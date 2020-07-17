<%--
  Created by IntelliJ IDEA.
  User: 11841
  Date: 2019/6/24
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <ul>
        <li><a onclick="toAdminLogin()">管理员登录</a></li>
    </ul>
</body>

<script>
    function toAdminLogin() {
        window.location.href="./adminLogin.jsp";
    }
</script>
</html>
