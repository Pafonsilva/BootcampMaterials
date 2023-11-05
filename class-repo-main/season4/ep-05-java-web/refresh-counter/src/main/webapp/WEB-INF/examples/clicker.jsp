<%--
  Created by IntelliJ IDEA.
  User: pantoninho
  Date: 23/03/2017
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Clicker</title>
</head>
<body>

<h1>Request context refreshes:</h1>
<h2>${reqRefreshes}</h2>

<h1>Session context refreshes:</h1>
<h2>${sessionRefreshes}</h2>

<h1>Application context refreshes:</h1>
<h2>${appRefreshes}</h2>

</body>
</html>
