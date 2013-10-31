package Participants.MAEDKU;

/***
 * The cell class represent a cell with an row, column and owner indicator.
 *
 * The columns are the i values, the rows the j and the owner can be RED, BLUE or UNDEFined.
 *
 * @author: David Kuehner (david.kuehner@he-arc.ch), Marco Aeberli (marco.aeberli@he-arc.ch)
 */
public class Cell
{
	public enum Owner 
	{
		RED, BLUE, UNDEF
	}
	
	public static Owner getAdversary(Owner owner)
	{
		return owner == Cell.Owner.RED ? Cell.Owner.BLUE : Cell.Owner.RED;
	}

	/**********************************
	 * Constructor
	 **********************************/
	 
	public Cell(int i, int j, Owner owner)
	{
		this.i = i;
		this.j = j;
		this.owner = owner;
	}
	 
	public Cell(int i, int j)
	{
		this(i, j, Owner.UNDEF);
	}
	
	public Cell(Cell cell)
	{
		this(cell.i, cell.j, cell.owner);
	}
	
	/**********************************
	 * Public methods
	 **********************************/
	
	@Override
	public String toString()
	{
		return "(" + getI() + " " + getJ() + ")";
	}
	
	/**********************************
	 * Getter/Setter
	 **********************************/
	
	public int getI()
	{
		return this.i;
	}
	
	public int getJ()
	{
		return this.j;
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
	private int i;  // Column
	private int j;  // Line/row
	private Owner owner;
}