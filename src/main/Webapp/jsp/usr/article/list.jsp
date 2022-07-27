<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.exam.article.dto.ArticleDto" %>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>

<h1>게시물 리스트</h1>

<ul>
    <% for ( ArticleDto article : articles ) { %>
    <li>
        <a href="/usr/article/detail/free/<%=article.getId()%>"><%=article.getId()%>. <%=article.getTitle()%></a>
        <a href="/usr/article/modify/free/<%=article.getId()%>"> 수정 </a>
        <a href="/usr/article/delete/free/<%=article.getId()%>"> 삭제 </a>
    </li>
    <% } %>
</ul>