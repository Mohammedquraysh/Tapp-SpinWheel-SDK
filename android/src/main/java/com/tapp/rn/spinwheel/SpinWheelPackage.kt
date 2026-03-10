package com.tapp.rn.spinwheel

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager

/**
 * Registers SpinWheelViewManager with the React Native runtime.
 *
 * Add this to your app's MainApplication.kt:
 *   override fun getPackages() = listOf(
 *       MainReactPackage(),
 *       SpinWheelPackage()   ← add this line
 *   )
 */
class SpinWheelPackage : ReactPackage {
    override fun createViewManagers(ctx: ReactApplicationContext): List<ViewManager<*, *>> =
        listOf(SpinWheelViewManager())

    override fun createNativeModules(ctx: ReactApplicationContext): List<NativeModule> =
        emptyList()
}