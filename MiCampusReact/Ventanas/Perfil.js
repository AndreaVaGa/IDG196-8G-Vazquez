import React from 'react';
import {
  StyleSheet,
  Text,
  AsyncStorage,
  View,
  Image,
  ImageBackground,
  screenWidth,
  TouchableOpacity
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

export default class Perfil extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      nombre: '',
      apellido: '',
      carrera: '',
      semestre: '',
      aprobadas: '',
      matricula: '', 
      portada: '', 
      apiRoot: "http://10.12.20.188:8080/api/micampus"
    };
      
  }

  _IraTutores = () => {
    return fetch(this.state.apiRoot +'/public/v1/alumnos/'+ this.state.matricula +'/Tutores')
      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('tutores', JSON.stringify(responseJson))
          this.props.navigation.navigate('Tutores');
        }
      })
      .catch((error) => {
        console.error(error);
      });
  }

  _IraConfiguracion = () => {
    this.props.navigation.navigate('Configuracion');
  }

  componentDidMount() {
    this._loadInitionState().done();
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('perfil');
    if (value !== null) {
      var alumno = JSON.parse(value)
      this.setState({ nombre: alumno.nombre_1 + ' ' +alumno.nombre_2 })
      this.setState({ matricula: alumno.matricula })
      this.setState({ apellido: alumno.apellido_paterno + ' ' + alumno.apellido_materno })
      this.setState({ carrera: alumno.nombre_programa })
      this.setState({ aprobadas: alumno.materias_aprobadas })
      this.setState({portada: alumno.foto_portada.slice(0,1)})
      

    }
  }
  
  render() {
    var x = this.state.portada.toString()
    var load_image = x == 'a' ? require("../src/imgs/portada/a.jpg") : 
      this.state.portada == 'b' ? require("../src/imgs/portada/b.jpg") : 
      this.state.portada == 'c' ? require("../src/imgs/portada/c.jpg") : 
      this.state.portada == 'd' ? require("../src/imgs/portada/d.jpg") : 
      this.state.portada == 'e' ? require("../src/imgs/portada/e.jpg") :
      this.state.portada == 'f' ? require("../src/imgs/portada/f.jpg") : 
      this.state.portada == 'g' ? require("../src/imgs/portada/g.jpg") :
      this.state.portada == 'h' ? require("../src/imgs/portada/h.jpg") : 
      this.state.portada == 'i' ? require("../src/imgs/portada/i.jpg") :
      this.state.portada == 'j' ? require("../src/imgs/portada/j.jpg") : 
      this.state.portada == 'k' ? require("../src/imgs/portada/k.jpg") :
      this.state.portada == 'l' ? require("../src/imgs/portada/l.jpg") : 
      this.state.portada == 'm' ? require("../src/imgs/portada/m.jpg") :
      this.state.portada == 'n' ? require("../src/imgs/portada/n.jpg") : 
      this.state.portada == 'o' ? require("../src/imgs/portada/o.jpg") :
      this.state.portada == 'p' ? require("../src/imgs/portada/p.jpg") : 
      require("../src/imgs/portada/o.jpg") ;
    return (
      <View>
        <ImageBackground source={load_image} style={styles.portada}>
          <TouchableOpacity onPress={(this._IraConfiguracion)}>
            <Image source={require("../src/imgs/configuracion.png")} style={styles.confi} onPress={(this._IraConfiguracion)}></Image>
          </TouchableOpacity>
          <Image source={{ uri: 'https://micampus.tij.cetys.mx/fotos/' + this.state.matricula + '.jpg' }} style={styles.fpersona} />
        </ImageBackground>
        <View>
          <Text style={styles.title2}>{this.state.nombre}</Text>
          <Text style={styles.title2}>{this.state.apellido}</Text>
          <Text style={styles.texto}>Carrera: {this.state.carrera} </Text>
          <Text style={styles.texto}>Materias aprobadas: {this.state.aprobadas}</Text>
          <Text style={styles.info} onPress={this._IraTutores}>Más información ></Text>
        </View>
      </View>


    );
  }
}

const styles = StyleSheet.create({
  title: {
    fontSize: 18,
    fontWeight: 'bold',
    marginTop: 20,
    textAlign: 'center'
  },
  title2: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 25,
    textAlign: 'center'
  },
  fpersona: {
    width: 130,
    height: 130,
    borderWidth: 5,
    borderColor: '#ffffff',
    borderRadius: 65,
  },
  portada: {
    width: screenWidth,
    height: 200,
    alignItems: 'center',
    justifyContent: 'flex-end',
  },
  texto: {
    justifyContent: 'center',
    marginLeft: 50,
    fontSize: 14,
  },
  info: {
    justifyContent: 'center',
    fontWeight: 'bold',
    color: '#4169E1',
    marginLeft: 50,
    marginTop: 50,
    fontSize: 12,
  },
  confi: {
    height: hp('5%'),
    width: wp('9%'),
    marginBottom: 25,
    marginLeft: 300,
  }
});