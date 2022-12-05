package menu;


import atividade.AtividadeService;
import data.DataHandler;
import projeto.ProjetoService;
import usuario.UsuarioService;

public final class FactoryCustom {
    private static Menu instanciaProjetos;
    private static Menu instanciaUsuarios;
    private static UsuarioService instanciaUsuarioService;
    private static ProjetoService instanciaProjetoService;
    private static AtividadeService instanciaAtividadeService;
    private static DataHandler instanciaDataHandler;


    public static Menu getInstanciaDeProjetos(){
        if(instanciaProjetos == null){
            instanciaProjetos = new DeProjetos();
        }
        return instanciaProjetos;
    }
    public static Menu getInstanciaDeUsuarios(){
        if(instanciaUsuarios == null){
            instanciaUsuarios = new DeUsuarios();
        }
        return instanciaUsuarios;
    }
    public static UsuarioService getInstanciaUsuarioService(){
        if(instanciaUsuarioService == null){
            instanciaUsuarioService = new UsuarioService();
        }
        return instanciaUsuarioService;
    }

    public static DataHandler getInstanciaDataHandler(){
        if (instanciaDataHandler == null){
            instanciaDataHandler = new DataHandler();
        }
        return instanciaDataHandler;
    }
    public static ProjetoService getInstanciaProjetoService(){
        if (instanciaProjetoService == null){
            instanciaProjetoService = new ProjetoService();
        }
        return instanciaProjetoService;
    }
    public static AtividadeService getInstanciaAtividadeService(){
        if (instanciaAtividadeService == null){
            instanciaAtividadeService = new AtividadeService();
        }
        return instanciaAtividadeService;
    }
}
