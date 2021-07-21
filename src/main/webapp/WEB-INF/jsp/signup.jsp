<!DOCTYPE html>
<html>
    <head>
        <title>Sign up</title>
       
        <style><%@include file="/WEB-INF/css/style.css"%></style>
        <style><%@include file="/WEB-INF/css/style2.css"%></style>
        <style><%@include file="/WEB-INF/css/nav.css"%></style>
         <style><%@include file="/WEB-INF/css/style3.css"%></style>
        
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
		
		${error }
		
		
        
		<br><br> <br><br>
		
		 <form method="post" enctype="multipart/form-data" action="/up">

            <table class="t"  width="75%" height="50%" bgcolor="white" align="center">

                    <tr>
                        <td colspan="2" align="center">
                            <h3 for="matricule">Matricule :  </h3>
                           <input type="text" placeholder="matricule" name="matricule" required autofocus class="box" >
                            
                             
                        </td>
                        
                    </tr>
                    <tr>
                        <td>
                            <h3 for="pass">Password : </h3>
                            
                            <input type="password" placeholder="Password" name="pass" required autofocus class="box">
                        </td>
                        <td>
                            <h3 for="cpass">Password Confirmation : </h3>
                           
                            <input type="password" placeholder="Password" name="cpass" required autofocus class="box">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3 for="nom">First Name : </h3>
                            
                            <input type="text" placeholder="First Name" name="fname" required autofocus class="box"> 
                        </td>
                        <td>
                            <h3 for="prenom">Last Name : </h3>
                            
                            <input type="text" placeholder="Last Name" name="lname" required autofocus class="box">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <h3 for="date">Date of Birth : </h3>
                            
                            <input type="date" placeholder="YYYY / MM / DD" name="date" required autofocus class="box">
                        </td>
                        
                    </tr>
                    <tr>
                    
                    <td>
                            <h3 for="sexe">Sexe : </h3>
                            
                            
                              <h3 for="homme">	Man : <input type="radio" name="sexe" value="M"  class="check" required>  
                              					Woman : <input type="radio" name="sexe" value="F"  class="check"required>
                               </h3> 
                              
                        </td>
                        <td >
                            
                                <h3 for="cycle">Cycle : </h3>
                                
                                <select  name="cycle" size="1" class="selection" required> 
                                                
                                                <option></option>
                                                <option >Engineer</option>
                                                <option >Master</option>
                                                <option >Phd</option>
                                                
                                </select>
                                <br><br><br>
                        </td>
                    
                    </tr>
                    <tr>
                        <td>
                            <h3 for="niveau">Grade : </h3>
                            <select  name="grade" size="1" class="selection" required>
                                            
                                            <option></option>
                                            <option >1st year</option>
                                            <option >2nd year</option>
                                            <option >3rd year</option>
                                            <option >4th year</option>
                                            
                            </select>
                            <br><br><br>
                        </td>
                        <td>
                            <h3 for="filiere">Major : </h3>
                            <select  name="major" size="1" class="selection" required>
                                            
                                            <option></option>
                                            <option >Data & Software Engineering</option>
                                            <option >Data Science</option>
                                            <option >Statistique-Economie Appliquee</option>
                                            <option >Recherche Operationnelle et Aide a la Decision</option>
                                            <option >Statistique-Demographie</option>
                                            <option >Actuariat-Finance</option>
                                            <option >Etc</option>

                                        
                            </select>
                            <br><br><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3 for="photo">Photo : </h3>
                                        <input type="file" placeholder="Entrer votre photo" name="photo" required autofocus>
                                        <br><br><br>
                        </td>
                        <td>
                            <h3 for="copie_cin">Copy CIN : </h3>
                            <input type="file" placeholder="Entrer votre copie cin" name="copy_cin" required autofocus>
                            <br><br><br>
                    </td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h3 for="copie_baccalaureat">Copy Baccalaureat : </h3>
                                        <input type="file" placeholder="Entrer votre copie baccalaureat" name="copy_bac" required autofocus>
                                        <br><br><br>
                        </td>
                        <td>
                            <h3 for="attestation_reussite">Certificate of success  : </h3>
                            <input type="file" placeholder="Entrer votre attestation reussite" name="certificate_success " required autofocus>
                            <br><br><br>
                        </td>

                    <tr>
                        <td height="100px" width="100px" align="center">
                            <input type="submit" value="Create" name="create" class="block">
                        <td height="100px" width="100px" align="center">
                            <input type="reset" value="Initialize " name="reset" class="block">
                            
                        </td>
                    </tr>

            </table>
            
                
        </form>
        
        <br><br>

        <form  method="post" action="/" >
            
             <input type="submit" value="Return" name="return" class="block" align = "center" style = ' margin: auto ;transform: translate(675px,0px);'>
        </form>


   
		
    
    </body>
</html>
    