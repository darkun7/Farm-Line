/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import event.Util;
import object.*;
import event.Event;
/**
 *
 * @author msi
 */
public class Main {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String res;
        Scanner in = new Scanner (System.in);
        boolean play = true;
        //Pembelian Ternak Awal
        Event event = new Event();
        Pekerja pekerja = new Pekerja();
        Player pyr = new Player(event.startGame(), 1000);
        Toko toko = new Toko();
        Kandang kandang = new Kandang();
        toko.bukaToko(pyr, kandang, pekerja);
        while(play){
            event.menuPeternakan(pyr, pekerja);
            Util.printSeparator("Perintah:");
            res = in.nextLine();
            if(null!=res)switch (res) {
                case "1":
                    pekerja.bukaPekerja(pyr, kandang);
                    break;
                case "2":
                    kandang.bukaKandang(pekerja);
                    break;
                case "3":
                    toko.bukaToko(pyr, kandang, pekerja);
                    break;
                case "4":
                    pekerja.skipHari(pyr,kandang);
                    break;
            }
        }
    }
    
}
