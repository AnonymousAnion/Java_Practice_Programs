import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.Collections;
import java.util.function.Predicate;

public class Filter {
	
	private final ArrayList <Double> filter;
	private double startTime = 0.0;
	private double duration = 0.0;
	
	/**
	 * @author Liam
	 * Default Constructor with a sample size of 11 data points
	 */
	public Filter() {
		
		filter = new ArrayList<Double>(11);
	}
	
	/**
	 * @author Liam
	 * @param sampleSize the number of data points to be sampled
	 */
	public Filter(int sampleSize) {
		
		filter = new ArrayList<Double>(sampleSize);
	}
	
	/**
	 * @author Liam
	 * @param startTime the clock time
	 * @param duration the duration over which data is sampled
	 */
	public Filter(double startTime, double duration) {
		
		this();
		this.startTime = startTime;
		this.duration = duration;
	}
	
	/**
	 * @author Liam
	 * @param duration the duration over which data is sampled
	 */
	public Filter(double duration) {
		
		this();
		this.duration = duration;
	}
	
	/**
	 * @author Liam
	 * @param values an array of sequence of parameter values
	 * a vararg constructor which takes in an array or a sequence of values to construct a filter
	 */
	public Filter(double... values) {
		
		filter = new ArrayList<Double>();
		
		for (Double data: values) {
			
			filter.add(data);
		}
	}
	
	/**
	 *@author Liam
	 *@param aL the array list to copy the contents of aL2. aL gets cleared().
	 *@param aL2 the array list to be copied
	 */
	public static void copyListContents(ArrayList <Double> aL, ArrayList <Double> aL2) {
		
		aL.clear();
		
		for (Double data: aL2) {
			
			aL.add(data);
		}
	}
	
	/**
	 *@author Liam
	 *@param aL the array list to copy the contents of aL2. aL gets cleared().
	 *@param aL2 the array list to be copied
	 *@throws IllegalArgumentException when the number of data points is less than zero. You can't copy fewer than zero data points.
	 */
	public static void copyListContents(ArrayList <Double> aL, ArrayList <Double> aL2, int numDataPoints) throws IllegalArgumentException {
		
		if (numDataPoints < 0) {
			
			throw new IllegalArgumentException("Number of data points cannot be less than zero");
		}
		
		if (numDataPoints > aL2.size()) {
			
			copyListContents(aL, aL2);
		}
		else {
			
			aL.clear();
			
			for (int i = aL2.size() - numDataPoints; i < aL2.size(); i++) {
				
				aL.add(aL2.get(i));
			}
		}
	}
	
	/**
	 * @author Liam
	 * @param value the value added to the sample
	 */
	public void update(double value) {
		
		if (filter.size() > 20) {
			
			filter.remove(0);
		}
		
		filter.add(value);
	}
	
	/**
	 * @author Liam
	 * clears the contents of the filter
	 */
	public void clear() {
		
		filter.clear();
	}
	
	/**
	 * @author Liam
	 * removes elements based on lambda expression
	 */
	public void removeIf(Predicate<Double> p) {
		
		filter.removeIf(p);
	}
	
	/**
	 * @author Liam
	 * @return the size of the sample
	 */
	public int getSize() {
		
		return filter.size();
	}
	
	/**
	 * @author Liam
	 * @param index the index in the sample
	 * @return the value at the index in the sample
	 */
	public double get(int index) {
		
		return filter.get(index);
	}
	
	/**
	 * @author Liam
	 * @return the first most frequently occurring value in the sample
	 */
	public double getMode() {
		
		ArrayList <Double> sample = new ArrayList<Double>();
		
		copyListContents(sample, filter);
		Collections.sort(sample);
		
		short modeIndex = 0;
		short freq = 1;
		short valFreq = 0;
		for (int i = 1; i < sample.size(); i++) {
			
			if (sample.get(i).equals(sample.get(i-1))) {
				
				freq++;
				
				if (freq > valFreq) {
					
					valFreq = freq;
					modeIndex = (short) (i-1);
				}
			}
			else {
				
				if (freq > valFreq) {
					
					valFreq = freq;
					modeIndex = (short) (i-1);
				}
				
				freq = 1;
			}
		}
		
		return sample.get(modeIndex);
	}
	
	/**
	 * @author Liam
	 * @param numDataPoints the number of recent data points to use
	 * @return the first most frequently occurring value in the sample
	 */
	public double getMode(int numDataPoints) {
		
		if (numDataPoints > filter.size()) {
			
			return getMode();
		}
		else {
			
			ArrayList <Double> sample = new ArrayList<Double>();
			
			copyListContents(sample, filter, numDataPoints);
			Collections.sort(sample);
			
			short modeIndex = 0;
			short freq = 1;
			short valFreq = 0;
			
			for (int i = 1; i < sample.size(); i++) {
				
				if (sample.get(i).equals(sample.get(i-1))) {
					
					freq++;
					
					if (freq > valFreq) {
						
						valFreq = freq;
						modeIndex = (short) (i-1);
					}
				}
				else {
					
					if (freq > valFreq) {
						
						valFreq = freq;
						modeIndex = (short) (i-1);
					}
					
					freq = 1;
				}
			}
			
			return sample.get(modeIndex);
		}
	}
	
