package com.qyf.maven_demo.serviceImpl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qyf.maven_demo.mapper.CalculateMapper;
import com.qyf.maven_demo.model.Calculate;
import com.qyf.maven_demo.model.Student;
import com.qyf.maven_demo.service.ICalculateService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/**
 *   服务实现类
 *
 * @author qyf
 * @since 2018-12-04
 */
@Component
@Service()
public class CalculateServiceImpl extends ServiceImpl<CalculateMapper,Calculate> implements ICalculateService {

	@Autowired
	private CalculateMapper calculateMapper;
	
	/************************ 常用的计算 及注意事项*************************************/
	/**
	 * 凡是用来计算的属性，都应该判断是否null是否空值
	 * 凡是作为除数的属性，都应该判断是不是0，0不能作为除数
	 * 凡是做除法运算，都应该保留小数位数，避免除不尽
	 * 除法乘法时  a/b *c  时应先 (a*c)/b
	 */
		@Override
		public Object calculate(Calculate param) {
			calculateTest();
			return null;
		}
		private void calculateTest() {
			/************************* BigDecimal 数据类型的加减乘除    *************/
			BigDecimal a=BigDecimal.ZERO;
			BigDecimal b=new BigDecimal(1);
			BigDecimal c=new BigDecimal(0);
			//加法
			BigDecimal add=a.add(b);
			//减法
			BigDecimal sub=c.subtract(a);
			//乘法
			BigDecimal mult=c.multiply(b);
			//乘法保留小数
			BigDecimal mult2=c.multiply(b).setScale(2, BigDecimal.ROUND_UP);//向上保留2位小数
			//除法
			a=new BigDecimal(1);
			b=new BigDecimal(3);
			BigDecimal divi=a.divide(b,2,BigDecimal.ROUND_DOWN );//向下保留2位
		    //（1）ROUND_FLOOR 截断保留；（2）ROUND_HALF_DOWN：若舍弃部分> .5，则作 ROUND_UP；否则，作 ROUND_DOWN； （3）ROUND_HALF_UP：若舍弃部分>=.5，则作 ROUND_UP ；否则，作 ROUND_DOWN 。
		    //除法乘法 (a/b)*c
			a=new BigDecimal(1);
			b=new BigDecimal(3);
			c=new BigDecimal(3);
			BigDecimal test=a.multiply(c).divide(b, 2,BigDecimal.ROUND_DOWN);// (a*c)/b 除后保留2位
		}
		@Override
		public Object calculateByStream(Calculate param) {
			calculateByStreamTest();
			return null;
		}
		/************************ 常用的计算 使用Java8 的strea计算*************************************/
		/**BigDecimal 类型的数据**/
		private void calculateByStreamTest() {
			List<Calculate> list=getDataList();
			//计算总数量（求和）
			BigDecimal calNumTotal=list.stream()
					.map(Calculate::getCalNum).reduce(BigDecimal.ZERO, BigDecimal::add);
			System.out.println(calNumTotal);
			//计算符合条件的总数量（求和）
			BigDecimal calNumTotalFilter=list.stream().filter(item -> item.getNO().equals("1"))
					.map(Calculate::getCalNum).reduce(BigDecimal.ZERO, BigDecimal::add);//reduce(identity, accumulator)：可以认为第一个参数为默认值，但需要满足identity op x = x，所以对于求和操作，identity的值为0，对于求积操作，identity的值为1。
			//求最大值
			Optional<Calculate> maxOpt=list.stream().max((item1,item2)-> item1.getCalNum().compareTo(item2.getCalNum()));
			Calculate maxCalculate=maxOpt.get();
			BigDecimal maxValue=maxCalculate.getCalNum();
			//求最小值
			Optional<Calculate> minOpt=list.stream().min((item1,item2)->item1.getCalNum().compareTo(item2.getCalNum()));
			BigDecimal minValue=minOpt.get().getCalNum();
			System.out.println(minValue + "," + maxValue);	
			//concat 两个list组合     相当于sql中的 unin all
			List<Calculate> list1=getDataList();
			List<Calculate> list2=getDataList();
			List<Calculate> listConcatLiat2=Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());

		}
		/**Integer  类型的数据**/
		private void calculateByStreamTest2() {
			List<Integer> intList=new ArrayList<>();intList.add(3);intList.add(2);intList.add(1);intList.add(1);
			//加法，
			int sum1 = intList.stream().reduce(0, (x,y) -> x+y);
			//或者
			int sum2 = intList.stream().reduce(0, Integer::sum);
			List<Calculate>  list=getDataList();
			int intAsum=list.stream().mapToInt(Calculate::getId).sum();
			double doubleAsum=list.stream().mapToDouble(Calculate::getDoubA).sum();
			//最小值
			Optional<Integer> minOpt=intList.stream().min((item1,item2) -> item1.compareTo(item2)) ;
			int minValue=minOpt.get();
			//最大值
			Optional<Integer> maxOpt=intList.stream().max((item1,item2) -> item1.compareTo(item2)) ;
			int maxValue=maxOpt.get();
			System.out.println(sum1+","+sum2+","+minValue+ "," +maxValue);//计算结果sum1=5,sum2=5,minValue=1,maxValue=3
			
		}
		private static List<Calculate> getDataList(){
			List<Calculate> list=new ArrayList<>();
			Calculate obj1=new Calculate();
			obj1.setPrice(new BigDecimal(1));obj1.setNums(new BigDecimal(2));obj1.setCalNum(new BigDecimal(1));
			obj1.setDoubA(1.1);
			
			obj1.setNO("1");
			Calculate obj2=new Calculate();obj2.setNums(new BigDecimal(2));obj2.setCalNum(new BigDecimal(1));
			obj2.setDoubA(1.1);
			obj2.setNO("1");
			
			Calculate obj3=new Calculate();
			obj3.setPrice(new BigDecimal(1));obj3.setNums(new BigDecimal(2));obj3.setCalNum(new BigDecimal(2));
			obj3.setDoubA(1.1);
			obj3.setNO("2");
			
			list.add(obj1);list.add(obj2);list.add(obj3);
			return list;
		}
		private static List<Student> getDataListStu(){
			List<Student> list=new ArrayList<>();
			Student obj1=new Student();
			obj1.setStuId("11");
			obj1.setName("qyf");
			obj1.setAge(22);
			Student obj2=new Student();
			obj2.setStuId("11");
			obj2.setName("qin");
			obj2.setAge(22);
			Student obj3=new Student();
			obj3.setStuId("33");
			obj3.setName("yu");
			obj3.setAge(22);
			list.add(obj1);list.add(obj2);list.add(obj3);
			return list;
		}
	/**
	     * 它们的执行效率排序为 ：for > forEach > stream
	     * 它们的代码编写量排序为：for < forEach < stream
	*/
		public static void main(String[] args) {
			List<Student> list1=getDataListStu();
			//方式1：for循环
			for(Student obj:list1) {//会改变源数据list1
				obj.setStuClass("1");
			}
			//方式2：Java8的forEach
			list1.forEach(obj -> {
				obj.setStuClass("2");//会改变源数据list1
			});
			//方式2：java8的stream
			
		}
}
