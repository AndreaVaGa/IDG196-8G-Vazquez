import React from 'react';
import { StyleSheet, View, Image, Text, TouchableOpacity, TextInput, AsyncStorage, } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';
import { STATUS_CODES } from 'http';

export default class Login extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      usuario: '',
      password: '',
      apiRoot: "http://ec2co-ecsel-1o7jydferg75c-743462231.us-east-2.elb.amazonaws.com:8080/api/micampus/"
    };
  }
  componentDidMount() {
    this._loadInitionState().done();
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('usuario');
    if (value !== null) {
      this.props.navigation.navigate('Menu');
    }
  }

  _getAlumno = () => {
    var matriculatemp = this.state.usuario
    var matricula_numerica = matriculatemp.slice(matriculatemp.length * -1 + 1)

    return fetch(this.state.apiRoot + 'public/v1/alumnos/login', {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        matricula: this.state.usuario,
        password: this.state.password
      }),
    })
      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson.matricula == matricula_numerica) {
          AsyncStorage.setItem('usuario', JSON.stringify(responseJson))
          this.props.navigation.navigate('Menu');
        }

      })
      .catch((error) => {
        if (STATUS_CODES == 404) {
          alert('Usuario o contraseña incorrecta')
        }
        else if (STATUS_CODES == 500) {
          alert('Conexión fallida con el servidor')
        }
      });
  }

  render() {
    return (
      <View style={styles.container}>

        <Image style={styles.img} source={require('../src/imgs/flama.png')} />
        <TextInput placeholder="Usuario"
          style={styles.text} onChangeText={(usuario) => this.setState({ usuario })} />
        <TextInput placeholder="Contraseña" secureTextEntry={true}
          style={styles.text} onChangeText={(password) => this.setState({ password })} />
        <TouchableOpacity style={[styles.boton]} onPress={this._getAlumno}>
          <Text style={[styles.botonText]} onPress={this._getAlumno}>Ingresar</Text>
        </TouchableOpacity>

      </View>
    );
  }
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fdcc01',
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    fontSize: 20,
    padding: 10
  },
  img: {
    flex: .4,
    aspectRatio: 1,
    resizeMode: 'contain',
    marginBottom: 10
  },
  boton: {
    height: 42,
    width: wp('50%'),
    flexDirection: 'row',
    borderRadius: 20,
    shadowColor: 'grey',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.9,
    shadowRadius: 2,
    elevation: 4,
    backgroundColor: 'black',
    justifyContent: 'center',
    marginTop: 30,
  },
  botonText: {
    marginTop: 5,
    fontSize: 18,
    textAlign: 'center',
    color: 'white',
    fontWeight: 'bold',
  },
});
