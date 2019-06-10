import React from 'react';
import { StyleSheet, View, Text, ScrollView, screenWidth } from 'react-native';

export default class Terminos extends React.Component {
  render() {
    return (
      <ScrollView style={styles.container}>
        <Text style={styles.titles}>Terminos: </Text>
        <View style={styles.lineStyle} />
        <Text style={styles.texto}>
          Cetys app procurará garantizar disponibilidad, continuidad o buen funcionamiento de la aplicación. Cetys app podrá bloquear, interrumpir o restringir el acceso a esta cuando lo considere necesario para el mejoramiento de la aplicación o por dada de baja de la misma.
        </Text>
        <Text style={styles.texto}>
          Se recomienda al Usuario tomar medidas adecuadas y actuar diligentemente al momento de acceder a la aplicación, como por ejemplo, contar con programas de protección, antivirus, para manejo de malware, spyware y herramientas similares.
        </Text>
        <Text style={styles.texto}>
          Cetys app no será responsable por: 
        </Text>
        <Text style={styles.lista}>
          a. Fuerza mayor o caso fortuito.
        </Text>
            <Text style={styles.lista}>
              b. Por la pérdida, extravío o hurto de su dispositivo móvil que implique el acceso de terceros a la aplicación móvil.
            </Text>
            <Text style={styles.lista}>
              c. Por errores en la digitación o accesos por parte del cliente.
            </Text>
            <Text style={styles.lista}>
              d. Por los perjuicios, lucro cesante, daño emergente, morales, y en general sumas a cargo de cetys app, por los retrasos, no procesamiento de información o suspensión del servicio del operador móvil o daños en los dispositivos móviles.
            </Text>

        <Text style={styles.titles}>Privacidad: </Text>
        <View style={styles.lineStyle} />
        <Text style={styles.texto}>
          Con la descarga de la APP usted acepta y autoriza que Cetys app, utilice sus datos en calidad de responsable del tratamiento para fines derivados de la ejecución de la APP. 
          Cetys app informa que podrá ejercer sus derechos a conocer, actualizar, rectificar y suprimir su información personal; así como el derecho a revocar el consentimiento otorgado 
          para el tratamiento de datos personales previstos en la ley 1581 de 2012, siendo voluntario responder preguntas sobre información sensible o de menores de edad. 
        </Text>
        <Text style={styles.texto}>
          Cetys app podrá dar a conocer, transferir y/o trasmitir sus datos personales dentro del país a cualquier campus de Cetys Universidad, así como a terceros a consecuencia de un contrato, 
          ley o vínculo lícito que así lo requiera, para todo lo anterior otorgo mi autorización expresa e inequívoca. De conformidad a lo anterior autoriza el tratamiento de su información 
          en los términos señalados, y transfiere a Cetys app de manera total, y sin limitación mis derechos de imagen y patrimoniales de autor, de manera voluntaria, previa, explicita, 
          informada e inequívoca.
        </Text>
        <Text style={styles.extra}>
          El Usuario acepta expresamente los Términos y Privacidad, siendo condición esencial para la utilización de la aplicación. En el evento en que se encuentre en desacuerdo con estos Términos y privacidad, solicitamos abandonar la aplicación inmediatamente. 
          Cetys app podrá modificar los presentes términos y privacidad, avisando a los usuarios de la aplicación mediante la difusión de las modificación por algún medio electrónico, redes sociales o correo electrónico, lo cual se entenderá aceptado por el 
          usuario si éste continua con el uso de la aplicación. 
        </Text>
      </ScrollView>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: 'white',
  },
  titles: {
    justifyContent: 'center',
    marginTop: 25,
    marginLeft: 30,
    marginRight: 30,
    fontSize: 23
  },
  texto: {
    justifyContent: 'center',
    fontSize: 13,
    marginLeft: 30,
    marginRight: 30,
    marginBottom: 10,
  },
  lista: {
    justifyContent: 'center',
    fontSize: 13,
    marginLeft: 40,
    marginRight: 30,
  },
  extra: {
    justifyContent: 'center',
    fontSize: 10,
    marginLeft: 30,
    marginRight: 30,
    marginBottom: 10,
    marginTop: 20, 
    fontWeight: 'bold',
  },
  lineStyle: {
    borderWidth: 1,
    width: screenWidth,
    borderColor: '#ffd700',
    marginTop: 15,
    marginBottom: 10,
    marginLeft: 30,
    marginRight: 30,
  },
});

