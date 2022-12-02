package menu;


import usuario.UsuarioService;

public class DeUsuarios implements Menu {
    UsuarioService usuarioService = FactoryCustom.getInstanciaUsuarioService();
    @Override
    public void principal() throws Exception{
        boolean running = true;
        int option;
        while (running) {
            System.out.println("Selecione: \n1 - mostrar usuarios \n2 - adicionar usuario \n3 - ver usuario \n4 - excluir usuario \n0 - voltar ao menu principal");
            option = Input.entradaDeInt();
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
        usuarioService.mostrarTodos();
        return;
    }

    @Override
    public void criar() throws Exception{
        Login.doSignIn();
        return;
    }

    @Override
    public void ver(){
        System.out.println("digite o nome do usuario que quer ver mais informacoes");
        String nomePVer = Input.entradaDeLinha();
        usuarioService.verEEditar(nomePVer);
        return;
    }

    @Override
    public void excluir(){
        System.out.println("digite o nome do usuario que quer excluir");
        String nomePExclusao = Input.entradaDeLinha();
        usuarioService.removeUser(nomePExclusao);
        return;
    }
}
