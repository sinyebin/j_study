package myshop;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
   private static List<ProductDTO> list = new ArrayList();
   static {
      list.add(new ProductDTO(1,"소나타","HYUNDAI",3000,0));
      list.add(new ProductDTO(2,"카니발","KIA",4000,0));
      list.add(new ProductDTO(3,"S530","벤츠",9000,0));
      list.add(new ProductDTO(4,"S80","VOLVO",6000,0));
      list.add(new ProductDTO(5,"K5","KIA",2500,0));
      list.add(new ProductDTO(6,"BMW","BMW",5500,0));
   }
   
   public List<ProductDTO> selectAll() {
      return list;
   }
   
   public ProductDTO selectOne(ProductDTO dto) {
      int idx  =  list.indexOf(dto);
      if(idx != -1) {
         return list.get(idx);
      }
      return null;
   }
}