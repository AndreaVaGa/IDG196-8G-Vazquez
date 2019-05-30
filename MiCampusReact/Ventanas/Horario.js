import React from 'react';
import { StyleSheet, Text, View, FlatList, AsyncStorage } from 'react-native';
import Carousel from '../Utils/carrousel';
import HorarioRow from '../Utils/horario_row';
import { link } from '../src/Constantes'

class Horario extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      matricula: '',
      loading: true,
      horario: '',
      lunes: [],
      martes: [],
      miercoles: [],
      jueves: [],
      viernes: [],
      sabado: [],
      visible: false,
      loading: false,
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
    if (value !== null) {
      var alumno = JSON.parse(value)
      this.setState({ matricula: alumno.matricula })
    }
    fetch(link.horario.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          var value = JSON.stringify(responseJson)
          if (value !== null) {
            var horario = JSON.parse(value)
            horario.horario.forEach(materia => {
              if (materia.dia == 1) {

                this.state.lunes.push(materia)
              }
              else if (materia.dia == 2) {

                this.state.martes.push(materia)
              }
              else if (materia.dia == 3) {

                this.state.miercoles.push(materia)
              }
              else if (materia.dia == 4) {

                this.state.jueves.push(materia)
              }
              else if (materia.dia == 5) {

                this.state.viernes.push(materia)
              }
              else {
                this.state.sabado.push(materia)
              }

            });
            this.setState({ lunes: this.state.lunes })
            this.setState({ martes: this.state.martes })
            this.setState({ miercoles: this.state.miercoles })
            this.setState({ jueves: this.state.jueves })
            this.setState({ viernes: this.state.viernes })
            this.setState({ sabado: this.state.sabado })

          }
        }
      })
      .catch((error) => {
        console.error(error);
      });
  }

  _onPressItem = (value) => {
    alert(value)
  };

  _renderItem = ({ item }) => (

    <HorarioRow
      onPressItem={this._onPressItem}
      matricula={item.matricula}
      horaI={item.hora_inicio}
      horaF={item.hora_final}
      materia={item.materia}
      salon={item.lugar}
      profesor={item.maestro}
      color={item.color.slice(0, 7)}

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
        <Carousel >
          <View>
            <View style={{ backgroundColor: '#FA1111' }}>
              <Text style={styles.semana}>Lunes</Text>
            </View>
            <FlatList
              data={this.state.lunes}
              extraData={this.state}
              keyExtractor={(item, index) => item.materia}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />
          </View>

          <View>
            <View style={{ backgroundColor: '#32CD32' }}>
              <Text style={styles.semana}>Martes</Text>
            </View>
            <FlatList
              data={this.state.martes}
              extraData={this.state}
              keyExtractor={(item, index) => item.materia}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />
          </View>

          <View>
            <View style={{ backgroundColor: '#DAA520' }}>
              <Text style={styles.semana}>Miércoles</Text>
            </View>
            <FlatList
              data={this.state.miercoles}
              extraData={this.state}
              keyExtractor={(item, index) => item.materia}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />
          </View>

          <View>
            <View style={{ backgroundColor: '#DB7093' }}>
              <Text style={styles.semana}>Jueves</Text>
            </View>
            <FlatList
              data={this.state.jueves}
              extraData={this.state}
              keyExtractor={(item, index) => item.materia}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />
          </View>

          <View>
            <View style={{ backgroundColor: '#663399' }}>
              <Text style={styles.semana}>Viernes</Text>
            </View>
            <FlatList
              data={this.state.viernes}
              extraData={this.state}
              keyExtractor={(item, index) => item.materia}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />
          </View>

          <View>
            <View style={{ backgroundColor: '#CD5C5C' }}>
              <Text style={styles.semana}>Sábado</Text>
            </View>
            <FlatList
              data={this.state.sabado}
              extraData={this.state}
              keyExtractor={(item, index) => item.materia}
              renderItem={this._renderItem}
              showsVerticalScrollIndicator={false}
            />
          </View>

        </Carousel>
      );
    }
  }
}

export default Horario;

const styles = StyleSheet.create({
  cargar: {
    flex: 1,
    alignContent: 'center',
    justifyContent: 'center',
  },
  container: {
    flex: 1,
  },
  semana: {
    textAlign: 'center',
    color: '#ffffff',
    fontSize: 16,
    margin: 10
  }

});
