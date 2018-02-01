/*
 * Class to simulate Percolation to perform the Monte-Carlo experiment
 * Cole Halverson
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    
    private int[][] grid;
    private int openSites = 0;
    private WeightedQuickUnionUF wquuf;
    private int topVirtualSite;
    private int bottomVirtualSite;
    
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
        int totalSites = n*n+2;
        wquuf = new WeightedQuickUnionUF( totalSites );
        
        topVirtualSite = totalSites - 1;
        bottomVirtualSite = totalSites;
        
    }
    
    /*
     * Opens the site at (row, col) if not already open
     */
    public void open(int row, int col){
        checkArguments(row, col);
        
        if( !isOpen(row, col) ){ 
            grid[row][col] = 1; 
            
            openSites++;
            
            int site = getSite(row,col);
            
            //Connect to adjacent open sites
            //above
            if( row==0 ){ wquuf.union(site, topVirtualSite); }
            else{
            	if( isOpen(row-1, col) ){
            		wquuf.union(site, getSite(row-1, col));
            	}
            }
            //below
            if( row==grid.length-1 ){ wquuf.union(site, bottomVirtualSite); }
            else{
            	if( isOpen(row+1, col) ){
            		wquuf.union(site, getSite(row+1, col));
            	}
            }
            //left
            if( col>0 ){
            	if( isOpen(row, col-1) ){
            		wquuf.union(site, getSite(row, col-1));
            	}
            }
            //right
            if( col<grid.length-1 ){
            	if( isOpen(row, col+1) ){
            		wquuf.union(site, getSite(row, col+1));
            	}
            }
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
    
    public int numberOfOpenSites(){
        return openSites;
    }
    
    /*
     * Does the system percolate?
     */
    public boolean percolates(){
        return wquuf.connected(topVirtualSite, bottomVirtualSite);
    }
    
    /*
     * Test client
     */
    public static void main(String[] args){
        
    }  
    
    private void checkArguments(int row, int col){
        if( row < 0 || col < 0 || row > grid.length || col > grid.length ){
        	String errMsg = "Arguments out of bounds of array.";
            throw new IllegalArgumentException( errMsg );
        }
    }
    
    /**
     * 
     * @param row
     * @param col
     * @return the wquuf site corresponding to the given index in the percolation grid
     */
    private int getSite(int row, int col){
    	return row*grid.length + col;
    }
    
}

    
