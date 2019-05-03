import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    ScrollView,
    TouchableOpacity,
    Image
} from 'react-native';
import { CheckBox } from 'react-native-elements';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

export default class Tramites extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            checked:false
        };
    }

    _IraPago = () => {
        this.props.navigation.navigate('Pago');
      }
   
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

            <ScrollView style={{marginBottom:50}}>

                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                    <CheckBox center checked={this.state.checked} onPress={() => this.setState({checked: !this.state.checked})} />
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
                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                         <CheckBox center checked={this.state.checked} onPress={() => this.setState({checked: !this.state.checked})} />
                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>$65</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.texto}>Escolares (español)</Text>
                            <Text style={styles.headers}>Carta para servicios médicos</Text>
                        </View>
                    </View>
                </View>
                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                         <CheckBox center checked={this.state.checked} onPress={() => this.setState({checked: !this.state.checked})} />
                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>$65</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.texto}>Escolares (español)</Text>
                            <Text style={styles.headers}>Constancia de estudios (sin calificaciones)</Text>
                        </View>
                    </View>
                </View>
                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                         <CheckBox center checked={this.state.checked} onPress={() => this.setState({checked: !this.state.checked})} />
                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>$65</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.texto}>Escolares (español)</Text>
                            <Text style={styles.headers}>Carta de calificaciones</Text>
                        </View>
                    </View>
                </View>
                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                         <CheckBox center checked={this.state.checked} onPress={() => this.setState({checked: !this.state.checked})} />
                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>$870</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.texto}>Escolares (español)</Text>
                            <Text style={styles.headers}>Trámite de cambio de carrera y/o maestría (convalidación de estudios)</Text>
                        </View>
                    </View>
                </View>
                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                         <CheckBox center checked={this.state.checked} onPress={() => this.setState({checked: !this.state.checked})} />
                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>$60</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.texto}>Escolares (español)</Text>
                            <Text style={styles.headers}>Historial académico de profesional</Text>
                        </View>
                    </View>
                </View>
                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                         <CheckBox center checked={this.state.checked} onPress={() => this.setState({checked: !this.state.checked})} />
                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>$65</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.texto}>Escolares (ingles)</Text>
                            <Text style={styles.headers}>Constancia de estudios en ingles (sin calificaciones)</Text>
                        </View>
                    </View>
                </View>

                </ScrollView>

                <View style={styles.total}>
                         <Text style={styles.textPromedio}>Total: $200 
                         <TouchableOpacity onPress={(this._IraConfiguracion)}>
                            <Image source={require("../src/imgs/pagar.png")} style={styles.boton} onPress={(this._IraPago)}></Image>
                        </TouchableOpacity>
                     </Text>
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
    boton: { 
      marginLeft: 25,
      height: 10,
      },
});