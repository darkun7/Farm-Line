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
public class Unggas extends Hewan {
    private ArrayList<String> yangDiMakan; 
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
    public Unggas(String nama, boolean jenisKelamin, int masaHidup, String tipeMakanan, int berat){
        super(nama, jenisKelamin, masaHidup, tipeMakanan, 1);
        this.jumlahKaki = 2;
        this.yangDiMakan = new ArrayList<>();
    }
    public void bersuara(){
        System.out.println("Moh...");
    }
    public void tidur(){
        System.out.println("zZzZ");
    }
    public void potong(){
        System.out.println("x_x");
    }
    
    
}