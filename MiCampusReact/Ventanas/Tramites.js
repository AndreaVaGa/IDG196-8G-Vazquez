import React from 'react';
import { StyleSheet, View, Text, Image, TouchableOpacity, AsyncStorage, FlatList, ScrollView } from 'react-native';
import Collapsible from 'react-native-collapsible';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';
import TramitesRow from '../Utils/tramites_row';

class ListViewDemo extends React.Component {
 _renderItem = ({ item }) => (
    <TramitesRow
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
      <ScrollView style={{marginBottom:50}}>
        <FlatList
          data={this.state.data}
          extraData={this.state}
          keyExtractor={(item, index) => item.materia}
          renderItem={this._renderItem}
          showsVerticalScrollIndicator={false}
        />
      </ScrollView>
        <View style={styles.promedio}>
          <Text style={styles.textPromedio}>Total: $200 </Text>
        </View>
      </View>
    );
  }
}

export default ListViewDemo;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginBottom: 20,
    alignContent: 'flex-end',
  },
  promedio: {
    backgroundColor: '#191919',
    bottom: 0,
    position: 'absolute',
    padding: 7,
    width: '100%',
  },
  textPromedio: { 
    color: 'white', 
    fontWeight: 'bold', 
    fontSize: 20, 
    textAlign: 'right', 
    marginRight: 5, 
    marginBottom: 10, 
  },

});
