/*
 * Used to perform a series of computations experiments related to percolation
 * Cole Halverson
*/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private final double[] thresholds;
	private static final double CONFIDENCE_95 = 1.96;
    
    public PercolationStats(int n, int trials){
   
    	thresholds = new double[trials];
    	for(int i = 0; i < trials; i++) {
    		
    		Percolation percolation = new Percolation(n);
    		
    		while(!percolation.percolates()) {
    			percolation.open(StdRandom.uniform(1,n+1), StdRandom.uniform(1,n+1));
    		}
    		
    		thresholds[i] = (double) percolation.numberOfOpenSites() / (n*n);
    		
    	}	
    }
    
    public double mean() {
    	return StdStats.mean(thresholds);
    }
    
    public double stddev() {
    	return StdStats.stddev(thresholds);
    }
    
    public double confidenceLo() {
    	return mean() - CONFIDENCE_95 * (stddev() / Math.sqrt(thresholds.length));
    }
    
    public double confidenceHi() {
    	return mean() + CONFIDENCE_95 * (stddev() / Math.sqrt(thresholds.length));
    }
    
    
    public static void main(String[] args) {
    	if(args.length != 2) {
    		String errMsg = "Two arguments required: n, trials";
    		throw new IllegalArgumentException(errMsg);
    	}
    	
    	int n = Integer.parseInt(args[0]);
    	int trials = Integer.parseInt(args[1]);
    	
    	if(n <= 0 || trials <= 0) {
    		String errMsg = "n and trials must be greater than 0.";
    		throw new IllegalArgumentException(errMsg);
    	}
    	
    	PercolationStats percolationStats = new PercolationStats(n, trials);
    	
    	//Print stats
    	System.out.println("mean = " + percolationStats.mean());
    	System.out.println("stddev = " + percolationStats.stddev());
    	System.out.println("95% conficence interval = " + "[" + 
    			percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");
    }
    
}

