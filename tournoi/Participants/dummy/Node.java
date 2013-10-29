package Participants.dummy;

import Othello.Move;
import java.util.List;

public class Node
{
	private Grid grid;
	private Cell.Owner owner;
	private Move lastMove;
	private Node parent;
	private int parentNbAdvMove;
	private int parentNbCell;
	
	public Node(Grid grid, Cell.Owner owner)
	{
		this.grid = grid;
		this.owner = owner;
		this.lastMove = null;
		this.parentNbAdvMove = 0;
	}
	
	/*funking stupide grid*/
	public int evalDummy()
	{
		int i = lastMove.i;
		int j = lastMove.j;
	  /*int values[][] = { { 500, -150, 30, 10, 10, 30, -150,  500 },
						   {-150, -250,  0,  0,  0,  0, -250, -150 },
						   {  30,    0,  1,  2,  2,  1,    0,   30 },
						   {  30,    0,  2, 16, 16,  2,    0,   30 },
						   {  30,    0,  2, 16  16,  2,    0,   30 },
						   {  30,    0,  1,  2,  2,  1,    0,   30 },
						   {-150, -250,  0,  0,  0,  0, -250, -150 },
						   { 500, -150, 30, 10, 10, 30, -150,  500 }
						   };*/
		int values[][] = { { 100,  -8,  8,  6,  6,  8,  -8, 100 },
						   {  -8, -24, -4,  3,  3, -4, -24,  -8 },
						   {   8,  -4,  7,  4,  4,  7,  -4,   8 },
						   {   6,   3,  4,  0,  0,  4,   3,   6 },
						   {   6,   3,  4,  0,  0,  4,   3,   6 },
						   {   8,  -4,  7,  4,  4,  7,  -4,   8 },
						   {  -8, -24, -4,  3,  3, -4, -24,  -8 },
						   { 100,  -8,  8,  6,  6,  8,  -8, 100 }
						   };
		return values[i][j];
	}
	
	// this eval mix grid and strategy
	public int eval()
	{
		int i = lastMove.i;
		int j = lastMove.j;
		int n = grid.getSize() - 1;
		
		int a = 100;	// corner
		int c = -8;		// c near to corner = bad position
		int x = -24; 	// x near to corner in diag = very bad
		int y = 7;		// y near to x = good position
		int b = 8;		// best edge position
		int d = -4;		// near b = bad position
		int e = 6;		// good edge position
		int f = 3;		// bof position ^^
		int g = 4;		// bof position bis
		
		double factMove = 0.2;
		double factCell = 0.2;
		
		int values[][] = { {  a,  c,  b,  e,  e,  b,  c,  a  },
						   {  c,  x,  d,  f,  f,  d,  x,  c  },
						   {  b,  d,  y,  g,  g,  y,  d,  b  },
						   {  e,  f,  g,  0,  0,  g,  f,  e  },
						   {  e,  f,  g,  0,  0,  g,  f,  e  },
						   {  b,  d,  y,  g,  g,  y,  d,  b  },
						   {  c,  x,  d,  f,  f,  d,  x,  c  },
						   {  a,  c,  b,  e,  e,  b,  c,  a  } };
									
		int grade = values[i][j];

		// checks if the number of advMoves decreace or not
		int debug = (int)factMove * ( parentNbAdvMove - grid.getPossibleTurns(owner).size() );
		grade += debug;
		
		// checks if the number of cell decreace or not
		debug = (int)factCell * ( parentNbCell - grid.countCellOfOwner(owner) );
		grade += debug;
		
		return grade;
	}
	
	// this method is to heavy, first initialisation must be done by the grid this avoid a lot of tests
	public int evalBad()
	{
		
		int i = lastMove.i;
		int j = lastMove.j;
		int n = grid.getSize() - 1;
		
		// temporaire pour evaluation
		int extXC = +10;
		int XC = -1000000;
		int corner = +1000;
		int edge = +100;
		int factBound = -1;
		int factMove = -1;
		int factCell = 1;
		
		
		int grade = 0;
		System.out.println("( " + i  +" , " + j +" ) ");
		
		/* Specials location -> to complex, use a grid */
		// if in external border of X and C
		if( ( i==2 && ( j <=2 || j>=n-2) ) || 
			( i==n-2 && ( j <=2 || j>=n-2) ) ||
			( j==2 && ( i <=1 || i>=n-1) ) ||  
			( j==n-2 && (i <=1 || i >= n-1)) ){
			grade += extXC; System.out.println("is extXC + " + extXC); }
		// if in X and C
		else if( ( i==1 && ( j <=1 || j >= n-1) ) || 
			( i==n-1 && ( j <= 1 || j >= n-1) ) ||
			( i==0 && (j==1 || j == n-1)) ||
			( i==n && (j==1 || j == n-1)) ){
			grade +=XC; System.out.println("is XC + " + XC); }
		// if in corners
		else if( (i==j && (i==0 || i==n) ) ||
			( ( i==0 && j==n) || (i==n && j==n) ) ){
			grade += corner;  System.out.println("is corner + " + corner); }
			
		// if on the edge
		if( i == 0 || 
			i == n ||
			j == 0 ||
			j == n  ){
			grade += edge;  System.out.println("is edge + " + edge); }
			
		// if on a boundary
		int boundCount = grid.boundaryLevel(i,j);
		int debug = factBound * boundCount;
		System.out.println("boundary + " + debug); 
		grade += debug;

		// checks if the number of advMoves decreace or not
		debug = factMove * ( parentNbAdvMove - grid.getPossibleTurns(owner).size() );
		System.out.println("advMoves + " + debug); 
		grade += debug;
		
		// checks if the number of cell decreace or not
		debug = factCell * ( parentNbCell - grid.countCellOfOwner(owner) );
		System.out.println("myCell + " + debug); 
		grade += debug;
		
		System.out.println("--------> " + grade);
		return grade;
	}
	
	public boolean isGameOver()
	{
		List<Move> myMoves = grid.getPossibleTurns(owner);
		List<Move> advMoves = grid.getPossibleTurns(Cell.getAdversary(owner));
		return (myMoves.size() == 0 && advMoves.size() == 0);
	}
	
	public List<Move> ops()
	{
		return grid.getPossibleTurns(owner);
	}
	
	public void setLastMove(Move lastMove)
	{
		this.lastMove = lastMove;
	}
	
	public void setParentNbAdvMove(int nb)
	{
		this.parentNbAdvMove = nb;
	}
	
	public void setParentNbCell( int nb )
	{
		this.parentNbCell = nb;
	}
	
	public Node apply(Move move)
	{
		Grid newGrid = this.grid.cloneOf();
		
		try
		{
			newGrid.addTurn(move, owner);
		}
		catch(InvalidMoveException exception)
		{
			System.out.println("[MAEDKU] ouwou, we have catched an exception which shouldn't occure.");
			System.out.println("[MAEDKU] We have extracted this move...:(.");
			System.out.println("[MAEDKU] The cause is: " + exception.getMessage());
		}
		Node newNode = new Node(newGrid, Cell.getAdversary(owner));
		newNode.setLastMove(move);
		newNode.setParentNbAdvMove(this.grid.getPossibleTurns(owner).size());
		Cell.Owner adversary = Cell.Owner.RED == owner ? Cell.Owner.BLUE : Cell.Owner.RED ;
		newNode.setParentNbCell(this.grid.countCellOfOwner( adversary ) );
		return newNode;
	}
}