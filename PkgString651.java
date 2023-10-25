
package pkhstring;

public class PkgString651{

    public static void main(String[] args) {
      String cadenaDeTexto ="Universidad politécnica del valle de Méxic";
        System.out.println("Cadena original: "+cadenaDeTexto);
        System.out.println("La longitud de la cadena es "+cadenaDeTexto.length());
        System.out.println("La primera letra de la cadena "+ cadenaDeTexto.charAt(0));
       
        int ultimaLetra = (cadenaDeTexto.length()) -1;  
        System.out.println("Ultima letra: "+cadenaDeTexto.charAt(ultimaLetra));
        System.out.println("Valor de la subcadena: "+ cadenaDeTexto.substring(1, 3));
        
        String cadena1= "HolA"; 
        String cadena2= "Hola";
        
        String mayusculasC1 = cadena1.toUpperCase();
        String mayusculasC2 = cadena2.toUpperCase();
        
        Integer numeroEntero = 0;

        
        
        System.out.println("¿La cadena uno es igual a la 2?: "+mayusculasC1.equals(mayusculasC2));
    }
    
}
