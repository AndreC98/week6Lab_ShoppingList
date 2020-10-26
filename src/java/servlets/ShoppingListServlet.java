/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andre
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        String sessionUsername = (String) session.getAttribute("username");
        
        if (action != null){
            if(action.equals("logout")){
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
            }
        }
        if(sessionUsername != null){
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
                    .forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = (String) request.getParameter("action");
        ArrayList<String> items = (ArrayList) session.getAttribute("items");
        if (items == null){
            items = new ArrayList<>();
        }

        switch (action) {
            case "register":
                String username = (String) request.getParameter("username");
                if(username == null || username.length() == 0){
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
                }
                else{
                session.setAttribute("username", username);
                break;
                }
            case "add":
                {
                    String item = (String) request.getParameter("item");
                    if(item.length() > 0){
                    items.add(item);
                    request.setAttribute("item", " ");
                    }
                    break;
                }
            case "delete":
                {
                    String item = request.getParameter("itemsList");
                    items.remove(item);
                    break;
                }
            default:
                break;
        }
        session.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp")
                    .forward(request, response);

    }

}
