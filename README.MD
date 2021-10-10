# 介绍

jutil是Java常用的工具代码集，依赖的JDK最低版本是1.8，除了JDK1.8外无其他依赖

# 使用

# 使用

* 在pom.xml中加入：

```xml
<repositories>
    <repository>
        <id>jutil</id>
        <name>github repository</name>
        <url>https://topicstudy.github.io/jutil/maven-repo/</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.wjh</groupId>
        <artifactId>jutil</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

> 加入上面的配置后`mvn install`一下；如果还是爆红需要重启IDEA
>
> 如果`mvn install`失败过，请删掉本地maven仓库中安装失败的项目，在执行`mvn install`

* 示例：正在整理，也可以先看单元测试

  # 联系我

| 微信   | topicstudy                    |
| ------ | ----------------------------- |
| Gitee  | https://gitee.com/topicstudy  |
| Github | https://github.com/topicstudy |
