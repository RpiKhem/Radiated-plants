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
public class Parabokor extends Noveny {
    public Parabokor(String name, int food){
        this.setName(name);
        this.setFood(food);
        this.setType('p');
    }
}
