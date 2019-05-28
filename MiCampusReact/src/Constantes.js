export var matricula = '';
export const apiRoot = "http://0.0.0.0:8080/api/micampus/public/v1";

export const link = {
    login: apiRoot + '/alumnos/login',
    perfil: this.state.matricula + '/perfil',
    boleta: apiRoot + '/alumnos/' + matricula + '/boleta',
    horario: apiRoot + '/alumnos/' + matricula + '/horario',
    tramites: apiRoot + '/alumnos/' + matricula + '/tramites',
    tutores: apiRoot + '/alumnos/' + matricula + '/tutores',
    historialFinanciero: apiRoot + '/alumnos/' + matricula + '/historial/financiero',
    cursando: apiRoot + '/alumnos/' + matricula + '/historial/academico/materias/cursando',
    aprobadas: apiRoot + '/alumnos/' + matricula + '/historial/academico/materias/aprobadas',
    porCursar: apiRoot + '/alumnos/' + matricula + '/historial/academico/materias/porCursar',
    promedioGeneral: apiRoot + '/alumnos/' + this.state.matricula + '/historial/academico/promedioGeneral'
}

