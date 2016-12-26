#!/usr/bin/env bash
java -jar hotfix_demo/patchtool_demo/BCFixPatchTools-1.2.0.jar -cmd patch -src_apk /Users/wuer/Projects/alibaba/hotfix/hotfix-android/hotfix_demo/patchtool_demo/hotfix_demo-old.apk -fixed_apk /Users/wuer/Projects/alibaba/hotfix/hotfix-android/hotfix_demo/patchtool_demo/hotfix_demo-new.apk -wp /Users/wuer/Projects/alibaba/hotfix/hotfix-android/hotfix_demo/patchtool_demo/patch_out -sign_file_url /Users/wuer/Projects/alibaba/hotfix/hotfix-android/hotfix_demo/demo.jks -sign_file_pass test123 -sign_alias test123 -sign_alias_pass test123 -filter_class_file /Users/wuer/Projects/alibaba/hotfix/hotfix-android/hotfix_demo/patchtool_demo/classFilter.txt
adb push /Users/wuer/Projects/alibaba/hotfix/hotfix-android/hotfix_demo/patchtool_demo/patch_out/hotfix-working/baichuan-hotfix-patch.jar /sdcard/Download




 java -jar BCFixPatchTools-1.3.0.jar -c patch -s /Users/longtaoge/Downloads/hotfix_demo/patchtool_demo/hotfix_demo-old.apk -f /Users/longtaoge/Downloads/hotfix_demo/patchtool_demo/hotfix_demo-new.apk -wp /Users/longtaoge/Downloads/hotfix_demo/patchtool_demo/patch_out -k /Users/longtaoge/Downloads/hotfix_demo/demo.jks  -p test123 -a test123 -e test123


 java -jar BCFixPatchTools-1.3.0.jar -c patch -s /Users/longtaoge/AndroidApp/tinkerDemo/patchtool_demo/hotfix_demo-old.apk -f /Users/longtaoge/AndroidApp/tinkerDemo/patchtool_demo/hotfix_demo-new.apk -wp /Users/longtaoge/AndroidApp/tinkerDemo/patchtool_demo/patch_out -k /Users/longtaoge/AndroidApp/tinkerDemo/hotfixdemo/demo.jks  -p test123 -a test123 -e test123
