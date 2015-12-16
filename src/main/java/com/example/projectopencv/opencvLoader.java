package com.example.projectopencv;

import org.fusesource.hawtjni.runtime.Library;

import ch.qos.logback.core.util.Loader;

public class opencvLoader {

	public static String version="2.4.11";
	private static Object initializeLock=new Object();
	private static boolean initialized=false;
	
	public static void init()
	{
		init(Loader.class.getClassLoader());
	}
	
	public static void init(ClassLoader loader)
	{
		synchronized (initializeLock) {
			if(!initialized)
			{
				Library library=new Library("opencv_java",version,loader);
			}
		}
		
	}
	
	
}
