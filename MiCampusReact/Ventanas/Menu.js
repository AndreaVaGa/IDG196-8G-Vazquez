import React from 'react';
import { StyleSheet, ScrollView, Text, View, ImageBackground, AsyncStorage, screenWidth, screenHeight, Image, TouchableOpacity } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

export default class Menu extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      matricula: '',
      host:'http://10.12.20.188:8080',
      apiRoot: "/api/micampus"
    };

  }
  
  componentDidMount() {
    this._loadInitionState().done();
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('usuario');
    if (value !== null) {
      var alumno = JSON.parse(value)
      this.setState({ matricula: alumno.Matricula })
    }
  }
  _IraPerfil = () => {

    return fetch(this.state.apiRoot +'/public/v1/alumnos/buscarPerfil?matricula='+ this.state.matricula)
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
  _IraHorario = () => {
    this.props.navigation.navigate('Horario');
  }
  _getHistorial = () => {

    fetch(this.state.apiRoot +'/public/v1/alumnos/buscarCursando?matricula='+ this.state.matricula)

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('cursando', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(this.state.apiRoot +'/public/v1/alumnos/buscarAprobadas?matricula='+ this.state.matricula)

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('aprobadas', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(this.state.apiRoot +'/public/v1/alumnos/buscarPorCursar?matricula='+ this.state.matricula)

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('porcursar', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(this.state.host +'/mc/promedioG')

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

    return fetch(this.state.apiRoot +'/public/v1/alumnos/buscarBoleta?matricula='+ this.state.matricula)
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

    return fetch(this.state.apiRoot +'/public/v1/alumnos/buscarHorario?matricula='+ this.state.matricula)

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
            <Text style={styles.title}>Académico</Text>

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
            <View style={styles.lineStyle} />
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
    marginBottom: 25,
  },
  Boton2: {
    height: 100,
    borderRadius: 20,
    padding: 10,
    alignContent: 'flex-end',
  },
});