# RN-Android-Demo
只集成了Android部分的无埋点SDK与触达SDK

## 集成步骤
- 这个项目已经全部集成好Android部分的两种SDK，git clone后本地可以直接跑
- 集成方式是先按这篇文档集成android无埋点SDK https://docs.growingio.com/docs/sdk-integration/react-native-wu-mai-dian-sdk/
- 再按这篇文档集成android触达SDK(注意顺序，触达SDK依赖无埋点SDK) https://shimo.im/docs/NpMKr1mstNcnZRkl/read


## 本地跑的步骤

编译项目环境 根目录下
  ```
  npm install 
```
运行iOS部分 根目录下
  ```
  react-native run-ios --simulator="iPhone 8"
  ```
运行Andorid部分 先用AS打开/android这个目录，Sync一下项目，加载需要的依赖，再在根目录下
  ```
  react-native run-android 报错没有模拟器的话建议直接用AS run项目
```
![](https://tva1.sinaimg.cn/large/006y8mN6ly1g7czun16rfj30yq0u0wh5.jpg)
