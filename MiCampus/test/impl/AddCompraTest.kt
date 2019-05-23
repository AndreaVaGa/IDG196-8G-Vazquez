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
import mx.edu.cetys.garay.andrea.dto.ReciboDTO
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AddCompraTest {
    private val getReciboQueryHandler = mockk<RequestHandler<GetReciboQuery, GetReciboQueryResponse>>()
    private val saveCompraCommandHandler = mockk<RequestHandler<SaveCompraCommand, SaveCompraCommandResponse>>()
    private val getHistorialQueryHandler = mockk<RequestHandler<GetHistorialQuery, GetHistorialQueryResponse>>()
    private val getTramitesQueryHandler = mockk<RequestHandler<GetPerfilQuery, GetTramitesQueryResponse>>()
    private val api = FinancieroApi(
        getReciboQueryHandler,
        saveCompraCommandHandler,
        getHistorialQueryHandler,
        getTramitesQueryHandler
    )

    private val matricula = (0..10).random().toString()
    private val tramites = "1,4,"
    private val id_compra = 5
    private val date = "2019-05-10"
    private val id_tramite = 1
    private val tramite = "Duplicado de Credencial"
    private val precio = 165
    private val total = 165
    private val SaveCompraResponse = ArrayList<ReciboDTO>()
    private val recibo = ReciboDTO(id_compra, matricula, date, id_tramite, tramite, precio, total)

    @Before
    fun setup() {
        SaveCompraResponse.add(recibo)
        every { saveCompraCommandHandler.handle(any()) } returns SaveCompraCommandResponse(SaveCompraResponse)

    }
    @Test
    fun `calls save compra query handler`(){
        api.addCompra(FinancieroApi.AddCompraRequest(matricula, tramites))

        verify { saveCompraCommandHandler.handle(any()) }
    }
    @Test
    fun `returns recibo correctly when request is correct`(){
        val request = SaveCompraCommand(matricula,tramites)
        val expected = FinancieroApi.SaveCompraResponse(SaveCompraResponse)

        every {
            saveCompraCommandHandler.handle(request)
        } returns (SaveCompraCommandResponse(SaveCompraResponse))

        val actual = api.addCompra(FinancieroApi.AddCompraRequest(matricula,tramites))
        Assert.assertEquals(expected, actual)

        verify { saveCompraCommandHandler.handle(request) }

    }
}