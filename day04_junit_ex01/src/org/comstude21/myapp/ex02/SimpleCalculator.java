package org.comstude21.myapp.ex02;

public class SimpleCalculator {
	private int res=0;
	public int add(int x, int y) {
		res=x+y;
		return res;
	}
	public int sub(int x, int y) {
		res=x-y;
		return res;
	}
	public int mul(int x, int y) {
		res=x*y;
		return res;
	}
	public int div(int x, int y) {
		res=x/y;
		return res;
	}
}
