/**
 * -----------------------------------------------------
 * ES234211 - Programming Fundamental
 * Genap - 2023/2024
 * Group Capstone Project: Snake and Ladder Game
 * -----------------------------------------------------
 * Class    : Q
 * Group    : 4
 * Members  :
 * 1. 5026231002 - Aisya Candra Kirana Dewi
 * 2. 5026231056 - Balindra Adisakti
 * 3. 5026231061 - Devika Rahman
 * ------------------------------------------------------
 */

public class Buff {
    //state
    private int buffPos;

    //constructor
    public Buff(int buffPos){
        this.buffPos = buffPos;
    }

    //setter method
    public void setBuffPos(int buffPos){
        this.buffPos = buffPos;
    }
    
    //getter method
    int getBuffPos(){
        return this.buffPos;
    }
}
