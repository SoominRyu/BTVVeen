<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연결 확인</title>
</head>
<body>
<H3> DB connection test </H3>
<%
Class.forName("org.mariadb.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://15.164.218.79:3306/test_db","root","1234");
	if(conn!=null){
		out.println("DB연결 성공.<BR>");
		conn.close();
		out.println("DB연결 끊음.<BR>");
	}
	else {
		out.println("연결할 수 없음.<BR>");
	}
%>
</body>
</html>