# RN-Android-Demo
只有Android部分集成了无埋点SDK与触达SDK

## 集成步骤
先按这篇文档集成android 无埋点SDK部分 https://docs.growingio.com/docs/sdk-integration/react-native-wu-mai-dian-sdk/
再按

编译项目环境 根目录下
  npm install 
运行iOS部分 根目录下
  react-native run-ios --simulator="iPhone 8"
  
运行Andorid部分 先用AS打开/android这个目录，Sync一下项目，加载需要的依赖，再在根目录下
  react-native run-android 报错没有模拟器的话建议直接用AS run项目

![](https://tva1.sinaimg.cn/large/006y8mN6ly1g7czun16rfj30yq0u0wh5.jpg)