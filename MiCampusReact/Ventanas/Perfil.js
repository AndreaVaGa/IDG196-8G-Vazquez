import React from 'react';
import { StyleSheet, Text, AsyncStorage, View, Image, ImageBackground, screenWidth, TouchableOpacity, ActivityIndicator } from 'react-native';
import { link } from '../src/Constantes'

export default class Perfil extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true,
      nombre: '',
      apellido: '',
      carrera: '',
      semestre: '',
      aprobadas: '',
      portada: ''
    };

  }

  _IraTutores = () => {
    this.props.navigation.navigate('Tutores');
  }

  _IraConfiguracion = () => {
    this.props.navigation.navigate('Configuracion');
  }

  componentDidMount() {
    this._loadInitionState();
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('usuario');
    if (value !== null) {
      var alumno = JSON.parse(value)
      this.setState({ matricula: alumno.matricula })
      return fetch(link.perfil.replace('{matricula}', this.state.matricula))
        .then((response) => response.json())
        .then((responseJson) => {
          if (responseJson !== undefined) {
            var response = JSON.stringify(responseJson)
            var alumno = JSON.parse(response)
            this.setState({ nombre: alumno.perfil.nombre_1 + ' ' + alumno.perfil.nombre_2 })
            this.setState({ matricula: alumno.perfil.matricula })
            this.setState({ apellido: alumno.perfil.apellido_paterno + ' ' + alumno.perfil.apellido_materno })
            this.setState({ carrera: alumno.perfil.nombre_programa })
            this.setState({ aprobadas: alumno.perfil.materias_aprobadas })
            this.setState({ portada: alumno.perfil.foto_portada.slice(0, 1) })
            setTimeout(() => {
              this.setState({
                loading: false
              })
            },
              300)
          }
        })
        .catch((error) => {
          console.error(error);
        });
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
                                    require("../src/imgs/portada/o.jpg");
    {
      if (this.state.loading) {
        return (
          <View style={styles.cargar} >
            <ActivityIndicator size='large' color='grey' />
          </View>
        );
      }
      return (
        <View>
        <View>
          <ImageBackground source={load_image} style={styles.portada}>
            <TouchableOpacity onPress={(this._IraConfiguracion)}>
              <Image source={require("../src/imgs/configuracion.png")} style={styles.confi} onPress={(this._IraConfiguracion)}></Image>
            </TouchableOpacity>
          </ImageBackground>
           <Image source={{ uri: 'https://micampus.tij.cetys.mx/fotos/' + this.state.matricula + '.jpg' }} style={styles.fpersona} />
          </View>
          <View style={{bottom:'10%'}}>
            <Text style={styles.title}>{this.state.nombre}</Text>
            <Text style={styles.title2}>{this.state.apellido}</Text>
            <Text style={styles.texto}>Carrera: {this.state.carrera} </Text>
            <Text style={styles.texto}>Materias aprobadas: {this.state.aprobadas}</Text>
            <Text style={styles.info} onPress={this._IraTutores}>Más información ></Text>
          </View>
        </View>
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
  title: {
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
    top:0
  },
  title2: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 25,
    textAlign: 'center'
  },
  fpersona: {
    width: 150,
    height: 150,
    borderWidth: 5,
    borderColor: '#ffffff',
    borderRadius: 80,
    bottom: '20%',
    left: '30%',
  },
  portada: {
    width: screenWidth,
    height: 200,
    alignItems: 'center',
    justifyContent: 'flex-start',
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
    resizeMode: 'contain',
    marginBottom: 25,
    marginLeft: 350,
    marginTop: 10,

  }
});