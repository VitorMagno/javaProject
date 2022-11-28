package atividade;

import java.util.ArrayList;

import usuario.Usuario;
import usuario.UsuarioService;

public class AtividadeService {
    UsuarioService servicosDoUsuario = menu.FactoryCustom.getInstanciaUsuarioService();
    Usuario usuarioLogado = servicosDoUsuario.getUsuarioLogado();
    private ArrayList<Atividade> atividades =  new ArrayList<Atividade>();

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

    public void criarAtividade(String identificacao, String descricao, Usuario responsavel) {
        if(verificacaoUsuario()){
            Atividade novaAtividade = new Atividade(identificacao ,descricao, responsavel);
            atividades.add(novaAtividade);
            System.out.println("atividade adicionada com sucesso");
        }
        
    }
}
