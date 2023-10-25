
package Funciones;

public class FuncionesGenerales {
    public String removerAcentos(String palabraOrigen){
        String palabraRetorno = palabraOrigen.toLowerCase();
        String conAcento = "descripcíónés";
        String sinAcento = "descripcciones";
        
        int ejemplares = conAcento.length();
        for (int i = 0; i < ejemplares; i++) {
            palabraRetorno = palabraRetorno.replace(conAcento.charAt(i), sinAcento.charAt(i));
        }
        return palabraRetorno;
    }
}
