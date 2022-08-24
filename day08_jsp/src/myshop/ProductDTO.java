package myshop;

public class ProductDTO {
   int pno;
   String pname;
   String company;
   int price;
   int ea;
   
   public ProductDTO() {
      this(0, "", "", 0, 0);
   }

   public ProductDTO(int pno, String pname, String company, int price, int ea) {
      this.pno = pno;
      this.pname = pname;
      this.company = company;
      this.price = price;
      this.ea = ea;
   }

   public int getPno() {
      return pno;
   }

   public void setPno(int pno) {
      this.pno = pno;
   }

   public String getPname() {
      return pname;
   }

   public void setPname(String pname) {
      this.pname = pname;
   }

   public String getCompany() {
      return company;
   }

   public void setCompany(String company) {
      this.company = company;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getEa() {
      return ea;
   }

   public void setEa(int ea) {
      this.ea = ea;
   }

   @Override
   public String toString() {
      return "ProductDTO [pno=" + pno + ", pname=" + pname + ", company=" + company + ", price=" + price + ", ea="
            + ea + "]";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + pno;
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      ProductDTO other = (ProductDTO) obj;
      if (pno != other.pno)
         return false;
      return true;
   }
   
   @Override
   protected Object clone() throws CloneNotSupportedException {
      return new ProductDTO(pno, pname, company, price, ea);
   }
}