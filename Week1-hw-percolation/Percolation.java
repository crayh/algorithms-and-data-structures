/*
 * Class to simulate Percolation to perform the Monte-Carlo experiment
 * Cole Halverson
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    
    private int[][] grid;
    private int openSites = 0;
    private WeightedQuickUnionUF wquuf;
    
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
        
        /*
         * Instantiate WeightedQuickUnionFind object to track connections between sites and 
         * check for percolation.  n*n+2 sites are created to account for two virtual sites, (0)
         * and (n+1).
         * Sites located in the top or bottom rows of the grid are connected to the top or 
         * bottom virtual site, respectively, upon being opened.  This method makes checking for
         * percolation more economical.    
         */
        wquuf = new WeightedQuickUnionUF( n*n+2 );
        
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

    
