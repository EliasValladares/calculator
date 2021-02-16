package evaluator;

public class Operand {

  private int value;

  public Operand( String token ) {
    this.value = Integer.valueOf(token);
  }

  public Operand( int value ) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static boolean check( String token ) {
    try{
        Integer.parseInt(token);
    }catch (Exception ex){
        return false;
    }
    return true;
  }
}
