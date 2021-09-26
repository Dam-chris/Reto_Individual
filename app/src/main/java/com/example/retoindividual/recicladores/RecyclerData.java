package com.example.retoindividual.recicladores;

public class RecyclerData
{
    private String title;
    private String imgid;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getImgid()
    {
        return imgid;
    }

    public void setImgid(String imgid)
    {
        this.imgid = imgid;
    }

    public RecyclerData(String title, String imgid)
    {
        this.title = title;
        this.imgid = imgid;
    }
}
