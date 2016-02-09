import edu.cmu.sphinx.demo.helloworld.SweetVoice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import sun.font.TextLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author archit
 */
public class audioInput extends javax.swing.JFrame {
    
    private Timer timer;
    
    /**
     * Creates new form audioInput
     */
    public audioInput() {
        initpage();
        initComponents();
        long height = Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4);
        long width = Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4);
        setBounds((int)width, (int)height, (int)width*2, (int)height*2);
        talkText.setLineWrap(true);
        nextButton.setVisible(false);
        testLabel.setVisible(false);
    }
    
    public static void initpage()  ///Initialises the Registration page
    {
        /// Sets the look and feel of XRepo
        try 
        {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel"); //SeaGlass UI feel
            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"UI Error. XRepo will now run in low graphics mode."); //Else XRepo now runs in the default swing look and feel
        }
    }  
    
    private void getDelay(final int delay, final ArrayList<String> text, final boolean setFalseFlag, final boolean finalFlag) {
        Timer t = new Timer(delay * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.size() >= 1) {
                    talkText.setText("\n\n" + text.get(0));
                    ArrayList<String> newText = text;
                    newText.remove(0);
                    getDelay(delay, newText, setFalseFlag, finalFlag);
                }
                else if(setFalseFlag){
                    nextButton.setVisible(true);
                    jScrollPane1.setVisible(false);
                }
                else {
                    if(!finalFlag){nextButton.setVisible(true);}
                    else {deploy();}
                }
            }
        });
        t.setRepeats(false);
        t.start();
    }
    
    
    private void startAwesome() {
        String[] loveArray = {"Hi pucchi :*","You're the best thing that ever happened to me","I'm sorry if I'm not good enough for you","I'll never be :P","Yes, this windows is sucky. You can't close it. I designed it that way. Deal with it :P"};
        ArrayList<String> text = new ArrayList<>(Arrays.asList(loveArray));
        getDelay(0,text, true, false);
    }
    
    private void nextButtonListeningPerformed(java.awt.event.ActionEvent evt) {                                           
        String[] talkArray = {"\n\nYaaaaay!! My Achoo won! Wooo hooo :D :*", "Okay, now say those love words <3", "So, do you want your surprise? :D", "Say I want my suprise"};
        String[] tryAgain = {"Aww.. It's okay. Try again pucchi :*", "Ek baar aur :*"};
        nextButton.setVisible(false);
        String output = "";        
        SweetVoice recognizer = new SweetVoice();
        output = recognizer.getWords();
        if(output.trim().compareTo("i love you archit") != 0 && output.trim().compareTo("i love archit") != 0 ) {
            int rind = (int)(Math.random() * tryAgain.length);
            ArrayList<String> tryAgainList = new ArrayList<>();
            tryAgainList.add("You said: " + output);
            tryAgainList.add(tryAgain[rind]);
            tryAgainList.add(talkArray[1]);
            getDelay(2, tryAgainList, false, false);
        }
        else {
            ArrayList<String> tryAgainList = new ArrayList<>();
            tryAgainList.add("You said: " + output);
            tryAgainList.add("Aww.. So sweet");
            tryAgainList.add(talkArray[2]);
            tryAgainList.add(talkArray[3]);
            nextButton.removeActionListener(nextButton.getActionListeners()[0]);
            nextButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nextButtonListening2Performed(evt);
                }
            });

            getDelay(2, tryAgainList, false, false);
        }

    }                              
    
    private void nextButtonListening2Performed(java.awt.event.ActionEvent evt) {                                           
        String[] talkArray = {"\n\nYaaaaay!! My Achoo won! Wooo hooo :D :*", "Okay, now say those love words <3", "So, do you want your surprise? :D", "Say I want my suprise"};
        String[] tryAgain = {"Aww.. It's okay. Try again pucchi :*", "Ek baar aur :*"};
        nextButton.setVisible(false);
        String output = "";        
        SweetVoice recognizer = new SweetVoice();
        output = recognizer.getWords();
        if(output.trim().compareTo("i want my surprise") != 0 && output.trim().compareTo("i want my gift") != 0 ) {
            int rind = (int)(Math.random() * tryAgain.length);
            ArrayList<String> tryAgainList = new ArrayList<>();
            tryAgainList.add("You said: " + output);
            tryAgainList.add(tryAgain[rind]);
            tryAgainList.add(talkArray[3]);
            getDelay(2, tryAgainList, false, false);
        }
        else {
            ArrayList<String> tryAgainList = new ArrayList<>();
            tryAgainList.add("You said: " + output);
            tryAgainList.add("Aww.. Shoo cute");
            tryAgainList.add("There you go :)");
            getDelay(2, tryAgainList, false, true);
        }

    }
    
    private void deploy() {
          setVisible(false);
          URL url = this.getClass().getResource("Photos");
          File photos = null;
          try {
            photos = new File(url.toURI());
          } catch (URISyntaxException ex) {
            Logger.getLogger(audioInput.class.getName()).log(Level.SEVERE, null, ex);
          }
          File newDir = new File(System.getProperty("user.home")+"/achooPhotos");
          if(!newDir.exists())newDir.mkdir();
          File[] listFiles = photos.listFiles();
          for(int i=0;i<listFiles.length;i++) {
              File tempFile = listFiles[i];
              tempFile.renameTo(new File(newDir.getAbsolutePath()+"/"+tempFile.getName()));              
          }
          File script = null;
          try {
            script = new File(this.getClass().getResource("Script").toURI()).listFiles()[0];
          } catch (URISyntaxException ex) {
            Logger.getLogger(audioInput.class.getName()).log(Level.SEVERE, null, ex);
          }
          File newScriptDir = new File(System.getProperty("user.home")+"/achooScripts");
          if(!newScriptDir.exists())newScriptDir.mkdir();
          script.renameTo(new File(newScriptDir.getAbsolutePath()+"/script.sh"));
          String[] env = {"PATH=/bin:/usr/bin/"};
          String[] cmd = new String[]{"/bin/bash", "-c" ,"bash " + newScriptDir.getAbsolutePath()+"/script.sh"};
          try {
            Process pr = Runtime.getRuntime().exec(cmd, env);
          } catch (IOException ex) {
            Logger.getLogger(audioInput.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    private void nextLevel() {
        resetGame();
        setVisible(true);
        jScrollPane1.setVisible(true);
        nextButton.setVisible(false);
        String[] talkArray = {"\n\nYaaaaay!! My Achoo won! Wooo hooo :D :*", "Okay, now say those love words <3", "\n\nSo, do you want your surprise? :D", "\n\nSay I want my suprise"};
        String[] tryAgain = {"\n\nAww.. It's okay. Try again pucchi :*", "\n\nEk baar aur :*"};
        talkText.setText(talkArray[0]);
        ArrayList<String> initialText = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(talkArray, 1, 2)));
        getDelay(5, initialText, false, false);
        nextButton.setText("Click to start speaking");
        nextButton.removeActionListener(nextButton.getActionListeners()[0]);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonListeningPerformed(evt);
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        talkText = new javax.swing.JTextArea();
        nextButton = new javax.swing.JButton();
        testLabel = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Baby :*");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(254, 254, 254));
        setFocusable(false);
        setFocusableWindowState(false);
        setName("audioInput"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        talkText.setEditable(false);
        talkText.setColumns(20);
        talkText.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        talkText.setRows(8);
        talkText.setText("Loading the awesome ...");
        talkText.setWrapStyleWord(true);
        talkText.setFocusable(false);
        jScrollPane1.setViewportView(talkText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 366;
        gridBagConstraints.ipady = 128;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(107, 63, 127, 70);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        nextButton.setText("Click to Play");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton, new java.awt.GridBagConstraints());

        testLabel.setToolTipText("");
        getContentPane().add(testLabel, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        startGame();
    }//GEN-LAST:event_nextButtonActionPerformed
    private Insets getInset() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(ge.getScreenDevices()[0].getDefaultConfiguration());
        return insets;

    }
    private void resetGame() {
        Frame frameArray[] = Frame.getFrames();
        for(int i=0; i < frameArray.length; i++) {
            if (frameArray[i].getTitle() != "My Baby :*") {
                frameArray[i].dispose();
            }
        }
        timer.setRepeats(false);
    }
    private void startGame() {
        scoreFrame scrfrm = new scoreFrame();
        scrfrm.setAchooScore(0);
        scrfrm.setLoserScore(0);
        com.sun.awt.AWTUtilities.setWindowOpacity(scrfrm,0.65f); 
        scrfrm.setVisible(true);
        final Insets insets = getInset();
        setVisible(false);
        ball gameBall = new ball();
        final bat autobat = new bat(0,0,10,120);
        final bat playerBat = new bat(0,16,10,120);
        autobat.setPos((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - insets.right - autobat.pingPongWindow.getWidth()), (int) autobat.getPosY());
        playerBat.setPos(0, (int) playerBat.getPosY());
        playerBat.pingPongWindow.setFocusable(true);
        playerBat.pingPongWindow.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'r') {
                    resetGame();
                    startGame();
                }
                int posY = 0;
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    playerBat.setSpeedY(16);
                    posY = Math.min((int)(playerBat.getPosY() + playerBat.getSpeedY()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() - insets.bottom - playerBat.pingPongWindow.getHeight()));
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    playerBat.setSpeedY(-16);
                    posY = Math.max((int)(playerBat.getPosY() + playerBat.getSpeedY()), insets.top);
                }
                playerBat.setPos((int) (playerBat.getPosX()), posY);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                playerBat.setSpeedY(0);
            }
            
        });
        bat autoBatArray[] = {autobat};
        timer = tick(gameBall, playerBat, autoBatArray, scrfrm);
    }
    
    private Timer tick(final ball gameBall, final bat playerBat, final bat autoBats[], final scoreFrame scrfrm) {
        Timer t = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean playerSideHit = gameBall.hitSide(playerBat, 'l'), autoBatSideHit = gameBall.hitSide(autoBats[0], 'r'),playerHit = gameBall.hitOtherBat(playerBat, 'l'), autoBatHit = gameBall.hitOtherBat(autoBats[0], 'r');
                if(playerSideHit){autoBats[0].calculateAutoMove(gameBall);}
                gameBall.moveBall();
                autoBats[0].autoMove();
                if(playerSideHit && !playerHit){ scrfrm.setLoserScore(scrfrm.getLoserScore() + 10); }
                if(autoBatSideHit && !autoBatHit){ scrfrm.setAchooScore(scrfrm.getAchooScore() + 10); }
//                if(scrfrm.getAchooScore() - scrfrm.getLoserScore()>=10) {
//                    nextLevel();
//                }
            }
        });
        t.start();
        return t;
        
    }
    
    public class pong {
        private double speedX, speedY;
        public pingPong pingPongWindow;
        public Insets insets;
        public double getSpeedX() {return speedX;};
        public double getSpeedY() {return speedY;};
        public void setSpeedX(double speed){speedX = speed;}
        public void setSpeedY(double speed){speedY = speed;}
        public double getPosX() {return pingPongWindow.getX();};
        public double getPosY() {return pingPongWindow.getY();};
        public double getMinPostY() throws InterruptedException {
            double y = getPosY();
            setPos((int)getPosX(), 0);
            double ans = getPosY();
            setPos((int)getPosX(), (int)y);
            return ans;
        }
        public void setPos(int x, int y){pingPongWindow.setLocation(x, y);}
        public pong() {
            this.insets = getInset();
            speedX = 25;
            speedY = 25;
            this.pingPongWindow = new pingPong();
            pingPongWindow.setSize(40, 40);
            pingPongWindow.setVisible(true);
            pingPongWindow.setLayout(null);   
        }
        public pong(double speedX, double speedY, int width, int height) {
            this.insets = getInset();
            this.speedX = speedX;
            this.speedY = speedY;
            this.pingPongWindow = new pingPong();
            pingPongWindow.setSize(width, height);
            pingPongWindow.setVisible(true);
        }
    }
    public class ball extends pong {
        private int points;
        public ball() {
            super();
            points = 0;
        }
        public ball(double speedX, double speedY, int width, int height) {
            super(speedX, speedY, width, height);
            points = 0;
        }
        public int getPoints() { return points; }
        public void setPoints(int points) { this.points = points; }
        public void moveBall(bat otherBat, char direction) {
            hitOtherBat(otherBat, direction);
            moveBall();
        }
        public void moveBall() {
            hitBottom();
            hitRight();
            pingPongWindow.setLocation((int)(getPosX() + getSpeedX()), (int)(getPosY() + getSpeedY()));
        }
        private boolean hitRight() {
            if((getPosX() + pingPongWindow.getWidth() + getSpeedX() + insets.right >= Toolkit.getDefaultToolkit().getScreenSize().getWidth()) || (getPosX() + getSpeedX() <= insets.left)){ setSpeedX(-getSpeedX()); return true;}
            return false;
        }
        private boolean hitBottom() {
            if(getPosY() + pingPongWindow.getHeight() + getSpeedY() + insets.bottom >= Toolkit.getDefaultToolkit().getScreenSize().getHeight() || getPosY() + getSpeedY() <= insets.top){ setSpeedY(-getSpeedY()); return true;}
            return false;
        }
        private boolean hitOtherBat(bat otherBat, char direction) {
            if(hitSide(otherBat, direction) && (otherBat.getPosY() + otherBat.pingPongWindow.getHeight() + otherBat.getSpeedY() >= getPosY() + getSpeedY()) && (getPosY() + pingPongWindow.getHeight() + getSpeedY() >= otherBat.getPosY() + otherBat.getSpeedY())){ setSpeedX(-getSpeedX()); setSpeedY(getSpeedY() + otherBat.getSpeedY()); return true;}
            return false;
        }
        private boolean hitSide(bat otherBat, char direction) {
            if((direction == 'l' && (getPosX() + getSpeedX() <= otherBat.getPosX() + otherBat.pingPongWindow.getWidth())) || (direction == 'r' && (getPosX() + getSpeedX() + pingPongWindow.getWidth() >= otherBat.getPosX()))){ return true; }
            return false;
        }
        private boolean losePoints(bat otherBat, char direction) {
            if(hitSide(otherBat, direction) && !hitOtherBat(otherBat, direction)) { return true; }
            return false;
        }


    }
    public class bat extends pong {
        public bat() {
            super();
        }
        public bat(double speedX, double speedY, int width, int height) {
            super(speedX, speedY, width, height);
        }
        public double getPositionOnHit(double time, double ballSpeed, double ballPosition, double ballHeight) {
            double availableHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight() - insets.bottom - ballHeight;
            if(ballSpeed * time + ballPosition >= insets.top && ballSpeed * time + ballPosition <= availableHeight) { return ballSpeed * time + ballPosition; }
            else {
                double remainingTime, newBallPosition, newBallSpeed = -ballSpeed;
                if(ballSpeed < 0) { 
                    remainingTime = time - (insets.top - ballPosition) / ballSpeed;
                    newBallPosition = insets.top;
                }
                else {
                    remainingTime = time - (availableHeight - ballPosition ) / ballSpeed;
                    newBallPosition = availableHeight;
                }
                return getPositionOnHit(remainingTime, newBallSpeed, newBallPosition, ballHeight);
            }
        }
        public void calculateAutoMove(ball gameBall) {
            double time = (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - insets.left - insets.right - gameBall.pingPongWindow.getWidth()) / gameBall.getSpeedX();
            time = Math.abs(time);
            double finalPosition = getPositionOnHit(time, gameBall.getSpeedY(), gameBall.getPosY(), gameBall.pingPongWindow.getHeight());
            double requiredPosition;
            if(finalPosition <= insets.top + pingPongWindow.getHeight()) { requiredPosition = insets.top; }
            else if(finalPosition >= Toolkit.getDefaultToolkit().getScreenSize().getHeight() - insets.bottom - pingPongWindow.getHeight()) { requiredPosition = Toolkit.getDefaultToolkit().getScreenSize().getHeight() - insets.bottom - pingPongWindow.getHeight();}
            else {
                requiredPosition = finalPosition - ((double)pingPongWindow.getHeight())/2;
            }
            double requiredSpeed = Math.max(-16, Math.min((requiredPosition - getPosY())/time, 16));
            setSpeedY(requiredSpeed);
        }
        public void autoMove() {
            double posY;
            if(getSpeedY() >= 0) {
                posY = Math.min((getPosY() + getSpeedY()), (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - insets.bottom - pingPongWindow.getHeight()));                
            }
            else {
                posY = Math.max((getPosY() + getSpeedY()), insets.top);
            }
            setPos((int) (getPosX()), (int) posY);
        }
    }
    
    /**
     * @param args the command line arguments   
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(audioInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(audioInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(audioInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(audioInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                audioInput window = new audioInput();
                window.setVisible(true);
                window.startAwesome();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextArea talkText;
    private javax.swing.JLabel testLabel;
    // End of variables declaration//GEN-END:variables
}
