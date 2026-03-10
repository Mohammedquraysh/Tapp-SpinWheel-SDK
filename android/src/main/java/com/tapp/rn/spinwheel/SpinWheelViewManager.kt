package com.tapp.rn.spinwheel

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.tapp.spinwheel.presentation.view.SpinWheelView

/**
 * React Native ViewManager — bridges the JS component to the native SpinWheelView.
 *
 * When JS renders:
 *   <SpinWheelView configUrl="https://..." />
 *
 * React Native calls getName() to find this manager, creates the view via
 * createViewInstance(), then calls setConfigUrl() with the prop value.
 */
class SpinWheelViewManager : SimpleViewManager<SpinWheelView>() {

    /** Must match requireNativeComponent('SpinWheelView') in index.tsx */
    override fun getName() = "SpinWheelView"

    override fun createViewInstance(context: ThemedReactContext): SpinWheelView =
        SpinWheelView(context)

    /** Receives the configUrl prop from JS and starts the widget. */
    @ReactProp(name = "configUrl")
    fun setConfigUrl(view: SpinWheelView, configUrl: String) {
        view.initialize(configUrl)
    }
}