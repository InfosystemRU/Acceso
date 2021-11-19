package org.doofinder.pojos.users;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDetailsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("user_details")
	private UserDetailsVO userDetails;

	public UserDetailsVO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsVO userDetails) {
		this.userDetails = userDetails;
	}

}
