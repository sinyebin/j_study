package org.comstudy21.myapp.test01;

import java.util.HashMap;

// Factory 디자인 패턴 활용
public class BeanFactory implements AbstractBeanFactory {
	private static HashMap<String, Tv> map = new HashMap();
	static {
		map.put("samsung", new SamsungTV());
		map.put("lg", new LgTv());
		map.put("pansonic", new PanasonicTv());
	}

	@Override
	public Object getBean(String name) {
		return map.get(name);
	}
}