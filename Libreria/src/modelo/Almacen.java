package modelo;

public class Almacen {
    private Libros[] libros;
    private int librosAñadidos;
    private int paginasPorMinuto = 1;

    public Almacen(int numeroLibros) {
        libros = new Libros[numeroLibros];
        librosAñadidos = 0;
    }

    public void setPaginasPorMinuto(int paginasPorMinuto) {
        this.paginasPorMinuto = paginasPorMinuto;
    }

    public boolean puedoAñadirLibro(Libros libro) {
        if (librosAñadidos < libros.length) {
            libros[librosAñadidos] = libro;
            librosAñadidos++;
            return true;
        }
        return false;
    }

    public void mostrarLibros() {
        if (librosAñadidos == 0) {
            System.out.println("No hay libros en el almacén.");
            return;
        }
        
        String lineaDivisoriaLarga = "|"+"-".repeat(129)+"|";
        System.out.println(lineaDivisoriaLarga);
        System.out.println("|Título                        |Año |Autor                         |Premio Planeta|Páginas|Tiempo lectura en minutos|Precio       |");
        System.out.println(lineaDivisoriaLarga);

        int tiempoTotal = 0;
        float valorTotal = 0;

        for (int i = 0; i < librosAñadidos; i++) {
            Libros libro = libros[i];
            String premioPlaneta = libro.getAutor().esPremioPlaneta() ? "Sí" : "No";
            int tiempoLectura = libro.calcularTiempoLectura(paginasPorMinuto);
            tiempoTotal += tiempoLectura;
            valorTotal += libro.getPrecio();

            System.out.printf("|%30s|%4s|%30s|%2s            |%3s    |%3s min                  | %10s €|\n",
                    libro.getTitulo(),
                    String.valueOf(libro.getAñoPublicacion()),
                    libro.getAutor().getNombreCompleto(),
                    premioPlaneta,
                    String.valueOf(libro.getPaginas()),
                    tiempoLectura,
                    String.valueOf(libro.getPrecio()));
        }

        System.out.println(lineaDivisoriaLarga);
        System.out.printf("| Tiempo de lectura total                                                                 |%3s min                  |             |\n", String.valueOf(tiempoTotal));
        System.out.printf("| Valor total                                                                                                       | %10s €|\n", String.valueOf(valorTotal));
        System.out.println(lineaDivisoriaLarga+"\n");
    }

}
