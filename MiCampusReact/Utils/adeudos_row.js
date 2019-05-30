import React from 'react';
import { Text, View, StyleSheet, TouchableOpacity } from 'react-native';
import { widthPercentageToDP as wp } from 'react-native-responsive-screen';

class AdeudosRow extends React.Component {

    _IraRecibo = () => {
        this.props.navigation.navigate('Recibo');
    }

    render() {
        return (
            <View style={styles.container}>

                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>

                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>$ 100 MXN</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.texto}>Credenciales</Text>
                            <Text style={styles.headers}>Duplicado de credencial de estudiante</Text>
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

export default AdeudosRow;

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
        backgroundColor: 'green',
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
        marginTop: 4,
        color: 'grey',
    },
    caja: {
        width: 20,
        height: 20,

    }
});