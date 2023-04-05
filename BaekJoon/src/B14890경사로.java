import java.util.Arrays;
import java.util.Scanner;

public class B14890경사로 {
	static int[] d= {-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int count = 0; //지나갈 수 있는 길의 개수
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//가로확인
		boolean[] visit;//경사로 만들어진자리
		boolean non ; //못감?
		for(int i=0; i<N; i++) {
			visit = new boolean[N];
			non = true;//일단 갈수 있음으로 설정
			for(int j=1; j<N; j++) {
				//달라지는 순간 이전이나 
				if(map[i][j] == map[i][j-1])
					continue;
				else if(map[i][j] == map[i][j-1] + 1) {//1커질때
					for(int l=L; l>0; l--) {
						if( j-l>=0 && !visit[j-l] && map[i][j] == map[i][j-l]+1) {	//경사로로 바뀐자리 아니라면
							visit[j-l] = true;
						}else {
							non = false;
							break;
						}
					}
				}else if(map[i][j] == map[i][j-1] - 1) {//1 작아질때
					
					for(int l=L-1; l>=0; l--) {
						if( j+l<N && !visit[j+l] && map[i][j-1] == map[i][j+l]+1) {	//경사로로 바뀐자리 아니라면
							visit[j+l] = true;
						}else {
							non = false;
							break;
						}
					}
				}else {
					non = false;
					break;
				}
			}
			if(non) {
//				System.out.println(non);
//				System.out.println(Arrays.toString(map[i]));
//				System.out.println(Arrays.toString(visit));
				count++;
			}
		}
		
		//세로확인
		for(int j=0; j<N; j++) {
			visit = new boolean[N];
			non = true;//일단 갈수 있음으로 설정
			for(int i=1; i<N; i++) {
				if(map[i][j] == map[i-1][j])//같으면 그냥 진행
					continue;
				else if(map[i][j] == map[i-1][j] + 1) {//1이 커졌을 때
					for(int l=L; l>0; l--) {
						if( i-l>=0 && !visit[i-l] && map[i][j] == map[i-1][j]+1) {	//경사로로 바뀐자리 아니라면
							visit[i-l] = true;
						}else {
							non = false;
							break;
						}
					}
				}else if(map[i][j] == map[i-1][j] - 1) {//1 작아질때
					for(int l=L-1; l>=0; l--) {
						if( i+l<N && !visit[i+l] && map[i-1][j] == map[i+l][j]+1) {	//경사로로 바뀐자리 아니라면
							visit[i+l] = true;
						}else {
							non = false;
							break;
						}
					}
				}else {
					non = false;
					break;
				}
			}
			if(non) {
//				System.out.println(non);
//				for(int i=0; i<N; i++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//				System.out.println(Arrays.toString(visit));
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
