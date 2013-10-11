package Participants.Console;

public class Cell
{

	/**********************************
	 * Constructor
	 **********************************/
	 
	public Cell(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	/**********************************
	 * Getter/Setter
	 **********************************/
	 
	public int getRow()
	{
		return this.row;
	}
	
	public int getColumn()
	{
		return this.column;
	}
	
	/**********************************
	 * Variables
	 **********************************/
	 
	// Inputs/Outputs
	private int row;
	private int column;
}