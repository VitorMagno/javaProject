package atividade;

import usuario.Profissional;

public class TarefasPorProfissional {
    private String tarefa;
    private Profissional responsavel;
    public TarefasPorProfissional(String tarefa, Profissional responsavel) {
        this.tarefa = tarefa;
        this.responsavel = responsavel;
    }
    public String getTarefa() {
        return tarefa;
    }
    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
    public Profissional getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(Profissional responsavel) {
        this.responsavel = responsavel;
    }

    
}
