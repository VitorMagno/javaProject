package projeto;

public class Projeto {
    private String nome;
    private String descricao;
    private String unidadeAcademica;

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
