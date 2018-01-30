/*
 * Class to simulate Percolation to perform the Monte-Carlo experiment
 * Cole Halverson
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    
    private int[][] grid;
    private int openSites = 0;
    
    /*
     * Constructor.  Creates an n-by-n "grid" via 2d array.  Java defaults 
     * element values to 0.
     */
    Percolation(int n){
        if( n <= 0 ) {
        	String errMsg = "N must be greater than 0";
        	throw new IllegalArgumentException( errMsg );
        }
        grid = new int[n][n];
    }
    
    /*
     * Opens the site at (row, col) if not already open
     */
    public void open(int row, int col){
        checkArguments(row, col);
        
        if( !isOpen(row, col) ){ 
            grid[row][col] = 1; 
            openSites++;
        }
    }
    
    public boolean isOpen(int row, int col){
        checkArguments(row, col);
        return grid[row][col] == 1;
    }
    
    public boolean isFull(int row, int col){
        checkArguments(row, col);
        return grid[row][col] == 0;
    }
    
    private void checkArguments(int row, int col){
        if( row > grid.length || col > grid.length ){
        	String errMsg = "Arguments out of bounds of array.";
            throw new IllegalArgumentException( errMsg );
        }
    }
    
    public int numberOfOpenSites(){
        return openSites;
    }
    
    /*
     * Does the system percolate?
     */
    public boolean percolates(){
        
    	return true;
    }
    
    /*
     * Test client
     */
    public static void main(String[] args){
        
    }
    
    
    
}

    
