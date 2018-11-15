package ArrayHeight;

import java.util.Arrays;

public class Height {
	public static Integer[] myTree = new Integer[]{null, 1,2,3,4,5,6,7,null, null, 10, 11};
	
	public static void main(String[] args) {
		System.out.println(getHeight(1));
		System.out.println(getDepth(3));
	}

	
	public static int getHeight(int n) {
		int h = 0;
		if((n*2) < myTree.length && myTree[(n*2)] != null) {
			h = Math.max(h, 1 + getHeight(n*2));
		}
		if(((2*n)+1) < myTree.length && myTree[((n*2)+1)] != null) {
			h = Math.max(h, 1 + getHeight((n*2)+1));
		}

		return h;
		

	}
	
	public static int getHeight2(int n) {
		if
	}
	
	public static int getDepth(int n) {
		int d = 0;
		if(n == 1 || n==0) {
			return 0;
		}else {
			if(n%2==0 && (n*0.5) < myTree.length && myTree[(int) (n*0.5)] != null) {
				d = Math.max(d, 1 + getDepth((int) (n*0.5)));
			}
			if(((n-1)*0.5) < myTree.length && myTree[(int) ((n-1)*0.5)] != null) {
				d = Math.max(d, 1 + getDepth((int) ((n-1)*0.5)));
			}
		}
		return d;
	}
	
//	public int getHeight(TreeLinkedList node) {
//		int h = 0;
//		for(TreeLinkedList child : node.childreen) {
//			h = Math.max(h,  1 + getHeight(child));
//		}
//		return h;
//	}
}

//
//if(n < myTree.length && myTree[n] != null) {
//	h = Math.max(h, 1 + getHeight(n*2));
//	h = Math.max(h, 1 + getHeight((n*2) + 1));

