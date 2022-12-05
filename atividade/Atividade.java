package atividade;

import java.util.ArrayList;
import java.util.Date;

import data.DataHandler;
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
    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
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
    public void setDataHrFim(Date dataHrFim) {
        this.dataHrFim = dataHrFim;
    }
    public Date getDataHrFim() {
        return dataHrFim;
    }
    public Date getDataHrInicio() {
        return dataHrInicio;
    }
    public void setDataHrInicio(Date dataHrInicio) {
        this.dataHrInicio = dataHrInicio;
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

    public Profissional buscaProfissional(String nomeDoProfissional) {
        Profissional achado = null;
        for(Profissional profissional: profissionais){
            if(profissional.getNome().equals(nomeDoProfissional)){
                achado = profissional;
                break;
            }
            
        }
        if(achado == null){
            System.out.println("profissional nao encontrado:");
            return achado;
        }
        return achado;
        
    }
    public void addTarefaParaProfissional(Profissional profissional, String descricao){
        TarefasPorProfissional novaTarefa = new TarefasPorProfissional(descricao, profissional);
        tarefasPorProfissional.add(novaTarefa);
    }
    
    @Override
    public String toString() {
        return "Atividade [descricao = " + descricao + ", responsavel = " + responsavel + ", data inicio = "+ DataHandler.dateToString(dataHrInicio)+ ", data fim = "+DataHandler.dateToString(dataHrFim)+"]";
    }
    
    
}
