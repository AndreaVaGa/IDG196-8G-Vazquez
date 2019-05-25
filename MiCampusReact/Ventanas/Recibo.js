import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    TouchableOpacity,
    TextInput
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

class Recibo extends React.Component {

    _IraHistorialF = () => {
        this.props.navigation.navigate('HistorialFinanciero');
    }

    render() {
        return (
            <View style={styles.container}>
                <View style={[styles.contenido]}>
                    <View style={styles.textoContenido}>
                        <View>
                            <Text style={styles.boxText}>Folio: {global.sumaTramites}</Text>
                        </View>

                        <View style={styles.lineStyle} />

                        <View>
                            <Text style={styles.total}>Total: ${global.sumaTramites}MXN</Text>
                        </View>
                        <View style={[styles.filaBox]}>
                            <Text style={styles.cantidad}>{global.sumaTramites}</Text>
                            <Text style={styles.producto}>Nombre del servicio</Text>
                            <Text style={styles.precio}>${global.sumaTramites}MXN</Text>
                        </View>
                    </View>
                </View>
                <View style={[styles.boton]}>
                    <TouchableOpacity onPress={(this._IraHistorialF)}>
                        <Text style={[styles.aceptar]}>Aceptar</Text>
                    </TouchableOpacity>
                </View>
            </View>
        );
    }
}
export default Recibo;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginLeft: 15
    },
    contenido: {
        height: 350,
        width: wp('91%'),
        borderTopLeftRadius: 10,
        borderTopRightRadius: 10,
        backgroundColor: 'white',
        flexDirection: 'row',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
        marginTop: 30,
    },
    boton: {
        height: 60,
        width: wp('91%'),
        borderBottomRightRadius: 10,
        borderBottomLeftRadius: 10,
        backgroundColor: '#f2f2f2',
        flexDirection: 'row',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
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
    },
    cantidad: {
        height: 30,
        width: wp('5%'),
        flexDirection: 'column',
        fontSize: 18,
        textAlign: 'right',
    },
    producto: {
        height: 30,
        width: wp('50%'),
        flexDirection: 'column',
        fontSize: 18,
        textAlign: 'center',
    },
    precio: {
        height: 30,
        width: wp('20%'),
        flexDirection: 'column',
        textAlign: 'right',
        fontSize: 18,
    },
    lineStyle: {
        borderWidth: .7,
        width: wp('75%'),
        marginLeft: 15,
        marginRight: 15,
        marginBottom: 25,
        borderColor: '#ffd700',
    },

});