

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner InputUser = new Scanner(System.in);
        //Objeto da Classe Scanner para ler a entrada do usuario

        //Classes Instanciadas
        DadosCliente Dados = new DadosCliente();
        Autenticacao AT = new Autenticacao();
        OperacoesDatabase ComandosSQL = new OperacoesDatabase();

        //Mensagem Incial
        System.out.println("\nOlá seja bem vindo a Mosquitos Shop!\n");

        //Pergunta Cadastro
        System.out.println("Para utilizar os serviços da MataMosquitosShop é necessario ter login! Voce já possui um login?: ");
        String PrimeiraPergunta = InputUser.nextLine();

        String [] VetorSim = {"Sim", "sim", "sIM", "SiM", "sIm"};
        String [] VetorNao = {"Nao", "não", "Não", "nAo", "NAo", "nao", "nAO"};

        for(String i : VetorSim) {
            if(i.equals(PrimeiraPergunta)) {
                Boolean TemCadastro = true;
                Dados.setUsuarioCadastrado(TemCadastro);

            }


        }

        for(String i: VetorNao) {
            if(i.equals(PrimeiraPergunta)) {
                Boolean TemCadastro = false;
                Dados.setUsuarioCadastrado(TemCadastro);
            }

        }

        if(Dados.getUsuarioCadastrado() == true) {
            //chamar metodo de login
        }


        else {
            //chamar metodo de cadastro
           Dados.Cadastro();
           AT.AutenticarCPF();
           AT.AutenticarRG();
           AT.AutenticarEmail();
           ComandosSQL.CadastrarUsuarioNoBD();


            



        }

    }
}