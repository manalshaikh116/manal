                                                     import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class Ping extends JFrame implements ActionListener{

private JButton runButton = new JButton("Run");
private JLabel pingResult = new JLabel("Result"); 
private String results;

public Ping(){
    runButton.addActionListener(this);

    add(pingResult, BorderLayout.CENTER);
    add(runButton, BorderLayout.NORTH);

}

//Action Listener
public void actionPerformed(ActionEvent e)
{
    String buttonString = e.getActionCommand( );

    if (buttonString.equals("Run"))
    {
        //Execute Ping
        try {
            String line;
            Process p = Runtime.getRuntime().exec("ping www.google.com -c 2");
            BufferedReader input = new BufferedReader(
                new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                results += line + "\n";
                pingResult.setText(results);
                //System.out.println(line);
            }

            input.close();
        }catch (Exception err){
            err.printStackTrace();
        }

    }else{
        System.exit(0);
    }
}

public static void main(String[] args) {
    Ping sp = new Ping();
    sp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    sp.setSize(400, 400);
    sp.setVisible(true);
    sp.setLayout(new FlowLayout());
}

}
