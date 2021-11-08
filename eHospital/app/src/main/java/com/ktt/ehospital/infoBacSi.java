package com.ktt.ehospital;

public class infoBacSi {
    private String name;
    private String hocvi;
    private String knghiem;
    private String price;
    private int img;

    public infoBacSi(String name, String hocvi, String knghiem, String price, int img) {
        this.name = name;
        this.hocvi = hocvi;
        this.knghiem = knghiem;
        this.price = price;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHocvi() {
        return hocvi;
    }

    public void setHocvi(String hocvi) {
        this.hocvi = hocvi;
    }

    public String getKnghiem() {
        return knghiem;
    }

    public void setKnghiem(String knghiem) {
        this.knghiem = knghiem;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
