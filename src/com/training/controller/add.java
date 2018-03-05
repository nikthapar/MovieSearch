package com.training.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		   
	      /* RequestDispatcher dispatcher = request.getRequestDispatcher("favroite.jsp");
	       dispatcher.forward(request,response);*/
	       response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
	}

}
