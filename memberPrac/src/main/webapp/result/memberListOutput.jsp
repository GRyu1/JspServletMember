<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.MemberVO" %><%--
  Created by IntelliJ IDEA.
  User: 정건룡
  Date: 2023-03-30
  Time: 오후 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보</title>
</head>
<body>
<%
    ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
    if(list!=null && !list.isEmpty()){%>
<table border="2">
    <tr><th>ID</th><th>비밀번호</th><th>이름</th></tr>
    <%
        for(int i=0; i<list.size(); i++){
            MemberVO member = list.get(i); %>
    <tr>
        <td><%=member.getId()%></td>
        <td><%=member.getPasswd()%></td>
        <td><%=member.getName()%></td>
    </tr>
    <%}
    }else{%>
    <%= "등록된 회원정보가 없습니다." %>
    <%}
    %>
</table>
<%@ include file="home.jsp"%>
</body>
</html>
