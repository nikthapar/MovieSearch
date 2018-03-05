package com.training.controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class view
 */
@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		if(type.equals("0")) {
		String path = new File("").getAbsolutePath()+"/ADD.json";
		JSONParser parser = new JSONParser();
			JSONObject main=null;
			try {
				main = (JSONObject) parser.parse(new FileReader(path));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/json");
			response.getWriter().write(main.toString());
		}
		else if(type.equals("1")) {
			 String index = request.getParameter("index");
			 FileRead obj1 = new FileRead();
			 obj1.fileremove(index);
			 String path = new File("").getAbsolutePath()+"/ADD.json";
				JSONParser parser = new JSONParser();
					JSONObject main=null;
					try {
						main = (JSONObject) parser.parse(new FileReader(path));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					response.setContentType("application/json");
					response.getWriter().write(main.toString());
				
		}
		else if(type.equals("2")){
			String path = new File("").getAbsolutePath()+"/ADD.json";
			JSONParser parser = new JSONParser();
				JSONObject main=null;
				try {
					main = (JSONObject) parser.parse(new FileReader(path));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.setContentType("application/json");
				response.getWriter().write(main.toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
