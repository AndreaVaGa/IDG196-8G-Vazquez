import React from 'react';
import { Text, View, StyleSheet } from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp} from 'react-native-responsive-screen';
class ReciboRow extends React.Component {

    render() {
        return (
            <View style={styles.container}>
                <View style={styles.filaBox}>
                    <Text style={styles.producto}>{this.props.tramite}</Text>
                    <Text style={styles.precio}>${this.props.precio}MXN</Text>
                </View>
            </View>

        );
    }
}

export default ReciboRow;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginLeft: 15,
    },
    filaBox: {
        flexDirection: 'row',
    },
    producto: {
        height: wp('5%'),
        width: wp('50%'),
        flexDirection: 'column',
        fontSize: 14,
        textAlign: 'center',
    },

});