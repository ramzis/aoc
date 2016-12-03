package d2;
import java.util.Arrays;

public class Day2 {

	public static void main(String[] args) {
		int n = 5;
		String input[] = new String[n]; 
		input[0] = "RDLULDLDDRLLLRLRULDRLDDRRRRURLRLDLULDLDLDRULDDLLDRDRUDLLDDRDULLLULLDULRRLDURULDRUULLLUUDURURRDDLDLDRRDDLRURLLDRRRDULDRULURURURURLLRRLUDULDRULLDURRRLLDURDRRUUURDRLLDRURULRUDULRRRRRDLRLLDRRRDLDUUDDDUDLDRUURRLLUDUDDRRLRRDRUUDUUULDUUDLRDLDLLDLLLLRRURDLDUURRLLDLDLLRLLRULDDRLDLUDLDDLRDRRDLULRLLLRUDDURLDLLULRDUUDRRLDUDUDLUURDURRDDLLDRRRLUDULDULDDLLULDDDRRLLDURURURUUURRURRUUDUUURULDLRULRURDLDRDDULDDULLURDDUDDRDRRULRUURRDDRLLUURDRDDRUDLUUDURRRLLRR";
		input[1] = "RDRRLURDDDDLDUDLDRURRLDLLLDDLURLLRULLULUUURLDURURULDLURRLRULDDUULULLLRLLRDRRUUDLUUDDUDDDRDURLUDDRULRULDDDLULRDDURRUURLRRLRULLURRDURRRURLDULULURULRRLRLUURRRUDDLURRDDUUDRDLLDRLRURUDLDLLLLDLRURDLLRDDUDDLDLDRRDLRDRDLRRRRUDUUDDRDLULUDLUURLDUDRRRRRLUUUDRRDLULLRRLRLDDDLLDLLRDDUUUUDDULUDDDUULDDUUDURRDLURLLRUUUUDUDRLDDDURDRLDRLRDRULRRDDDRDRRRLRDULUUULDLDDDUURRURLDLDLLDLUDDLDLRUDRLRLDURUDDURLDRDDLLDDLDRURRULLURULUUUUDLRLUUUDLDRUDURLRULLRLLUUULURLLLDULLUDLLRULRRLURRRRLRDRRLLULLLDURDLLDLUDLDUDURLURDLUURRRLRLLDRLDLDRLRUUUDRLRUDUUUR";
		input[2] = "LLLLULRDUUDUUDRDUUURDLLRRLUDDDRLDUUDDURLDUDULDRRRDDLLLRDDUDDLLLRRLURDULRUUDDRRDLRLRUUULDDULDUUUDDLLDDDDDURLDRLDDDDRRDURRDRRRUUDUUDRLRRRUURUDURLRLDURDDDUDDUDDDUUDRUDULDDRDLULRURDUUDLRRDDRRDLRDLRDLULRLLRLRLDLRULDDDDRLDUURLUUDLLRRLLLUUULURUUDULRRRULURUURLDLLRURUUDUDLLUDLDRLLRRUUDDRLUDUDRDDRRDDDURDRUDLLDLUUDRURDLLULLLLUDLRRRUULLRRDDUDDDUDDRDRRULURRUUDLUDLDRLLLLDLUULLULLDDUDLULRDRLDRDLUDUDRRRRLRDLLLDURLULUDDRURRDRUDLLDRURRUUDDDRDUUULDURRULDLLDLDLRDUDURRRRDLDRRLUDURLUDRRLUDDLLDUULLDURRLRDRLURURLUUURRLUDRRLLULUULUDRUDRDLUL";
		input[3] = "LRUULRRUDUDDLRRDURRUURDURURLULRDUUDUDLDRRULURUDURURDRLDDLRUURLLRDLURRULRRRUDULRRULDLUULDULLULLDUDLLUUULDLRDRRLUURURLLUUUDDLLURDUDURULRDLDUULDDRULLUUUURDDRUURDDDRUUUDRUULDLLULDLURLRRLRULRLDLDURLRLDLRRRUURLUUDULLLRRURRRLRULLRLUUDULDULRDDRDRRURDDRRLULRDURDDDDDLLRRDLLUUURUULUDLLDDULDUDUUDDRURDDURDDRLURUDRDRRULLLURLUULRLUDUDDUUULDRRRRDLRLDLLDRRDUDUUURLRURDDDRURRUDRUURUUDLRDDDLUDLRUURULRRLDDULRULDRLRLLDRLURRUUDRRRLRDDRLDDLLURLLUDL";
		input[4] = "ULURLRDLRUDLLDUDDRUUULULUDDDDDRRDRULUDRRUDLRRRLUDLRUULRDDRRLRUDLUDULRULLUURLLRLLLLDRDUURDUUULLRULUUUDRDRDRUULURDULDLRRULUURURDULULDRRURDLRUDLULULULUDLLUURULDLLLRDUDDRRLULUDDRLLLRURDDLDLRLLLRDLDRRUUULRLRDDDDRUDRUULDDRRULLDRRLDDRRUDRLLDUDRRUDDRDLRUDDRDDDRLLRDUULRDRLDUDRLDDLLDDDUUDDRULLDLLDRDRRUDDUUURLLUURDLULUDRUUUDURURLRRDULLDRDDRLRDULRDRURRUDLDDRRRLUDRLRRRRLLDDLLRLDUDUDDRRRUULDRURDLLDLUULDLDLDUUDDULUDUDRRDRLDRDURDUULDURDRRDRRLLRLDLU";
		
		int answers[] = new int[n];
		int start = 4; // Key '5'
		for(int i = 0; i < n; i ++) {
			answers[i] = getNumber(start, input[i]);
			start = answers[i];
			answers[i] += 1; // adjust from coordinate to key
		}
		System.out.println("Ladies and gents, the answers: " + Arrays.toString(answers));
		
		int mapSize = 7; //Should only work with odd
		char map[] = new char[mapSize*mapSize];
		for(int i = 0; i < mapSize*mapSize; i++) map[i] = 'X';
		for(int i = 1; i <= mapSize/2; i++) {
			for(int x = 0; x < 1 + (i-1)*2; x++) {
				map[(i*mapSize) + (mapSize/2 + 1) - (i) + x] = (char)((i-1)*(i-1) + 1 + x + '0');
			}
		}
		int letter = 65;
		for(int i = 0; i < mapSize/2-1; i++) {
			for(int x = 0; x < ((mapSize/2-1) -1 - i)*2 + 1 ; x++) {
				map[((mapSize*(mapSize/2 + 1)) + i*mapSize) + (i+2) + x] = (char)(letter++);
			}
		}
		answers = new int[n];
		start = 22; // Key '5'
		for(int i = 0; i < n; i ++) {
			answers[i] = getAlphaNum(start, input[i], map);
			start = answers[i];
		}
		System.out.println("One more time: ");
		for(int i = 0; i < n; i++) 
			System.out.println(map[answers[i]]);
		
	}
	// 0 1 2
	// 3 4 5
	// 6 7 8
	public static int getNumber(int start, String input) {
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			switch(c) {
			case 'U':
				start -= 3;
				if(start < 0) start += 3;
				break;
			case 'D':
				start += 3;
				if(start > 8) start -=3;
				break;
			case 'L':
				if((start % 3) - 1 >= 0)
					start -= 1; 
				break;
			case 'R':
				if((start % 3) + 1 < 3)
					start += 1;
				break;
			}
		}
		return start;
	}
	/*  Using map
	    X X X X X X X
		X X X 1 X X X
		X X 2 3 4 X X
		X 5 6 7 8 9 X
		X X A B C X X
		X X X D X X X
		X X X X X X X
	 */
	public static int getAlphaNum(int start, String input, char map[]) {
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			switch(c) {
			case 'U':
				start -= 7;
				if(map[start] == 'X') start += 7;
				break;
			case 'D':
				start += 7;
				if(map[start] == 'X') start -=7;
				break;
			case 'L':
				start -= 1;
				if(map[start] == 'X') start +=1;  
				break;
			case 'R':
				start += 1;
				if(map[start] == 'X') start -=1;
				break;
			}
		}
		return start;
	}
}