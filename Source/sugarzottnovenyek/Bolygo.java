/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sugarzottnovenyek;

import java.util.ArrayList;
import java.math.*;
import java.util.Iterator;

/**
 *
 * @author Rimóczi Loránd EOH12I
 */
public class Bolygo {
    private ArrayList<Noveny> novenyek;
    private int sugarzas = 0; //0 semleges, -1 alfa, 1 delta
    
    public Bolygo() {
        novenyek = new ArrayList<>();
    }
    
    public Bolygo(ArrayList<Noveny> novenyek) {
        this.novenyek = new ArrayList<>(novenyek);
    }
    
    public void setSugarzas(int a) {
        this.sugarzas = a;
    }
    
    public int getSugarzas() {
        return this.sugarzas;
    }
    
    //Egy teljes nap "szimulálása", étel változás, sugárzási igény a következő napra
    //Fontos, elsőnek élet vizsgálat a sugárzás függvényében, utána járulhat hozzá a sugárzás módosításához
    public void nextDay() {
        int aktSugarzas = this.getSugarzas();
        //Minden nap megjeleníti, mely növények éltek túl eddig (reggelre)
        System.out.println("Előző napot túlélők:");
        novenyek.forEach(nov -> {
            switch(nov.getType()){
                    case 'a':
                        nov.novenyKiir();
                        break;
                    case 'd':
                        nov.novenyKiir();
                        break;
                    case 'p':
                        nov.novenyKiir();
                        break;
            }
        });
        
        System.out.println(); //üres sor a kinézet miatt
        System.out.print("Napi sugárzás: "); //sima print, hogy egysorba kerüljön vele a sugárzás neve
        switch(aktSugarzas){
            case -1:
                System.out.println("alfa.");
                break;
            case 0:
                System.out.println("semleges.");
                break;
            case 1:
                System.out.println("delta.");
                break;
        }
        
        //ételmennyiságek módosítása, élet vizsgálat,
        //illetve élő növény esetén a következő napi sugárzásra való igény gyűjtése
        int alfaIgeny = 0;
        int deltaIgeny = 0;
        Iterator<Noveny> itr = novenyek.iterator();
        //for(Noveny nov : novenyek){ //for ciklus a változók miatt
        while(itr.hasNext()){
            Noveny nov = itr.next(); //while iterátorban
            switch(nov.getType()){
                    case 'a': //puffancs: alfa esetén +2, delta esetén -2, semleges esetén -1
                        switch (aktSugarzas) {
                            case 0: //semleges
                                nov.setFood(nov.getFood() - 1);
                                break;
                            case 1: //delta
                                nov.setFood(nov.getFood() - 2);
                                break;
                            default: //alfa
                                nov.setFood(nov.getFood() + 2);
                                break;
                        }
                        
                        //0 vagy kevesebb, valamint 10 feletti tápmennyiségnél elpusztul
                        if(nov.getFood() <= 0){
                            //iterátor remove() függvényével lehet iterálás közben elemet törölni
                            itr.remove();
                        }
                        else if(nov.getFood() > 10){
                            itr.remove();
                        }
                        else{ //életben maradás esetén következő napi befolyás
                            alfaIgeny += 10;
                        }
                        
                        break;

                    case 'd': //deltafa: alfa esetén -3, delta esetén +4, semleges esetén -1
                        switch (aktSugarzas) {
                            case 0: //semleges
                                nov.setFood(nov.getFood() - 1);
                                break;
                            case 1: //delta
                                nov.setFood(nov.getFood() + 4);
                                break;
                            default: //alfa
                                nov.setFood(nov.getFood() - 3);
                                break;
                        }
                        
                        if(nov.getFood() <= 0){
                            itr.remove();
                        }
                        else{ //életben maradás esetén következő napi befolyás
                            if(nov.getFood() < 5){
                                deltaIgeny += 4;
                            }
                            else if(nov.getFood() <= 10){
                                deltaIgeny += 1;
                            }
                        } 
                        break;
                        
                    case 'p': //parabokor: alfa esetén +1, delta esetén +1, semleges esetén -1
                        switch (aktSugarzas) {
                            case 0: //semleges
                                nov.setFood(nov.getFood() - 1);
                                break;
                            case 1: //delta
                                nov.setFood(nov.getFood() + 1);
                                break;
                            default: //alfa
                                nov.setFood(nov.getFood() + 1);
                                break;
                        }
                        
                        //sugárzást nem befolyásol
                        if(nov.getFood() <= 0){
                            itr.remove();
                        }
            }
        }
        
        //sugárzás beállítása az igányek alapján következő napra
        if(Math.abs(alfaIgeny - deltaIgeny) < 3){
            this.setSugarzas(0);
        }
        else if (alfaIgeny > deltaIgeny + 3){
            this.setSugarzas(-1);
        }
        else{
            this.setSugarzas(1);
        }
        
        //a nap végi túlélők
        System.out.println(); //üres sor a kinézet miatt
        System.out.println("A nap túlélői:");
        novenyek.forEach(nov -> {
            switch(nov.getType()){
                case 'a':
                    nov.novenyKiir();
                    break;
                case 'd':
                    nov.novenyKiir();
                    break;
                case 'p':
                    nov.novenyKiir();
                    break;
            }
        });
    }
}
