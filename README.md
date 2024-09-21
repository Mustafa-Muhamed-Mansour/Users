# Table of content
1. [Users](#users)
2. [Screenshots](#screenshots)
3. [Structure Project](#structure-project)
4. [Build With](#build-with)

# 🧑Users

Are a collection of users contains of name, image, type of gender, email's user, phone and age's user.


# 📸Screenshots

## 📱Mobile
<img src = "https://github.com/user-attachments/assets/58013d31-e71f-4fe8-beba-5a6534d64509" width = "200" height = "400">  <img src = "https://github.com/user-attachments/assets/7fe156f1-b6cf-41c7-85af-c1ecd689f266" width = "200" height = "400">
<img src = "https://github.com/user-attachments/assets/82bfe022-aadf-4fed-9c0b-b095a5f3f129" width = "200" height = "400">  

## 🖥️Desktop
<img src = "https://github.com/user-attachments/assets/9f2c7dfa-79b3-4c1c-863d-618babae5582" width = "800" height = "600"> <img src = "https://github.com/user-attachments/assets/3be3f18b-fd92-4487-af83-f17e6d2aeb18" width = "800" height = "600">
<img src = "https://github.com/user-attachments/assets/57d65450-ac52-470a-882d-6e16e8b9ef13" width = "800" height = "600">  


# Structure project

## (🥴MVVM without clean architecture)
<img src = "https://github.com/user-attachments/assets/ed2cef85-acf0-4b20-9d56-d4e12a088fdb" width = "700" height = "600">

## (🫡MVVM with clean architecture)
<img src = "https://github.com/user-attachments/assets/162c03ae-5294-4372-801e-31d9d0aa98b5" width = "900" height = "600">


# 🧑🏾‍💻Build with

* [Jetpack Compose](https://developer.android.com/jetpack/compose) - is Android’s modern toolkit for building native UI.
* [Koin](https://insert-koin.io/docs/quickstart/android/) - is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
* [Voyager](https://voyager.adriel.cafe/) - To solve the problem of duplicate navigation code in our Android and iOS projects by providing a shared navigation module.
* [ImageLoader](https://github.com/qdsfdhvh/compose-imageloader) - will reload when it's displayed.
* [Ktor](https://github.com/ktorio/ktor) - to get data from the network (API) instead of retrofit.. (to make HTTP requests)


## Before running!
 - install JDK 17 or higher on your machine
 - add `local.properties` file to the project root and set a path to Android SDK there

### Android
To run the application on android device/emulator:  
 - open project in Android Studio and run imported android run configuration

To build the application bundle:
 - run `./gradlew :composeApp:assembleDebug`
 - find `.apk` file in `composeApp/build/outputs/apk/debug/composeApp-debug.apk`
Run android simulator UI tests: `./gradlew :composeApp:pixel5Check`

### Desktop
Run the desktop application: `./gradlew :composeApp:run`
Run desktop UI tests: `./gradlew :composeApp:jvmTest`
