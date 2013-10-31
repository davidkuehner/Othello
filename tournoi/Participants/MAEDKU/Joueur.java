package Participants.MAEDKU;

import Othello.Move;

/**
 * The Joueur class contains merges the different parts to build an "intelligent" Othello player.
 *
 * 
 *
 * @author: David Kuehner (david.kuehner@he-arc.ch), Marco Aeberli (marco.aeberli@he-arc.ch)
 */
public class Joueur extends Othello.Joueur
{

	/**********************************
	 * Constructor
	 **********************************/
	 
	public Joueur(int depth, int playerID) {
		super(depth, playerID);
		grid = new Grid(8);
		
		// Initialize the game grid.
		grid.getCell(3,3).setOwner(Cell.Owner.BLUE);
		grid.getCell(4,3).setOwner(Cell.Owner.RED);
		grid.getCell(3,4).setOwner(Cell.Owner.RED);
		grid.getCell(4,4).setOwner(Cell.Owner.BLUE);
		
		// as default, the adversary takes RED, he will be the beginner.
		mycolor = Cell.Owner.BLUE;
		advcolor = Cell.Owner.RED;
		
		if(playerID == 0)
		{
			// I will take the first turn, so i take RED as Color.
			mycolor = Cell.Owner.RED;
			advcolor = Cell.Owner.BLUE;
		}
	}

	/**********************************
	 * Public methods
	 **********************************/
	 
	public Move nextPlay(Move move)
	{
		// Calculate some parameters of the current state before applying the adversary move.
		int parentAdvCellCount = this.grid.countCellOfOwner(advcolor);
		int parentAdvMoveCount = this.grid.getPossibleTurns(mycolor).size();
		
		if(move!=null)
			grid.addTurn(move, advcolor);
		
		// create the root node for the evaluation tree and apply the alphabeta algorithm
		Node root = new Node(this.grid, mycolor, parentAdvCellCount, parentAdvMoveCount);
		MinMaxResult res = alphabeta(root, this.depth, true, Integer.MAX_VALUE);
		
		if(res.getMove() != null)
			grid.addTurn(res.getMove(), mycolor);
		
		return res.getMove();
	}
	
	
	/**********************************
	 * private methods
	 **********************************/
	 
	private MinMaxResult alphabeta(Node node, int depth, boolean maximize, int parentValue)
	{
		if(depth == 0 || node.isGameOver())
		{
			return new MinMaxResult(null, node.eval());
		}
		
		int optVal = (maximize ? Integer.MIN_VALUE : Integer.MAX_VALUE);
		Move optOp = null;
		
		for(Move op : node.ops())
		{
			Node newNode = node.apply(op);
			MinMaxResult res = alphabeta(newNode, depth-1, !maximize, optVal);
			
			int factor = (maximize ? 1 : -1);
			if(res.getValue() * factor > optVal * factor)
			{
				optVal = res.getValue();
				optOp = op;
				if(optVal * factor > parentValue * factor)
					break;
			}
		}
		
		return new MinMaxResult(optOp, optVal);
	}
	
	/**********************************
	 * Variables
	 **********************************/
	
	// Tools
	private Grid grid;
	private boolean colorInitialized;
	private Cell.Owner mycolor;
	private Cell.Owner advcolor;
}