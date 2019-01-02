<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@page import="bean.LoginDao"
    		import="bean.Userdetails"
    		import="java.util.ArrayList"
    
     %>
    <jsp:useBean id="obj" class="bean.LoginBean"/>
    <jsp:setProperty property="*" name="obj"/>
    
   
    <%
    boolean status = LoginDao.validate(obj);
    if(status)
    {    	   
		session.setAttribute("session","TRUE");
		String userEmail = request.getParameter("email");
		
		ArrayList<Userdetails> retreiveData = LoginDao.getUserInfo(userEmail);
		
		LoginDao obj2 = new LoginDao();
		   
		session.setAttribute("Id",obj2.getId());
		session.setAttribute("Name",obj2.getName());
		session.setAttribute("Surname",obj2.getSurname());
		session.setAttribute("Location",obj2.getLocation());
		session.setAttribute("Phone",obj2.getPhone());
		
	%>	
		<jsp:forward page="Check.jsp"></jsp:forward>
		<% 
    }
    else
    {
    	out.println("Sorry something is wrong");
    	%>    	
    	<jsp:include page="index.jsp"/>
    	<%
   			 }    
     %>
     
    