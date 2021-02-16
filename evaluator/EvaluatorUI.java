package evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {
  private TextField txField = new TextField();
  private Panel buttonPanel = new Panel();

  // total of 20 buttons on the calculator,
  // numbered from left to right, top to bottom
  // bText[] array contains the text for corresponding buttons
  private static final String[] bText = {
    "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
    "*", "0", "^", "=", "/", "(", ")", "C", "CE"
  };
  private Button[] buttons = new Button[ bText.length ];

  public static void main(String argv[]) {
    EvaluatorUI calc = new EvaluatorUI();
  }

  public EvaluatorUI() {
    setLayout( new BorderLayout() );

    add( txField, BorderLayout.NORTH );
    txField.setEditable( false );

    add( buttonPanel, BorderLayout.CENTER );
    buttonPanel.setLayout( new GridLayout( 5, 4 ));

    //create 20 buttons with corresponding text in bText[] array
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ] = new Button( bText[ i ]);
    }

    //add buttons to button panel
    for (int i=0; i<20; i++) {
      buttonPanel.add( buttons[ i ]);
    }

    //set up buttons to listen for mouse input
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ].addActionListener( this );
    }

    setTitle( "Calculator" );
    setSize( 400, 400 );
    setLocationByPlatform( true  );
    setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent event ) {
    // You need to fill in this fuction
	  String buttonPressed = event.getActionCommand();
	  String str = this.txField.getText();
	  if("1".equals(buttonPressed)){
          this.txField.setText(str + "1");
      } else if("2".equals(buttonPressed)){
          this.txField.setText(str + "2");
      }else if("3".equals(buttonPressed)){
          this.txField.setText(str + "3");
      }else if("4".equals(buttonPressed)){
          this.txField.setText(str + "4");
      }else if("5".equals(buttonPressed)){
          this.txField.setText(str + "5");
      }else if("6".equals(buttonPressed)){
          this.txField.setText(str + "6");
      }else if("7".equals(buttonPressed)){
          this.txField.setText(str + "7");
      }else if("8".equals(buttonPressed)){
          this.txField.setText(str + "8");
      }else if("9".equals(buttonPressed)){
          this.txField.setText(str + "9");
      }else if("0".equals(buttonPressed)){
          this.txField.setText(str + "0");
      } else if("+".equals(buttonPressed)){
          this.txField.setText(str + "+");
      }else if("- ".equals(buttonPressed)){
          this.txField.setText(str + "- ");
      }else if("*".equals(buttonPressed)){
          this.txField.setText(str + "*");
      }else if("/".equals(buttonPressed)){
          this.txField.setText(str + "/");
      }else if("^".equals(buttonPressed)){
          this.txField.setText(str + "^");
      }else if("(".equals(buttonPressed)){
          this. txField.setText(str + "(");
      }else if(")".equals(buttonPressed)) {
          this.txField.setText(str + ")");
      }else if("=".equals(buttonPressed)) {
    	  Evaluator res = new Evaluator();    	  
    	  this.txField.setText(Integer.toString(res.eval(str)));
      }else if("CE".equals(buttonPressed)){
          this.txField.setText(str.substring(0,str.length()-1));
  }else {
      this.txField.setText(" ");
  }
  }
}
