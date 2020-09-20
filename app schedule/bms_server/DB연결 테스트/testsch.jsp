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
<H3> testSchedule</H3>
<table border="1">
<%
Class.forName("org.mariadb.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://15.164.218.79:3306/test_db","root","1234");
	Statement stmt = conn.createStatement();
	
	String strSQL = "select * from testSchedule";
	ResultSet rs =stmt.executeQuery(strSQL);
	
	while(rs.next()){
		
%>
<TR>
<TD><%=rs.getString("sid") %></TD>
<TD><%=rs.getString("StartDateTime") %></TD>
<TD><%=rs.getString("EndDateTime") %></TD>
<TD><%=rs.getString("ScheduleName") %></TD>
<TD><%=rs.getString("ScheduleLoc") %></TD>
<TD><%=rs.getString("message") %></TD>
<TD><%=rs.getString("Alarm") %></TD>
</TR>
<%
	}
	rs.close();
	stmt.close();
	conn.close();
%>
</table>

</body>
</html>