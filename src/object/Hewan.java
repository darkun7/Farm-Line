/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import event.Util;

/**
 *
 * @author Darkun7
 */
public abstract class Hewan {
    
    protected String nama;
    protected boolean jenisKelamin;
    protected int masaHidup;
    protected String tipeMakanan;
    protected int kebutuhanMakan;
    protected int berat;
    protected boolean dewasa;
    protected boolean status;
    

    public Hewan(String nama, boolean jenisKelamin, int masaHidup, String tipeMakanan, int berat){
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.masaHidup = 1;
        this.tipeMakanan = tipeMakanan;
        this.kebutuhanMakan = 100;
        this.berat = berat;
        this.dewasa = false;
        this.status = true;
        
    }
    public String getNama(){
        return this.nama;
    }
    public String getjenisKelamin(){
        if(this.jenisKelamin){
            return "Jantan";
        } else {
            return "Betina";
        }
    }
    public int getMasaHidup(){
        return this.masaHidup;
    }
    public void setMasaHidup(int masaHidup){
        this.masaHidup=masaHidup;
        this.setBerat(this.getBerat()+Util.Random(5, 10));
        if(this.masaHidup>4){
            this.dewasa = true;
            System.out.println(this.nama+" telah menjadi dewasa");
        }
    }
    public String getTipeMakanan(){
        return this.tipeMakanan;
    }
    public int getKebutuhanMakan(){
        return this.kebutuhanMakan;
    }
    public void setKebutuhanMakan(int kebutuhanMakan){
        this.kebutuhanMakan = kebutuhanMakan;
    }
    public int getBerat(){
        return this.berat;
    }
    public void setBerat(int berat){
        this.berat = berat;
    }
    public String getDewasa(){
        if(this.dewasa){
            return "Dewasa";
        } else {
            return "Anak-anak";
        }
    }
    public String getStatus(){
        if(this.status){
            return "hidup";
        } else {
            return "mati";
        }
    }
    public void setStatus(boolean status){
        this.status = status;
    }
//    Behaviour
    public void cekStatus(){
        System.out.println("Hewan " + nama + " dalam keadaan " + this.getStatus());
    }
    public void makan(){}
    public void tumbuh(){}
}
