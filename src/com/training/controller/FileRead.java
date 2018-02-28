package com.training.controller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileRead {
    @SuppressWarnings("unchecked")
    ArrayList<String> str = null;
    FileRead(){
    	super();
    }
    FileRead(ArrayList<String> arr){
    	str=arr;
    	//System.out.println(str.size());
    }
	@SuppressWarnings("unchecked")
	void fileread() throws IOException {
		System.out.println("hello");
    	String sRootPath = new File("").getAbsolutePath();
    	File fs = new File(sRootPath+"/ADD.json");
    	//String sRootPath = new File("").getAbsolutePath();
    	fs.createNewFile();
		JSONObject obj = new JSONObject();
    	JSONArray list = new JSONArray();
    	for(String temp3 : str) {
    	list.add(temp3);
    	}
    	obj.put("Movies",list);
    	FileWriter f=null;
		try {
			f = new FileWriter(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String temp = obj.toString();
        try {
			f.write(temp);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        try {
			f.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(temp);
    	
    	JSONParser parser = new JSONParser();
        Object obj1=null;
		try {
			obj1 = parser.parse(new FileReader(fs));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        @SuppressWarnings("unused")
		JSONObject jsonobject = (JSONObject)obj1;
        JSONArray name = (JSONArray)jsonobject.get("Movies");
        int length = name.size();
        System.out.println(length);
        
    }
}
