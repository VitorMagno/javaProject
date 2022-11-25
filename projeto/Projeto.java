package projeto;

import java.util.ArrayList;

import usuario.Profissional;

public class Projeto {
    private String nome;
    private String descricao;
    private String unidadeAcademica;
    private Data dataHrInicio;
    private Data dataHrFim;
    private Data periodoVigenciaBolsa;
    private Usuario coordenador;
    private ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();
    private int valorBolsaProfissional;

    public Projeto(String nome, String descricao, String unidadeAcademica){
        this.nome = nome;
        this.descricao = descricao;
        this.unidadeAcademica = unidadeAcademica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidadeAcademica() {
        return unidadeAcademica;
    }
    
    public void setUnidadeAcademica(String unidadeAcademica) {
        this.unidadeAcademica = unidadeAcademica;
    }
}
