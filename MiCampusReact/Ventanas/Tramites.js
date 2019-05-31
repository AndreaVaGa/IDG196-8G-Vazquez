import React from 'react';
import { Text, View, StyleSheet, TouchableOpacity, ScrollView, FlatList, AsyncStorage, ActivityIndicator } from 'react-native';
import { widthPercentageToDP as wp } from 'react-native-responsive-screen';
import TramitesRow from '../Utils/tramites_row';
import { link } from '../src/Constantes'
class Tramites extends React.Component {

  constructor(props) {
    super(props)
    this.state = {
      loading: true,
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
    global.sumaTramites = 0;
    global.listaTramites = [null];
    return fetch(link.tramites.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          var response = JSON.stringify(responseJson)
          var tramites = JSON.parse(response)
          this.setState({ data: tramites.tramites })
        }
      })
      .catch((error) => {
        console.error(error);
      });
  }

  _IraPago = () => {
    if (this.state.total > 0) {
      this.props.navigation.navigate('Pago');
    }
    if (this.state.total==0) {
            this._opacity.setNativeProps({ opacity: .5 })
        }
  }

  handler(amount) {
    this.setState({ total: amount })
  }

  _renderItem = ({ item }) => (
    <TramitesRow
      onPressItem={this._onPressItem}
      id= {item.id}
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
    if (this.state.total > 0) {
            this._opacity.setNativeProps({ opacity: 1 })
        }
        
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
              keyExtractor={(item, index) => item.nombre}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />

          </ScrollView>


          <View style={styles.total}>
            <View style={styles.fila}>

              <View style={{ flexDirection: 'column', }}>
                <Text style={styles.textPromedio}>Total: ${this.state.total}MXN</Text>
              </View>

              <View style={{ flexDirection: 'column', marginLeft: 7 }}>
                <TouchableOpacity style={[styles.box]} onPress={(this._IraPago)} ref={component => this._opacity = component}>
                  <Text style={[styles.boxText]} >Pagar</Text>
                </TouchableOpacity>
              </View>

            </View>
          </View>

        </View>


      );
    }
  }
}
export default Tramites;

const styles = StyleSheet.create({
  cargar: {
    flex: 1,
    alignContent: 'center',
    justifyContent: 'center',
  },
  container: {
    flex: 1,
  },
  total: {
    backgroundColor: '#333333',
  },
  fila: {
    flexDirection: 'row',
    justifyContent: `center`,
    marginTop: 10,
    marginBottom: 35,
  },
  textPromedio: {
    color: 'white',
    fontSize: 18,
    textAlign: 'center',
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
    opacity: .5
  },
  boxText: {
    fontSize: 18,
    color: '#333333',
  },
});