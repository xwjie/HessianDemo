# HessianDemo
最近公司有个项目使用了Hessian，特做个Demo备份。

Hessian以高性能，使用简单闻名，使用起来确实非常简单，结合强大的SpringBoot，整个范例实现了config的CRUD，代码不到50行，非常有实战意义。


# 创建工程

使用https://start.spring.io/创建工程。创建一个hessianserver工程，依赖中增加web和lombok。在创建一个hessianclient工程，依赖中增加web和lombok，cache。

再单独在STS中新建一个maven工程hessiancommon，用于存放bean定义和接口定义。

# hessiancommon工程
这里还是以config的crud为例，比较有代表意义。新建Config，ResultBean，和IConfigService接口定义。

单独一个工程的目的是为了独立出来让Server和client端都可以引用。相对于api文档。

# hessianserver工程

## 引入hessiancommon。
## 实现IConfigService接口。
## 发布hessian服务

# hessianclient工程

## 引入hessiancommon
## 配置hessian服务
## 注入IConfigService接口并调用

# 

<!-- https://mvnrepository.com/artifact/com.caucho/hessian -->
<dependency>
    <groupId>com.caucho</groupId>
    <artifactId>hessian</artifactId>
    <version>4.0.38</version>
</dependency>
