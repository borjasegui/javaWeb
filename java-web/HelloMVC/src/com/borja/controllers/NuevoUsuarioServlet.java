package com.borja.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borja.database.BBDD;
import com.borja.models.Habitacion;
import com.borja.models.Usuario;

@WebServlet("/nuevousuario")
public class NuevoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Habitacion> habitaciones = BBDD.getInstance().Habitaciones;
		
		request.setAttribute("lasHabitaciones", habitaciones);
		request.getRequestDispatcher("/nuevousuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombrerecib = request.getParameter("nombre");
		String emailrecib = request.getParameter("email");
		String passrecib = request.getParameter("password");
		String confirmrecib = request.getParameter("confirmacion");
		String habitacionrec = request.getParameter("habitacion");
		
		System.out.println("habitacion: " +habitacionrec);

		Usuario nuevoUser = new Usuario(0, nombrerecib, passrecib, emailrecib, null);

		if (nuevoUser.esValido(confirmrecib)) {
			
			BBDD bbdd = BBDD.getInstance();
			bbdd.insertarUsuario(nuevoUser);
			response.sendRedirect("listaUsuarios");

		} else {
			request.setAttribute("mensajeerror", "datos incorrectos");
			request.setAttribute("newusuario", nuevoUser);
			this.doGet(request, response);
		}

	}

}
