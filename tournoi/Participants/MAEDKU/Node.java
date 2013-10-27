package Participants.MAEDKU;

import Othello.Move;
import java.util.List;

public class Node
{
	private Grid grid;
	private Cell.Owner owner;
	
	public Node(Grid grid, Cell.Owner owner)
	{
		this.grid = grid;
		this.owner = owner;
	}
	
	public int eval()
	{
		return 0;
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
		return new Node(newGrid, Cell.getAdversary(owner));
	}
}