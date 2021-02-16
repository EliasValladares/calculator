package operators;

import evaluator.Operand;

public class MultiplyOperator extends Operator{

	@Override
	public int priority() {
		return 2;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// TODO Auto-generated method stub
		 Operand multiply = new Operand(op1.getValue() * op2.getValue());
		return multiply;
	}
	

}
