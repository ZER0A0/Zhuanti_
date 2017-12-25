import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Stage extends JFrame {
    public Stage() {
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

    private boolean foot , direction = true , jlock = false , dlock = false;

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

    //TEST
    private JLabel jlbHatTEST = new JLabel(Hat);
    private int HawTEST , HahTEST , hatimeTEST;
    private boolean halockTEST = false;
    private Timer rightattTEST;

    //Boss
    private ImageIcon NBoss_LN = new ImageIcon("Image\\NBoss_LN.png");
    private ImageIcon GBoss_LN = new ImageIcon("Image\\GBoss_LN.png");
    private ImageIcon NBoss_RN = new ImageIcon("Image\\NBoss_RN.png");
    private ImageIcon GBoss_RN = new ImageIcon("Image\\GBoss_RN.png");
    private ImageIcon NBoss_LD = new ImageIcon("Image\\NBoss_LD.png");
    private ImageIcon GBoss_LD = new ImageIcon("Image\\GBoss_LD.png");
    private ImageIcon NBoss_RD = new ImageIcon("Image\\NBoss_RD.png");
    private ImageIcon GBoss_RD = new ImageIcon("Image\\GBoss_RD.png");
    private ImageIcon NBoss_LA = new ImageIcon("Image\\NBoss_LA.png");
    private ImageIcon GBoss_LA = new ImageIcon("Image\\GBoss_LA.png");
    private ImageIcon NBoss_RA = new ImageIcon("Image\\NBoss_RA.png");
    private ImageIcon GBoss_RA = new ImageIcon("Image\\GBoss_RA.png");
    private ImageIcon NBoss_LAD = new ImageIcon("Image\\NBoss_LAD.png");
    private ImageIcon GBoss_LAD = new ImageIcon("Image\\GBoss_LAD.png");
    private ImageIcon NBoss_RAD = new ImageIcon("Image\\NBoss_RAD.png");
    private ImageIcon GBoss_RAD = new ImageIcon("Image\\GBoss_RAD.png");
    private ImageIcon GBoss_LAU = new ImageIcon("Image\\GBoss_LAU.png");
    private ImageIcon GBoss_RAU = new ImageIcon("Image\\GBoss_RAU.png");
    private ImageIcon NBoss_F1 = new ImageIcon("Image\\NBoss_F1.png");
    private ImageIcon NBoss_F2 = new ImageIcon("Image\\NBoss_F2.png");
    private ImageIcon NBoss_F3 = new ImageIcon("Image\\NBoss_F3.png");
    private ImageIcon NBoss_F4 = new ImageIcon("Image\\NBoss_F4.png");
    private ImageIcon NBoss_F5 = new ImageIcon("Image\\NBoss_F5.png");
    private ImageIcon NBoss_F6 = new ImageIcon("Image\\NBoss_F6.png");
    private ImageIcon NBoss_F7 = new ImageIcon("Image\\NBoss_F7.png");
    private ImageIcon NBoss_F8 = new ImageIcon("Image\\NBoss_F8.png");
    private ImageIcon GBoss_F1 = new ImageIcon("Image\\GBoss_F1.png");
    private ImageIcon GBoss_F2 = new ImageIcon("Image\\GBoss_F2.png");
    private ImageIcon GBoss_F3 = new ImageIcon("Image\\GBoss_F3.png");
    private ImageIcon GBoss_F4 = new ImageIcon("Image\\GBoss_F4.png");
    private ImageIcon GBoss_F5 = new ImageIcon("Image\\GBoss_F5.png");
    private ImageIcon GBoss_F6 = new ImageIcon("Image\\GBoss_F6.png");
    private ImageIcon GBoss_F7 = new ImageIcon("Image\\GBoss_F7.png");
    private ImageIcon GBoss_F8 = new ImageIcon("Image\\GBoss_F8.png");

    private JLabel jlbBoss = new JLabel(NBoss_LN);

    private int Bosw = 950 , Bosh = 567;

    private boolean Bosdirection , Bosdlock = false;

    //HP
    private JLabel jlbHPPla = new JLabel();
    private JLabel jlbHPPlaB = new JLabel();
    private JLabel jlbHPBos = new JLabel();
    private JLabel jlbHPBosB = new JLabel();

    private int HPPlah = 200 , HPPlay = 50;
    private int HPBosh = 200, HPBosy = 50;
    private int PlaDamage = 5;

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
                    if(direction){jlbPlayer.setIcon(Player_RN);}
                    else if(!direction){jlbPlayer.setIcon(Player_LN);}
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
                if(!Bosdlock && Haw1 >= Bosw + 40 && Haw1 <= Bosw + 120 && Hah1 >= Bosh - 7 && Hah1 <= Bosh + 189){
                    rightatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw1 >= Bosw + 40 && Haw1 <= Bosw + 120 && Hah1 >= Bosh + 41 && Hah1 <= Bosh + 189){
                    rightatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                jlbHat1.setBounds(Haw1 += 40 , Hah1 , 85 , 28);
                hatime1 += 1;
                if(hatime1 == 12){rightatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;}
            }
        });
        leftatt1 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw1 >= Bosw - 10 && Haw1 <= Bosw + 70 && Hah1 >= Bosh - 7 && Hah1 <= Bosh + 189){
                    leftatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw1 >= Bosw - 10 && Haw1 <= Bosw + 70 && Hah1 >= Bosh + 41 && Hah1 <= Bosh + 189){
                    leftatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                jlbHat1.setBounds(Haw1 -= 40 , Hah1 , 85 , 28);
                hatime1 += 1;
                if(hatime1 == 12){leftatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;}
            }
        });
        rightatt2 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw2 >= Bosw + 40 && Haw2 <= Bosw + 120 && Hah2 >= Bosh - 7 && Hah2 <= Bosh + 189){
                    rightatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw2 >= Bosw + 40 && Haw2 <= Bosw + 120 && Hah2 >= Bosh + 41 && Hah2 <= Bosh + 189){
                    rightatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                jlbHat2.setBounds(Haw2 += 40 , Hah2 , 85 , 28);
                hatime2 += 1;
                if(hatime2 == 12){rightatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;}
            }
        });
        leftatt2 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw2 >= Bosw - 10 && Haw2 <= Bosw + 70 && Hah2 >= Bosh - 7 && Hah2 <= Bosh + 189){
                    leftatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw2 >= Bosw - 10 && Haw2 <= Bosw + 70 && Hah2 >= Bosh + 41 && Hah2 <= Bosh + 189){
                    leftatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                jlbHat2.setBounds(Haw2 -= 40 , Hah2 , 85 , 28);
                hatime2 += 1;
                if(hatime2 == 12){leftatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;}
            }
        });
        rightatt3 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw3 >= Bosw + 40 && Haw3 <= Bosw + 120 && Hah3 >= Bosh - 7 && Hah3 <= Bosh + 189){
                    rightatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw3 >= Bosw + 40 && Haw3 <= Bosw + 120 && Hah3 >= Bosh + 41 && Hah3 <= Bosh + 189){
                    rightatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                jlbHat3.setBounds(Haw3 += 40 , Hah3 , 85 , 28);
                hatime3 += 1;
                if(hatime3 == 12){rightatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;}
            }
        });
        leftatt3 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw3 >= Bosw - 10 && Haw3 <= Bosw + 70 && Hah3 >= Bosh - 7 && Hah3 <= Bosh + 189){
                    leftatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw3 >= Bosw - 10 && Haw3 <= Bosw + 70 && Hah3 >= Bosh + 41 && Hah3 <= Bosh + 189){
                    leftatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                jlbHat3.setBounds(Haw3 -= 40 , Hah3 , 85 , 28);
                hatime3 += 1;
                if(hatime3 == 12){leftatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;}
            }
        });

        //TEST
        jlbHatTEST.setBounds(600 , 608 , 85 , 28);
        this.add(jlbHatTEST);

        rightattTEST = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHatTEST.setBounds(HawTEST -= 40 , HahTEST , 85 , 28);
                hatimeTEST += 1;
                if(HawTEST >= Bosw - 60 && HawTEST <= Bosw + 20 && HahTEST >= Bosh + 41 && HahTEST <= Bosh + 189){
                    rightattTEST.stop() ; jlbHatTEST.setVisible(false) ; halockTEST = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);
                }
                if(hatimeTEST == 12){rightattTEST.stop() ; jlbHatTEST.setVisible(false) ; halockTEST = false;}
            }
        });

        //Boss
        jlbBoss.setBounds(Bosw, Bosh, 200, 200);
        this.add(jlbBoss);

        //HP
        jlbHPPla.setBounds(fw / 2  - 550 , HPPlay , 30 , HPPlah);
        jlbHPBos.setBounds(fw / 2  + 510 , HPBosy , 30 , HPBosh);
        jlbHPPlaB.setBounds(fw / 2  - 550 , HPPlay , 30 , 200);
        jlbHPBosB.setBounds(fw / 2  + 510 , HPBosy , 30 , 200);
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
                    if(!jlock){dlock = false;
                        if(direction){jlbPlayer.setIcon(Player_RJ);}
                        else if(!direction){jlbPlayer.setIcon(Player_LJ);}
                        jumput.start();
                        jlock = true;}
                    break;
                case KeyEvent.VK_DOWN :
                    if(!dlock && !jlock){
                        if(direction){jlbPlayer.setIcon(Player_RD);}
                        else if(!direction){jlbPlayer.setIcon(Player_LD);}
                    dlock = true;}
                    break;
                case KeyEvent.VK_Z :
                    if(!halock1){
                        if(direction){rightatt1.start() ; Haw1 = Plaw + 120;}
                        else if(!direction){leftatt1.start() ; Haw1 = Plaw;}
                        if(!dlock){Hah1 = Plah + 60;}
                        else if(dlock){Hah1 = Plah + 120;}
                        jlbHat1.setBounds(Haw1 , Hah1 , 85 , 28);
                        jlbHat1.setVisible(true);
                        if(direction && !jlock && !dlock){jlbPlayer.setIcon(Player_RA);}
                        else if(!direction && !jlock && !dlock){jlbPlayer.setIcon(Player_LA);}
                        hatime1 = 0;
                        halock1 = true;}
                    else if(halock1 && !halock2){
                        if(direction){rightatt2.start() ; Haw2 = Plaw + 120;}
                        else if(!direction){leftatt2.start() ; Haw2 = Plaw;}
                        if(!dlock){Hah2 = Plah + 60;}
                        else if(dlock){Hah2 = Plah + 120;}
                        jlbHat2.setBounds(Haw2 , Hah2 , 85 , 28);
                        jlbHat2.setVisible(true);
                        if(direction && !jlock && !dlock){jlbPlayer.setIcon(Player_RA);}
                        else if(!direction && !jlock && !dlock){jlbPlayer.setIcon(Player_LA);}
                        hatime2 = 0;
                        halock2 = true;}
                    else if(halock1 && halock2 && !halock3){
                        if(direction){rightatt3.start() ; Haw3 = Plaw + 120;}
                        else if(!direction){leftatt3.start() ; Haw3 = Plaw;}
                        if(!dlock){Hah3 = Plah + 60;}
                        else if(dlock){Hah3 = Plah + 120;}
                        jlbHat3.setBounds(Haw3 , Hah3 , 85 , 28);
                        jlbHat3.setVisible(true);
                        if(direction && !jlock && !dlock){jlbPlayer.setIcon(Player_RA);}
                        else if(!direction && !jlock && !dlock){jlbPlayer.setIcon(Player_LA);}
                        hatime3 = 0;
                        halock3 = true;}
                    break;
                case KeyEvent.VK_X :
                    Bosw = 55;
                    jlbBoss.setBounds(Bosw, Bosh, 200, 200);
                    jlbBoss.setIcon(GBoss_RN);
                    break;
                case KeyEvent.VK_C :
                    jlbBoss.setIcon(GBoss_LA);
                    break;
                case KeyEvent.VK_V :
                    jlbBoss.setIcon(GBoss_LAD);
                    break;
                case KeyEvent.VK_B :
                    jlbBoss.setIcon(GBoss_LAU);
                    break;
                case KeyEvent.VK_N :
                    jlbBoss.setIcon(GBoss_LD);
                    Bosdlock = true;
                    break;
                case KeyEvent.VK_Q:
                    HawTEST = 600;
                    HahTEST = 608;
                    jlbHatTEST.setBounds(HawTEST , HahTEST , 85 , 28);
                    jlbHatTEST.setVisible(true);
                    rightattTEST.start();
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
                    if(!jlock){
                    if(direction){jlbPlayer.setIcon(Player_RN);}
                    else if(!direction){jlbPlayer.setIcon(Player_LN);}
                    dlock = false;}
                    break;
                case KeyEvent.VK_Z :
                    if(!jlock && !dlock){
                        if(direction){jlbPlayer.setIcon(Player_RN);}
                        else if(!direction){jlbPlayer.setIcon(Player_LN);}}
                    break;
            }
        }
    }
}