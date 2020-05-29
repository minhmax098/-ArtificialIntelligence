package Game15So;

import Game15So.Operator;
import Game15So.State;

public class State {
	// Mang chua thong tin cua bang
		int g; 
		int h;
		int d[][] = new int [4][4];
		State cha;
		Operator me;
		
		// Ham dung mac dinh 
		public State() {
			for (int i = 0; i<4; i++) {
				for(int j = 0; j<4; j++) {
					d[i][j] = (i * 4 + j + 1) % 16;
				}
			}
		}
		
		// Ham in no ra 
		public void Print() {
			for (int i = 0; i<4; i++) {
				for (int j = 0; j<4; j++) {
					System.out.print(d[i][j] + "  	 ");
				}
				System.out.println();
			}
			System.out.println("-----");
		}

		public State Clone() {
			// TODO Auto-generated method stub
			State n = new State();
			for (int i = 0; i< 4; i++) {
				for (int j = 0 ;j < 4; j++) {
					n.d[i][j] = this.d[i][j];
				}
			}
			return n;
		}

		public String getKey() {
			// TODO Auto-generated method stub
			String s = "";
			for (int i = 0; i< 4; i++) {
				for (int j =0; j <4; j++) {
					s += d[i][j];
				}
			}
			return s;
		}	
}
