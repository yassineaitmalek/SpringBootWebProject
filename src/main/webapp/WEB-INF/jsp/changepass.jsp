<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Change Password</title>
		
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
		
		
	    <div class="log" style="box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );transform: translate(550px, 75px);">
	    	<br>
	        <form method='POST' action="/dashboard/changepass/process/">
		        <h3 class="type">Old Password </h3>
		        <input type="password" placeholder="Password"  name='op' required autofocus class="box">
		        <h3 class="type">New Password</h3>
		        <input type="password" placeholder="Password" name='np' required autofocus class="box">
		        <h3 class="type">Confirm New Password</h3>
		        <input type="password" placeholder="Password" name ='cnp' required autofocus class="box">
		        
		        <input type="submit" value='Change' name='change' class='bt' >
	        
	        </form>

	    
	    </div>
	</body>
</html>

