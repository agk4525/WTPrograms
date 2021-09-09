import java.awt.*;
import java.awt.event.*;
class MyCalculator extends Frame implements ActionListener
{
     TextField tf;
     Panel panel;
     
     String btns[] = {"1", "2", "3", "+","4", "5", "6", "-","7", "8", "9", "*","C", "0", "=", "/"};
    Button btn[] = new Button[16];   
     int i,num1=0,num2=0,result=0;
     char ch;
     
     public MyCalculator() {
     
      Font f=new Font("SansSerif",Font.BOLD,20);
      tf=new TextField(10);
      tf.setFont(f);
      panel=new Panel();
      add(tf,"North");
      add(panel,"Center");
      panel.setLayout(new GridLayout(4,4));
      for(i=0;i<16;i++) {
       btn[i]= new Button(btns[i]);
       btn[i].setFont(f);
       btn[i].addActionListener(this);
       panel.add(btn[i]);
      }
      addWindowListener(new WindowAdapter(){
       
       public void windowClosing(WindowEvent we) {
        System.exit(0);}});
      }
     public void actionPerformed(ActionEvent ae) {
                String str=ae.getActionCommand();
                if(str.equals("+")) {
                        ch='+';
                        num1=Integer.parseInt(tf.getText());
                        tf.setText("");
                }
                else if(str.equals("-")) {
                        ch='-';
                        num1=Integer.parseInt(tf.getText());
                        tf.setText("");
                }
                else if(str.equals("*")) {
                        ch='*';
                        num1=Integer.parseInt(tf.getText());
                        tf.setText("");
                }
                else if(str.equals("/")) {
                        ch='/';
                        num1=Integer.parseInt(tf.getText());
                        tf.setText("");
                }
                else if(str.equals("=")) {
                        num2=Integer.parseInt(tf.getText());
                        switch(ch) {
                              case '+' : result=num1+num2;
                                             break;
                              case '-' : result=num1-num2;
                                             break;
                              case '*' : result=num1*num2;
                                             break;
                              case '/' : result=num1/num2;
                                             break;
                         }
                         tf.setText(result + "");
                         result=0;
                }
                else if(str.equals("C")) {
                         tf.setText("");
                         num1=num2=result=0;
                }
                else {
                         tf.setText(tf.getText() + str);
                }
        }
     
     public static void main(String args[]) {
      
                MyCalculator m=new MyCalculator();
                m.setTitle("My Calculator");
                m.setSize(350,400);
                m.setVisible(true);
     }
}
