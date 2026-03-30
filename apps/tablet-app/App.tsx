import { StyleSheet, Text, View } from 'react-native';

import { StatusBar } from 'expo-status-bar';

import {
  NATIVE_PI,
  getBatteryLevel,
  checkIsConnected,
  fetchNetworkInfo,
  subscribeToNetworkChanges,
} from '../../packages/data-sync';
import { useEffect, useState } from 'react';



export default function App() {
  const [statusNetwork, setStatusNetwork] = useState<string>('');
  const [typeNetwork, setTypeNetwork] = useState<string>('');

  useEffect(() => {

    subscribeToNetworkChanges((event) => {
      setStatusNetwork(event.isConnected ? 'connected' : 'disconnected')
      setTypeNetwork(event.type)
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text>The Native PI value: {NATIVE_PI}</Text>
      <Text>The BatteryLevel: {getBatteryLevel()}</Text>
      <Text>Check is Connect: {checkIsConnected()}</Text>
      <Text>The status network: {statusNetwork}</Text>
      <Text>The type netwotk: {typeNetwork}</Text>

      <StatusBar style='auto' />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center'
  }
});
