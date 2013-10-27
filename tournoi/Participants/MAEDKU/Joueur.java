package Participants.MAEDKU;

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
		if(move!=null)
			grid.addTurn(move, advcolor);

		Move mymove = minmax();
		if(mymove!=null)
			grid.addTurn(mymove, mycolor);
		
		return mymove;
	}
	
	private Move minmax()
	{
		MinMaxResult res = max(new Node(this.grid, mycolor), this.depth);
		return res.getMove();
	}
	
	private MinMaxResult max(Node node, int depth)
	{
		if(depth == 0 || node.isGameOver())
		{
			return new MinMaxResult(null, node.eval());
		}
		
		int maxValue = Integer.MAX_VALUE * -1;
		Move maxOp = null;
		
		for(Move op : node.ops())
		{
			Node newChild = node.apply(op);
			MinMaxResult minResult = min(newChild, depth - 1);
			
			if(minResult.getValue() > maxValue)
			{
				maxValue = minResult.getValue();
				maxOp = minResult.getMove();
			}
		}
		
		return new MinMaxResult(maxOp, maxValue);
	}
	
	private MinMaxResult min(Node node, int depth)
	{
		if(depth == 0 || node.isGameOver())
		{
			return new MinMaxResult(null, node.eval());
		}
		
		int minValue = Integer.MIN_VALUE;
		Move minOp = null;
		
		for(Move op : node.ops())
		{
			Node newChild = node.apply(op);
			MinMaxResult maxResult = max(newChild, depth - 1);
			
			if(maxResult.getValue() < minValue)
			{
				minValue = maxResult.getValue();
				minOp = maxResult.getMove();
			}
		}
		
		return new MinMaxResult(minOp, minValue);
	}
}