import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    TouchableOpacity,
    ScrollView,
    Image,
    FlatList,
    AsyncStorage,
    RefreshControl
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';
import TramitesRow from '../Utils/tramites_row';


class Tramites extends React.Component {

     constructor(props) {
    super(props)
    this.state = {
      loading: false,
      page: 1,
      seed: 1,
      error: null,
      refreshing: true,
    };
  }

  componentDidMount() {
    this._loadInitionState().done();
  }

    _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('boleta');
    if (value !== undefined) {
      var boleta = JSON.parse(value)
      this.setState({ data: boleta.boleta})
    }
  }

    _IraPago = () => {
        this.props.navigation.navigate('Pago');
      }
    
      _renderItem = ({ item }) => (
        <TramitesRow
        onPressItem={this._onPressItem}
        fila={item.fila}
        seleccionar={item.seleccionar}
        headersPrecio={item.headersPrecio}
        info={item.info}
        texto={item.texto}
        header={item.header}
        />
      );

      render() {
        return (
          <View style={styles.container} >
          <ScrollView>
            <FlatList
              data={this.state.data}
              extraData={this.state}
              keyExtractor={(item, index) => item.fila}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />

            </ScrollView>


            <View style={styles.total}>
                         <Text style={styles.textPromedio}>Total: ${global.sumaTramites} 
                         <TouchableOpacity onPress={(this._IraPago)}>
                            <Image source={require("../src/imgs/pagar.png")} style={styles.boton} onPress={(this._IraPago)}></Image>
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
      fontWeight: 'bold', 
      fontSize: 20, 
      textAlign: 'center', 
      marginTop: 10,
      marginBottom: 35, 
    },
    boton: { 
      marginLeft: 25,
      },
});