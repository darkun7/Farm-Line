/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

public class Player {
    protected String nama;
    protected int uang;
    protected int hari;
    
    public Player (String nama, int uang){
        this.hari = 1;
        this.uang = uang;
    }
    public String getNama(){
        return this.nama;
    }
    public void setNama(String namaBaru){
        String namaLama = this.nama;
        this.nama = namaBaru;
        System.out.println("Nama "+namaLama+" sudah diubah menjadi "+namaBaru);
    }    
    public int getHari(){
        return this.hari;
    }
    public void setHari(int hari){
        this.hari = hari;
    }
    public int getUang(){
        return this.uang;
    }
    public void setUang(int uang){
        this.uang = uang;
    }
//    Behaviour
    public void tambahUang(int uang){
        this.uang = this.getUang()+uang;
    }
    public void kurangiUang(int uang){
        if(uang>0){
            this.uang = this.getUang()-uang;
        }else{
            System.out.println("Transaksi bermasalah");
        }        
    }
    public void tambahHari (){
        this.hari += 1;
    }
}
