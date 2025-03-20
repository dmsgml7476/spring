package com.springStudy1.DTO;

public class TestA {

	private TestB tb;
	private TestC tc;
	
	public void makeObject2(TestC tc) {
		// 약한 결합
		this.tc=tc;
	}
	
	public void makeObject1() {
	// 강한 결합
		this.tb=new TestB();	
	}
	
	public void makeObject1(int num, String name) {
		this.tb = new TestB(num, name);
	}
	
	public void TestB(int num) {
		this.tb = new TestB(num);
	}
}
// TestA 객체가 생성되야 makeObject1()을 쓸 수 있고 makeObject1()이 실행되어야 TestB클래스 객체가 만들어진다. 
// TestB클래스는 TestA에 의존적이다. 이를 강한 결합이라고 한다.