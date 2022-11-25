package menu;

import java.util.GregorianCalendar;

import usuario.UsuarioService;

public final class FactoryCustom {
    private static Menu instanciaProjetos;
    private static Menu instanciaUsuarios;
    private static UsuarioService instanciaUsuarioService;
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
}
