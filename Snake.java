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

public class Snake{
    int head;
    int tail;
    
    Snake(int head, int tail){
        this.head = head;
        this.tail = tail;
    }
    
    void setTail(int tail){
        this.tail = tail;
    }
    void setHead(int head){
        this.head = head;
    }
    int getTail(){
        return this.tail;
    }
    int getHead(){
        return this.head;
    }
}