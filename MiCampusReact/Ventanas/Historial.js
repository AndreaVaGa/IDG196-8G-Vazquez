import React from 'react';
import { StyleSheet, View, Text, Image, TouchableOpacity, AsyncStorage, FlatList, ScrollView, ActivityIndicator } from 'react-native';
import Collapsible from 'react-native-collapsible';
import { widthPercentageToDP as wp, heightPercentageToDP as hp} from 'react-native-responsive-screen';
import { link } from '../src/Constantes'

export default class Historial extends React.Component {
  state = {
    collapsed: true,
    collapsed2: true,
    collapsed3: true,
    collapsed4: true,
  };

  toggleExpanded = () => {
    this.setState({
      collapsed: !this.state.collapsed,
    });
  }

  toggleExpanded2 = () => {
    this.setState({
      collapsed2: !this.state.collapsed2,
    });
  }
  toggleExpanded3 = () => {
    this.setState({
      collapsed3: !this.state.collapsed3,
    });
  }

  toggleExpanded4 = () => {
    this.setState({
      collapsed4: !this.state.collapsed4,
    });
  }


  constructor(props) {
    super(props);
    this.state = {
      loading: true,
      matricula: '',
      historial: '',
      promedio: '',
      cursando: '',
      aprobadas: '',
      sujetas: '',
      puede: ''
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
    fetch(link.cursando.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          var response = JSON.stringify(responseJson)
          var cursando = JSON.parse(response)
          this.setState({ cursando: cursando.cursando })
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(link.aprobadas.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          var response = JSON.stringify(responseJson)
          var aprobadas = JSON.parse(response)
          this.setState({ aprobadas: aprobadas.aprobadas })
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(link.porCursar.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          var response = JSON.stringify(responseJson)
          var porCursar = JSON.parse(response)
          this.setState({ puede: porCursar.porcursar })
        }
      })
      .catch((error) => {
        console.error(error);
      });
    fetch(link.promedioGeneral.replace('{matricula}', this.state.matricula))

      .then((response) => response.json())
      .then((responseJson) => {
        if (responseJson !== undefined) {
          var response = JSON.stringify(responseJson)
          var promedio = JSON.parse(response)
          this.setState({ promedio: promedio.promedio_general })

        }
      })
      .catch((error) => {
        console.error(error);
      });
  }

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

        <View style={styles.container}>
          <ScrollView style={{ marginBottom: 50 }}>
            <View>
              <TouchableOpacity onPress={this.toggleExpanded}>

                <View style={[styles.row, { height: this.state.animation }]}>
                  <View style={[styles.colorBox, { backgroundColor: '#4481c2' }]}>
                  </View>
                  <View style={styles.info}>
                    <Text style={styles.titulo}>Cursando</Text>
                  </View>

                  <View style={styles.rowIcon}>
                    <Image style={{ flex: 1, aspectRatio: .25, resizeMode: 'contain' }} source={require('../src/imgs/dropdown-01.png')}></Image>
                  </View>
                </View>

              </TouchableOpacity>

              <Collapsible collapsed={this.state.collapsed} align="center">


                <View style={[styles.row, { height: this.state.animation }]}>
                  <FlatList
                    data={this.state.cursando}
                    showsVerticalScrollIndicator={false}
                    renderItem={({ item }) =>
                      <View style={styles.fila}>

                        <View style={styles.materia}>
                          <Text style={styles.headers}>{item.nombre_materia}</Text>
                          <Text style={styles.texto}>{item.nombre_maestro}</Text>
                        </View>

                        <View style={styles.faltas}>
                          <Text style={styles.headers}>H</Text>
                          <Text style={styles.texto}>{item.horas_clase}</Text>
                        </View>

                        <View style={styles.promedio2}>
                          <Text style={styles.headers}>P</Text>
                        </View>

                      </View>
                    }
                    keyExtractor={item => item.materia}
                    ItemSeparatorComponent={this.ListViewItemSeparator}
                  />

                </View>

              </Collapsible>
            </View>

            <View>
              <TouchableOpacity onPress={this.toggleExpanded2}>
                <View style={[styles.row, { height: this.state.animation }]}>
                  <View style={[styles.colorBox, { backgroundColor: '#87c540' }]}>
                  </View>
                  <View style={styles.info}>
                    <Text style={styles.titulo}> Puede Cursar</Text>
                  </View>

                  <View style={styles.rowIcon}>
                    <Image style={{ flex: 1, aspectRatio: .25, resizeMode: 'contain' }} source={require('../src/imgs/dropdown-01.png')}></Image>
                  </View>
                </View>

              </TouchableOpacity>

              <Collapsible collapsed={this.state.collapsed2} align="center">
                <View style={[styles.row, { height: this.state.animation }]}>
                  <FlatList
                    data={this.state.puede}
                    showsVerticalScrollIndicator={false}
                    renderItem={({ item }) =>
                      <View style={styles.fila}>

                        <View style={styles.materia}>
                          <Text style={styles.headers}>{item.nombre_materia}</Text>
                          <Text style={styles.texto}>Maestro Indefinido</Text>
                        </View>

                        <View style={styles.faltas}>
                          <Text style={styles.headers}>H</Text>
                          <Text style={styles.texto}>{item.horas_clase}</Text>
                        </View>

                        <View style={styles.promedio2}>
                          <Text style={styles.headers}>P</Text>

                        </View>

                      </View>
                    }
                    keyExtractor={item => item.materia}
                    ItemSeparatorComponent={this.ListViewItemSeparator}
                  />

                </View>
              </Collapsible>
            </View>

            <View>
              <TouchableOpacity onPress={this.toggleExpanded3}>
                <View style={[styles.row, { height: this.state.animation }]}>
                  <View style={[styles.colorBox, { backgroundColor: '#fdd900' }]}>
                  </View>
                  <View style={styles.info}>
                    <Text style={styles.titulo}>Aprobadas</Text>
                  </View>

                  <View style={styles.rowIcon}>
                    <Image style={{ flex: 1, aspectRatio: .25, resizeMode: 'contain' }} source={require('../src/imgs/dropdown-01.png')}></Image>
                  </View>
                </View>

              </TouchableOpacity>

              <Collapsible collapsed={this.state.collapsed3} align="center">
                <View style={[styles.row, { height: this.state.animation }]}>
                  <FlatList
                    data={this.state.aprobadas}
                    showsVerticalScrollIndicator={false}
                    renderItem={({ item }) =>
                      <View style={styles.fila}>

                        <View style={styles.materia}>
                          <Text style={styles.headers}>{item.nombre_materia}</Text>
                          <Text style={styles.texto}>{item.nombre_maestro}</Text>
                        </View>

                        <View style={styles.faltas}>
                          <Text style={styles.headers}>H</Text>
                          <Text style={styles.texto}>{item.horas_clase}</Text>
                        </View>

                        <View style={styles.promedio2}>
                          <Text style={styles.headers}>P</Text>
                          <Text style={styles.texto}>{item.calificacion_final}</Text>
                        </View>

                      </View>
                    }
                    keyExtractor={item => item.materia}
                    ItemSeparatorComponent={this.ListViewItemSeparator}
                  />

                </View>
              </Collapsible>
            </View>

          </ScrollView>
          <View style={styles.promedio}>
            <Text style={{ color: 'white', fontWeight: 'bold', fontSize: 20, textAlign: 'right', marginRight: 5, marginTop: 3, marginBottom: 20, }}>Promedio general: {this.state.promedio}</Text>
          </View>
        </View>
      );
    }
  }
}

