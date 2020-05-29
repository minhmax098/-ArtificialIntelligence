package GameCaro;

import java.util.Scanner;

public class GameCaro {
	public static void main(String[] args) {
		new GameCaro();
	}
	
	public GameCaro() {
		Scanner sc = new Scanner(System.in);
		int player = 1;
		int turn = 0;
		int d = 5;
		State s = new State();
		s.print();
		while (true) {
			if (turn % 2 + 1 == player) {
				// User
				State child = null;
				while (child == null) {
					System.out.println("Please input coordinate!!");
					int x = sc.nextInt();
					int y = sc.nextInt();
					child = new Operator(x, y).Move(s);
				}
				s = child;
				if (Win(s)) {
					s.print();
					System.out.println("Player Won!");
					break;
				}
			} else {
				// AI
				System.out.println("AI turn!!");
				int min = Integer.MAX_VALUE;
				State minchild = null;
				for (int i = 0; i < s.N; i++)
					for (int j = 0; j < s.N; j++) {
						State child = new Operator(i, j).Move(s);
						if (child == null)
							continue;
						int tmp = MiniMax(child, 1, true);
						System.out.println(i+","+j+":"+tmp);
						if (min>tmp){
							min=tmp;
							minchild = child;
						}
					}
				s = minchild;
				if (Win(s)) {
					s.print();
					System.out.println("AI Won!");
					break;
				}
			}
			s.print();
			if (isEndNode(s)){
				System.out.println("Draw!");
				break;
			}
			turn++;
		}
	}
}
