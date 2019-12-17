<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드 결과</h2>
	<%
		String str = request.getParameter("result");
	if(str.equals("SUCCESS"))
		out.println("성공적으로 업로드 되었습니다.");
	else
		out.println("파일 업로드에 실패했습니다.");
	%>
</body>
</html>