package com.lsm.frame.annotation;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 日志注解类
 * @author lsm
 */
@Target(ElementType.METHOD) //表示该注解标注在方法上
@Retention(RetentionPolicy.RUNTIME) //表示该注解保留到runtime阶段，将被JVM保留,所以它能在运行时被JVM或其他使用反射机制的代码所读取和使用.
@Documented //表示该注解会被 javadoc 之类的工具处理, 所以注解类型信息也会被包括在生成的文档中
public @interface LoggerManage {
    /**
     * 日志描述，这里使用了@AliasFor 别名。spring提供的
     * @return
     */
    @AliasFor("desc")
    String value() default "";

    /**
     * 日志描述
     * @return
     */
    @AliasFor("value")
    String desc() default "";

    /**
     * 是否不记录日志
     * @return
     */
    boolean ignore() default false;
}
