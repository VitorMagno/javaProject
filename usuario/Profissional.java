package usuario;

public class Profissional implements Usuario{
    private String nome;
    private String cpf;
    private String unidadeAcademica;

    public Profissional(String nome, String cpf, String unidadeAcademica) {
        this.nome = nome;
        this.cpf = cpf;
        this.unidadeAcademica = unidadeAcademica;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    @Override
    public String getCpf() {
        return this.cpf;
    }

    @Override
    public void setCpf(String novoCpf) {
        this.cpf = novoCpf;
    }

    @Override
    public String getUnidadeAcademica() {
        return this.unidadeAcademica;
    }

    @Override
    public void setUnidadeAcademica(String novaUnidadeAcademica) {
        this.unidadeAcademica = novaUnidadeAcademica;
    }
    @Override
    public String toString(){
        return "-----------\nNome: " + getNome() + "\nCpf: " + getCpf() + "\nUnidade Academica: " + getUnidadeAcademica()+
        "\nFuncao: " +this.getClass().getSimpleName() +"\n-----------";
    }
}
