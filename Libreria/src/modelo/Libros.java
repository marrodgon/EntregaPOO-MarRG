package modelo;

public class Libros {
    private String titulo;
    private int añoPublicacion;
    private Autor autor;
    private int paginas;
    private float precio;

    public Libros(String titulo, int añoPublicacion, Autor autor, int paginas, float precio){
        this.titulo = titulo;
        this.añoPublicacion =añoPublicacion;
        this.autor = autor;
        this.paginas = paginas;
        this.precio = precio;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getAñoPublicacion(){
        return añoPublicacion;
    }

    public Autor getAutor(){
        return autor;
    }

    public int getPaginas(){
        return paginas;
    }

    public float getPrecio(){
        return precio;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAñoPublicacion(int añoPublicacion){
        this.añoPublicacion = añoPublicacion;
    }

    public void setPaginas(int paginas){
        this.paginas = paginas;
    }

    public void setPrecio(float precio){
        this.precio = precio;
    }

    
    public int calcularTiempoLectura(int paginasPorMinuto){
        return paginas/paginasPorMinuto;
    }

}
