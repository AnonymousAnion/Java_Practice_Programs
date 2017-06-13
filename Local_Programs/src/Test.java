import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.time.LocalDateTime;
import java.time.format.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Test {

	public static void main(String[] args) {
		
		int charFreq [] = new int[128];
		
		System.out.println(false == false);
		
		System.out.println("CHAR FREQ: " + charFreq[0]++);
		System.out.println("CHAR FREQ: " + charFreq[0]);
		
		int[] arr = new int[0];
		
		//System.out.println(arr[0]); //ArrayIndexOutOfBoundsException
		
		for (int i = 3; i < 2; i++) {
			
			System.out.println("hmmmmm");
		}
		
		// TODO Auto-generated method stub
		List<Animal> animal = new ArrayList<Animal>();
		animal.add(new Animal("fish", false, true));
		animal.add(new Animal("kangaroo", true, false));
		animal.add(new Animal("rabbit", true, false));
		animal.add(new Animal("turtle", false, true));
		
		try {
			
			eat();
		}
		catch (FileNotFoundException e) {
			
			
		}
		catch (IOException e){
			
			
		}
		catch (Exception e) {
			
			
		}
		
		print(animal, a -> "fish".equals(a.toString()));
		String num = "123";
		boolean ad = false;
		
		if (ad) {
			
			String name = "";
		}
		else {
			
			String name = "";
			
			if (true)
				name.toUpperCase();
			else
				name.toLowerCase();
		}
		
		String name = "Fred";
		
		String[] names = new String[] {"Bob"};
		List<String>list2 = Arrays.asList(names);
		names = null;
		//list2.remove(0);
		
		List<String>list = Arrays.asList("Bob");
		//list.add("Sally");
		
		System.out.println(animal.get(0).getClass());
		
		LocalTime now = LocalTime.now();
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_TIME));
		
		String test = "";
		String test2 = "";
		String test3 = null;
		System.out.println(test3);
		String test4 = null;
		test += "Hello";
		String c = "Hello";
		System.out.println(c == test);
		String a = new String("Hello");
		String b = new String("Hello");
		String d = "Hello";
		String g = "Testing";
		g = g.replace("t", "");
		System.out.println(g);
		
		List<String> l = new ArrayList<String>();
		l.add(c);
		l.add(b);
		System.out.println(l);
		Object object = c;
		System.out.println(object.equals("Hello"));
		System.out.println(l.remove("Hello"));
		//l.remove(1);
		System.out.println(l);
		System.out.println(d == l.get(0) ? "Last removed": "First Removed");
		
		System.out.println(a == c ? true: false);
		System.out.println(a == b ? true: false);
		System.out.println(b == c ? true: false);
		System.out.println(a == "Hello" ? true: false);
		System.out.println(b == "Hello" ? true: false);
		System.out.println(c == "Hello" ? true: false);
		System.out.println(d == "Hello" ? true: false);
		System.out.println(test == "Hello" ? true: false);
		System.out.println(test2 == "" ? true: false);
		System.out.println(test2 == null ? true: false);
		System.out.println(test3 == null ? true: false);
		System.out.println(test3 == test4 ? true: false);
		System.out.println("Hello" == "Hello");
		System.out.println(c == test);
		System.out.println(c == d ? true: false);
		System.out.println("Random" == "Random" ? true: false);
		System.out.println(test == "" ? true: false);
		System.out.println(test == "Hello" ? true: false);
		
		System.out.println("Animal Size: " + animal.size());
		for (int i = 0; i < animal.size(); i++) {
			
			animal.remove(0);
			System.out.println("PRINTED");
		}
	}
	
	private static void print(List<Animal> animals, Predicate <Animal> checker) {
		
		for (Animal animal : animals) {
			
			if (checker.test(animal)) {
				
				System.out.print(animal + " ");
			}
		}
	}
	
	public static void eat() throws FileNotFoundException {
		
		try {
			System.out.println("1");
			throw new IOException();
		}
		catch (IOException e) {
			
			System.out.println("2");
			throw new FileNotFoundException();
		}
		finally {
			
			System.out.println("3");
		}
	}
}

