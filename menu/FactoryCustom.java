package menu;

import usuario.UsuarioService;

public final class FactoryCustom {
    private static Menu instanciaProjetos;
    private static Menu instanciaUsuarios;
    private static UsuarioService instanciaUsuarioService;

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
}
