package models;

public class Libro {
    private String title;
    private String editorial;
    private String autor;
    private int fechaPub;

    public Libro(String title, String editorial, String autor, int fechaPub) {
        this.title = title;
        this.editorial = editorial;
        this.autor = autor;
        this.fechaPub = fechaPub;
    }

    public String getTitle() {
        return title;
    }

    public String titulos(){

        return "Titulo: " + title;
    }


}
