/*
 * Class to simulate Percolation to perform the Monte-Carlo experiment
 * Cole Halverson
 */

//import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    
    private int[][] grid;
    private int openSites = 0;
    private final WeightedQuickUnionUF wquuf;
    private final int topVirtualSite;
    private final int bottomVirtualSite;
    
    /**
     * Initializes an n-by-n grid of completely full sites
     * @param n
     */
    public Percolation(int n) {
        if(n <= 0) {
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
        int totalSites = (n*n)+2;
        wquuf = new WeightedQuickUnionUF(totalSites);
        
        topVirtualSite = totalSites - 2;
        bottomVirtualSite = totalSites - 1;
    }
    
    /**
     * Opens the given site in the system
     * @param row
     * @param col
     * @throws IllegalArgumentException unless {@code 0 <= row < n} 
     * 	or {@code 0 <= col < n}
     */
    public void open(int row, int col){
    	row--;
    	col--;
        checkArguments(row, col);
        
        if(grid[row][col] != 1){ 
            grid[row][col] = 1; 
            
            openSites++;
            
            int site = getSite(row,col);
            
            //Connect to adjacent open sites
            //above
            if( row==0 ){ wquuf.union(site, topVirtualSite); }
            else{
            	if(grid[row-1][col] == 1){
            		wquuf.union(site, getSite(row-1, col));
            	}
            }
            //below
            if( row==grid.length-1 ){ wquuf.union(site, bottomVirtualSite); }
            else{
            	if(grid[row+1][col] == 1){
            		wquuf.union(site, getSite(row+1, col));
            	}
            }
            //left
            if( col>0 ){
            	if(grid[row][col-1] == 1){
            		wquuf.union(site, getSite(row, col-1));
            	}
            }
            //right
            if( col<grid.length-1 ){
            	if(grid[row][col+1] == 1){
            		wquuf.union(site, getSite(row, col+1));
            	}
            }
        }
    }
    
    /**
     * Checks if a given site is open.
     * @param row
     * @param col
     * @return
     * @throws IllegalArgumentException unless {@code 0 <= row < n} 
     * 	or {@code 0 <= col < n}
     */
    public boolean isOpen(int row, int col) {
    	row--;
    	col--;
        checkArguments(row, col);
        return grid[row][col] == 1;
    }
    
    /**
     * Checks if a given site is full.  I believe that means the site is open and connected
     * to the top.
     * @param row
     * @param col
     * @return
     * @throws IllegalArgumentException unless {@code 0 <= row < n} 
     * 	or {@code 0 <= col < n}
     */
    public boolean isFull(int row, int col) {
    	row--;
    	col--;
        checkArguments(row, col);
        
        if(grid[row][col] != 0 && wquuf.connected(getSite(row, col), topVirtualSite)) {
        	return true;
        }
       
        return false;
    }
    
    /**
     * 
     * @return number of open sites in the system
     */
    public int numberOfOpenSites() {
        return openSites;
    }
    
    /**
     * Checks if the system percolates
     * @return
     */
    public boolean percolates() {
        return wquuf.connected(topVirtualSite, bottomVirtualSite);
    }
    
   /**
     * Test client
     */
    public static void main(String[] args) {
    	
        // left blank intentionally
    	
    }  
    
    private void checkArguments(int row, int col) {
        if(row < 0 || col < 0 || row > grid.length || col > grid.length) {
        	String errMsg = "Arguments out of bounds of array.";
            throw new IllegalArgumentException(errMsg);
        }
    }
    
    /**
     * 
     * @param row
     * @param col
     * @return the wquuf site corresponding to the given index in the percolation grid
     */
    private int getSite(int row, int col) {
    	return row*grid.length + col;
    }
    
}

    
