package Game15So;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import Game15So.Operator;
import Game15So.State;

public class SearchA {
	public static void main(String []args) {
		State Start,Goal,O=null;
		//List<State> Open;
		PriorityQueue<State> Open = new PriorityQueue<State>(new Comparator<State>() {
			@Override
			public int compare(State s1, State s2) {
				return (s1.g+s1.h)- (s2.g+s2.h);
			}
		});
		
		Map<String,State> Closed = new HashMap<>();  
		
		Goal = new State();
		Start = new State();
		
		Random rand = new Random();
		for (int i=0;i<1000;i++) {
			Operator op = new Operator(rand.nextInt(4));
			State n = op.Move(Start);
			if (n!=null) Start = n;
		}
		Start.Print();
		
		//Open = new ArrayList<State>();
		
		//Buoc 1
		Start.g = 0;
		Start.h = DistanceH(Start, Goal);
		
		Open.add(Start);
		Closed.put(Start.getKey(), Start);
		
		while (true) {
			//Buoc 2
			if (Open.size()==0) break;
			
			//Buoc 3
			O = Open.remove();
			
			//Buoc 4
			if (Equal(O,Goal)) break;
			
			//Buoc 5
			for (int i=0;i<4;i++) {
				Operator op = new Operator(i);
				State child = op.Move(O);
				if (child ==null) continue;
				if (In(child,Closed)) continue;
				child.cha = O;
				child.me = op;
				child.g = O.g+1;
				child.h = DistanceH(child, Goal);
				Open.add(child);
				Closed.put(child.getKey(), child);
			}
		}
		
		if (Equal(O,Goal)) {
			System.out.println("Tim Kiem Thanh Cong");
			PrintResult(O);
		}
		
	}

	private static int DistanceH(State start, State goal) {
		int count =0;
		for (int i=0;i<4;i++)
			for (int j=0;j<4;j++)
				if(start.d[i][j] != goal.d[i][j]) 
					count++;
		// TODO Auto-generated method stub
		return count;
	}

	private static void PrintResult(State o) {
		if (o.cha!=null) {
			PrintResult(o.cha);
			switch (o.me.i) {
			case 0: System.out.println("Up");break;
			case 1: System.out.println("Down");break;
			case 2: System.out.println("Left");break;
			case 3: System.out.println("Right");break;
			}
		}
		o.Print();
	}

	private static boolean In(State child, Map<String,State> closed) {
		return closed.containsKey(child.getKey());
	}

	private static boolean Equal(State o, State goal) {
		if (o==null || goal==null) return false;
		for (int i=0;i<4;i++)
			for (int j=0;j<4;j++)
				if (o.d[i][j]!=goal.d[i][j]) return false;
		return true;
	}

		
}
