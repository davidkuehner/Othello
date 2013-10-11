package Participants.Console;

import Othello.Move;

public class MAEDKUPlayer extends Othello.Joueur
{
	public MAEDKUPlayer(int depth, int playerID) {
		super(depth, playerID);
	}

	public Move nextPlay(Move move)
	{
		return new Move(1,1);
	}
}