package menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        boolean running = true;
        Scanner input = Input.getInstancia();
        Menu menuDeProjetos = FactoryCustom.getInstanciaDeProjetos();
        Menu menuDeUsuarios = FactoryCustom.getInstanciaDeUsuarios();
        int opcao;
        while (running) {
            System.out.println("Bem vindo ao gerenciador de projetos");
            System.out.println("Selecione uma opção: \n1 - Criar Conta\n2 - Logar \n3 - Menu de projetos \n4 - Menu de usuarios \n5 - Sair");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    Login.doSignIn();
                    break;
                case 2:
                    Login.doLogin();
                    break;
                case 3:
                    menuDeProjetos.principal();;
                    break;
                case 4:
                    menuDeUsuarios.principal();;
                    break;
                case 5:
                    System.out.println("Até mais!");
                    running = false;
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
            
        }
    }
}
