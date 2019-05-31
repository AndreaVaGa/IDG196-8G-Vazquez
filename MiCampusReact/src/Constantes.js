export const apiRoot = "http://ec2co-ecsel-1o7jydferg75c-743462231.us-east-2.elb.amazonaws.com:8080/api/micampus/public/v1";

export const link = {
    login: apiRoot + '/alumnos/login',
    perfil: apiRoot + '/alumnos/{matricula}/perfil',
    boleta: apiRoot + '/alumnos/{matricula}/boleta',
    horario: apiRoot + '/alumnos/{matricula}/horario',
    tramites: apiRoot + '/alumnos/tramites',
    tutores: apiRoot + '/alumnos/{matricula}/tutores',
    tutores: apiRoot + '/alumnos/{matricula}/tutores',
    historialFinanciero: apiRoot + '/alumnos/{matricula}/historial/financiero',
    cursando: apiRoot + '/alumnos/{matricula}/historial/academico/materias/cursando',
    aprobadas: apiRoot + '/alumnos/{matricula}/historial/academico/materias/aprobadas',
    porCursar: apiRoot + '/alumnos/{matricula}/historial/academico/materias/porCursar',
    promedioGeneral: apiRoot + '/alumnos/{matricula}/historial/academico/promedioGeneral',
    recibo: apiRoot + '/alumnos/{matricula}/historial/financiero/recibo/{id}'
}