	/**
	 * @author Liam
	 * @return the median value of the sample
	 */
	public double getMedian() {
		
		ArrayList <Double> sample = new ArrayList<Double>();
		
		copyListContents(sample, filter);
		Collections.sort(sample);
		
		if ((sample.size() % 2) == 1) {
			
			return sample.get((int)(sample.size()/2));
		}
				
		return (sample.get((int) (sample.size()/2)) + sample.get((int) (sample.size()/2)-1))/2;
	}
	
	/**
	 * @author Liam
	 * @param numDataPoints the number of recent data points to use
	 * @return the median value of the sample
	 */
	public double getMedian(int numDataPoints) {
		
			ArrayList <Double> sample = new ArrayList<Double>();
			
			copyListContents(sample, filter, numDataPoints);
			Collections.sort(sample);
			
			if ((sample.size() % 2) == 1) {
				
				return sample.get((int)(sample.size()/2));
			}
					
			return (sample.get((int) (sample.size()/2)) + sample.get((int) (sample.size()/2)-1))/2;
	}
	
	/**
	 * @author Liam
	 * @return the average value of the sample
	 */
	public double getMean() {
		
		double sum = 0.0;
		
		for (int i = 0; i < filter.size(); i ++) {
			
			sum += filter.get(i);
		}
		
		return sum / filter.size();
	}
	
	/**
	 * @author Liam
	 * @param numDataPoints the number of recent data points to use
	 * @return the average value of the most recent number of data points specified
	 */
	public double getMean(int numDataPoints) {
		
		if (numDataPoints > filter.size()) {
			
			return getMean();
		}
		else {
			
			double sum = 0.0;
			
			for (int i = filter.size() - numDataPoints; i < filter.size(); i++) {
				
				sum += filter.get(i);
			}
			
			return sum / numDataPoints;
		}
	}
	
	/**
	 * @author Liam
	 * @param p lambda expression to filter outliers
	 * @return the mean of the smaple with outliers removed based on lambda expression
	 */
	public double getMean(Predicate<Double> p) {
		
		ArrayList <Double> sample = new ArrayList<Double>();
		double sum = 0.0;
		
		copyListContents(sample, filter);
		Collections.sort(sample);
		
		sample.removeIf(p);
		
		//Debug
		System.out.println(sample);
		
		for (int i = 0; i < sample.size(); i ++) {
			
			sum += sample.get(i);
		}
		
		return sum / sample.size();
	}
	
	/**
	 * @author Liam
	 * @param numDataPoints the number of recent data points to use
	 * @return the average value of the most recent number of data points specified
	 * Note: If you're using other methods for the lambda, make sure to use the overloaded version with numDataPoints
	 */
	public double getMean(Predicate<Double> p, int numDataPoints) {
		
		ArrayList <Double> sample = new ArrayList<Double>();
		
		if (numDataPoints > filter.size()) {
			
			return getMean(p);
		}
		else {
			
			double sum = 0.0;
			copyListContents(sample, filter, numDataPoints);
			Collections.sort(sample);
			
			sample.removeIf(p);
			
			if (numDataPoints > sample.size()) {
				
				for (int i = 0; i < sample.size(); i ++) {
					
					sum += sample.get(i);
				}
				
				return sum / sample.size();
			}
			else{
				
				for (int i = sample.size() - numDataPoints; i < sample.size(); i++) {
					
					sum += sample.get(i);
				}
				
				return sum / numDataPoints;
			}
		}
	}
	
	/**
	 * @author Liam
	 * @return the mean of the middle quartiles of the sample
	 */
	public double getMedianMean() {
		
		ArrayList <Double> sample = new ArrayList<Double>();
		
		copyListContents(sample, filter);
		Collections.sort(sample);
		//Debug
		//System.out.println(sample);
		
		int baseFour = sample.size()/4;
		
		for (int i = 0; i < baseFour; i++) {
			
			sample.remove((int) 0);
		}
		
		//Debug
		//System.out.println(sample);
		
		for (int i = 0; i < baseFour; i++) {
			
			sample.remove(sample.size() - 1);
		}
		
		//Debug
		//System.out.println(sample);
		
		double sum = 0.0;
		
		for (double num: sample) {
			
			sum += num;
		}
		
		return sum/sample.size();
	}
	
