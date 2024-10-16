package modelo;

import com.coti.tools.Esdia;

public class Libros {
    private String titulo;
    private int añoPublicacion;
    private Autor autor;
    private int paginas;
    private int tiempoLecturaMinutos;
    private float precio;

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

    public int getTiempoLecturaMinutos(){
        return tiempoLecturaMinutos;
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

    public void setTiempoLecturaMinutos(){
        this.tiempoLecturaMinutos = Esdia.readInt("Introduzca el tiempo de lectura en minutos del libro: \n");
    }

    public void setPrecio(float precio){
        this.precio = precio;
    }
}
