import React from 'react';
import { AsyncStorage } from 'react-native';
import { createStackNavigator, } from 'react-navigation';
import Login from './Ventanas/Login';
import Boleta from './Ventanas/Boleta';
import Historial from './Ventanas/Historial';
import Horario from './Ventanas/Horario';
import Perfil from './Ventanas/Perfil';
import Tutores from './Ventanas/Tutores';
import Fondo from './Ventanas/Fondo';
import Terminos from './Ventanas/Terminos';
import Configuracion from './Ventanas/Configuracion';
import Menu from './Ventanas/Menu';
import Tramites from './Ventanas/Tramites';


Expo.ScreenOrientation.allow(Expo.ScreenOrientation.Orientation.PORTRAIT);

const MiCampus = createStackNavigator({
  Login: { screen: Login, navigationOptions: { header: null, } },
  Boleta: {
    screen: Boleta, navigationOptions: {
      headerStyle: {
        backgroundColor: 'black',
      }, headerTitleStyle: {
        color: 'white',
        fontWeight: 'bold',
      },
      title: 'Boleta',
      headerTintColor: 'white',
    }
  },
  Horario: {
    screen: Horario, navigationOptions: {
      title: 'Horario', headerStyle: {
        backgroundColor: 'black',
      }, headerTitleStyle: {
        color: 'white',
        fontWeight: 'bold',
      },
      headerTintColor: 'white',
    }
  },
  Historial: {
    screen: Historial, navigationOptions: {
      title: 'Historial',
      headerStyle: {
        backgroundColor: 'black',
      },
      headerTitleStyle: {
        color: 'white',
        fontWeight: 'bold',
      },
      headerTintColor: 'white',
    }
  },
  Perfil: {
    screen: Perfil, navigationOptions: {
      title: 'Perfil',
      headerStyle: {
        backgroundColor: 'black',
      }, headerTitleStyle: {
        color: 'white',
        fontWeight: 'bold',
      },
      headerTintColor: 'white',
    }
  },
  Tutores: {
    screen: Tutores, navigationOptions: {
      title: 'Tutores',
      headerStyle: {
        backgroundColor: 'black',
      }, headerTitleStyle: {
        color: 'white',
        fontWeight: 'bold',
      },
      headerTintColor: 'white',
    }
  },
  Fondo: {
    screen: Fondo, navigationOptions: {
      title: 'Fondo',
      headerStyle: {
        backgroundColor: 'black',
      }, headerTitleStyle: {
        color: 'white',
        fontWeight: 'bold',
      },
      headerTintColor: 'white',
    }
  },
  Terminos: {
    screen: Terminos, navigationOptions: {
      title: 'Terminos y privacidad',
      headerStyle: {
        backgroundColor: 'black',
      }, headerTitleStyle: {
        color: 'white',
        fontWeight: 'bold',
      },
      headerTintColor: 'white',
    }
  },
  Tramites: {
    screen: Tramites, navigationOptions: {
      title: 'Tramites',
      headerStyle: {
        backgroundColor: 'black',
      }, headerTitleStyle: {
        color: 'white',
        fontWeight: 'bold',
      },
      headerTintColor: 'white',
    }
  },
  Configuracion: {
    screen: Configuracion, navigationOptions: {
      title: 'Configuración',
      headerStyle: {
        backgroundColor: 'black',
      }, headerTitleStyle: {
        color: 'white',
        fontWeight: 'bold',
      },
      headerTintColor: 'white',
    }
  },
  Menu: {
    screen: Menu, navigationOptions: { header: null, }
  }
});
export default class App extends React.Component {
  constructor(props) {
    super(props);

  }
  _LogOut = () => {
    AsyncStorage.removeItem('usuario')
    this.props.navigation.navigate('Login');

  }
  render() {
    return (
      <MiCampus />
    );
  }
}
