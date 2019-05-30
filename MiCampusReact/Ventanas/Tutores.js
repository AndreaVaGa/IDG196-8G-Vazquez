import React from 'react';
import { StyleSheet, View, Text, AsyncStorage, ScrollView, screenWidth, ActivityIndicator } from 'react-native';
import { link } from '../src/Constantes'


export default class Tutores extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true,
      nombre: '',
      telefono: '',
      trabajo: '',
      correo: '',
      direccion: '',
      nombre2: '',
      telefono2: '',
      trabajo2: '',
      correo2: '',
      direccion2: ''
    };
  }

  componentDidMount() {
    this._loadInitionState().done();
    setTimeout(() => {
      this.setState({
        loading: false
      })
    },
      300)
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('usuario');
    if (value !== null) {
      var alumno = JSON.parse(value)
      this.setState({ matricula: alumno.matricula })
    }
    return fetch(link.tutores.replace('{matricula}', this.state.matricula))
      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          var response = JSON.stringify(responseJson)
          var alumno = JSON.parse(response)
          this.setState({ nombre: alumno.tutores.nombre_1_padre + ' ' + alumno.tutores.nombre_2_padre + ' ' + alumno.tutores.apellido_paterno_padre + ' ' + alumno.tutores.apellido_materno_padre })
          this.setState({ telefono: alumno.tutores.telefono_padre })
          this.setState({ trabajo: alumno.tutores.empresa_padre })
          this.setState({ correo: alumno.tutores.email_padre })
          this.setState({ direccion: alumno.tutores.direccion_padre + ' ' + alumno.tutores.colonia_padre })
          this.setState({ nombre2: alumno.tutores.nombre_1_madre + ' ' + alumno.tutores.nombre_2_madre + ' ' + alumno.tutores.apellido_paterno_madre + ' ' + alumno.tutores.apellido_materno_madre })
          this.setState({ telefono2: alumno.tutores.telefono_madre })
          this.setState({ trabajo2: alumno.tutores.empresa_madre })
          this.setState({ correo2: alumno.tutores.email_madre })
          this.setState({ direccion2: alumno.tutores.direccion_madre + ' ' + alumno.tutores.colonia_madre })

        }
      })
      .catch((error) => {
        console.error(error);
      });
  }

  render() {
    {
      if (this.state.loading) {
        return (
          <View style={styles.cargar} >
            <ActivityIndicator size='large' color='grey' />
          </View>
        );
      }
    return (
      <ScrollView style={styles.container}>
        <Text style={styles.titles}>Padre: </Text>
        <Text style={styles.texto}>{this.state.nombre}</Text>
        <View style={styles.lineStyle} />
        <Text style={styles.texto2}>Telefono: </Text>
        <Text style={styles.texto}>{this.state.telefono}</Text>
        <Text style={styles.texto2}>Trabajo: </Text>
        <Text style={styles.texto}>{this.state.trabajo}</Text>
        <Text style={styles.texto2}>Correo: </Text>
        <Text style={styles.texto}>{this.state.correo}</Text>
        <Text style={styles.texto2}>Dirección: </Text>
        <Text style={styles.texto}>{this.state.direccion}</Text>
        <Text style={styles.titles}>Madre: </Text>
        <Text style={styles.texto}>{this.state.nombre2}</Text>
        <View style={styles.lineStyle} />
        <Text style={styles.texto2}>Telefono: </Text>
        <Text style={styles.texto}>{this.state.telefono2}</Text>
        <Text style={styles.texto2}>Trabajo: </Text>
        <Text style={styles.texto}>{this.state.trabajo2}</Text>
        <Text style={styles.texto2}>Correo: </Text>
        <Text style={styles.texto}>{this.state.correo2}</Text>
        <Text style={styles.texto2}>Dirección: </Text>
        <Text style={{ justifyContent: 'center', fontSize: 14, marginRight: 30, marginLeft: 30, marginBottom: 50 }}>{this.state.direccion2}</Text>
      </ScrollView>
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
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: 'white',
  },
  titles: {
    justifyContent: 'center',
    marginTop: 25,
    marginLeft: 30,
    marginRight: 30,
    fontSize: 30
  },
  texto: {
    justifyContent: 'center',
    fontSize: 14,
    marginLeft: 30,
    marginRight: 30,
  },
  texto2: {
    justifyContent: 'center',
    marginTop: 20,
    marginLeft: 30,
    marginRight: 30,
    fontSize: 16
  },
  lineStyle: {
    borderWidth: 1,
    width: screenWidth,
    borderColor: '#ffd700',
    marginTop: 15,
    marginLeft: 30,
    marginRight: 30,
  },
});
