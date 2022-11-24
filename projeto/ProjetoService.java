package projeto;


import java.util.ArrayList;
import java.util.Scanner;

import menu.Input;
import usuario.Usuario;
import usuario.UsuarioService;

public class ProjetoService {
    UsuarioService servicosDoUsuario = menu.FactoryCustom.getInstanciaUsuarioService();
    private ArrayList<Projeto> projetos =  new ArrayList<Projeto>();
    Usuario usuarioLogado = servicosDoUsuario.getUsuarioLogado();
    Scanner input = Input.getInstancia();

    public void criarProjeto(){
        if (usuarioLogado == null){
            System.out.println("usuario nao logado, por favor faca o login para acessar a essa funcionalidade");
        }
        else if(usuarioLogado.getClass().getSimpleName() != "Professor"){
            System.out.println("Somente um professor pode criar um projeto");
        } else {
            String nome, descricao, unidadeAcademica;
            nome = input.next();
            descricao = input.next();
            unidadeAcademica = input.next();
            Projeto novoProjeto = new Projeto(nome, descricao, unidadeAcademica);
            projetos.add(novoProjeto);
        }
    }
}
