<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Sign-in INSEA </title>
       
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

 		<div class="log" style="box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 ); transform: translate(550px, 75px);">
            <form method="post" action="/signin">
	        	<br><br>
	            <h2 align="center" class="title">Sign in</h2>
	                <br>
	         
	                <h2 class="type"> Email </h2>
	
	                <input type="text" placeholder="Email" name="email" required autofocus class="box">   
	                <br><br>
	
	                <h2 class="type">Password </h2>

	                <input type="password" placeholder="Password" name="password" required class="box">
	               
	                <input type="submit" value="Connect" name="connect" class="bt">
                
            </form>
            <br><br><br><br><br><br><br><br><br>
            <a style='text-decoration:none'  href="/signup"  ><h1  class="link" >Sign up</h1></a>

 
        </div>
        
    </body>
</html>

