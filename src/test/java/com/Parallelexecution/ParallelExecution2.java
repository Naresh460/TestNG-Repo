package com.Parallelexecution;

import org.testng.annotations.Test;

public class ParallelExecution2 {

	@Test
	public void method1() {
		System.out.println("class2--->>>method1-->" +Thread.currentThread().getId());
	}
	
	@Test
	public void method2() {
		System.out.println("class2--->>>method2-->" +Thread.currentThread().getId());
	}
	
	@Test
	public void method3() {
		System.out.println("class2--->>>method3-->" +Thread.currentThread().getId());
	}
	
	
}
