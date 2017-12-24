import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Stage01 extends JFrame {
    public Stage01() {
        initComp();
    }
    //Player
    private ImageIcon Player_RN = new ImageIcon("Image\\Player_RN.png");
    private ImageIcon Player_LN = new ImageIcon("Image\\Player_LN.png");
    private ImageIcon Player_R1 = new ImageIcon("Image\\Player_R1.png");
    private ImageIcon Player_L1 = new ImageIcon("Image\\Player_L1.png");
    private ImageIcon Player_R2 = new ImageIcon("Image\\Player_R2.png");
    private ImageIcon Player_L2 = new ImageIcon("Image\\Player_L2.png");
    private ImageIcon Player_RJ = new ImageIcon("Image\\Player_RJ.png");
    private ImageIcon Player_LJ = new ImageIcon("Image\\Player_LJ.png");
    private ImageIcon Player_RD = new ImageIcon("Image\\Player_RD.png");
    private ImageIcon Player_LD = new ImageIcon("Image\\Player_LD.png");
    private ImageIcon Player_RA = new ImageIcon("Image\\Player_RA.png");
    private ImageIcon Player_LA = new ImageIcon("Image\\Player_LA.png");

    private JLabel jlbPlayer = new JLabel(Player_RN);

    private int Plaw = 0 , Plah = 567;

    private boolean foot , direction , jlock = false , dlock = false;

    private Timer walkrt , walklt , jumput , jumpdt;

    //Player Attack
    private ImageIcon Hat = new ImageIcon("Image\\Hat.png");

    private JLabel jlbHat1 = new JLabel(Hat);
    private JLabel jlbHat2 = new JLabel(Hat);
    private JLabel jlbHat3 = new JLabel(Hat);

    private int Haw1 , Hah1 , hatime1;
    private int Haw2 , Hah2 , hatime2;
    private int Haw3 , Hah3 , hatime3;

    private boolean halock1 = false;
    private boolean halock2 = false;
    private boolean halock3 = false;

    private Timer rightatt1 , leftatt1;
    private Timer rightatt2 , leftatt2;
    private Timer rightatt3 , leftatt3;

    //HP
    private JLabel jlbHPPla = new JLabel();
    private JLabel jlbHPPlaB = new JLabel();
    private JLabel jlbHPBos = new JLabel();
    private JLabel jlbHPBosB = new JLabel();

    private int HPPlah = 200 , HPPlaw = 50;
    private int HPBosh = 200, HPBosw = 50;

    //Window
    private int sw = getToolkit().getScreenSize().width;
    private int sh = getToolkit().getScreenSize().height;
    private int fw = 1200, fh = 800;

    private void initComp() {
        //Window
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(sw / 2 - fw / 2, sh / 2 - fh / 2, fw, fh);
        this.setLayout(null);
        this.setTitle("請輸入標題");
        this.addKeyListener(new KeyMonitor());

        //Player
        jlbPlayer.setBounds(Plaw, Plah, 200, 200);
        this.add(jlbPlayer);

        walkrt = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                direction = true;
                if(Plaw + 20 <= 1000){
                    jlbPlayer.setBounds(Plaw += 20 , Plah, 200, 200);}
                if(foot == true && jlock == false && dlock == false){jlbPlayer.setIcon(Player_R2) ; foot = false;}
                else if(foot == false && jlock == false && dlock == false){jlbPlayer.setIcon(Player_R1) ; foot = true;}
                else if(jlock == true){jlbPlayer.setIcon(Player_RJ);}
                else if(dlock == true){jlbPlayer.setIcon(Player_RD);}
            }
        });
        walklt = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                direction = false;
                if(Plaw - 20 >= 0){
                    jlbPlayer.setBounds(Plaw -= 20 , Plah, 200, 200);}
                if(foot == true && jlock == false && dlock == false){jlbPlayer.setIcon(Player_L2) ; foot = false;}
                else if(foot == false && jlock == false && dlock == false){jlbPlayer.setIcon(Player_L1) ; foot = true;}
                else if(jlock == true){jlbPlayer.setIcon(Player_LJ);}
                else if(dlock == true){jlbPlayer.setIcon(Player_LD);}
            }
        });
        jumput = new Timer(35, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbPlayer.setBounds(Plaw , Plah -= 30 , 200, 200);
                if(Plah == 297){jumput.stop() ; jumpdt.start();}
            }
        });
        jumpdt = new Timer(35, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbPlayer.setBounds(Plaw , Plah += 30 , 200, 200);
                if(Plah == 567){jumpdt.stop();
                    if(direction == true){jlbPlayer.setIcon(Player_RN);}
                    else if(direction == false){jlbPlayer.setIcon(Player_LN);}
                    jlock = false;}
            }
        });

        //Player Attack
        jlbHat1.setBounds(Plaw , Plah , 85 , 28);
        jlbHat2.setBounds(Plaw , Plah , 85 , 28);
        jlbHat3.setBounds(Plaw , Plah , 85 , 28);

        this.add(jlbHat1);
        this.add(jlbHat2);
        this.add(jlbHat3);
        jlbHat1.setVisible(false);
        jlbHat2.setVisible(false);
        jlbHat3.setVisible(false);

        rightatt1 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat1.setBounds(Haw1 += 40 , Hah1 , 85 , 28);
                hatime1 += 1;
                if(hatime1 == 12){rightatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;}
            }
        });
        leftatt1 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat1.setBounds(Haw1 -= 40 , Hah1 , 85 , 28);
                hatime1 += 1;
                if(hatime1 == 12){leftatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;}
            }
        });
        rightatt2 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat2.setBounds(Haw2 += 40 , Hah2 , 85 , 28);
                hatime2 += 1;
                if(hatime2 == 12){rightatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;}
            }
        });
        leftatt2 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat2.setBounds(Haw2 -= 40 , Hah2 , 85 , 28);
                hatime2 += 1;
                if(hatime2 == 12){leftatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;}
            }
        });
        rightatt3 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat3.setBounds(Haw3 += 40 , Hah3 , 85 , 28);
                hatime3 += 1;
                if(hatime3 == 12){rightatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;}
            }
        });
        leftatt3 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat3.setBounds(Haw3 -= 40 , Hah3 , 85 , 28);
                hatime3 += 1;
                if(hatime3 == 12){leftatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;}
            }
        });

        //HP
        jlbHPPla.setBounds(fw / 2  - 550 , HPPlaw , 30 , HPPlah);
        jlbHPBos.setBounds(fw / 2  + 510 , HPBosw , 30 , HPBosh);
        jlbHPPlaB.setBounds(fw / 2  - 550 , HPPlaw , 30 , 200);
        jlbHPBosB.setBounds(fw / 2  + 510 , HPBosw , 30 , 200);
        jlbHPPla.setOpaque(true);
        jlbHPBos.setOpaque(true);
        jlbHPPlaB.setOpaque(true);
        jlbHPBosB.setOpaque(true);
        jlbHPPla.setBackground(Color.green);
        jlbHPBos.setBackground(Color.green);
        jlbHPPlaB.setBackground(Color.red);
        jlbHPBosB.setBackground(Color.red);
        this.add(jlbHPPla);
        this.add(jlbHPBos);
        this.add(jlbHPPlaB);
        this.add(jlbHPBosB);
    }

    private class KeyMonitor extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    walklt.start();
                    break;
                case KeyEvent.VK_RIGHT :
                    walkrt.start();
                    break;
                case KeyEvent.VK_UP :
                    if(jlock == false){dlock = false;
                        if(direction == true){jlbPlayer.setIcon(Player_RJ);}
                        else if(direction == false){jlbPlayer.setIcon(Player_LJ);}
                        jumput.start();
                        jlock = true;}
                    break;
                case KeyEvent.VK_DOWN :
                    if(dlock == false && jlock == false){
                        if(direction == true){jlbPlayer.setIcon(Player_RD);}
                        else if(direction == false){jlbPlayer.setIcon(Player_LD);}
                    dlock = true;}
                    break;
                case KeyEvent.VK_Z :
                    if(halock1 == false){
                        if(direction == true){rightatt1.start() ; Haw1 = Plaw + 120;}
                        else if(direction == false){leftatt1.start() ; Haw1 = Plaw;}
                        if(dlock == false){Hah1 = Plah + 60;}
                        else if(dlock == true){Hah1 = Plah + 120;}
                        jlbHat1.setBounds(Haw1 , Hah1 , 85 , 28);
                        jlbHat1.setVisible(true);
                        if(direction == true && jlock == false && dlock == false){jlbPlayer.setIcon(Player_RA);}
                        else if(direction == false && jlock == false && dlock == false){jlbPlayer.setIcon(Player_LA);}
                        hatime1 = 0;
                        halock1 = true;}
                    else if(halock1 == true && halock2 == false){
                        if(direction == true){rightatt2.start() ; Haw2 = Plaw + 120;}
                        else if(direction == false){leftatt2.start() ; Haw2 = Plaw;}
                        if(dlock == false){Hah2 = Plah + 60;}
                        else if(dlock == true){Hah2 = Plah + 120;}
                        jlbHat2.setBounds(Haw2 , Hah2 , 85 , 28);
                        jlbHat2.setVisible(true);
                        if(direction == true && jlock == false && dlock == false){jlbPlayer.setIcon(Player_RA);}
                        else if(direction == false && jlock == false && dlock == false){jlbPlayer.setIcon(Player_LA);}
                        hatime2 = 0;
                        halock2 = true;}
                    else if(halock1 == true && halock2 == true && halock3 == false){
                        if(direction == true){rightatt3.start() ; Haw3 = Plaw + 120;}
                        else if(direction == false){leftatt3.start() ; Haw3 = Plaw;}
                        if(dlock == false){Hah3 = Plah + 60;}
                        else if(dlock == true){Hah3 = Plah + 120;}
                        jlbHat3.setBounds(Haw3 , Hah3 , 85 , 28);
                        jlbHat3.setVisible(true);
                        if(direction == true && jlock == false && dlock == false){jlbPlayer.setIcon(Player_RA);}
                        else if(direction == false && jlock == false && dlock == false){jlbPlayer.setIcon(Player_LA);}
                        hatime3 = 0;
                        halock3 = true;}
                    break;
            }
        }
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    walklt.stop();
                    break;
                case KeyEvent.VK_RIGHT :
                    walkrt.stop();
                    break;
                case KeyEvent.VK_DOWN :
                    if(jlock == false){
                    if(direction == true){jlbPlayer.setIcon(Player_RN);}
                    else if(direction == false){jlbPlayer.setIcon(Player_LN);}
                    dlock = false;}
                    break;
                case KeyEvent.VK_Z :
                    if(jlock == false && dlock == false){
                        if(direction == true){jlbPlayer.setIcon(Player_RN);}
                        else if(direction == false){jlbPlayer.setIcon(Player_LN);}}
                    break;
            }
        }
    }
}