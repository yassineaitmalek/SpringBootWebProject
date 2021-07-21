<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html  xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
    <head>
    	
    	<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		
        <title>INSEA</title>
       
        <link rel = "shortcut icon" type = 'img/png' href="/WEB-INF/images/INSEA_logo.png" >
       
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
        
       
          
    </head>
    
    <body>
            
	    <div id='cssmenu'>
			<ul>
			   <li><a href='/'>INSEA</a></li>
			   <li class='active' style="transform: translate(1225px,0%);"><a href='/signin'>	Sign in	</a></li>
			   <li class='active' style="transform: translate(950px,0%);"><a href='/signup'>	Sign up	</a></li>
			   <li class='active' style="transform: translate(650px,0%);"><a href='/about'>		About	</a> </li>
			   <li class='active' style="transform: translate(350px,0%);"><a href='/contact'>	Contact	</a></li>
			</ul>
		</div>

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    
    <h1 style="text-align:center"> Welecome to Spring framework project   </h1>
    
    
    
    </body>
</html> 
	
