import React from 'react';
import { StyleSheet, ScrollView, Text, View, ImageBackground, AsyncStorage, screenWidth, screenHeight, Image, TouchableOpacity } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';
import { link } from '../src/Constantes'

export default class Menu extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
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
    this.props.navigation.navigate('Perfil');
  }

  _getHistorial = () => {

    fetch(link.cursando.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('cursando', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(link.aprobadas.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('aprobadas', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(link.porCursar.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('porcursar', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(link.promedioGeneral.replace('{matricula}', this.state.matricula))

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

    return fetch(link.boleta.replace('{matricula}', this.state.matricula))
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

    return fetch(link.horario.replace('{matricula}', this.state.matricula))

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
    return fetch(link.tramites.replace('{matricula}', this.state.matricula))

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
    return fetch(link.historialFinanciero.replace('{matricula}', this.state.matricula))

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
            <View style={styles.lineStyle} />
          </View>

          <View>
            <Text style={styles.title}>Financiero</Text>
          </View>

          <View style={styles.container}>
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