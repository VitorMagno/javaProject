package atividade;

import usuario.Usuario;

public class Atividade {
    public Atividade(String descricao, Usuario responsavel) {
        this.descricao = descricao;
        this.responsavel = responsavel;
    }
    private String descricao;
    private Usuario responsavel;
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
    @Override
    public String toString() {
        return "Atividade [descricao = " + descricao + ", responsavel = " + responsavel + "]";
    }
    
    
}
