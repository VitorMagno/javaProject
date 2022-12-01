package atividade;

import java.util.ArrayList;
import java.util.Date;

import usuario.Profissional;
import usuario.Usuario;

public class Atividade {
    private String identificacao;
    private String descricao;
    private Usuario responsavel;
    private Date dataHrInicio;
    private Date dataHrFim;
    private ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
    private ArrayList<TarefasPorProfissional> tarefasPorProfissional = new ArrayList<TarefasPorProfissional>();
    
    
    public Atividade (String identificacao, String descricao, Usuario responsavel) {
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.responsavel = responsavel;
    }
    public String getIdentificacao(){
        return identificacao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Usuario getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
    public void addProfissional(Usuario novoProfissional){
        profissionais.add((Profissional) novoProfissional);
    }
    


    @Override
    public String toString() {
        return "Atividade [descricao = " + descricao + ", responsavel = " + responsavel + "]";
    }
    
    
}
