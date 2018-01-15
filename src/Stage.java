import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

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

    private int Plaw = 0 , Plah = 567 , walktime = 0;

    private boolean foot , direction = true , jlock = false , dlock = false , PlaStop = false;

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

    //Boss
    private ImageIcon NBoss_LN = new ImageIcon("Image\\NBoss_LN.png");
    private ImageIcon GBoss_LN = new ImageIcon("Image\\GBoss_LN.png");
    private ImageIcon NBoss_LD = new ImageIcon("Image\\NBoss_LD.png");
    private ImageIcon GBoss_LD = new ImageIcon("Image\\GBoss_LD.png");
    private ImageIcon NBoss_LA = new ImageIcon("Image\\NBoss_LA.png");
    private ImageIcon GBoss_LA = new ImageIcon("Image\\GBoss_LA.png");

    private JLabel jlbBoss = new JLabel(NBoss_LN);

    private int Bosw = 950 , Bosh = 567;

    private boolean Bosdlock = false , BosGlock = false , BosStop = false;

    //Boss Attack
    private ImageIcon MoG_9 = new ImageIcon("Image\\MoG_9.png");

    private JLabel jlbMoG1 = new JLabel(MoG_9);
    private JLabel jlbMoG2 = new JLabel(MoG_9);
    private JLabel jlbMoG3 = new JLabel(MoG_9);
    private JLabel jlbMoG4 = new JLabel(MoG_9);

    private ImageIcon Hand_L1 = new ImageIcon("Image\\Hand_L1.png");
    private ImageIcon Hand_L2 = new ImageIcon("Image\\Hand_L2.png");
    private ImageIcon Hand_L3 = new ImageIcon("Image\\Hand_L3.png");
    private ImageIcon Hand_L4 = new ImageIcon("Image\\Hand_L4.png");
    private ImageIcon Hand_L5 = new ImageIcon("Image\\Hand_L5.png");
    private ImageIcon Hand_L6 = new ImageIcon("Image\\Hand_L6.png");
    private ImageIcon Hand_L7 = new ImageIcon("Image\\Hand_L7.png");
    private ImageIcon Hand_L8 = new ImageIcon("Image\\Hand_L8.png");
    private ImageIcon Hand_L9 = new ImageIcon("Image\\Hand_L9.png");
    private ImageIcon Hand_L10 = new ImageIcon("Image\\Hand_L10.png");
    private ImageIcon Hand_L11 = new ImageIcon("Image\\Hand_L11.png");
    private ImageIcon Hand_L12 = new ImageIcon("Image\\Hand_L12.png");
    private ImageIcon Hand_L13 = new ImageIcon("Image\\Hand_L13.png");
    private ImageIcon Hand_L14 = new ImageIcon("Image\\Hand_L14.png");
    private ImageIcon Hand_L15 = new ImageIcon("Image\\Hand_L15.png");
    private ImageIcon Hand_L16 = new ImageIcon("Image\\Hand_L16.png");
    private ImageIcon Hand_L17 = new ImageIcon("Image\\Hand_L17.png");
    private ImageIcon Hand_L18 = new ImageIcon("Image\\Hand_L18.png");
    private ImageIcon Hand_L19 = new ImageIcon("Image\\Hand_L19.png");
    private ImageIcon Hand_L20 = new ImageIcon("Image\\Hand_L20.png");
    private ImageIcon Hand_U1 = new ImageIcon("Image\\Hand_U1.png");
    private ImageIcon Hand_U2 = new ImageIcon("Image\\Hand_U2.png");
    private ImageIcon Hand_U3 = new ImageIcon("Image\\Hand_U3.png");
    private ImageIcon Hand_U4 = new ImageIcon("Image\\Hand_U4.png");
    private ImageIcon Hand_U5 = new ImageIcon("Image\\Hand_U5.png");
    private ImageIcon Hand_U6 = new ImageIcon("Image\\Hand_U6.png");
    private ImageIcon Hand_U7 = new ImageIcon("Image\\Hand_U7.png");
    private ImageIcon Hand_U8 = new ImageIcon("Image\\Hand_U8.png");
    private ImageIcon Hand_U9 = new ImageIcon("Image\\Hand_U9.png");
    private ImageIcon Hand_U10 = new ImageIcon("Image\\Hand_U10.png");
    private ImageIcon Hand_U11 = new ImageIcon("Image\\Hand_U11.png");
    private ImageIcon Hand_U12 = new ImageIcon("Image\\Hand_U12.png");

    private int Mow1 , Moh1 , Motime1;
    private int Mow2 , Moh2 , Motime2;
    private int Mow3 , Moh3 , Motime3;
    private int Mow4 , Moh4 , Motime4;
    private int leftMotime;
    private int Handtime , Handw = 27;
    private int UHandtime;

    private int MoGtype , GBostime;
    private Random BosAttackr = new Random();
    private Timer BosAttackt , GBost;

    private Timer Mot1;
    private Timer Mot2;
    private Timer Mot3;
    private Timer Mot4;
    private Timer leftMot;
    private Timer leftHandt , Handt1 , Handt2;
    private Timer leftUHandt , UHandt1 , UHandt2;

    //HP
    private JLabel jlbHPPla = new JLabel();
    private JLabel jlbHPPlaB = new JLabel();
    private JLabel jlbHPBos = new JLabel();
    private JLabel jlbHPBosB = new JLabel();

    private int HPPlah = 200 , HPPlay = 50;
    private int HPBosh = 200 , HPBosy = 50;
    private int PlaDamage = 1;
    private int BosDamage = 10;

    //Window
    private int sw = getToolkit().getScreenSize().width;
    private int sh = getToolkit().getScreenSize().height;
    private int fw = 1200, fh = 800;

    //Stage
    private Timer Startt;
    private int Starttime;
    private Timer PlaDiet , BosDiet;
    private JLabel jlbend = new JLabel("",JLabel.CENTER);
    private JLabel jlbexit = new JLabel("exit",JLabel.CENTER);
    private boolean exitlock = true;

    private void initComp() {
        //Window
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(sw / 2 - fw / 2, sh / 2 - fh / 2, fw, fh);
        this.setLayout(null);
        this.setTitle("Stage");
        this.addKeyListener(new KeyMonitor());

        //Player
        jlbPlayer.setBounds(Plaw, Plah, 200, 200);
        this.add(jlbPlayer);

        walkrt = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                direction = true;
                walktime += 1;
                if(Plaw + 10 <= 1000){
                    jlbPlayer.setBounds(Plaw += 10 , Plah, 200, 200);}
                if(foot && !jlock && !dlock){jlbPlayer.setIcon(Player_R2) ; foot = false;}
                else if(!foot && !jlock && !dlock){jlbPlayer.setIcon(Player_R1) ; foot = true;}
                else if(jlock){jlbPlayer.setIcon(Player_RJ);}
                else if(dlock){jlbPlayer.setIcon(Player_RD);}
            }
        });
        walklt = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                direction = false;
                walktime += 1;
                if(Plaw - 10 >= 0){
                    jlbPlayer.setBounds(Plaw -= 10 , Plah, 200, 200);}
                if(foot && !jlock && !dlock){jlbPlayer.setIcon(Player_L2) ; foot = false;}
                else if(!foot && !jlock && !dlock){jlbPlayer.setIcon(Player_L1) ; foot = true;}
                else if(jlock){jlbPlayer.setIcon(Player_LJ);}
                else if(dlock){jlbPlayer.setIcon(Player_LD);}
            }
        });
        jumput = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbPlayer.setBounds(Plaw , Plah -= 30 , 200, 200);
                if(Plah == 297){jumput.stop() ; jumpdt.start();}
            }
        });
        jumpdt = new Timer(30, new ActionListener() {
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

        rightatt1 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw1 >= Bosw + 60 && Haw1 <= Bosw + 100 && Hah1 >= Bosh - 7 && Hah1 <= Bosh + 189){
                    rightatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw1 >= Bosw + 15 && Haw1 <= Bosw + 55 && Hah1 >= Bosh + 41 && Hah1 <= Bosh + 189){
                    rightatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                if (HPBosh <= 0 && !PlaStop){BosDiet.start();}
                jlbHat1.setBounds(Haw1 += 20 , Hah1 , 85 , 28);
                hatime1 += 1;
                if(hatime1 == 25){rightatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;}
            }
        });
        leftatt1 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw1 >= Bosw - 10 && Haw1 <= Bosw + 30 && Hah1 >= Bosh - 7 && Hah1 <= Bosh + 189){
                    leftatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw1 >= Bosw + 55 && Haw1 <= Bosw + 95 && Hah1 >= Bosh + 41 && Hah1 <= Bosh + 189){
                    leftatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                if (HPBosh <= 0 && !PlaStop){BosDiet.start();}
                jlbHat1.setBounds(Haw1 -= 20 , Hah1 , 85 , 28);
                hatime1 += 1;
                if(hatime1 == 25){leftatt1.stop() ; jlbHat1.setVisible(false) ; halock1 = false;}
            }
        });
        rightatt2 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw2 >= Bosw + 60 && Haw2 <= Bosw + 100 && Hah2 >= Bosh - 7 && Hah2 <= Bosh + 189){
                    rightatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw2 >= Bosw + 15 && Haw2 <= Bosw + 55 && Hah2 >= Bosh + 41 && Hah2 <= Bosh + 189){
                    rightatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                if (HPBosh <= 0 && !PlaStop){BosDiet.start();}
                jlbHat2.setBounds(Haw2 += 20 , Hah2 , 85 , 28);
                hatime2 += 1;
                if(hatime2 == 25){rightatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;}
            }
        });
        leftatt2 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw2 >= Bosw - 10 && Haw2 <= Bosw + 30 && Hah2 >= Bosh - 7 && Hah2 <= Bosh + 189){
                    leftatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw2 >= Bosw + 55 && Haw2 <= Bosw + 95 && Hah2 >= Bosh + 41 && Hah2 <= Bosh + 189){
                    leftatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                if (HPBosh <= 0 && !PlaStop){BosDiet.start();}
                jlbHat2.setBounds(Haw2 -= 20 , Hah2 , 85 , 28);
                hatime2 += 1;
                if(hatime2 == 25){leftatt2.stop() ; jlbHat2.setVisible(false) ; halock2 = false;}
            }
        });
        rightatt3 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw3 >= Bosw + 60 && Haw3 <= Bosw + 100 && Hah3 >= Bosh - 7 && Hah3 <= Bosh + 189){
                    rightatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw3 >= Bosw + 15 && Haw3 <= Bosw + 55 && Hah3 >= Bosh + 41 && Hah3 <= Bosh + 189){
                    rightatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                if (HPBosh <= 0 && !PlaStop){BosDiet.start();}
                jlbHat3.setBounds(Haw3 += 20 , Hah3 , 85 , 28);
                hatime3 += 1;
                if(hatime3 == 25){rightatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;}
            }
        });
        leftatt3 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Bosdlock && Haw3 >= Bosw - 10 && Haw3 <= Bosw + 30 && Hah3 >= Bosh - 7 && Hah3 <= Bosh + 189){
                    leftatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                else if(Bosdlock && Haw3 >= Bosw + 55 && Haw3 <= Bosw + 95 && Hah3 >= Bosh + 41 && Hah3 <= Bosh + 189){
                    leftatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;
                    jlbHPBos.setBounds(fw / 2  + 510 , HPBosy += PlaDamage , 30 , HPBosh -= PlaDamage);}
                if (HPBosh <= 0 && !PlaStop){BosDiet.start();}
                jlbHat3.setBounds(Haw3 -= 20 , Hah3 , 85 , 28);
                hatime3 += 1;
                if(hatime3 == 25){leftatt3.stop() ; jlbHat3.setVisible(false) ; halock3 = false;}
            }
        });

        //Boss
        jlbBoss.setBounds(Bosw, Bosh, 200, 200);
        this.add(jlbBoss);

        //Boss Attack
        jlbMoG1.setBounds(1000 , 620 , 50 , 50);
        jlbMoG2.setBounds(1000 , 620 , 50 , 50);
        jlbMoG3.setBounds(1000 , 620 , 50 , 50);
        jlbMoG4.setBounds(1000 , 620 , 50 , 50);

        this.add(jlbMoG1);
        this.add(jlbMoG2);
        this.add(jlbMoG3);
        this.add(jlbMoG4);

        jlbMoG1.setVisible(false);
        jlbMoG2.setVisible(false);
        jlbMoG3.setVisible(false);
        jlbMoG4.setVisible(false);

        BosAttackt = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!BosGlock && HPBosh <= 100){
                    GBost.start() ; BosAttackt.stop();
                }
                else{
                MoGtype = BosAttackr.nextInt(3) + 1;
                if(MoGtype == 1){leftMot.start();}
                else if(MoGtype == 2){leftHandt.start();}
                else if(MoGtype == 3){leftUHandt.start();}
                BosAttackt.stop();}
            }
        });
        GBost = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GBostime += 1;
                if(GBostime == 1){BosGlock = true ; BosDamage = 20;}
                else if(GBostime == 5){jlbBoss.setIcon(GBoss_LN);}
                else if(GBostime == 6){jlbBoss.setIcon(NBoss_LN);}
                else if(GBostime == 10){jlbBoss.setIcon(GBoss_LN);}
                else if(GBostime == 11){jlbBoss.setIcon(NBoss_LN);}
                else if(GBostime == 14){jlbBoss.setIcon(GBoss_LN);}
                else if(GBostime == 15){jlbBoss.setIcon(NBoss_LN);}
                else if(GBostime == 16){jlbBoss.setIcon(GBoss_LN);}
                else if(GBostime == 20){BosAttackt.start() ; GBost.stop();}
            }
        });
        Mot1 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MoGtype == 1){
                    jlbMoG1.setBounds(Mow1 -= 20 , Moh1 , 50 , 50);
                    Motime1 += 1;
                    if(!dlock && Mow1 >= Plaw + 65 && Mow1 <= Plaw + 90 && Moh1 >= Plah - 20 && Moh1 <= Plah + 168){
                        Mot1.stop() ; jlbMoG1.setVisible(false);
                        jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage , 30 , HPPlah -= BosDamage);
                    }
                    else if(dlock && Mow1 >= Plaw + 65 && Mow1 <= Plaw + 90 && Moh1 >= Plah + 33 && Moh1 <= Plah + 168){
                        Mot1.stop() ; jlbMoG1.setVisible(false);
                        jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage , 30 , HPPlah -= BosDamage);
                    }
                    if (HPPlah <= 0 && !PlaStop){PlaDiet.start();}
                    if(Motime1 == 47){Mot1.stop() ; jlbMoG1.setVisible(false);}
                }
            }
        });

        Mot2 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MoGtype == 1){
                    jlbMoG2.setBounds(Mow2 -= 20 , Moh2 , 50 , 50);
                    Motime2 += 1;
                    if(!dlock && Mow2 >= Plaw + 65 && Mow2 <= Plaw + 90 && Moh2 >= Plah - 20 && Moh2 <= Plah + 168){
                        Mot2.stop() ; jlbMoG2.setVisible(false);
                        jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage , 30 , HPPlah -= BosDamage);
                    }
                    else if(dlock && Mow2 >= Plaw + 65 && Mow2 <= Plaw + 90 && Moh2 >= Plah + 33 && Moh2 <= Plah + 168){
                        Mot2.stop() ; jlbMoG2.setVisible(false);
                        jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage , 30 , HPPlah -= BosDamage);
                    }
                    if (HPPlah <= 0 && !PlaStop){PlaDiet.start();}
                    if(Motime2 == 47){Mot2.stop() ; jlbMoG2.setVisible(false);}
                }}
        });
        Mot3 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MoGtype == 1){
                    jlbMoG3.setBounds(Mow3 -= 20 , Moh3 , 50 , 50);
                    Motime3 += 1;
                    if(!dlock && Mow3 >= Plaw + 65 && Mow3 <= Plaw + 90 && Moh3 >= Plah - 20 && Moh3 <= Plah + 168){
                        Mot3.stop() ; jlbMoG3.setVisible(false);
                        jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage , 30 , HPPlah -= BosDamage);
                    }
                    else if(dlock && Mow3 >= Plaw + 65 && Mow3 <= Plaw + 90 && Moh3 >= Plah + 33 && Moh3 <= Plah + 168){
                        Mot3.stop() ; jlbMoG3.setVisible(false);
                        jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage , 30 , HPPlah -= BosDamage);
                    }
                    if (HPPlah <= 0 && !PlaStop){PlaDiet.start();}
                    if(Motime3 == 47){Mot3.stop() ; jlbMoG3.setVisible(false);}
                }}
        });
        Mot4 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MoGtype == 1){
                    jlbMoG4.setBounds(Mow4 -= 20 , Moh4 , 50 , 50);
                    Motime4 += 1;
                    if(!dlock && Mow4 >= Plaw + 65 && Mow4 <= Plaw + 90 && Moh4 >= Plah - 20 && Moh4 <= Plah + 168){
                        Mot4.stop() ; jlbMoG4.setVisible(false);
                        jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage , 30 , HPPlah -= BosDamage);
                    }
                    else if(dlock && Mow4 >= Plaw + 65 && Mow4 <= Plaw + 90 && Moh4 >= Plah + 33 && Moh4 <= Plah + 168){
                        Mot4.stop() ; jlbMoG4.setVisible(false);
                        jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage , 30 , HPPlah -= BosDamage);
                    }
                    if (HPPlah <= 0 && !PlaStop){PlaDiet.start();}
                    if(Motime4 == 47){Mot4.stop() ; jlbMoG4.setVisible(false);}
                }}
        });
        leftMot = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftMotime += 1;
                if(leftMotime == 12){
                    if(!BosGlock){jlbBoss.setIcon(NBoss_LA);}
                    else if(BosGlock){jlbBoss.setIcon(GBoss_LA);}
                    jlbMoG1.setIcon(MoG_9) ; Mow1 = 1000 ; Moh1 = 680 ; jlbMoG1.setVisible(true) ; Motime1 = 0 ; Mot1.start();}
                else if(leftMotime == 24){Mow2 = 1000 ; Moh2 = 560 ; jlbMoG2.setIcon(MoG_9) ; jlbMoG2.setVisible(true) ; Motime2 = 0 ; Mot2.start();}
                else if(leftMotime == 36){Mow3 = 1000 ; Moh3 = 680 ; jlbMoG3.setIcon(MoG_9) ; jlbMoG3.setVisible(true) ; Motime3 = 0 ; Mot3.start();}
                else if(leftMotime == 48){Mow4 = 1000 ; Moh4 = 560 ; jlbMoG4.setIcon(MoG_9) ; jlbMoG4.setVisible(true) ; Motime4 = 0 ; Mot4.start();}
                else if(leftMotime == 60){Mow1 = 1000 ; Moh1 = 680 ; jlbMoG1.setVisible(true) ; Motime1 = 0 ; Mot1.start();}
                else if(leftMotime == 72){Mow2 = 1000 ; Moh2 = 560 ; jlbMoG2.setVisible(true) ; Motime2 = 0 ; Mot2.start();}
                else if(leftMotime == 84){Mow3 = 1000 ; Moh3 = 680 ; jlbMoG3.setVisible(true) ; Motime3 = 0 ; Mot3.start();}
                else if(leftMotime == 96){Mow4 = 1000 ; Moh4 = 560 ; jlbMoG4.setVisible(true) ; Motime4 = 0 ; Mot4.start();
                    if(!BosGlock){jlbBoss.setIcon(NBoss_LN);}
                    else if(BosGlock){jlbBoss.setIcon(GBoss_LN);}}
                else if(leftMotime == 132){leftMot.stop() ; leftMotime = 0 ; BosAttackt.start();}
            }
        });
        Handt1 = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Handtime += 1;
                Handw += 27;
                if(Mow1 - Handw >= Plaw - 700 && Mow1 - Handw <= Plaw - 410 && Moh1 >= Plah - 20 && Moh1 <= Plah + 168){
                    jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage , 30 , HPPlah -= BosDamage);
                }
                if (HPPlah <= 0 && !PlaStop){PlaDiet.start();}
                if(Handtime == 1){jlbMoG1.setIcon(Hand_L2);}
                else if(Handtime == 2){jlbMoG1.setIcon(Hand_L3);}
                else if(Handtime == 3){jlbMoG1.setIcon(Hand_L4);}
                else if(Handtime == 4){jlbMoG1.setIcon(Hand_L5);}
                else if(Handtime == 5){jlbMoG1.setIcon(Hand_L6);}
                else if(Handtime == 6){jlbMoG1.setIcon(Hand_L7);}
                else if(Handtime == 7){jlbMoG1.setIcon(Hand_L8);}
                else if(Handtime == 8){jlbMoG1.setIcon(Hand_L9);}
                else if(Handtime == 9){jlbMoG1.setIcon(Hand_L10);}
                else if(Handtime == 10){jlbMoG1.setIcon(Hand_L11);}
                else if(Handtime == 11){jlbMoG1.setIcon(Hand_L12);}
                else if(Handtime == 12){jlbMoG1.setIcon(Hand_L13);}
                else if(Handtime == 13){jlbMoG1.setIcon(Hand_L14);}
                else if(Handtime == 14){jlbMoG1.setIcon(Hand_L15);}
                else if(Handtime == 15){jlbMoG1.setIcon(Hand_L16);}
                else if(Handtime == 16){jlbMoG1.setIcon(Hand_L17);}
                else if(Handtime == 17){jlbMoG1.setIcon(Hand_L18);}
                else if(Handtime == 18){jlbMoG1.setIcon(Hand_L19);}
                else if(Handtime == 19){jlbMoG1.setIcon(Hand_L20);}
                else if(Handtime == 20){Mow1 += 13 ; Handt2.start() ; Handt1.stop();}
            }
        });
        Handt2 = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Handtime -= 1;
                if(Handtime == 19){jlbMoG1.setIcon(Hand_L19);}
                else if(Handtime == 18){jlbMoG1.setIcon(Hand_L18);}
                else if(Handtime == 17){jlbMoG1.setIcon(Hand_L17);}
                else if(Handtime == 16){jlbMoG1.setIcon(Hand_L16);}
                else if(Handtime == 15){jlbMoG1.setIcon(Hand_L15);}
                else if(Handtime == 14){jlbMoG1.setIcon(Hand_L14);}
                else if(Handtime == 13){jlbMoG1.setIcon(Hand_L13);}
                else if(Handtime == 12){jlbMoG1.setIcon(Hand_L12);}
                else if(Handtime == 11){jlbMoG1.setIcon(Hand_L11);}
                else if(Handtime == 10){jlbMoG1.setIcon(Hand_L10);}
                else if(Handtime == 9){jlbMoG1.setIcon(Hand_L9);}
                else if(Handtime == 8){jlbMoG1.setIcon(Hand_L8);}
                else if(Handtime == 7){jlbMoG1.setIcon(Hand_L7);}
                else if(Handtime == 6){jlbMoG1.setIcon(Hand_L6);}
                else if(Handtime == 5){jlbMoG1.setIcon(Hand_L5);}
                else if(Handtime == 4){jlbMoG1.setIcon(Hand_L4);}
                else if(Handtime == 3){jlbMoG1.setIcon(Hand_L3);}
                else if(Handtime == 2){jlbMoG1.setIcon(Hand_L2);}
                else if(Handtime == 1){jlbMoG1.setIcon(Hand_L1) ; jlbMoG1.setVisible(false);
                    if(!BosGlock){jlbBoss.setIcon(NBoss_LN);}
                    else if(BosGlock){jlbBoss.setIcon(GBoss_LN);}}
                else if(Handtime == -4){Handtime = 0 ; Handw = 27 ; Handt2.stop() ; BosAttackt.start();}
            }
        });
        leftHandt = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!BosGlock){jlbBoss.setIcon(NBoss_LA);}
                else if(BosGlock){jlbBoss.setIcon(GBoss_LA);}
                Mow1 = 493 ; Moh1 = 629;
                jlbMoG1.setBounds(Mow1 , Moh1 , 557 , 27);
                jlbMoG1.setIcon(Hand_L1);
                jlbMoG1.setVisible(true);
                Handt1.start();
                leftHandt.stop();
            }
        });
        UHandt1 = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Handtime += 1;
                if(Handtime >= 6){Handw += 27;}
                if(Handtime >= 6 && Mow1 >= Plaw + 55 && Mow1 <= Plaw + 100 && Moh1 - Handw >= Plah - 590 && Moh1 - Handw <= Plah - 390){
                    jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage / 2 , 30 , HPPlah -= BosDamage / 2);
                }
                if (HPPlah <= 0 && !PlaStop){PlaDiet.start();}
                if(Handtime == 1){Mow1 = Plaw + 80 ; jlbMoG1.setBounds(Mow1 , Moh1 , 27 , 557);}
                else if(Handtime == 6){jlbMoG1.setVisible(true);}
                else if(Handtime == 7){jlbMoG1.setIcon(Hand_U2);}
                else if(Handtime == 8){jlbMoG1.setIcon(Hand_U3);}
                else if(Handtime == 9){jlbMoG1.setIcon(Hand_U4);}
                else if(Handtime == 10){jlbMoG1.setIcon(Hand_U5);}
                else if(Handtime == 11){jlbMoG1.setIcon(Hand_U6);}
                else if(Handtime == 12){jlbMoG1.setIcon(Hand_U7);}
                else if(Handtime == 13){jlbMoG1.setIcon(Hand_U8);}
                else if(Handtime == 14){jlbMoG1.setIcon(Hand_U9);}
                else if(Handtime == 15){jlbMoG1.setIcon(Hand_U10);}
                else if(Handtime == 16){jlbMoG1.setIcon(Hand_U11);}
                else if(Handtime == 17){jlbMoG1.setIcon(Hand_U12) ; UHandt2.start() ; UHandt1.stop();}
            }
        });
        UHandt2 = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Handtime -= 1;
                Handw -= 27;
                if(Mow1 >= Plaw + 55 && Mow1 <= Plaw + 100 && Moh1 - Handw >= Plah - 590 && Moh1 - Handw <= Plah - 390){
                    jlbHPPla.setBounds(fw / 2  - 550 , HPPlay += BosDamage / 2 , 30 , HPPlah -= BosDamage / 2);
                }
                if (HPPlah <= 0 && !PlaStop){PlaDiet.start();}
                if(Handtime == 16){jlbMoG1.setIcon(Hand_U11);}
                else if(Handtime == 15){jlbMoG1.setIcon(Hand_U10);}
                else if(Handtime == 14){jlbMoG1.setIcon(Hand_U9);}
                else if(Handtime == 13){jlbMoG1.setIcon(Hand_U8);}
                else if(Handtime == 12){jlbMoG1.setIcon(Hand_U7);}
                else if(Handtime == 11){jlbMoG1.setIcon(Hand_U6);}
                else if(Handtime == 10){jlbMoG1.setIcon(Hand_U5);}
                else if(Handtime == 9){jlbMoG1.setIcon(Hand_U4);}
                else if(Handtime == 8){jlbMoG1.setIcon(Hand_U3);}
                else if(Handtime == 7){jlbMoG1.setIcon(Hand_U2);}
                else if(Handtime == 6){jlbMoG1.setIcon(Hand_U1) ; jlbMoG1.setVisible(false);}
                else if(Handtime == 0){Handtime = 0 ; Handw = 27;
                    if(UHandtime != 5){UHandtime += 1 ; UHandt1.start() ; UHandt2.stop();}
                    else if(UHandtime == 5){UHandtime = 0;
                        if(!BosGlock){jlbBoss.setIcon(NBoss_LN);}
                        else if(BosGlock){jlbBoss.setIcon(GBoss_LN);}
                        UHandt2.stop();BosAttackt.start();}
                        }
            }
        });
        leftUHandt = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!BosGlock){jlbBoss.setIcon(NBoss_LD);}
                else if(BosGlock){jlbBoss.setIcon(GBoss_LD);}
                Mow1 = 493 ; Moh1 = 210;
                jlbMoG1.setBounds(Mow1 , Moh1 , 27 , 557);
                jlbMoG1.setIcon(Hand_U1);
                UHandt1.start();
                leftUHandt.stop();
            }
        });

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

        //Stage
        Startt = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Starttime += 1;
                if(Starttime == 1){PlaStop = true ; jlbPlayer.setVisible(false) ; jlbBoss.setVisible(false);}
                else if(Starttime == 10){jlbPlayer.setVisible(true) ; jlbBoss.setVisible(true);}
                else if(Starttime == 11){jlbPlayer.setVisible(false) ; jlbBoss.setVisible(false);}
                else if(Starttime == 15){jlbPlayer.setVisible(true) ; jlbBoss.setVisible(true);}
                else if(Starttime == 16){jlbPlayer.setVisible(false) ; jlbBoss.setVisible(false);}
                else if(Starttime == 19){jlbPlayer.setVisible(true) ; jlbBoss.setVisible(true);}
                else if(Starttime == 20){jlbPlayer.setVisible(false) ; jlbBoss.setVisible(false);}
                else if(Starttime == 21){jlbPlayer.setVisible(true) ; jlbBoss.setVisible(true);}
                else if(Starttime == 25){PlaStop = false;}
                else if(Starttime == 35){Starttime = 0 ; BosAttackt.start() ; Startt.stop();}
            }
        });
        Startt.start();

        jlbend.setBounds(fw / 2 - 300 , fh / 2 - 235 , 600 , 200);
        jlbexit.setBounds(fw / 2 - 300 , fh / 2 - 85 , 600 , 200);
        jlbend.setOpaque(true);
        jlbexit.setOpaque(true);
        jlbend.setFont(new Font(null,0,100));
        jlbexit.setFont(new Font(null,0,50));
        this.add(jlbexit);
        this.add(jlbend);
        jlbend.setVisible(false);
        jlbexit.setVisible(false);

        BosDiet = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Starttime += 1;
                if(Starttime == 1){PlaStop = true ; jlbBoss.setIcon(GBoss_LN) ; BosAttackt.stop();
                    if(direction){walkrt.stop() ; jlbPlayer.setIcon(Player_RN);}
                    else if(!direction){walklt.stop() ; jlbPlayer.setIcon(Player_LN);}
                    if(MoGtype == 1){leftMot.stop() ; Mot1.stop() ; Mot2.stop() ; Mot3.stop() ; Mot4.stop();
                    jlbMoG1.setVisible(false) ;  jlbMoG2.setVisible(false) ;  jlbMoG3.setVisible(false) ;  jlbMoG4.setVisible(false);}
                    else if(MoGtype == 2){Handt1.stop() ; Handt2.stop() ; jlbMoG1.setVisible(false);}
                    else if(MoGtype == 3){UHandt1.stop() ; UHandt2.stop() ; jlbMoG1.setVisible(false);}}
                else if(Starttime == 20){jlbBoss.setIcon(GBoss_LD);}
                else if(Starttime == 32){jlbBoss.setVisible(false);}
                else if(Starttime == 34){jlbBoss.setVisible(true);}
                else if(Starttime == 40){jlbBoss.setVisible(false);}
                else if(Starttime == 42){jlbBoss.setVisible(true);}
                else if(Starttime == 46){jlbBoss.setVisible(false);}
                else if(Starttime == 48){jlbBoss.setVisible(true);}
                else if(Starttime == 49){jlbBoss.setVisible(false);}
                else if(Starttime == 50){jlbHat1.setBounds(fw / 2 - 42 , 370 , 85 , 28) ; jlbHat1.setVisible(true) ; exitlock = false;
                    jlbend.setVisible(true) ; jlbend.setText("You Win!!") ; jlbend.setBackground(Color.GREEN);
                    jlbexit.setVisible(true) ; jlbexit.setBackground(Color.GREEN) ; BosDiet.stop();}
            }
        });
        PlaDiet = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Starttime += 1;
                if(Starttime == 1){PlaStop = true ; BosAttackt.stop();
                    if(!BosGlock){jlbBoss.setIcon(NBoss_LA);}
                    else if(BosGlock){jlbBoss.setIcon(GBoss_LA);}
                    if(direction){walkrt.stop() ; jlbPlayer.setIcon(Player_RN);}
                    else if(!direction){walklt.stop() ; jlbPlayer.setIcon(Player_LN);}
                    if(MoGtype == 1){leftMot.stop() ; Mot1.stop() ; Mot2.stop() ; Mot3.stop() ; Mot4.stop();
                        jlbMoG1.setVisible(false) ;  jlbMoG2.setVisible(false) ;  jlbMoG3.setVisible(false) ;  jlbMoG4.setVisible(false);}
                    else if(MoGtype == 2){Handt1.stop() ; Handt2.stop() ; jlbMoG1.setVisible(false);}
                    else if(MoGtype == 3){UHandt1.stop() ; UHandt2.stop() ; jlbMoG1.setVisible(false);}}
                else if(Starttime == 20){
                    if(direction){jlbPlayer.setIcon(Player_RD);}
                    else if(!direction){jlbPlayer.setIcon(Player_LD);}}
                else if(Starttime == 32){jlbPlayer.setVisible(false);}
                else if(Starttime == 34){jlbPlayer.setVisible(true);}
                else if(Starttime == 40){jlbPlayer.setVisible(false);}
                else if(Starttime == 42){jlbPlayer.setVisible(true);}
                else if(Starttime == 46){jlbPlayer.setVisible(false);}
                else if(Starttime == 48){jlbPlayer.setVisible(true);}
                else if(Starttime == 49){jlbPlayer.setVisible(false);}
                else if(Starttime == 50){jlbHat1.setBounds(fw / 2 - 42 , 370 , 85 , 28) ; jlbHat1.setVisible(true) ; exitlock = false;
                    jlbend.setVisible(true) ; jlbend.setText("You Died!!") ; jlbend.setBackground(Color.RED);
                    jlbexit.setVisible(true) ; jlbexit.setBackground(Color.RED) ; PlaDiet.stop();}
            }
        });

    }

    private class KeyMonitor extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    if(!PlaStop){
                        walklt.start();
                    }
                    break;
                case KeyEvent.VK_RIGHT :
                    if(!PlaStop){
                        walkrt.start();
                    }
                    break;
                case KeyEvent.VK_UP :
                    if(!PlaStop){
                        if(!jlock){dlock = false;
                            if(direction){jlbPlayer.setIcon(Player_RJ);}
                            else if(!direction){jlbPlayer.setIcon(Player_LJ);}
                            jumput.start();
                            jlock = true;}
                    }
                    break;
                case KeyEvent.VK_DOWN :
                    if(!PlaStop){
                        if(!jlock){
                            if(direction){jlbPlayer.setIcon(Player_RD);}
                            else if(!direction){jlbPlayer.setIcon(Player_LD);}
                            dlock = true;}
                    }
                    break;
                case KeyEvent.VK_Z :
                    if(!PlaStop){
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
                    }
                    else if(!exitlock){
                        System.exit(0);
                    }
                    break;
            }
        }
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            switch(key) {
                case KeyEvent.VK_LEFT :
                    if(!PlaStop){
                        walklt.stop();
                        walktime = 0;
                    }
                    break;
                case KeyEvent.VK_RIGHT :
                    if(!PlaStop) {
                        walkrt.stop();
                        walktime = 0;
                    }
                    break;
                case KeyEvent.VK_DOWN :
                    if(!PlaStop){
                        if(!jlock){
                            if(direction){jlbPlayer.setIcon(Player_RN);}
                            else if(!direction){jlbPlayer.setIcon(Player_LN);}
                            dlock = false;}
                    }
                    break;
                case KeyEvent.VK_Z :
                    if(!PlaStop){
                        if(!jlock && !dlock){
                            if(direction){jlbPlayer.setIcon(Player_RN);}
                            else if(!direction){jlbPlayer.setIcon(Player_LN);}}
                    }
                    break;
            }
        }
    }
}