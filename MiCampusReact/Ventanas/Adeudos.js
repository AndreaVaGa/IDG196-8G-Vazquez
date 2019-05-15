import React from 'react';
import {
    View,
    StyleSheet,
    FlatList,
     AsyncStorage,
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';
import AdeudosRow from '../Utils/adeudos_row';

class Adeudos extends React.Component {
     
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
    var value = await AsyncStorage.getItem('boleta');
    if (value !== undefined) {
      var boleta = JSON.parse(value)
      this.setState({ data: boleta.boleta})
    }
  }

    
      _renderItem = ({ item }) => (
        <AdeudosRow
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
            </View>
                
        );
    }
}
export default Adeudos;

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