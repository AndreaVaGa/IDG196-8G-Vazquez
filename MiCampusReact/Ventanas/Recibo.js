import React from 'react';
import { Text, View, StyleSheet, AsyncStorage, TouchableOpacity, Image, FlatList, ActivityIndicator } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp} from 'react-native-responsive-screen';
import ReciboRow from '../Utils/recibo_row';

class Recibo extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            loading: true,
            id_compra: '',
            date: '',
            id_tramite: '',
            tramite: '',
            precio: '',
            total: '',
            matricula: '',
            data: ''
        };
    }

    _IraMenu = () => {
        this.props.navigation.navigate('Menu');
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
        var value2 = await AsyncStorage.getItem('recibo');
        if (value2 !== null) {
            var recibo = JSON.parse(value2)
            this.setState({ data: recibo.recibo })
            this.setState({id_compra: recibo.recibo[0].id_compra})
            this.setState({total: recibo.recibo[0].total })
        }
    }
    _renderItem = ({ item }) => (
        <ReciboRow
            onPressItem={this._onPressItem}
            id_compra={item.id_compra}
            date={item.date}
            precio={item.precio}
            seleccionar={item.seleccionar}
            id_tramite={item.id_tramite}
            tramite={item.tramite}
            total={item.total}
            binder={this.handler}
        />
    );

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
                <View style={[styles.contenido]}>
                    <View style={styles.textoContenido}>
                        <Image style={styles.img} source={require('../src/imgs/flamaAmarilla.png')} />
                        <View>
                            <Text style={styles.boxText}>Folio: {this.state.id_compra} </Text>
                        </View>

                        <View style={styles.lineStyle} />
                        <View>
                            <Text style={styles.total}>Total: ${this.state.total}MXN</Text>
                        </View>
                        <View style={[styles.filaBox]}>
                            <FlatList
                                data={this.state.data}
                                extraData={this.state}
                                keyExtractor={(item, index) => item.id_compra}
                                renderItem={this._renderItem}
                                showsVerticalScrollIndicator={false}
                            />
                        </View>
                    </View>
                </View>
                <View style={[styles.boton]}>
                    <TouchableOpacity onPress={(this._IraMenu)}>
                        <Text style={[styles.aceptar]}>Aceptar</Text>
                    </TouchableOpacity>
                </View>
            </View>
        );
    }
}
export default Recibo;

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
    contenido: {
        height: hp('55%'),
        width: wp('91%'),
        borderTopLeftRadius: 10,
        borderTopRightRadius: 10,
        backgroundColor: 'white',
        flexDirection: 'row',
        marginTop: 30,
    },
    boton: {
        height: hp('10%'),
        width: wp('91%'),
        borderBottomRightRadius: 10,
        borderBottomLeftRadius: 10,
        backgroundColor: '#f2f2f2',
        flexDirection: 'row',
        justifyContent: 'center',
    },
    textoContenido: {
        fontSize: 16,
        marginLeft: 18,
        color: 'black',
        marginTop: 10,
        opacity: 1,
    },
    aceptar: {
        fontSize: 18,
        textAlign: 'center',
        color: '#b3b3b3',
        marginTop: 18,
        opacity: 1,
    },
    filaBox: {
        flexDirection: 'row',
    },
    boxText: {
        height: 30,
        width: wp('81%'),
        flexDirection: 'column',
        fontSize: 14,
        textAlign: 'center',
        color: 'grey',
    },
    total: {
        height: 30,
        width: wp('81%'),
        flexDirection: 'column',
        marginTop: 7,
        marginBottom: 20,
        marginLeft: 5,
        fontSize: 25,
        textAlign: 'center'
    },
    cantidad: {
        height: 30,
        width: wp('5%'),
        flexDirection: 'column',
        fontSize: 14,
        textAlign: 'right',
    },
    lineStyle: {
        borderWidth: .7,
        width: wp('75%'),
        marginLeft: 15,
        marginRight: 15,
        marginBottom: 25,
        borderColor: '#ffd700',
    },
    img: {
        resizeMode: 'contain',
        aspectRatio: 3,
        marginBottom: 3,
        marginTop: 3,

    },

});