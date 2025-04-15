plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
//    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.nextgen.tes"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.nextgen.tes"
        minSdk = 29
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

//    Kotlin
    implementation(libs.androidx.core.ktx)

//    UI
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)

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
    implementation(libs.hilt.android)
//    ksp(libs.hilt.android.compiler)

//    Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}