	/**
	 * @author Liam
	 * @param numDataPoints the number of recent data points to use
	 * @return the mean of the middle quartiles of the sample of the most recent number of data points specified
	 */
	public double getMedianMean(int numDataPoints) {
		
		ArrayList <Double> sample = new ArrayList<Double>();
		
		copyListContents(sample, filter, numDataPoints);
		Collections.sort(sample);
		
		//Debug
		//System.out.println(sample);
		
		int baseFour = sample.size()/4;
		
		for (int i = 0; i < baseFour; i++) {
			
			sample.remove((int) 0);
		}
		
		//Debug
		//System.out.println(sample);
		
		for (int i = 0; i < baseFour; i++) {
			
			sample.remove(sample.size() - 1);
		}
		
		//Debug
		//System.out.println(sample);
		
		double sum = 0.0;
		
		for (double num: sample) {
			
			sum += num;
		}
		
		return sum/sample.size();
	}
	
	/**
	 * @author Liam
	 * @return the standard deviation of the sample
	 * within one standard deviation (~68%), within two (~96%), within three ~100%
	 */
	public double getStandardDeviation() {
		
		double sigma = 0.0; //sum
		double mean = getMean();
		double standardDeviation = 0.0;
		
		for (int i = 0; i < filter.size(); i++) {
			
			sigma += Math.pow(filter.get(i)-mean, 2);
		}
		
		standardDeviation = Math.sqrt(sigma/filter.size());
		
		return standardDeviation;
	}
	
	/**
	 * @author Liam
	 * @param numDataPoints the number of recent data points to use
	 * @return the standard deviation of the sample
	 * within one standard deviation (~68%), within two (~96%), within three ~100%
	 */
	public double getStandardDeviation(int numDataPoints) {
		
		double sigma = 0.0; //sum
		double mean = getMean(numDataPoints);
		double standardDeviation = 0.0;
		
		ArrayList <Double> sample = new ArrayList<Double>();
		
		copyListContents(sample, filter, numDataPoints);
		
		for (int i = 0; i < sample.size(); i++) {
			
			sigma += Math.pow(sample.get(i)-mean, 2);
		}
		
		standardDeviation = Math.sqrt(sigma/sample.size());
		
		return standardDeviation;
	}
	
	/**
	 * @author Liam
	 * @return the variance of the sample
	 */
	public double getVariance() {
		
		return Math.pow(getStandardDeviation(), 2);
	}
	
	/**
	 * @author Liam
	 * @param numDataPoints the number of recent data points to use
	 * @return the variance of the sample
	 */
	public double getVariance(int numDataPoints) {
		
		return Math.pow(getStandardDeviation(numDataPoints), 2);
	}
	
	/**
	 * @author Liam
	 * @return the range of the values from the data points in the sample
	 */
	public double getRange() {
		
		ArrayList <Double> sample = new ArrayList<Double>();
		
		copyListContents(sample, filter);
		Collections.sort(sample);
		
		return (sample.size() > 0) ? (sample.get(sample.size() - 1) - sample.get(0))
				: 0;
	}
	
	/**
	 * @author Liam
	 * @param numDataPoints the number of recent data points to use
	 * @return the range of the values from the data points in the sample
	 */
	public double getRange(int numDataPoints) {
		
		ArrayList <Double> sample = new ArrayList<Double>();
		
		copyListContents(sample, filter, numDataPoints);
		Collections.sort(sample);
		
		return (sample.size() > 0) ? (sample.get(sample.size() - 1) - sample.get(0))
				: 0;
	}
	
	/**
	 * @author Liam
	 * @param value the new data point
	 * @return the Z-Score of the new data point
	 */
	public double calculateZScore(double value) {
		
		return (value - getMean())/getStandardDeviation();
	}
	
	/**
	 * @author Liam
	 * @param value the new data point
	 * @param numDataPoints the number of recent data points to use
	 * @return the Z-Score of the new data point
	 */
	public double calculateZScore(double value, int numDataPoints) {
		
		return (value - getMean(numDataPoints))/getStandardDeviation(numDataPoints);
	}
	
	/**
	 * @author Liam
	 * @param zScore a zScore to corrspond to a value from the sample
	 * use this to determine the value of a z score in relation to the sample data
	 */
	public double calculateValue(double zScore) {
		
		double value = zScore*getStandardDeviation() + getMean();
		
		return value;
	}
	
	/**
	 * @author Liam
	 * @param zScore a zScore to corrspond to a value from the sample
	 * @param numDataPoints the number of recent data points to use
	 * use this to determine the value of a z score in relation to the sample data
	 */
	public double calculateValue(double zScore, int numDataPoints) {
		
		double value = zScore*getStandardDeviation(numDataPoints) + getMean(numDataPoints);
		
		return value;
	}
	
	/**
	 * @author Liam
	 * Overrides the default object toString() method. Returns all the data points in the sample in CSV (Comma Separated Value) format
	 */
	public String toString() {
		
		String data = "";
		
		for (int i = 0; i < filter.size(); i++) {
			
			data += filter.get(i) + ",";
		}
		
		return data;
	}
}
