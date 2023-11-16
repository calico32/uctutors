@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.hilt)
  kotlin("kapt")
}

android {
  namespace = "lol.calico.uctutors"
  compileSdk = 34

  defaultConfig {
    applicationId = "lol.calico.uctutors"
    minSdk = 31
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }

    fun quoted(str: String) = '"' + str.replace("\"", "\\\"") + '"'

    buildConfigField("String", "WEB_CLIENT_ID", quoted(env.WEB_CLIENT_ID.value))
    buildConfigField("String", "SERVER_URL", quoted(env.SERVER_URL.value))
  }

  buildFeatures {
    compose = true
    buildConfig = true

  }

  buildTypes {
    debug {
      isMinifyEnabled = false

    }
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
  kotlinOptions {
    jvmTarget = "1.8"
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.4"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  implementation(libs.core.ktx)
  implementation(libs.lifecycle.runtime.ktx)
  implementation(libs.activity.compose)
  implementation(platform(libs.compose.bom))
  implementation(libs.ui)
  implementation(libs.ui.graphics)
  implementation(libs.ui.tooling.preview)
  implementation(libs.ui.text.googlefonts)
  implementation(libs.navigation)
  implementation(libs.material3)
  implementation(libs.material.icons.extended)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.espresso.core)
  androidTestImplementation(platform(libs.compose.bom))
  androidTestImplementation(libs.ui.test.junit4)
  debugImplementation(libs.ui.tooling)
  debugImplementation(libs.ui.test.manifest)
  implementation(libs.google.protobuf.kotlin)
  implementation(libs.google.protobuf.java)
  implementation(libs.google.commonprotos)
  implementation(libs.google.googleplay.auth)
  implementation(libs.grpc.core)
  implementation(libs.grpc.protobuf)
  implementation(libs.grpc.stub)
  implementation(libs.grpc.kotlin)
  implementation(libs.grpc.okhttp)
  implementation(libs.kotlinx.coroutines)
  implementation(libs.hilt)
  implementation(libs.hilt.navigation)
  implementation(libs.datastore)
  kapt(libs.hilt.compiler)
}

kapt {
  correctErrorTypes = true
}