package br.nom.marcelomenezes.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

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

