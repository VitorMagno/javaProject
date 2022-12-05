package menu;


import atividade.Atividade;
import atividade.AtividadeService;
import data.DataHandler;
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
        System.out.println("digite o nome:");
        nome = Input.entradaDeLinha();
        System.out.println("digite a descricao:");
        descricao = Input.entradaDeLinha();
        System.out.println("digite a unidade academica:");
        unidadeAcademica = Input.entradaDeLinha();
        projetoService.criarProjeto(nome, descricao, unidadeAcademica);
        return;
    }

    @Override
    public void ver(){
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
            int option;
            boolean running =true;
            while (running) {
                System.out.println("-------------\n1 - editar nome \n2 - editar descricao \n3 - editar valor bolsa \n4 - editar data inicio \n5 - editar data fim"+
            "\n6 - editar periodo de vigencia da bolsa \n7 - adicionar profissional \n8 - criar atividades nesse projeto \n9 - status do projeto"+ 
            "\n10 - gerenciar atividades desse projeto \n11 - retorna ao menu anterior\n-------------" );
                option = Input.entradaDeInt();
                switch (option) {
                    case 1:
                        System.out.println("digite novo nome:");
                        String novoNome = Input.entradaDeLinha();
                        projeto.setNome(novoNome);
                        break;
                    case 2:
                        System.out.println("digite nova descricao:");
                        String novaDescricao = Input.entradaDeLinha();
                        projeto.setDescricao(novaDescricao);
                        break;
                    case 3:
                        System.out.println("digite novo valor:");
                        int novoValorBolsa = Input.entradaDeInt();
                        projeto.setValorBolsaProfissional(novoValorBolsa);
                        break;
                    case 4:
                        System.out.println("digite nova data e hr no formato 'dd/mm/aa hr':");
                        String dataInicio = Input.entradaDeLinha();
                        dataHandler.setDataHR(dataInicio);
                        projetoService.setData(projeto, dataHandler.getDate(), 1);
                        break;
                    case 5:
                        System.out.println("digite nova data e hr no formato 'dd/mm/aa hr':");
                        String dataFim = Input.entradaDeLinha();
                        dataHandler.setDataHR(dataFim);
                        projetoService.setData(projeto, dataHandler.getDate(), 2);
                        break;
                    case 6:
                        System.out.println("digite a quantidade de dias que durara a bolsa:");
                        int qtdDias = Input.entradaDeInt();
                        projetoService.setPeriodo(projeto, qtdDias);
                        break;
                    case 7:
                        System.out.println("digite o nome do profissional: ");
                        String nomeDoProfissional = Input.entradaDeLinha();
                        Usuario usuarioEncontrado  = usuarioService.findUser(nomeDoProfissional);
                        if(usuarioEncontrado!=null){
                            System.out.println("usuario encontrado foi: "+usuarioEncontrado);
                            projeto.addProfissional(usuarioEncontrado);
                        }
                        break;
                    case 8:
                        System.out.println("digite a identificacao");
                        String identificacao = Input.entradaDeLinha();
                        System.out.println("descricao da atividade");
                        String descricao = Input.entradaDeLinha();
                        System.out.println("usuario responsavel");
                        String usuarioResponsavel = Input.entradaDeLinha();
                        Usuario responsavel = usuarioService.findUser(usuarioResponsavel);
                        if(responsavel != null){
                            System.out.println("usuario encontrado, criando atividade...");
                            Atividade novaAtividade = atividadeService.criarAtividade(identificacao, descricao, responsavel);
                            if(novaAtividade == null){
                                System.out.println("abortado");
                                return;
                            }
                            projetoService.alocaAtividade(projeto, novaAtividade);
                            return;
                        }
                        System.out.println("atividade nao foi criada");
                        break;
                    case 9:
                        System.out.println("digite o nome do projeto que deseja mudar o status");
                        String nomeDoProjeto = Input.entradaDeLinha();
                        projetoService.changeStatus(nomeDoProjeto);
                        break;
                    case 10:
                        System.out.println("gerenciar atividades desse projeto");
                        atividades(projeto);
                        break;
                    case 11: 
                        System.out.println("saindo");
                        return;
                    default:
                        System.out.println("opcao invalida");
                        break;
                }
            }
        }
    }

    public void atividades(Projeto projeto) {
        int option;
        boolean running = true;
        while (running) {
            
            System.out.println("digite: \n1-criar atividade \n2-ver atividades \n3-selecionar atividade para ediçao ou adiçao de informaçoes \n4-excluir atividade \n5-retorna ao menu anterior");
            option = Input.entradaDeInt();
            switch (option) {
                case 1:
                    System.out.println("digite a identificacao, descricao da atividade e em seguida o usuario responsavel");
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
    
                case 2:
                    projetoService.listarAtividades(projeto);
                break;
                case 3:
                    String atividadeParaEditar = Input.entradaDeLinha();
                    Atividade editar = projeto.buscaAtividade(atividadeParaEditar);
                    if(editar==null){
                        System.out.println("atividade nao encontrada");
                        return;
                    }
                    editarAtividade(editar);
                break;
                case 4:
                    String atividadeParaExcluir = Input.entradaDeLinha();
                    Atividade excluir = projeto.buscaAtividade(atividadeParaExcluir);
                    if(excluir==null){
                        System.out.println("atividade nao encontrada");
                        return;
                    }
                    excluirAtividade(excluir, projeto);
                break;
                case 5:
                    System.out.println("saindo");
                    return;
                default:
                    break;
            }
        }
    }
    public void editarAtividade(Atividade atividade) {
        int option;
        boolean running = true;
        while (running) {
            System.out.println("editar: \n1-identificacao \n2-descricao \n3-responsavel \n4-inicio \n5-fim \n6-adicionar profissional" +
            "\n7-alocar tarefa a profissional \n8-retorna ao menu anterior");
            option = Input.entradaDeInt();
            switch (option) {
                case 1:
                    System.out.println("digite a nova identificacao");
                    String novaId = Input.entradaDeLinha();    
                    atividadeService.setNovaIdentificacao(novaId, atividade);
                break;
                case 2:
                    System.out.println("digite a nova descricao");
                    String novaDescricao = Input.entradaDeLinha();
                    atividadeService.setNovaDescricao(novaDescricao, atividade);
                break;
                case 3:
                    System.out.println("digite o nome do novo responsavel, deve ser um profissional");
                break;
                case 4:
                    System.out.println("digite a nova data e hr de inicio, no formato 'dd/mm/aaaa' hh");
                    String dataInicio = Input.entradaDeLinha();
                    atividadeService.setData(dataInicio, atividade, 1);
                break;
                case 5:
                    System.out.println("digite a nova data e hr de fim, no formato 'dd/mm/aaaa' hh");
                    String dataFim = Input.entradaDeLinha();
                    atividadeService.setData(dataFim, atividade, 2);
                break;
                case 6:
                    System.out.println("digite o nome do profissional");
                    String nomeDoProfissional = Input.entradaDeLinha();
                    Usuario profissionalRequisitado = usuarioService.findUser(nomeDoProfissional);
                    atividadeService.addProfissional(atividade, profissionalRequisitado);
    
                break;
                case 7:
                    System.out.println("digite qual tarefa e o profissional que deseja alocar");
                    String novaTarefa = Input.entradaDeLinha();
                    String alocarAoProfissional = Input.entradaDeLinha();
                    atividadeService.DesignaTarefaAProfissional(atividade, alocarAoProfissional, novaTarefa);
                break;
                case 8: 
                    System.out.println("saindo");
                    return;
                default:
                    break;
            }
        }
    }
    public void excluirAtividade(Atividade atividade, Projeto projeto) {
        projetoService.removeAtividade(atividade, projeto);
    }
}
