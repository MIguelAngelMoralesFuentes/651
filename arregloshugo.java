/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arregloshugo;
import java.util.*;
public class arregloshugo {    
    public static void main(String[] args) {
        //guardar las ventas de 10 dias en un arreglo 
        //y determinar cuales son mayores a 2000 (inclusive)
        double ventas[]= new double [10];
        Scanner entrada= new Scanner(System.in);
        System.out.println("********Ventas mayores a 2000*****");
        System.out.println("");
        System.out.println("ingrese las 10 ventas del mes");
        
        //llenar el arreglo
        for (int i = 0; i <= ventas.length -1; i++) {
            System.out.println("ingrese la venta:"+ i+1+ " ");
            ventas[i] = entrada.nextDouble();
            
        }
        //seterminar cuales ventas en el arreglo son mayores o iguales 
        //a 2000
        ventasMayores2000(ventas);
    }
    public static void ventasMayores2000(double x[]){
        int j=0;
        int total=0;
        double acumuladorVentas=0;
        System.out.println("estas son las ventas mayores o iguales a 2000");
        
        //recorrer el arreglo
        while(j <10){
            if(x[j] >=2000){
                System.out.println("$"+ x[j]);
                total ++;
                acumuladorVentas = acumuladorVentas +1;
            }
            j++;
        }
        System.out.println("El total de ventas >=2000 es: "+ total);
        System.out.println("El acumulado total es: "+ acumuladorVentas);
    }
}


