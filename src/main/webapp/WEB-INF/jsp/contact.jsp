<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Contact INSEA</title>
		
	  	<link rel = "shortcut icon" type = 'img/png' href="./INSEA_logo.png" >
       
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
			
			   
		    <h2 align="center" class="title">Contact</h2>
		       <h2 align="center" class="title1">Institut National de Statistique et d'Economie Appliquée</h2> 
		       <h2 align="center" class="title1">Rabat-Instituts</h2>   
		       <h2 align="center" class="title1"> Rabat</h2>      
		       <h2 align="center" class="title1">B.P. 6217</h2>    
		       <h2 align="center" class="title1"> Maroc</h2> 
		       <h2 align="center" class="title1"> Tel: (212) 05 37 77 48 59/60 </h2>
		       <h2 align="center" class="title1">Fax: (212) 05 37 77 94 57 </h2>        
		       <h2 align="center" class="title1"><a align="center" href="http://www.insea.ac.ma/" target="_blank" >Site Officel </a> </h2> 
		    
	    
	    </div>
	    
	</body>



</html>
