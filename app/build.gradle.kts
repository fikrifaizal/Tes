import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
//    id("com.google.devtools.ksp")
    alias(libs.plugins.hiltAndroid)
}

// get and read local properties with safer method
// hide base url from pushing to github
val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(localPropertiesFile.inputStream())
}
val baseUrl = localProperties.getProperty("BASE_URL") ?: "https://fallback-url.com"

android {
    namespace = "com.nextgen.tes"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.nextgen.tes"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        // get base url from local.properties
        buildConfigField("String", "BASE_URL", "\"${baseUrl}\"")

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

//    Kotlin
    implementation(libs.androidx.core.ktx)

//    UI
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)

//    Architecture KTX
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

//    Networking
    implementation (libs.retrofit2)
    implementation (libs.retrofit2.converter.gson)
    implementation (libs.logging.interceptor)

//    Datastore
    implementation(libs.androidx.datastore.preferences)

//    Coroutine
    implementation (libs.kotlinx.coroutines.android)

//    Dependency Injection
//    Dagger Hilt cannot use ksp instead kapt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

//    Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}