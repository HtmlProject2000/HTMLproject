<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	boolean sthWrong[] = (boolean[])request.getAttribute("sthWrong");
	for(int i = 0;i<4;i++){
		if(sthWrong[i]){
			switch(i){
			case 0:
				out.println("<h1> Um dos campos de senha não foi preechido</h1>");
				break;
			case 1:
				out.println("<h1> Um dos campos de e-mail não foi preechido</h1>");
				break;
			case 2:
				out.println("<h1> A senha inserida não é igual nos dois campos.</h1>");
				break;
			case 3:
				out.println("<h1> O e-mail inserido não é igual nos dois campos.</h1>");
				break;
			}
		}
	}
	%>
	<a href = 'sing-in.html'> <input type = "button" value = "Voltar"></a>
</body>
</html>