package mybatis.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.ProductVO;

public class ProductDAO {
	public static List<ProductVO> getTotal() {
		SqlSession session = FactoryService.getFactory().openSession();
		List<ProductVO> list = session.selectList("product.total");
		return list;
	}

	public static int add(String pno, String pname, String price) {
		Map<String, String> map = new Hashtable<String, String>();

		map.put("pno", pno);
		map.put("pname", pname);
		map.put("price", price);

		SqlSession session = FactoryService.getFactory().openSession(true);
		int cnt = session.insert("product.add", map);
		session.close();
		return cnt;
	}

	public static List<ProductVO> conditionSearch(String searchCondition, String searchKeyword) {
		Map<String, String> map = new Hashtable();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);

		SqlSession session = FactoryService.getFactory().openSession();

		List<ProductVO> searchList = session.selectList("product.conditionSearch", map);
		session.close();
		return searchList;
	}

	public static int delete(String pno) {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("pno", pno);
		SqlSession session = FactoryService.getFactory().openSession(true);
		int cnt = session.delete("product.delete", map);
		session.close();
		return cnt;
	}

	public static int update(String pno, String pname, String price) {
		Map<String, String> map = new Hashtable<String, String>();

		map.put("pno", pno);
		map.put("pname", pname);
		map.put("price", price);

		SqlSession session = FactoryService.getFactory().openSession(true);
		int cnt = session.insert("product.update", map);
		session.close();
		return cnt;
	}
}
