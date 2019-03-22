import React from 'react';
import { StyleSheet, View, Image, TouchableOpacity, TextInput, AsyncStorage, } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

export default class Login extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      usuario: '',
      password: '', 
      host: 'http://10.12.20.188:8080', 
      apiRoot: "/api/micampus"
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

    return fetch(this.state.host + '/mc/alumno')

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('usuario', JSON.stringify(responseJson))
          this.props.navigation.navigate('Menu');
        }

      })
      .catch((error) => {
        alert('Usuario o contraseña incorrecta')
      });
  }

  render() {
    return (
      <View style={styles.container}>

        <Image style={{ flex: .4, aspectRatio: 1, resizeMode: 'contain', marginBottom: 10 }} source={require('../src/imgs/flama.png')} />
        <TextInput placeholder="Usuario"
          style={styles.text} onChangeText={(usuario) => this.setState({ usuario })} />
        <TextInput placeholder="Contraseña" secureTextEntry={true}
          style={styles.text} onChangeText={(password) => this.setState({ password })} />
        <View>
          <TouchableOpacity onPress={(this._getAlumno)}>
            <Image source={require('../src/imgs/ingresar.png')} style={styles.button} onPress={this._getAlumno} />
          </TouchableOpacity>
        </View>
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
    width: '30%',
    height: '30%',
    marginBottom: 50,
    justifyContent: 'center',
  },
  button: {
    height: hp('9%'),
    width: wp('60%'),
    marginTop: 25,

  }


});
