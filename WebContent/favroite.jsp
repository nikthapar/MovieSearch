
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%! int count= 0;%>
<%! String[] arr=new String[10];%>
<% String str[]=(String[])request.getAttribute("id");
out.println("Hello <br>");
for(int i=0;i<str.length;i++){
	arr[i]=str[i];
	}
    out.println("Favroite List"+"<br>");
    for(int i=0;i<10;i++){
    	if(arr[i] !=null)
    	out.println("movie"+" "+arr[i]+"<br>");
    }
    out.println("Count"+(count=count+str.length));
    if(count > 10){
    	int a = 10/0;
    }
%>
</body>
</html>