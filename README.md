# Tapp-SpinWheel-SDK
A Kotlin Android spin wheel UI component that fetches remote JSON configuration and PNG assets from Google Drive, renders a fully animated spin wheel, and exposes the component to React Native as an installable .tgz package.


Table of Contents

1.Overview
2.Project Structure
3.Architecture
4.Prerequisites
5.Quick Start
6.Configuration
7.Google Drive Asset Setup
8.Running the Android Demo App
9.React Native Integration
10.Running the React Native Demo App
11.Caching Strategy
12.Deliverables


Overview
The SpinWheel SDK provides a single SpinWheelView component that:

Fetches a remote JSON configuration file
Downloads 4 PNG image assets from Google Drive
Renders a spin wheel UI using those assets
Animates the wheel when the user taps the spin button
Caches the config and assets locally for offline use
Persists the last fetch timestamp in SharedPreferences


Project Structure
Spinwheelsdk/
├── app/                        => Android demo app (open in Android Studio)
├── spinwheel-library/          => The reusable SDK (open in Android Studio)
├── spinwheel-rn-wrapper/       => React Native npm package (open in VS Code)
├── demo-app/                   => React Native demo app (open in VS Code)
├── sample_config.json         
├── SETUP.md                    => Step-by-step setup guide

What opens where
Folder                 Tool     
Spinwheelsdk/root      Android Studio — File => Open
spinwheel-library/     Android Studio — shown automatically
app/                   Android Studio — shown automatically
spinwheel-rn-wrapper/  VS Code or Android Studio Project view
demo-app/              VS Code or Android Studio Project view

Architecture
The library uses MVVM + Clean Architecture with three layers:
Presentation  =>  SpinWheelView + SpinWheelViewModel
Domain        =>  WidgetConfig, UseCases, Repository interface
Data          =>  RemoteDataSource (OkHttp) + LocalDataSource (SharedPreferences + CBOR)

Key decisions:
No Hilt — uses a Service Locator so consumers need zero DI configuration
No Jetpack Compose — uses android.view.View subclasses for React Native compatibility
OkHttp for all networking with exponential back-off retry
kotlinx-serialization-json for JSON parsing
kotlinx-serialization-cbor for binary disk cache (~30% smaller than JSON)
SharedPreferences for timestamps and metadata only (never large blobs)


Prerequisites

Android Studio Hedgehog or later
Android SDK 34
Kotlin 1.9.23
Node.js 18+ and npm (for RN wrapper and demo app)
A device or emulator running Android API 24+
