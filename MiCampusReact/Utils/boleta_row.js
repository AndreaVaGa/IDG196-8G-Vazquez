import React from 'react';
import { Text, View, TouchableOpacity, StyleSheet } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp} from 'react-native-responsive-screen';

class BoletaRow extends React.PureComponent {
    constructor(props) {
        super(props)
        this.state = {
            collapsed: true
        };
    }
    _changeHeight = () => {
        if (this.state.collapsed) {
            this._height.setNativeProps({ height: hp('30%') });
            this._height2.setNativeProps({ height: hp('30%') });
            this._height3.setNativeProps({ height: hp('30%') });
        }
        else {
            this._height.setNativeProps({ height: hp('16%') });
            this._height2.setNativeProps({ height: hp('16%') });
            this._height3.setNativeProps({ height: hp('16%') });
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
                        <Text style={[styles.texto, { position: 'absolute', top: hp('16%') }]}>Parcial 1</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: hp('20%') }]}>Parcial 2</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: hp('24%') }]}>Parcial 3</Text>
                    </View>
                    <View style={[styles.faltas, { alignItems: 'center' }]} ref={component => this._height2 = component}>
                        <Text style={styles.headers}>F</Text>
                        <Text style={styles.texto}>{this.props.faltas}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: hp('16%') }]}>{this.props.faltas1}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: hp('20%') }]}>{this.props.faltas2}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: hp('24%') }]}>{this.props.faltas3}</Text>
                    </View>
                    <View style={styles.promedio} ref={component => this._height3 = component}>
                        <Text style={styles.headers}>P</Text>
                        <Text style={styles.texto}>{this.props.calif}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: hp('16%') }]}>{this.props.calif1}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: hp('20%') }]}>{this.props.calif2}</Text>
                        <Text style={[styles.texto, { position: 'absolute', top: hp('24%') }]}>{this.props.calif3}</Text>
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
        marginLeft: 15,
        flexDirection: 'row',
    },
    materia: {
        overflow: "hidden",
        height: hp('16%'),
        width: wp('61%'),
        borderTopLeftRadius: 10,
        borderBottomLeftRadius: 10,
        backgroundColor: '#F5F5F5',
        flexDirection: 'column',
    },
    faltas: {
        overflow: "hidden",
        height: hp('16%'),
        width: wp('15%'),
        backgroundColor: '#ffffff',
        flexDirection: 'column',
    },
    promedio: {
        overflow: "hidden",
        height: hp('16%'),
        width: wp('15%'),
        borderTopRightRadius: 10,
        borderBottomRightRadius: 10,
        backgroundColor: '#ffffff',
        flexDirection: 'column',
    },
    headers: {
        fontSize: 20,
        textAlign: 'center',
        marginTop: 15,
        marginLeft: 5,
        marginRight: 5,
    },
    texto: {
        fontSize: 12,
        textAlign: 'center',
        color: '#333333',
        margin: 7,
        opacity: 1,
    }
});
