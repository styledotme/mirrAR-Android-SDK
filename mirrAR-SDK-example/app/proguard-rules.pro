# Add project specific ProGuard rules here.

-ignorewarnings
-keep class * {
    public private *;
}

-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**

#retRofit
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

-keepclassmembers class * {
    native <methods>;
}
-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-dontwarn okhttp3.**

 -dontwarn com.squareup.**

-keep class com.parse.*{ *; }
-dontwarn com.parse.**
-keepclasseswithmembernames class * {
    native <methods>;
}