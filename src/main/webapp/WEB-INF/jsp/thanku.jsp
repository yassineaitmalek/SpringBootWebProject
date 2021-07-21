<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
    <head>
        <title>Insea</title>
       
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
    
    <h1 style="text-align:center"> thank you very much for your registration ${name }  </h1>
    
    </body>
</html> 
	
