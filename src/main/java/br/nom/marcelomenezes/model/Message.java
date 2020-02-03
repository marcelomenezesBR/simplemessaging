package br.nom.marcelomenezes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Message  {

	@JsonSetter("business_id")
	@SerializedName("business_id") 
	private String businessId;
	private String name;
	private String address;
	private String city;
	private String state;
	@JsonSetter("postal_code")
	@SerializedName("postal_code")
	private String postalCode;
	private float latitude;
	private float longitude;
	private float stars;
	@JsonSetter("review_count")
	@SerializedName("review_count")
	private int reviewCount;
	@JsonSetter("is_open")
	@SerializedName("is_open")
	private int isOpen;
	@JsonProperty	 ("attributes")
	private br.nom.marcelomenezes.model.Attributes attributes;
	private String categories;
	@JsonProperty("hours")
	private Hours hours;


	@Override
	public String toString() {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(this); 
		return jsonInString;    	
	}


	public String getBusinessId() {
		return businessId;
	}


	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public float getStars() {
		return stars;
	}


	public void setStars(float stars) {
		this.stars = stars;
	}


	public int getReviewCount() {
		return reviewCount;
	}


	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}


	public int getIsOpen() {
		return isOpen;
	}


	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}


	public br.nom.marcelomenezes.model.Attributes getAttributes() {
		return attributes;
	}


	public void setAttributes(br.nom.marcelomenezes.model.Attributes attributes) {
		this.attributes = attributes;
	}


	public String getCategories() {
		return categories;
	}


	public void setCategories(String categories) {
		this.categories = categories;
	}


	public Hours getHours() {
		return hours;
	}


	public void setHours(Hours hours) {
		this.hours = hours;
	}

}
