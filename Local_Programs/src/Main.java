import java.util.Scanner;
import java.lang.Math;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Timer;
import java.util.function.Predicate;

public class Main {
	
	public static void main(String[] args) {

		/*String [][] names = {{"Bill", "Billy", "Bob"}, {"Sal", "Sally", "Saltine"}, {"Chris", "Christopher", "Christine"}};
		
		loopyLoop : for (String[] nameArr : names) {
			loopDoop : for (int i = 0; i < nameArr.length; i++) {
				
				if (i == nameArr.length -1)
					continue loopyLoop;
					
				System.out.println(nameArr[i]);
			}
		}
		
		boolean bool = false ^ false;
		
		System.out.println(bool);*/
		
		/*for (int i = 0; i < 10; ) {
			
			i = ++i;
			System.out.println(i);
		}*/
		
		/*final char b = 'L';
		
		switch (b) {
		
		case 'K':
			System.out.println("Yo");
			break;
			
		case 'L':
			System.out.println("YAYA!");
			break;
			
		default:
			System.out.println("Aww");
			break;
		}*/
		
		/*
		String a = "K";
		String b = a;
		String c = new String("K");
		
		System.out.println((a==c) ? "Unexpected" : "Expected");
		System.out.println((a==b) ? "Expected" : "Unexpected");
		System.out.println((b==c) ? "Unexpected" : "Expected");
		*/
		
		//double vals [] = {0.6, 1.3, 2, 4, 4.2, 7.9, 8.1, 9.7, 9.7, 10, 19.4, 20};
		
		//Filter filter = new Filter(vals);
		
		Filter filter = new Filter();
		
		
		filter.update(7.9);
		filter.update(4.2);
		filter.update(1.3);
		filter.update(9.7);
		filter.update(9.7);
		filter.update(10);
		filter.update(0.6);
		filter.update(8.1);
		filter.update(20);
		filter.update(2);
		filter.update(4);
		filter.update(19.4);
		
		
		System.out.println(filter);
		
		for (byte i = 0; i < filter.getSize(); i++) {
			
			System.out.println(filter.get(i));
		}
		
		for (byte i = 0; i < filter.getSize(); i++) {
			
			System.out.println(filter.calculateZScore(filter.get(i)));
		}
		
		int numDataPoints = 3;
		
		for (int i = filter.getSize() - numDataPoints; i < filter.getSize(); i++) {
			
			System.out.print(filter.get(i) + ", ");
		}
		
		System.out.println("Mean: " + filter.getMean(numDataPoints));
		System.out.println("Median: " + filter.getMedian(numDataPoints));
		System.out.println("Range: " + filter.getRange(numDataPoints));
		System.out.println("Standard Deviation: " + filter.getStandardDeviation(numDataPoints));
		System.out.println("Variance: " + filter.getVariance(numDataPoints));
		System.out.println("Mode: " + filter.getMode(numDataPoints));
		System.out.println("Median Mean: " + filter.getMedianMean(numDataPoints));
		System.out.println("Mean: " + filter.getMean(f -> Math.abs(filter.calculateZScore(f, numDataPoints)) > 1.0, numDataPoints));
		
		/*
		DateTimeFormatter sf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter sf2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		DateTimeFormatter sf3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter sf4 = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		LocalDateTime moment = LocalDateTime.of(today, now);
		
		System.out.println(now.format(sf2));
		System.out.println(today.format(sf3));
		System.out.println(moment.format(sf));
		System.out.println(moment.format(sf4));
		
		System.out.println("Before Lambda: " + filter);
		filter.removeIf(f -> f.doubleValue() < 5.0);
		System.out.println("After Lambda: " + filter);*/
	}
}
