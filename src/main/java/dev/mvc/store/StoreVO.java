package dev.mvc.store;

public class StoreVO {
    private int storeno;
    private String name;
    private String adress;
    private int lat;
    private int lng;
    private String rdate;
    private String visible;
    public int getStoreno() {
        return storeno;
    }
    public void setStoreno(int storeno) {
        this.storeno = storeno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public int getLat() {
        return lat;
    }
    public void setLat(int lat) {
        this.lat = lat;
    }
    public int getLng() {
        return lng;
    }
    public void setLng(int lng) {
        this.lng = lng;
    }
    public String getRdate() {
        return rdate;
    }
    public void setRdate(String rdate) {
        this.rdate = rdate;
    }
    public String getVisible() {
        return visible;
    }
    public void setVisible(String visible) {
        this.visible = visible;
    }
    
    
}
