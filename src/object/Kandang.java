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
public class Kandang {
    public int kapasitas;
    private int rumput;
    private int biji_bijian;
    private int makan_rumput;
    private int makan_biji;
    private int isi_kandang;
//    Hewan[] ternak = new Hewan[kapasitas];
    private final Hewan ternak[];
    public Kandang() {
        this.isi_kandang = 0;
        this.kapasitas = 4;
        this.rumput = 0;
        this.biji_bijian = 0;
        this.makan_rumput = 0;
        this.makan_biji = 0;
        ternak = new Hewan[kapasitas];
    }
    
    public void tambahHewan(Hewan obj){
        if ( isi_kandang == kapasitas ) {
            Util.printPesan("Kandang Penuh!");
        }
        for( int i = 0; i < kapasitas; i++ ){
            if( ternak[i] == null ){
                ternak[i] = obj;
                Util.print("Menambahkan %s ternak pada posisi %d!", ternak[i].getNama(), i);
                break;
            }
        }
        isi_kandang++;
    }
    public Hewan hapusHewan(int index){
        if ( isi_kandang == 0 ) {
            Util.printPesan("Kandang kosong");
        } 
        
        if ( !cekIndex(index) ) {
            Util.printPesan("Index tidak ditemukan!");
        }
        
        Hewan removed = ternak[index];
        ternak[index] = null;
        isi_kandang--;
        return removed;
    }
    public boolean cekIndex( int index ){
        return ternak[index] != null;
    }
    public String getDewasaTernak( int index ){
        return ternak[index].getDewasa();
    }
    public String getNamaTernak( int index ){
        return ternak[index].getNama();
    }
    public void jumlahHewanUnggas (){
        int ayam = 0;
        int angsa = 0;
        for( int i = 0; i < ternak.length; i++ ){
            if(this.cekIndex(i)){
                if(ternak[i].getNama().equals("ayam")){
                    ayam++;
                }else if(ternak[i].getNama().equals("angsa")){
                    angsa++;
                }
            }
        }
        Util.pop("Angsa "+angsa +"ekor");
        Util.pop("Ayam "+ayam +"ekor");
    }
    public int jumlahHewanUnggas(boolean gabung){
        int unggass = 0;
        for( int i = 0; i < ternak.length; i++ ){
            if(this.cekIndex(i)){
                if(ternak[i].getNama().equals("ayam") || ternak[i].getNama().equals("angsa")){
                    unggass++;
                }
            }
        }
        return unggass;
    }
    public void jumlahHewanMamalia (){
        int kambing = 0;
        int sapi = 0;
        for( int i = 0; i < ternak.length; i++ ){
            if(this.cekIndex(i)){
                if(ternak[i].getNama().equals("kambing")){
                    kambing++;
                }else if(ternak[i].getNama().equals("sapi")){
                    sapi++;
                }
            }
        }
        Util.pop("Sapi "+sapi +"ekor");
        Util.pop("Kambing "+kambing +"ekor");
    }
    public int jumlahHewanMamalia(boolean gabung){
        int mamals = 0;
        for( int i = 0; i < ternak.length; i++ ){
            if(this.cekIndex(i)){
                if(ternak[i].getNama().equals("kambing") || ternak[i].getNama().equals("sapi")){
                    mamals++;
                }
            }
        }
        return mamals;
    }
    public void jumlahTotalHewan (){
        Util.pop("Kandang berisi "+this.getIsiKandang() +"hewan");
    }
    public void bukaKandang(Pekerja p){
        Util.printHeader("Kandang");
        tampilkanTernakSemua();
        jumlahHewanMamalia();
        jumlahHewanUnggas();
        System.out.println("Kapasitas: "+this.getIsiKandang() +"/"+ this.getKapasitas());
    }
    public void tampilkanTernakSemua(){
        for( int i = 0; i < ternak.length; i++ ){
            if(this.cekIndex(i)){
                Util.printInBox(i+1 +".   "+ternak[i].getNama() + " " + ternak[i].getjenisKelamin() + " " + ternak[i].getBerat() + "Kg " + ternak[i].masaHidup + " " + ternak[i].getDewasa());
            }
        }
    }
    public int getRumput (){
        return this.rumput;
    }
    public void setRumput (int value){
        this.rumput = value;
    }
    public int getBiji (){
        return this.biji_bijian;
    }
    public void setBiji (int value){
        this.biji_bijian = value;
    }
    
    public int getRumputMakan (){
        return this.makan_rumput;
    }
    public void setRumputMakan (int value){
        this.makan_rumput = value;
    }
    public int getBijiMakan (){
        return this.makan_biji;
    }
    public void setBijiMakan (int value){
        this.makan_biji = value;
    }
    public void tambahKandang (){
        this.kapasitas +=2;
    }
    public int getKapasitas (){
        return this.kapasitas;
    }
    public int getIsiKandang (){
        return this.isi_kandang;
    }
    public void gantiHari(){
        setRumputMakan(this.getRumputMakan() - this.jumlahHewanMamalia(true)*10);
        if(this.getRumputMakan()<=0){
            this.setRumputMakan(0);
            for( int i = 0; i < ternak.length; i++ ){
                if(this.cekIndex(i)){
                    if(ternak[i].getNama().equals("sapi") || ternak[i].getNama().equals("kambing")){
                        ternak[i].setStatus(false);
                        this.hapusHewan(i);
                        System.out.println("X Ternak "+ i +" mati kelaparanX");
                    }
                }
            }
        }else{
            for( int i = 0; i < ternak.length; i++ ){
                if(this.cekIndex(i)){
                    if(ternak[i].getNama().equals("sapi") || ternak[i].getNama().equals("kambing")){
                        ternak[i].setMasaHidup(ternak[i].getMasaHidup()+1);
                    }
                }
            }
        }
        setBijiMakan(this.getBijiMakan() - this.jumlahHewanUnggas(true)*5);
        if(this.getBijiMakan()<=0){
            this.setBijiMakan(0);
            for( int i = 0; i < ternak.length; i++ ){
                if(this.cekIndex(i)){
                    if(ternak[i].getNama().equals("ayam") || ternak[i].getNama().equals("angsa")){
                        ternak[i].setStatus(false);
                        this.hapusHewan(i);
                        System.out.println("X Ternak "+ i +" mati kelaparanX");
                    }
                }
            }
        }else{
            for( int i = 0; i < ternak.length; i++ ){
                if(this.cekIndex(i)){
                    if(ternak[i].getNama().equals("ayam") || ternak[i].getNama().equals("angsa")){
                        ternak[i].setMasaHidup(ternak[i].getMasaHidup()+1);
                    }
                }
            }
        }
    }
}
