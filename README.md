# annotation-example
注解使用示例及入门
注解的相关知识点
提到注解，大多数人应该都不默认，在我们程序中见到的@Override，@Deprected，@SupressWarnings等等，这些都是注解，只不过是系统自己封装好的，而我们平时比较少去深入理解是怎样实现的？

1）什么是注解（Annotation）：
Annotation（注解）就是Java提供了一种元程序中的元素关联任何信息和着任何元数据（metadata）的途径和方法。Annotion(注解)是一个接口，程序可以通过反射来获取指定程序元素的Annotion对象，然后通过Annotion对象来获取注解里面的元数据。

2）注解的分类：
根据注解参数的个数，我们可以将注解分为三类：

标记注解:一个没有成员定义的Annotation类型被称为标记注解。这种Annotation类型仅使用自身的存在与否来为我们提供信息。比如后面的系统注解@Override;
单值注解
完整注解　
根据注解使用方法和用途，我们可以将Annotation分为三类：

JDK内置系统注解
元注解
自定义注解
3）元注解：
元注解的作用就是负责注解其他注解。Java5.0定义了4个标准的meta-annotation类型，它们被用来提供对其它annotation类型作说明。Java5.0定义的元注解：
1. @Target
2. @Retention
3. @Documented
4. @Inherited

元注解 解析说明

@Documented 是否会保存到 Javadoc 文档中

@Retention 保留时间，可选值

SOURCE（源码时），CLASS（编译时），RUNTIME（运行时）

默认为 CLASS，SOURCE 大都为 Mark Annotation，这类 Annotation 大都用来校验，比如 Override, SuppressWarnings

@Target 可以用来修饰哪些程序元素，如 TYPE, METHOD, CONSTRUCTOR, FIELD, PARAMETER 等，未标注则表示可修饰所有

ANONOTATION_TYPE(注解类型声明），
PACKAGE（包）
TYPE （类，包括enum及接口，注解类型）
METHOD （方法）
CONSTRUCTOR （构造方法）
FIFLD （成员变量）
PARAMATER （参数）
LOCAL_VARIABLE （局部 变量）

@Inherited 是否可以被继承，默认为 false
4）什么是metadata（元数据）：
元数据从metadata一词译来，就是“关于数据的数据”的意思。
　
　元数据的功能作用有很多，比如：你可能用过Javadoc的注释自动生成文档。这就是元数据功能的一种。总的来说，元数据可以用来创建文档，跟踪代码的依赖性，执行编译时格式检查，代替已有的配置文件。如果要对于元数据的作用进行分类，目前还没有明确的定义，不过我们可以根据它所起的作用，大致可分为三类：
1. 编写文档：通过代码里标识的元数据生成文档
2. 代码分析：通过代码里标识的元数据对代码进行分析
3. 编译检查：通过代码里标识的元数据让编译器能实现基本的编译检查
