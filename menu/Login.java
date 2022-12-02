package menu;



import usuario.UsuarioService;

public final class Login {

    public static void doLogin() throws Exception{
        String nome, cpf;
        UsuarioService usuarioService = FactoryCustom.getInstanciaUsuarioService();
        System.out.println("digite o nome");
        nome = (String) Input.entradaDeLinha();
        System.out.println("e o cpf");
        cpf = (String) Input.entradaDeLinha();
        usuarioService.logar(nome, cpf);
    }

    public static void doSignIn() throws Exception{
        String nome, cpf, unidadeAcademica;
        UsuarioService usuarioService = FactoryCustom.getInstanciaUsuarioService();
        System.out.println("digite o nome");
        nome = (String) Input.entradaDeLinha();
        System.out.println("cpf");
        cpf = (String) Input.entradaDeLinha();
        System.out.println("e unidade academica");
        unidadeAcademica = (String) Input.entradaDeLinha();
        System.out.println("digite: \n1 - aluno \n2 - professor \n3 - pesquisador \n4 - profissional");
        int option = Input.entradaDeInt();
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
