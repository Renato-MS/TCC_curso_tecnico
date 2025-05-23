package conexaoBancoDeDados;

import Interfaces.Logui;
import Interfaces.TelaPrincipal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class conexaoMySql {

    

   // private String driver = "com.mysql.jdbc.Driver";
    private String driver = "org.gjt.mm.mysql.Driver";  
    public String url = "jdbc:mysql://127.0.0.1/etec";
    public  String usuario ="root" ;
    public  String senha ="";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;

    public boolean eventuaCenexao() {
        boolean resultado = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            //JOptionPane.showMessageDialog(null, "conectou");
        } catch (ClassNotFoundException classeErro) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO GRAVE\n\n O Driver requerido para a conexão não foi "
                    + "encontrado\n\n");
            resultado = false;
        } catch (SQLException sqlErro) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o banco de dados");
            resultado = false;
        }
        return resultado;
    }

    public void executaComandosSql(String comando) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(comando);
            //JOptionPane.showMessageDialog(null, "OK");
        } catch (SQLException sqlErro2) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar o comando SQL");
        }
    }

    public void fechaConexao() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexaoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "A conexão não pode ser fechada");
        }
    }

    public boolean autenticacao() {
         
        boolean result = true;
        try {
            Class.forName(driver);         
            conexao = DriverManager.getConnection(url, usuario, senha);
            //JOptionPane.showMessageDialog(null, "conectou");            
            new TelaPrincipal().setVisible(true);
            fechaConexao();

        } catch (ClassNotFoundException classeErro) {
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO GRAVE\n\n O Driver requerido para a conexão não foi "
                    + "encontrado\n\n");
            result = false;
        } catch (SQLException sqlErro) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha estão errados\nou não consegue achar o banco de dados.\n\n"
                    + "> Informe o nome de usuário e senha corretamente.\n> Verifique se ambos estão cadastrados no banco de dados.\n> "
                    + "Certifique-se que o MySQL está instalado.\n> Observe se o banco de dados foi gravado corretamente com o nome de \"etec\".\n\n"
                    + "Caso o banco de dados esteja armazenado em outro computador,\nfeche o programa e execute o aplicativo configPC, informe o nome\nou endereço IP "
                    + "do mesmo.",
                    "Erro de autenticação",JOptionPane.ERROR_MESSAGE);
            new Logui().setVisible(true);

            result = false;
        }
        return result;
    }

   

}
