package GameCaro;

public class Operator 
{
	int x, y;
	public Operator(int x, int y)
	{
		this.x= x;
		this.y= y;
	}
	public State Move(State s) {
		if( x<0 || x > s.N)
			return null;
		if( y<0 || y > s.N)
			return null;
		if(s.a[x][y] != 0)
			return null;
		
		int count =0;
		for(int i=0; i<s.N; i++)
			for(int j=0; j<s.N; j++)
				if(s.a[j][j] != 0) count++;
		State state = s.Clone();
		if(count % 2 == 0) 
			state.a[x][y] =1;
		else
			state.a[x][y] =2;
		
		return state;
		
	}
	

}
