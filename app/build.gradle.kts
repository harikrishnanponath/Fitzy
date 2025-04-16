plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.harikrish.fitzy"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.harikrish.fitzy"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.foundation.layout.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    implementation("androidx.compose.runtime:runtime-livedata:1.7.8")

    implementation("io.coil-kt:coil-compose:2.5.0")

    implementation("androidx.compose.material:material-icons-extended:1.5.0")

    val nav_version = "2.8.9"

    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:$nav_version")

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //Bottom navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.compose.material3:material3:1.1.2")

    //System UI for
//    implementation("com.google.accompanist:accompanist-systemuicontroller:0.35.0-alpha")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.34.0")


    implementation("br.com.devsrsouza.compose.icons:font-awesome:1.1.0")

    implementation("androidx.compose.ui:ui-text-google-fonts:1.7.8")







}