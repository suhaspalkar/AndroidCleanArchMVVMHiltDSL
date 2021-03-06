object Plugins{
    object AgpGradle {
        private const val version = "7.0.2"
        const val agp = "com.android.tools.build:gradle:$version"

    }

    object Kotlin {
        private const val version = "1.5.31"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object DaggerHilt{
        const val version = "2.38.1"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }
}

object Libs {

    object AndroidX {
        private const val coreKtxVersion = "1.6.0"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

        object UI {
            object AppCompact {
                private const val version = "1.3.1"
                const val appcompat = "androidx.appcompat:appcompat:$version"
            }

            object Material {
                private const val version = "1.4.0"
                const val material = "com.google.android.material:material:$version"
            }

            object ConstraintLayout {
                private const val version = "2.1.0"
                const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
            }
        }

        object Lifecycle {
            private const val version = "2.3.1"
            const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Navigation {
            private const val version = "2.3.5"
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }
    }

    object DaggerHilt{
        const val hiltAndroid = "com.google.dagger:hilt-android:${Plugins.DaggerHilt.version}"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Plugins.DaggerHilt.version}"
    }

    object Glide {
        private const val version = "4.12.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val glideCompiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Test {
        private const val junitVersion = "4.13.2"
        private const val extJunitVersion = "1.1.3"
        private const val espressoVersion = "3.4.0"
        const val junit = "junit:junit:$junitVersion"
        const val extJUnit = "androidx.test.ext:junit:$extJunitVersion"
        const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
    }

}
