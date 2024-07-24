/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sugarzottnovenyek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rimóczi Loránd EOH12I
 */
public class Olvaso {
    static int beolvas(ArrayList<Noveny> novenyBe, String inFile) throws IOException {
        int novenyDb = 0;
        int napok = 0;
        int food = 0;
        try{
            try (Scanner scanner = new Scanner(new File(inFile))) {
                novenyDb = scanner.nextInt();  //első int-et olvasása, ami megadja, hány növény lesz
                for(int i = 0; i < novenyDb; i++){
                    String name = scanner.next();
                    char tipus = scanner.next().charAt(0); //karakter beolvasása
                    food = scanner.nextInt();
                    switch(tipus){
                        case 'a':
                            Puffancs puffancs = new Puffancs(name, food);
                            novenyBe.add(puffancs);
                            break;
                        case 'd':
                            Deltafa deltafa = new Deltafa(name, food);
                            novenyBe.add(deltafa);
                            break;
                        case 'p':
                            Parabokor parabokor = new Parabokor(name, food);
                            novenyBe.add(parabokor);
                            break;
                    }
                    //Teszt kiírás beolvasott soronként
                    //System.out.println("Beolvasva " + i + " index adatsor."); //tesztelés
                }
                napok = scanner.nextInt(); //napok számának beolvasása a fájl végén
                
                //Összesen olvasott sorok száma, teszt kiírás
                //System.out.println("Beolvasva osszesen: " + novenyDb + " adatsor."); //tesztelés
                
                //Tesztkiírás, a beolvasott adatok kiírása
                /*System.out.println("Teszt kiirasa az adaatoknak:");
                novenyBe.forEach(nov -> {
                    nov.novenyKiir();
                });*/
            }
        }catch(FileNotFoundException e){
            System.out.println("Fájl nem található.");
        }catch(NumberFormatException s){
            System.out.println("Hibás adat a fájlban, sikertelen konvertálás.");
        }
        return napok;
    }
}
