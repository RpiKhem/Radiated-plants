/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sugarzottnovenyek;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static sugarzottnovenyek.Olvaso.beolvas;

/**
 *
 * @author Rimóczi Loránd EOH12I
 */
public class SugarzottNovenyek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //lista, amiben a növények lesznek, ez alapján készül bolygó
        ArrayList<Noveny> beolvasArray = new ArrayList<Noveny>();
        
        //adatok beolvasása, valamint napok számának lekérése, hogy meddig fusson a szimuláció
        Scanner in = new Scanner(System.in);
        String inFile = in.nextLine();
        int napok = beolvas(beolvasArray, inFile);
        
        //Teszt kiírás, napok számának ellenőrzéséhez
        //System.out.println("Teszt, napok szama: " + napok);
        
        //egy bolygó példányosítása, a beolvasott növény adatokkal
        Bolygo minta = new Bolygo(beolvasArray);
        
        //for ciklus napszámszor a bolygó next() metódusával, így szimulálva a napok teltét
        for(int i = 0; i < napok; i++){
            System.out.println(); //üres sor kinézet miatt
            System.out.println(i + 1  + ". nap:"); //aktuális nap száma, ciklusváltozó 0-val kezd
            minta.nextDay();
        }
    }
}
