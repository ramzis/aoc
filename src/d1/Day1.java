package d1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day1 {
	
    public static void main() {
		String input = "L1, R3, R1, L5, L2, L5, R4, L2, R2, R2, L2, R1, L5, R3, L4, L1, L2, R3, R5, L2, R5, L1, R2, L5, R4, R2, R2, L1, L1, R1, L3, L1, R1, L3, R5, R3, R3, L4, R4, L2, L4, R1, R1, L193, R2, L1, R54, R1, L1, R71, L4, R3, R191, R3, R2, L4, R3, R2, L2, L4, L5, R4, R1, L2, L2, L3, L2, L1, R4, R1, R5, R3, L5, R3, R4, L2, R3, L1, L3, L3, L5, L1, L3, L3, L1, R3, L3, L2, R1, L3, L1, R5, R4, R3, R2, R3, L1, L2, R4, L3, R1, L1, L1, R5, R2, R4, R5, L1, L1, R1, L2, L4, R3, L1, L3, R5, R4, R3, R3, L2, R2, L1, R4, R2, L3, L4, L2, R2, R2, L4, R3, R5, L2, R2, R4, R5, L2, L3, L2, R5, L4, L2, R3, L5, R2, L1, R1, R3, R3, L5, L2, L2, R5";	
		//String input = "R2, L2, R2, R2, R2";
    	int direction = 0;
		int x = 0, y = 0; // Starting coordinates
		HashMap<Integer, Integer> map = new HashMap<>();
		List<String> ops = Arrays.asList(input.replaceAll("\\s+","").split(","));
		Day1 main = new Day1();
		map.put(main.new Pair(0,0).hashCode(), 1);
		for(int i = 0; i < ops.size(); i++) {
			StringBuilder op = new StringBuilder(ops.get(i));
			char side = op.charAt(0);
			int distance = Integer.parseInt(op.deleteCharAt(0).toString());
			direction = (side == 'L') ? direction - 1 : direction + 1;
			direction = direction < 0 ? 3 : direction % 4;
			for(int step = 0; step < distance; step++) {
				switch(direction){
					case 0: y+=1;
					break;
					case 1: x+=1; 
					break;
					case 2: y-=1; 
					break;
					case 3: x-=1; 
					break;
				}
				int value;
				if(map.containsKey(main.new Pair(x,y).hashCode())) value = map.get(main.new Pair(x,y).hashCode()) + 1;
				else value = 1;
				map.put(main.new Pair(x,y).hashCode(), value);
				System.out.println(x+" "+y);
				if(value == 2) {
					System.out.println("Found pair "+x+" "+y+". Dist "+ (Math.abs(x) + Math.abs(y)));
					return;
				}
			}
			
		}
		int answer = Math.abs(x) + Math.abs(y);
		System.out.println("The aswer is..."+answer+"!");
	}
    
    public class Pair {
    	private int x, y;
    	Pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	
    	 @Override
	    public int hashCode()
	    {
    		 int result = x;
    		 result = 347337 * result + y;
    		 return result;
	    }
    	
    	int X(){return this.x;}
    	int Y(){return this.y;}
    }
}
