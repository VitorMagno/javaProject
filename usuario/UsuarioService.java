package usuario;

import java.util.ArrayList;
import java.util.Scanner;

import menu.Input;

public class UsuarioService {
    private ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();
    private Usuario usuarioLogado = null;
    Scanner input = Input.getInstancia();
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
        return this.usuarioLogado;
    }
    public String getTipoUsuario(){
        return this.usuarioLogado.getClass().getSimpleName();
    }

    public void logar(String nome, String cpf) throws Exception{
        Usuario usuarioAchado = findUser(nome);
        if(usuarioAchado != null){
            if(usuarioAchado.getNome().equals(nome) && usuarioAchado.getCpf().equals(cpf)){
                this.usuarioLogado = usuarioAchado;
                System.out.println("logado em " + nome + " este usuario eh " + getTipoUsuario());
            }
            else if(usuarioAchado.getNome().equals(nome) || usuarioAchado.getCpf().equals(cpf)){
                System.out.println("credenciais incorretas");
            }
        }else{
            System.out.println("nao encontrado");
        }
    }

    public void mostrarTodos(){
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome()+ " " + usuario.getCpf());
        }
    }

    public Usuario findUser(String nomeUsuario){
        Usuario achado = null;
        for(Usuario usuario: usuarios){
            if(usuario.getNome().equals(nomeUsuario)){
                achado = usuario;
                break;
            }
        }
        return achado;
    }

    public void verInfo(Usuario user){
        System.out.println(user);
    }

    public void editar(Usuario user){
        System.out.println("deseja editar: 1-nome 2-cpf 3-unidade academica");
        int option = 0;
        if(option == 1){
            String novoNome = input.next();
            user.setNome(novoNome);
        }else if(option == 2){
            String novoCpf = input.next();
            user.setCpf(novoCpf);
        }else if(option == 3){
            String novaUnidadeAcademica = input.next();
            user.setUnidadeAcademica(novaUnidadeAcademica);
        }else{
            System.out.println("opcao invalida, retornando ao menu anterior");
            return;
        }
    }
    public void verEEditar(String nome){
        int option = 0;
        Usuario verEeditar = findUser(nome);
        verInfo(verEeditar);
        System.out.println("deseja editar? 1-sim 2-nao");
        option = input.nextInt();
        if(option == 1){

        }else if(option == 2){
            System.out.println("edicao cancelada");
            return;
        }else{
            System.out.println("opcao invalida, retornando ao menu anterior");
            return;
        }



    }

    public void removeUser(String nomeUsuario){
        Usuario paraRemover = findUser(nomeUsuario);
        if(paraRemover == null){
            System.out.println("nao encontrado");
        }else{
            System.out.println("removendo usuario " + paraRemover.getNome());
            usuarios.remove(paraRemover);
        }
    }
}
