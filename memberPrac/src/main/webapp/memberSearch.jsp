<%--
  Created by IntelliJ IDEA.
  User: Keon Ryong Cheong
  Date: 2023-04-03
  Time: 오전 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>회원 정보 검색</title>
</head>
<body>

<h1>회원 정보 검색</h1>

${error}

<form action="memberSearch.do" method="post">
    ID : <input type="text" name="id">
    <input type="hidden" name="job" value="search">
    <input type="submit" value="검색">
</form>

</body>
</html>
