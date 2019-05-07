import React from 'react';
import {
    Text,
    View,
    StyleSheet,
    TouchableOpacity,
    Image,
    RefreshControl
} from 'react-native';
import { CheckBox } from 'react-native-elements';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

global.sumaTramites = 0;

class TramitesRow extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            checked: false,
            price: 100
        };
    }

    _changeValue = () => {

        this.setState({ checked: !this.state.checked })
        if (this.state.checked) {
            global.sumaTramites -= this.state.price;

        }
        else {
            global.sumaTramites += this.state.price;
        }
        this.props.binder(global.sumaTramites)
    }

    _onPress = () => {
        this._changeValue()
    };


    render() {
        return (
            <View style={styles.container}>

                <View style={styles.fila}>
                    <View style={[styles.seleccionar]}>
                        <CheckBox center checked={this.state.checked} onPress={this._onPress} />
                    </View>
                    <View>
                        <View style={[styles.precio]}>
                            <Text style={styles.headersPrecio}>${this.state.price}</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.texto}>Credenciales</Text>
                            <Text style={styles.headers}>Duplicado de credencial de estudiante</Text>
                        </View>
                    </View>
                </View>

            </View>

        );
    }
}

export default TramitesRow;

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