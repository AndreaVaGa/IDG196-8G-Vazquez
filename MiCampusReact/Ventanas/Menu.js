import React from 'react';
import { StyleSheet, ScrollView, Text, View, ImageBackground, AsyncStorage, screenWidth, screenHeight, Image, TouchableOpacity } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

export default class Menu extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      matricula: '',
      apiRoot: "http://ec2co-ecsel-1o7jydferg75c-743462231.us-east-2.elb.amazonaws.com:8080/api/micampus/"
    };

  }
  componentDidMount() {
    this._loadInitionState().done();
    
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('usuario');
    if (value !== null) {
      var alumno = JSON.parse(value)
      this.setState({ matricula: alumno.matricula })
    }
  }
  _IraPerfil = () => {
    return fetch(this.state.apiRoot + '/public/v1/alumnos/' + this.state.matricula + '/Perfil')
      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('perfil', JSON.stringify(responseJson))
          this.props.navigation.navigate('Perfil');

        }
      })
      .catch((error) => {
        console.error(error);
      });
  }

  _getHistorial = () => {

    fetch(this.state.apiRoot + '/public/v1/alumnos/' + this.state.matricula + '/Cursando')

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('cursando', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(this.state.apiRoot + '/public/v1/alumnos/' + this.state.matricula + '/Aprobadas')

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('aprobadas', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(this.state.apiRoot + '/public/v1/alumnos/' + this.state.matricula + '/PorCursar')

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('porcursar', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(this.state.apiRoot + '/public/v1/alumnos/' + this.state.matricula + '/PromedioGeneral')

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('PromedioGeneral', JSON.stringify(responseJson))
        }
        this.props.navigation.navigate('Historial');
      })
      .catch((error) => {
        console.error(error);
      });
  }


  _getBoleta = () => {

    return fetch(this.state.apiRoot + '/public/v1/alumnos/' + this.state.matricula + '/Boleta')
      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('boleta', JSON.stringify(responseJson))
          this.props.navigation.navigate('Boleta');
        }
      })
      .catch((error) => {
        console.error(error);
      });
  }

  _getHorario = () => {

    return fetch(this.state.apiRoot + '/public/v1/alumnos/' + this.state.matricula + '/Horario')

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('horario', JSON.stringify(responseJson))
          this.props.navigation.navigate('Horario');
        }
      })
      .catch((error) => {
        console.error(error);
      });
  }
  _getTramites = () => {
    return fetch( 'http://0.0.0.0:8080/api/micampus/public/v1/alumnos/tramites')

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('tramites', JSON.stringify(responseJson))
          this.props.navigation.navigate('Tramites');
        }
      })
      .catch((error) => {
        console.error(error);
      });

          
  }

  _getHistorialFinanciero = () => {
    return fetch( 'http://0.0.0.0:8080/api/micampus/public/v1/alumnos/T021204/historial/financiero')

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('historialF', JSON.stringify(responseJson))
          this.props.navigation.navigate('HistorialFinanciero');
        }
      })
      .catch((error) => {
        console.error(error);
      });

    
}

_getAdeudos = () => {

  this.props.navigation.navigate('Adeudos');
}

  render() {
    return (
      <ImageBackground style={styles.perfilContainer} source={require('../src/imgs/background.jpg')}>
        <ScrollView>
          <View style={styles.perfilContainer}>
            <View style={{ flexDirection: 'row', justifyContent: 'flex-end', alignItems: 'flex-start', paddingRight: 10 }}>
              <TouchableOpacity style={styles.Boton2} onPress={(this._IraPerfil)}>
                <Image style={{ flex: 1, aspectRatio: .2, resizeMode: 'contain' }} source={require("../src/imgs/perfil.png")}></Image>
              </TouchableOpacity>
            </View>

            <View>
            <Text style={styles.title}>Académico</Text>
            </View>

            <View style={styles.container}>
              <TouchableOpacity style={styles.Boton} onPress={(this._getBoleta)} title='Boleta'>
                <Image source={require("../src/imgs/boleta.png")}></Image>
                <Text style={styles.texto}>Boleta</Text>
              </TouchableOpacity>
              <TouchableOpacity style={styles.Boton} onPress={(this._getHistorial)} title='Historial'>
                <Image source={require("../src/imgs/historial.png")}></Image>
                <Text style={styles.texto}>Historial</Text>
              </TouchableOpacity>
              <TouchableOpacity style={styles.Boton} onPress={(this._getHorario)} title='Horario'>
                <Image source={require("../src/imgs/horario.png")}></Image>
                <Text style={styles.texto}>Horario</Text>
              </TouchableOpacity>
            </View>
            <View style={styles.lineStyle}/>
          </View>

          <View>
          <Text style={styles.title}>Financiero</Text>
          </View>

          <View style={styles.container}>
            <TouchableOpacity style={styles.Boton} onPress={(this._getAdeudos)} title='Adeudos'>
              <Image source={require("../src/imgs/adeudos.png")}></Image>
              <Text style={styles.texto}>Adeudos</Text>
            </TouchableOpacity>
            <TouchableOpacity style={styles.Boton} onPress={(this._getHistorialFinanciero)} title='HistorialFinanciero'>
              <Image source={require("../src/imgs/hfinanciero.png")}></Image>
              <Text style={styles.texto}>Historial</Text>
            </TouchableOpacity>
            <TouchableOpacity style={styles.Boton} onPress={(this._getTramites)} title='Tramites'>
              <Image source={require("../src/imgs/tramites.png")}></Image>
              <Text style={styles.texto}>Trámites</Text>
            </TouchableOpacity>
          </View>
        </ScrollView>
      </ImageBackground>
    );
  }
}

const styles = StyleSheet.create({
  perfilContainer: {
    flex: 1,
  },
  container: {
    flex: 3,
    flexDirection: 'row',
    justifyContent: 'flex-start',
    margin: 5,
  },
  title: {
    fontSize: 25,
    fontWeight: 'bold',
    textAlign: 'left',
    color: 'white',
    marginLeft: 15,
    marginTop: 5,
    marginBottom: 5,
  },
  texto: {
    fontSize: 15,
    textAlign: 'left',
    color: 'white',
    marginLeft: 8.5,
    marginTop: 7,
    marginBottom: 5,
  },
  lineStyle: {
    borderWidth: .9,
    width: screenWidth,
    marginLeft: 20,
    marginRight: 20,
    marginBottom: 25,
    borderColor: '#ffd700',
  },
  backgroundImage: {
    width: screenWidth,
    height: screenHeight,
    justifyContent: 'flex-end',
  },
  Boton: {
    height: hp('18%'),
    borderRadius: 20,
    padding: 10,
    marginBottom: 10,
  },
  Boton2: {
    height: 100,
    borderRadius: 20,
    padding: 10,
    alignContent: 'flex-end',
  },
});