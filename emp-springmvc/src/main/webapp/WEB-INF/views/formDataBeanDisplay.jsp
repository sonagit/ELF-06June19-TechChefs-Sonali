<%@page import="com.techchefs.emp.dto.UserBean"%>

<% UserBean userBean = (UserBean) request.getAttribute("userBean"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FormDataDisplay</title>
</head>
<body>
Welcome  to the Website <%=userBean.getUserId() %> 
</body>
</html>