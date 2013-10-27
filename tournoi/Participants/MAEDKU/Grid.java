package Participants.MAEDKU;

import Othello.Move;
import java.util.ArrayList;
import java.util.List;

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
	
	public Grid(Grid grid)
	{
		this.size = grid.size;
		this.cells = new Cell[this.size*this.size];
		
		for(int i = 0; i < this.size; ++i)
		{
			for(int j = 0; j < this.size; j++)
			{
				this.cells[i*j] = new Cell(grid.cells[i*j]);
			}
		}
	}
	
	/**********************************
	 * Public methods
	 **********************************/
	
	@Override
	public Object clone()
	{
		return cloneOf();
	}
	
	public Grid cloneOf()
	{
		return new Grid(this);
	}
	
	public List<Move> getPossibleTurns(Cell.Owner owner)
	{
		List<Move> ops = new ArrayList<Move>();
		
		Cell.Owner adversary = Cell.Owner.RED == owner ? Cell.Owner.BLUE : Cell.Owner.RED;
		
		for(int i = 0; i < size; ++i)
		{
			for(int j = 0; j < size; ++j)
			{
				if(getSouth(i, j) != null && getSouth(i, j).getOwner() == adversary)
				{
					if(checkSouthLineForOwner(i, j, owner))
					{
						ops.add(new Move(i,j));
					}
				}
				else if(getSouthWest(i, j) != null && getSouthWest(i, j).getOwner() == adversary)
				{
					if(checkSouthWestLineForOwner(i, j, owner))
					{
						ops.add(new Move(i,j));
					}
				}
				else if(getWest(i, j) != null && getWest(i, j).getOwner() == adversary)
				{
					if(checkWestLineForOwner(i, j, owner))
					{
						ops.add(new Move(i,j));
					}
				}
				else if(getNorthWest(i, j) != null && getNorthWest(i, j).getOwner() == adversary)
				{
					if(checkNorthWestLineForOwner(i, j, owner))
					{
						ops.add(new Move(i,j));
					}
				}
				else if(getNorth(i, j) != null && getNorth(i, j).getOwner() == adversary)
				{
					if(checkNorthLineForOwner(i, j, owner))
					{
						ops.add(new Move(i,j));
					}
				}
				else if(getNorthEast(i, j) != null && getNorthEast(i, j).getOwner() == adversary)
				{
					if(checkNorthEastLineForOwner(i, j, owner))
					{
						ops.add(new Move(i,j));
					}
				}
				else if(getEast(i, j) != null && getEast(i, j).getOwner() == adversary)
				{
					if(checkEastLineForOwner(i, j, owner))
					{
						ops.add(new Move(i,j));
					}
				}
				else if(getSouthEast(i, j) != null && getEast(i, j).getOwner() == adversary)
				{
					if(checkSouthEastLineForOwner(i, j, owner))
					{
						ops.add(new Move(i,j));
					}
				}
			}
		}
		
		return ops;
	}
	
	public void addTurn(Move move, Cell.Owner owner)
	{
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
	
		private Cell getNorth(int i, int j)
	{
		return null;
	}
	
	private Cell getNorthEast(int i, int j)
	{
		return null;
	}
	
	private Cell getEast(int i, int j)
	{
		return null;
	}
	
	private Cell getSouthEast(int i, int j)
	{
		return null;
	}
	
	private Cell getSouth(int i, int j)
	{
		return null;
	}

	private Cell getSouthWest(int i, int j)
	{
		return null;
	}
	
	private Cell getWest(int i, int j)
	{
		return null;
	}
	
	private Cell getNorthWest(int i, int j)
	{
		return null;
	}
	
	private boolean checkSouthLineForOwner(int i, int j, Cell.Owner owner)
	{
		Cell cell = getSouth(i,j);
		if(cell == null)
		{
			return false;
		}
		
		if(cell.getOwner() == owner)
		{
			return true;
		}
		
		return checkSouthLineForOwner(cell.getI(), cell.getJ(), owner);
	}
	
	private boolean checkSouthWestLineForOwner(int i, int j, Cell.Owner owner)
	{
		return false;
	}
	
	private boolean checkWestLineForOwner(int i, int j, Cell.Owner owner)
	{
		return false;
	}
	
	private boolean checkNorthWestLineForOwner(int i, int j, Cell.Owner owner)
	{
		return false;
	}
	
	private boolean checkNorthLineForOwner(int i, int j, Cell.Owner owner)
	{
		return false;
	}
	
	private boolean checkNorthEastLineForOwner(int i, int j, Cell.Owner owner)
	{
		return false;
	}
	
	private boolean checkEastLineForOwner(int i, int j, Cell.Owner owner)
	{
		return false;
	}
	
	private boolean checkSouthEastLineForOwner(int i, int j, Cell.Owner owner)
	{
		return false;
	}
	
	private boolean neihboorIsAdversary(Cell c, Cell.Owner owner )
	{
		return false;
	}
	
	/**********************************
	 * Variables
	 **********************************/
	
	// Inputs
	private int size;
	
	// Tools 
	private Cell[] cells;
}