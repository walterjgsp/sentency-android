plugins {
    id("com.android.application")
    id("kotlin-android")
}

val composeVersion = "1.0.0-rc01"
val koinVersion = "3.1.2"
val retrofitVersion = "2.9.0"

val defaultBaseUrl = "\"https://localhost/server/\""
val defaultAPIKey = "\"API_KEY\""


android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "org.wcode.sentency"
        minSdk = 28
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", System.getenv("BASE_URL") ?: defaultBaseUrl)
            buildConfigField("String", "API_KEY", System.getenv("API_KEY") ?: defaultAPIKey)
        }
        debug {
            buildConfigField("String", "BASE_URL", defaultBaseUrl)
            buildConfigField("String", "API_KEY", defaultAPIKey)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.0")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha05")

    // Koin
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation("io.insert-koin:koin-android-compat:$koinVersion")
    implementation("io.insert-koin:koin-androidx-workmanager:$koinVersion")
    implementation("io.insert-koin:koin-androidx-compose:$koinVersion")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.1"))
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")

    // Glide
    implementation ("com.google.accompanist:accompanist-coil:0.13.0")

    // Test
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.insert-koin:koin-test:$koinVersion")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
}