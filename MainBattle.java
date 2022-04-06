package battleship;

import java.io.IOException;
import java.util.Scanner;

public class MainBattle extends BattleShipGame{
	public static void main(String[] args) throws IOException {
		Player1 p1 = new Player1();
		Player2 p2 = new Player2();
		p1.Placing();
		System.out.println("Press Enter and pass the move to another player");
		Scanner sc= new Scanner(System.in);
		sc.nextLine();
		p2.Placing();
		game();
	}

}
