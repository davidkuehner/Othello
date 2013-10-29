package Participants.dummy;

import Othello.Move;

public class MinMaxResult
{
	private Move move;
	private int value;
	
	public MinMaxResult(Move move, int value)
	{
	this.move = move;
	this.value = value;
	}
	
	public Move getMove()
	{
	return move;
	}
	
	public int getValue()
	{
	return value;
	}
}