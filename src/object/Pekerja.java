/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import event.Util;
import java.util.Scanner;

/**
 *
 * @author Darkun7
 */
public class Pekerja {
    Scanner in = new Scanner (System.in);
    String res;
    protected int jumlah;
    private int aksi;
    public Pekerja(){
        this.jumlah = 1;
        this.aksi = 2;
    }
    public int getJumlah(){
        return this.jumlah;
    }
    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }
    public void resetAksi(){
        this.aksi = this.getJumlah()+this.getJumlah();
    }
    public int getAksi(){
        return this.aksi;
    }
    public void useAksi(){
        this.aksi--;
    }
//    Behaviour
    public void bukaPekerja(Player p,Kandang k){
        int open = 1;
        while(open == 1){
        Util.printHeader("Aksi");
        Util.pop("1. Beri makan");
        Util.pop("2. Potong");
        Util.pop("0. Kembali");
        Util.printSeparator("Perintah:");
            res = in.nextLine();
            if("1".equals(res)){
                memberiMakan(p, k);
            }else if("2".equals(res)){
                memotong(p, k);
            }else if("3".equals(res)){
                open = 0;
            }
        }
    }
    public void memberiMakan(Player p, Kandang k){
        int open = 1;
        while(open == 1){
            if(aksi>=1){
                int biji = k.getBiji();
                int rumput = k.getRumput();
                Util.printHeader("Beri Makan");
                System.out.println("-> Biji-bijian di Gudang: " + biji+"| Biji-bijian di Kandang: "+k.getBijiMakan());
                System.out.println("-> Rumput di Gudang: " + rumput+"| Rumput di Kandang: "+k.getRumputMakan());
                Util.pop("1. Beri makan biji-bijian");
                Util.pop("2. Beri makan rumput");
                Util.pop("0. Kembali");
                Util.printSeparator("Perintah:");
                res = in.nextLine();
                if("1".equals(res)){
                    if(biji>=50){
                        k.setBiji(k.getBiji()-50);
                        k.setBijiMakan(k.getBijiMakan()+50);
                        Util.pop("sebanyak 50 sudah diberikan sebagai pakan.");
                        this.useAksi();
                    }else{
                        Util.printPesan("Stok biji di gudang kurang!");
                    }
                }else if("2".equals(res)){
                    if(rumput>=50){
                        k.setRumput(k.getBiji()-50);
                        k.setRumputMakan(k.getRumputMakan()+50);
                        Util.pop("sebanyak 50 sudah diberikan sebagai pakan.");
                        this.useAksi();
                    }else{
                        Util.printPesan("Stok rumput di gudang kurang!");
                    }
                }else if("3".equals(res)){
                    open = 0;
                }
            }else{
                this.skipHari(p,k);
            }
        }
    }
    public void skipHari(Player p, Kandang k){
        p.setHari(p.getHari()+1);
        this.resetAksi();
        Util.printSeparator("Memasuki Hari ke-"+p.getHari());
        k.gantiHari();
    }
    public void memotong(Player p, Kandang k){
        if(aksi>=1){
            Util.printHeader("Memotong");
            k.tampilkanTernakSemua();
            Util.pop("Pilih angka ternak yang akan dijual.");
            Util.pop("0. Kembali");
            Util.printSeparator("Perintah: ");
            int rex = in.nextInt();
            if(rex > 0){
                String spesies = k.getNamaTernak(rex-1);
                p.tambahUang(Util.Random(20, 75));
                k.hapusHewan(rex-1);
                }
            }else{
                this.skipHari(p, k);
            }
        }
    
}
