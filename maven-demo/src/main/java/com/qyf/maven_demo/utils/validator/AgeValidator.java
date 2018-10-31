package com.qyf.maven_demo.utils.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 2、验证器的实现
 * @author qyf
 * 2018-10-31
 */
public class AgeValidator implements ConstraintValidator<CustomerValidator,Integer>{
	@Override
	public void initialize(CustomerValidator constraintAnnotation) {
		//String msg=constraintAnnotation.message();
	}
	@Override
	public boolean isValid(Integer i, ConstraintValidatorContext arg1) {
		if(i % 2 !=0) {
			return false;
		}else {
			return true;
		}	
	}
}
/***************************  代码解说   ********************************/
/**
 *  验证器有两个类型参数，第一个是所属的注解，第二个是注解作用地方的类型，这里因为作用在age上，因此这里用了Integer
 *  isValid()就是判断是否合法的地方
 *  initialize()可以在验证开始前调用注解里的方法，从而获取到一些注解里的参数，这里用不到
 * */

