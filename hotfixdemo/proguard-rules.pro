# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/longtaoge/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


 # java -jar BCFixPatchTools-1.3.0.jar -c patch -s /Users/longtaoge/AndroidApp/tinkerDemo/patchtool_demo/hotfix_demo-old.apk -f /Users/longtaoge/AndroidApp/tinkerDemo/patchtool_demo/hotfix_demo-new.apk -wp /Users/longtaoge/AndroidApp/tinkerDemo/patchtool_demo/patch_out -k /Users/longtaoge/AndroidApp/tinkerDemo/hotfixdemo/demo.jks  -p test123 -a test123 -e test123



 -applymapping mapping.txt

 #HotFix
 -keep class * extends java.lang.annotation.Annotation
 -keepclasseswithmembernames class * {
     native <methods>;
 }
 -keep class com.alipay.euler.andfix.**{
     *;
 }
 -keep class com.taobao.hotfix.aidl.**{*;}
 -keep class com.ta.utdid2.device.**{*;}
 -keep class com.taobao.hotfix.HotFixManager{
     public *;
 }


