import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConexaoBD {

    public Connection getObjetoDeConexao() {
        return ObjetoDeConexao;
    }

    public void setObjetoDeConexao(Connection objetoDeConexao) {
        ObjetoDeConexao = objetoDeConexao;
    }

    private Connection ObjetoDeConexao;

        protected void Conexao() {



            try {

                ObjetoDeConexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MOSQUITOS", "root", "Lorenzo05*");


            }


            catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

}