package com.gilachus.chronometer3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;

//https://www.youtube.com/watch?v=i_1JPCM0VcM
public class Chronometer4 extends JFrame implements ActionListener{
    private int seconds, minutes, hours;
    private Timer chronometer;
    private JButton runStop, restart;
    private JLabel time;

    public Chronometer4(){
            this.setTitle("Chronometer");
            this.setSize(250, 80);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));

            runStop = new JButton("run");
            runStop.addActionListener(this);

            restart = new JButton("restart");
            restart.addActionListener(this);



            seconds = 0;
            minutes = 0;
            hours = 0;

            time = new JLabel(hours+" : "+minutes+" : "+seconds);

            this.add(runStop);
            this.add(restart);
            this.add(time);

            chronometer = new Timer(1000, this);

    }
    public static void main(String[] args){
            Chronometer4 chronometer4 = new Chronometer4();
            chronometer4.setVisible(true);
    }	

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof Timer){
                    seconds ++;
                    if(seconds == 60){
                            minutes ++;
                            seconds = 0;
                            if(minutes == 60){
                            hours ++;
                            minutes = 0;
                            }
                    }
                    time.setText(hours+" : "+minutes+" : "+seconds);
                    return;
            }else if(e.getSource() instanceof JButton){
                    JButton button = (JButton)e.getSource();
                    if(button.getText().equals("run")){
                            chronometer.start();
                            button.setText("stop");
                    }else if(button.getText().equals("stop")){
                            chronometer.stop();
                            button.setText("run");

                    }else if(button.getText().equals("restart")){
                            seconds = 0;
                            minutes = 0;
                            hours = 0;
                            chronometer.stop();
                            time.setText(hours+" : "+minutes+" : "+seconds);
                    }
            }
    }
}

