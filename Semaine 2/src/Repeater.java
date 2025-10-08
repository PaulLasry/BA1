import java.util.Scanner;
class Repeater {
	private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Say 'Hey'");
    String input = scanner.nextLine();
    System.out.println("You said '" + input + "'");
  }
}
