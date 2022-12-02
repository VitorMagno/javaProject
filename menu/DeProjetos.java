package menu;


import Data.DataHandler;
import atividade.Atividade;
import atividade.AtividadeService;
import projeto.Projeto;
import projeto.ProjetoService;
import usuario.Usuario;
import usuario.UsuarioService;

public class DeProjetos implements Menu {
    ProjetoService projetoService = FactoryCustom.getInstanciaProjetoService();
    UsuarioService usuarioService = FactoryCustom.getInstanciaUsuarioService();
    AtividadeService atividadeService = FactoryCustom.getInstanciaAtividadeService();
    DataHandler dataHandler = FactoryCustom.getInstanciaDataHandler();
    @Override
    public void principal() {
        boolean running = true;
        int option;
        while (running){
            System.out.println("Selecione: \n1 - mostrar projetos \n2 - adicionar projeto \n3 - ver projeto \n4 - excluir projeto \n0 - voltar ao menu principal");
            option = Input.entradaDeInt();
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
        nome = Input.entradaDeLinha();
        descricao = Input.entradaDeLinha();
        unidadeAcademica = Input.entradaDeLinha();
        projetoService.criarProjeto(nome, descricao, unidadeAcademica);
        return;
    }

    @Override
    public void ver(){
        System.out.println("seleciona um projeto, mostra opcao de editar nome, descricao, valor da bolsa, data de inicio, data de fim, periodo de vigencia da bolsa"
        +"adicionar profissional, adicionar atividade, mudar status");
        System.out.println("digite o nome do projeto para ver mais detalhes e opcoes"); 
        String nomeDoProjeto = Input.entradaDeLinha();
        Projeto projetoEncontrado = projetoService.findProjeto(nomeDoProjeto);
        System.out.println(projetoEncontrado);
        System.out.println("deseja editar alguma informação?\n1-sim \n2-nao");
        int option = Input.entradaDeInt();
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
        nomeDoProjeto = Input.entradaDeLinha();
        projetoService.exluirProjeto(nomeDoProjeto);
        return;
    }

    public void editar(Projeto projeto){
        if (projetoService.verificacaoUsuario()){
            System.out.println("-------------\n1 - editar nome \n2 - editar descricao \n3 - editar valor bolsa \n4 - editar data inicio \n5 - editar data fim"+
            "\n6 - editar perio de vigencia da bolsa \n7 - adicionar profissional \n8 - adicionar atividade \n9 - status do projeto\n-------------" );
            int option = Input.entradaDeInt();
            switch (option) {
                case 1:
                    String novoNome = Input.entradaDeLinha();
                    projeto.setNome(novoNome);
                    break;
                case 2:
                    String novaDescricao = Input.entradaDeLinha();
                    projeto.setDescricao(novaDescricao);
                    break;
                case 3:
                    int novoValorBolsa = Input.entradaDeInt();
                    projeto.setValorBolsaProfissional(novoValorBolsa);
                    break;
                case 4:
                    String dataInicio = Input.entradaDeLinha();
                    dataHandler.setDataHR(dataInicio);
                    projetoService.setData(projeto, dataHandler.getDate(), 1);
                    break;
                case 5:
                    String dataFim = Input.entradaDeLinha();
                    dataHandler.setDataHR(dataFim);
                    projetoService.setData(projeto, dataHandler.getDate(), 2);
                    break;
                case 6:
                    int qtdDias = Input.entradaDeInt();
                    projetoService.setPeriodo(projeto, qtdDias);
                    break;
                case 7:
                    String nomeDoProfissional = Input.entradaDeLinha();
                    Usuario usuarioEncontrado  = usuarioService.findUser(nomeDoProfissional);
                    projeto.addProfissional(usuarioEncontrado);
                    break;
                case 8:
                    System.out.println("digite a descricao da atividade e em seguida o usuario responsavel");
                    String identificacao = Input.entradaDeLinha();
                    String descricao = Input.entradaDeLinha();
                    String usuarioResponsavel = Input.entradaDeLinha();
                    Usuario responsavel = usuarioService.findUser(usuarioResponsavel);
                    if(responsavel != null){
                        System.out.println("usuario encontrado, criando atividade...");
                        Atividade novaAtividade = atividadeService.criarAtividade(identificacao, descricao, responsavel);
                        projetoService.alocaAtividade(projeto, novaAtividade);
                        return;
                    }
                    System.out.println("usuario nao encontrado, atividade nao foi criada");
                    break;
                case 9:
                    String nomeDoProjeto = Input.entradaDeLinha();
                    projetoService.changeStatus(nomeDoProjeto);
                    break;
            
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        }
    }
}
