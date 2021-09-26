package com.example.retoindividual.recicladores;

public class RecyclerData
{
    private String titulo;
    private String img;

    public RecyclerData(String titulo, String img)
    {
        this.titulo = titulo;
        this.img = img;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitle(String titulo)
    {
        this.titulo = titulo;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }
}
