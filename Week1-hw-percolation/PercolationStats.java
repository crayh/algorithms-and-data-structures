/*
 * Used to perform a series of computations experiments related to percolation
 * Cole Halverson
*/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private int[] thresholds;
    
    public PercolationStats(int n, int trials){
    	for( int i = 0; i < trials; i++){
    		thresholds = new int[trials];
    		
    		Percolation percolation = new Percolation(n);
    		
    		while( ! percolation.percolates() ){
    			percolation.open(StdRandom.uniform(n), StdRandom.uniform(n));
    		}
    		
    		thresholds[i] = percolation.numberOfOpenSites();
    	}
    	
    }
    
    public double mean(){
    	return StdStats.mean(thresholds);
    }
    
    public double stddev(){
    	return StdStats.stddev(thresholds);
    }
    
    public double confidenceLo(){
    	return this.confidencelo;
    }
    
    public double confidenceHi(){
    	return this.confidencehi;
    }
    
    
    public static void main(String[] args){
    	if( args.length != 2 ){
    		String errMsg = "Two arguments required: n, trials";
    		throw new IllegalArgumentException( errMsg );
    	}
    	
    	int n = Integer.parseInt( args[0] );
    	int trials = Integer.parseInt( args[1] );
    	
    	if( n <= 0 || trials <= 0 ){
    		String errMsg = "n and trials must be greater than 0.";
    		throw new IllegalArgumentException( errMsg );
    	}
    	
    	PercolationStats percolationStats = new PercolationStats( n, trials );
    	
    }
    
}

