interface Rideable {
double num = 9; // all interface variables are public static final
//String getGait(); //all interface methods are public
//num = 8; // this reassigns a final variable which is illegal
}
public class Camel implements Rideable {
int weight = 2;
public static void main(String[] args) {
new Camel().go(8);

Rideable cam = new Camel();
Camel camel = (Camel)cam;

if (cam == camel) {
	System.out.println("You can compare parents and chidren");
}
}
void go(int speed) {
++speed;
weight++;
int walkrate = speed * weight;
//System.out.print(walkrate + getGait());
}
//String getGait() { // this is default which reduces visibility which is illegal
//return " mph, lope";
//}
}