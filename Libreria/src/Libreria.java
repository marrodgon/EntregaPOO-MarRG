import com.coti.tools.Esdia;

import modelo.Almacen;
import modelo.Libros;
import modelo.Autor;

public class Libreria {
    public static void main(String[] args) throws Exception {
        
        
        
    }

    private static void mostrarMenu(){
        String lineaDivisoria = "|"+"-".repeat(54)+"|";
        System.out.println(lineaDivisoria);
        System.out.println("|MIS LIBROS"+" ".repeat(44)+"|");
        System.out.println(lineaDivisoria);
        System.out.println("|  1) Nuevo almacén de libros"+" ".repeat(26)+"|");
        System.out.println("|  2) Establecer ritmo de lectura (páginas por minuto) "+"|");
        System.out.println("|  3) Añadir un nuevo libro al almacén"+" ".repeat(17)+"|");
        System.out.println("|  4) Mostrar información actual de libros"+" ".repeat(13)+"|");
        System.out.println("|  5) Salir (se borrará toda la información)"+" ".repeat(11)+"|");
        System.out.println(lineaDivisoria);
    }

}
