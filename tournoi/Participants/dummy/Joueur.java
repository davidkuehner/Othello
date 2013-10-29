package Participants.dummy;

import Othello.Move;

public class Joueur extends Othello.Joueur
{
	private Grid grid;
	private Cell.Owner o;
	private boolean colorInitialized;
	private Cell.Owner mycolor;
	private Cell.Owner advcolor;
	
	public Joueur(int depth, int playerID) {
		super(depth, playerID);
		grid = new Grid(8);
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

	public Move nextPlay(Move move)
	{
		try
		{
			if(move!=null)
				grid.addTurn(move, advcolor);
		}
		catch(InvalidMoveException exception)
		{
			System.out.println("[MAEDKU] The move of the adversary is invalid!");
			System.out.println("[MAEDKU] The cause is: " + exception.getMessage());
		}
		
		Move mymove = minmax();
		
		try
		{
			if(mymove!=null)
				grid.addTurn(mymove, mycolor);
		}
		catch(InvalidMoveException exception)
		{
			System.out.println("[MAEDKU] huff, we have done an error in our algorithm. That's not cool.");
			System.out.println("[MAEDKU] The cause is: " + exception.getMessage());
		}
		
		return mymove;
	}
	
	private Move minmax()
	{
		MinMaxResult res = alphabeta(new Node(this.grid, mycolor), this.depth, true, Integer.MAX_VALUE);
		return res.getMove();
	}
	
	private MinMaxResult alphabeta(Node node, int depth, boolean maximize, int parentValue)
	{
		if(depth == 0 || node.isGameOver())
		{
			//return new MinMaxResult(null, node.eval());
			return new MinMaxResult(null, node.evalDummy());
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
}