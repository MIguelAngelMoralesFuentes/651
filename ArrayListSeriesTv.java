
package arregloshugo;
import java.util.ArrayList;

public class ArrayListSeriesTv {


    public static void main(String[] args) {
   ArrayList<String> listaseries = new ArrayList<>();
   listaseries.add("Braking bad");
   listaseries.add("Friends");
   listaseries.add("Vikingos");
   
        System.out.println(listaseries);
        listaseries.remove("Friends");
          System.out.println(listaseries);
          
          boolean contanFriends = listaseries.contains("Friends");
          System.out.println("La lista contiene friends ?" + contanFriends);
          int tamano = listaseries.size();
          System.out.println("el tamaño del arraylist es " + tamano);
          
          //Declarar diverso tipos de arraylist
          ArrayList<Integer> listaInteger = new ArrayList<>();
          ArrayList<Double> listaDoubles = new ArrayList<>();
          ArrayList<Boolean> listaBoolean = new ArrayList<>();
    }
    
}
