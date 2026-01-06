package reservaasientos;

import java.util.Scanner;

public class ReservaAsientos {

    public static void main(String[] args) {
        
        
        //ctrl + espacio: suggestions
        
        char asientos[][] = new char[10][10]; //Matriz de 10 filas y 10 asientos c/u
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila, asiento;
        String respuesta;
        
        //Recorro y cargo la matriz
        for(int f = 0; f<10; f++){
            for(int c = 0; c<10; c++){
                asientos[f][c] = 'L';
                System.out.print(asientos[f][c] + " ");
            }
            System.out.println();
        }
        
        System.out.println("---------Bienvenido al Sistema de Reservas---------");
        
        while(bandera == false){
            System.out.println("Ingrese Fila y Asiento a reservar");
            
            System.out.print("Fila (entre 0 y 9): ");
            fila = teclado.nextInt();
            
            System.out.print("Asiento (entre 0 y 9): ");
            asiento = teclado.nextInt();
            
            //char no es un objeto. String si lo es, y ahi si podria usar asientos[fila][asiento].equals("L")
            //char es un tipo de dato primitivo
            if(asientos[fila][asiento] == 'L'){
                asientos[fila][asiento] = 'X';
                System.out.println("El asiento fue reservado correctamente");
                
                //Muestro toda la matriz
                for(int f = 0; f<10; f++){
                    for(int c = 0; c<10; c++){
                        System.out.print(asientos[f][c] + " ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("El asiento ya se encuentra ocupado");
            }
            
            System.out.println("Desea usted reservar otro asiento? S: si. Cualquier caracter: no");
            respuesta = teclado.next();
            if(respuesta.equalsIgnoreCase("S")){
                //Nada. Bandera sigue igual
            }
            else{
                bandera = true;
            }
            
        }
    }
    
}