package mx.edu.cetys.garay.andrea.impl

import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQuery
import mx.edu.cetys.garay.andrea.application.Tutores.GetTutoresQueryHandler

class TutoresApi {
    private val getTutoresQueryHandler = GetTutoresQueryHandler()

    fun getTutores(matricula: String): GetTutoresResponse{
        val response = getTutoresQueryHandler.handle(GetTutoresQuery(matricula))
        return GetTutoresResponse(
            response.nombre_1_padre,
            response.nombre_2_padre,
            response.apellido_paterno_padre,
            response.apellido_materno_padre,
            response.direccion_padre,
            response.colonia_padre,
            response.telefono_padre,
            response.email_padre,
            response.telefono_celular_pad,
            response.empresa_padre,
            response.emp_dir_padre,
            response.emp_col_padre,
            response.emp_tel_padre,
            response.nombre_1_madre,
            response.nombre_2_madre,
            response.apellido_paterno_madre,
            response.apellido_materno_madre,
            response.direccion_madre,
            response.colonia_madre,
            response.telefono_madre,
            response.email_madre,
            response.telefono_celular_madre,
            response.empresa_madre,
            response.emp_dir_madre,
            response.emp_col_madre,
            response.emp_tel_madre
        )
    }

    data class GetTutoresResponse(
        val nombre_1_padre: String,
        val nombre_2_padre: String,
        val apellido_paterno_padre: String,
        val apellido_materno_padre: String,
        val direccion_padre: String,
        val colonia_padre: String,
        val telefono_padre: String,
        val email_padre: String,
        val telefono_celular_pad: String,
        val empresa_padre: String,
        val emp_dir_padre: String,
        val emp_col_padre: String,
        val emp_tel_padre: String,
        val nombre_1_madre: String,
        val nombre_2_madre: String,
        val apellido_paterno_madre: String,
        val apellido_materno_madre: String,
        val direccion_madre: String,
        val colonia_madre: String,
        val telefono_madre: String,
        val email_madre: String,
        val telefono_celular_madre: String,
        val empresa_madre: String,
        val emp_dir_madre: String,
        val emp_col_madre: String,
        val emp_tel_madre: String
    )
}