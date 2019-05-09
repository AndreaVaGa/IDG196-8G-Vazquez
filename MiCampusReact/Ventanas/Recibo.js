import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    TouchableOpacity,
    TextInput,
    Image
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

class Recibo extends React.Component {
    render() {
        return (
            <View style={styles.container}>
                    <View style={[styles.fila]}>
                    <Text style={styles.textoPrecio}>${global.sumaTramites}MXN</Text>
                    </View>
                    <View>
                        <View style={[styles.contenido]}>
                            <View style={styles.textoContenido}>
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
export default Recibo;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginLeft: 15,
    },
    fila: {
        marginTop: 30,
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
    
});