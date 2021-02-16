package operators;

import evaluator.Operand;

public class PowerOperator extends Operator{

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		 Operand power = new Operand((int)Math.pow (op1.getValue(),op2.getValue()));
	        return power;
	}

}
