package Code;
// Needs a package declaration to move to another folder

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by:
 * Date:
 * A starter file to use the Finch
 */

public class FinchTemplateFile
   {
   public static void main(final String[] args)
      {
 	  System.out.println("connected");
	  JFrame frame = new JFrame("Key Listener");
      Container contentPane = frame.getContentPane();
      KeyListener listener = new KeyListener() {
    	  Finch bigman = new Finch();
          @Override
          public void keyPressed(KeyEvent event) {
              printEventInfo("Key Pressed", event);
          }
          @Override
          public void keyReleased(KeyEvent event) {
              printEventInfo("Key Released", event);
          }
          @Override
          public void keyTyped(KeyEvent event) {
              printEventInfo("Key Typed", event);
          }
          private void printEventInfo(String str, KeyEvent e) {
        	  char w1 = 'w';
        	  char a1 = 'a';
        	  char d1 = 'd';
        	  char s1 = 's';
        	  char pressed = e.getKeyChar();
        	  if (str == "Key Released") {
        		  pressed = ' ';
        	  }
              System.out.println(str);
              int code = e.getKeyCode();
              System.out.println("   Code: " + KeyEvent.getKeyText(code));
              System.out.println("   Char: " + e.getKeyChar());
              int mods = e.getModifiersEx();
              System.out.println("    Mods: "
                      + KeyEvent.getModifiersExText(mods));
              System.out.println("    Location: "
                      + keyboardLocation(e.getKeyLocation()));
              System.out.println("    Action? " + e.isActionKey());
              if (pressed == w1) {
            	  bigman.setWheelVelocities(255,255);
            	  System.out.println("w");
            	  pressed = ' ';
            	  }
              if (pressed == a1) {
            	  bigman.setWheelVelocities(255,0);
            	  System.out.println("a");
            	  pressed = ' ';
            	  }
              if (pressed == s1) {
            	  bigman.setWheelVelocities(-255,-255);
            	  System.out.println("s");
            	  pressed = ' ';
            	  }
              if (pressed == d1) {
            	  bigman.setWheelVelocities(0,255);
            	  System.out.println("d");
            	  pressed = ' ';
            	  }
          }
          private String keyboardLocation(int keybrd) {
              switch (keybrd) {
                  case KeyEvent.KEY_LOCATION_RIGHT:
                      return "Right";
                  case KeyEvent.KEY_LOCATION_LEFT:
                      return "Left";
                  case KeyEvent.KEY_LOCATION_NUMPAD:
                      return "NumPad";
                  case KeyEvent.KEY_LOCATION_STANDARD:
                      return "Standard";
                  case KeyEvent.KEY_LOCATION_UNKNOWN:
                  default:
                      return "Unknown";
              }
          }
      };
      JTextField textField = new JTextField();
      textField.addKeyListener(listener);
      contentPane.add(textField, BorderLayout.NORTH);
      frame.pack();
      frame.setVisible(true);
  }
	  
      // Write some code here!
      //bigman.setWheelVelocities(10,10,1);
      // Always end your program with finch.quit()
 }