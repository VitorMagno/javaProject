package menu;

import java.util.Scanner;

import usuario.UsuarioService;

public final class Login {

    public static void doLogin() throws Exception{
        String nome, cpf;
        Scanner input = Input.getInstancia();
        UsuarioService usuarioService = FactoryCustom.getInstanciaUsuarioService();
        System.out.println("digite o nome e o cpf");
        nome = (String) input.next();
        System.out.println(nome);
        cpf = (String) input.next();
        System.out.println(cpf);
        usuarioService.logar(nome, cpf);
    }

    public static void doSignIn() throws Exception{
        String nome, cpf, unidadeAcademica;
        Scanner input = Input.getInstancia();
        UsuarioService usuarioService = FactoryCustom.getInstanciaUsuarioService();
        System.out.println("digite o nome, cpf e unidade academica");
        nome = (String) input.next();
        System.out.println(nome);
        cpf = (String) input.next();
        System.out.println(cpf);
        unidadeAcademica = (String) input.next();
        System.out.println(unidadeAcademica);
        System.out.println("digite: \n1 - aluno \n2 - professor \n3 - pesquisador \n4 - profissional");
        int option = input.nextInt();
        switch (option) {
            case 1:
                usuarioService.createAluno(nome, cpf, unidadeAcademica);
                break;
            case 2:
                usuarioService.createProfessor(nome, cpf, unidadeAcademica);
                break;
            case 3:
                usuarioService.createPesquisador(nome, cpf, unidadeAcademica);
                break;
            case 4:
                usuarioService.createProfissional(nome, cpf, unidadeAcademica);
                break;
            default:
                System.out.println("opcao invalida");
                break;
        }
        
    }
}
