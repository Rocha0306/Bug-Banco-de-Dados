import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OperacoesDatabase {

    ConexaoBD PegarConexao = new ConexaoBD();
    DadosCliente PegarDados = new DadosCliente();

    Autenticacao DadosPrivados = new Autenticacao();
    public void CadastrarUsuarioNoBD() throws SQLException {

        try {
            PegarConexao.Conexao();
            String ComandoSQL = String.format("INSERT INTO DADOSCLIENTE(NOME, IDADE, CPF, RG, EMAIL, SENHA) VALUES('%s', '%d', '%s', '%s', '%s', '%s')", PegarDados.getNome(), PegarDados.getIdade(), DadosPrivados.getCPF(), DadosPrivados.getRG(), DadosPrivados.getEmail(), PegarDados.getSenha());
            int NumDeLinhas = PegarConexao.getObjetoDeConexao().createStatement().executeUpdate(ComandoSQL);
            System.out.println("Informacoes cadastradas com sucesso!");

        }

        catch (Exception e) {
            throw new RuntimeException(e);
        }


    }




}
