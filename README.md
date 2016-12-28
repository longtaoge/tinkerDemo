# tinkerDemo
本项目是 tinker 热补丁修复 示例

本例完全参照 [http://tinkerpatch.com/Docs/intro](http://tinkerpatch.com/Docs/intro)
以及 [https://github.com/TinkerPatch](https://github.com/TinkerPatch)

整理实现

是tinker 初学者的练习参考项目

使用方法:


### 1 在 http://tinkerpatch.com 上注册应用并添加应用 


![](https://github.com/longtaoge/tinkerDemo/blob/master/image/tinkerpatch.png)


### 2 修改 tinkerpatch.gradle 中的 appKey 为自己应用的key 



   appKey = "9e4dd618099f64c7"    //  http://tinkerpatch.com 上注册的key 




### 1 调用 assembleRelease 编译，我们会将编译过的包保存在build/bakApk中。然后我们将它安装到手机，我们发现APP出现了BUG,公鸡下面的名字写成了孔雀 点击红色按钮，可以看到补丁并没有加载.


![](https://github.com/longtaoge/tinkerDemo/blob/master/image/tinkerpatch_ar.png)


![](https://github.com/longtaoge/tinkerDemo/blob/master/image/XLB20161228230051.jpg)



### 2 修改代码，将MainActivity中  //  contentMain.setBackgroundResource(R.mipmap.rooster); 打开。然后我们需要修改build.gradle中的参数，将步骤一编译保存的安装包路径拷贝到tinkerPatch中的oldApk参数中。

![](https://github.com/longtaoge/tinkerDemo/blob/master/app/src/main/res/drawable/tinker8.png)


![](https://github.com/longtaoge/tinkerDemo/blob/master/image/tinkerpatch_copy.png)




### 3调 tinkerPatchRelease, 补丁包与相关日志会保存在/build/outputs/tinkerPatch/。然后我们将patch_signed_7zip.apk 上传到 TinkerPatch 后台



   

![](https://github.com/longtaoge/tinkerDemo/blob/master/image/thinkerpatch_release.png)

![](https://github.com/longtaoge/tinkerDemo/blob/master/image/tinkerpatch.png)




### 4 点击加载补丁菜单,然后锁屏或者点击重启按钮 

![](https://github.com/longtaoge/tinkerDemo/blob/master/image/XLB20161228230100.jpg)


### 5 我们可以看到公鸡的名字已经修复了，同时点击红色按钮，显示补丁包的确已经加载成功了。 

![](https://github.com/longtaoge/tinkerDemo/blob/master/image/XLB20161228230516.jpg)





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
