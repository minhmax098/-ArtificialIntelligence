package Game8So;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Search {
	public static void main(String []args) {
		State Start,Goal,O=null;
		List<State> Open;//open : cai mo lay trc lay ra trc
		
		Map<String,State> Closed = new HashMap<>();//
		
		Goal = new State();//khoi tao goal
		Start = new State(); // khoi tao start
		
		Random rand = new Random(); //tao bien ramdom
		for (int i=0;i<1000;i++) {
			Operator op = new Operator(rand.nextInt(4)); // nextInt: 0->3
			State n = op.Move(Start); // n la 1 trang thai cua ma tran
			if (n!=null) 
				Start = n;
		}
		Start.Print();
		
		Open = new ArrayList<State>();
		
		//Buoc 1
		Open.add(Start);  /// cho goc :start vao hang doi
		Closed.put(Start.getkey(), Start); // start tro vao close, closed la Map, getKey()de tim kiem cho nhanh hon
		// bien mang thanh chuoi, neu co Hashmap thi no anh xa co cai Key phu hop.
		while (true) {
			//Buoc 2
			if (Open.size()==0) break; // xet open co rong ko -> ket thuc
			
			//Buoc 3
			O = Open.remove(0); // O la trang thai trung gian, lay tk dau tien cua Open
			
			//Buoc 4
			if (Equal(O,Goal)) break;// kiem tra co bang goal k -> ket thuc
			//neu chua bang thi dua vao goal roi tiep tuc xet
			//Goal la mot State, moi o la mot State
			//neu k bang goal thi qua buoc 5:
			
			//Buoc 5: tim tat ca cac dinh O k thuoc open, y la sau O co bn trang thai
			for (int i=0;i<4;i++) { // for co 4 huong , toi da 4 Goal
				Operator op = new Operator(i); //
				State child = op.Move(O); //mOVE O: huong i
				if (child ==null) continue; //bo qua , di qua huong tiep theo
				if (In(child,Closed)) continue; //bo cau lenh phia duoi, chay tiep vong for
				child.cha = O;// kiem tra key cua child co nam trong key cua closed hay k, 
				child.me = op;
				Open.add(child);
				Closed.put(child.getkey(), child);
			}
		}
		
		if (Equal(O,Goal)) {
			System.out.println("Tim Kiem Thanh Cong");
			PrintResult(O);
		}
		
	}

	private static void PrintResult(State o) {//doi voi moi State thi minh phai biet trang thai trc do cua State
		if (o.cha!=null) {
			PrintResult(o.cha);// co duoc 2 buoc tren minh ms in ra dc buoc PrintResult
			//PrintResult goi de quy trong PrintResult
			switch (o.me.i) {
			case 0: System.out.println("Up");break;
			case 1: System.out.println("Down");break;
			case 2: System.out.println("Left");break;
			case 3: System.out.println("Right");break;
			}
		}
		o.Print();
	}

	private static boolean In(State child, Map<String,State> closed) { // truyen vo tk trang thai con, map
		return closed.containsKey(child.getkey()); // return closed.
		//constrainKey:
	}

	private static boolean Equal(State o, State goal) {//Equal : 2 vong for long nhau.
		if (o==null || goal==null) return false;
		for (int i=0;i<3;i++)
			for (int j=0;j<3;j++)
				if (o.d[i][j]!=goal.d[i][j]) return false;
		return true;
	}

}
