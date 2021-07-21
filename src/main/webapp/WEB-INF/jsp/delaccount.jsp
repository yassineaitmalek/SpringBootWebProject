<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Delete Account</title>
		
        <style><%@include file="/WEB-INF/css/style.css"%></style>
    
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
          
	</head>
	<body>
	
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
  	

		${error }
		
		
	    <div class="log" style="box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );transform: translate(550px, 75px); height: 320px;">
	    	<br><br><br>
	        <form method='POST' action="/dashboard/delaccount/process/">
		        <h3 align = "center" class="type">Deleting Account </h3>
		        
		        <p align="center" class="title1">
		        	By pressing the "Delete" Button you will no longer be an INSEA Student .
		        	and therefore we wish you the best in your life and of course we wish you the best of luck 
		        	to find success   <br>		&#128154
		        </p>
		         <br><br><br> <br><br><br>
		        <input type="submit" value='Delete' name='del' class='bt' >
	        
	        </form>

	    
	    </div>
	</body>
</html>

