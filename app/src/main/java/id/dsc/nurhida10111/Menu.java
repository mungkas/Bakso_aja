package id.dsc.nurhida10111;

/**
 * Created by athaya on 19/04/18.
 */

public class Menu {
    private String id;
    private String nama;
    private String harga;

    public Menu(){

    }

    public Menu(String id, String nama, String harga){
        this.id=id;
        this.nama=nama;
        this.harga=harga;
    }

    public String getId(){ return id;}
    public  void setId(String id){ this.id=id;}
    public  String getNama(){ return nama;}
    public void setNama(String nama){ this.nama=nama;}
    public String getHarga(){ return harga;}
    public void setHarga(String harga){ this.harga=harga;}
}