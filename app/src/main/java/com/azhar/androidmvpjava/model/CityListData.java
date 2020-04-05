package com.azhar.androidmvpjava.model;

public class CityListData {
	private String background;
	private String name;
	private String description;
	private String id;

	public void setBackground(String background){
		this.background = background;
	}

	public String getBackground(){
		return background;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"background = '" + background + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
