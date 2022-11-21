package usuario;

import java.util.ArrayList;

public class UsuarioService {
    private ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();
    private Usuario usuarioLogado;

    public void createAluno(String novoNome, String novoCpf, String novaUnidadeAcademica){
        Aluno novoAluno = new Aluno(novoNome, novoCpf, novaUnidadeAcademica);
        usuarios.add(novoAluno);
    }

    public void createProfessor(String novoNome, String novoCpf, String novaUnidadeAcademica){
        Professor novoProfessor = new Professor(novoNome, novoCpf, novaUnidadeAcademica);
        usuarios.add(novoProfessor);
    }

    public void createPesquisador(String novoNome, String novoCpf, String novaUnidadeAcademica){
        Pesquisador novoPesquisador = new Pesquisador(novoNome, novoCpf, novaUnidadeAcademica);
        usuarios.add(novoPesquisador);
    }

    public void createProfissional(String novoNome, String novoCpf, String novaUnidadeAcademica){
        Profissional novoProfissional = new Profissional(novoNome, novoCpf, novaUnidadeAcademica);
        usuarios.add(novoProfissional);
    }

    public Usuario getUsuarioLogado(){
        return usuarioLogado;
    }

    public void logar(String nome, String cpf) throws Exception{
        boolean naoEncontrado = true;
        for (Usuario usuario : usuarios) {
            if(usuario.getNome() == nome && usuario.getCpf() == cpf){
                System.out.println("logado em " + nome + " " + usuario.getClass());
                this.usuarioLogado = usuario;
                naoEncontrado = false;
                break;
            }
            else if(usuario.getNome() == nome || usuario.getCpf() == cpf){
                System.out.println("credenciais incorretas");
                naoEncontrado = false;
                break;
            }
        }
        if(naoEncontrado == true){
            System.out.println("nao encontrado");
        }
    }
}
