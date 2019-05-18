import React from 'react';
import {
  Text,
  View,
  StyleSheet,
  TouchableOpacity,
  ScrollView,
  FlatList,
  AsyncStorage,
  RefreshControl
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';
import TramitesRow from '../Utils/tramites_row';
//import console = require('console');


class Tramites extends React.Component {

  constructor(props) {
    super(props)
    this.state = {
      loading: false,
      page: 1,
      seed: 1,
      error: null,
      refreshing: true,
      total: 0
    };

    this.handler = this.handler.bind(this);

  }

  componentDidMount() {
    this._loadInitionState().done();
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('tramites');
    if (value !== undefined) {
      var tramites = JSON.parse(value)
      this.setState({ data: tramites.tramites })
    }
    global.sumaTramites = 0;
  }

  _IraPago = () => {
    this.props.navigation.navigate('Pago');
  }

  handler(amount) {
    this.setState({ total: amount })
  }

  _renderItem = ({ item }) => (
    <TramitesRow
      onPressItem={this._onPressItem}
      nombre={item.nombre}
      precio={item.precio}
      seleccionar={item.seleccionar}
      headersPrecio={item.headersPrecio}
      info={item.info}
      texto={item.texto}
      header={item.header}
      binder={this.handler}
    />
  );

  render() {
    return (
      <View style={styles.container} >
        <ScrollView>
          <FlatList
            data={this.state.data}
            extraData={this.state}
            keyExtractor={(item, index) => item.nombre}
            renderItem={this._renderItem}
            showsVerticalScrollIndicator={false}
          />

        </ScrollView>


        <View style={styles.total}>
          <Text style={styles.textPromedio}>Total: ${this.state.total}MXN 
            <TouchableOpacity style={[styles.box]} onPress={(this._IraPago)}>
              <Text style={[styles.boxText]} >Pagar</Text>
            </TouchableOpacity>
            </Text>
        </View>

      </View>


    );
  }
}
export default Tramites;

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  total: {
    backgroundColor: '#333333',
  },

  textPromedio: {
    color: 'white',
    fontSize: 18,
    textAlign: 'center',
    marginTop: 10,
    marginBottom: 35,
  },
  box: {
    height: 25,
    width: wp('22%'),
    flexDirection: 'row',
    borderRadius: 20,
    shadowColor: 'black',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.9,
    shadowRadius: 2,
    elevation: 4,
    backgroundColor: '#ffd700',
    justifyContent: 'center',
},
boxText: {
    fontSize: 18,
    color: '#333333',
},
});