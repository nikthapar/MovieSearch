package com.training.controller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileRead {
    @SuppressWarnings("unchecked")
    ArrayList<String> str = null;
    static int count = 0;
    FileRead(){
    	super();
    }
    FileRead(ArrayList<String> arr){
    	str=arr;
    	//System.out.println(str.size());
    }
	@SuppressWarnings({ "unchecked", "null" })
	void fileread() throws IOException {
		System.out.println("hello");
    	String sRootPath = new File("").getAbsolutePath();
    	System.out.println(sRootPath);
    	File fs = new File(sRootPath+"/ADD.json");
    	//String sRootPath = new File("").getAbsolutePath();
    	fs.createNewFile();
    	JSONParser parser = new JSONParser();
        Object obj1=null;
		try {
			obj1 = parser.parse(new FileReader(fs));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject();
        @SuppressWarnings("unused")
		JSONObject obj2 = (JSONObject)obj1;
        if(obj2 != null)
        	obj=obj2;
    	JSONArray list = new JSONArray();
    	JSONArray rand = (JSONArray) obj.get("Movies");
    	if(rand != null) {
    		Iterator<String> key = rand.iterator();
    		while(key.hasNext()) {
    			list.add((String)key.next());
    		}

    		for(String temp3 : str) {
    			key = rand.iterator();
    			int flag = 0;
    			while(key.hasNext()) {
    				if(temp3.equals((String)key.next())){
    					flag = 1;
    					break;
    				}
    			}
    			if(flag == 0)
    				list.add(temp3);
    		}
    	}
    	else {
    	for(String temp3 : str) {
	    	list.add(temp3);
	    	}
    	}
		obj.put("Movies", list);
		count = list.size();
		obj.put("count", list.size());
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
    	
    	parser = new JSONParser();
        obj1=null;
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
	@SuppressWarnings("unchecked")
	public void fileremove(String i) throws IOException {
		int index=Integer.parseInt(i);
		System.out.println("hello");
    	String sRootPath = new File("").getAbsolutePath();
    	System.out.println(sRootPath);
    	File fs = new File(sRootPath+"/ADD.json");
    	//String sRootPath = new File("").getAbsolutePath();
    	fs.createNewFile();
		JSONParser parser = new JSONParser();
        Object obj1=null;
		try {
			obj1 = parser.parse(new FileReader(fs));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject obj = (JSONObject)obj1;
		JSONArray arr = (JSONArray) obj.get("Movies");
		if(index < 0 || index >= arr.size()) {
			obj.put("flag", "0");
		}
		else {
		     arr.remove(index);
		     obj.put("Movies", arr);
		     int len = arr.size();
		     obj.put("count",len );
		     obj.put("flag", "1");
		     count = arr.size();
		}
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
	}
}
