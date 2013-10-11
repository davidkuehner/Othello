package Participants.Console;


public class Grid
{
	/**********************************
	 * Constructor
	 **********************************/
	 
	public Grid(int size)
	{
		this.size = size;
		cells = new Cell[this.size*this.size];
		
		initGrid();
	}
	
	/**********************************
	 * Public methods
	 **********************************/
	
	public Cell[] getPossibleTurns()
	{
		return null;
	}
	
	public Cell getNorth(Cell c)
	{
		return null;
	}
	
	public Cell getNorthEast(Cell c)
	{
		return null;
	}
	
	public Cell getEast(Cell c)
	{
		return null;
	}
	
	public Cell getSouthEast(Cell c)
	{
		return null;
	}
	
	public Cell getSouth(Cell c)
	{
		return null;
	}

	public Cell getSouthWest(Cell c)
	{
		return null;
	}
	
	public Cell getWest(Cell c)
	{
		return null;
	}
	
	public Cell getNorthWest(Cell c)
	{
		return null;
	}
	
	/**********************************
	 * Getter/Setter
	 **********************************/
	 
	 	
	/**********************************
	 * private methods
	 **********************************/
	
	private void initGrid()
	{
		for(int i = 0; i < this.size; ++i)
		{
			for(int j = 0; j < this.size; j++)
			{
				this.cells[i*j] = new Cell(i,j);
			}
		}
	}
	
	/**********************************
	 * Variables
	 **********************************/
	
	// Inputs
	private int size;
	
	// Tools 
	private Cell[] cells;
}