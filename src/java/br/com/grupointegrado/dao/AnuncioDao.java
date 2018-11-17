package br.com.grupointegrado.dao;

import static br.com.grupointegrado.dao.Conexao.getConexaoMySQL;
import br.com.grupointegrado.model.Anuncio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnuncioDao extends Conexao {

    private PreparedStatement ps;
    private ResultSet rs;

    Connection c = getConexaoMySQL();

    public void inserir(Anuncio obj) {
        try {

            String sql = "INSERT INTO VeiculoAPS.anuncio(ID_anuncio,nomeCarro,anoFabricacao,anoModelo,KM,valor,combustivel,categoria,descr,CaminhoIMG)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";

            ps = getConexaoMySQL().prepareStatement(sql);

            ps.setInt(1, obj.getId());
            ps.setString(2,obj.getNome());
            ps.setInt(3,obj.getAnoFabric());
            ps.setInt(4,obj.getAnoModelo());
            ps.setDouble(5, obj.getKM());
            ps.setDouble(6, obj.getValor());
            ps.setString(7, obj.getTipoCombustivel());
            ps.setString(8, obj.getCategoria());
            ps.setString(9, obj.getDescricao());
            ps.setString(10, obj.getCaminho());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Anuncio getAnuncio(Integer ID) {
        try {
            String sql = "SELECT * FROM VeiculoAPS.anuncio WHERE ID_anuncio = ?";

            ps = getConexaoMySQL().prepareStatement(sql);
            ps.setInt(1, ID);

            ps.execute();

            if (rs.next()) {
                Anuncio obj = new Anuncio();
                obj.setId(rs.getInt("ID_anuncio"));
                obj.setAnoFabric(rs.getInt("anoFabricacao"));
                obj.setAnoModelo(rs.getInt("anoModelo"));
                obj.setKM(rs.getDouble("KM"));
                obj.setValor(rs.getDouble("valor"));
                obj.setTipoCombustivel(rs.getString("combustivel"));
                obj.setCategoria(rs.getString("combustivel"));
                obj.setDescricao(rs.getString("descr"));
                obj.setCaminho(rs.getString("CaminhoIMG"));
                return obj;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return null;
    }

    public List<Anuncio> getAllAnuncio() {
        try {
            String sql = "SELECT * FROM VeiculoAPS.anuncio";

            ps = getConexaoMySQL().prepareStatement(sql);

            ps.execute();

            List<Anuncio> Lista = new ArrayList<>();

            while (rs.next()) {
                Anuncio obj = new Anuncio();

                obj.setId(rs.getInt("ID_anuncio"));
                obj.setAnoFabric(rs.getInt("anoFabricacao"));
                obj.setAnoModelo(rs.getInt("anoModelo"));
                obj.setKM(rs.getDouble("KM"));
                obj.setValor(rs.getDouble("valor"));
                obj.setTipoCombustivel(rs.getString("combustivel"));
                obj.setCategoria(rs.getString("combustivel"));
                obj.setDescricao(rs.getString("descr"));
                obj.setCaminho(rs.getString("CaminhoIMG"));

                Lista.add(obj);

            }

            return Lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
