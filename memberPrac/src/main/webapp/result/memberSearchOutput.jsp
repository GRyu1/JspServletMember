<%--
  Created by IntelliJ IDEA.
  User: Keon Ryong Cheong
  Date: 2023-04-03
  Time: 오전 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>회원 정보 검색 결과</title>
</head>
<body>
<%
    String result = (String)request.getAttribute("result");
    if(result!=null){%>
        ${result}
    <%}else{
%>
<H3>${member.id}/${member.passwd}/${member.name}</H3>
<%}%>
<%@include file="home.jsp"%>
</body>
</html>
