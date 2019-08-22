package com.techchefs.springboot.beans;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName("user-response")
public class LMSResponse {
	
	@JsonProperty("status-code")
	private int statusCode;
	private String message; 
	private String description;
	private List<UserBean> beans;
	
}
