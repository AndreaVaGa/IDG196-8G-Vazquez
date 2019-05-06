import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    ScrollView,
    TouchableOpacity,
    Image,
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

class Pago extends React.Component {
    render() {
        return (
            <View style={styles.container}>
                    <View style={[styles.precioTotal]}>
                    <Text style={styles.textoPrecio}>$165 MXN</Text>
                    </View>
                    <View>
                        <View style={[styles.contenido]}>
                            <Text style={styles.textoContenido}>$165</Text>
                            <View style={[styles.box]}>
                                <Text style={[styles.boxText]}>Pagar $165.00 MXN</Text>
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
    container: {
        flex: 1,
        marginLeft: 15,
    },
    precioTotal: {
        marginTop: 30,
        height: 70,
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
    },
    textoPrecio: {
        fontSize: 24,
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
        marginRight: 18,
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
        borderTopLeftRadius: 10,
        borderTopRightRadius: 10,
        borderBottomRightRadius: 10,
        borderBottomLeftRadius: 10,
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
        backgroundColor: 'yellow',
    },
    boxText: {
        fontSize: 18,
        textAlign: 'center',
        marginLeft: 15,
        marginRight: 15,
        marginTop: 10,
        marginBottom: 10,
        color: '#333333',
    },
    
});