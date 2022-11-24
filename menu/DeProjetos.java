package menu;

import java.util.Scanner;

public class DeProjetos implements Menu {
    Scanner input = Input.getInstancia();
    @Override
    public void principal() {
        boolean running = true;
        int option;
        while (running){
            System.out.println("Selecione: \n1 - mostrar projetos \n2 - adicionar projeto \n3 - ver projeto \n4 - excluir projeto \n0 - voltar ao menu principal");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("mostrar projetos");
                    mostrar();
                    break;
                case 2:
                    System.out.println("adicionar projeto");
                    criar();
                    break;
                case 3:
                    System.out.println("ver projeto");
                    ver();
                    break;
                case 4:
                    System.out.println("excluir projeto");
                    excluir();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal");
                    return;
                default:
                    System.out.println("Selecione uma opcao valida");
                    break;
            }
        }
    }

    @Override
    public void mostrar(){
        System.out.println("mostrando lista de projetos");
        return;
    }

    @Override
    public void criar(){
        System.out.println("cria um novo projeto");
        return;
    }

    @Override
    public void ver(){
        System.out.println("exibe mais informacoes sobre o projeto e opcao de editar");
        return;
    }
    @Override
    public void excluir(){
        System.out.println("seleciona um projeto para exclusao");
        return;
    }
}
