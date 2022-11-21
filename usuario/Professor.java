package usuario;

public class Professor implements Usuario {
    private String nome;
    private String cpf;
    private String unidadeAcademica;

    public Professor(String nome, String cpf, String unidadeAcademica) {
        this.nome = nome;
        this.cpf = cpf;
        this.unidadeAcademica = unidadeAcademica;
    }

    @Override
    public String getNome() {
        
        return this.nome;
    }

    @Override
    public void setNome() {
        
        
    }

    @Override
    public String getCpf() {
        
        return this.cpf;
    }

    @Override
    public void setCpf() {
        
        
    }

    @Override
    public String getUnidadeAcademica() {
        
        return this.unidadeAcademica;
    }

    @Override
    public void setUnidadeAcademica() {
        
        
    }
    
}
