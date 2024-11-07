package calculator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * This is the numberBtnClicked class used to implement ActionListener for each numerical button(implements inheritance).
 */
public class numberBtnClicked implements ActionListener{
    private final int number;
    private final JTextField textField;

    /**
     * Constructor for numberBtnClicked
     * @param number is input number used for each type of button(0-9).
     * @param textField is the input textField object passed from the GUI.
     * Both parameters used to identify which button number when called by subclass.
     */
    public numberBtnClicked(int number, JTextField textField) {
        this.number = number;
        this.textField = textField;
    }

    /**
     * actionPerformed method is used to invoke action event when a numerical button is pressed.
     * @param e the event to be processed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(textField.getText().equals("0")){
            textField.setText(String.valueOf(number));
        }
        else {
            textField.setText(textField.getText() + number);
        }
    }

}

/**
 * Each following button subclass inherits the properties of numberBtnClicked and passes its respective value and
 * GUI textfield.
 * Creates a ActionListener for each numerical button type.
 * zeroBtnClicked is the event handler class for zeroBtn.
 */
class zeroBtnClicked extends numberBtnClicked{
    public zeroBtnClicked(int number, JTextField textField) {
        super(0, textField);
    }
}

/**
 * oneBtnClicked is the event handler class for oneBtn.
 */
class oneBtnClicked extends numberBtnClicked{
    public oneBtnClicked(int number, JTextField textField) {
        super(1, textField);
    }
}

/**
 * twoBtnClicked is the event handler class for twoBtn.
 */
class twoBtnClicked extends numberBtnClicked{
    public twoBtnClicked(int number, JTextField textField) {
        super(2, textField);
    }
}
/**
 * threeBtnClicked is the event handler class for threeBtn.
 */
class threeBtnClicked extends numberBtnClicked{
    public threeBtnClicked(int number, JTextField textField) {
        super(3, textField);
    }
}
/**
 * fourBtnClicked is the event handler class for fourBtn.
 */
class fourBtnClicked extends numberBtnClicked{
    public fourBtnClicked(int number, JTextField textField) {
        super(4, textField);
    }
}

/**
 * fiveBtnClicked is the event handler class for fiveBtn.
 */
class fiveBtnClicked extends numberBtnClicked{
    public fiveBtnClicked(int number, JTextField textField) {
        super(5, textField);
    }
}

/**
 * sixBtnClicked is the event handler class for sixBtn.
 */
class sixBtnClicked extends numberBtnClicked{
    public sixBtnClicked(int number, JTextField textField) {
        super(6, textField);
    }
}

/**
 * sevenBtnClicked is the event handler class for sevenBtn.
 */
class sevenBtnClicked extends numberBtnClicked{
    public sevenBtnClicked(int number, JTextField textField) {
        super(7, textField);
    }
}

/**
 * eightBtnClicked is the event handler class for eightBtn.
 */
class eightBtnClicked extends numberBtnClicked{
    public eightBtnClicked(int number, JTextField textField) {
        super(8, textField);
    }
}

/**
 * nineBtnClicked is the event handler class for nineBtn.
 */
class nineBtnClicked extends numberBtnClicked{
    public nineBtnClicked(int number, JTextField textField) {
        super(9, textField);
    }
}
