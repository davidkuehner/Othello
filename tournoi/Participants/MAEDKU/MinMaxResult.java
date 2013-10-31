package Participants.MAEDKU;

import Othello.Move;

/***
 * The MinMaxResult class represents a result of the minimax or alphabeta algorithm.
 * 
 * Only a result of the Othello game can be represented. Otherwise this class should be
 * refactored to a template class.
 *
 * @author: David Kuehner (david.kuehner@he-arc.ch), Marco Aeberli (marco.aeberli@he-arc.ch)
 */
public class MinMaxResult
{
	/**********************************
	 * Constructor
	 **********************************/
	
	public MinMaxResult(Move move, int value)
	{
		this.move = move;
		this.value = value;
	}
	
	/**********************************
	 * Getter/Setter
	 **********************************/
	 
	public Move getMove()
	{
		return move;
	}
	
	public int getValue()
	{
		return value;
	}
	
	/**********************************
	 * Variables
	 **********************************/
	
	// inputs/outputs
	private Move move;
	private int value;
	
}