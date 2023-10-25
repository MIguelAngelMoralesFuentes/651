/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arregloshugo;

import java.util.ArrayList;


public class ArrayListPersonas {
    public static void main(String[] args) {
     ArrayList<Persona>listaPersonas=new ArrayList<>();
        listaPersonas.add(new Persona (1, "Benito",15));
        listaPersonas.add(new Persona (2, "Pedrito",17));
        listaPersonas.add(new Persona (3, "juan",25));
        
        //System.out.println("Imprime lista de personas: "+listaPersonas);
        System.out.println("---------FOR-------------------");
        for (int i = 0; i < listaPersonas.size(); i++) {
            System.out.println("Contenido"+ listaPersonas.get(i).getNombre());
         
        }
        System.out.println("----------FOR EACH----------------");
                for (Persona perso:listaPersonas){
                    System.out.println("contenido"+perso.getNombre());
}}}

