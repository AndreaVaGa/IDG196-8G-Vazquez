package mx.edu.cetys.garay.andrea.impl

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import mx.edu.cetys.garay.andrea.application.HistorialFin.GetHistorialQuery
import mx.edu.cetys.garay.andrea.application.HistorialFin.GetHistorialQueryResponse
import mx.edu.cetys.garay.andrea.application.RequestHandler
import mx.edu.cetys.garay.andrea.application.financiero.*
import mx.edu.cetys.garay.andrea.application.perfiles.GetPerfilQuery
import mx.edu.cetys.garay.andrea.application.tramites.GetTramitesQueryResponse
import mx.edu.cetys.garay.andrea.dto.HistorialDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HistorialFinancieroTest {
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
    private val getHistorialQueryResponse = ArrayList<HistorialDTO>()

    private val historial = HistorialDTO(
        id_compra,
        date,
        id_tramites,
        name,
        price
    )

    @Before
    fun setup() {
        getHistorialQueryResponse.add(historial)
        every { getHistorialQueryHandler.handle(any()) } returns GetHistorialQueryResponse(getHistorialQueryResponse)
    }

    @Test
    fun `calls historial query handler`() {
        financieroApi.getHistorial(matricula)

        verify { getHistorialQueryHandler.handle(any()) }
    }

    @Test
    fun `returns historial correctly when request is correct`() {
        val request = GetHistorialQuery(matricula)
        val expected = FinancieroApi.GetHistorialResponse(getHistorialQueryResponse)

        every {
            getHistorialQueryHandler.handle(request)
        } returns (GetHistorialQueryResponse(getHistorialQueryResponse))

        val actual = financieroApi.getHistorial(matricula)
        Assert.assertEquals(expected, actual)

        verify { getHistorialQueryHandler.handle(request) }
    }
}