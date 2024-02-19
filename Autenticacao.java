import org.apache.commons.mail.SimpleEmail;

import java.util.*;


public class Autenticacao {
    Scanner InputUser = new Scanner(System.in);

    DadosCliente Dados = new DadosCliente();

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    private String CPF;

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    private String RG;

    private String EmailEmpresa = "lorenzo.23.rocha@gmail.com";

    private String SenhaEmpresa = "wwsz jzhe wnsr gimf";

    private String NumeroAutenticacao;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Email;




    public void AutenticarCPF() {

        System.out.println("Digite seu CPF: ");
        this.CPF = InputUser.nextLine();
        while(this.CPF.length() != 11) {
            System.out.println("CPF não existe, digite novamente");
            System.out.println("Digite seu CPF: ");
            this.CPF = InputUser.nextLine();
        }
        int CPFVetor[] = new int[11];


      for(int i = 0; i < 11; i++) {
          CPFVetor[i] = Character.getNumericValue(CPF.charAt(i));





      }

      int[] Multi1 = {10,9,8,7,6,5,4,3,2};
      int [] Multi2 = {11,10,9,8,7,6,5,4,3,2};
      int soma = 0;
      int Resto = 0;
      int PrimeiroDigitoVerificador = 0;
      int soma2 = 0;
      int Resto2 = 0;
      int SegundoDigitoVerificador = 0;

      for(int i = 0; i <= 8; i++) {
          soma += CPFVetor[i] * Multi1[i];
          Resto = soma % 11;
          PrimeiroDigitoVerificador = 11 - Resto;

      }


      for(int i = 0; i <= 9; i++) {
          soma2 += CPFVetor[i] * Multi2[i];
          Resto2 = soma2 % 11;
          SegundoDigitoVerificador = 11 - Resto2;

      }




      if(PrimeiroDigitoVerificador == CPFVetor[9] && SegundoDigitoVerificador == CPFVetor[10]) {
          System.out.println("CPF Valido");
          Boolean CPFValido = true;
          Dados.setCPFValido(CPFValido);

      }

      else {
          Boolean CPFValido = false;
          Dados.setCPFValido(CPFValido);
          while(Dados.getCPFValido() == false) {
              System.out.println("\nCPF Invalido");
              AutenticarCPF();
          }





      }














    }

    public void AutenticarRG() {
        System.out.println("Digite seu RG sem espaços!");
        System.out.println("Digite seu RG: ");
        this.RG = InputUser.next();
        while(this.RG.length() != 9) {
            System.out.println("\nRG não existe");
            System.out.println("Digite seu RG: ");
            this.RG = InputUser.next();
        }

        int RGVetor[] = new int[9];

        //transformar de String para int[]
        for(int i = 0; i < 9; i++) {
            RGVetor[i] = Character.getNumericValue(RG.charAt(i));
        }

        int [] Multi = {2,3,4,5,6,7,8,9};
        int soma = 0;
        int Resto = 0;
        int DigitoVerificadorCPF = 0;

        for(int i = 0; i <= 7; i++) {
            soma += RGVetor[i] * Multi[i];
            Resto = soma % 11;
            DigitoVerificadorCPF = 11 - Resto;


        }

        if(DigitoVerificadorCPF == RGVetor[8]) {
            Boolean RGValido = true;
            Dados.setRGValido(RGValido);
            System.out.println("\nRG Valido!");
        }

        else {
            Boolean RGValido = false;
            Dados.setRGValido(RGValido);
            while(Dados.getRGValido() == false) {
                System.out.println("\nRG Invalido!");
                AutenticarRG();
            }

        }


    }



    private String Autenticacao() {
        Random NumeroAleatorioRandom = new Random();
        int Autenticacao = NumeroAleatorioRandom.nextInt();
        this.NumeroAutenticacao = String.valueOf(Autenticacao);

        return NumeroAutenticacao;

    }



    public void AutenticarEmail() {

        InputUser.nextLine();
        System.out.println("Digite seu email: ");
        this.Email = InputUser.nextLine();

        while(!this.Email.contains("@gmail.com") && !this.Email.contains("outlook.com") && !this.Email.contains("hotmail.com")) {
            System.out.println("Email Invalido!");
            System.out.println("Digite seu email: ");
            this.Email = InputUser.nextLine();
        }



        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com"); //define o host do google do gmail
        email.setSmtpPort(465); //aqui define a porta até ai extremamente parecido com a conexão com um BD
        email.setAuthentication(EmailEmpresa, SenhaEmpresa);  //Este metodo recebe por parametro um objeto do tipo default authenticator, autentica a conexão o envio do email
        email.setSSLOnConnect(true);
        // esse metodo vai ativar a conexão de forma segura, esse protocolo protege o email

        try {

            email.setFrom(EmailEmpresa);   //de onde esse email vem, esse metodo faz isso, define o emissario
            email.setSubject("Autenticação de email");
            email.setMsg("Numero de Autenticação: " + Autenticacao());
            email.addTo(this.Email); //define o destinatario
            email.send();
            System.out.println("\nEnviamos um codigo de verificação para validar seu email!");






        }

        catch(Exception e) {
            e.printStackTrace();

        }


        System.out.println("Digite o numero de Autenticação enviado: ");
        String ATUser = InputUser.nextLine();

        if(ATUser.equals(this.NumeroAutenticacao)) {
            Boolean EmailAutenticado = true;
            Dados.setEmailValido(EmailAutenticado);



        }

        else {
            Boolean EmailAutenticado = false;
            Dados.setEmailValido(EmailAutenticado);
            System.out.println("\nNumero de Autenticação Invalido! Faça novamente o processo!");
            AutenticarEmail();


        }





    }














}
