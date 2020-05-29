package Game8So;

public class Operator {
	//0: Up
		//1: Down
		//2: Left
		//3: Right
		int i; //i: 0,1,2,3
		
		public Operator(int i) {
			this.i = i;
		}

		State Move(State s) { // tra ve state
			switch (i) {
			case 0: return Up(s);  // mot ham tra ve state
			case 1: return Down(s); 
			case 2: return Left(s);
			case 3: return Right(s);
			}
			return null;
		}

		private State Left(State s) { 
			MyPoint pzero = GetZero(s); //1 diem, lay gia tri toa do so 0
			if (pzero.j>0) {  //pzero nam o hang 1 vs hang 2, ko nam o hang 0
				State ns = s.Clone();
				ns.d[pzero.i][pzero.j] = ns.d[pzero.i][pzero.j-1];// doi vi tri 2 o cho nhau
				ns.d[pzero.i][pzero.j-1] = 0;
				return ns;
			}
			return null;
		}

		private State Right(State s) {
			MyPoint pzero = GetZero(s); 
			if (pzero.j<2) {
				State ns = s.Clone();
				ns.d[pzero.i][pzero.j] = ns.d[pzero.i][pzero.j+1];
				ns.d[pzero.i][pzero.j+1] = 0;
				return ns;
			}
			return null;
		}

		private State Down(State s) {
			MyPoint pzero = GetZero(s); 
			if (pzero.i>0) {
				State ns = s.Clone();
				ns.d[pzero.i][pzero.j] = ns.d[pzero.i-1][pzero.j];
				ns.d[pzero.i-1][pzero.j] = 0;
				return ns;
			}
			return null;
		}

		private State Up(State s) {
			MyPoint pzero = GetZero(s); 
			if (pzero.i<2) {
				State ns = s.Clone();
				ns.d[pzero.i][pzero.j] = ns.d[pzero.i+1][pzero.j];
				ns.d[pzero.i+1][pzero.j] = 0;
				return ns;
			}
			return null;
		}

		private MyPoint GetZero(State s) { // Lay toa do i,j
			for (int i=0;i<3;i++)
				for (int j=0;j<3;j++) {
					if (s.d[i][j]==0)
						return new MyPoint(i,j);
				}
			return null;
		}

	}

	class MyPoint{
		int i,j;
		public MyPoint(int i, int j) {
			this.i = i;
			this.j = j;
		}
}
