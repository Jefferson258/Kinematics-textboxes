import javax.swing.*;
import java.text.*;

public class Kinematics
 {
   public static void main(String[] args)
   {
      DecimalFormat df = new DecimalFormat("0.000");
       
      JTextField sField = new JTextField(10);
      JPanel sPanel = new JPanel();
      sPanel.add(new JLabel("What do you want to solve for? Enter acceleration, displacement, final velocity, initial velocity, or time."));
      sPanel.add(sField);
      int r = JOptionPane.showConfirmDialog(null, sPanel, "Please Enter Kinematic Values", JOptionPane.OK_CANCEL_OPTION);
      
      double a = Double.POSITIVE_INFINITY, disp = Double.POSITIVE_INFINITY, vf = Double.POSITIVE_INFINITY, vi = Double.POSITIVE_INFINITY, t = Double.POSITIVE_INFINITY;
      
      JTextField aField = new JTextField(5);
      JTextField dField = new JTextField(5);
      JTextField vfField = new JTextField(5);
      JTextField viField = new JTextField(5);
      JTextField tField = new JTextField(5);


      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Acceleration:"));
      myPanel.add(aField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Displacement:"));
      myPanel.add(dField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Final Velocity:"));
      myPanel.add(vfField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Initial Velocity:"));
      myPanel.add(viField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Time:"));
      myPanel.add(tField);
      myPanel.add(Box.createVerticalStrut(15)); // a spacer
      myPanel.add(new JLabel("If you do not have the value, leave the space blank"));

      int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Kinematic Values", JOptionPane.OK_CANCEL_OPTION);

      if (result == JOptionPane.OK_OPTION) 
      {
          if(!aField.getText().equals(""))
            a = Double.parseDouble(aField.getText());
          if(!dField.getText().equals(""))
            disp = Double.parseDouble(dField.getText());
          if(!vfField.getText().equals(""))
            vf = Double.parseDouble(vfField.getText());
          if(!viField.getText().equals(""))
            vi = Double.parseDouble(viField.getText());
          if(!tField.getText().equals(""))
            t = Double.parseDouble(tField.getText());
      }
      
      Kin solve = new Kin(a, vi, vf, disp, t);
      if(sField.getText().equals("acceleration"))
        System.out.println(df.format(solve.solveForAcceleration()) + " m/s^2");
      else if(sField.getText().equals("time"))
        System.out.println(df.format(solve.solveForTime()) + " s");
      else if(sField.getText().equals("final velocity"))
        System.out.println(df.format(solve.solveForVf()) + " m/s");
      else if(sField.getText().equals("initial velocity"))
        System.out.println(df.format(solve.solveForVi()) + " m/s");  
      else if(sField.getText().equals("displacement"))
        System.out.println(df.format(solve.solveForDisplacement()) + " m");  
   }
}