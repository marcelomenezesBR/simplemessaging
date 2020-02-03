package br.nom.marcelomenezes.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * Model class of Hours
 * Annotation used to expose different fields names
 * 		- JsonCreator - for Jackson deserialization
 * 		- SerializedName - for Gson serialization
 * 		- JsonProperty - to relate different fields names
 *		- JsonAutoDetect - detect public fields 
 */

@JsonAutoDetect
public class Hours  {
	@SerializedName("Tuesday") 
	private String tuesday;
	@SerializedName("Wednesday") 
	private String wednesday;
	@SerializedName("Thursday")
	private String thursday;
	@SerializedName("Friday")
	private String friday;
	@SerializedName("Saturday")
	private String saturday;
	
	/**
	 * Constructor for deserializaztion
	 * @param tuesday
	 * @param wednesday
	 * @param thursday
	 * @param friday
	 * @param saturday
	 */
	@JsonCreator
	public Hours(@JsonProperty("Tuesday") String tuesday,@JsonProperty("Wednesday")String wednesday,@JsonProperty("Thursday")String thursday,
			@JsonProperty("Friday")String friday,@JsonProperty("Saturday")String saturday) {
		this.tuesday=tuesday;
		this.wednesday=wednesday;
		this.thursday=thursday;
		this.friday=friday;
		this.saturday=saturday;
	}


	//Getters and Setters
	
	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

}