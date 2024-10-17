import com.coti.tools.Esdia;

import modelo.Almacen;
import modelo.Libros;
import modelo.Autor;

public class Libreria {
    private static Almacen almacen;

    public static void main(String[] args) throws Exception {
        int eleccion;
        do{
            mostrarMenu();
            eleccion = Esdia.readInt("Elija una opción (1-5):\n");
            ejecutarEleccion(eleccion);
        } while (eleccion != 5);
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

    private static void ejecutarEleccion(int eleccion){
        switch (eleccion) {
            case 1:
                crearAlmacen();
                break;

            case 2:
                setRitmoLectura();
                break;

            case 3:
                añadirLibro();
                break;

            case 4:
                mostrarLibros();
                break;
        
            case 5:
                System.out.println("Saliendo, se borrarán todos los datos.");

            default:
                System.err.println("Elección no válida");;
        }
    }

    private static void crearAlmacen(){
        int numeroLibros = Esdia.readInt("Indique cuántos libros va a haber en el almacen:\n");
        almacen = new Almacen(numeroLibros);
        System.out.println("Se ha creado un almacen con espacio para "+numeroLibros+" libros");
    }

    private static void setRitmoLectura() {
        if (almacen == null) {
            System.out.println("No hay ningún almacen creado.\n");
        }
        int paginasPorMinuto = Esdia.readInt("Indique cuantas páginas por minuto lee: \n");
        almacen.setPaginasPorMinuto(paginasPorMinuto);
        System.out.println("Ha indicado que usted lee "+paginasPorMinuto+" páginas por minuto.");
    }
    
    private static void añadirLibro() {
        if (almacen == null) {
            System.out.println("No hay ningún almacen creado.\n");
        }
        String titulo = Esdia.readString("Inserte el título del libro que quiere añadir: \n");
        int añoPublicacion = Esdia.readInt("Inserte el año de publicación: \n");
        int paginas = Esdia.readInt("Inserte el numero de páginas: \n");
        float precio = Esdia.readFloat("Inserte el precio: \n");
        String nombreAutor = Esdia.readString("Inserte el nombre del autor: \n");
        String apellidosAutor = Esdia.readString("Inserte los apellidos del autor: \n");
        boolean premioPlaneta = Esdia.siOno("¿Ha ganado el autor algún premio planeta?\n");

        Autor autor = new Autor(nombreAutor, apellidosAutor, premioPlaneta);
        Libros libro = new Libros(titulo, añoPublicacion, autor, paginas, precio);

        if (almacen.puedoAñadirLibro(libro)) {
            System.out.println("Libro añadido correctamente.");
        } else {
            System.err.println("El almacén no tiene espacio para añadir más libros.");
        }
    }

    private static void mostrarLibros() {
        if (almacen == null) {
            System.out.println("No hay ningún almacen creado.");
            return;
        }
        almacen.mostrarLibros();
    }

}
