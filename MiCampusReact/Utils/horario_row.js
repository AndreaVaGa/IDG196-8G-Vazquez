import React from 'react';
import {
  Text,
  View,
  TouchableOpacity,
  StyleSheet,
  AsyncStorage
} from 'react-native';
import { link } from '../src/Constantes'
import { StatusColorPicker } from 'react-native-status-color-picker';
class HorarioRow extends React.PureComponent {
  constructor(props) {
    super(props)
    this.state = {
      visible: false,
      colors: ['#ffffff', "#BC95DD", "#95D5DD", "#F9BBF4", "#F9F4BB", "#BBD1F9", "#F9D3BB", "#03A9F4", "#00BCD4", "#009688", "#4CAF50", "#8BC34A", "#CDDC39", "#FFEB3B", "#FFC107", "#FF9800"],
      selectedColor: this.props.color,
    };
  }
  componentDidMount() {
    this._loadInitionState().done();

  }

  _loadInitionState = async () => {
    var value = await AsyncStorage.getItem('usuario');
    if (value !== null) {
      var alumno = JSON.parse(value)
      this.setState({ matricula: alumno.matricula })
    }
  }

  ok = data => {
    this.setState({ selectedColor: data.selectedColor });
    this.close();
    return fetch(link.horario.replace('{matricula}', this.state.matricula), {

      method: 'PUT',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        matricula: this.state.matricula,
        materia: this.props.materia,
        color: data.selectedColor
      }),
    })
      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          AsyncStorage.setItem('horario', JSON.stringify(responseJson))
        }
      })
      .catch((error) => {
        console.error(error);
      })
    AsyncStorage.setItem(this.props.materia, data.selectedColor);
  };

  close = () => {
    this.setState({ visible: false });
  };

  _onPress = () => {
    this.setState({ visible: true })

  };


  render() {
    return (
      <View>
        <TouchableOpacity onPress={this._onPress}>
          <View style={styles.fila}>
            <View style={styles.materia}>
              <Text style={styles.headers}>{this.props.materia}</Text>
              <Text style={styles.profesor}>{this.props.profesor}</Text>
            </View>
            <View style={[styles.salon, { backgroundColor: this.state.selectedColor }]}>
              <Text style={styles.numero}>{this.props.salon}</Text>
              <Text style={styles.hora}>{this.props.horaI}:00- {this.props.horaF}:00</Text>
            </View>
          </View>
        </TouchableOpacity>
        <StatusColorPicker
          visible={this.state.visible}
          colors={this.state.colors}
          selectedColor={this.state.selectedColor}
          onOk={this.ok}
          onCancel={this.close} />
      </View>
    );
  }
}

export default HorarioRow;


const styles = StyleSheet.create({
  fila: {
    marginTop: 30,
    marginBottom: 5,
    marginLeft: 22,
    flexDirection: 'row',
  },
  materia: {
    width: 240,
    height: 100,
    justifyContent: 'center',
    borderTopLeftRadius: 10,
    borderBottomLeftRadius: 10,
    backgroundColor: '#F5F5F5',
    flexDirection: 'column',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.8,
    shadowRadius: 2,
    elevation: 4,
  },
  salon: {
    width: 80,
    height: 100,
    justifyContent: 'center',
    borderTopRightRadius: 10,
    borderBottomRightRadius: 10,
    flexDirection: 'column',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.8,
    shadowRadius: 2,
    elevation: 4,
  },
  headers: {
    fontSize: 20,
    textAlign: 'left',
    marginLeft: 10,
  },
  numero: {
    fontSize: 20,
    textAlign: 'center',
  },
  profesor: {
    textAlign: 'left',
    color: '#333333',
    marginTop: 2,
    marginLeft: 10,
  },
  hora: {
    textAlign: 'center',
    color: '#333333',
    marginTop: 2,
    fontSize: 10,
  },
});