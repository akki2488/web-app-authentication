package com.bss.auth.service;

import com.bss.auth.model.Role;
import com.bss.auth.model.User;
import com.bss.auth.repositories.RoleRepository;
import com.bss.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Rocky on 14-11-2018.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
		});
		return authorities;
	}

	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

    public User saveUser(User user) {
		System.out.println("CustomUserDetailsService saveUser, user: "+ user);
	    User newUser = new User();
	    newUser.setUserName(user.getUserName());
	    newUser.setPassword(passwordEncoder().encode(user.getPassword()));
	    newUser.setFirstName(user.getFirstName());
	    newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setMobile(user.getMobile());

	    List<Role> roles = roleRepository.findAll();
		System.out.println("CustomUserDetailsService existing, roles: "+ roles);

	    if(roles == null || roles.isEmpty()) {
	    	List<Role> defaultRoles = new ArrayList<>();
			defaultRoles.add(new Role("ADMIN", "ADMIN"));
			defaultRoles.add(new Role("BUYER", "BUYER"));
			defaultRoles.add(new Role("SELLER", "SELLER"));
			roleRepository.saveAll(defaultRoles);
		}

		Role userRole = roleRepository.findByRole("ADMIN");
		newUser.setRoles(new HashSet<>(Arrays.asList(userRole)));
		newUser.setEnabled(true);
		System.out.println("CustomUserDetailsService saving, newUser: "+ newUser);
        return userRepository.save(newUser);
    }
}
