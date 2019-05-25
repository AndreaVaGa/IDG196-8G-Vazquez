import React from 'react';
import {
  View,
  StyleSheet,
  FlatList,
  ScrollView,
  AsyncStorage,
} from 'react-native';
import HistorialFRow from '../Utils/historial_f_row';

class HistorialFinanciero extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      loading: false,
      page: 1,
      seed: 1,
      error: null,
      refreshing: false,
    };
  }

  componentDidMount() {
    this._loadInitionState().done();
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('historialF');
    if (value !== undefined) {
      var historialF = JSON.parse(value)
      this.setState({ data: historialF.historial })
    }
  }


  _renderItem = ({ item }) => (
    <HistorialFRow
      onPressItem={this._onPressItem}
      seleccionar={item.seleccionar}
      headersPrecio={item.headersPrecio}
      fecha={item.date.slice(0, 11)}
      id_compra={item.id_compras}
      precio={item.price}
      descripcion={item.name}
    />
  );

  render() {
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
export default HistorialFinanciero;

const styles = StyleSheet.create({
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