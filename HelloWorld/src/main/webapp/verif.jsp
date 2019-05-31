<%@ page import="jpa.LoginEntityManager" %>
<%@ page import="model.Login" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    Login user = new Login (login, password);

   /* LoginEntityManager loginEntityManager= new LoginEntityManager();
   // Login user= loginEntityManager.findByLoginAndPassword(login,password);
    if(user!=null){
        response.sendRedirect("home.jsp");
    }else{
        // wrong username and password
       // response.sendRedirect("index.jsp");
    }*/
      if(login!= user.getLogin()||password != user.getPassword()) {
            System.out.println("Error1");
            request.setAttribute("message", "Wrong login or password");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if(login == user.getLogin() & password == user.getPassword()) {
            System.out.println("Ok");
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else if(login == null || password == null){
            System.out.println("Error3");
            request.setAttribute("message", "All the fields are not completed");
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        }


%>