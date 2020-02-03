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
public class Attributes {
	@SerializedName("GoodForKids")
	@JsonProperty("GoodForKids")
	public String goodForKids;
			
	@JsonCreator
	public Attributes (@JsonProperty("GoodForKids") String goodForKids){
		this.goodForKids = goodForKids;
	}
}

