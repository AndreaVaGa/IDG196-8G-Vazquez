import React from 'react';
import {
  StyleSheet,
  View,
  FlatList,
  AsyncStorage,
  ActivityIndicator
} from 'react-native';
import BoletaRow from '../Utils/boleta_row';

class ListViewDemo extends React.Component {

  constructor(props) {
    super(props)
    this.state = {
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
      150)
  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('boleta');
    if (value !== undefined) {
      var boleta = JSON.parse(value)
      this.setState({ data: boleta.boleta })
    }
  }
  //funcion que se define como atributo y se puede mandar 
  //a ejecutar desde el componente
  _onPressItem = (value) => {
    alert(value)
  };

  _renderItem = ({ item }) => (
    <BoletaRow
      onPressItem={this._onPressItem}
      matricula={item.matricula}
      materia={item.nombre_materia}
      calif={item.promedio}
      profesor={item.nombre_maestro}
      faltas={item.faltas_totales}
      calif1={item.calificacion1}
      calif2={item.calificacion2}
      calif3={item.calificacion3}
      faltas1={item.faltas1}
      faltas2={item.faltas2}
      faltas3={item.faltas3}
    />
  );

  render() {
    return (
      <View style={styles.container} >
        {
          this.state.loading ?
            <ActivityIndicator size='large' color='grey' />
            :
              <FlatList
                data={this.state.data}
                extraData={this.state}
                keyExtractor={(item, index) => item.materia}
                renderItem={this._renderItem}
                showsVerticalScrollIndicator={false}
              />
        }
      </View>
    );
  }
}

export default ListViewDemo;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginBottom: 20,
    alignContent: 'flex-end'
  }
});
