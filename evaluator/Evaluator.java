package evaluator;

import java.util.*;

import operators.Operator;

public class Evaluator {
	private Stack<Operand> operandStack;
	private Stack<Operator> operatorStack;

	private StringTokenizer tokenizer;
	private static final String DELIMITERS = "+-*^/() ";

	public Evaluator() {
		operandStack = new Stack<>();
		operatorStack = new Stack<>();
	}

	public int eval(String expression) {
		String token;
		this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

		while (this.tokenizer.hasMoreTokens()) {
			if (!(token = this.tokenizer.nextToken()).equals(" ")) {
				if (Operand.check(token)) {
					operandStack.push(new Operand(token));
				} else {
					if (!Operator.check(token)) {
						System.out.println("*****invalid token******");						
						System.exit(1);
					}
					Operator newOperator = Operator.getOperator(token);
					if (token.equals(")")) {
						processExpressions(newOperator);
						continue;
					}
					if (!operatorStack.empty() && !token.equals("(")
							&& operatorStack.peek().priority() >= newOperator.priority()) {
						if (operatorStack.peek().priority() == newOperator.priority()) {
							Operator operate = operatorStack.pop();
							Operand op2 = operandStack.pop();
							Operand op1 = operandStack.pop();
							operandStack.push(operate.execute(op1, op2));
						} else
							processExpressions(newOperator);
					}
					operatorStack.push(newOperator);
				}
			}
		} 

		processExpressions(Operator.getOperator(")"));
		return operandStack.pop().getValue();

	}

	private void processExpressions(Operator ope) {
		while (!operatorStack.empty()) {
			Operator operate = operatorStack.pop();
			if (operate.getClass() == Operator.getOperator("(").getClass()) {
				if (ope == Operator.getOperator(")")) {
					break;					
				}
				operatorStack.push(operate);
				break;
			}
			Operand op2 = operandStack.pop();
			Operand op1 = operandStack.pop();
			operandStack.push(operate.execute(op1, op2));
		}
	}
	
}
