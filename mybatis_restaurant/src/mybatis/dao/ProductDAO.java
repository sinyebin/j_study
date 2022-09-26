package mybatis.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.ProductVO;

public class ProductDAO {
	public static List<ProductVO> getTotal(){
		SqlSession ss = FactoryService.getFactory().openSession();
		List<ProductVO> list = ss.selectList("product.total");
		ss.close();
		return list;
	}
	
	public static void add(String rno, String rtitle, String rprice) {
		Map<String,String>map = new Hashtable();
		map.put("rtitle", rtitle);
		map.put("rprice", rprice);
		
		SqlSession ss = FactoryService.getFactory().openSession(true);
		
		ss.insert("product.add", map);
		ss.close();
	}
	
	public static void update(String rno, String rtitle, String rprice) {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("rno", rno);
		map.put("rtitle", rtitle);
		map.put("rprice", rprice);
		SqlSession ss = FactoryService.getFactory().openSession(true);
		ss.update("product.update", map);
		ss.close();
	}
	
	public static ProductVO findByNo(String rno) {
		SqlSession ss = FactoryService.getFactory().openSession();
		Map<String, String> map = new Hashtable<String, String>();
		map.put("rno", rno);
		ProductVO vo = ss.selectOne("product.findByNo", map);
		ss.close();
		
		return vo;
	}
	public static void delete(String rno) {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("rno", rno);
		SqlSession ss = FactoryService.getFactory().openSession(true);
		ss.delete("product.delete", map);
		ss.close();
	}
}
