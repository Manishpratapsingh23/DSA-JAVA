package game.TIC_TAC_TOE;

public class Board {
    private char board[][];
    private final int boardSize=3;
    private char p1,p2;
    private int count;
    public final static int P1_wins=1;
    public final static int P2_wins=2;
    public final static int DRAW=3;
    public final static int INCOMPLETE=4;
    public final static int INVALID=5;

    public Board(char p1, char p2){
        board =new char[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                board[i][j]=' ';
            }
        }
        this.p1=p1;
        this.p2=p2;
    }

    int move(char symbol, int x, int y) {
        if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=' ') return INVALID;
        board[x][y]=symbol;
        count++;

        // check row
        if(board[x][0]==board[x][1] && board[x][0]==board[x][2]){
            return symbol==p1 ? P1_wins : P2_wins;
        }

        //chaeck column
        if(board[0][y]==board[1][y] && board[0][y]==board[2][y]){
            return symbol==p1 ? P1_wins : P2_wins;
        }
        // check diagonal1
        if(board[0][0]!=' ' && board[1][1]==board[0][0] && board[0][0]==board[2][2]){
            return symbol==p1 ? P1_wins : P2_wins;
        }

        //check diagonal2
        if(board[2][0]!=' ' && board[2][0]==board[1][1] && board[2][0]==board[0][2]){
            return symbol==p1 ? P1_wins : P2_wins;
        }

        if(count==boardSize*boardSize){
            return DRAW;
        }
        return INCOMPLETE;
    }

    void print() {
        System.out.println("<--------------------------------------------------------->");
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                System.out.print(" | "+board[i][j]+" | ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("<--------------------------------------------------------->");
    }

}
