import React from 'react';
import { StyleSheet, View, Image, screenWidth} from 'react-native';
import { widthPercentageToDP as wp, heightPercentageToDP as hp} from 'react-native-responsive-screen';
import Carousel from '../Utils/carrousel';

class Tutorial extends React.Component {

  render() {

    return (
      <Carousel >
        <View>
        <View style={styles.cuadro}></View>
        <Image source={require("../src/imgs/gifs/intro.gif")} style={styles.imagenPortada}></Image>
        </View>

        <View>
        <View style={styles.cuadro}></View>
          <Image source={require("../src/imgs/gifs/boleta.gif")} style={styles.imagenPortada} />
        </View>

        <View>
        <View style={styles.cuadro}></View>
          <Image source={require("../src/imgs/gifs/historialA.gif")} style={styles.imagenPortada} />
        </View>

        <View>
        <View style={styles.cuadro}></View>
          <Image source={require("../src/imgs/gifs/horario.gif")} style={styles.imagenPortada} />
        </View>

        <View>
        <View style={styles.cuadro}></View>
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
  cuadro: {
    width: screenWidth,
    height: hp('5%'),
    backgroundColor: '#fdcc01',
    alignItems: 'center',
    justifyContent: 'flex-end',
  },
  imagenPortada: {
    width: screenWidth,
    height: hp('90%'),
    alignItems: 'center',
    justifyContent: 'flex-end',

  },

});