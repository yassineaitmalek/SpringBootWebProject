<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
    <head>
        <title>About INSEA</title>
       
        <link rel = "shortcut icon" type = 'img/png' href="/WEB-INF/images/INSEA_logo.png" >
       
        <style><%@include file="/WEB-INF/css/style3.css"%></style>
        
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
          
    </head>
    <body>
    
	    <c:if test="${connected}">
		     <div id='cssmenu'>
			<ul>
			   <li><a href='/dashboard'>INSEA</a></li>
			   <li class='active' style="transform: translate(1225px,0%);"><a href='#'>Settings</a>
			      <ul>
			               <li><a href='/dashboard/changepass'>Change password</a></li>			       
			               <li><a href='/dashboard/delaccount'>Delete account</a></li>
			               <li><a href='/dashboard/reup'>Reupload file</a></li>
			               <li><a href='/about'>About</a></li>
			               <li><a href='/contact'>Contact</a></li>
			               <li><a href='/logout'>Logout </a></li>
			         
			      </ul>
			   </li>
   
			</ul>
		</div>
  	
	  	
		</c:if>
		<c:if test="${!connected}">
		    <div id='cssmenu'>
					<ul>
					   <li><a href='/'>INSEA</a></li>
					   <li class='active' style="transform: translate(1225px,0%);"><a href='/signin'>	Sign in	</a></li>
					   <li class='active' style="transform: translate(950px,0%);"><a href='/signup'>	Sign up	</a></li>
					   <li class='active' style="transform: translate(650px,0%);"><a href='/about'>		About	</a> </li>
					   <li class='active' style="transform: translate(350px,0%);"><a href='/contact'>	Contact	</a></li>
					</ul>
				</div>
		</c:if>
            
		
		
	
	    <div class="lg" style="box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 ); ">
	    	
	    	
	    	<h2 align="center" class="title">	About	</h2>
	    	<br><br><br>
		    <p align="center" class="title1">
				The National Institute of Statistics and Applied Economics (INSEA)
				 is one of the oldest engineering schools in Morocco and remains to this day one of the most prestigious Moroccan Grandes
				 ecoles in engineering. Located in Rabat and created in 1961, its latest naming has changed by Royal Decree from the appellation 
				 The Training Centre of Engineers in Statistics in 1967 with the support of the Economic Commission for Africa (ECA).
		    </p>
	    
	    </div>

	</body>
	
</html>

