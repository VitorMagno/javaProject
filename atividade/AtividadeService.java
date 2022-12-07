package atividade;

import java.util.ArrayList;
import java.util.Date;

import data.DataHandler;
import menu.FactoryCustom;

import usuario.Profissional;
import usuario.Usuario;
import usuario.UsuarioService;

public class AtividadeService {
    DataHandler dataHandler = FactoryCustom.getInstanciaDataHandler();
    UsuarioService servicosDoUsuario = FactoryCustom.getInstanciaUsuarioService();
    Usuario usuarioLogado;
    private ArrayList<Atividade> atividades =  new ArrayList<Atividade>();

    public boolean verificaSeProfessor(){
        usuarioLogado = servicosDoUsuario.getUsuarioLogado();
        System.out.println(usuarioLogado.getClass().getSimpleName());
        if(usuarioLogado == null){
            System.out.println("usuario nao logado, por favor faca o login para acessar a essa funcionalidade");
            return false;
        }
        else if(!usuarioLogado.getClass().getSimpleName().equalsIgnoreCase("professor")){
            System.out.println("verificando usuario...\nFuncionalidade exclusiva para professores");
            return false;
        }else{
            System.out.println("verificando usuario....\nAceito");
            return true;
        }
    }
    public boolean verificaSeProfissional(Usuario usuario){
        if(usuario == null){
            System.out.println("usuario reconhecido");
            return false;
        }
        else if(!usuario.getClass().getSimpleName().equalsIgnoreCase("profissional")){
            System.out.println("verificando usuario...\nFuncionalidade exclusiva para professores");
            return false;
        }else{
            System.out.println("verificando usuario....\nAceito");
            return true;
        }
    }

    public Atividade criarAtividade(String identificacao, String descricao, Usuario responsavel) {
        if(verificaSeProfessor()){
            Atividade novaAtividade = new Atividade(identificacao, descricao, responsavel);
            atividades.add(novaAtividade);
            System.out.println("atividade adicionada com sucesso");
            return novaAtividade;
        }
        return null;
        
    }
    public void excluirAtividade(Atividade atividadeParaExcluir) {
        atividades.remove(atividadeParaExcluir);
    }
    public void setNovaIdentificacao(String novaID, Atividade a) {
        a.setIdentificacao(novaID);
    }
    public void setNovaDescricao(String novaDescricao, Atividade a) {
        a.setDescricao(novaDescricao);
    }
    public void setResponsavel(Profissional profissional, Atividade a) {
        if(verificaSeProfissional(profissional)){
            a.setResponsavel(profissional);
        }
    }
    public void setData(String novaData, Atividade atividade, int option){
        dataHandler.setDataHR(novaData);
        Date dataConvertida = dataHandler.getDate();
        if (option == 1) {
            atividade.setDataHrInicio(dataConvertida);
            return;
        }
        atividade.setDataHrFim(dataConvertida);
        return;
    }   
    public void addProfissional(Atividade atividade, Usuario usuario){
        if(verificaSeProfissional(usuario)){
            atividade.addProfissional(usuario);
        }
    }

    public void DesignaTarefaAProfissional(Atividade atividade, String nomeResponsavel, String tarefa){
        Profissional profissional = atividade.buscaProfissional(nomeResponsavel);
        if(profissional == null){
            System.out.println("abortado");
            return;
        }
        atividade.addTarefaParaProfissional(profissional, tarefa);
    }
}
