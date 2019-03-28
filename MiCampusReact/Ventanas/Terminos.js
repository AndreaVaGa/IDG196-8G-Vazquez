import React from 'react';
import { StyleSheet, View, Text, AsyncStorage, ScrollView, screenWidth } from 'react-native';

export default class Terminos extends React.Component {
  render() {
    return (
      <ScrollView style={styles.container}>
        <Text style={styles.titles}>Terminos: </Text>
        <View style={styles.lineStyle} />
        <Text style={styles.texto}>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
        exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute 
        irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
        pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
        deserunt mollit anim id est laborum.

        </Text>
        <Text style={styles.titles}>Privacidad: </Text>
        <View style={styles.lineStyle} />
        <Text style={styles.texto}>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
        exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute 
        irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
        pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
        deserunt mollit anim id est laborum.

        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
        exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute 
        irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
        pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
        deserunt mollit anim id est laborum.
        </Text>
      </ScrollView>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: 'white',
  },
  titles: {
    justifyContent: 'center',
    marginTop: 25,
    marginLeft: 30,
    marginRight: 30,
    fontSize: 30
  },
  texto: {
    justifyContent: 'center',
    fontSize: 14,
    marginLeft: 30,
    marginRight: 30,
  },
  lineStyle: {
    borderWidth: 1,
    width: screenWidth,
    borderColor: '#ffd700',
    marginTop: 15,
    marginLeft: 30,
    marginRight: 30,
  },
});

