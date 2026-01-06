package reservaasientos;

import java.util.Scanner;

public class ReservaAsientos {

    public static void main(String[] args) {
        
        //Declaracion de variables
        char asientos[][] = new char[10][10]; //Matriz de 10 filas y 10 asientos c/u
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila = 0, asiento = 0; //Deben ser inicializados debido a las validaciones
        String respuesta;
        String verMapa;
        
        //Recorro y cargo la matriz
        for(int f = 0; f<10; f++){
            for(int c = 0; c<10; c++){
                asientos[f][c] = 'L';
                //System.out.print(asientos[f][c] + " ");
            }
            //System.out.println();
        }
        
        //Bienvenida al sistema
        System.out.println("---------Bienvenido al Sistema de Reservas---------");
        
        //Reserva de asientos
        while(bandera == false){
            
            //Visualizacion del mapa
            System.out.println("Desea usted ver los asientos disponibles? S: si. Cualquier caracter: no");
            verMapa = teclado.next();
            
            if(verMapa.equalsIgnoreCase("S")){
                mostrarMapa(asientos);
            }
            
            
            //Reserva
            System.out.println("\nIngrese Fila y Asiento a reservar");
            
            boolean valorIngresadoOk = false; //Importante: Debe estar dentro del while para reiniciarse en cada iteracion su valor a false
            while(valorIngresadoOk == false){
            
                System.out.print("Fila (entre 0 y 9): ");
                fila = teclado.nextInt();

                System.out.print("Asiento (entre 0 y 9): ");
                asiento = teclado.nextInt();
                
                if(fila>=0 && fila<=9){
                    if(asiento>=0 && asiento<=9){
                        valorIngresadoOk = true;
                    }
                    else{
                        System.out.println("El numero de asiento no es valido.");
                    }
                }
                else{
                    System.out.println("El numero de fila no es valido");
                }
            }
            
            //char no es un objeto. String si lo es, y ahi si podria usar asientos[fila][asiento].equals("L")
            //char es un tipo de dato primitivo
            if(asientos[fila][asiento] == 'L'){
                asientos[fila][asiento] = 'X';
                System.out.println("El asiento fue reservado correctamente");
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
 
    //Static hace el metodo utilizable para toda la clase
    //Concepto para usar las variables locales afuera del main las paso como parametros al metodo.
    static void mostrarMapa(char asientos[][]){
        for(int f = 0; f<10; f++){
            for(int c = 0; c<10; c++){
                System.out.print("[" + asientos[f][c] + "]");
            }
        System.out.println();
        }
    }
}