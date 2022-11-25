package projeto;


import java.util.ArrayList;

import usuario.Usuario;
import usuario.UsuarioService;

public class ProjetoService {
    UsuarioService servicosDoUsuario = menu.FactoryCustom.getInstanciaUsuarioService();
    private ArrayList<Projeto> projetos =  new ArrayList<Projeto>();
    Usuario usuarioLogado = servicosDoUsuario.getUsuarioLogado();

    public boolean verificacaoUsuario(){
        if(usuarioLogado == null){
            System.out.println("usuario nao logado, por favor faca o login para acessar a essa funcionalidade");
            return false;
        }
        else if(usuarioLogado.getClass().getSimpleName() != "Professor"){
            System.out.println("verificando usuario...\nFuncionalidade exclusiva para professores");
            return false;
        }else{
            System.out.println("verificando usuario....\nAceito");
            return true;
        }
    }

    public void criarProjeto(String nome, String descricao, String unidadeAcademica){
        if(verificacaoUsuario()){
            Usuario coordenador = usuarioLogado;
            Projeto novoProjeto = new Projeto(nome, descricao, unidadeAcademica, coordenador);
            projetos.add(novoProjeto);
        }
    }

    public void exluirProjeto(String nomeProjeto) {
        Projeto projetoParaExclusao = findProjeto(nomeProjeto);
        if(projetoParaExclusao != null){
            System.out.println("projeto"+ projetoParaExclusao.getNome() +"removido");
            projetos.remove(projetoParaExclusao);
            return;
        }
        System.out.println("projeto nao encontrado");
    }

    public void listarProjetos(){
        for (Projeto projeto : projetos) {
            System.out.println(projeto);
        }
    }

    public Projeto findProjeto(String nomeProjeto){
        Projeto projetoEncontrado = null;
        for (Projeto projeto : projetos) {
            if(projeto.getNome().equals(nomeProjeto)){
                projetoEncontrado = projeto;
                return projetoEncontrado;
            }
        }
        return projetoEncontrado;
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

    public void removeProfissional(String nomeProfissional, String nomeProjeto){
        Projeto projetoEncontrado = findProjeto(nomeProjeto);
        if(projetoEncontrado!=null){
            projetoEncontrado.removeProfissional(nomeProfissional);
            return;
        }
        System.out.println("projeto nao encontrado");

    }

    
}
