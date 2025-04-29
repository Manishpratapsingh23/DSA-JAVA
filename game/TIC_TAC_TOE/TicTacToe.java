package game.TIC_TAC_TOE;
import java.util.*;


public class TicTacToe {
    private Player player1, player2;
    private Board board;

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame(); 
    }

    public void startGame(){
        Scanner sc=new Scanner(System.in);
        player1=takeInput(1);
        player2=takeInput(2);
        while(player1.getSymbol()==player2.getSymbol()){
            System.out.println("Symbol already take! choose other");
            char symbol=sc.next().charAt(0);
            player2.setSymbol(symbol);
        
        }
        board=new Board(player1.getSymbol(),player2.getSymbol()); 
        boolean turn=true;
        int status = board.INCOMPLETE;
        while(status == board.INCOMPLETE || status == board.INVALID){
            if(turn){
                System.out.println("Player 1- "+player1.getName()+"'s chance");
                System.out.println("Enter x");
                int x=sc.nextInt();
                System.out.println("Enter y");
                int y=sc.nextInt();
                status= board.move(player1.getSymbol(),x,y);
                if(status!=board.INVALID){
                    turn=false;
                    board.print();
                } else{
                    System.out.println("Invalid move! Try Agin!");
                }
            }
            else{
                System.out.println("Player 2- "+player2.getName()+"'s chance");
                System.out.println("Enter x");
                int x=sc.nextInt();
                System.out.println("Enter y");
                int y=sc.nextInt();
                status= board.move(player2.getSymbol(),x,y);
                if(status!=board.INVALID){
                    turn=true;
                    board.print();
                } else{
                    System.out.println("Invalid move! Try Agin!");
                } 
            }
        }
        if(status==Board.P1_wins){
            System.err.println(player1.getName()+" Wins....!!");
        }
        if(status==Board.P2_wins){
            System.err.println(player2.getName() +" Wins....!!");
        }
        if(status==Board.DRAW){
            System.err.println("Draw....!!");
        }

    }
    private Player takeInput(int num){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Player "+num+" name : ");
        String name=sc.nextLine();
        System.out.println("Enter Player "+num+" Symbol : ");
        char symbol=sc.next().charAt(0);
        Player p=new Player(name,symbol);
        return p;
    }
}
