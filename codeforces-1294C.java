// Q : https://codeforces.com/problemset/problem/1294/C

class Solution{
  public static int[] findThree(int n) {
		int a = 2, b = 2, c = 2;
		for(; a*a<=n; a++) {
			if(n%a == 0) break;
		}
		n = n/a;
		for(;b*b<=n;b++){
		    if(n%b == 0 && b!=a) break;
		}
		
		c = n/b;
		if(c!=1 && a!=b && b!=c && c!=a){
		    return new int[]{a,b,c};
		}
		return new int[] {-1};
	}
}
