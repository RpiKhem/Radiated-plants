/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sugarzottnovenyek;

/**
 *
 * @author Rimóczi Loránd EOH12I
 */
abstract public class Noveny {
    private String name;
    private int food;
    private char type;
    
    final public void setName(String name){
        this.name = name;
    }
    
    final public void setFood(int food) {
        this.food = food;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getFood() {
        return this.food;
    }
    
    final public void setType(char c) {
        this.type = c;
    }
    
    public char getType() {
        return this.type;
    }
    
    public void novenyKiir() {
        switch(this.getType()){
            case 'a':
                System.out.println(this.getName() + " puffancs, táp mennyisége: " + this.getFood());
                break;
            case 'd':
                System.out.println(this.getName() + " deltafa, táp mennyisége: " + this.getFood());
                break;
            case 'p':
                System.out.println(this.getName() + " parabokor, táp mennyisége: " + this.getFood());
                break;
        }
    }
}
