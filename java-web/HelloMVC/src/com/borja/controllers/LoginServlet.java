package com.borja.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.borja.database.BBDD;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   request.getRequestDispatcher("/login.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String emailrecib =request.getParameter("nombre");
		 String passrecib =request.getParameter("password");
	
		System.out.println("ESTOY en el post");
		System.out.println("este es tu" + emailrecib);
		System.out.println("este es tu" + passrecib);
		
		BBDD bd = BBDD.getInstance();
		
		
		boolean existeuser = bd.existeUsuarioPorEmailYPass(emailrecib,passrecib);
		
		//decidir si existe usuario cn ese email y pass.. entrar en listausuarios
		//si no ...volver a mostrar formulario
		
		
		HttpSession session = request.getSession();
		
		if(existeuser) {
			//llevarlo
			//si queremos que el usuario no vea la ruta
			// request.getRequestDispatcher("/ListaUsuarios").forward(request, response);
			//si queremos q el usuario vea la ruta
			session.setAttribute("usuario", emailrecib);
			response.sendRedirect("listaUsuarios");
		}else {
			request.setAttribute("errormensaje", "contraseņa y email invalidos");
			doGet(request,response);
		}
	}

}
