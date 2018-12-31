package com.qyf.maven_demo.utils.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 算法题目描述：
 * 有一数组 a[1000] 存放了1000个数，这1000个数取自1-1999，且只有两个相同的数，剩下998个数不同，
 * 写一个搜索算法找出相同的那个数的值（注意空间效率和时间效率尽可能优化）
 * @author qyf
 *
 */
public class SearchAlgorithm {
	public static void main(String[] args) {
		//构造测试数据
		int[] arr= new int[4];
		for(int i=0;i<4;i++) {
			arr[i]=i+1;
		}
		arr[1]=2;
		/**搜索方式1**/
		Long time1=System.currentTimeMillis();
		Map<Integer,Integer> keys=new HashMap<>();
		for(Integer i:arr) {
			if(!keys.containsKey(i)) {
				keys.put(i, i);
			}else {
				System.out.println("相同的数是："+i);
			}
		}
		Long time2=System.currentTimeMillis();
		System.out.println("map key查找用时："+(time2-time1)+"毫秒");
		/**二分搜索算法(此題不可用，結果不對）**/
		binaryFindResult(arr);
		//System.out.println(middleIndex);
		
	}
	public static void binaryFindResult(int[] data){
		Long time1=System.currentTimeMillis();
		Arrays.sort(data);
		for (int i = 0; i < data.length; i++) {
		int target = data[i];
		int result = binaryFind(data, target);
		if (result != -1) {
		//System.out.println("相同元素为："+data[result]);
		Long time2=System.currentTimeMillis();
		//System.out.println("二分查找用时："+(time2-time1)+"毫秒");
		break;
		 }
		}
	}
	
	public static int binaryFind(int[] data, int target) {
		int start = 0;
		int end = data.length - 1;
		while (start <= end) {
		int middleIndex = (start + end) / 2;
		if (target == data[middleIndex]) {
		return middleIndex;
		}
		if (target >= data[middleIndex]) {
		start = middleIndex + 1;
		} else {
		end = middleIndex - 1;
		}
		}
		return -1;
		}
	}

