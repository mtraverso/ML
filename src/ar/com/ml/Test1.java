package ar.com.ml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int rows = Integer.valueOf(br.readLine());
		int[][] matrix;
		if(rows > 0){
			String line = br.readLine();
			String[] values= line.split(" ");
			matrix = new int[rows][values.length];
			for(int i = 0; i< values.length;i++){
				matrix[0][i] = Integer.valueOf(values[i]);
			}
			for(int i = 1; i< rows;i++){
				values = br.readLine().split(" ");
				for(int j = 0; j< values.length;j++){
					matrix[i][j] = Integer.valueOf(values[j]);
				}
			}
			int queries = Integer.valueOf(br.readLine());
			
			int[] r1s = new int[queries];
			int[] c1s = new int[queries];
			int[] r2s = new int[queries];
			int[] c2s = new int[queries];
			
			for(int i = 0; i< queries;i++){
				String[] queryStr = br.readLine().split(" ");
				r1s[i] = Integer.valueOf(queryStr[0])-1;
				c1s[i] = Integer.valueOf(queryStr[1])-1;
				r2s[i] = Integer.valueOf(queryStr[2])-1;
				c2s[i] = Integer.valueOf(queryStr[3])-1;
			}
			
			median(matrix,r1s,c1s,r2s,c2s);
		}
	}
	
	private static void median(int[][] matrix, int[] r1s, int[] c1s, int[] r2s, int[] c2s){
		for(int i = 0; i<r1s.length; i++){
			List<Integer> values = new ArrayList<Integer>();
			int r1 = r1s[i];
			int c1 = c1s[i];
			int r2 = r2s[i];
			int c2 = c2s[i];
			for(int j = r1; j<= r2;j++){
				for(int k = c1; k<= c2; k++){
					values.add(matrix[j][k]);
				}
			}
			Collections.sort(values);
			
			if(values.size() %2 == 0){
				int value1 = values.get((values.size()/2) -1);
				int value2 = values.get((values.size()/2));
				System.out.println((value1+value2)/2);
			}else{
				System.out.println(values.get(values.size()/2));
			}
		}
	}
	
	

}
