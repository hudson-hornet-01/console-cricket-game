import java.util.Scanner;
import java.util.Random;
class Cricket{
    public static String overs(int balls){
        int overs,extraBalls;
        overs=balls/6;
        extraBalls=balls%6;
        String over=" ("+overs+"."+extraBalls+")";
        
        return over;
    }
    public static void showMessage(int runs){
        if(runs==4)
            System.out.println("Pierced the gap perfectly — FOUR!");
        else if(runs==6)
            System.out.println("BOOM! That\'s a massive SIX!");
        else if(runs==7)
            System.out.println("Oh no! The batsman is OUT!");
    }
    public static void showScore(int score,int wicket,int balls){
        System.out.println("Score: "+score+"/"+wicket+overs(balls));
    }
    public static void playerBattingFirst(Scanner obj,Random x)throws Exception{
        int player_score,computer_score,player_wicket,player_balls,runs,score,wicket,balls;
        
        System.out.println("Press p to hit the ball");
        char bat=obj.next().charAt(0);
                
        System.out.println("----------Player score----------");
        balls=score=wicket=0;
        while(bat=='p' || bat=='P'){
            balls++;
                    
            runs = x.nextInt(8);                    
            if(runs<=6)
                score += runs;
            else 
                wicket += 1;
            
            showMessage(runs);
            showScore(score,wicket,balls);                    
                    
            if(balls==60 || wicket==10)
                break;
                    
            System.out.println("Press p to hit the ball");
            bat=obj.next().charAt(0);
        }
        player_score = score;
        player_wicket = wicket;
        player_balls = balls;
        System.out.println("Final score = "+score+"/"+wicket+overs(balls));
                
        System.out.println("\nComputer will have to chase "+(score+1)+" runs in 60 balls");
        System.out.println("Computer\'s innings");
                
        System.out.println("----------Computer score----------");
                
        score=wicket=0;
        for(balls=1; balls<=60; balls+=1){
            runs=x.nextInt(8);
                    
            Thread.sleep(1500);
                    
            if(runs<=6)
                score += runs;
            else 
                wicket += 1;
            
            showMessage(runs);
            showScore(score,wicket,balls);
                    
            if(wicket==10 || player_score<score)
                break;                    
        }
        if(balls==61)
            balls--;
        computer_score=score;                
        
        if(player_score>computer_score)
            System.out.println("\n\n\n==========What a match! You secured victory by "+ (player_score-computer_score) +" runs!==========");
        else if(computer_score>player_score)
            System.out.println("\n\n\n==========Defeat! Lost by "+(10-wicket)+" wickets with "+(60-balls)+" remaining==========");
        else
            System.out.println("\n\n\n==========What a thriller! The match ends in a TIE!==========");
            
        System.out.println("\n==========Match Summary==========");
        System.out.println("Player score: "+player_score+"/"+player_wicket+overs(player_balls));
        System.out.println("Computer score: "+computer_score+"/"+wicket+overs(balls));
        System.out.println("=================================");
    }
    public static void computerBattingFirst(Scanner obj,Random x)throws Exception{
        int score,wicket,balls,runs,computer_score,player_score,computer_wicket,computer_balls;
        
        System.out.println("----------Computer score----------");
        score=wicket=0;
        for(balls=1; balls<=60; balls+=1){
            runs=x.nextInt(8);
                    
            Thread.sleep(1500);
                    
            if(runs<=6)
                score += runs;
            else 
                wicket += 1;
                
            showMessage(runs);
            showScore(score,wicket,balls);
            
            if(wicket==10)
                break;
        }
        if(balls==61)
            balls--;
        computer_score = score;
        computer_wicket = wicket;
        computer_balls = balls;
        System.out.println("Final score = "+score+"/"+wicket+overs(balls));
                
        System.out.println("\nYou will have to chase "+(score+1)+" runs in 60 balls");
        System.out.println("Player\'s innings");
        
        System.out.println("Press p to hit the ball");
        char bat=obj.next().charAt(0);
        
        System.out.println("----------Player score----------");       
        balls=score=wicket=0;
        while(bat=='p' || bat=='P'){
            balls++;
                    
            runs = x.nextInt(8);                    
            if(runs<=6)
                score += runs;
            else 
                wicket += 1;
            
            showMessage(runs);
            showScore(score,wicket,balls);
            
            if(balls==60 || wicket==10 || computer_score<score)
                break;
                    
            System.out.println("Press p to hit the ball");
            bat=obj.next().charAt(0);
        }
        player_score = score;
        
        if(player_score>computer_score)
            System.out.println("\n\n\n==========Clinical performance! You won by "+(10 - wicket)+" wickets with "+(60-balls)+" remaining!==========");
        else if(player_score<computer_score)
            System.out.println("\n\n\n==========Defeat! Your opponent won by "+(computer_score-player_score)+" runs==========");
        else
            System.out.println("\n\n\n==========Scores level! It’s a nail-biting TIE!==========");
            
        System.out.println("\n==========Match Summary==========");
        System.out.println("Computer score: "+computer_score+"/"+computer_wicket+overs(computer_balls));
        System.out.println("Player score: "+player_score+"/"+wicket+overs(balls));
        System.out.println("=================================");
    }
    public static void main(String args[])throws Exception{
        Random x=new Random();
        Scanner obj=new Scanner(System.in);
        char toss;
        int t,choice;
        
        System.out.println("----------Toss time----------");
        System.out.print("Press H for heads or T for tails: ");
        toss=obj.next().charAt(0);
        
        t=x.nextInt(2)+1;
        toss=Character.toUpperCase(toss);
        if((t==1 && toss=='H') || (t==2 && toss=='T')){
            System.out.println("\n\nYou\'ve won the toss!!");
            System.out.println("Enter your choice:");
            System.out.print("1 for batting or 2 for bowling\n: ");
            choice=obj.nextInt();
            
            if(choice==1)
                playerBattingFirst(obj,x);        
            else
                computerBattingFirst(obj,x);
        }
        else{
            System.out.println("\n\nYou\'ve lost the toss!!");
            choice=x.nextInt(2)+1;
            Thread.sleep(1500);
            if(choice==1){
                System.out.println("Computer decided to bat first");
                computerBattingFirst(obj,x);
            }
            else{
                System.out.println("Computer decided to bowl first");
                playerBattingFirst(obj,x);
            }
        }
    }
}