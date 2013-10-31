package Participants.MAEDKU;

import Othello.Move;
import java.util.ArrayList;
import java.util.List;

/**
 * A grid represents a othello playing field with a variable size.
 *
 * The grid is initialized by default with all the cells to a UNDEFined owner.
 * Moves can be applied to an existant grid with the method addTurn(...).
 * 
 * @author: David Kuehner (david.kuehner@he-arc.ch), Marco Aeberli (marco.aeberli@he-arc.ch)
 */
public class Grid
{
	/**********************************
	 * Constructor
	 **********************************/
	 
	public Grid(int size)
	{
		this.size = size;
		
		// Create the cells and set them to a UNDEF owner.
		initGrid();
	}
	
	/**
	 * Copy constructor allows to create a deep copy of a grid.
	 */
	public Grid(Grid grid)
	{
		this.size = grid.size;
		
		this.cells = new Cell[this.size][this.size];
			
		for(int j = 0; j < this.size; j++)
		{
			for(int i = 0; i < this.size; ++i)
			{
				this.cells[i][j] = new Cell(grid.cells[i][j]);
			}
		}
	}
	
	/**********************************
	 * Public methods
	 **********************************/
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		if(cells.length>0)
		{
			sb.append(" ");
			for(int j = 0; j < cells[0].length; j++)
				sb.append("|" + j);
			sb.append("\n");
		}
		
		for(int j = 0; j < cells.length; ++j)
		{
			sb.append(j);
			for(int i = 0; i < cells[j].length; ++i)
			{
				switch(cells[i][j].getOwner())
				{
				case RED:
					sb.append("|R");
					break;
				case BLUE:
					sb.append("|B");
					break;
				case UNDEF:
					sb.append("| ");
					break;
				default:
					break;
				}
				
			}
			sb.append("|\n");
		}
		sb.append("\n");
		
