package operators;

import java.util.HashMap;

import evaluator.*;

public abstract class Operator {
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );

  public abstract int priority();
  public abstract Operand execute( Operand op1, Operand op2 );

  public static boolean check( String token ) {
	  if(operators.containsKey(token))
  		return true;
  	return false;
  }
  
  private static HashMap<String, Operator> createOperators()
  {
  	HashMap<String, Operator> operators = new HashMap<String, Operator>();
  	operators.put("+", new AddOperator() );
  	operators.put("-", new SubtractOperator() );
  	operators.put("*", new MultiplyOperator() );
  	operators.put("^", new PowerOperator() );
  	operators.put("/", new DivideOperator() );
  	operators.put("(", new LPOperator() );
  	operators.put(")", new RPOperator() );
  	return operators;
  }
  
  private static final HashMap<String,Operator> operators = createOperators();
  
  public static Operator getOperator(String token) {
      if(check(token)){
          return Operator.operators.get(token);
      }
      return null;
  }
}
