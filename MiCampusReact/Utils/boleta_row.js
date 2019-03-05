import React from 'react';
import {
    Text,
    View,
    TouchableOpacity,
    StyleSheet
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

class BoletaRow extends React.PureComponent {
    constructor(props) {
        super(props)
        this.state = {
            collapsed: true
        };
    }
    _changeHeight = () => {
        if (this.state.collapsed) {
            this._height.setNativeProps({ height: 200 });
            this._height2.setNativeProps({ height: 200 });
            this._height3.setNativeProps({ height: 200 });
        }
        else {
            this._height.setNativeProps({ height: 100 });
            this._height2.setNativeProps({ height: 100 });
            this._height3.setNativeProps({ height: 100 });
        }
        this.state.collapsed = !this.state.collapsed;
    }

    //se llama la funcion desde el renglon individualmente
    _onPress = () => {
        this._changeHeight()
        //this.props.onPressItem(this.props.materia);
    };

    render() {
        return (
            <TouchableOpacity onPress={this._onPress}>
                <View style={styles.fila}>
                    <View style={[styles.materia, { alignItems: 'center' }]} ref={component => this._height = component}>
                        <Text style={[styles.headers, { marginTop: 20, fontSize: 15 }]}>{this.props.materia}</Text>
                        <Text style={styles.texto}>{this.props.profesor}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: 100 }]}>Parcial 1</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: 130 }]}>Parcial 2</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: 160 }]}>Parcial 3</Text>
                    </View>
                    <View style={[styles.faltas, { alignItems: 'center' }]} ref={component => this._height2 = component}>
                        <Text style={styles.headers}>F</Text>
                        <Text style={styles.texto}>{this.props.faltas}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: 100 }]}>{this.props.faltas1}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: 130 }]}>{this.props.faltas2}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: 160 }]}>{this.props.faltas3}</Text>
                    </View>
                    <View style={styles.promedio} ref={component => this._height3 = component}>
                        <Text style={styles.headers}>P</Text>
                        <Text style={styles.texto}>{this.props.calif}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: 100 }]}>{this.props.calif1}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: 130 }]}>{this.props.calif2}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: 160 }]}>{this.props.calif3}</Text>
                    </View>
                </View>
            </TouchableOpacity>
        );

    }
}

export default BoletaRow;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginBottom: 50,
    },
    fila: {
        marginTop: 30,
        marginLeft: 22,
        flexDirection: 'row',
    },
    materia: {
        overflow: "hidden",
        height: 100,
        width: wp('58%'),
        borderTopLeftRadius: 10,
        borderBottomLeftRadius: 10,
        backgroundColor: '#F5F5F5',
        flexDirection: 'column',
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.8,
        shadowRadius: 2,
        elevation: 4,
    },
    faltas: {
        overflow: "hidden",
        height: 100,
        width: wp('15%'),
        backgroundColor: '#ffffff',
        flexDirection: 'column',
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.8,
        shadowRadius: 2,
        elevation: 4,
    },
    promedio: {
        overflow: "hidden",
        height: 100,
        width: wp('15%'),
        borderTopRightRadius: 10,
        borderBottomRightRadius: 10,
        backgroundColor: '#ffffff',
        flexDirection: 'column',
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.8,
        shadowRadius: 2,
        elevation: 4,
    },
    headers: {
        fontSize: 20,
        textAlign: 'center',
        marginTop: 15,
    },
    texto: {
        fontSize: 12,
        textAlign: 'center',
        color: '#333333',
        margin: 7,
        opacity: 1,
    }
});
