<%@ page import="vo.MemberVO" %><%--
  Created by IntelliJ IDEA.
  User: Keon Ryong Cheong
  Date: 2023-04-03
  Time: 오전 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>회원 정보 수정</title>
</head>
<body>

<h1>수정 정보 검색</h1>

${error}

<form action="memberSearch.do" method="post">
    ID : <input type="text" name="id">
    <input type="hidden" name="job" value="update">
    <input type="submit" value="검색">
</form>

<%
    MemberVO member = (MemberVO) request.getAttribute("member");
    if (member != null) {%>
<h1>회원 정보 수정</h1>

<form action="memberUpdate.do" method="post">
    ID : <input type="text" name="id" readonly value="${member.id}">
    비밀번호 : <input type="password" name="passwd" value="${member.passwd}">
    이름 : <input type="text" name="name" value="${member.name}">
    <input type="submit" value="수정">
</form>
<%} else {%>
${result}
<%}%>

</body>
</html>
