<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "java.sql.*"%>
    <% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안드로이드 연결확인</title>
</head>
<body>
<H3> 안드로이드 연결 - 저장  </H3>
<%
//String sid = request.getParameter("sid");
//String StartDateTime = request.getParameter("StartDateTime");
String StartDateTime = "20200920120000";
//String EndDateTime = request.getParameter("EndDateTime");
String EndDateTime = "20200920120000";
String ScheduleNam = request.getParameter("title");
String ScheduleLoc = request.getParameter("place");
String message = request.getParameter("content");
//String Alarm = request.getParameter("Alarm");
String Alarm = "20200920120000";
int sid = 0;

Class.forName("org.mariadb.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://15.164.218.79:3306/test_db","root","1234");
Statement stmt = conn.createStatement();

//sid값 구하기
String strSQL_sid = "select sid from testSchedule";
ResultSet rs =stmt.executeQuery(strSQL_sid);

while(rs.next()){
	sid=rs.getInt("sid")+1;
}
//sid 값 구하기

String strSQL = "insert into testSchedule values ( ";
strSQL=strSQL + sid + ",";
strSQL=strSQL + StartDateTime + ",";
strSQL=strSQL + EndDateTime + ",";
strSQL=strSQL + "'"+ ScheduleNam + "',";
strSQL=strSQL + "'"+ ScheduleLoc + "',";
strSQL=strSQL + "'"+ message + "',";
strSQL=strSQL + Alarm + ")";

stmt.executeUpdate(strSQL);
rs.close();
stmt.close();
conn.close();

response.sendRedirect("testSch.jsp");

%>
</body>
</html>