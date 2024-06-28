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

public class Ladder{
    int fromPosition;
    int toPosition;
    
    Ladder(int from, int to){
        this.fromPosition = from;
        this.toPosition = to;
    }
    
    void setFromPosition(int from){
        this.fromPosition =  from;
        
    }
    
    void setToPosition(int to){
        this.toPosition = to;
        
    }
    
    int getFromPosition(){
        return fromPosition;
        
    }
    int getToPosition(){
        return toPosition;
    
    }
}