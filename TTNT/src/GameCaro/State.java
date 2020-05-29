package GameCaro;

public class State {
	int value;
	int N =3;
	int a[][]= new int [N][N];
	
	void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(a[i][j] == 0) System.out.println("_");
				if(a[i][j] == 1) System.out.println("X");
				if(a[i][j] == 2) System.out.println("O");
			}
		System.out.println();			
	}
	System.out.println("=====");
	}
	
	State Clone() {
		State state = new State();
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				state.a[i][j]= this.a[i][j];
		return state;
	}
	
}
