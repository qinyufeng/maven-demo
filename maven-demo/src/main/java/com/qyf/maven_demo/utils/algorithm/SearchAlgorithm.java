package com.qyf.maven_demo.utils.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;

public class SearchAlgorithm {
	/**
	 * 算法题目描述：
	 * 有一数组 a[1000] 存放了1000个数，这1000个数取自1-999，且只有两个相同的数，剩下998个数不同，
	 * 写一个搜索算法找出相同的那个数的值（注意空间效率和时间效率尽可能优化）
	 * @author qyf
	 * 结果分析：
	 * 搜索方式二在空间效率和时间效率上都比搜索方式一优，
	 * 原因一：因为hashMap是通过key来计算哈希值来存放数据，每次存取都需要先算一次hash，所以空间上，他既要维护键，又要维护值
	 * 原因二：一个byte8个字节，一个int32个字节
	 */
	public static void main(String[] args) {	
		long t11 = System.nanoTime();
		Integer[] a1 = initData(1000);
		long t12 = System.nanoTime();
		long t13 = System.nanoTime();
		int num1 = searchOne(a1);
		long t14 = System.nanoTime();
		System.out.printf("方式一的结果如下：");
		System.out.printf("结果: %s \r\n", num1);
		System.out.printf("初始化数组时间: %s ms \r\n", (t12 - t11) * 1.0D / 1000000);
		System.out.printf("搜索时间: %s ms \r\n", (t14 - t13) * 1.0D / 1000000);
		/****************************************************************************/
		long t21 = System.nanoTime();
		Integer[] a2 = initData(1000);
		long t22 = System.nanoTime();
		long t23 = System.nanoTime();
		int num2 = searchTwo(a2);
		long t24 = System.nanoTime();
		System.out.printf("方式二的结果如下：");
		System.out.printf("结果: %s \r\n", num2);
		System.out.printf("初始化数组时间: %s ms \r\n", (t22 - t21) * 1.0D / 1000000);
		System.out.printf("搜索时间: %s ms \r\n", (t24 - t23) * 1.0D / 1000000);
	}
	/**
	 * 搜索方式一
	 * 
	 * 
	 */
	private static int searchOne(Integer[] a) {
		Map<Integer,Integer> keys=new HashMap<>(2048);
		for(Integer i:a) {
			if(!keys.containsKey(i)) {
				keys.put(i, i);
			}else {
				return i;
			}
		}
		return 0;
	}
	/**
	 * 搜索方式二
	 * 
	 * 
	 */
	private static int searchTwo(Integer[] orgArr) {
		byte[] temp  = new byte[orgArr.length];
		for (int i : orgArr) {
			if (temp[i] == 1) {
				return i;
			} else {
				temp[i] = 1;
			}
		}
		return 0;
	}
	/**
	 * 初始化数据，用于测试
	 * 
	 * 
	 */
	private static Integer[] initData(int n) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		int seed = RandomUtils.nextInt(0, n);

		while (list.get(seed) == seed) {

			list.set(seed, RandomUtils.nextInt(0, n));
		}

		System.out.printf("种子序列是 %d ,种子的值是 %d \r\n", seed, list.get(seed));

		Collections.shuffle(list);

		return list.toArray(new Integer[n]);
		
	}

}

