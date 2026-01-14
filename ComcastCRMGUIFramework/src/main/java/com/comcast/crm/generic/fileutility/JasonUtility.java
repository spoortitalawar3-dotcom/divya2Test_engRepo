package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JasonUtility {
	public String getdataFromJsonFile(String key) throws Throwable {
		//step:1 GET THE JAVA OBJECT OF THE PHYSICAL FILE
		FileReader fileR=new FileReader("./configAppData/appCommonData.json");
		JSONParser parser = new JSONParser();
		
		//PASS THAT FILE INTO ACTUAL JAVA OBJECT
		Object obj = parser.parse(fileR);//CONVERTED TO JAVA OBJECT
		
		//CONVERT THAT TO HASH MAP KEY AND VALUE PAIR
		JSONObject map=(JSONObject)obj;//DOWNCASTED THE JAVA OBJECT TO JASON OBJECT
		
		 String data = (String)map.get(key);
		 return data;
		

}}
