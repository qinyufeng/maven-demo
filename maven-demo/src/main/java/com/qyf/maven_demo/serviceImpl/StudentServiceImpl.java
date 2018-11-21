package com.qyf.maven_demo.serviceImpl;

import com.qyf.maven_demo.model.Student;
import com.qyf.maven_demo.mapper.StudentMapper;
import com.qyf.maven_demo.service.StudentService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
	@Autowired
	private StudentService service;
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
		stu.setId(4);
		stu.setName("qinyufeng4");
		stu.setAge(22);
		stu.setModifyDate(new Date());
		service.insertOrUpdate(stu);
		//mapper.updateById(stu);
	}

	@Override
	public Object insertCommon(Map<String, Object> params) {
		
		List<Map<String, Object>> stuList = (List<Map<String, Object>>) params.get("list");
		try {
			for (Map<String, Object> map : stuList) {
				// 生成sql参数：将所有key放到fieldNames，所有value放到fieldValues
				Map<String, Object> keysAndVlues = separateMapByKeysAndVlues(map, "fieldNames", "fieldValues", true);//true允许某个字段值为null

				// 执行数据库操作
				Map<String, Object> updateMap = new HashMap<String, Object>();
				updateMap.put("fieldNames", keysAndVlues.get("fieldNames"));
				updateMap.put("fieldValues", keysAndVlues.get("fieldValues"));
				mapper.insertCommon(updateMap);
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		return stuList;
	}

	@Override
	public Object updateCommon(Map<String, Object> params) {
		List<Map<String, Object>> stuList = (List<Map<String, Object>>) params.get("list");
		try {

			for (Map<String, Object> map : stuList) {
				// 生成sql参数
				Map<String, Object> keysAndVlues = separateMapByKeysAndVlues(map, "fieldNames", "fieldValues", true);

				Map<String, Object> updateMap = new HashMap<>();
				updateMap.put("fieldNames", keysAndVlues.get("fieldNames"));
				updateMap.put("paramMap", map);

				mapper.updateCommon(updateMap);
			}

		} catch (Exception e) {
			return e.getMessage();
		}
		return stuList;
	}

	@Override
	public Object selectCommon(Map<String, Object> params) {

		// 返回结果
		List<Map<String, Object>> result = new ArrayList<>();

		try {
			// 生成sql参数
			Map<String, Object> paramMap = (Map<String, Object>) params.get("paramMap");
			// 模糊查询字段
			List<String> vagueFieldNames = getStringList(params.get("vagueFieldNames"));
			// in查询字段
			List<String> inConditionList = new ArrayList<>();

			List<String> inFieldNames = getStringList(params.get("inFieldNames"));
			for (String name : inFieldNames) {

				// for-iteam
				Object valueObject = paramMap.get(name);

				String joinString = getJoinString(valueObject);
				if (joinString == null || "".equals(joinString)) {
					continue;
				}
				String conditionIteam = name + " in " + " ( " + getJoinString(valueObject) + " ) ";
				// 添加iteam
				inConditionList.add(conditionIteam);
			}
			params.remove("inFieldNames");

			// 分离字段和值
			Map<String, Object> keysAndVlues = separateMapByKeysAndVlues(paramMap, "fieldNames", "fieldValues", false);
			List<String> paramNames = (List<String>) keysAndVlues.get("fieldNames");

			if (paramNames != null && paramNames.size() > 0) {

				// 从 paramMap中分离 模糊查询字段
				paramNames.removeAll(vagueFieldNames);
				// 从 paramMap中分离 in查询字段
				paramNames.removeAll(inFieldNames);

				// 常规字段名字
				params.put("whereFieldNames", paramNames);
				// 模糊查询字段名字
				params.put("vagueFieldNames", vagueFieldNames);
				// in查询字段名字
				params.put("inConditions", inConditionList);
			}

			// 分页参数，和总记录数
			Page<Student> pageParam = pageParam(params, Student.class);
			// 执行数据库操作
			result = mapper.selectCommon(pageParam, params);

			return result;

		} catch (Exception e) {
			return e.getMessage();
		}
	}
   
	// --------------------------------------方法区--------------------------------------

	private Map<String, Object> separateMapByKeysAndVlues(Map<String, Object> map, String keyName, String valueName,
			boolean needNull) {

		HashMap<String, Object> result = new HashMap<String, Object>();

		if (map == null) {
			return result;
		}

		Set<Entry<String, Object>> entrySet = map.entrySet();

		List<String> keys = new ArrayList<>();
		List<Object> values = new ArrayList<>();

		for (Entry<String, Object> entry : entrySet) {

			String key = entry.getKey();
			Object value = entry.getValue();

			// 是否跳过为null的字段
			if (!needNull && value == null) {
				continue;
			}

			keys.add(key);
			values.add(value);

		}

		result.put(keyName, keys);
		result.put(valueName, values);

		return result;

	}
	/**
	 * 获取字符串和数组
	 * 
	 * @param data
	 * @return
	 */
	public static List<String> getStringList(Object data) {
		List<String> result = new ArrayList<>();

		if (data == null) {
			return result;
		}

		if (data instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) data;
			for (Object object : collection) {
				result.add(object + "");
			}
		} else {
			result.addAll(Arrays.asList((data + "").split(",")));
		}
		return result;
	}
	private String getJoinString(Object object) {
		List<String> list = getStringList(object);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			String iteam = list.get(i);
			iteam = "'" + iteam + "'";
			if (i != list.size() - 1) {
				iteam = iteam + ",";
			}
			result.append(iteam);
		}
		return result.toString();
	}
	private <T> Page<T> pageParam(Map<String, Object> data, Class<T> className) {

		Object paging = data.get("paging");

		int pageSize = 10;
		int currentPage = 1;

		// 不分页（）
		if (paging instanceof Boolean && !(Boolean) data.get("paging")) {

			pageSize = Integer.MAX_VALUE;

		} else {

			// 分页
			if (!ObjectUtils.isEmpty(data.get("pageSize"))) {

				pageSize = (int)data.get("pageSize");

			}

		}
		if (!ObjectUtils.isEmpty(data.get("currentPage"))) {

			currentPage =(int)data.get("currentPage");

		}

		return new Page<T>(currentPage, pageSize);

	}
}
