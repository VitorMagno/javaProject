package menu;

import java.util.Scanner;

public final class Input {
    
    private static Scanner instancia;

    public static void getInstancia(){
        if (instancia == null) {
            instancia =  new Scanner(System.in);
        }
    }
    public static String entradaDeLinha(){
        getInstancia();
        String entrada;
        entrada = instancia.nextLine();
        return entrada;
    }
    public static int entradaDeInt(){
        getInstancia();
        int entrada;
        entrada = instancia.nextInt();
        instancia.nextLine();
        return entrada;
    }
}
