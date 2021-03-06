plugins {
    id("com.android.application")
    kotlin("android")
//    id("kotlin-kapt")
    kotlin("kapt")
//    id("dagger.hilt.android.plugin")
    // apply(plugin = "com.google.firebase.crashlytics")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = "com.sp.cleanarchitectureapp"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }

    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }

//    flavorDimensions(AppConfig.dimension)
//    productFlavors {
//        create("staging") {
//            applicationIdSuffix = ".staging"
//            setDimension(AppConfig.dimension)
//        }
//
//        create("production") {
//            setDimension(AppConfig.dimension)
//        }
//    }
}

dependencies {
    //app libs
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.UI.AppCompact.appcompat)
    implementation(Libs.AndroidX.UI.Material.material)
    implementation(Libs.AndroidX.UI.ConstraintLayout.constraintLayout)
    implementation(Libs.AndroidX.Lifecycle.liveDataKtx)
    implementation(Libs.AndroidX.Lifecycle.viewModelKtx)
    implementation(Libs.Glide.glide)
    annotationProcessor(Libs.Glide.glideCompiler)

    implementation(Libs.DaggerHilt.hiltAndroid)
    kapt(Libs.DaggerHilt.hiltAndroidCompiler)

    implementation(Libs.AndroidX.Navigation.fragmentKtx)
    implementation(Libs.AndroidX.Navigation.uiKtx)


    //test libs
    testImplementation(Libs.Test.junit)

    androidTestImplementation(Libs.Test.extJUnit)
    androidTestImplementation(Libs.Test.espressoCore)
}

//kapt {
//    correctErrorTypes = true
//}