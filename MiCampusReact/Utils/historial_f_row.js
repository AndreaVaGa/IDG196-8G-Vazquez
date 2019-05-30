import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    TouchableOpacity
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

class HistorialFRow extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            matricula: ''
        };
    }
    _IraRecibo = () => {
        this.props.navigation.navigate('Recibo');
    }

    render() {
        return (
            <View style={styles.container}>

                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                        <Text style={styles.fecha}>{this.props.fecha}</Text>
                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>${this.props.total}</Text>
                        </View>
                        <View style={styles.info}>
                            {/*  <Text style={styles.texto}>Compra #{this.props.id_compra}</Text>*/}
                            <Text style={styles.headers}>Compra #{this.props.id_compra}</Text>
                            <TouchableOpacity onPress={(this._IraRecibo)}>
                                <Text style={[styles.reciboText]}>Ver recibo</Text>
                            </TouchableOpacity>
                        </View>
                    </View>
                </View>

            </View>

        );
    }
}

export default HistorialFRow;

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    fila: {
        marginTop: 30,
        marginLeft: 15,
        flexDirection: 'row',
    },
    seleccionar: {
        justifyContent: 'center',
        height: 110,
        width: wp('25%'),
        borderTopLeftRadius: 10,
        borderBottomLeftRadius: 10,
        backgroundColor: '#00b300',
        flexDirection: 'column',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
    },
    precio: {
        height: 30,
        width: wp('66%'),
        borderTopRightRadius: 10,
        backgroundColor: '#666666',
        flexDirection: 'column',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
    },
    info: {
        height: 80,
        width: wp('66%'),
        borderBottomRightRadius: 10,
        backgroundColor: '#f2f2f2',
        flexDirection: 'column',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
    },
    total: {
        backgroundColor: '#191919',
        bottom: 0,
        position: 'absolute',
        padding: 7,
        width: '100%',
    },
    texto: {
        fontSize: 12,
        textAlign: 'left',
        marginLeft: 18,
        color: '#333333',
        marginTop: 7,
        opacity: 1,
    },
    headersPrecio: {
        fontSize: 14,
        textAlign: 'right',
        marginRight: 15,
        color: 'white',
        marginTop: 7,
    },
    headers: {
        fontSize: 14,
        fontWeight: 'bold',
        textAlign: 'left',
        marginLeft: 18,
        marginRight: 15,
        marginTop: 4,
        color: '#333333',
    },
    reciboText: {
        fontSize: 10,
        fontWeight: 'bold',
        textAlign: 'right',
        marginRight: 18,
        marginTop: 1,
        color: 'grey',
    },
    fecha: {
        fontSize: 14,
        textAlign: 'center',
        color: 'white',
    },
    caja: {
        width: 20,
        height: 20,

    }
});