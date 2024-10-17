package modelo;

import com.coti.tools.Esdia;

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

    public boolean agregarLibro(Libros libro) {
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
        
        String lineaDivisoriaLarga = "|"+"-".repeat(70)+"|";
        System.out.println(lineaDivisoriaLarga);
        System.out.println("| Título | Año | Autor | Premio Planeta | Páginas | Tiempo (min) | Precio |");
        System.out.println(lineaDivisoriaLarga);

        int tiempoTotal = 0;
        double valorTotal = 0.0;

        for (int i = 0; i < librosAñadidos; i++) {
            Libros libro = libros[i];
            String premioPlaneta = libro.getAutor().isPremioPlaneta() ? "Sí" : "No";
            int tiempoLectura = libro.calcularTiempoLectura(paginasPorMinuto);
            tiempoTotal += tiempoLectura;
            valorTotal += libro.getPrecio();

            System.out.printf("| %s | %d | %s | %s | %d | %d | %.2f € |\n",
                    libro.getTitulo(),
                    libro.getAñoPublicacion(),
                    libro.getAutor().getNombreCompleto(),
                    premioPlaneta,
                    libro.getPaginas(),
                    tiempoLectura,
                    libro.getPrecio());
        }

        System.out.println(lineaDivisoriaLarga);
        System.out.printf("\n| Tiempo de lectura total: %d min | Valor total: %.2f € |\n", tiempoTotal, valorTotal);
        System.out.println(lineaDivisoriaLarga);
    }

}
