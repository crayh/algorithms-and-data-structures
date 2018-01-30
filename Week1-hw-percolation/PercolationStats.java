/*
 * Used to perform a series of computations experiments related to percolation
 * Cole Halverson
*/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private double mean;
	private double stddev;
	private double confidencelo;
	private double confidencehi;
    
    public PercolationStats(int n, int trials){
    	
    }
    
    public double mean(){
    	return this.mean;
    }
    
    public double stddev(){
    	return this.stddev;
    }
    
    public double confidenceLo(){
    	return this.confidencelo;
    }
    
    public double confidenceHi(){
    	return this.confidencehi;
    }
    
    
    public static void main(String[] args){
    	if( args.length != 2 ){
    		String errMsg = "Two arguments required: trials, n";
    		throw new IllegalArgumentException( errMsg );
    	}
    	
    	int n = Integer.parseInt( args[2] );
    	int trials = Integer.parseInt( args[1] );
    	
    	PercolationStats percolationStats = new PercolationStats( n, trials );
    	
    }
    
}

