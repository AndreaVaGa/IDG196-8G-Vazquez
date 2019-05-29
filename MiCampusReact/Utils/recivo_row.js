import React from 'react';
import {
    Text,
    View,
    StyleSheet
} from 'react-native';

class RecivoRow extends React.Component {
    
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
  
export default RecivoRow;
