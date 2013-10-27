package Participants.MAEDKU;

import Othello.Move;

public class Joueur extends Othello.Joueur
{
	private Grid grid;
	private Cell.Owner o;
	private static final Cell.Owner MYCOLOR = Cell.Owner.RED;
	private static final Cell.Owner ADVCOLOR = Cell.Owner.BLUE;
	
	public Joueur(int depth, int playerID) {
		super(depth, playerID);
		grid = new Grid(8);
	}

	public Move nextPlay(Move move)
	{
		if(move!=null)
			grid.addTurn(move, ADVCOLOR);
		
		Move mymove = minmax();
		if(mymove!=null)
			grid.addTurn(mymove, MYCOLOR);
		
		return mymove;
	}
	
	private Move minmax()
	{
		MinMaxResult res = max(new Node(this.grid, MYCOLOR), this.depth);
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