import React from 'react';
import {
  StyleSheet,
  Text,
  View,
  Image,
  ActivityIndicator
} from 'react-native';
import Carousel from '../Utils/carrousel';
import { widthPercentageToDP as wp, heightPercentageToDP as hp } from 'react-native-responsive-screen';

class Tutorial extends React.Component {

  render() {
    
    return (
      <Carousel >
        <View>
          <Image source={require("../src/imgs/gifs/intro.gif")} style={styles.imagenPortada} />
        </View>

        <View>
          <Image source={require("../src/imgs/gifs/boleta.gif")} style={styles.imagenPortada} />
        </View>

        <View>
          <Image source={require("../src/imgs/gifs/historialA.gif")} style={styles.imagenPortada} />
        </View>

        <View>
          <Image source={require("../src/imgs/gifs/horario.gif")} style={styles.imagenPortada} />
        </View>

        <View>
          <Image source={require("../src/imgs/gifs/tramites.gif")} style={styles.imagenPortada} />
        </View>

      </Carousel>
    );
  }
}

export default Tutorial;

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  imagenPortada: {
    width: wp (100),
    height: hp (100),
  },

});