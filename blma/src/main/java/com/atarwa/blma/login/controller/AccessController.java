package com.atarwa.blma.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atarwa.blma.common.util.Util;
import com.atarwa.blma.login.model.Login;
import com.atarwa.blma.login.model.Role;
import com.atarwa.blma.login.service.UserService;

@RestController
public class AccessController {
 
	@Autowired
	UserService userService;
	
	@Autowired
	Login login;
	
    @RequestMapping(value = "/role/{userRole}", method = RequestMethod.GET)
    public ResponseEntity<Login> adminPage(ModelMap model, @PathVariable("userRole") String userRole) {
    	if(Role.contains(userRole.toUpperCase())) {
    		login.setRole(userRole);
    		login.setUserName(Util.getPrincipal());
    		login.setAuthenticated(true);
    		return new ResponseEntity<Login>(login, HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
    	}
    }
 
}
