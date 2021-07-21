package com.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Userservice implements UserDetailsService {

	@Autowired
	private UserCRUD userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new Userdetail(user);
	}
	
	public void CreateUser(String email,String pass,String matricule) {
		User user = new User();
		user.setEmail(email);
		user.setMatricule(matricule);
		user.setPass(pass);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPass());
		user.setPass(encodedPassword);
		
		userRepo.save(user);
	}
	
	public User CreateUserwithoutsave(String email,String pass,String matricule) {
		User user = new User();
		user.setEmail(email);
		user.setMatricule(matricule);
		user.setPass(pass);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String encodedPassword = passwordEncoder.encode(user.getPass());
		user.setPass(encodedPassword);
		
		return user;
	}
	
	public boolean Matchpass(String pass , String dbpass) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(pass, dbpass);
		
	}
	
	public User getUser(String matricule) {
		User u = userRepo.findByMatricule(matricule);
		return u;
	}
	
	public void UpdatePasswordUser(User user ,String password) {
		
		user.setPass(password);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPass());
		user.setPass(encodedPassword);
		userRepo.save(user);
	}
	
	public String EncodePassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		return encodedPassword;
	}
	
	public void DeleteUser(String matricule) {
		User u = this.getUser(matricule);
		
		userRepo.delete(u);
	}

}
