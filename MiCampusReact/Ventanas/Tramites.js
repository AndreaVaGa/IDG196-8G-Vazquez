import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    ScrollView,
    TouchableOpacity,
    Image
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

export default class Tramites extends React.Component {

  functionOne(){
    // do something
    }
    
    functionTwo(){
    // do someting
    }

    functionCombined() {
      this.functionOne();
      this.functionTwo();
  }

    render() {
        return (
            <View style={styles.container}>
                <View style={styles.fila}>
                <ScrollView style={{marginBottom:50}}>
                    <View style={[styles.seleccionar]}>
                         <View style={[styles.caja, styles.cuadrado]}></View>
                    </View>
                    <View style={[styles.precio]}>
                        <Text style={styles.headersPrecio}>$200</Text>
                    </View>
                    <View style={styles.info}>
                        <Text style={styles.headers}>NOMBRE DEL PAGO</Text>
                        <Text style={styles.texto}>Informacion extra del tramite</Text>
                    </View>
                 </ScrollView>
                </View>
                <View style={styles.total}>
                         <Text style={styles.textPromedio}>Total: $200 
                  <TouchableOpacity>
                  <Image source={require("../src/imgs/pagar.png")} style={styles.boton} />
                </TouchableOpacity></Text>
                </View>
                </View>
                
        );
    }
}

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
        overflow: "hidden",
        justifyContent: 'center',
        height: 100,
        width: wp('15%'),
        borderTopLeftRadius: 10,
        borderBottomLeftRadius: 10,
        backgroundColor: '#ffffff',
        flexDirection: 'column',
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.8,
        shadowRadius: 2,
        elevation: 4,
    },
    precio: {
        overflow: "hidden",
        height: 30,
        width: wp('70%'),
        borderTopRightRadius: 10,
        backgroundColor: '#666666',
        flexDirection: 'column',
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.8,
        shadowRadius: 2,
        elevation: 4,
    },
    info: {
        overflow: "hidden",
        height: 70,
        width: wp('70%'),
        borderBottomRightRadius: 10,
        backgroundColor: '#f2f2f2',
        flexDirection: 'column',
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.8,
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
    textPromedio: { 
      color: 'white', 
      fontWeight: 'bold', 
      fontSize: 18, 
      textAlign: 'center', 
      marginTop: 3,
      marginBottom: 20, 
    },
    texto: {
        fontSize: 12,
        textAlign: 'left',
        marginLeft: 18,
        color: '#333333',
        marginTop: 2,
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
        marginTop: 15,
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
    boton: { 
      marginLeft: 25,
      height: 10,
      },
});