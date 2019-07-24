<%!
public String name = "Rajani Kanth";
private int age = 10;

{
	System.out.println ("Text in JSP");
}

public String getName() 
{
	return name;
}
public int getAge() 
{
	return age;
}

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Name <%= name  %><BR>
Age <%= age  %>
<% for(int i=0; i<=5; i++){ %>
	
Name <%= name  %><BR>
<%}%>

</body>
</html>