1. Crear un nuevo proyecto
2. Agregar la configuracion en libs.versions.toml


#navigation
androidx-navigation-fragment-ktx = { group = "androidx.navigation", name = "navigation-fragment-ktx", version.ref = "navigationFragmentKtx" }
androidx-navigation-ui-ktx = { group = "androidx.navigation", name = "navigation-ui-ktx", version.ref = "navigationUiKtx" }

#Room
room = { module= "androidx.room:room-ktx", version.ref="room" }
room-runtime = { module= "androidx.room:room-runtime", version.ref="room" }
room-compiler = { module = "androidx.room:room-compiler", version.ref="room" }

--------------En [Versions]


navigationFragmentKtx = "2.7.7"
navigationUiKtx = "2.7.7"
room = "2.6.1"

3. Hacer que ser recargue el grandlee, click en el martillo y despues en el elefante.
4. En build.gradle.kts


Agregar el viewBinding


Dependencias:


   //navigation
   implementation(libs.androidx.navigation.fragment.ktx)
   implementation(libs.androidx.navigation.ui.ktx)


   // room
   implementation(libs.room)
   implementation(libs.room.runtime)
   kapt(libs.room.compiler)


y en plugins
   kotlin("kapt")
5. Importante en el res crear el Navigator
6. copy and paste todos los package y con eso ya se puede realizar un create, delete, edit\
7. importante el MyApplication
8. el DialogFunctions.kt debe de tener su layout si no no funciona
9. En manifest linea 11 se debe de colocar android:name=".MyApplication"
10. El main activity debe de modificarse para poder inicializar el proyecto en la pantalla que se desea.