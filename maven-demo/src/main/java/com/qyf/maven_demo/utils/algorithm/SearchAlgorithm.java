package com.qyf.maven_demo.utils.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Integer[] arr=[1000];
		for(int i=1;i<1000;i++) {
			arr[i]=i;
		}
		arr.add(1);
		//搜索1
		Set<Integer> sets=new HashSet<>();
		for(Integer i:arr) {
			sets.add(i);
		}
		Integer[] setsArr=(Integer[]) sets.toArray();
	}

}