const styles = StyleSheet.create({
  cargar: {
    flex: 1,
    alignContent: 'center',
    justifyContent: 'center',
  },
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  row: {
    marginTop: 30,
    marginLeft: 15,
    flexDirection: 'row',
    alignContent: 'center',
  },
  info: {
    height: hp('16%'),
    width: wp('61%'),
    backgroundColor: '#F5F5F5',
    flexDirection: 'column',
    shadowColor: '#000',
  },
  materia: {
    height: hp('16%'),
    width: wp('61%'),
    borderTopLeftRadius: 10,
    borderBottomLeftRadius: 10,
    backgroundColor: '#F5F5F5',
    flexDirection: 'column',
  },

  colorBox: {
    height: hp('16%'),
    width: wp('15%'),
    backgroundColor: '#4481c2',
    borderTopLeftRadius: 10,
    borderBottomLeftRadius: 10,
    borderTopRightRadius: 0,
    borderBottomRightRadius: 0,
  },
  rowIcon: {
    height: hp('16%'),
    width: wp('15%'),
    borderTopRightRadius: 10,
    borderBottomRightRadius: 10,
    borderTopLeftRadius: 0,
    borderBottomLeftRadius: 0,
    backgroundColor: '#F5F5F5',
    flexDirection: 'column',
    alignItems: 'center',
  },
  titulo: {
    fontSize: 18,
    textAlign: 'center',
    marginTop: 15,
    alignContent: 'center',
    marginLeft: 5,
    marginRight: 5,
    marginTop: 40,
  },
  headers: {
    fontSize: 18,
    textAlign: 'center',
    marginTop: 15,
    alignContent: 'center',
    marginLeft: 5,
    marginRight: 5,
  },
  headers2: {
    fontSize: 15,
    textAlign: 'center',
    marginTop: 15,
  },
  promedio: {
    backgroundColor: '#191919',
    bottom: 0,
    position: 'absolute',
    padding: 7,
    width: '100%',
  },
  faltas: {
    width: 65,
    backgroundColor: '#ffffff',
    flexDirection: 'column',
  },
  fila: {
    height: hp('16%'),
    width: wp('15%'),
    marginBottom: 10,
    flexDirection: 'row',
  },
  promedio2: {
    height: hp('16%'),
    width: wp('15%'),
    borderTopRightRadius: 10,
    borderBottomRightRadius: 10,
    backgroundColor: '#ffffff',
    flexDirection: 'column',
  },
  texto: {
    fontSize: 12,
    textAlign: 'center',
    color: '#333333',
    marginTop: 5,
    marginBottom: 15,
    marginLeft: 5,
    marginRight: 5,
  }
});