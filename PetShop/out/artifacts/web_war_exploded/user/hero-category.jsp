<%@ page import="bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Species" %>
<%@ page import="java.util.Map" %>
<%@ page import="DAO.SpeciesDAO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="DAO.CategoryDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>--%>
<div class="hero__categories">
    <div class="hero__categories__all">
        <i class="fa fa-bars"></i>
        <span>Tất cả sản phẩm</span>
    </div>
    <ul class="hero__categories__menu">
        <% List<Species> list = SpeciesDAO.getListSpecies();
            Map<String, List<Category>> map = new HashMap<>();
            for (int i = 0; i< list.size();i++){
                List<Category> listCategory = CategoryDAO.getListCategory(list.get(i).getSpecies_name());
                map.put(list.get(i).getSpecies_name(),listCategory);
            }%>

        <%for (int i = 0; i<list.size(); i++){%>
        <li><a href="category?category_name=<%=list.get(i).getSpecies_name()%>"><%=list.get(i).getSpecies_name()%></a>
            <ul class="pet">
                <%for (Category listCate : map.get(list.get(i).getSpecies_name())){%>
                <li><a href="category?category_name=<%=listCate.getCategory_name()%>"><%=listCate.getCategory_name()%></a></li>
                <%}%>
            </ul>
        </li>
       <%}%>
    </ul>
</div>
