package com.qyf.maven_demo.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.qyf.maven_demo.service.StudentService;

@Service
@EnableScheduling
public class CoreTask {
	private final Logger logger=LogManager.getLogger();
	
	@Autowired
	private StudentService stuService;
	
	@Scheduled(cron="0 0/1 * * * ?")//没隔一分钟执行一次
	public void taskTestOne(){ 
		logger.info("定时任务开始执行");
		System.out.println("执行定时任务");
		logger.info("定时任务执行结束");
	}
	@Scheduled(cron="0 0/1 * * * ?")//没隔一分钟执行一次
	public void taskTest2(){ 
		logger.info("定时任务开始执行");
		stuService.myTask();
		logger.info("定时任务执行结束");
	}

}
/**
 * 定时任务这三个注解缺一不可
 * @Service 
 * @EnableScheduling 这个注解放在配置类上，表示开启定时任务的支持
 * @Scheduled 声明要执行的定时任务
 * 
 * 按顺序依次为    秒（0~59） 分（0~59）  时（0~23）  天（月）（0~31，但是你需要考虑你月的天数）   月（0~11）  天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT） 7.年份（1970－2099）
 *
/ 指定数值的增量    例如：在子表达式（分钟）里的“0/15”表示从第0分钟开始，每15分钟  。在子表达式（分钟）里的“3/20”表示从第3分钟开始，每20分钟（它和“3，23，43”）的含义一样
？  仅被用于天（月）和天（星期）两个子表达式，表示不指定值   当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”
* 代表所有可能的值   因此，“*”在子表达式（月）里表示每个月的含义，“*”在子表达式（天（星期））表示星期的每一天
 
 */
