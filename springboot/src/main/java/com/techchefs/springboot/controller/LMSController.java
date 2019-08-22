package com.techchefs.springboot.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techchefs.springboot.beans.LMSResponse;
import com.techchefs.springboot.beans.UserBean;
import com.techchefs.springboot.repository.LMSRepository;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class LMSController {

	@Autowired
	LMSRepository repository;

	@GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String helloWorld() {
		return "Welcome to Library Management System !!!!";
	}

	@PostMapping(path = "/adduser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LMSResponse addUser(@RequestBody UserBean userbean) {

		LMSResponse response = new LMSResponse();

		if (!repository.existsById(userbean.getUserEmailId())) {
			repository.save(userbean);
			response.setStatusCode(201);
			response.setMessage("Successful");
			response.setDescription("User data added sucessfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("User data not added");
		}
		return response;
	}

	@GetMapping(path = "/getuser", produces = MediaType.APPLICATION_JSON_VALUE)
	public LMSResponse getUser(String id) {
		LMSResponse response = new LMSResponse();
		if (repository.existsById(id)) {
			UserBean bean = repository.findById(id).get();
			response.setStatusCode(201);
			response.setMessage("Successful");
			response.setDescription("User data found sucessfully");
			response.setBeans(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("User data not found");
		}
		return response;
	}

	@PostMapping(path = "/updateuser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LMSResponse updateUser(@RequestBody UserBean bean) {

		LMSResponse response = new LMSResponse();
		if (repository.existsById(bean.getUserEmailId())) {
			repository.save(bean);
			response.setStatusCode(201);
			response.setMessage("Successful");
			response.setDescription("User data updated sucessfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("User data not updated");
		}
		return response;
	}

	@DeleteMapping(path = "/deleteuser")
	public LMSResponse deleteUser(@PathParam("emailId") String emailId) {
		LMSResponse response = new LMSResponse();
		if (repository.existsById(emailId)) {
			repository.deleteById(emailId);
			response.setStatusCode(201);
			response.setMessage("Successful");
			response.setDescription("User data deleted sucessfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("User data not deleted");
		}
		return response;

	}

	@PostMapping(path = "/login/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
	public LMSResponse authenticate(String emailId, String password, HttpServletRequest request) {
		LMSResponse response = new LMSResponse();
		if (repository.existsById(emailId)) {
			UserBean bean = repository.findById(emailId).get();
			if (bean != null && bean.getPassword().equals(password)) {
				response.setStatusCode(201);
				response.setMessage("Sucessful");
				response.setDescription("User is authenticated successfully");
				response.setBeans(Arrays.asList(bean));
				request.getSession().setAttribute("bean", bean);
			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Invalid Credentials");
			}
			if (bean.getBanStatus()) {
				response.setStatusCode(4001);
				response.setMessage("Banned");
				response.setDescription("User is banned please pay your dues");
			}
		}
		return response;
	}

}
