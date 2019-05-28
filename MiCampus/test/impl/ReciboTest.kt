package mx.edu.cetys.garay.andrea.impl

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import mx.edu.cetys.garay.andrea.application.HistorialFin.GetHistorialQuery
import mx.edu.cetys.garay.andrea.application.HistorialFin.GetHistorialQueryResponse
import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.financiero.GetReciboQuery
import mx.edu.cetys.garay.andrea.application.financiero.GetReciboQueryResponse
import mx.edu.cetys.garay.andrea.application.financiero.SaveCompraCommand
import mx.edu.cetys.garay.andrea.application.financiero.SaveCompraCommandResponse
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.application.tramites.GetTramitesQueryResponse
import mx.edu.cetys.garay.andrea.dto.HistorialDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ReciboTest {

    private val getReciboQueryHandler = mockk<RequestHandler<GetReciboQuery, GetReciboQueryResponse>>()
    private val saveCompraCommandHandler = mockk<RequestHandler<SaveCompraCommand, SaveCompraCommandResponse>>()
    private val getHistorialQueryHandler = mockk<RequestHandler<GetHistorialQuery, GetHistorialQueryResponse>>()
    private val getTramitesQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetTramitesQueryResponse>>()

    val financieroApi = FinancieroApi(
        getReciboQueryHandler,
        saveCompraCommandHandler,
        getHistorialQueryHandler,
        getTramitesQueryHandler
    )

    private val matricula = (0..10).random().toString()

    private val id_compra = 7
    private val date = ""
    private val id_tramites = 1
    private val name = "Duplicado de credencial"
    private val price = 165
    private val getReciboQueryResponse = ArrayList<HistorialDTO>()

    private val recibo = HistorialDTO(
        id_compra,
        date,
        id_tramites,
        name,
        price
    )

    @Before
    fun setup() {
        getReciboQueryResponse.add(recibo)
        every { getReciboQueryHandler.handle(any()) } returns GetReciboQueryResponse(getReciboQueryResponse)
    }

    @Test
    fun `calls recibo query handler`() {
        financieroApi.getRecibo(FinancieroApi.GetReciboRequest(matricula,id_compra))

        verify { getReciboQueryHandler.handle(any()) }
    }

    @Test
    fun `returns recibo correctly when request is correct`() {
        val request = GetReciboQuery(matricula, id_compra)
        val expected = FinancieroApi.GetReciboResponse(getReciboQueryResponse)

        every {
            getReciboQueryHandler.handle(request)
        } returns (GetReciboQueryResponse(getReciboQueryResponse))

        val actual = financieroApi.getRecibo(FinancieroApi.GetReciboRequest(matricula,id_compra))
        Assert.assertEquals(expected, actual)

        verify { getReciboQueryHandler.handle(request) }
    }
}