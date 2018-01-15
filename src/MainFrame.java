import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame{
    public MainFrame(){
        initComp();
    }
    private JLabel jlbStart = new JLabel("Start",JLabel.CENTER);
    private JLabel jlbExit = new JLabel("Exit",JLabel.CENTER);
    private JLabel jlbHelp = new JLabel("Help",JLabel.CENTER);

    private boolean lock = false;

    private JLabel jlbTitle = new JLabel("章魚梅子",JLabel.CENTER);

    private ImageIcon Hat = new ImageIcon("Image\\Hat.png");

    private JLabel jlbHat = new JLabel(Hat);
    private int Haw = 408 , Hah = 323;

    private int sw = getToolkit().getScreenSize().width;
    private int sh = getToolkit().getScreenSize().height;
    private int fw = 900 , fh = 600;

    private void initComp(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(sw / 2 - fw / 2 , sh / 2 - fh / 2 , fw , fh);
        this.setLayout(null);
        this.setTitle("Title");

        jlbStart.setBounds(fw / 2 - 350 , fh / 2 + 50 , 200 , 100);
        jlbHelp.setBounds(fw / 2 - 100 , fh / 2 + 50 , 200 , 100);
        jlbExit.setBounds(fw / 2 + 150 , fh / 2 + 50 , 200 , 100);
        jlbTitle.setBounds(fw / 2 - 300 , fh / 2 - 235 , 600 , 200);
        jlbStart.setOpaque(true);
        jlbHelp.setOpaque(true);
        jlbExit.setOpaque(true);
        jlbTitle.setOpaque(true);
        jlbStart.setBackground(Color.GREEN);
        jlbHelp.setBackground(Color.GREEN);
        jlbExit.setBackground(Color.GREEN);
        jlbTitle.setBackground(Color.GREEN);
        jlbStart.setFont(new Font(null,0,40));
        jlbHelp.setFont(new Font(null,0,40));
        jlbExit.setFont(new Font(null,0,40));
        jlbTitle.setFont(new Font(null,0,100));
        this.add(jlbStart);
        this.add(jlbHelp);
        this.add(jlbExit);
        this.add(jlbTitle);
        //jlbHelp2.setVisible(false);

        jlbHat.setBounds(Haw , Hah , 85 , 28);
        this.add(jlbHat);

        this.addKeyListener(new KeyMonitor());

    }
    private class KeyMonitor extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    if(!lock && Haw == 408 || !lock && Haw == 658){jlbHat.setBounds(Haw -= 250, Hah , 85 , 28);}
                    break;
                case KeyEvent.VK_RIGHT :
                    if(!lock && Haw == 408 || !lock && Haw == 158){jlbHat.setBounds(Haw += 250, Hah , 85 , 28);}
                    break;
                case KeyEvent.VK_ENTER :
                    if(Haw == 158){
                        Stage stage = new Stage();
                        stage.setVisible(true);
                        MainFrame.this.setVisible(false);}
                    else if(Haw == 408){
                        if(!lock){jlbStart.setText("Z攻擊") ; jlbHelp.setText("Back") ; jlbExit.setText("方向鍵移動") ; lock = true;}
                        else if(lock){jlbStart.setText("Start") ; jlbHelp.setText("Help") ; jlbExit.setText("Exit") ; lock = false;}}
                    else if(Haw == 658){System.exit(0);}

            }
        }
    }
}