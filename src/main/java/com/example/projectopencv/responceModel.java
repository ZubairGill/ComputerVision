package com.example.projectopencv;

public class responceModel {

	private String path;
	private String title;
	
	public responceModel(String d,String t) {
		path=d;
		title=t;
	}
	
	public String getPath()
	{
		return path ;
	}
	public String getTitle() {
		return title;
	}
	
}
