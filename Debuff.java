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

public class Debuff {
    //state
   private  int debuffPos;

   //constructor
   public Debuff(int debuffPos) {
    this.debuffPos = debuffPos;
   }

   //setter method
    void setDebuffPos(int debuffPos) {
    this.debuffPos = debuffPos;
   }

   //getter method
   int getDebuffPos(){
    return this.debuffPos;
   }

}
