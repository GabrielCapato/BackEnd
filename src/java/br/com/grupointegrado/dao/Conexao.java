package br.com.grupointegrado.dao;

//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Properties;

//Início da classe de conexão//
public class Conexao {

    public static String status = "Não conectou...";

//Método Construtor da Classe//
    public Conexao() {

    }

//Método de Conexão//
    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;          //atributo do tipo Connection

        try {

// Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);

// Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";    //caminho do servidor do BD

            String mydatabase = "VeiculoAPS";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";        //nome de um usuário de seu BD      

            String password = "root";      //sua senha de acesso
            
            Properties props = new Properties();
            props.setProperty("user", "root");
            props.setProperty("password", "root");
            props.setProperty("serverTimezone", "America/Sao_Paulo");

            connection = DriverManager.getConnection(url, props);

            //Testa sua conexão//  
            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (Exception e) {  //Driver não encontrado
            e.printStackTrace();
        }
        return null;
    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {

        return status;

    }

    //Método que fecha sua conexão//
    public static boolean FecharConexao() {

        try {

            Conexao.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return Conexao.getConexaoMySQL();

    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConexaoMySQL();
        
        System.out.println(status);
    }
}
