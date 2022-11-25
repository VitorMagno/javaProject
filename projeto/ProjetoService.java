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
            Usuario coordenador = usuarioLogado;
            nome = input.next();
            descricao = input.next();
            unidadeAcademica = input.next();
            Projeto novoProjeto = new Projeto(nome, descricao, unidadeAcademica, coordenador);
            projetos.add(novoProjeto);
        }
    }

    public Projeto findProjeto(String nomeProjeto){
        Projeto projetoAchado = null;
        for (Projeto projeto : projetos) {
            if(projeto.getNome().equals(projetoAchado)){
                projetoAchado = projeto;
                return projetoAchado;
            }
        }
        return projetoAchado;
    }

    public void addNovoProfissional(String nomeProfissional, String nomeProjeto){
        Usuario profissional = servicosDoUsuario.findUser(nomeProfissional);
        Projeto projeto = findProjeto(nomeProjeto);
        if(projeto != null && profissional != null){
            if(profissional.getClass().getSimpleName()!= "Profissional"){
                System.out.println("usuario precisa ser do tipo profissional, adicao sem sucesso");
                return;
            }
            projeto.addProfissional(profissional);
            System.out.println("adicionado com sucesso");
            return;
        }
        System.out.println("usuario ou projeto invalidos, verifique a existencia dos dois");
    }

    
}
