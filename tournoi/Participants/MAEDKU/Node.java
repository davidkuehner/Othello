package Participants.MAEDKU;

import Othello.Move;
import java.util.List;

public class Node
{
	private Grid grid;
	private Cell.Owner owner;
	private Cell.Owner advColor;
	private Move lastMove;
	private int parentAdvCellCount;
	private int parentAdvMoveCount;
	
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

	
	/*switch grid  as http://www.csse.uwa.edu.au/cig08/Proceedings/papers/8010.pdf*/
	public int eval()
	{
		int i = lastMove.i;
		int j = lastMove.j;
		int size = grid.getSize();
		int cells = size*2;
				
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
			return ending[i][j];
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
			return middle[i][j];
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
			return opening[i][j];
		}
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
		Grid newGrid = this.grid.cloneOf();
		
		newGrid.addTurn(move, owner);
		
		Cell.Owner adversary = Cell.getAdversary(owner);
		int parentAdvCellCount = this.grid.countCellOfOwner(adversary);
		int parentAdvMoveCount = this.grid.getPossibleTurns(adversary).size();
		
		Node newNode = new Node(newGrid, adversary, move, parentAdvCellCount, parentAdvMoveCount);
		
		return newNode;
	}
}