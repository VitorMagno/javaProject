package menu;

import java.util.Scanner;

import atividade.AtividadeService;
import projeto.Projeto;
import projeto.ProjetoService;
import usuario.Usuario;
import usuario.UsuarioService;

public class DeProjetos implements Menu {
    Scanner input = Input.getInstancia();
    ProjetoService projetoService = FactoryCustom.getInstanciaProjetoService();
    UsuarioService usuarioService = FactoryCustom.getInstanciaUsuarioService();
    AtividadeService atividadeService = FactoryCustom.getInstanciaAtividadeService();
    @Override
    public void principal() {
        boolean running = true;
        int option;
        while (running){
            System.out.println("Selecione: \n1 - mostrar projetos \n2 - adicionar projeto \n3 - ver projeto \n4 - excluir projeto \n0 - voltar ao menu principal");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("mostrar projetos");
                    mostrar();
                    break;
                case 2:
                    System.out.println("adicionar projeto");
                    criar();
                    break;
                case 3:
                    System.out.println("ver projeto");
                    ver();
                    break;
                case 4:
                    System.out.println("excluir projeto");
                    excluir();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal");
                    return;
                default:
                    System.out.println("Selecione uma opcao valida");
                    break;
            }
        }
    }

    @Override
    public void mostrar(){
        projetoService.listarProjetos();
        return;
    }

    @Override
    public void criar(){
        String nome, descricao, unidadeAcademica;
        nome = input.next();
        descricao = input.next();
        unidadeAcademica = input.next();
        projetoService.criarProjeto(nome, descricao, unidadeAcademica);
        return;
    }

    @Override
    public void ver(){
        System.out.println("seleciona um projeto, mostra opcao de editar nome, descricao, valor da bolsa, data de inicio, data de fim, periodo de vigencia da bolsa"
        +"adicionar profissional, adicionar atividade, mudar status");
        System.out.println("digite o nome do projeto para ver mais detalhes e opcoes"); 
        String nomeDoProjeto = input.nextLine();
        Projeto projetoEncontrado = projetoService.findProjeto(nomeDoProjeto);
        System.out.println(projetoEncontrado);
        int option = input.nextInt();
        System.out.println("deseja editar alguma informação?\n1-sim \n2-nao");
        switch (option) {
            case 1:
                editar(projetoEncontrado);
                break;
            case 2:
                System.out.println("retornando");
                break;
        
            default:
                System.out.println("opcao invalida");
                break;
        }
        return;
    }
    @Override
    public void excluir(){
        System.out.println("digite o nome do projeto para exclusao");
        String nomeDoProjeto;
        nomeDoProjeto = input.next();
        projetoService.exluirProjeto(nomeDoProjeto);
        return;
    }

    public void editar(Projeto projeto){
        if (projetoService.verificacaoUsuario()){
            System.out.println("-------------\n1 - editar nome \n2 - editar descricao \n3 - editar valor bolsa \n4 - editar data inicio \n5 - editar data fim"+
            "\n6 - editar perio de vigencia da bolsa \n7 - adicionar profissional \n8 - adicionar atividade \n9 - status do projeto\n-------------" );
            int option = input.nextInt();
            switch (option) {
                case 1:
                    String novoNome = input.nextLine();
                    projeto.setNome(novoNome);
                    break;
                case 2:
                    String novaDescricao = input.nextLine();
                    projeto.setDescricao(novaDescricao);
                    break;
                case 3:
                    int novoValorBolsa = input.nextInt();
                    projeto.setValorBolsaProfissional(novoValorBolsa);
                    break;
                case 4:
                    System.out.println("implementar farofa da data");
                    break;
                case 5:
                    System.out.println("implementar farofa da data");
                    break;
                case 6:
                    System.out.println("implementar farofa da data");
                    break;
                case 7:
                    String nomeDoProfissional = input.nextLine();
                    Usuario usuarioEncontrado  = usuarioService.findUser(nomeDoProfissional);
                    projeto.addProfissional(usuarioEncontrado);
                    break;
                case 8:
                    System.out.println("digite a descricao da atividade e em seguida o usuario responsavel");
                    String identificacao = input.nextLine();
                    String descricao = input.nextLine();
                    String usuarioResponsavel = input.nextLine();
                    Usuario responsavel = usuarioService.findUser(usuarioResponsavel);
                    if(responsavel != null){
                        System.out.println("usuario encontrado, criando atividade...");
                        atividadeService.criarAtividade(identificacao, descricao, responsavel);
                        return;
                    }
                    System.out.println("usuario nao encontrado, atividade nao foi criada");
                    break;
                case 9:
                    String nomeDoProjeto = input.nextLine();
                    projetoService.changeStatus(nomeDoProjeto);
                    break;
            
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        }
    }
}
