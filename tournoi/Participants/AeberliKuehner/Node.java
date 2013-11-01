package Participants.AeberliKuehner;

import Othello.Move;
import java.util.List;

/***
 * This class represents a node in the evaluation tree.
 * 
 * To be able to determine the strength of a node some information are necessary.
 * These information are also associated and available in this class.
 *
 * @author: David Kuehner (david.kuehner@he-arc.ch), Marco Aeberli (marco.aeberli@he-arc.ch)
 */
public class Node
{
	/**********************************
	 * Constructor
	 **********************************/

	public Node(Grid grid, Cell.Owner owner, int parentAdvCellCount, int parentAdvMoveCount)
	{
		this(grid, owner, null, parentAdvCellCount, parentAdvMoveCount);
	}
	
	public Node(Grid grid, Cell.Owner owner, Move lastMove, int parentAdvCellCount, int parentAdvMoveCount)
	{
		this.grid = grid;
		this.owner = owner;
		this.advColor = Cell.getAdversary(owner);
		this.lastMove = lastMove;
		this.parentAdvCellCount = parentAdvCellCount;
		this.parentAdvMoveCount = parentAdvMoveCount;
	}

	/**********************************
	 * Public methods
	 **********************************/
	 
	public int eval()
	{
		/*
		The main idea to use different grids for different game situations came from http://www.csse.uwa.edu.au/cig08/Proceedings/papers/8010.pdf
		Based on this evaluation grids, we have added some parameteres which could optimize the evaluation.
		Afterwards we didn't had the passion in this subject to invest a lot of hours for the optimization.
		Our factors are selected not totally by random, but they aren't based on many tests and research too...
		
		Two indicators - number of free empty cell is odd and the number of cells lost/won - are only evaluated when the game is in the ending phase.
		*/
		int i = lastMove.i;
		int j = lastMove.j;
		int size = grid.getSize();
		int cells = size*2;
		int grade = 0;
		
		// factors for different evaluation parties
		int boundaryFactor = 1000;
		int advMoveFactor = 100;
		int oddFactor = 1000;
		int advCellFactor = 150;
		
		if( grid.isEndingState() ) {
			// Ending State: two cells in the corners with the same color
			int ending[][] = { { 550062, -17812, -258948, -59007, -59007, -258948, -17812, 550062},
								{-17812, 96804, -216084, -201723, -201723, -216084, 96804, -17812},
								{-258948, -216084, 49062, -107055, -107055, 49062, -216084, -258948},
								{-59007, -201723, -107055, 73486, 73486, -107055, -201723, -59007},
								{-59007, -201723, -107055, 73486, 73486, -107055, -201723, -59007},
								{-258948, -216084, 49062, -107055, -107055, 49062, -216084, -258948},
								{-17812, 96804, -216084, -201723, -201723, -216084, 96804, -17812},
								{550062, -17812, -258948, -59007, -59007, -258948, -17812, 550062}};
			grade = ending[i][j];
			
		    // Check if the number of empty resting cells is odd.
		    // If it's odd the last move will be for the adversary --> generally bad...
		    int odd = (grid.isCountOfEmptyCellOdd() ? 1 : 0);
		    grade -= odd * oddFactor;
			
			
			grade += advCellFactor * (parentAdvCellCount - grid.countCellOfOwner(advColor));
		}
		else if (grid.isMiddleState()) {
			// Middle State: at least one cell on the edge not empty.
			int middle[][] = {{ 632711, -332813, 33907, -200512, -200512, 33907, -332813, 632711},
								{-332813, -152928, -187550, -18176, -18176, -187550, -152928, -332813},
								{33907, -187550, 106939, 62415, 62415, 106939, -187550, 33907},
								{-200512, -18176, 62415, 10539, 10539, 62415, -18176, -200512},
								{-200512, -18176, 62415, 10539, 10539, 62415, -18176, -200512},
								{33907, -187550, 106939, 62415, 62415, 106939, -187550, 33907},
								{-332813, -152928, -187550, -18176, -18176, -187550, -152928, -332813},
								{632711, -332813, 33907, -200512, -200512, 33907, -332813, 632711}};
			grade = middle[i][j];
		} 
		else {
			int opening[][] = { {0, 0,        0,    0,    0,    0,    0,   0},
								{0, -2231, 5583, 2004, 2004, 5583, -2231,  0},
								{0, 5583, 10126, -10927, -10927, 10126, 5583, 0},
								{0, 2004, -10927, -10155, -10155, -10927, 2004, 0},
								{0, 2004, -10927, -10155, -10155, -10927, 2004, 0},
								{0, 5583, 10126, -10927, -10927, 10126, 5583, 0},
								{0, -2231, 5583, 2004, 2004, 5583, -2231, 0},
								{0, 0, 0, 0, 0, 0, 0, 0} };
			grade = opening[i][j];
		}
		
		// check neighbours, more items around the move is better
		// Value between 0 and 4
		grade -= boundaryFactor * grid.boundaryLevel(i, j);
		
		// Compare the possible moves of the adversary before the last move and after
		int difference = this.parentAdvMoveCount - this.grid.getPossibleTurns(advColor).size();
		grade += advMoveFactor * difference;
		
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

	public Node apply(Move move)
	{
		// Copy the current grid
		Grid newGrid = this.grid.cloneOf();
		
		// apply the move, have to be a valid one, to the new generated grid.
		newGrid.addTurn(move, owner);
		
		// Save some informations which are necessary for the new created node
		Cell.Owner adversary = Cell.getAdversary(owner);
		int parentAdvCellCount = this.grid.countCellOfOwner(adversary);
		int parentAdvMoveCount = this.grid.getPossibleTurns(adversary).size();
		
		// Create the new node and return it.
		Node newNode = new Node(newGrid, adversary, move, parentAdvCellCount, parentAdvMoveCount);
		
		return newNode;
	}
	
	/**********************************
	 * Variables
	 **********************************/
	
	// inputs
	private Grid grid;
	private Cell.Owner owner;
	private Cell.Owner advColor;
	private Move lastMove;
	private int parentAdvCellCount;
	private int parentAdvMoveCount;
}