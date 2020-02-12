<%@page import="entidades.Ciudadano"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<header>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <% if(session.getAttribute("user")==null)
    	{%>
    <a class="navbar-brand" href="/Web/login.jsp">Login</a>
    	<% }else {%>
    <a class="navbar-brand" href="/Web/logout">Logout</a>    
    	<%} %>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
       <% try{ 
    	Ciudadano c=new Ciudadano();	
		c=(Ciudadano)session.getAttribute("user");
	    %> 
          <a class="nav-link disabled" href="#"><%=c.getUser()%></a><%}catch(Exception e){ %>
          <a class="nav-link disabled" href="#">-</a><%}%>
        </li>
      </ul>
      <form class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</header>
</html>