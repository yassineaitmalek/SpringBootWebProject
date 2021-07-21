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
	        <form method='POST' enctype="multipart/form-data" action="/dashboard/reup/process/">
		        <h3 align = "center" class="type"> Changing file </h3>
		        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<h3 for="f" style ="display:inline-block">Chose file : &nbsp &nbsp </h3>
		        
                            <select  name="file_name" size="1" class="selection" required style ="display:inline-block">
                                            
                                            <option></option>
                                            <option value="photo">Photo	</option>
                                            <option value="copy_cin">Copy CIN					</option>
                                            <option value="copy_bac">Copy Baccalaureat</option>
                                            <option value="certificate_success">Certificate of success</option>
                                           
                                        
                            </select>
                            <br><br><br>
                       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                       <input align="center" type="file" placeholder="Upload your file" name="file_to_upload" required autofocus>
		        
		         <br><br><br> <br><br><br><br><br>
		        <input type="submit" value='Re-Upload' name='reup' class='bt' >
	        
	        </form>

	    
	    </div>
	</body>
</html>

