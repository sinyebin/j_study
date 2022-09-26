package mybatis.vo;

public class ProductVO {
	private int rno;
	private String rtitle;
	private int rprice;
	
	public ProductVO() {
		this(0,"", 0);
	}
	public ProductVO(int rno, String rtitle, int rprice) {
		this.rno=rno;
		this.rtitle=rtitle;
		this.rprice=rprice;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public int getRprice() {
		return rprice;
	}
	public void setRprice(int rprice) {
		this.rprice = rprice;
	}
	
	@Override
	public String toString() {
		return String.format("{\"rno\":%d, \"rtitle\":\"%s\", \"rprice\":\"%d\"}", rno, rtitle, rprice);
	}
}
