import React from 'react';
import { Text, View, StyleSheet, TouchableOpacity } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp} from 'react-native-responsive-screen';

class HistorialFRow extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            matricula: ''
        };
    }

    _IraRecibo = () => {
        this.props.binder(true, this.props.id_compra)
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
                            <Text style={styles.headers}>Compra #{this.props.id_compra}</Text>
                            <Text style={styles.texto}>{this.props.descripcion}...</Text>
                        </View>
                        <View style={styles.reciboTabla}>
                            <TouchableOpacity onPress={this._IraRecibo}>
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
        height: hp('16%'),
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
        height: hp('3%'),
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
        height: hp('10%'),
        width: wp('66%'),
        backgroundColor: '#f2f2f2',
        flexDirection: 'column',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
    },
    reciboTabla: {
        height: hp('3%'),
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
        padding: 5,
        width: '100%',
    },
    texto: {
        fontSize: 12,
        textAlign: 'left',
        marginLeft: 15,
        marginRight: 15,
        color: '#333333',
        marginTop: 5,
        opacity: 1,
    },
    headersPrecio: {
        fontSize: 12,
        textAlign: 'right',
        marginRight: 15,
        color: 'white',
        marginTop: 2,
    },
    headers: {
        fontSize: 12,
        fontWeight: 'bold',
        textAlign: 'left',
        marginLeft: 15,
        marginRight: 15,
        marginTop: 4,
        color: '#333333',
    },
    reciboText: {
        fontSize: 10,
        fontWeight: 'bold',
        textAlign: 'right',
        marginRight: 15,
        color: 'grey',
    },
    fecha: {
        fontSize: 11,
        textAlign: 'center',
        color: 'white',
    },
    caja: {
        width: 20,
        height: 20,
    }
});