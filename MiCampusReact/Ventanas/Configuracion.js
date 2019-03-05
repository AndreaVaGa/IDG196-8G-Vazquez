import React from 'react';
import { StyleSheet, TouchableOpacity, View, Text, Image, AsyncStorage } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';


export default class Configuracion extends React.Component {

  _LogOut = () => {
    AsyncStorage.removeItem('usuario')
    this.props.navigation.navigate('Login');
  }
  _IraFondo = () => {
    this.props.navigation.navigate('Fondo');
  }

  _IraTerminos = () => {
    this.props.navigation.navigate('Terminos');
  }

  render() {
    return (
      <View style={styles.container}>

        <View style={styles.textBox}>
          <Text style={styles.titles}>NOTIFICACIONES</Text>
        </View>

        <View style={styles.textBox}>
          <View style={styles.fila}>
            <View style={styles.columna}>
              <Text style={styles.titles}>FONDO</Text>
            </View>
            <View style={styles.columna2}>
              <TouchableOpacity onPress={(this._IraFondo)}>
                <Image source={require('../src/imgs/flecha.png')} style={styles.flechafondo} onPress={this._IraFondo} />
              </TouchableOpacity>
            </View>

          </View>
        </View>

        <View style={styles.textBox}>

          <View style={styles.fila}>
            <View style={styles.columna}>
              <Text style={styles.titles}>TERMINOS/PRIVACIDAD</Text>
            </View>
            <View style={styles.columna2}>
              <TouchableOpacity onPress={(this._IraTerminos)}>
                <Image source={require('../src/imgs/flecha.png')} style={styles.flecha} onPress={this._IraTerminos} />
              </TouchableOpacity>
            </View>
          </View>

        </View>
        <TouchableOpacity onPress={(this._LogOut)}>
          <Image source={require('../src/imgs/cerrar.png')} style={styles.sesion} onPress={(this._LogOut)} />
        </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    margin: 20,
  },

  textBox: {
    backgroundColor: '#F5F5F5',
    justifyContent: 'center',
    borderRadius: 20,
    marginTop: 20,
  },

  columna2: {
    justifyContent: 'center',
    flexDirection: 'row',
  },

  flecha: {
    height: hp('3%'),
    width: wp('2.5%'),
    marginLeft: 100,
    marginBottom: 10,
    marginTop: 10,
  },

  flechafondo: {
    height: hp('3%'),
    width: wp('2.5%'),
    marginLeft: 228,
    marginBottom: 10,
    marginTop: 10,
  },

  titles: {
    fontSize: 15,
    marginLeft: 20,
    marginBottom: 10,
    marginTop: 10,
  },

  fila: {
    flexDirection: 'row'
  },

  columna: {
    justifyContent: 'center',
  },

  sesion: {
    height: hp('10%'),
    width: wp('90%'),
    marginTop: 100,
  }

});
