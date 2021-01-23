/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import event.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author Darkun7
 */
public class Toko {
    Scanner in = new Scanner (System.in);
    private final HashMap<String, Integer> hargaBeli;
    private final HashMap<String, Integer> hargaJual;
    String[] mamalia = new String[]{"sapi", "kerbau"};
    String[] unggas = new String[]{"ayam", "angsa"};
    String[] pakan = new String[]{"A", "B", "C"};
    public Toko(){
        this.hargaBeli = new HashMap<>();
        this.hargaJual = new HashMap<>();
        hargaBeli.put("rumput",100);
        hargaBeli.put("biji-bijian", 25);
        hargaBeli.put("pekerja",500);
        hargaBeli.put("sapi", 1000);
        hargaBeli.put("kerbau", 500);
        hargaBeli.put("angsa", 100);
        hargaBeli.put("ayam", 50);
        hargaBeli.put("kandang", 15000);
        hargaJual.put("sapi", 5000);
        hargaJual.put("kerbau", 2500);
        hargaJual.put("angsa", 300);
        hargaJual.put("ayam", 150);
    }
    public void membeli(Player p, Kandang k, Pekerja w, String obj,int amount){
        Integer price = hargaBeli.get(obj);
        if(p.getUang()<price){
            Util.print("Coin anda kurang!");
        }else{
            for(int i=1; i<=amount; i++){
                int rand = Util.Random(5, 10);
                if(k.getIsiKandang()<k.getKapasitas()){
                    List<String> mamals = Arrays.asList(mamalia);
                    List<String> unggs = Arrays.asList(unggas);
                    List<String> pakn = Arrays.asList(pakan);
                    boolean gender;
                    if(rand%2==1){
                        gender = true;
                    }else{
                        gender = false;
                    }
                    if(mamals.contains(obj)){
                        Hewan obj_baru = new Mamalia(obj, gender, 1, "rumput", rand) {};
                        k.tambahHewan(obj_baru);
                    } else if (unggs.contains(obj)){
                        Hewan obj_baru = new Unggas(obj, gender, 1, "biji-bijian", rand/2) {};
                        k.tambahHewan(obj_baru);
                    } else if (pakn.contains(obj)){
                        if("rumput".equals(obj)){
                            k.setRumput(k.getRumput()+100);
                        }else{
                            k.setBiji(k.getBiji()+100);
                        }
                    } else if("kandang".equals(obj)){
                        k.tambahKandang();
                    }else if ("pekerja".equals(obj)){
                        w.setJumlah(w.getJumlah()+1);
                    }
                    p.kurangiUang(price);
                }else{
                    Util.printPesan("Kapasitas kandang penuh.");
                }
            }
        }
    }
    
    public void menjual(Player p, Kandang k, String obj){
        int res;
        Util.printHeader("Menjual Ternak");
        k.tampilkanTernakSemua();
        Util.pop("Pilih angka ternak yang akan dijual.");
        Util.pop("0. Kembali");
        Util.printSeparator("Perintah: ");
        res = in.nextInt();
        if(res > 0){
            String spesies = k.getNamaTernak(res-1);
            Integer price = hargaBeli.get(spesies);
            if("Anak-anak".equals(k.getDewasaTernak(res-1))){
                price = price/2;
            }
            k.hapusHewan(res-1);
            p.tambahUang(price);
        }
    }
    
    public void bukaToko(Player p, Kandang k, Pekerja w){
        int open = 1;
        String mode = "Beli";
        while(open == 1){
            Util.printHeader("Toko (" + mode + ")");
            System.out.println("-> Coin: " + p.getUang());
            String res;
            if ("Beli".equals(mode) ){
                hargaBeli.entrySet().forEach(entry->{
                System.out.println( entry.getKey() + " : " + entry.getValue()+ " Coin");
                });
                Util.pop("Ketik nama produk untuk membeli. contoh: 'Ayam'");
                Util.pop("Ketik: '2' untuk menjual produk");  
            }else{
                hargaJual.entrySet().forEach(entry->{
                System.out.println( entry.getKey() + " : " + entry.getValue()+ " Coin");
                });
                Util.pop("Ketik 'ok' untuk mulai menjual.");
                Util.pop("Ketik: '1' untuk membeli produk");  
            }
            Util.pop("Ketik: '0' untuk kembali.");
            Util.printSeparator("Perintah:");
            res = in.nextLine();
            if("1".equals(res)){
                mode = "Beli";
            }else if("2".equals(res)){
                mode = "Jual";
            }else if("0".equals(res)){
                open = 0;
            }else{
                
                int nominal;
                if("Beli".equals(mode) && hargaBeli.containsKey(res)){
                    System.out.println("sebanyak: ");
                    nominal = in.nextInt();
                    Util.clearConsole();
                    this.membeli(p, k, w, res, nominal); 
                }else if ("Jual".equals(mode) && "ok".equals(res)){
                    Util.clearConsole();
                    this.menjual(p, k, res);
                }
            }
        }
         
    }
    
    
}