/*
 * Class to simulate Percolation to perform the Monte-Carlo experiment
 * Cole Halverson
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class Percolation{
    
    int[][] grid;
    int openSites;
    
    /*
     * Constructor.  Creates an n-by-n "grid" via 2d array.  Java defaults 
     * element values to 0.
     */
    Percolation(int n){
        if( n <= 0 ) { throw new IllegalArgumentException(); }
        grid = new int[n][n];
        openSites = 0;
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
           throw new IllegalArgumentException();
        }
    }
    
    public int numberOfOpenSites(){
        return openSites;
    }
    
    /*
     * Does the system percolate?
     */
    public boolean percolates(){
        
    }
    
    
    
    
    
    /*
     * Test client
     */
    public static void main(String[] args){
        
    }
    
    
    
}

    
