package com.qyf.maven_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages="com.qyf")//scanBasePackages要扫描的包，多个时：scanBasePackages={"com.qyf","xxx"};exclude=xxx.class要排除掉扫描的类
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
