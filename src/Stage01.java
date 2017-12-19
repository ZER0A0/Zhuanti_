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
    private ImageIcon Hat = new ImageIcon("Image\\Hat.png");

    private JLabel jlbPlayer = new JLabel(Player_RN);
    private int Plaw = 0 , Plah = 567;

    private int foot = 0 , direction = 0 , jlock = 0 , dlock = 0;

    private JLabel jlbHat1 = new JLabel(Hat);
    private JLabel jlbHat2 = new JLabel(Hat);
    private JLabel jlbHat3 = new JLabel(Hat);

    private int Haw1 , Hah1 , hatime1 , halock1 = 0;
    private int Haw2 , Hah2 , hatime2 , halock2 = 0;
    private int Haw3 , Hah3 , hatime3 , halock3 = 0;

    //ABC
    private JLabel jlbBoss = new JLabel(Player_LN);
    private int Bosw = 1000 , Bosh = 565;
    private JLabel test = new JLabel(Hat);
    private JLabel test2 = new JLabel(Hat);
    private int testw = 1000 , testh = 559 , testtime1 = 0 , testtime2 = 0;
    private int testw2 = 1000 , testh2 = 742 , testtime12 = 0 , testtime22 = 0;
    private Timer testt1 , testt2;
    private Timer testt12 , testt22;
    private Timer udi;
    private int udidi = 0 , option = 0;

    private JLabel jlbHPPla = new JLabel();
    private JLabel jlbHPPlaB = new JLabel();
    private JLabel jlbHPBos = new JLabel();
    private JLabel jlbHPBosB = new JLabel();

    private int HPPlah = 200 , HPBosh = 200;

    private Timer jumput , jumpdt;
    private Timer rightatt1 , leftatt1;
    private Timer rightatt2 , leftatt2;
    private Timer rightatt3 , leftatt3;

    private int sw = getToolkit().getScreenSize().width;
    private int sh = getToolkit().getScreenSize().height;
    private int fw = 1200, fh = 800;

    private void initComp() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(sw / 2 - fw / 2, sh / 2 - fh / 2, fw, fh);
        this.setLayout(null);
        this.setTitle("請輸入標題");

        jlbPlayer.setBounds(Plaw, Plah, 200, 200);
        this.add(jlbPlayer);

        //ABC
        jlbBoss.setBounds(Bosw , Bosh , 200 , 200);
        this.add(jlbBoss);
        test.setBounds(testw , testh , 85 , 28);
        test2.setBounds(testw2 , testh2 , 85 , 28);
        this.add(test);
        this.add(test2);
        testt1 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test.setBounds(testw -= 20 , testh , 85 , 28);
                testtime1 += 1;
                if(dlock == 0 && jlock == 0){if(testw <= Plaw+100 && testw >= Plaw && testh + 28 >= Plah + 12&& testh <= Plah +189){testt1.stop();testtime1 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test.setVisible(false);}}
                else if(dlock == 1){if(testw <= Plaw+140 && testw >= Plaw - 20 && testh + 28 >= Plah + 65&& testh <= Plah +189){testt1.stop();testtime1 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test.setVisible(false);}}
                else if(jlock == 1){if(testw <= Plaw+140 && testw >= Plaw - 20 && testh + 28 >= Plah + 20&& testh <= Plah +175){testt1.stop();testtime1 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test.setVisible(false);}}
                if (testtime1 == 40){testt1.stop();testt2.start();testtime1 = 0;}
            }
        });
        testt2 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test.setBounds(testw += 20 , testh , 85 , 28);
                testtime2 += 1;
                if(dlock == 0 && jlock == 0){if(testw <= Plaw+100 && testw >= Plaw && testh + 28 >= Plah + 12&& testh <= Plah +189){testt2.stop();testtime2 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test.setVisible(false);}}
                else if(dlock == 1){if(testw <= Plaw+140 && testw >= Plaw -20 && testh + 28 >= Plah + 65&& testh <= Plah +189){testt2.stop();testtime2 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test.setVisible(false);}}
                else if(jlock == 1){if(testw <= Plaw+140 && testw >= Plaw - 20 && testh + 28 >= Plah + 20&& testh <= Plah +175){testt2.stop();testtime2 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test.setVisible(false);}}
                if (testtime2 == 40){testt2.stop();testt1.start();testtime2 = 0;}
            }
        });
        testt12 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test2.setBounds(testw2 -= 20 , testh2 , 85 , 28);
                testtime12 += 1;
                if(dlock == 0 && jlock == 0){if(testw2 <= Plaw+100 && testw2 >= Plaw && testh2 + 28 >= Plah + 20 && testh2 <= Plah +189){testt12.stop();testtime12 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test2.setVisible(false);}}
                else if(dlock == 1){if(testw2 <= Plaw+140 && testw2 >= Plaw - 20 && testh2 + 28 >= Plah + 65 && testh2 <= Plah +189){testt12.stop();testtime12 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test2.setVisible(false);}}
                else if(jlock == 1){if(testw2 <= Plaw+140 && testw2 >= Plaw - 20 && testh2 + 28 >= Plah + 20&& testh2 <= Plah +175){testt12.stop();testtime12 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test2.setVisible(false);}}
                if (testtime12 == 40){testt12.stop();testt22.start();testtime12 = 0;}
            }
        });
        testt22 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test2.setBounds(testw2 += 20 , testh2 , 85 , 28);
                testtime22 += 1;
                if(dlock == 0 && jlock == 0){if(testw2 <= Plaw+100 && testw2 >= Plaw && testh2 + 28 >= Plah + 12 && testh2 <= Plah +189){testt22.stop();testtime22 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test2.setVisible(false);}}
                else if(dlock == 1){if(testw2 <= Plaw+140 && testw2 >= Plaw - 20 && testh2 + 28 >= Plah + 65 && testh2 <= Plah +189){testt22.stop();testtime22 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test2.setVisible(false);}}
                else if(jlock == 1){if(testw2 <= Plaw+140 && testw2 >= Plaw - 20 && testh2 + 28 >= Plah + 20&& testh2 <= Plah +175){testt22.stop();testtime22 = 0;HPPlah -= 2;jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - HPPlah - 150 , 30 , HPPlah);test2.setVisible(false);}}
                if (testtime22 == 40){testt22.stop();testt12.start();testtime22 = 0;}
            }
        });
        udi = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                udidi += 1;
                if(udidi == 3){udi.stop();udidi = 0;option = 0;}
            }
        });

        jlbHat1.setBounds(Plaw , Plah , 85 , 28);
        jlbHat2.setBounds(Plaw , Plah , 85 , 28);
        jlbHat3.setBounds(Plaw , Plah , 85 , 28);

        this.add(jlbHat1);
        this.add(jlbHat2);
        this.add(jlbHat3);
        jlbHat1.setVisible(false);
        jlbHat2.setVisible(false);
        jlbHat3.setVisible(false);

        jlbHPPla.setBounds(fw / 2  - 550 , fh / 2 - 350 , 30 , HPPlah);
        jlbHPBos.setBounds(fw / 2  + 510 , fh / 2 - 350 , 30 , HPBosh);
        jlbHPPlaB.setBounds(fw / 2  - 550 , fh / 2 - 350 , 30 , 200);
        jlbHPBosB.setBounds(fw / 2  + 510 , fh / 2 - 350 , 30 , 200);
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
                    if(direction == 0){jlbPlayer.setIcon(Player_RN);}
                    else if(direction == 1){jlbPlayer.setIcon(Player_LN);}
                    jlock = 0;}
            }
        });
        rightatt1 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat1.setBounds(Haw1 += 40 , Hah1 , 85 , 28);
                hatime1 += 1;
                /////
                if(Haw1 >= Bosw + 40){rightatt1.stop();jlbHat1.setVisible(false);if(option == 0){HPBosh-=2;jlbHPBos.setBounds(fw / 2  + 510 , fh / 2 - HPBosh - 150 , 30 , HPBosh);}halock1 = 0;udi.start();option = 1;}
                /////
                if(hatime1 == 12){rightatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = 0;}
            }
        });
        leftatt1 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat1.setBounds(Haw1 -= 40 , Hah1 , 85 , 28);
                hatime1 += 1;
                if(hatime1 == 12){leftatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = 0;}
            }
        });
        rightatt2 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat2.setBounds(Haw2 += 40 , Hah2 , 85 , 28);
                hatime2 += 1;
                /////
                if(Haw2 >= Bosw + 40){rightatt2.stop();jlbHat2.setVisible(false);if(option == 0){HPBosh-=2;jlbHPBos.setBounds(fw / 2  + 510 , fh / 2 - HPBosh - 150 , 30 , HPBosh);}halock2 = 0;udi.start();option = 1;}
                /////
                if(hatime2 == 12){rightatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = 0;}
            }
        });
        leftatt2 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat2.setBounds(Haw2 -= 40 , Hah2 , 85 , 28);
                hatime2 += 1;
                if(hatime2 == 12){leftatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = 0;}
            }
        });
        rightatt3 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat3.setBounds(Haw3 += 40 , Hah3 , 85 , 28);
                hatime3 += 1;
                /////
                if(Haw3 >= Bosw + 40){rightatt3.stop();jlbHat3.setVisible(false);if(option == 0){HPBosh-=2;jlbHPBos.setBounds(fw / 2  + 510 , fh / 2 - HPBosh - 150 , 30 , HPBosh);}halock3 = 0;udi.start();option = 1;}
                /////
                if(hatime3 == 12){rightatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = 0;}
            }
        });
        leftatt3 = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbHat3.setBounds(Haw3 -= 40 , Hah3 , 85 , 28);
                hatime3 += 1;
                if(hatime3 == 12){leftatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = 0;}
            }
        });

        this.addKeyListener(new KeyMonitor());
    }

    private class KeyMonitor extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    direction = 1;
                    if(Plaw - 40 >= 0){
                        jlbPlayer.setBounds(Plaw -= 40 , Plah, 200, 200);}
                    if(foot == 0 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_L2) ; foot = 1;}
                    else if(foot == 1 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_L1) ; foot = 0;}
                    else if(jlock == 1){jlbPlayer.setIcon(Player_LJ);}
                    else if(dlock == 1){jlbPlayer.setIcon(Player_LD);}
                    break;
                case KeyEvent.VK_RIGHT :
                    direction = 0;
                    if(Plaw + 40 <= 1000){
                        jlbPlayer.setBounds(Plaw += 40 , Plah, 200, 200);}
                    if(foot == 0 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_R2) ; foot = 1;}
                    else if(foot == 1 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_R1) ; foot = 0;}
                    else if(jlock == 1){jlbPlayer.setIcon(Player_RJ);}
                    else if(dlock == 1){jlbPlayer.setIcon(Player_RD);}
                    break;
                case KeyEvent.VK_UP :
                    if(jlock == 0){dlock = 0;
                        if(direction == 0){jlbPlayer.setIcon(Player_RJ);}
                        else if(direction == 1){jlbPlayer.setIcon(Player_LJ);}
                        jumput.start();
                        jlock = 1;}
                    break;
                case KeyEvent.VK_DOWN :
                    if(dlock == 0 && jlock == 0){
                        if(direction == 0){jlbPlayer.setIcon(Player_RD);}
                        else if(direction == 1){jlbPlayer.setIcon(Player_LD);}
                    dlock = 1;}
                    break;
                case KeyEvent.VK_Z :
                    if(halock1 == 0){
                        if(direction == 0){rightatt1.start() ; Haw1 = Plaw + 120;}
                        else if(direction == 1){leftatt1.start() ; Haw1 = Plaw;}
                        if(dlock == 0){Hah1 = Plah + 60;}
                        else if(dlock == 1){Hah1 = Plah + 120;}
                        jlbHat1.setBounds(Haw1 , Hah1 , 85 , 28);
                        jlbHat1.setVisible(true);
                        if(direction == 0 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_RA);}
                        else if(direction == 1 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_LA);}
                        hatime1 = 0;
                        halock1 = 1;}
                    else if(halock1 == 1 && halock2 == 0){
                        if(direction == 0){rightatt2.start() ; Haw2 = Plaw + 120;}
                        else if(direction == 1){leftatt2.start() ; Haw2 = Plaw;}
                        if(dlock == 0){Hah2 = Plah + 60;}
                        else if(dlock == 1){Hah2 = Plah + 120;}
                        jlbHat2.setBounds(Haw2 , Hah2 , 85 , 28);
                        jlbHat2.setVisible(true);
                        if(direction == 0 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_RA);}
                        else if(direction == 1 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_LA);}
                        hatime2 = 0;
                        halock2 = 1;}
                    else if(halock1 == 1 && halock2 == 1 && halock3 == 0){
                        if(direction == 0){rightatt3.start() ; Haw3 = Plaw + 120;}
                        else if(direction == 1){leftatt3.start() ; Haw3 = Plaw;}
                        if(dlock == 0){Hah3 = Plah + 60;}
                        else if(dlock == 1){Hah3 = Plah + 120;}
                        jlbHat3.setBounds(Haw3 , Hah3 , 85 , 28);
                        jlbHat3.setVisible(true);
                        if(direction == 0 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_RA);}
                        else if(direction == 1 && jlock == 0 && dlock == 0){jlbPlayer.setIcon(Player_LA);}
                        hatime3 = 0;
                        halock3 = 1;}
                    break;

                /////625     756    530 551
                case KeyEvent.VK_X:
                    testw = 1000 ; testh = 559;test.setBounds(testw , testh , 85 , 28);testtime1 = 0 ; testtime2 = 0;testt1.stop();testt2.stop();testt1.start();test.setVisible(true);
                    testw2 = 1000 ; testh2 = 742;test2.setBounds(testw2 , testh2 , 85 , 28);testtime12 = 0 ; testtime22 = 0;testt12.stop();testt22.stop();testt12.start();test2.setVisible(true);
                    break;
            }
        }
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_DOWN :
                    if(jlock == 0){
                    if(direction == 0){jlbPlayer.setIcon(Player_RN);}
                    else if(direction == 1){jlbPlayer.setIcon(Player_LN);}
                    dlock = 0;}
                    break;
                case KeyEvent.VK_Z :
                    if(jlock == 0 && dlock == 0){
                        if(direction == 0){jlbPlayer.setIcon(Player_RN);}
                        else if(direction == 1){jlbPlayer.setIcon(Player_LN);}}
                    break;
            }
        }
    }
}