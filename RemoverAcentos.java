package removeracentos;

import Funciones.FuncionesGenerales;

public class RemoverAcentos {

    public static void main(String[] args) {
        FuncionesGenerales palabra = new FuncionesGenerales(); 
        String miPalabra;
        miPalabra = palabra.removerAcentos("cheétos");
        System.out.println(miPalabra);
    }
    
}
