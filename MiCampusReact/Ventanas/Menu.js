import React from 'react';
import { StyleSheet, ScrollView, Text, View, ImageBackground, AsyncStorage, screenWidth, screenHeight, Image, TouchableOpacity, ActivityIndicator } from 'react-native';
import { heightPercentageToDP as hp } from 'react-native-responsive-screen';

export default class Menu extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true
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
    this.props.navigation.navigate('Historial');
  }

  _getBoleta = () => {
    this.props.navigation.navigate('Boleta');
  }

  _getHorario = () => {
    this.props.navigation.navigate('Horario');
  }
  _getTramites = () => {
    this.props.navigation.navigate('Tramites');
  }

  _getHistorialFinanciero = () => {
    this.props.navigation.navigate('HistorialFinanciero');
  }

  render() {
    {
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
}

const styles = StyleSheet.create({
  cargar: {
    flex: 1,
    alignContent: 'center',
    justifyContent: 'center',
  },
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