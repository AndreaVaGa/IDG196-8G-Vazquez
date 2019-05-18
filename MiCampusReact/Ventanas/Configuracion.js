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
          <View style={styles.fila}>
            <View style={styles.columna}>
              <Text style={styles.titles}>Fondo</Text>
            </View>
            <View style={styles.columnaF}>
              <TouchableOpacity onPress={(this._IraFondo)}>
                <Image source={require('../src/imgs/flecha.png')} style={styles.flechafondo} onPress={this._IraFondo} />
              </TouchableOpacity>
            </View>
          </View>
        </View>

        <View style={styles.textBox}>

          <View style={styles.fila}>
            <View style={styles.columna}>
              <Text style={styles.titles}>Terminos/Privacidad</Text>
            </View>
            <View style={styles.columnaF}>
            <TouchableOpacity onPress={(this._IraTerminos)}>
                <Image source={require('../src/imgs/flecha.png')} style={styles.flecha} onPress={this._IraTerminos} />
            </TouchableOpacity>
            </View>
        </View>

        <View style={styles.textBox}>
          <View style={styles.fila}>
            <View style={styles.columna}>
              <Text style={styles.titles}>Tutorial</Text>
            </View>
            <View style={styles.columnaF}>
              <TouchableOpacity onPress={(this._IraFondo)}>
                <Image source={require('../src/imgs/flecha.png')} style={styles.flechafondo} onPress={this._IraFondo} />
              </TouchableOpacity>
            </View>
          </View>
        </View>

        </View>
        <TouchableOpacity style={[styles.boton]} onPress={(this._LogOut)}>
            <Text style={[styles.botonText]}>Cerrar sesión</Text>
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
  fila: {
    flexDirection: 'row'
  },
  columna: {
    justifyContent: 'center',
    height: 40,
    width: wp('80%'),
  },
  columnaF: {
    justifyContent: 'center',
    height: 40,
    width: wp('20%'),
  },
  textBox: {
    backgroundColor: '#F5F5F5',
    justifyContent: 'center',
    borderRadius: 20,
    marginTop: 20,
  },
  flecha: {
    height: hp('3%'),
    width: wp('2.5%'),
    marginTop: 10,
    marginBottom: 10,
  },
  flechafondo: {
    height: hp('3%'),
    width: wp('2.5%'),
    marginTop: 10,
    marginBottom: 10,
  },
  titles: {
    fontSize: 16,
    marginLeft: 20,
    marginBottom: 10,
    marginTop: 10,
  },
  boton: {
    height: 40,
    width: wp('81%'),
    flexDirection: 'row',
    borderRadius: 20,
    shadowColor: 'grey',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.9,
    shadowRadius: 2,
    elevation: 4,
    backgroundColor: 'red',
    marginTop: 110,
    marginLeft: 10,
    justifyContent: 'center',
},
botonText: {
    marginTop: 7,
    fontSize: 16,
    color: 'white',
    textAlign: 'center',
    fontWeight: 'bold',
},


});
