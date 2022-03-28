package javaAlgorithmsTests;

import java.util.*;

public class Main {

	boolean solution(String sequence) {

		Deque<Character> values = new ArrayDeque<Character>();

		for (int i = 0; i < sequence.length(); i++) {
			char x = sequence.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				values.push(x);
				continue;
			}

			if (values.isEmpty())
				return false;

			char check = 0;

			switch (x) {
			case ')':
				check = values.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				values.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = values.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		return (values.isEmpty());
	}

	boolean getResult() {
		// Here we will set the string value
		String value = "({})";

		if (solution(value)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		Main test = new Main();
		System.out.println(test.getResult());

	}

}
