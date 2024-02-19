import java.util.Scanner;

public class DadosCliente {

    Scanner InputUser = new Scanner(System.in);



    private String Nome;

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer idade) {
        Idade = idade;
    }

    private int Idade;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }


    public String getNomeDeUsuario() {
        return NomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        NomeDeUsuario = nomeDeUsuario;
    }

    public String NomeDeUsuario;

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    private String Senha;

    public Boolean getUsuarioCadastrado() {
        return UsuarioCadastrado;
    }

    public void setUsuarioCadastrado(Boolean usuarioCadastrado) {
        UsuarioCadastrado = usuarioCadastrado;
    }

    private Boolean UsuarioCadastrado;

    public Boolean getCPFValido() {
        return CPFValido;
    }

    public void setCPFValido(Boolean CPFValido) {
        this.CPFValido = CPFValido;
    }

    private Boolean CPFValido;

    public Boolean getRGValido() {
        return RGValido;
    }

    public void setRGValido(Boolean RGValido) {
        this.RGValido = RGValido;
    }

    private Boolean RGValido;

    public Boolean getEmailValido() {
        return EmailValido;
    }

    public void setEmailValido(Boolean emailValido) {
        EmailValido = emailValido;
    }

    private Boolean EmailValido;


    public void Cadastro() {
        System.out.println("Digite seu nome: ");
        this.Nome = InputUser.nextLine();
        System.out.println("Digite sua idade: ");
        this.Idade = InputUser.nextInt();
        InputUser.nextLine();
        System.out.println("Digite sua senha: ");
        this.Senha = InputUser.nextLine();

        //Requirir uma senha mais forte
        while(this.Senha.contains(this.Nome)) {
            System.out.println("Escolha uma senha mais forte! Essa é fraca");
            System.out.println("Digite sua senha: ");
            this.Senha = InputUser.nextLine();
        }


    }







}
