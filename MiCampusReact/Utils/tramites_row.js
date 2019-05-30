import React from 'react';
import { Text, View, StyleSheet } from 'react-native';
import { CheckBox } from 'react-native-elements';
import { widthPercentageToDP as wp } from 'react-native-responsive-screen';

global.sumaTramites = 0;
global.listaTramites = [null];
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
            global.sumaTramites -= this.props.precio;
            for (var i = 0; i < global.listaTramites.length; i++) {
                if (global.listaTramites[i] == this.props.id) {
                    global.listaTramites.splice(i, 1)
                }
            }
        }
        else {
            global.sumaTramites += this.props.precio;
            global.listaTramites.unshift(this.props.id)


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
                            <Text style={styles.headersPrecio}>${this.props.precio}</Text>
                        </View>
                        <View style={styles.info}>
                            <Text style={styles.headers}>{this.props.nombre}</Text>
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
        flexDirection: 'row',
    },
    seleccionar: {
        justifyContent: 'center',
        height: 110,
        width: wp('25%'),
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
    caja: {
        width: 20,
        height: 20,
    }
});