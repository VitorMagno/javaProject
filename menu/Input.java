package menu;

import java.util.Scanner;

public final class Input {
    
    private static Scanner instancia;
    public static Scanner getInstancia(){
        if (instancia == null)
            instancia =  new Scanner(System.in);
        return instancia;
    }
}
