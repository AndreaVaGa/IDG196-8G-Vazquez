import React from 'react';
import { Text, View, StyleSheet, TouchableOpacity, TextInput, AsyncStorage, ActivityIndicator } from 'react-native';
import { link } from '../src/Constantes'
import { widthPercentageToDP as wp } from 'react-native-responsive-screen';

class Pago extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            matricula: '',
            textoTarjeta: '',
            textoExpiracion: '',
            textoCVV: ''
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
    _IraRecibo = () => {
        this.setState({ loading: true })
        if (this.state.textoTarjeta.length == 16 && this.state.textoExpiracion.length == 5 && this.state.textoCVV.length >= 2) {
            return fetch(link.historialFinanciero.replace('{matricula}', this.state.matricula), {
                method: 'POST',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    matricula: this.state.matricula,
                    tramites: global.listaTramites.toString()
                }),
            })
                .then((response) => response.json())
                .then((responseJson) => {
                    if (responseJson !== undefined) {
                        AsyncStorage.setItem('recibo', JSON.stringify(responseJson))
                        this.props.navigation.navigate('Recibo');
                        setTimeout(() => {
                            this.setState({ loading: false })
                        },
                            300)
                    }
                })
                .catch((error) => {
                    console.error(error);
                })
        }
    }

    render() {
        if (this.state.loading) {
            return (
                <View style={styles.cargar} >
                    <ActivityIndicator size='large' color='grey' />
                </View>
            );
        }
        return (
            <View style={styles.container}>
                <View style={[styles.precioTotal]}>
                    <Text style={styles.textoPrecio}>${global.sumaTramites}MXN</Text>
                </View>
                <View>
                    <View style={[styles.contenido]}>
                        <View style={styles.textoContenido}>
                            <View>
                                <TextInput style={[styles.boxContenido]}
                                    placeholder="Numero de Trajeta"
                                    placeholderTextColor='grey'
                                    onChangeText={(textoTarjeta) => this.setState({ textoTarjeta })}
                                    maxLength={16}
                                />
                            </View>
                            <View style={[styles.boxEC]}>
                                <TextInput style={[styles.boxECInterno]}
                                    placeholder="Expira"
                                    placeholderTextColor='grey'
                                    onChangeText={(textoExpiracion) => this.setState({ textoExpiracion })}
                                    maxLength={5}
                                />
                                <TextInput style={[styles.boxECInterno]}
                                    placeholder="CVV"
                                    placeholderTextColor='grey'
                                    onChangeText={(textoCVV) => this.setState({ textoCVV })}
                                    maxLength={3}
                                />
                            </View>

                            <TouchableOpacity style={[styles.box]} onPress={(this._IraRecibo)}>
                                <Text style={[styles.boxText]} >Pagar ${global.sumaTramites}MXN </Text>
                            </TouchableOpacity>
                        </View>
                    </View>
                    <View style={styles.infoExtra}>
                        <Text style={styles.textoInfo}>Duplicado de credencial de estudiante</Text>
                    </View>
                </View>
            </View>
        );
    }
}
export default Pago;

const styles = StyleSheet.create({
    cargar: {
        flex: 1,
        alignContent: 'center',
        justifyContent: 'center',
    },
    container: {
        flex: 1,
        marginLeft: 15,
    },
    precioTotal: {
        marginTop: 30,
        height: 50,
        width: wp('91%'),
        borderTopLeftRadius: 10,
        borderTopRightRadius: 10,
        backgroundColor: '#333333',
        flexDirection: 'row',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
    },
    contenido: {
        height: 300,
        width: wp('91%'),
        backgroundColor: '#f2f2f2',
        flexDirection: 'row',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
    },
    infoExtra: {
        height: 80,
        width: wp('91%'),
        borderBottomRightRadius: 10,
        borderBottomLeftRadius: 10,
        backgroundColor: '#333333',
        flexDirection: 'row',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
        justifyContent: 'center',
    },
    textoPrecio: {
        fontSize: 26,
        textAlign: 'left',
        marginLeft: 18,
        marginRight: 18,
        color: 'white',
        marginTop: 10,
        opacity: 1,
    },
    textoContenido: {
        fontSize: 18,
        textAlign: 'left',
        marginLeft: 18,
        color: '#333333',
        marginTop: 10,
        opacity: 1,
    },
    textoInfo: {
        fontSize: 12,
        textAlign: 'center',
        marginLeft: 18,
        marginRight: 18,
        color: '#f2f2f2',
        marginTop: 15,
        opacity: 1,
    },
    box: {
        height: 40,
        width: wp('61%'),
        flexDirection: 'row',
        borderRadius: 20,
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
        backgroundColor: '#ffd700',
        justifyContent: 'center',
        marginTop: 35,
        marginLeft: 38,
    },
    boxText: {
        marginTop: 5,
        fontSize: 20,
        textAlign: 'center',
        color: '#333333',
    },
    boxContenido: {
        height: 40,
        width: wp('81%'),
        flexDirection: 'column',
        justifyContent: 'center',
        marginTop: 30,
        marginBottom: 10,
        fontSize: 22,
        padding: 5,
    },
    boxEC: {
        marginTop: 20,
        marginBottom: 30,
        flexDirection: 'row',
    },
    boxECInterno: {
        height: 40,
        width: wp('40%'),
        flexDirection: 'column',
        fontSize: 22,
        padding: 5,
    },

});