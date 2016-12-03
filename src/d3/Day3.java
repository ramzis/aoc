package d3;
import java.io.*;
import java.util.Arrays;

public class Day3 {

	public static void main(String[] args) throws IOException {
		File dir = new File(".");
		File fin = new File(dir.getCanonicalPath() + File.separator + "src" + File.separator + "d3" + File.separator + "input.txt");
		readFile1(fin);
		readFile2(fin);
	}

	private static void readFile1(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		int count = 0;
		while ((line = br.readLine()) != null) {
			String nums[] = line.trim().split("\\s+");
			System.out.println(Arrays.toString(nums));
			if(isTriangle(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2])))
				count++;
		}
		br.close();
		System.out.println(count+" triangles are real!");
	}
	
	private static void readFile2(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String lines[] = new String[3];
		final int columns = 3;
		int count = 0;
		while ((lines[0] = br.readLine()) != null) {
			lines[1] = br.readLine();
			lines[2] = br.readLine();
			
			int triangles[][] = new int[columns][3];
			for(int i = 0; i < 3; i++) {
				int nums[] = Arrays.stream(lines[i].trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
				for(int y = 0; y < columns; y++)
					triangles[y][i] = nums[y];
			}
			for(int i = 0; i < 3; i++)
			if(isTriangle(triangles[i][0], triangles[i][1], triangles[i][2]))
				count++;
		}
		br.close();
		System.out.println("No! Actually " +count+" triangles are real!");
	}
	
	private static boolean isTriangle(int x, int y, int z) {
		return x+y>z && y+z>x && x+z>y;
	}
}