package Participants.MAEDKU;

public class Cell
{
	public enum Owner 
	{
		RED, BLUE, UNDEF
	}

	/**********************************
	 * Constructor
	 **********************************/
	public Cell(int row, int column, Owner owner)
	{
		this.row = row;
		this.column = column;
		this.owner = owner;
	}
	 
	public Cell(int row, int column)
	{
		this(row, column, Owner.UNDEF);
	}
	
	/**********************************
	 * Getter/Setter
	 **********************************/
	 
	public int getRow()
	{
		return this.row;
	}
	
	public int getI()
	{
		return getRow();
	}
	
	public int getColumn()
	{
		return this.column;
	}
	
	public int getJ()
	{
		return getColumn();
	}
	
	public Owner getOwner()
	{
		return this.owner;
	}
	
	public void setOwner(Owner owner)
	{
		this.owner = owner;
	}
	
	/**********************************
	 * Variables
	 **********************************/
	 
	// Inputs/Outputs
	private int row;
	private int column;
	private Owner owner;
}