		return sb.toString();
	}
	
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
		
		
		for(int j = 0; j < cells.length; ++j)
		{
			for(int i = 0; i < cells[j].length; ++i)
			{
				if(validMove(i, j, owner))
				{
					ops.add(new Move(i,j));
				}
			}
		}
		
		return ops;
	}
	
	public boolean validMove(int i, int j, Cell.Owner owner)
	{
		Cell.Owner adversary = Cell.getAdversary(owner);
		
		if(getCell(i, j) == null || getCell(i,j).getOwner() != Cell.Owner.UNDEF)
			return false;

		if(getSouth(i, j) != null && getSouth(i, j).getOwner() == adversary)
		{
			if(checkSouthLineForOwner(i, j, owner))
			{
				return true;
			}
		}
		if(getSouthWest(i, j) != null && getSouthWest(i, j).getOwner() == adversary)
		{
			if(checkSouthWestLineForOwner(i, j, owner))
			{
				return true;
			}
		}
		if(getWest(i, j) != null && getWest(i, j).getOwner() == adversary)
		{
			if(checkWestLineForOwner(i, j, owner))
			{
				return true;
			}
		}
		if(getNorthWest(i, j) != null && getNorthWest(i, j).getOwner() == adversary)
		{
			if(checkNorthWestLineForOwner(i, j, owner))
			{
				return true;
			}
		}
		if(getNorth(i, j) != null && getNorth(i, j).getOwner() == adversary)
		{
			if(checkNorthLineForOwner(i, j, owner))
			{
				return true;
			}
		}
		if(getNorthEast(i, j) != null && getNorthEast(i, j).getOwner() == adversary)
		{
			if(checkNorthEastLineForOwner(i, j, owner))
			{
				return true;
			}
		}
		if(getEast(i, j) != null && getEast(i, j).getOwner() == adversary)
		{
			if(checkEastLineForOwner(i, j, owner))
			{
				return true;
			}
		}
		if(getSouthEast(i, j) != null && getSouthEast(i, j).getOwner() == adversary)
		{
			if(checkSouthEastLineForOwner(i, j, owner))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void addTurn(Move move, Cell.Owner owner)
	{
		Cell cell = getCell(move.i, move.j);
		
		if(cell != null)
		{
			cell.setOwner(owner);
			
			swapNorthCells(cell, owner);
			swapNorthEastCells(cell, owner);
			swapEastCells(cell, owner);
			swapSouthEastCells(cell, owner);
			swapSouthCells(cell, owner);
			swapSouthWestCells(cell, owner);
			swapWestCells(cell, owner);
			swapNorthWestCells(cell, owner);
		}
	}
	
	/**
	 * @return Returns true if the Cell (i,j) is one of the four edges.
	 */
	public boolean isEdge(int i, int j)
	{
		return( i == 0 || 
				i == size-1 ||
				j == 0 ||
				j == size -1 );
	}

	public boolean isEndingState()
	{
		// Ending State: two cells in the corners with the same color
		int n = size-1;
		return (
				   (getCell(0,0).getOwner() == getCell(n,0).getOwner() && getCell(0,0).getOwner() != Cell.Owner.UNDEF )
				|| (getCell(0,0).getOwner() == getCell(n,n).getOwner() && getCell(0,0).getOwner() != Cell.Owner.UNDEF )
				|| (getCell(0,0).getOwner() == getCell(0,n).getOwner() && getCell(0,0).getOwner() != Cell.Owner.UNDEF )
				|| (getCell(n,0).getOwner() == getCell(n,n).getOwner() && getCell(n,0).getOwner() != Cell.Owner.UNDEF )
				|| (getCell(n,0).getOwner() == getCell(0,n).getOwner() && getCell(n,0).getOwner() != Cell.Owner.UNDEF )
				|| (getCell(n,n).getOwner() == getCell(0,n).getOwner() && getCell(n,n).getOwner() != Cell.Owner.UNDEF )
				);
	}
	
	public boolean isMiddleState()
	{
		// Middle State: at least one cell on the edge not empty.
		for(int j = 0; j<size; j++)
		{
			if(getCell(0,j).getOwner() != Cell.Owner.UNDEF
				|| getCell(size-1,j).getOwner() != Cell.Owner.UNDEF)
				return true;
		}
		
		for(int i = 0; i<size; i++)
		{
			if(getCell(i,0).getOwner() != Cell.Owner.UNDEF
				|| getCell(i,size-1).getOwner() != Cell.Owner.UNDEF)
				return true;
		}
		
		return false;
	}
	
	public int boundaryLevel(int i, int j)
	{
		int count = 0;
		
		Cell cell = getNorth(i,j);
		if ( cell != null )
			if (cell.getOwner() == Cell.Owner.UNDEF )
				count++;
		
		cell = getSouth(i,j);
		if( cell != null )
			if ( cell.getOwner() == Cell.Owner.UNDEF )
				count++;
				
		cell = getEast(i,j);
		if( cell != null)
			if ( cell.getOwner() == Cell.Owner.UNDEF )
				count++;
				
		cell = getWest(i,j);
		if( cell != null)
			if ( cell.getOwner() == Cell.Owner.UNDEF )
				count++;
		
		return count;
	}
	 	
	public Cell getCell(int i, int j)
	{
		if(0 <= i && i < this.cells.length
			&& 0 <= j && j < this.cells[i].length )
		{
			return cells[i][j];
		}
		
		return null;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public int countCellOfOwner(Cell.Owner owner)
    {
        int count = 0;
        for(int j = 0; j < size; j++)
        {
            for(int i = 0; i < size; i++)
            {
                if(getCell(i, j).getOwner() == owner)
                    count++;
            }
        }
        return count;
    }
	
	public boolean isCountOfEmptyCellOdd()
    {
        return countOfEmptyCell() % 2 != 0;
    }
	
	public int countOfEmptyCell()
    {
        int count = 0;
        for(int j = 0; j < size; j++)
        {
            for(int i = 0; i < size; i++)
            {
                if(getCell(i, j).getOwner() == Cell.Owner.UNDEF)
                    count++;
            }
        }
        return count;
    }
	 	
	/**********************************
	 * private methods
	 **********************************/
	
	private void initGrid()
	{
		cells = new Cell[this.size][this.size];
		for(int i = 0; i < this.size; ++i)
		{
			for(int j = 0; j < this.size; j++)
			{
				this.cells[i][j] = new Cell(i, j);
			}
		}
	}
	
	private Cell getNorth(int i, int j)
	{
		return getCell(i, j-1);
	}
	
	private Cell getNorthEast(int i, int j)
	{
		return getCell(i+1, j-1);
	}
	
	private Cell getEast(int i, int j)
	{
		return getCell(i+1, j);
	}
	
	private Cell getSouthEast(int i, int j)
	{
		return getCell(i+1, j+1);
	}
	
	private Cell getSouth(int i, int j)
	{
		return getCell(i, j+1);
	}

	private Cell getSouthWest(int i, int j)
	{
		return getCell(i-1, j+1);
	}
	
	private Cell getWest(int i, int j)
	{
		return getCell(i-1, j);
	}
	
	private Cell getNorthWest(int i, int j)
	{
		return getCell(i-1, j-1);
	}
	
	private boolean checkSouthLineForOwner(int i, int j, Cell.Owner owner)
	{
		Cell cell = getSouth(i,j);
		if(cell == null)
			return false;
		else if(cell.getOwner() == owner)
			return true;
		else if(cell.getOwner() != Cell.Owner.UNDEF)
			return checkSouthLineForOwner(cell.getI(), cell.getJ(), owner);
		else
			return false;
	}
	
	private boolean checkSouthWestLineForOwner(int i, int j, Cell.Owner owner)
	{
		Cell cell = getSouthWest(i,j);
		if(cell == null)
			return false;
		else if(cell.getOwner() == owner)
			return true;
		else if(cell.getOwner() != Cell.Owner.UNDEF)
			return checkSouthWestLineForOwner(cell.getI(), cell.getJ(), owner);
		else
			return false;
	}
	
	private boolean checkWestLineForOwner(int i, int j, Cell.Owner owner)
	{
		Cell cell = getWest(i,j);
		if(cell == null)
			return false;
		else if(cell.getOwner() == owner)
			return true;
		else if(cell.getOwner() != Cell.Owner.UNDEF)
			return checkWestLineForOwner(cell.getI(), cell.getJ(), owner);
		else
			return false;
	}
	
	private boolean checkNorthWestLineForOwner(int i, int j, Cell.Owner owner)
	{
		Cell cell = getNorthWest(i,j);
		if(cell == null)
			return false;
		else if(cell.getOwner() == owner)
			return true;
		else if(cell.getOwner() != Cell.Owner.UNDEF)
			return checkNorthWestLineForOwner(cell.getI(), cell.getJ(), owner);
		else
			return false;
	}
	
	private boolean checkNorthLineForOwner(int i, int j, Cell.Owner owner)
	{
		Cell cell = getNorth(i,j);
		if(cell == null)
			return false;
		else if(cell.getOwner() == owner)
			return true;
		else if(cell.getOwner() != Cell.Owner.UNDEF)
			return checkNorthLineForOwner(cell.getI(), cell.getJ(), owner);
		else
			return false;
	}
	
	private boolean checkNorthEastLineForOwner(int i, int j, Cell.Owner owner)
	{
		Cell cell = getNorthEast(i,j);
		if(cell == null)
			return false;
		else if(cell.getOwner() == owner)
			return true;
		else if(cell.getOwner() != Cell.Owner.UNDEF)
			return checkNorthEastLineForOwner(cell.getI(), cell.getJ(), owner);
		else
			return false;
	}
	
	private boolean checkEastLineForOwner(int i, int j, Cell.Owner owner)
	{
		Cell cell = getEast(i,j);
		if(cell == null)
			return false;
		else if(cell.getOwner() == owner)
			return true;
		else if(cell.getOwner() != Cell.Owner.UNDEF)
			return checkEastLineForOwner(cell.getI(), cell.getJ(), owner);
		else
			return false;
	}
	
	private boolean checkSouthEastLineForOwner(int i, int j, Cell.Owner owner)
	{
		Cell cell = getSouthEast(i,j);
		if(cell == null)
			return false;
		else if(cell.getOwner() == owner)
			return true;
		else if(cell.getOwner() != Cell.Owner.UNDEF)
			return checkSouthEastLineForOwner(cell.getI(), cell.getJ(), owner);
		else
			return false;
	}
	
	private boolean swapNorthCells(Cell cell, Cell.Owner targetOwner)
	{
		Cell next = getNorth(cell.getI(), cell.getJ());
		Cell.Owner adversary = Cell.getAdversary(targetOwner);
		
		if(next == null)
			return false;
			
		if(next.getOwner() == adversary)
		{
			boolean adversaryFound = swapNorthCells(next, targetOwner);
			
			if(adversaryFound)
				next.setOwner(targetOwner);
			
			return adversaryFound;
		}
		
		return (next.getOwner() == targetOwner);
	}
	
	private boolean swapNorthEastCells(Cell cell, Cell.Owner targetOwner)
	{
		Cell next = getNorthEast(cell.getI(), cell.getJ());
		Cell.Owner adversary = Cell.getAdversary(targetOwner);
		
		if(next == null)
			return false;
			
		if(next.getOwner() == adversary)
		{
			boolean adversaryFound = swapNorthEastCells(next, targetOwner);
			
			if(adversaryFound)
				next.setOwner(targetOwner);
			
			return adversaryFound;
		}
		
		return (next.getOwner() == targetOwner);
	}
	
	private boolean swapEastCells(Cell cell, Cell.Owner targetOwner)
	{
		Cell next = getEast(cell.getI(), cell.getJ());
		Cell.Owner adversary = Cell.getAdversary(targetOwner);
		
		if(next == null)
			return false;
			
		if(next.getOwner() == adversary)
		{
			boolean adversaryFound = swapEastCells(next, targetOwner);
			
			if(adversaryFound)
				next.setOwner(targetOwner);
			
			return adversaryFound;
		}
		
		return (next.getOwner() == targetOwner);
	}
	
	private boolean swapSouthEastCells(Cell cell, Cell.Owner targetOwner)
	{
		Cell next = getSouthEast(cell.getI(), cell.getJ());
		Cell.Owner adversary = Cell.getAdversary(targetOwner);
		
		if(next == null)
			return false;
			
		if(next.getOwner() == adversary)
		{
			boolean adversaryFound = swapSouthEastCells(next, targetOwner);
			
			if(adversaryFound)
				next.setOwner(targetOwner);
			
			return adversaryFound;
		}
		
		return (next.getOwner() == targetOwner);
	}
	
	private boolean swapSouthCells(Cell cell, Cell.Owner targetOwner)
	{
		Cell next = getSouth(cell.getI(), cell.getJ());
		Cell.Owner adversary = Cell.getAdversary(targetOwner);
		
		if(next == null)
			return false;
			
		if(next.getOwner() == adversary)
		{
			boolean adversaryFound = swapSouthCells(next, targetOwner);
			
			if(adversaryFound)
				next.setOwner(targetOwner);
			
			return adversaryFound;
		}
		
		return (next.getOwner() == targetOwner);
	}
	
	private boolean swapSouthWestCells(Cell cell, Cell.Owner targetOwner)
	{
		Cell next = getSouthWest(cell.getI(), cell.getJ());
		Cell.Owner adversary = Cell.getAdversary(targetOwner);
		
		if(next == null)
			return false;
			
		if(next.getOwner() == adversary)
		{
			boolean adversaryFound = swapSouthWestCells(next, targetOwner);
			
			if(adversaryFound)
				next.setOwner(targetOwner);
			
			return adversaryFound;
		}
		
		return (next.getOwner() == targetOwner);
	}
	
	private boolean swapWestCells(Cell cell, Cell.Owner targetOwner)
	{
		Cell next = getWest(cell.getI(), cell.getJ());
		Cell.Owner adversary = Cell.getAdversary(targetOwner);
		
		if(next == null)
			return false;
			
		if(next.getOwner() == adversary)
		{
			boolean adversaryFound = swapWestCells(next, targetOwner);
			
			if(adversaryFound)
				next.setOwner(targetOwner);
			
			return adversaryFound;
		}
		
		return (next.getOwner() == targetOwner);
	}
	
	private boolean swapNorthWestCells(Cell cell, Cell.Owner targetOwner)
	{
		Cell next = getNorthWest(cell.getI(), cell.getJ());
		Cell.Owner adversary = Cell.getAdversary(targetOwner);
		
		if(next == null)
			return false;
			
		if(next.getOwner() == adversary)
		{
			boolean adversaryFound = swapNorthWestCells(next, targetOwner);
			
			if(adversaryFound)
				next.setOwner(targetOwner);
			
			return adversaryFound;
		}
		
		return (next.getOwner() == targetOwner);
	}
	
	/**********************************
	 * Variables
	 **********************************/
	
	// Inputs
	private int size;
	
	// Tools 
	private Cell[][] cells;
			//   \ \
			//    \ \- line/row index
			//     \- column index
}