import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    TouchableOpacity,
    Image
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';
import TramitesRow from '../Utils/tramites_row';

class Tramites extends React.Component {

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
            <FlatList
              data={this.state.data}
              extraData={this.state}
              keyExtractor={(item, index) => item.fila}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />

                <View style={styles.total}>
                         <Text style={styles.textPromedio}>Total: $200 
                         <TouchableOpacity onPress={(this._IraConfiguracion)}>
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