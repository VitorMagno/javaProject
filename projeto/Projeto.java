package projeto;

import java.util.ArrayList;
import java.util.Date;

import atividade.Atividade;
import usuario.Profissional;
import usuario.Usuario;

public class Projeto {
    private String nome;
    private String descricao;
    private String unidadeAcademica;
    private Usuario coordenador;
    private Date dataHrInicio;
    private Date dataHrFim;
    private int periodoVigenciaBolsa;
    private ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();
    private int valorBolsaProfissional;
    private String status;

    public Projeto(String nome, String descricao, String unidadeAcademica, Usuario coordenador){
        this.nome = nome;
        this.descricao = descricao;
        this.unidadeAcademica = unidadeAcademica;
        this.coordenador = coordenador;
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

    public void setDataHrInicio(Date dataHrInicio) {
        this.dataHrInicio = dataHrInicio;
    }

    public Date getDataHrInicio() {
        return dataHrInicio;
    }

    public void setDataHrFim(Date dataHrFim) {
        this.dataHrFim = dataHrFim;
    }

    public Date getDataHrFim() {
        return dataHrFim;
    }

    public void setPeriodoVigenciaBolsa(int periodoVigenciaBolsa) {
        this.periodoVigenciaBolsa = periodoVigenciaBolsa;
    }

    public int getPeriodoVigenciaBolsa() {
        return periodoVigenciaBolsa;
    }

    public Usuario getCoordenador() {
        return coordenador;
    }

    public void setValorBolsaProfissional(int valorBolsaProfissional) {
        this.valorBolsaProfissional = valorBolsaProfissional;
    }

    public int getValorBolsaProfissional() {
        return valorBolsaProfissional;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }

    public Usuario buscarProfissionais (String nomeUsuarioBuscado){
        Usuario usuarioBuscado = null;
        for (Profissional profissional : profissionais) {
            if(profissional.getNome().equals(nomeUsuarioBuscado)){
                usuarioBuscado = profissional;
                return usuarioBuscado;
            }
        }
        return usuarioBuscado;
    }
    public Atividade buscaAtividade(String nomeAtividade){
        for (Atividade atividade : atividades) {
            if(atividade.getIdentificacao().equalsIgnoreCase(nomeAtividade)){
                return atividade;
            }
        }
        return null;
    }
    public void removeAtividade(Atividade a){
        atividades.remove(a);
    }
    public void mostrarProfissionais(){
        for (Profissional profissional : profissionais) {
            System.out.println("Nome: "+profissional.getNome()+"\nUnidade academica: "+profissional.getUnidadeAcademica());
        }
    }

    public void addProfissional(Usuario profissional){
        profissionais.add((Profissional) profissional);
    }

    public void addAtividade(Atividade novaAtividade) {
        atividades.add(novaAtividade);
    }
    public void listarAtividades(){
        for (Atividade atividade : atividades) {
            System.out.println(atividade);
        }
    }

    public boolean removeProfissional(String nomeUsuarioParaRemover){
        Usuario usuarioParaRemover = buscarProfissionais(nomeUsuarioParaRemover);
        if(usuarioParaRemover != null){
            profissionais.remove(usuarioParaRemover);
            System.out.println("usuario " + usuarioParaRemover.getNome() + " removido");
            return true;
        }
        System.out.println("usuario " +nomeUsuarioParaRemover+" não encontrado nesse projeto");
        return false;
    }

    @Override
    public String toString() {
        
        return "------------\nNome: " + getNome() +  "\nDescricao: " + getDescricao() +
        "\nUnidade academica: " + getUnidadeAcademica() + "\nBolsa: " + getValorBolsaProfissional() + "\n------------";
    }

}
