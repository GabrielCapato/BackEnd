/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupointegrado.Servlet;

import br.com.grupointegrado.dao.AnuncioDao;
import br.com.grupointegrado.model.Anuncio;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Capato
 */
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        RequestDispatcher JotaQuest = req.getRequestDispatcher("/WEB-INF/paginas/index.jsp");
        
        AnuncioDao dao = new AnuncioDao();
        List<Anuncio> Listobj = (List<Anuncio>) dao.getAllAnuncio();
        try {
            
        req.setAttribute("anuncios", Listobj);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
       
        JotaQuest.forward(req, resp);
    }

  

}
