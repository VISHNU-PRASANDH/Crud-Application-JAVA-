package com.project.SERVLET;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.project.DAO.UserDao;
import com.project.POJO.UserPojo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/") 
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("Requested path: " + path);

        switch (path) 
        {
            case "/insert":
                System.out.println("Insert triggered");
                try {
                    insertData(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/viewdata":
               System.out.println("data is displayed");
			   try 
			   {
				  selectAllData(request, response);
			   }
			   catch (Exception e)
			   {
				// TODO Auto-generated catch block
				 e.printStackTrace();
			   }
               break;
            case "/delete":
            	System.out.println("delete");
			  try 
			  {
				  deleteData(request, response);
			  } 
			  catch (Exception e)
			  {
				// TODO Auto-generated catch block
				  e.printStackTrace();
			  }
              break;
            case "/edit":
			try 
			{
				showEditForm(request, response);
			} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            break;
            case "/update":
			try
			{
				updateUser(request,response);
			} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            break;
            default:
                System.out.println("No matching path found");
        }
    }

    private void insertData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");

        UserPojo userpojo = new UserPojo();
        userpojo.setId(id);
        userpojo.setName(name);
        userpojo.setDesignation(designation);

        UserDao userdao = new UserDao();
        userdao.insertData(userpojo);
    }

    private void selectAllData(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	UserDao userdao=new UserDao();
		try 
		{
			List<UserPojo> userlist=userdao.selectAllData();
			request.setAttribute("alluser", userlist);
			RequestDispatcher ds=request.getRequestDispatcher("viewdata.jsp");
			try 
			{
				ds.forward(request, response);
			} 
			catch (ServletException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    private void deleteData(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	int id = Integer.parseInt(request.getParameter("id"));
    	UserDao userdao = new UserDao();
    	userdao.deleteData(id);
    	response.sendRedirect("viewdata");
    	
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	int id = Integer.parseInt(request.getParameter("id"));
        UserDao dao = new UserDao();
        UserPojo existingUser = dao.selectUser(id);
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateform.jsp");
        dispatcher.forward(request, response);
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 int id = Integer.parseInt(request.getParameter("id"));
         String name = request.getParameter("name");
         String designation = request.getParameter("designation");

         UserPojo user = new UserPojo();
         user.setId(id);
         user.setName(name);
         user.setDesignation(designation);

         UserDao dao = new UserDao();
         dao.updateUser(user);
         response.sendRedirect("viewdata");
    }

    
}
