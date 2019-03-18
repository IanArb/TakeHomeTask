import Versions.constraintlayout_version
import Versions.coroutines_version
import Versions.dagger_version
import Versions.glide_version
import Versions.google_truth_version
import Versions.gson_converter_version
import Versions.gson_version
import Versions.joda_time_version
import Versions.junit_version
import Versions.kotlin_version
import Versions.mockito_version
import Versions.okhttp_client_version
import Versions.retrofit_coroutines_version
import Versions.retrofit_version
import Versions.support_version
import Versions.timber_version

/**
 * Created by Ian Arbuckle on 18/03/2019.
 *
 */

object Versions {

    const val kotlin_version = "1.3.20"
    const val dagger_version = "2.17"
    const val timber_version = "4.7.1"
    const val constraintlayout_version = "1.1.0"
    const val support_version = "1.0.0"
    const val gson_converter_version = "2.5.0"
    const val mockito_version = "2.23.0"
    const val glide_version = "4.7.1"
    const val google_truth_version = "0.36"
    const val coroutines_version = "1.1.1"
    const val junit_version = "4.12"
    const val joda_time_version = "2.10.1.1"
    const val retrofit_version = "2.5.0"
    const val retrofit_coroutines_version = "0.9.2"
    const val okhttp_client_version = "3.14.0"
    const val gson_version = "2.8.5"
}

object GoogleDependencies {
    val material_library = "com.google.android.material:material:$support_version"
    val constraintlayout_library = "androidx.constraintlayout:constraintlayout:$constraintlayout_version"
    val cardview_library = "androidx.cardview:cardview:$support_version"
    val recyclerview_library = "androidx.recyclerview:recyclerview:$support_version"
    val appcompat_library =  "androidx.appcompat:appcompat:$support_version"
    val gson_library =  "com.google.code.gson:gson:$gson_version"
    val dagger_library =  "com.google.dagger:dagger:$dagger_version"
    val dagger_support_library =  "com.google.dagger:dagger-android-support:$dagger_version"
    val dagger_compiler_library =  "com.google.dagger:dagger-compiler:$dagger_version"
}

object ThirdPartyDependencies {
    val joda_library =  "net.danlew:android.joda:$joda_time_version"
    val retrofit_library =  "com.squareup.retrofit2:retrofit:$retrofit_version"
    val retrofit_coroutines_library = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$retrofit_coroutines_version"
    val okhttpclient_library =  "com.squareup.okhttp3:okhttp:$okhttp_client_version"
    val okhttp_interceptor_library = "com.squareup.okhttp3:logging-interceptor:$okhttp_client_version"
    val gson_converter_library = "com.squareup.retrofit2:converter-gson:$gson_converter_version"
    val timber_library = "com.jakewharton.timber:timber:$timber_version"
    val glide_library = "com.github.bumptech.glide:glide:$glide_version"
    val glide_compiler_library = "com.github.bumptech.glide:compiler:$glide_version"
}

object KotlinDependencies {
    val coroutines_core_library = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    val coroutines_android_library = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
    val coroutines_test_library = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version"
    val kotlin_std_library = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
}

object TestDependencies {
    val junit_library = "junit:junit:$junit_version"
    val mockito_library = "org.mockito:mockito-core:$mockito_version"
    val google_truth_library = "com.google.truth:truth:$google_truth_version"
}