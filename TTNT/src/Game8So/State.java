package Game8So;

public class State {
	int g; 
	int h;
	State cha;
	Operator me;
	int d[][] = new int[3][3]; // tạo ra ma trận ban đầu
	public State() {  // gan theo thu tu 0...8
		for (int i=0;i<3;i++)
			for (int j=0;j<3;j++)
				d[i][j] = (i*3+j+1)%9;
	}
	public State Clone() {
		State n = new State();
		for (int i=0;i<3;i++)
			for (int j=0;j<3;j++)
				n.d[i][j] = this.d[i][j];
		return n;
	}
	
	public void Print() {
		
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				System.out.print(d[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------");
	}
	public String getkey() 
	{
		String s = "";  // moi trang thai co 1 chuoi khac nhau
		for (int i=0;i<3;i++) 
			for (int j=0;j<3;j++) 
				s+=d[i][j];

		return s;
	}


}
