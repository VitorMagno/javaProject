package menu;

import java.util.GregorianCalendar;

import atividade.AtividadeService;
import projeto.ProjetoService;
import usuario.UsuarioService;

public final class FactoryCustom {
    private static Menu instanciaProjetos;
    private static Menu instanciaUsuarios;
    private static UsuarioService instanciaUsuarioService;
    private static ProjetoService instanciaProjetoService;
    private static AtividadeService instanciaAtividadeService;
    private static GregorianCalendar instanciaGCalendar;


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

    public static GregorianCalendar getInstanciaGregorianCalendar(){
        if (instanciaGCalendar == null){
            instanciaGCalendar = new GregorianCalendar();
        }
        return instanciaGCalendar;
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
