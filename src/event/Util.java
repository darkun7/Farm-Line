/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

/**
 *
 * @author msi
 */
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public final class Util {
    
    public static final void print(String msg, Object... args){
        System.out.printf( "[Farm Line] " + msg + "\n", args );
    }
    

    
    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    
    public static void printInBox(String msg, Object... args) {
        String border = "";
        StringBuilder sbborder = new StringBuilder(border);
        for( int i = 0; i < msg.length(); i++ )
            sbborder.append("|");
        
        for( Object ob : args ) {
            String str;
            try {
                str = (String)ob;
            }catch(ClassCastException ex) {
                str = Integer.toString((Integer)ob);
            }
            for( int i = 0; i < str.length(); i++ )
                sbborder.append("|");
        }
        border = sbborder.toString();
        System.out.println("||"+border+"||");
        System.out.printf("||| " + msg + " |||\n", args);
        System.out.println("||"+border+"||");
    }
    
    public static final void pop( String msg ){
        System.out.println(">" + msg );
    }
    
    public static final void printPesan( String msg ){
        System.out.println("<<< [" + msg + "] >>>");
    }
    
    public static final void printHeader( String msg ){
        System.out.println("==================[" + msg + "]==================");
    }
    
    public static final void printSeparator( String msg ){
        System.out.println(">>>>>>>>>>>>>>> [" + msg + "] <<<<<<<<<<<<<<<<");
    }
    
    public static int Random(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
