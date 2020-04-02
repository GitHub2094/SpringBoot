## 整合logback和配置sql语句日志输出

> `logback`是由log4j创始人设计的又一个开源日志组件。同时也是`springboot`默认记录日志的框架。

**由于默认就是使用`logback`,所以只需要配置一个`logback-spring.xml`文件在`resourcs`目录下即可，项目会自动识别的**

##1.xml配置
#### logback-spring.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration debug="false">
    <!--定义日志文件的存储地址 勿在 LogBack 的配置中使用相对路径 -->
    <property name="LOG_HOME" value="E:/logs/frame" />
    <!-- 控制台输出 -->
    <appender name="STDOUT"
              class="ch.qos.logback.core.ConsoleAppender">
        <encoder
                class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符 -->
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
        </encoder>
    </appender>
    <!-- 按照每天生成日志文件 -->
    <appender name="FILE"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <rollingPolicy
                class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!--日志文件输出的文件名 -->
            <FileNamePattern>${LOG_HOME}/frame.log.%d{yyyy-MM-dd}.log
            </FileNamePattern>
            <!--日志文件保留天数 -->
            <MaxHistory>30</MaxHistory>
        </rollingPolicy>
        <encoder
                class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符 -->
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
        </encoder>
        <!--日志文件最大的大小 -->
        <triggeringPolicy
                class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
            <MaxFileSize>10MB</MaxFileSize>
        </triggeringPolicy>
    </appender>

    <!-- 自定义包下设置为INFO,则可以看见输出的日志不包含debug输出了 -->
    <logger name="cn.lqdev.learning" level="INFO" />

    <!-- 日志输出级别 -->
    <root level="INFO">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="FILE" />
    </root>
</configuration>
```
##2.类使用
```java
//import slf4j.Loggger
private Logger logger =  LoggerFactory.getLogger(this.getClass());
logger.info("获取权限");

```

##3.配置输出sql语句日志
```xml
//在application.properties里配置sql日志输出
#打印日志sql
logging.level.com.lsm.frame.mapper=DEBUG
```