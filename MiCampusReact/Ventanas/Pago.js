import React from 'react';
import { Text, View, StyleSheet, TouchableOpacity, TextInput, AsyncStorage} from 'react-native';
import { link } from '../src/Constantes'
import { widthPercentageToDP as wp, heightPercentageToDP as hp} from 'react-native-responsive-screen';
import { Dropdown } from 'react-native-material-dropdown';

class Pago extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            loading: false,
            matricula: '',
            textoTarjeta: '',
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
        if (this.state.textoTarjeta.length == 16 && this.state.textoCVV.length >= 2) {
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
                            this.setState({
                                loading: false
                            })
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

        if (this.state.textoTarjeta.length == 16 && this.state.textoCVV.length >= 3) {
            this._opacity.setNativeProps({ opacity: 1 })
        }
        if (this.state.textoTarjeta.length < 16 && this.state.textoTarjeta.length > 0) {
            this._opacity.setNativeProps({ opacity: .5 })
        }
        if (this.state.textoCVV.length < 3 && this.state.textoCVV.length > 0) {
            this._opacity.setNativeProps({ opacity: .5 })
        }

        let data = [{
        value: '10/20',
        }, {
        value: '11/20',
        }, {
        value: '12/20',
        }];


        return (
            <View style={styles.container}>
                <View style={[styles.precioTotal]}>
                    <Text style={styles.textoPrecio}>${global.sumaTramites}MXN</Text>
                </View>
                <View>
                    <View style={[styles.contenido]}>
                        <View style={styles.textoContenido}>
                            <View>
                                <TextInput style={[styles.boxContenido]} keyboardType={'numeric'}
                                    placeholder="Numero de Trajeta"
                                    placeholderTextColor='grey'
                                    onChangeText={(textoTarjeta) => this.setState({ textoTarjeta })}
                                    maxLength={16}
                                />
                            </View>
                            <Dropdown label='Expira' data={data}/>
                            <View style={[styles.boxEC]}>
                                <TextInput style={[styles.boxECInterno]} keyboardType={'numeric'}
                                    placeholder="CVV"
                                    placeholderTextColor='grey'
                                    onChangeText={(textoCVV) => this.setState({ textoCVV })}
                                    maxLength={4}
                                />
                            </View>

                            <TouchableOpacity style={[styles.box]} onPress={(this._IraRecibo)} ref={component => this._opacity = component}>
                                <Text style={[styles.boxText]} >Pagar ${global.sumaTramites}MXN </Text>
                            </TouchableOpacity>
                        </View>
                    </View>
                    <View style={styles.infoExtra}>
                        <Text style={styles.textoInfo}></Text>
                    </View>
                </View>
            </View>
        );
    }
}
export default Pago;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginLeft: 15,
    },
    cargar: {
        flex: 1,
        alignContent: 'center',
        justifyContent: 'center',
    },
    precioTotal: {
        marginTop: 30,
        height: hp('9%'),
        width: wp('91%'),
        borderTopLeftRadius: 10,
        borderTopRightRadius: 10,
        backgroundColor: '#333333',
        flexDirection: 'row',
    },
    contenido: {
        height: hp('45%'),
        width: wp('91%'),
        backgroundColor: '#f2f2f2',
        flexDirection: 'row',
    },
    infoExtra: {
        height: hp('5%'),
        width: wp('91%'),
        borderBottomRightRadius: 10,
        borderBottomLeftRadius: 10,
        backgroundColor: '#333333',
        flexDirection: 'row',
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
        marginTop: 5,
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
        height: hp('7%'),
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
        alignItems: 'center',
        marginLeft: 38,
        opacity: .5,
    },
    boxText: {
        fontSize: 20,
        color: '#333333',
    },
    boxContenido: {
        height: hp('5%'),
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
        height: hp('5%'),
        width: wp('40%'),
        flexDirection: 'column',
        fontSize: 22,
        padding: 5,
    },

});