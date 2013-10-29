package Participants.dummy;

import Othello.Move;
import java.io.*;

public class InvalidMoveException extends Exception
{
	private Move move;
	private Cell.Owner owner;
	
	public InvalidMoveException(Move move, Cell.Owner owner)
	{
		super("Invalid move (" + move.i + ", " + move.j + ") from owner: " + owner);
		this.move = move;
		this.owner = owner;
	}
}