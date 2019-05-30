import React from 'react';
import { Text, View, StyleSheet } from 'react-native';
import { widthPercentageToDP as wp } from 'react-native-responsive-screen';
class ReciboRow extends React.Component {

    render() {
        return (
            <View style={styles.container}>
                <View style={styles.filaBox}>
                    <Text style={styles.cantidad}>1</Text>
                    <Text style={styles.producto}>{this.props.tramite}</Text>
                    <Text style={styles.precio}>${this.props.precio}MXN</Text>
                </View>
            </View>

        );
    }
}

export default ReciboRow;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginLeft: 15,

    },
    contenido: {
        height: 400,
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
        textAlign: 'center'
    },
    cantidad: {
        height: 30,
        width: wp('5%'),
        flexDirection: 'column',
        fontSize: 14,
        textAlign: 'right',
    },
    producto: {
        height: 30,
        width: wp('50%'),
        flexDirection: 'column',
        fontSize: 14,
        textAlign: 'center',
    },
    precio: {
        height: 30,
        width: wp('20%'),
        flexDirection: 'column',
        textAlign: 'right',
        fontSize: 14,
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