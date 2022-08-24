<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="myshop.ProductDAO"%>
<%@page import="myshop.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 장바구니 컨트롤 기능
int pno=Integer.parseInt(request.getParameter("pno"));
String cmd=request.getParameter("cmd");
int ea=Integer.parseInt(request.getParameter("ea"));



//session의 cartList
if(session.getAttribute("cartList")==null){
	session.setAttribute("cartList", new ArrayList<ProductDTO>());
}
List<ProductDTO> cartList=(List<ProductDTO>)session.getAttribute("cartList");
if(cmd.equals("add")){
	ProductDAO dao = new ProductDAO();
	ProductDTO product = dao.selectOne(new ProductDTO(pno,"","",0,0));
	ea+=product.getEa();
	product.setEa(ea);
	if(!cartList.contains(product)){
		cartList.add(product);
	}
}else if(cmd.equals("remove")){
	ProductDAO dao = new ProductDAO();
	ProductDTO product = dao.selectOne(new ProductDTO(pno,"","",0,0));
	product.setEa(ea);
	cartList.remove(product);
}



response.sendRedirect("cart_list.jsp");
%>