package Participants.MAEDKU;

import Othello.Move;
import java.util.ArrayList;
import java.util.List;

public class Grid
{
    public static void main(String [ ] args)
    {
		Grid grid = new Grid(8);
		System.out.print(grid.toString());
		
		
		grid.getSouth(1,1).setOwner(Cell.Owner.RED);
		grid.getSouthWest(1,1).setOwner(Cell.Owner.RED);
		grid.getWest(1,1).setOwner(Cell.Owner.RED);
		grid.getNorthWest(1,1).setOwner(Cell.Owner.RED);
		grid.getNorth(1,1).setOwner(Cell.Owner.RED);
		grid.getNorthEast(1,1).setOwner(Cell.Owner.RED);
		grid.getEast(1,1).setOwner(Cell.Owner.RED);
		grid.getSouthEast(1,1).setOwner(Cell.Owner.RED);

		System.out.print(grid.toString());
		
		System.out.println("------------------------");
		System.out.println(grid.getSouth(1,1));
		System.out.println(grid.getSouthWest(1,1));
		System.out.println(grid.getWest(1,1));
		System.out.println(grid.getNorthWest(1,1));
		System.out.println(grid.getNorth(1,1));
		System.out.println(grid.getNorthEast(1,1));
		System.out.println(grid.getEast(1,1));
		System.out.println(grid.getSouthEast(1,1));
		
		System.out.println("------------------------");
		System.out.println(grid.getSouth(0,0));
		System.out.println(grid.getSouthWest(0,0));
		System.out.println(grid.getWest(0,0));
		System.out.println(grid.getNorthWest(0,0));
		System.out.println(grid.getNorth(0,0));
		System.out.println(grid.getNorthEast(0,0));
		System.out.println(grid.getEast(0,0));
		System.out.println(grid.getSouthEast(0,0));
		
		System.out.println("------------------------");
		System.out.println(grid.getSouth(0,7));
		System.out.println(grid.getSouthWest(0,7));
		System.out.println(grid.getWest(0,7));
		System.out.println(grid.getNorthWest(0,7));
		System.out.println(grid.getNorth(0,7));
		System.out.println(grid.getNorthEast(0,7));
		System.out.println(grid.getEast(0,7));
		System.out.println(grid.getSouthEast(0,7));
		
		System.out.println("------------------------");
		System.out.println(grid.getSouth(7,0));
		System.out.println(grid.getSouthWest(7,0));
		System.out.println(grid.getWest(7,0));
		System.out.println(grid.getNorthWest(7,0));
		System.out.println(grid.getNorth(7,0));
		System.out.println(grid.getNorthEast(7,0));
		System.out.println(grid.getEast(7,0));
		System.out.println(grid.getSouthEast(7,0));
		
		System.out.println("------------------------");
		System.out.println(grid.getSouth(7,7));
		System.out.println(grid.getSouthWest(7,7));
		System.out.println(grid.getWest(7,7));
		System.out.println(grid.getNorthWest(7,7));
		System.out.println(grid.getNorth(7,7));
		System.out.println(grid.getNorthEast(7,7));
		System.out.println(grid.getEast(7,7));
		System.out.println(grid.getSouthEast(7,7));
		
		grid = new Grid(8);
		grid.getCell(2,2).setOwner(Cell.Owner.BLUE);
		grid.getCell(2,3).setOwner(Cell.Owner.BLUE);
		grid.getCell(2,4).setOwner(Cell.Owner.BLUE);
		grid.getCell(2,5).setOwner(Cell.Owner.BLUE);
		grid.getCell(2,6).setOwner(Cell.Owner.BLUE);
		grid.getCell(3,2).setOwner(Cell.Owner.BLUE);
		grid.getCell(3,3).setOwner(Cell.Owner.BLUE);
		grid.getCell(3,4).setOwner(Cell.Owner.BLUE);
		grid.getCell(3,5).setOwner(Cell.Owner.BLUE);
		grid.getCell(3,6).setOwner(Cell.Owner.BLUE);
		grid.getCell(4,2).setOwner(Cell.Owner.BLUE);
		grid.getCell(4,3).setOwner(Cell.Owner.BLUE);
		grid.getCell(4,4).setOwner(Cell.Owner.BLUE);
		grid.getCell(4,5).setOwner(Cell.Owner.BLUE);
		grid.getCell(4,6).setOwner(Cell.Owner.BLUE);
		grid.getCell(5,2).setOwner(Cell.Owner.BLUE);
		grid.getCell(5,3).setOwner(Cell.Owner.BLUE);
		grid.getCell(5,4).setOwner(Cell.Owner.BLUE);
		grid.getCell(5,5).setOwner(Cell.Owner.BLUE);
		grid.getCell(5,6).setOwner(Cell.Owner.BLUE);
		grid.getCell(6,2).setOwner(Cell.Owner.BLUE);
		grid.getCell(6,3).setOwner(Cell.Owner.BLUE);
		grid.getCell(6,4).setOwner(Cell.Owner.BLUE);
		grid.getCell(6,5).setOwner(Cell.Owner.BLUE);
		grid.getCell(6,6).setOwner(Cell.Owner.BLUE);
		System.out.println("------------------------");
		System.out.println(grid);
		
		System.out.println(grid.checkSouthLineForOwner(4,4, Cell.Owner.RED));
		grid.getCell(4,7).setOwner(Cell.Owner.RED);
		System.out.println(grid.checkSouthLineForOwner(4,4, Cell.Owner.RED));
		
		System.out.println(grid.checkSouthWestLineForOwner(4,4, Cell.Owner.RED));
		grid.getCell(1,7).setOwner(Cell.Owner.RED);
		System.out.println(grid.checkSouthWestLineForOwner(4,4, Cell.Owner.RED));
		
		System.out.println(grid.checkWestLineForOwner(4,4, Cell.Owner.RED));
		grid.getCell(1,4).setOwner(Cell.Owner.RED);
		System.out.println(grid.checkWestLineForOwner(4,4, Cell.Owner.RED));
		
		System.out.println(grid.checkNorthWestLineForOwner(4,4, Cell.Owner.RED));
		grid.getCell(1,1).setOwner(Cell.Owner.RED);
		System.out.println(grid.checkNorthWestLineForOwner(4,4, Cell.Owner.RED));
		
		System.out.println(grid.checkNorthLineForOwner(4,4, Cell.Owner.RED));
		grid.getCell(4,1).setOwner(Cell.Owner.RED);
		System.out.println(grid.checkNorthLineForOwner(4,4, Cell.Owner.RED));
		
		System.out.println(grid.checkNorthEastLineForOwner(4,4, Cell.Owner.RED));
		grid.getCell(7,1).setOwner(Cell.Owner.RED);
		System.out.println(grid.checkNorthEastLineForOwner(4,4, Cell.Owner.RED));
		
		System.out.println(grid.checkEastLineForOwner(4,4, Cell.Owner.RED));
		grid.getCell(7,4).setOwner(Cell.Owner.RED);
		System.out.println(grid.checkEastLineForOwner(4,4, Cell.Owner.RED));
		
		System.out.println(grid.checkSouthEastLineForOwner(4,4, Cell.Owner.RED));
		grid.getCell(7,7).setOwner(Cell.Owner.RED);
		System.out.println(grid.checkSouthEastLineForOwner(4,4, Cell.Owner.RED));
		System.out.println("");

		grid = new Grid(8);
		grid.getCell(3,3).setOwner(Cell.Owner.BLUE);
		grid.getCell(4,3).setOwner(Cell.Owner.RED);
		grid.getCell(3,4).setOwner(Cell.Owner.RED);
		grid.getCell(4,4).setOwner(Cell.Owner.BLUE);
		System.out.println("------------------------");
		System.out.println(grid);
		
		System.out.println("Valid moves RED: ");
		System.out.println(grid.validMove(2,3, Cell.Owner.RED));
		System.out.println(grid.validMove(3,2, Cell.Owner.RED));
		System.out.println(grid.validMove(5,4, Cell.Owner.RED));
		System.out.println(grid.validMove(4,5, Cell.Owner.RED));
		System.out.println("Invalid moves RED: ");
		System.out.println(grid.validMove(2,2, Cell.Owner.RED));
		System.out.println(grid.validMove(2,4, Cell.Owner.RED));
		System.out.println(grid.validMove(2,5, Cell.Owner.RED));
		System.out.println(grid.validMove(3,5, Cell.Owner.RED));
		System.out.println(grid.validMove(5,5, Cell.Owner.RED));
		System.out.println(grid.validMove(5,3, Cell.Owner.RED));
		System.out.println(grid.validMove(5,2, Cell.Owner.RED));
		System.out.println(grid.validMove(4,2, Cell.Owner.RED));
		
		for(Move move : grid.getPossibleTurns(Cell.Owner.RED))
			System.out.println("( " + move.i + ", " + move.j + " )");
		
		System.out.println("Valid moves BLUE: ");
		System.out.println(grid.validMove(4,2, Cell.Owner.BLUE));
		System.out.println(grid.validMove(2,4, Cell.Owner.BLUE));
		System.out.println(grid.validMove(5,3, Cell.Owner.BLUE));
		System.out.println(grid.validMove(3,5, Cell.Owner.BLUE));
		System.out.println("Invalid moves BLUE: ");
		System.out.println(grid.validMove(2,2, Cell.Owner.BLUE));
		System.out.println(grid.validMove(2,3, Cell.Owner.BLUE));
		System.out.println(grid.validMove(2,5, Cell.Owner.BLUE));
		System.out.println(grid.validMove(4,5, Cell.Owner.BLUE));
		System.out.println(grid.validMove(5,5, Cell.Owner.BLUE));
		System.out.println(grid.validMove(5,4, Cell.Owner.BLUE));
		System.out.println(grid.validMove(5,2, Cell.Owner.BLUE));
		System.out.println(grid.validMove(3,2, Cell.Owner.BLUE));
		
		for(Move move : grid.getPossibleTurns(Cell.Owner.BLUE))
			System.out.println("( " + move.i + ", " + move.j + " )");
		
		grid.addTurn(new Move(4,2), Cell.Owner.BLUE);
		System.out.println("------------------------");
		System.out.println(grid);
		
		System.out.println("BLUE possible turns: ");
		for(Move move : grid.getPossibleTurns(Cell.Owner.BLUE))
			System.out.println("( " + move.i + ", " + move.j + " )");
        
		System.out.println("RED possible turns: ");
		for(Move move : grid.getPossibleTurns(Cell.Owner.RED))
			System.out.println("( " + move.i + ", " + move.j + " )");
		
		
		
		
		grid.addTurn(new Move(5,2), Cell.Owner.RED);
		System.out.println("------------------------");
		System.out.println(grid);
		
		System.out.println("BLUE possible turns: ");
		for(Move move : grid.getPossibleTurns(Cell.Owner.BLUE))
			System.out.println("( " + move.i + ", " + move.j + " )");
        
		System.out.println("RED possible turns: ");
		for(Move move : grid.getPossibleTurns(Cell.Owner.RED))
			System.out.println("( " + move.i + ", " + move.j + " )");
			
		
		grid.addTurn(new Move(5,3), Cell.Owner.BLUE);
		System.out.println("------------------------");
		System.out.println(grid);
		
		System.out.println("BLUE possible turns: ");
		for(Move move : grid.getPossibleTurns(Cell.Owner.BLUE))
			System.out.println("( " + move.i + ", " + move.j + " )");
        
		System.out.println("RED possible turns: ");
		for(Move move : grid.getPossibleTurns(Cell.Owner.RED))
			System.out.println("( " + move.i + ", " + move.j + " )");
			
		
		
		grid.addTurn(new Move(3,2), Cell.Owner.RED);
		System.out.println("------------------------");
		System.out.println(grid);
		
		System.out.println("BLUE possible turns: ");
		for(Move move : grid.getPossibleTurns(Cell.Owner.BLUE))
			System.out.println("( " + move.i + ", " + move.j + " )");
        
		System.out.println("RED possible turns: ");
		for(Move move : grid.getPossibleTurns(Cell.Owner.RED))
			System.out.println("( " + move.i + ", " + move.j + " )");
		
	}

	/**********************************
	 * Constructor
	 **********************************/
	 
	public Grid(int size)
	{
		this.size = size;
		
		initGrid();
	}
	
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
		if(validMove(move.i, move.j, owner))
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
	}

	
	/**********************************
	 * Getter/Setter
	 **********************************/
	 	
	public Cell getCell(int i, int j)
	{
		if(0 <= i && i < this.cells.length
			&& 0 <= j && j < this.cells[i].length )
		{
			return cells[i][j];
		}
		
		return null;
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