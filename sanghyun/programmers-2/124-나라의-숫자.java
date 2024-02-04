import java.util.Stack;

class Solution {
    public StringBuilder solution(int n) {
    	// 124 나라

        Stack<Integer> stack = new Stack<Integer>();
        while (n > 3) {
			int num = n%3;
			switch (num) {
			case 0:
				stack.add(3);
				n--;
				break;
			case 1:
				stack.add(1);
				break;
			case 2:
				stack.add(2);
				break;
			default:
				break;
			}
			n = n /3 ;
		}
        stack.add(n);
        StringBuilder s = new StringBuilder();
        while(!stack.isEmpty()) {
        	int num = stack.pop();
        	if(num == 3) {
        		s.append(4);
        	}else {
        		s.append(num);
        	}
        }
     
        return s;
    }
}

