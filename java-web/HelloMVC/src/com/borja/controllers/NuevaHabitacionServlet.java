package com.borja.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borja.database.BBDD;
import com.borja.models.Habitacion;
import com.borja.models.Usuario;

@WebServlet("/nuevahabitacion")
public class NuevaHabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/nuevahabitacion.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String callerecib =request.getParameter("calle");
		 String metrosrecib =request.getParameter("metros");
		 
		 double metrosrecibdouble =0;
		 
		 try {
			 metrosrecibdouble = Double.parseDouble(metrosrecib);
		} catch (Exception e) {
			System.out.println("Execepcion!!!!: " + e.getMessage());
			
		}
		 
		 Habitacion nuevaHabitacion = new Habitacion(0, callerecib, metrosrecibdouble);

			if (nuevaHabitacion.esValido()) {

				BBDD bbdd = BBDD.getInstance();
				bbdd.insertarHabitacion(nuevaHabitacion);
				response.sendRedirect("nuevousuario");

			} else {
				request.setAttribute("mensajeerror", "datos incorrectos");
				request.setAttribute("nuevahabitacion", nuevaHabitacion);
				this.doGet(request, response);
			}
		  
		
		
	}

}
