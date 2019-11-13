package com.library.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import com.library.api.model.User;
import com.library.api.repository.SystemUserRepository;
import com.library.api.controller.ApiResponse;
import com.library.api.entity.SystemUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;


@SpringBootApplication
@RestController
public class LibraryUmgApplication {

	@Autowired
	SystemUserRepository systemUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryUmgApplication.class, args);
	}

	@RequestMapping(value="/user")
	public ResponseEntity<ApiResponse> user(OAuth2Authentication principal) {
		List<User> data = new ArrayList<>();
		
		try {
			List array = new ArrayList(((LinkedHashMap) ((UsernamePasswordAuthenticationToken) ((OAuth2Authentication) principal).getUserAuthentication()).getDetails()).values());;

			SystemUser systemUser = systemUserRepository.findByEmail((String)array.get(1));

			if (!systemUser.equals(null)) {
				User user = new User();
				user.setId((String)array.get(0));
				user.setEmail((String)array.get(1));
				user.setCompleteName((String)array.get(3));
				user.setFirstName((String)array.get(4));
				user.setLastName((String)array.get(5));
				user.profileImage((String)array.get(6));
				user.setTokenType(((OAuth2AuthenticationDetails) principal.getDetails()).getTokenType());
				user.setTokenValue(((OAuth2AuthenticationDetails) principal.getDetails()).getTokenValue());
				ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
				return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
			} else {
				ApiResponse apiResponse = new ApiResponse("FAIL", "Usuario No Autorizado", null);
				return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.UNAUTHORIZED);
			}

		}catch (Exception e) {
			ApiResponse apiResponse = new ApiResponse("FAIL", "Usuario No Autorizado", null);
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.UNAUTHORIZED);

		}

	}

}
