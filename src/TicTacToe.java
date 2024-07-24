import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe implements ActionListener{
    Random ran = new Random();
    JFrame frame =new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel text_field= new JLabel();           //for text_field
    JButton[] buttons=new JButton[9];         //for buttons--we need 9 buttons hin this game


     boolean playerA_turn;

      TicTacToe(){
          //threading the jframe
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          //size for the frame
          frame.setSize(900, 900);
          frame.getContentPane().setBackground(new Color(133, 39, 171));  //set color for the bg
          frame.setLayout(new BorderLayout());//setting layout for the frame
          frame.setVisible(true);

          //bg color for the text_field
          text_field.setBackground(new Color(25,25,25));
          text_field.setForeground(new Color(236, 236, 243));
          text_field.setFont(new Font("INK FONT",Font.BOLD, 75 ));
          text_field.setHorizontalAlignment(JLabel.CENTER);
          text_field.setText("Tic-Tac-Toe!!");
          text_field.setOpaque(true);

          title_panel.setLayout(new BorderLayout());
          title_panel.setBounds(0,0,800, 100);//co-ordinates from where to start

          button_panel.setLayout(new GridLayout(3,3));
          button_panel.setBackground(new Color(150,150,150));

           for(int i=0;i<9;i++){
               buttons[i]=new JButton();
               button_panel.add(buttons[i]);
               buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
               buttons[i].setFocusable(false);
               buttons[i].addActionListener(this);
           }

          title_panel.add(text_field);
          frame.add(title_panel,BorderLayout.NORTH);
          frame.add(button_panel);

          //whose turn is first

          first_turn();
      }
      @Override
      public void actionPerformed(ActionEvent e){

          for(int i=0;i<9;i++){
              if(e.getSource()==buttons[i]){
                  if(playerA_turn){
                      if(buttons[i].getText()==""){
                          buttons[i].setForeground(new Color(255, 0,0));
                          buttons[i].setText("X");
                          playerA_turn=false;
                          text_field.setText("O turn");
                          check();
                      }
                  }
                  else{
                      if(buttons[i].getText()==""){
                          buttons[i].setForeground(new Color( 0,0,255));
                          buttons[i].setText("O");
                          playerA_turn=true;
                          text_field.setText("X turn");
                          check();
                      }

                  }
              }
          }
      }

      public void first_turn(){

          try {
              Thread.sleep(5000);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          if(ran.nextInt(2)==0){
              playerA_turn=true;
              text_field.setText("X turn");
          }
          else{
              playerA_turn=false;
              text_field.setText("O turn");
          }

      }
      public void  check(){
          //check x win conditions
          if(     (buttons[0].getText()=="X") &&
                  (buttons[1].getText()=="X") &&
                  (buttons[2].getText()=="X")
          ){
               x_wins(0,1,2);
          }
          if(     (buttons[3].getText()=="X") &&
                  (buttons[4].getText()=="X") &&
                  (buttons[5].getText()=="X")
          ){
              x_wins(3,4,5);
          }
          if(     (buttons[6].getText()=="X") &&
                  (buttons[7].getText()=="X") &&
                  (buttons[8].getText()=="X")
          ){
              x_wins(6,7,8);
          }
          if(     (buttons[0].getText()=="X") &&
                  (buttons[3].getText()=="X") &&
                  (buttons[6].getText()=="X")
          ){
              x_wins(0,3,6);
          }
          if(     (buttons[1].getText()=="X") &&
                  (buttons[4].getText()=="X") &&
                  (buttons[7].getText()=="X")
          ){
              x_wins(1,4,7);
          }
          if(     (buttons[2].getText()=="X") &&
                  (buttons[5].getText()=="X") &&
                  (buttons[8].getText()=="X")
          ){
              x_wins(2,5,8);
          }
          if(     (buttons[0].getText()=="X") &&
                  (buttons[4].getText()=="X") &&
                  (buttons[8].getText()=="X")
          ){
              x_wins(0,4,8);
          }
          if(     (buttons[2].getText()=="X") &&
                  (buttons[4].getText()=="X") &&
                  (buttons[6].getText()=="X")
          ){
              x_wins(2,4,6);
          }

          //check o win conditions

          if(     (buttons[0].getText()=="O") &&
                  (buttons[1].getText()=="O") &&
                  (buttons[2].getText()=="O")
          ){
              o_wins(0,1,2);
          }
          if(     (buttons[3].getText()=="O") &&
                  (buttons[4].getText()=="O") &&
                  (buttons[5].getText()=="O")
          ){
              o_wins(3,4,5);
          }
          if(     (buttons[6].getText()=="O") &&
                  (buttons[7].getText()=="O") &&
                  (buttons[8].getText()=="O")
          ){
              o_wins(6,7,8);
          }
          if(     (buttons[0].getText()=="O") &&
                  (buttons[3].getText()=="O") &&
                  (buttons[6].getText()=="O")
          ){
              o_wins(0,3,6);
          }
          if(     (buttons[1].getText()=="O") &&
                  (buttons[4].getText()=="O") &&
                  (buttons[7].getText()=="O")
          ){
              o_wins(1,4,7);
          }
          if(     (buttons[2].getText()=="O") &&
                  (buttons[5].getText()=="O") &&
                  (buttons[8].getText()=="O")
          ){
              o_wins(2,5,8);
          }
          if(     (buttons[0].getText()=="O") &&
                  (buttons[4].getText()=="O") &&
                  (buttons[8].getText()=="O")
          ){
                o_wins(0,4,8);
          }
          if(     (buttons[2].getText()=="O") &&
                  (buttons[4].getText()=="O") &&
                  (buttons[6].getText()=="O")
          ){
              o_wins(2,4,6);
          }



      }
      public void x_wins(int a, int b, int c){
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);

            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            text_field.setText("X wins");

      }
      public void o_wins(int a , int b ,int c){
          buttons[a].setBackground(Color.GREEN);
          buttons[b].setBackground(Color.GREEN);
          buttons[c].setBackground(Color.GREEN);

          for(int i=0;i<9;i++){
              buttons[i].setEnabled(false);
          }
          text_field.setText("O wins");


      }


}
