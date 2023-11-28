package ventasmunicipio;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class VentasMunicipio {
    private static final String nArchivo = "ArchivoBaseCompraProductos.txt";

    public static void main(String[] args) {
        ArrayList<Municipios> datos = new ArrayList<Municipios>();
        File archivo = new File(nArchivo);
        Scanner s = null;

        try {
            s = new Scanner(archivo);
            while (s.hasNext()) {
                String linea = s.nextLine();
                String[] cortarString = linea.split(" ");
                String municipio = cortarString[3]; 

                Municipios info = new Municipios();

                info.setMunicipioA(municipio);

                if (municipio.equals("CiudadA")) {
                    int cantidad = Integer.parseInt(cortarString[4].substring(1)); 
                    info.setTotalA(cantidad);
                }
                if (municipio.equals("CiudadB")){
                    int cantidad = Integer.parseInt(cortarString[4].substring(1));
                    info.setTotalB(cantidad);
                }
                if (municipio.equals("CiudadC")){
                    int cantidad = Integer.parseInt(cortarString[4].substring(1));
                    info.setTotalC(cantidad);
                }

                datos.add(info);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        int CMA = 0; int acumB=0;
        int CMB = 0; int acumA=0;
        int CMC = 0; int acumC=0;

        for (Municipios info : datos) {
            String municipio = info.getMunicipioA();

            if (municipio.equals("CiudadA")) {
                CMA++;
                acumA += info.getTotalA();
            } else if (municipio.equals("CiudadB")) {
                CMB++;
                acumB += info.getTotalB();
            } else if (municipio.equals("CiudadC")) {
                CMC++;
                acumC += info.getTotalC();
            }
        }

        System.out.println("+----------------------------------------+");
        System.out.println("| Nombre de ciudad| Pagos        | Total |");
        System.out.println("|-----------------+--------------+-------|");
        System.out.println("| Municipio A     | " + CMA + "           | " +"$"+ acumA + "  |");
        System.out.println("|-----------------+--------------+-------|");
        System.out.println("| Municipio B     | " + CMB + "           | " +"$"+acumB + "  |");
        System.out.println("|-----------------+--------------+-------|");
        System.out.println("| Municipio C     | " + CMC + "           | " +"$"+acumC + "  |");
        System.out.println("+-----------------+--------------+-------+");

    }
}
