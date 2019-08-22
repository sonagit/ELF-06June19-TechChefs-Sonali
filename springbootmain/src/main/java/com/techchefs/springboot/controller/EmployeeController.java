package com.techchefs.springboot.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techchefs.springboot.beans.EmployeeAddressInfoBean;
import com.techchefs.springboot.beans.EmployeeEducationInfoBean;
import com.techchefs.springboot.beans.EmployeeExperienceInfoBean;
import com.techchefs.springboot.beans.EmployeeInfoBean;
import com.techchefs.springboot.beans.EmployeeOtherInfoBean;
import com.techchefs.springboot.beans.EmployeeResponse;
import com.techchefs.springboot.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping(path = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String helloWorld() {
		return "Hello World !!!!";
	}
	
	@PostMapping(path="/authenticate",produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse authenticate(Integer id, String password, HttpServletRequest request) {
		EmployeeResponse response = new EmployeeResponse();
		if (repository.existsById(id)) {
			EmployeeInfoBean bean = repository.findById(id).get();
			if (bean != null && bean.getPassword().equals(password)) {
				response.setStatusCode(201);
				response.setMessage("Sucessful");
				response.setDescription("Employee is authenticated successfully");
				response.setBeans(Arrays.asList(bean));
				request.getSession().setAttribute("bean", bean);
			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Invalid Credentials");
			}
		}
		return response;
	}

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse createEmployee(@RequestBody EmployeeInfoBean bean) {
		bean.getOtherInfo().setInfoBean(bean);
		for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressInfoBeans()) {
			addressInfoBean.getAddressPKBean().setInfoBean(bean);
		}
		for (EmployeeEducationInfoBean educationInfoBean : bean.getEducationInfoBeans()) {
			educationInfoBean.getEducationPKBean().setInfoBean(bean);
		}
		for (EmployeeExperienceInfoBean experienceInfoBean : bean.getExperienceInfoBeans()) {
			experienceInfoBean.getExperiencePKBean().setInfoBean(bean);
		}
		for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressInfoBeans()) {
			addressInfoBean.getAddressPKBean().setInfoBean(bean);
		}

		EmployeeInfoBean manager = bean.getMngrId();
		if (manager != null) {
			manager = repository.findById(manager.getId()).get();
			bean.setMngrId(manager);
		}
		EmployeeResponse response = new EmployeeResponse();
		
		if(!repository.existsById(bean.getId())){
			repository.save(bean);
			response.setStatusCode(201);
			response.setMessage("Successful");
			response.setDescription("Employee data added sucessfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data not added");
		}
		return response;
	}

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployee(int id) {
		EmployeeResponse response = new EmployeeResponse();
		if (repository.existsById(id)) {
			EmployeeInfoBean bean = repository.findById(id).get();
			response.setStatusCode(201);
			response.setMessage("Successful");
			response.setDescription("Employee data found sucessfully");
			response.setBeans(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data not found");
		}
		return response;
	}
	
	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse searchEmployee(int id) {
		EmployeeResponse response = new EmployeeResponse();
		if (repository.existsById(id)) {
			EmployeeInfoBean bean = repository.findById(id).get();
			response.setStatusCode(201);
			response.setMessage("Successful");
			response.setDescription("Employee data found sucessfully");
			response.setBeans(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data not found");
		}
		return response;
	}
	
	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean bean) {
		bean.getOtherInfo().setInfoBean(bean);
		for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressInfoBeans()) {
			addressInfoBean.getAddressPKBean().setInfoBean(bean);
		}
		for (EmployeeEducationInfoBean educationInfoBean : bean.getEducationInfoBeans()) {
			educationInfoBean.getEducationPKBean().setInfoBean(bean);
		}
		for (EmployeeExperienceInfoBean experienceInfoBean : bean.getExperienceInfoBeans()) {
			experienceInfoBean.getExperiencePKBean().setInfoBean(bean);
		}
		for (EmployeeAddressInfoBean addressInfoBean : bean.getAddressInfoBeans()) {
			addressInfoBean.getAddressPKBean().setInfoBean(bean);
		}

		EmployeeInfoBean manager = bean.getMngrId();
		manager = repository.findById(manager.getId()).get();
		bean.setMngrId(manager);
		
		EmployeeResponse response = new EmployeeResponse();
		if(repository.existsById(bean.getId())){
			bean.getOtherInfo().setOtherInfoid(repository.findByEmpById(bean).getOtherInfoid());
			repository.save(bean);
			response.setStatusCode(201);
			response.setMessage("Successful");
			response.setDescription("Employee data updated sucessfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data not updated");
		}
		return response;
	}

	@DeleteMapping(path = "/delete/{id}")
	public EmployeeResponse deleteEmployee(@PathParam("id")int id) {
		EmployeeResponse response = new EmployeeResponse();
		if(repository.existsById(id)){
			repository.deleteById(id);
			response.setStatusCode(201);
			response.setMessage("Successful");
			response.setDescription("Employee data deleted sucessfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data not deleted");
		}
		return response;

	}
	@GetMapping(value="/getotherinfo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
	public EmployeeOtherInfoBean getOtherInfo(int id) {
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setId(id);
		return repository.findByEmpById(bean);
	}
}
