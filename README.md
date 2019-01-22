# NSky 
[ ![Download](https://api.bintray.com/packages/bineanzhou/maven/com.nsky.box%3Acore/images/download.svg?version=1.0.1) ](https://bintray.com/bineanzhou/maven/com.nsky.box%3Acore/1.0.1/link)

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
       implementation 'com.nsky.box:nsky-core:+'
       //日志
       implementation "com.orhanobut:logger:$logger_version"
}
```
### 使用方法
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