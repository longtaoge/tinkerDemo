# tinkerDemo
本项目是 tinker 热补丁修复 示例

本例完全参照 ![https://github.com/Tencent/tinker/wiki/Tinker](https://github.com/Tencent/tinker/wiki/Tinker-%E6%8E%A5%E5%85%A5%E6%8C%87%E5%8D%97)

是tinker 初学者的练习参考项目

使用方法:



### 1 调用assembleDebug编译，我们会将编译过的包保存在build/bakApk中。然后我们将它安装到手机，我们发现APP出现了BUG,公鸡下面的名字写成了孔雀 点击红色按钮，可以看到补丁并没有加载.


![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker11.png)



![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker6.jpg)



### 2 修改代码，将MainActivity中  //  contentMain.setBackgroundResource(R.mipmap.rooster); 打开。然后我们需要修改build.gradle中的参数，将步骤一编译保存的安装包路径拷贝到tinkerPatch中的oldApk参数中。

![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker8.png)


![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker9.png)




### 3调 用tinkerPatchDebug, 补丁包与相关日志会保存在/build/outputs/tinkerPatch/。然后我们将patch_signed_7zip.apk推送到手机的sdcard中。



    adb push ./app/build/outputs/tinkerPatch/debug/patch_signed_7zip.apk /storage/sdcard0/


![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker4_1.png)

![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker4_2.png)




### 4 点击加载补丁菜单, 如果看到patch success, please restart process的toast，即可锁屏或者点击重启按钮 

![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker3.jpg)

![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker31.jpg)



### 5 我们可以看到公鸡的名字已经修复了，同时点击红色按钮，显示补丁包的确已经加载成功了。 

![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker5.jpg)





License
--------

    Copyright (C) 2016, longtaoge

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
