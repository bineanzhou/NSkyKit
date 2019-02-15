# NSkyKit 
[ ![Download](https://api.bintray.com/packages/bineanzhou/maven/com.nsky.kit%3Acore/images/download.svg) ](https://bintray.com/bineanzhou/maven/com.nsky.kit%3Acore/_latestVersion)

NSkyKit的设计目的是用于辅助快速搭建一个 Android 项目，同时利用自身提供的丰富控件及兼容处理，让开发者能专注于业务需求而无需耗费精力在基础代码的设计上。不管是新项目的创建，或是已有项目的维护，均可使开发效率和项目质量得到大幅度提升。
## 导入教程

> Step 1.先在 build.gradle(Project:XXXX) 的 repositories 添加:
```
allprojects {
	repositories {
		...
		maven { url "https://dl.bintray.com/bineanzhou/maven" }
		
	}
}
```
> Step 2. 然后在 build.gradle(Module:app) 的 dependencies 添加:
```
dependencies {
       //核心基础库
       implementation 'com.nsky.kit:nsky-core:+'
       //日志
       implementation "com.orhanobut:logger:$logger_version"
}
```
## 使用方法
在Application中初始化           
```kotlin
class MyApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        CoreAppExt.onCreate(this, true)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        CoreAppExt.attachBaseContext(base)
    }
}
```
## NSkyApp Demo介绍
> ### 抓包
```
chrome://inspect
```
![stetho](https://github.com/bineanzhou/NSky/blob/master/doc/img/img1.png)
