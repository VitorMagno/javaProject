package menu;

import java.util.Scanner;

public class DeUsuarios implements Menu {
    @Override
    public void principal()  {
        boolean running = true;
        int option;
        Scanner input = Input.getInstancia();
        while (running) {
            System.out.println("Selecione: \n1 - mostrar usuarios \n2 - adicionar usuario \n3 - ver usuario \n4 - excluir usuario \n0 - voltar ao menu principal");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Menu mostrar usuarios"); 
                    mostrar();
                    break;
                case 2:
                    System.out.println("Menu adicionar usuario");
                    criar();
                    break;
                case 3:
                    System.out.println("Menu ver usuario");
                    ver();
                    break;
                case 4:
                    System.out.println("Menu excluir usuario");
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
        System.out.println("mostrando lista de usuarios");
        return;
    }

    @Override
    public void criar(){
        System.out.println("cria um novo usuario");
        return;
    }

    @Override
    public void ver(){
        System.out.println("exibe mais informacoes sobre o usuario e opcao de editar");
        return;
    }

    @Override
    public void excluir(){
        System.out.println("seleciona um usuario para exclusao");
        return;
    }
}
