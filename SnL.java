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

 import java.util.ArrayList;
 import java.util.Scanner;
 
 public class SnL {
     
     //states, variable, or properties
     private int boardSize;
     private ArrayList<Player> players;
     private ArrayList<Snake> snakes;
     private ArrayList<Ladder> ladders;
     private ArrayList<Buff> buffs;
     private ArrayList<Debuff> debuffs;
     private int gameStatus;
     private int currentTurn;
 
     
     //constructor
     public SnL (int size){
         this.boardSize = size;
         this.snakes = new ArrayList<Snake>();
         this.ladders = new ArrayList<Ladder>();
         this.players= new ArrayList<Player>();
         this.buffs = new ArrayList<Buff>();
         this.debuffs = new ArrayList<Debuff>();
         this.gameStatus = 0;
         
     }
     
     public void initiateGame(){
         int [][] ladders = 
         {    {2, 23},
              {8, 34},
              {20, 77},
              {32, 68},
              {41, 79},
              {74, 88},
              {82, 100},
              {85, 95}
         };
         setLadders(ladders);

         int [][] snakes = 
         {    {47, 5},
              {29, 9},
              {38, 15},
              {97, 25},
              {53, 33},
              {92, 70},
              {86, 54},
              {97, 25}
         };
         setSnakes(snakes);
        
         //setting buff card, with this player gain immunity from snake one time
         int [] buffs = 
         {
            1,
            18, 
            26,
            50,
            85,
         };
         setBuffs(buffs);

        //setting debuff card, player gain immunity from ladder one time
         int [] debuffs = 
         {
            5,
            35,
            60,
            70,
            94,
         };
         setDebuffs(debuffs);

     }
     
     public Player getTurn() {
      if (this.gameStatus == 0) {
          double r = Math.random();
          if (r < 0.5){
              this.currentTurn = 0;
              return this.players.get(0); 
          }
          else {
              this.currentTurn = 1;
              return this.players.get(1);
          }
          
          
      }   
      else {
         if (currentTurn == 0) {
         this.currentTurn = 1;
         return this.players.get(1);  
         }
        
         else {
             this.currentTurn = 0;
             return this.players.get(0); }
      }
     }
     
     //setter methods
     public void setSizeBoard(int size){
         this.boardSize = size;
     }
     public void addPlayer(Player p){
         this.players.add(p);
     }

     public void setLadders(int[][] ladders){
         int s = ladders.length;
         for(int i = 0; i < s; i++){
             this.ladders.add(new Ladder(ladders[i][0],ladders[i][1]));
         }
     }
     
     public void setSnakes(int[][] snakes)
     {
         int s = snakes.length;
         for(int i = 0; i < s; i++){
             this.snakes.add(new Snake(snakes[i][0],snakes[i][1]));
         }
     }

     public void setBuffs(int[] buffs){
        int b = buffs.length;
        for(int i = 0; i < b; i++){
            this.buffs.add(new Buff(buffs[i]));
        }
     }

     public void setDebuffs(int[] debuffs){
        int b = debuffs.length;
        for(int i = 0; i < b; i++){
            this.debuffs.add(new Debuff(debuffs[i]));
        }
     }
     
     public int getBoardSize(){
         return this.boardSize;
     }
     public ArrayList<Player> getPlayers(){
         return this.players;
     }
     public ArrayList<Snake> getSnakes(){
         return this.snakes;
     }
     public ArrayList<Ladder> getLadders(){
         return this.ladders;
     }
     public ArrayList<Buff> getBuffs(){
        return this.buffs;
     }
     public ArrayList<Debuff> getDebuffs(){
        return this.debuffs;
     }

     
     public int getGameStatus(){
         return this.gameStatus;
     }
     public void play(){
         initiateGame();
         
         System.out.println("enter first player name:");
         Scanner sc= new Scanner(System.in);
         String firstPlayer= sc.nextLine();
         System.out.println("enter second player name:");
         String secondPlayer= sc.nextLine();
         Player p1 = new Player(firstPlayer);
         Player p2 = new Player(secondPlayer);
         
         addPlayer(p1);
         addPlayer(p2);
         
         Player nowPlaying;
         do{
             System.out.println("----------------------------------------------");
             nowPlaying = getTurn();
             System.out.println("Now Playing: "+ nowPlaying.getName()+" the current position is "+nowPlaying.getPosition());
             System.out.println(nowPlaying.getName()+" it's your turn, please press enter to roll dice");
             
             String input= sc.nextLine();
             int x = 0;
             if (input.isEmpty()){
                 x = nowPlaying.rollDice();
             }

             System.out.println(nowPlaying.getName()+ " is rolling dice and get number: "+x);
             movePlayer(nowPlaying, x);
             System.out.println(nowPlaying.getName()+ " new position is "+ nowPlaying.getPosition());

             for(int t = 0; t < 2; t++){
                if(x == 6){
                    System.out.println(nowPlaying.getName() + " got another turn!");
                    System.out.println();
                    x = nowPlaying.rollDice();
                    System.out.println(nowPlaying.getName()+ " is rolling dice and get number: "+x);
                    movePlayer(nowPlaying, x);
                    System.out.println(nowPlaying.getName()+ " new position is "+ nowPlaying.getPosition());
                }
             }

             
         } while(getGameStatus()!=2);
         
         System.out.println("The Game is Over, the winner is: "+ nowPlaying.getName());

         sc.close();
     }
     
     public void movePlayer(Player p, int x){
         this.gameStatus=1;
         p.moveAround(x, this.boardSize);

        for(Debuff d: this.debuffs){
            if(d.getDebuffPos() == p.getPosition()){
                p.addDebuffCard();
                System.out.println("Landed on debuff box, " + p.getName() + " receive 1 debuff card. Current debuff cards: " + p.getDebuffCard());
            }
        }

        for(Buff b: this.buffs){
            if(b.getBuffPos() == p.getPosition()){
                p.addBuffCard();
                System.out.println("Landed on buff box, " + p.getName() + " receive 1 buff card. Current buff cards: " + p.getBuffCard());
            }
        }

         for(Ladder l: this.ladders){
             if(l.getFromPosition() == p.getPosition()){
                if(p.getDebuffCard() > 0){
                    p.deductDebuffCard();
                    System.out.println("Debuff card in effect. " + p.getName() + " cannot climb the ladder. Debuff card minus 1. Current debuff card: " + p.getDebuffCard());
                }
                else{
                 p.setPosition(l.getToPosition()); 
                 System.out.println(p.getName()+" got ladder so jumps to "+p.getPosition());
                }
             }

         }
         
         for(Snake s: this.snakes){
             if(s.getHead() == p.getPosition()){
                if (p.getBuffCard() > 0) {
                    p.deductBuffCard();
                    System.out.println("Buff card in effect. " + p.getName() + " cannot go down the snake. Buff card minus 1. Current buff card: " + p.getBuffCard());
                }
                 else{
                    p.setPosition(s.getTail());
                 System.out.println(p.getName()+" got snake so slide down to "+p.getPosition());     
                 }           
             }
         }
         
         if (p.getPosition()==this.boardSize){
             this.gameStatus=2;
         }
     }
 }