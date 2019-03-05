import React from 'react';
import { StyleSheet, View, Text, AsyncStorage, ScrollView, screenWidth } from 'react-native';

export default class Tutores extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
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
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('tutores');
    if (value !== null) {
      var alumno = JSON.parse(value)
      this.setState({ nombre: alumno.Nombre_1_Padre + ' ' + alumno.Nombre_2_Padre + ' ' + alumno.Apellido_Paterno_Padre + ' ' + alumno.Apellido_Materno_Padre })
      this.setState({ telefono: alumno.Telefono_Padre })
      this.setState({ trabajo: alumno.Empresa_Padre })
      this.setState({ correo: alumno.Email_Padre })
      this.setState({ direccion: alumno.Direccion_Padre + ' ' + alumno.Colonia_Padre })
      this.setState({ nombre2: alumno.Nombre_1_Madre + ' ' + alumno.Nombre_2_Madre + ' ' + alumno.Apellido_Paterno_Madre + ' ' + alumno.Apellido_Materno_Madre })
      this.setState({ telefono2: alumno.Telefono_Madre })
      this.setState({ trabajo2: alumno.Empresa_Madre })
      this.setState({ correo2: alumno.Email_Madre })
      this.setState({ direccion2: alumno.Direccion_Madre + ' ' + alumno.Colonia_Madre })
    }
  }

  render() {
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

const styles = StyleSheet.create({
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
