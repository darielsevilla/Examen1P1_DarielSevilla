/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_darielsevilla;

import java.util.Scanner;
import java.security.SecureRandom;


public class Examen1P1_DarielSevilla {
    //metodo 1
    public static String primos(int num){
        String resp = "";
        for (int i = 1; i <= num; i++){
            //determinar si es factor
            String temp = resp;
            if(num % i == 0){
                //determinar si factor es primo
                if (i == 1){
                    resp += Integer.toString(i);
                 
                } else {
                    int cont = 0;
                    //numero de factores de cada factor
                    for(int j = 1; j <= i; j++){
                        if(i % j == 0){
                            cont++;
                        }
                        
                    }
                    
                    if (cont == 2){
                        resp += ", ";
                        resp += Integer.toString(i);
                    }
                }
            }
            
            
        }
        
        return resp;
    }
    //metodo 2
    public static void contorno(int ancho){
        int alto = (ancho/2) + 1;
        //filas de piramide
        for(int i = 0; i < alto; i++){
            int pos = ancho/2;
            for(int len = 0; len < ancho; len++){
                if(len < pos + (i+1) && len > pos - (i+1) && i < pos){
                    if ((len == pos - i || len == pos+i)  || (i == alto - 2  && len > pos-i && len < pos+i)){
                        System.out.print("+");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
        

    }
    //metodo 3
    public static String vecinos(String arg){
        String resp = "";
        SecureRandom random = new SecureRandom();
        int binario = random.nextInt(2);
        System.out.println("Numero generado: "+binario);
        int move = 0;
        //chequeo de suma y resta
        if(binario == 0){
            move = -1;
        }else{
            move = 1;
        }
        
        for(int i = 0; i < arg.length(); i++){
           resp += (char) (arg.charAt(i) + move);
        }
        
        return resp;
        
    }
    //metodo extra pascal
    public static int facto(int n){
        
        int fact = 1;
        if (n != 0){
            for (int i = 1; i <= n; i++){
                fact *= i;
            }
        }
        return fact;
    }
    
    public static int permu(int n, int r){
        int perm = facto(n) / facto(n-r);
       
        return perm;
    }
    
    public static int combi(int n, int r){
        int c = permu(n, r) / facto(r);
   
        return c;
    }
    
    public static void pascal(int filas){
        for(int i = 0; i < filas; i++){
            for (int j = 0; j < i; j++){
                System.out.printf("[%d]", combi(i,j));
                
            }
            System.out.println("[1]");
        }
    }
    
    public static void main(String[] args){
        Scanner lea = new Scanner(System.in);
        int menu;
        do {
            System.out.println("\n\n--Opcion menu--\n");
            System.out.println("1-Opcion primos");
            System.out.println("2-Contorno");
            System.out.println("3-Vecinos");
            System.out.println("4-Pascal");
            System.out.println("5-Salida");
            System.out.print("Opcion menu: ");
            menu = lea.nextInt();
            
            //menu
            switch(menu){
                case 1:
                    //primos 
                    int numP;
                    float check;
                    do {
                        System.out.print("Ingrese numero: ");
                        numP = lea.nextInt();
                        
                    }while(numP < 1);
                    
                    String resp = primos(numP);
                    System.out.printf("Los numeros primos que dividen el numero %d son: %s", numP, resp);
                    
                    break;
                case 2:
                    //contorno
                    int contor;
                    do{
                        System.out.print("Ingrese contorno: ");
                        contor = lea.nextInt();
                    }while(contor % 2 == 0);
                    
                    //metodo contorno
                    contorno(contor);
                    break;
                case 3:
                    //Vecinos
                    int noLet = 0;
                    String cadena;
                    lea.nextLine();
                    do{
                        noLet = 0;
                        System.out.print("Ingrese caracteres: ");
                        
                        cadena = lea.nextLine();
                        
                        //chequeo de letra
                        for (int i = 0; i < cadena.length(); i++){
                            if((cadena.toLowerCase().charAt(i) < 97 || cadena.toLowerCase().charAt(i) > 122) && cadena.charAt(i) != 32){
                                noLet++;
                            }
                            
                        }
                     
                    }while(noLet != 0);
                    
                    String nueva = vecinos(cadena);
                    System.out.println("Cadena resultante: " + nueva);
                    
                    break;
                case 4:
                    //caso pascal
                    int entero;
                    do{
                        System.out.print("Ingrese numero entero positivo: ");
                        entero = lea.nextInt();
                    }while(entero < 0);
                    
                    pascal(entero);
                    break;
            }
            
        }while(menu != 5);
    }
    
}
