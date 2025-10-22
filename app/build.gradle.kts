plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "ru.onlinestore.mobile"
    compileSdk = 36

    defaultConfig {
        applicationId = "ru.onlinestore.mobile"
        minSdk = 29
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        compileOptions {
            targetCompatibility = JavaVersion.VERSION_21
        }
    }

    buildFeatures { compose = true }
}

dependencies {
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)

    implementation(libs.material.icons)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.compose.viewmodel)

    implementation(libs.ktor.client.resources)
    implementation(libs.logback)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.content.negotation)
    implementation(libs.ktor.client.auth)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.core)

    implementation(libs.coil.compose.core)
    implementation(libs.coil.network.ktor)

    implementation(libs.kotlinx.serialization)
    implementation(libs.navigation3.ui)
    implementation(libs.navigation3.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}