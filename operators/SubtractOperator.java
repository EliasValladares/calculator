package operators;

import evaluator.Operand;

public class SubtractOperator extends Operator{

	@Override
	public int priority() {
		return 1;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		int res = op1.getValue() - op2.getValue();
    	Operand result = new Operand(res);
    	return result;
	}

}
