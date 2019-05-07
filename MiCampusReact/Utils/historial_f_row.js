import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    ScrollView,
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

class HistorialFRow extends React.Component {

    _IraRecibo = () => {
        this.props.navigation.navigate('Recibo');
      }

    render() {
        return (
            <View style={styles.container}>
            <ScrollView style={{marginBottom:50}}>

                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>$165</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.texto}>Credenciales</Text>
                            <Text style={styles.headers}>Duplicado de credencial de estudiante</Text>
                        </View>
                    </View>
                </View>
                
                </ScrollView>
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
        marginBottom: 5,
        flexDirection: 'row',
    },
    seleccionar: {
        justifyContent: 'center',
        height: 100,
        width: wp('15%'),
        borderTopLeftRadius: 10,
        borderBottomLeftRadius: 10,
        backgroundColor: '#ffffff',
        flexDirection: 'column',
        shadowColor: 'grey',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.9,
        shadowRadius: 2,
        elevation: 4,
    },
    precio: {
        height: 30,
        width: wp('76%'),
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
        height: 70,
        width: wp('76%'),
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
      caja: {
        width: 20,
        height: 20,

      },
    cuadrado: {
        position: 'absolute',
        backgroundColor: '#e6e6e6',
        marginLeft: 20,
    },
    palomita: {
        height: 100,
      justifyContent: 'center',
      alignItems: 'center',
    },
});