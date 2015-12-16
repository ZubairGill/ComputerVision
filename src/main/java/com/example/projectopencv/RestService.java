package com.example.projectopencv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/myservice")
@ComponentScan("projectopencv")
public class RestService {

	@RequestMapping(value="/service", method=RequestMethod.GET)
	public  String display()
	{
		System.out.println("Running");
		return "HAppy";
	}
	
	@RequestMapping(value="/ser", method=RequestMethod.GET)
	public @ResponseBody responceModel jsonDisplay()
	{
		responceModel r=new responceModel("HELLO","Sir");
		//r.getPath();
		return r;
	}
	
	
}
