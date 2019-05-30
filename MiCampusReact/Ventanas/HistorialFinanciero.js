import React from 'react';
import {
  View,
  StyleSheet,
  FlatList,
  ScrollView,
  AsyncStorage,
  ActivityIndicator
} from 'react-native';
import HistorialFRow from '../Utils/historial_f_row';
import { link } from '../src/Constantes'

class HistorialFinanciero extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      matricula: '',
      loading: true,
      page: 1,
      seed: 1,
      error: null,
      refreshing: false,
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
    if (value !== undefined) {
      var alumno = JSON.parse(value)
      this.setState({ matricula: alumno.matricula })
    }
    return fetch(link.historialFinanciero.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          var response= JSON.stringify(responseJson)
          var historialF = JSON.parse(response)
          this.setState({ data: historialF.historial })
        }
      })
      .catch((error) => {
        console.error(error);
      });

  }


  _renderItem = ({ item }) => (
    <HistorialFRow
      onPressItem={this._onPressItem}
      seleccionar={item.seleccionar}
      headersPrecio={item.headersPrecio}
      fecha={item.date.slice(0, 11)}
      id_compra={item.id_compra}
      total={item.total}
      descripcion={item.name}
    />
  );

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
        <View style={styles.container} >
          <ScrollView>
            <FlatList
              data={this.state.data}
              extraData={this.state}
              keyExtractor={(item, index) => item.id_compra}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />

          </ScrollView>
        </View>

      );
    }
  }
}
export default HistorialFinanciero;

const styles = StyleSheet.create({
  cargar: {
    flex: 1,
    alignContent: 'center',
    justifyContent: 'center',
  },
  container: {
    flex: 1,
  },
  textPromedio: {
    color: 'white',
    fontWeight: 'bold',
    fontSize: 18,
    textAlign: 'center',
    marginTop: 3,
    marginBottom: 20,
  },
  boton: {
    marginLeft: 25,
    height: 10,
  },
});