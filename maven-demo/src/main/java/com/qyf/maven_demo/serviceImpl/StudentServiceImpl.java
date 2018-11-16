package com.qyf.maven_demo.serviceImpl;

import com.qyf.maven_demo.model.Student;
import com.qyf.maven_demo.mapper.StudentMapper;
import com.qyf.maven_demo.service.StudentService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qyf
 * @since 2018-10-16
 */
@Component
@Service()
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
	@Autowired
	private StudentMapper mapper;

	@Override
	public Object javaEight(Student param) {
		//根据参数从数据库查出符合条件的参数
		Wrapper<Student> wrapper=new EntityWrapper<>();
		wrapper.eq("name", param.getName());
		List<Student> stuList=mapper.selectList(wrapper);
		
		/**
		 * List 转 map
		 * 这里id作为key，实体Student作为value;a -> a返回自身对象；
		 * 效果：{1=Student{id=1,name=小李，stuClass=一班}，2=Student{id=2,name=小黄......}}
		 */
		Map<Integer, Student> listToMap1=stuList.stream().collect(Collectors.toMap(Student::getId,  a -> a));
		/**
		 * List 转 map
		 * 这里id作为key，name作为value;
		 * 效果：{1=小李，2=小黄}
		 */
		Map<Integer, String> listToMap2=stuList.stream().collect(Collectors.toMap(Student::getId,  Student::getName));
		/**
		 * List 转 map
		 * 这里id作为key，有重复key时将之前的value 和现在的value拼接或相加起来；实体name作为value
		 * 效果：{一班=小李，二班=小黄，小花}
		 */
		Map<String, Object> listToMap3=stuList.stream().collect(Collectors.toMap(Student::getStuClass, b -> b,(key1,key2) -> key1+","+key2));
		
		/**
		 * list Filter 从集合中过滤出来符合条件的元素
		 */
		List<Student> commonClass=stuList.stream().filter(a->a.getStuClass().equals("一班")).collect(Collectors.toList());
		/**
		 * list 从集合中过滤出来符合条件的元素,然后将集合中的数据按照某个属性（对象型）求和
		 */
		BigDecimal moneyTotal=stuList.stream().filter(a->a.getStuClass().equals("一班")).map(Student::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
		/**
		 * list int型属性的求和
		 */
		int ageTotal=stuList.stream().mapToInt(Student::getAge).sum();
		
		System.out.println(listToMap1); System.out.println(listToMap2); System.out.println(listToMap3); System.out.println(commonClass);System.out.println(moneyTotal);System.out.println(ageTotal);
		return null;
	}

	/**
	 * 定时任务实现类
	 * 写法跟平时一样，没有什么不同
	 */
	@Override
	public void myTask() {
		Student stu=new Student();
		stu.setId(1);
		stu.setModifyDate(new Date());
		mapper.updateById(stu);
	}
}
