interface CanClimb { int maxHeight(); }
interface HasClaws {boolean isSharp(); }

public class Koala extends AbstractTest implements CanClimb, HasClaws {
	
	public boolean isSharp() { return true; }
	public int maxHeight() { return 15; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object koala = new Koala();
		CanClimb canClimb = (CanClimb)koala;
		HasClaws hasClaws = (HasClaws)canClimb;
		System.out.println(new Koala() instanceof CanClimb);
	}

}
