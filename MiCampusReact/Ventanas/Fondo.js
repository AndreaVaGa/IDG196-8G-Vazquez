import React from 'react';
import {
  StyleSheet,
  ScrollView,
  View,
  Text,
  TouchableOpacity,
  Image
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';
global.url = require("../src/imgs/portada/a.jpg");
export default class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      url: require("../src/imgs/portada/a.jpg"),
    };
  }
  _IraPerfil = () => {
    this.props.navigation.navigate('Perfil');
  }

  render() {
    return (
      <View>
        <ScrollView>
          <View style={styles.container}>
            <View style={styles.fila}>
              <View style={styles.columna}>
                <Image source={require("../src/imgs/portada/a.jpg")} style={styles.imagenPortada} />
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/b.jpg") }}>
                  <Image source={require("../src/imgs/portada/b.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/c.jpg") }}>
                  <Image source={require("../src/imgs/portada/c.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/d.jpg") }}>
                  <Image source={require("../src/imgs/portada/d.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/e.jpg") }}>
                  <Image source={require("../src/imgs/portada/e.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/f.jpg") }}>
                  <Image source={require("../src/imgs/portada/f.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/g.jpg") }}>
                  <Image source={require("../src/imgs/portada/g.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/h.jpg") }}>
                  <Image source={require("../src/imgs/portada/h.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
              </View>
              <View style={styles.columna}>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/i.jpg") }}>
                  <Image source={require("../src/imgs/portada/i.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/j.jpg") }}>
                  <Image source={require("../src/imgs/portada/j.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/k.jpg") }}>
                  <Image source={require("../src/imgs/portada/k.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/l.jpg") }}>
                  <Image source={require("../src/imgs/portada/l.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/m.jpg") }}>
                  <Image source={require("../src/imgs/portada/m.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/n.jpg") }}>
                  <Image source={require("../src/imgs/portada/n.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/o.jpg") }}>
                  <Image source={require("../src/imgs/portada/o.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
                <TouchableOpacity onPress={() => { global.url = require("../src/imgs/portada/p.jpg") }}>
                  <Image source={require("../src/imgs/portada/p.jpg")} style={styles.imagenPortada} />
                </TouchableOpacity>
              </View>
            </View>
          </View>
        </ScrollView>
        <View style={styles.cuadro}>
        <TouchableOpacity style={[styles.boton]} onPress={this._IraPerfil}>
            <Text style={[styles.botonText]}>Cambiar fondo</Text>
        </TouchableOpacity>
        </View>
      </View>
    );
  }
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginTop: 20,
    alignItems: 'center'
  },
  imagenPortada: {
    height: hp('25%'),
    width: wp('45%'),
    margin: 5,
    borderWidth: 2,
    borderColor: 'black',
  },
  fila: {
    flexDirection: 'row',
  },
  columna: {
    alignItems: 'center',
    marginBottom: 100,
  },
  cuadro: {
    backgroundColor: '#191919',
    bottom: 0,
    position: 'absolute',
    padding: 7,
    width: '100%',
    alignItems: "center",
  },
  boton: {
    height: 40,
    width: wp('61%'),
    flexDirection: 'row',
    borderRadius: 20,
    shadowColor: 'grey',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.9,
    shadowRadius: 2,
    elevation: 4,
    backgroundColor: '#ffd700',
    justifyContent: 'center',
    marginTop: 10,
    marginBottom: 10,
},
botonText: {
    marginTop: 5,
    fontSize: 20,
    textAlign: 'center',
    color: '#333333',
},
});