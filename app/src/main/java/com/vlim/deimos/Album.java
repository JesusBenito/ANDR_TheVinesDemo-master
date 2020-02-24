package com.vlim.deimos;

public class Album {
    public String title;
    public int fondo;
    public int botella;
    public int contenido;
    public String ubicacion;
    public int bandera;




    public Album(String title, int fondo, int botella, int contenido, String ubicacion,int bandera) {
        this.title = title;
        this.fondo = fondo;
        this.botella = botella;
        this.contenido = contenido;
        this.ubicacion = ubicacion;
        this.bandera = bandera;

    }



    public  String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public int getBotella() {
        return botella;
    }

    public void setBotella(int botella) {
        this.botella = botella;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public String getUbicacion(){return ubicacion; }

    public void setUbicacion(String ubicacion){this.ubicacion=ubicacion; }


    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
}
