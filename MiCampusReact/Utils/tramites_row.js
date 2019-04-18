import React from 'react';
import {
    Text,
    View,
    StyleSheet
} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

class TramitesRow extends React.PureComponent {
    render() {
        return (
                <View style={styles.fila}>
                    <View style={[styles.materia, { alignItems: 'center' }]} ref={component => this._height = component}>
                        <Text style={[styles.headers, { marginTop: 20, fontSize: 15 }]}>{this.props.materia}</Text>
                        <Text style={styles.texto}>{this.props.profesor}</Text>
                    </View>
                    <View style={[styles.faltas, { alignItems: 'center' }]} ref={component => this._height2 = component}>
                        <Text style={styles.headers}>F</Text>
                        <Text style={styles.texto}>{this.props.faltas}</Text>
                    </View>
                    <View style={styles.promedio} ref={component => this._height3 = component}>
                        <Text style={styles.headers}>P</Text>
                        <Text style={styles.texto}>{this.props.calif}</Text>
                    </View>
                </View>
        );

    }
}

export default TramitesRow;

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
