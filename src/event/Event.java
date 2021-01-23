/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import object.Pekerja;
import object.Player;
import object.Toko;

/**
 *
 * @author msi
 */
public class Event {
    Scanner in = new Scanner (System.in);
    public String startGame(){
        System.out.println("Masukkan nama anda: ");
        String data = in.nextLine();
        //Player player = new Player(data,1000);
        Util.print("Data pemain berhasil dibuat!");
        return data;
    }
    public void menuPeternakan(Player p, Pekerja w){
        System.out.println("->Coin: "+p.getUang());
        System.out.println("->Pekerja aktif: "+w.getJumlah());
        System.out.println("->Aksi: "+w.getAksi()+"/"+w.getJumlah()*2);
        Util.printHeader("Peternakan");
        Util.pop("1. Aksi");
        Util.pop("2. Kandang");
        Util.pop("3. Toko");
        Util.pop("4. Skip Hari");
        
    }


    
    
}
