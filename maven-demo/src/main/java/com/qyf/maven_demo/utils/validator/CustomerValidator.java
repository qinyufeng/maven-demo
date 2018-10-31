package com.qyf.maven_demo.utils.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/***************自定义注解参数验证：1、定义注解并且指定验证器 2、验证器的实现，3、使用注解  *****************/
/** 
 * 
 * @author qyf
 * 2018-1-31
 */  

/** 
 * 1、定义注解并指定验证器是AgeValidator
 * */
// 
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) 
@Constraint(validatedBy = AgeValidator.class)
public @interface CustomerValidator {  
	String message() default ""; 
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

} 
/***************************  代码解说   ********************************/
/**
 * 在创建注解的时候，需要使用一些注解来描述自己创建的注解，就是写在@interface上面的那些注解，这些注解被称为元注解
 * @Documented: 用于标记在生成javadoc时是否将注解包含进去
 * @Target：用于定义注解可以在什么地方使用，默认可以在任何地方使用，也可以指定使用的范围；
 * @Constraint 是最关键的，它表示这个注解是一个验证注解，并且指定了一个实现验证逻辑的验证器
 * 
 * message()指明了验证失败后返回的消息，此方法为@Constraint要求
 * groups()和payload()也为@Constraint要求，可默认为空，详细用途可以查看@Constraint文档

 * TYPE : 类、接口或enum声明;
 * FIELD: 域(属性)声明;
 * METHOD: 方法声明;
 * PARAMETER: 参数声明;
 * CONSTRUCTOR: 构造方法声明;
 * LOCAL_VARIABLE:局部变量声明;
 * ANNOTATION_TYPE:注释类型声明;
 * PACKAGE: 包声明
 */
