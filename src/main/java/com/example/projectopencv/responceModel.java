package com.example.projectopencv;

public class ResponceModel {

	private String path;
	private String title;
	
	public ResponceModel(String d,String t) {
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
