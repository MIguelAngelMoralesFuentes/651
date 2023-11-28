
package pkg651partidosfutbol;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
private static final String nombreArchivo = "partidos.txt";
   
    public static void main(String[] args) {
     ArrayList<partidosfutbol> partidos  = new ArrayList<partidosfutbol>();
     
     File archivo = new File(nombreArchivo);
     Scanner s =null;
        try {
            
            s=new Scanner (archivo);
            while (s.hasNextLine()){
                String linea =s.nextLine();
                String [] cortarString = linea.split("::");
         
                
                //mapeo de array con objetos de la clase partidos de futbol
                
                //crear un objeto
                partidosfutbol  partido = new partidosfutbol();
                partido.setEquipoLocal(cortarString[0]);
                partido.setEquipoVisitante(cortarString[1]);
               partido.setGolesLocal(Integer.parseInt(cortarString[2]));
               partido.setGolesVisitante(Integer.parseInt(cortarString[3]));
               
               
               partidos.add(partido);
     
     }
            
        } catch (Exception e) {
           e.printStackTrace();
            //System.out.println(" No se encontro archivo ");
        }
        
        //partidos.forEach(System.out::printl);
        System.out.println("Impresión  de objetos antes de procesar ");
        Iterator <partidosfutbol> itPartidos = partidos.iterator();
        while (itPartidos.hasNext()) {
            partidosfutbol partido = itPartidos.next();
            System.out.println(partido.getEquipoLocal()+" "
                               +partido.getEquipoVisitante()+" "
                               +partido.getGolesLocal()+" "
                               +partido.getGolesVisitante());
            
            
             }
        System.out.println("");
        
        //examinar partidos empatados
        itPartidos = partidos.iterator();
        while (itPartidos.hasNext()) {
        partidosfutbol partido = itPartidos.next();
            if (partido.getGolesLocal() !=partido.getGolesVisitante()) {
                itPartidos.remove();
                   
                
            }
            
        }
        
        System.out.println("Impresión de objetos despúes de procesar ");
        
        itPartidos = partidos.iterator();
        while (itPartidos.hasNext()) {
          partidosfutbol partido = itPartidos.next();
            System.out.println(partido.getEquipoLocal()+" "
                               +partido.getEquipoVisitante()+" "
                               +partido.getGolesLocal()+" "
                               +partido.getGolesVisitante());
            
            
            
        }
     
    }
    
}
