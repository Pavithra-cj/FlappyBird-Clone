plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "lk.itzcorpio.android.games.flappybird"
    compileSdk = 34

    defaultConfig {
        applicationId = "lk.itzcorpio.android.games.flappybird"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //Scalable Size Unit (support for different screen size)

    implementation ("com.intuit.sdp:sdp-android:1.0.6")
    implementation ("com.intuit.ssp:ssp-android:1.0.6")

    //Rounded Image View
    implementation ("com.makeramen:roundedimageview:2.3.0")

    //MultiDex
    implementation ("androidx.multidex:multidex:2.0.1")

    implementation ("com.android.volley:volley:1.2.1")
    implementation ("io.github.chaosleung:pinview:1.4.4")

}