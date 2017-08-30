package misc;

public class PrintallParantheses {

	static int count = 1000;

	public static void main(String[] args) {

		char stack[] = {0};
		char array[] = {0};
		int n1 = 3, n2 = 3, n3 = 3;
		print_comb(n1, n2, n3, -1, stack, array, 0);
	}

	static void print_comb(int n1, int n2, int n3, int top, char[] stack, char[] array, int in) {
		if (n1 == 0 && n2 == 0 && n3 == 0 && top == -1) {
			array[in] = 0;
			System.out.println(array);
		} else {
			if (top != -1) {
				if (stack[top] == '{') {
					char s[];
					s = stack.clone();
					array[in] = '}';
					print_comb(n1, n2, n3, top - 1, s, array, in + 1);
				} else if (stack[top] == '(') {
					char s[];
					s = stack.clone();
					array[in] = ')';
					print_comb(n1, n2, n3, top - 1, stack, array, in + 1);
				} else // if(stack[top]=='[')
				{
					char s[];
					s = stack.clone();
					array[in] = ']';
					print_comb(n1, n2, n3, top - 1, stack, array, in + 1);
				}
			}
			if (n1 > 0) {
				char s[];
				s = stack.clone();
				s[top + 1] = '{';
				array[in] = '{';
				print_comb(n1 - 1, n2, n3, top + 1, s, array, in + 1);
			}
			if (n2 > 0) {
				char s[];
				s = stack.clone();
				s[top + 1] = '(';
				array[in] = '(';
				print_comb(n1, n2 - 1, n3, top + 1, s, array, in + 1);
			}
			if (n3 > 0) {
				char s[];
				s = stack.clone();
				s[top + 1] = '[';
				array[in] = '[';
				print_comb(n1, n2, n3 - 1, top + 1, s, array, in + 1);
			}
		}

	}
}