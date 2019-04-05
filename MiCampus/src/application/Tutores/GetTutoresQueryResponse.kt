package mx.edu.cetys.garay.andrea.application.Tutores


data class GetTutoresQueryResponse(
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