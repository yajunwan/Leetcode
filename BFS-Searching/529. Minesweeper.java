// Let's play the minesweeper game (Wikipedia, online game)!

// You are given an m x n char matrix board representing the game board where:

// 'M' represents an unrevealed mine,
// 'E' represents an unrevealed empty square,
// 'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
// digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
// 'X' represents a revealed mine.
// You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').

// Return the board after revealing this position according to the following rules:

// If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
// If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
// If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
// Return the board when no more squares will be revealed.

public static class pair{
    int row;
    int col;
    pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}
public char[][] updateBoard(char[][] board, int[] click) {
    int directions[][]={ {-1,0},{0,-1},{1,0},{0,1},{-1,-1},{1,-1},{1,1},{-1,1}};
    
    Queue<pair> q=new ArrayDeque<>();
    
    q.add(new pair(click[0],click[1]));
    while(q.size()>0)
    {
        int size=q.size();
        for(int i=0;i<size;i++)
        {
            pair p=q.remove();
            int row=p.row;
            int col=p.col;
            if(board[row][col]=='E')
            {
                board[row][col]='B';
                
                int val=checkForMine(board,row,col);
                if(val>0)
                   board[row][col]=(char)(val+'0');
                else
                {
                    for(int direction[]:directions)
                    {
                         int r=row+direction[0];
                         int c=col+direction[1];
                         if(r<0 || c<0 || r>=board.length|| c>=board[0].length || (board[r][c]!='M' && board[r][c]!='E') )
                                continue;
                         q.add(new pair(r,c));
                    }
                }
                
            }
            else if( board[row][col]=='M' )
                board[row][col]='X';
            
        }   
        
        
    }
    return board;
    
}

public int checkForMine(char [][]board,int row,int col)
{
    int count=0;
    int directions[][]={ {-1,0},{0,-1},{1,0},{0,1},{-1,-1},{1,-1},{1,1},{-1,1}};
    for(int direction[]:directions)
    {
        int i=row+direction[0];
        int j=col+direction[1];
        if(i<0 || j<0 || i>=board.length|| j>=board[0].length)
            continue;
        if(board[i][j]=='M')
            count++;
    }
    return count;
    
}