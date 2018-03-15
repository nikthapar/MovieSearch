package com.training.controller;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * Servlet implementation class login
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String temp1 = request.getParameter("ids");
		   String[] id = temp1.split(",");
	       request.setAttribute("id",id);
	       ArrayList<String> arr = new ArrayList<>();
	       for(String temp : id)
	    	   arr.add(temp);
		   FileRead obj1 = new FileRead(arr);
		   obj1.fileread();
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
	      /* RequestDispatcher dispatcher = request.getRequestDispatcher("favroite.jsp");
	       dispatcher.forward(request,response);*/
	       //response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
	}

}
