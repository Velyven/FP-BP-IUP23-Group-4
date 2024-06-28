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

public class Player{
    //states
    private String name;
    private int position;
    private int bcard = 0; //buff card
    private int dcard = 0; //debuff card

    
    //constructor method
    public Player (String name){
        this.name = name;
    }

    //setter methods
    public void setName (String name){
      this.name=name;
    }
    
    public void setPosition(int position){
      this.position = position;
    }

    public void setBuffCard(int bcard){
        this.bcard = bcard;
    }    

    public void setDebufCard(int dcard){
        this.dcard = dcard;
    }
    
    //getter methods
    public String getName() {
        return this.name;
    }
    
    public int getPosition() {
        return this.position;
    }

    public int addBuffCard(){
        return bcard++;
    }

    public int addDebuffCard(){
        return dcard++;
    }

    public int deductBuffCard(){
        return bcard--;
    }

    public int deductDebuffCard(){
        return dcard--;
    }

    public int getBuffCard(){
        return bcard;
    }

    public int getDebuffCard(){
        return dcard;
    }
    
    //another method
    public int rollDice()
    {
        return (int)((Math.random()*6)+1);
    }
    
    public void moveAround(int x, int boardSize)
    {
        if (this.position + x > boardSize){
          this.position = (boardSize - this.position) + (boardSize - x); 
        }
        else {
            this.position = this.position + x;
           
        }
    }


    


}