package com.vozisov.chucknorrisjokes.model;

import com.google.gson.annotations.SerializedName;

public class Joke{

	@SerializedName("icon_url")
	private String iconUrl;

	@SerializedName("id")
	private String id;

	@SerializedName("category")
	private String category;

	@SerializedName("value")
	private String value;

	@SerializedName("url")
	private String url;

	public String getIconUrl(){
		return iconUrl;
	}

	public String getId(){
		return id;
	}

	public String getCategory(){
		return category;
	}

	public String getValue(){
		return value;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Joke{" + 
			"icon_url = '" + iconUrl + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",value = '" + value + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}