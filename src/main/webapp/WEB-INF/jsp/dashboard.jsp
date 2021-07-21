<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>DashBoard INSEA </title>
       
        <link rel = "shortcut icon" type = 'img/png' href="/WEB-INF/images/INSEA_logo.png" >
       
        <style><%@include file="/WEB-INF/css/style1.css"%></style>
        
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
  	
  	
  	
  		<br><br><br>
      	<h3 align="center"> Hello ${name} </h3>
      	<br>
        <h3 align="center">Here are your Data</h3>
		
		<div class="table-wrapper">
      	<table  cellspacing="0" border="1" class="fl-table">
      		<thead>
      			<tr>
                  	<th> Matricule</th>
                    <th> Last Name</th>
                    <th> First name</th>
                    <th> Cycle</th>
                    <th> Major</th>
                    <th> Grade</th>
                    <th> Date of Birth</th>
  
                    <th>Photo</th>
                    <th>CIN</th>
                    <th>Baccalaureat</th>
                    <th>Certificate of success</th>

            	

      				
      			</tr>
      		</thead>
      		<tbody>
				<tr>
					<td>	${si.matricule}		</td>
					<td>	${si.lname}			</td>
                    <td>	${si.fname}		</td>
                    <td>	${si.cycle}		</td>
                    <td>	${si.major}		</td>
                    <td>	${si.grade}		</td>
                    <td>	${si.date}		</td>
                           
                            
                    <td><a  style='text-decoration:none;' href= "/dashboard/show/${sd.matricule}/${sd.photo}"		target="pdf-frame">Show</a></td>
                    <td><a  style='text-decoration:none;' href=	"/dashboard/show/${sd.matricule}/${sd.copy_cin}"		 		target='_blank'>Show</a></td>
                    <td><a  style='text-decoration:none;' href=	"/dashboard/show/${sd.matricule}/${sd.copy_bac}"				target='_blank'>Show</a></td>
                    <td><a  style='text-decoration:none;' href=	"/dashboard/show/${sd.matricule}/${sd.certificate_success}" 	target='_blank'>Show</a></td>
                           
               	</tr>

            </tbody>

        	</table>
            
        </div>
  	
  	
  
    </body>

</html>
  