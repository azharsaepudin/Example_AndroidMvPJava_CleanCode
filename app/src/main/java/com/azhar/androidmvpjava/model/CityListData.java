package com.azhar.androidmvpjava.model;

public class CityListData {
	//private String background;
	private String NAMA;
	private String NPM;
	private String NO;

//	public void setBackground(String background){
//		this.background = background;
//	}
//
//	public String getBackground(){
//		return background;
//	}

	public void setName(String NAMA){
		this.NAMA = NAMA;
	}

	public String getNAMA(){
		return NAMA;
	}

	public void setNPM(String NPM){
		this.NPM = NPM;
	}

	public String getNPM(){
		return NPM;
	}

	public void setNO(String NO){
		this.NO = NO;
	}

	public String getNO(){
		return NO;
	}

	@Override
 	public String toString(){
		return 
			"Response{" +
			"NAMA = '" + NAMA + '\'' +
			",description = '" + NPM + '\'' +
			",id = '" + NO + '\'' +
			"}";
		}
}
