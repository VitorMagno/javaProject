package projeto;


import usuario.UsuarioService;

public class ProjetoService {
    UsuarioService servicosDoUsuario = menu.FactoryCustom.getInstanciaUsuarioService();

    public void criarProjeto(){
        if (servicosDoUsuario.getUsuarioLogado() == null){
            System.out.println("usuario nao logado, por favor faca o login para acessar a essa funcionalidade");
        }
        else{
            System.out.println(servicosDoUsuario.getUsuarioLogado().getClass());
        }
    }
}
