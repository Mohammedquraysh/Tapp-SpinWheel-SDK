import React from 'react';
import { requireNativeComponent, ViewStyle } from 'react-native';

/**
 * Props exposed to React Native JavaScript.
 */
export interface SpinWheelViewProps {
  /** URL of the remote JSON config file. */
  configUrl: string;
  style?: ViewStyle;
  /** Called after each spin animation completes. */
  onSpinComplete?: () => void;
  /** Called when the widget encounters an error. */
  onError?: (event: { nativeEvent: { message: string } }) => void;
}

/**
 * Links this TypeScript component to SpinWheelViewManager.kt on the Android side.
 * The string 'SpinWheelView' must match getName() in the ViewManager.
 */
const NativeSpinWheelView =
  requireNativeComponent<SpinWheelViewProps>('SpinWheelView');

/**
 * Drop-in React Native component that renders the native SpinWheelView.
 *
 * Usage:
 *   import { SpinWheelView } from '@tapp/react-native-spinwheel';
 *
 *   <SpinWheelView
 *     configUrl="https://yourserver.com/config.json"
 *     style={{ flex: 1 }}
 *     onSpinComplete={() => console.log('Spin done!')}
 *     onError={(e) => console.error(e.nativeEvent.message)}
 *   />
 */
export const SpinWheelView: React.FC<SpinWheelViewProps> = (props) => (
  <NativeSpinWheelView {...props} />
);

export default SpinWheelView;