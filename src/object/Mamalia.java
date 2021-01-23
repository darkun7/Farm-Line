/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.ArrayList;

/**
 *
 * @author Darkun7
 */
public class Mamalia extends Hewan{
    private final int jumlahKaki;
    /**
     *
     * @param nama
     * @param jenisKelamin
     * @param masaHidup
     * @param tipeMakanan
     * @param berat
     * @param nomorKandang
     */
    public Mamalia(String nama, boolean jenisKelamin, int masaHidup, String tipeMakanan, int berat){
        super(nama, jenisKelamin, masaHidup, tipeMakanan, 1);
        this.jumlahKaki = 4;
    }
    public void bersuara(){
        System.out.println("peck..peck..");
    }
    public void tidur(){
        System.out.println("zZzZ");
    }
    public void potong(){
        System.out.println("'^'");
    }
    
}
