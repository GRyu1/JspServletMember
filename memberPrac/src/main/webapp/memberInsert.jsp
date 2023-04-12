<%--
  Created by IntelliJ IDEA.
  User: Keon Ryong Cheong
  Date: 2023-04-02
  Time: 오후 7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>회원 가입 입력</title>
</head>
<body>

<h1>회원 가입 정보 입력</h1>

${error}

<form action="memberInsert.do" method="post">
    ID : <input type="text" name="id"><br>
    비밀번호 : <input type="password" name="passwd"><br>
    이름 : <input type="text" name="name"><br>

    <input type="submit" value="가입">
</form>

</body>
</html>
