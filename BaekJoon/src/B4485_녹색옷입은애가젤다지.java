import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B4485_녹색옷입은애가젤다지 {
	static int[] di = { -1, 0, 0, 1 };// 위, 왼, 오, 아래
	static int[] dj = { 0, -1, 1, 0 };
	static int[][] map;
	static boolean[][] visit;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (true) {
			tc++;
			N = sc.nextInt();
			if(N == 0) break;
			map = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("Problem "+ tc +": "+dis());
		}
	}

	static int dis() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0,0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Point minPoint = pq.poll();
			//System.out.println(minPoint);
			
			if(visit[minPoint.x][minPoint.y])
				continue;
			
			visit[minPoint.x][minPoint.y] = true;
			
			if(minPoint.x == N-1 && minPoint.y == N-1) {
				return minPoint.weight;
			}
			
			for(int d=0; d<4; d++) {
				int nexti = minPoint.x+di[d];
				int nextj = minPoint.y+dj[d];
				if(nexti>=0 && nextj>=0 && nexti<N && nextj<N && !visit[nexti][nextj]) {
					pq.add(new Point(nexti, nextj, minPoint.weight + map[nexti][nextj]));
				}
			}
		}
		return 0;
		
	}
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int weight;
		
		public Point(int x, int y, int weight)  {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point p) {
			return this.weight-p.weight;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}
		
	}
}
