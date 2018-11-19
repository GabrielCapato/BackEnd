/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupointegrado.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Capato
 */
public class AnunciarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher JotaQuest = req.getRequestDispatcher("/WEB-INF/paginas/anunciar.jsp");
        JotaQuest.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProdutoModel produto = new ProdutoModel();
            ProdutoController controller = new ProdutoController();
            produto.setDescProduto(request.getParameter("descricao"));
            produto.setDescMarca(request.getParameter("marca"));
            produto.setQntProduto(Integer.parseInt(request.getParameter("qntidade")));
            produto.setValorUnitario(Float.parseFloat(request.getParameter("valorUnitario").replace(",", ".")));
            controller.salvar(produto);
            response.sendRedirect("/admin/SalvoSucesso.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ''

}
