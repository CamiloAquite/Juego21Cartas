/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto21cartas;

import java.util.Random;
import java.util.Scanner;

public class Proyecto21Cartas {

    public static void main(String[] args) {

         //Constantes para estandarizar los valores del programa
        final short MAX_TARJETAS_GRUPO= 7; //Tarjetas por grupo
        final short MAX_GRUPOS= 3; //Cantidad de grupos
        final short MAX_TARJETAS= MAX_TARJETAS_GRUPO*MAX_GRUPOS; //Total de tarjetas.
        final short MIN_TARJETA_VALOR= 'A'; //Tarjeta incial, en este caso letra A.
        final short MAX_TARJETA_VALOR= (char)(MAX_TARJETAS+(int)('A')-1); //Tarjeta final.
        

        char indice;
        int i,j,tope1,tope2,tope3,contador;
        var generador=new Random();
        String columnaSelec;
        Scanner entrada= new Scanner(System.in);
        tope1=-1;tope2=-1;tope3=-1;
        
        contador=1;
        //String columnaSelec;
        //columnaSelec=0;
        
        char[] grupo1= new char[MAX_TARJETAS_GRUPO],
               grupo2= new char[MAX_TARJETAS_GRUPO],
               grupo3= new char[MAX_TARJETAS_GRUPO];
        char[] deck= new char[MAX_TARJETAS];
        
        //Generamos y agregamos los numeros aleatorios (letras) dentro del arreglo de 21 espacios
        for (i=0;i<MAX_TARJETAS;i++){
            indice=(char) ((generador.nextInt((int)MAX_TARJETA_VALOR-(int)MIN_TARJETA_VALOR+1)+(int)(MIN_TARJETA_VALOR)));

            j=0;
            while (j<i){
                    if (deck[j]==indice ){
                    j=0;
                    indice= (char) (generador.nextInt((int)MAX_TARJETA_VALOR-(int)MIN_TARJETA_VALOR+1)+(int)(MIN_TARJETA_VALOR));
                }else {
                    j++;
                }
            }
            deck[i]= indice;  
        }
            
        System.out.println();
        
        //Dividimos el arreglo de 21 espacios en los tres arreglos que nos dan.
        for (i=0;i<MAX_TARJETAS;i++){
            
            for (i=0;i<=6;i++){
              tope1++;
              grupo1[tope1]=deck[i];
            }
            for (i=7;i<=13;i++){
              tope2++;
              grupo2[tope2]=deck[i];
            }
            for (i=14;i<=20;i++){
              tope3++;
              grupo3[tope3]=deck[i];
            }
        }
        System.out.println();
        
        System.out.println("Haremos 3 secuencias. Empecemos... ");
        
        do{
            System.out.println("Secuencia "+(contador)+": ");
           
            System.out.println();
        
            //Imprimimos la primera baraja
            for (i=0;i<1;i++){
                for (j=0;j<=6;j++){
                    System.out.println(" "+grupo1[j]+ "   "+ grupo2[j]+"   "+grupo3[j]);
                }
            } 
            
            System.out.println();
            
            System.out.print("En que grupo esta tu tarjeta [1,2,3]: ");
            columnaSelec = entrada.nextLine();
            contador++;
            
            while (!columnaSelec.equals("1") && !columnaSelec.equals("2") && !columnaSelec.equals("3")) {
                System.out.print("ERROR - Opcion incorrecta, ingresa una opcion valida [1,2,3]: ");
                columnaSelec = entrada.nextLine();
            } 
            
            switch (columnaSelec) {
                case "1":
                  for (i = 1; i <= 7; i++) {
                    deck[i - 1] = grupo2[i - 1];
                    deck[i + 7 - 1] = grupo1[i - 1];
                    deck[i + 14 - 1] = grupo3[i - 1];
                } 
                break;
                case "2":
                  for (i = 1; i <= 7; i++) {
                    deck[i - 1] = grupo1[i - 1];
                    deck[i + 7 - 1] = grupo2[i - 1];
                    deck[i + 14 - 1] = grupo3[i - 1];
                } 
                break;
                case "3":
                  for (i = 1; i <= 7; i++) {
                    deck[i - 1] = grupo1[i - 1];
                    deck[i + 7 - 1] = grupo3[i - 1];
                    deck[i + 14 - 1] = grupo2[i - 1];
                } 
                break;
            } 
            for (i = 0; i < 7; i++) {
                grupo1[i] = deck[(i + 1) * 3 - 2 - 1];
                grupo2[i] = deck[(i + 1) * 3 - 1 - 1];
                grupo3[i] = deck[(i + 1) * 3 - 1];
            }
              
        }while(contador<4);
    System.out.print("Obviamente elegiste la " + deck[10]);
    System.out.println("");    
    }
    
}
