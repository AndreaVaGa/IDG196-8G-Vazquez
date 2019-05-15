import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    TouchableOpacity,
    TextInput
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

class Pago extends React.Component {

    _IraRecibo = () => {
        this.props.navigation.navigate('Recibo');
      }
      
    render() {
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
                                    />
                                </View>
                                <View style={[styles.boxEC]}>
                                    <TextInput style={[styles.boxECInterno]}
                                    placeholder="Expira"
                                    placeholderTextColor='grey'
                                    />
                                    <TextInput style={[styles.boxECInterno]}
                                    placeholder="CVV"
                                    placeholderTextColor='grey'
                                    />
                                </View>
                                
                                <TouchableOpacity style={[styles.box]} onPress={(this._IraRecibo)}>
                                    <Text style={[styles.boxText]} >Pagar ${global.sumaTramites}MXN</Text>
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
        borderTopLeftRadius: 10,
        borderTopRightRadius: 10,
        borderBottomRightRadius: 10,
        borderBottomLeftRadius: 10,
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
        height: 30,
        width: wp('81%'),
        flexDirection: 'column',
        justifyContent: 'center',
        marginTop: 30,
        marginBottom: 10,
        fontSize: 22,
    },
    boxEC: {
        marginTop: 20,
        marginBottom: 30,
        flexDirection: 'row',
    },
    boxECInterno: {
        height: 30,
        width: wp('35%'),
        flexDirection: 'column',
        fontSize: 22,
    },
    
});