package org.doofinder.pojos.users;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDetailsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("exists")
	private Boolean exists;

	@JsonProperty("user_details")
	private UserDetailsVO userDetails;
	@JsonProperty("user_details_list")
	private List<UserDetailsVO> userDetailsList;

	public Boolean getExists() {
		return exists;
	}

	public void setExists(Boolean exists) {
		this.exists = exists;
	}

	public UserDetailsVO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsVO userDetails) {
		this.userDetails = userDetails;
	}

	public List<UserDetailsVO> getUserDetailsList() {
		return userDetailsList;
	}

	public void setUserDetailsList(List<UserDetailsVO> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}

}
