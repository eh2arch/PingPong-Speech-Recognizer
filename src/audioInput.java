import java.awt.Dimension;
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
import java.lang.reflect.Array;
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
    
    private void getDelay(final int delay, final ArrayList<String> text) {
        Timer t = new Timer(delay * 100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.size() >= 1) {
                    talkText.setText("\n\n" + text.get(0));
                    ArrayList<String> newText = text;
                    newText.remove(0);
                    getDelay(delay, newText);
                }
                else {
                    nextButton.setVisible(true);
                    talkText.setOpaque(false);
                    jScrollPane1.setVisible(false);
                }
            }
        });
        t.setRepeats(false);
        t.start();
    }
    
    private void startAwesome() {
        String[] loveArray = {"Hi pucchi :*","You're the best thing that ever happened to me","I'm sorry if I'm not good enough for you","I'll never be :P","Yes, this windows is sucky. You can't close it. It's designed that way. Deal with it :P"};
        ArrayList<String> text = new ArrayList<>(Arrays.asList(loveArray));
        getDelay(2,text);
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
        jLabel1 = new javax.swing.JLabel();

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
        setName("audioInput"); // NOI18N
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

        nextButton.setText("Click to continue :*");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton, new java.awt.GridBagConstraints());

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

//        try {
//            Process p = Runtime.getRuntime().exec("notify-send bababa");
//        } catch (IOException ex) {
//            Logger.getLogger(audioInput.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            File photoPath = new File("Photos/1.png");
//            System.out.println(photoPath.getAbsolutePath().toString());
//            BufferedImage myPicture = ImageIO.read(new File("Photos/1.png"));
//            jLabel1.setIcon(new ImageIcon(myPicture));
//        } catch (IOException ex) {
//            Logger.getLogger(audioInput.class.getName()).log(Level.SEVERE, null, ex);
//        }
        startGame();
    }//GEN-LAST:event_nextButtonActionPerformed
    private Insets getInset() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(ge.getScreenDevices()[0].getDefaultConfiguration());
        return insets;

    }
    private void startGame() {
        final Insets insets = getInset();
        setVisible(false);
        pong ball = new pong();
        final pong autobat = new pong(0,16,10,120);
        final pong bat = new pong(0,16,10,120);
        autobat.setPos((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - insets.right - autobat.pingPongWindow.getWidth()), (int) autobat.getPosY());
        bat.setPos(0, (int) bat.getPosY());
        bat.pingPongWindow.setFocusable(true);
        bat.pingPongWindow.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void keyPressed(KeyEvent e) {
                int posY = 0;
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    bat.setSpeedY(16);
                    posY = Math.min((int)(bat.getPosY() + bat.speedY), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() - insets.bottom - bat.pingPongWindow.getHeight()));
                }
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    bat.setSpeedY(-16);
                    posY = Math.max((int)(bat.getPosY() + bat.speedY), insets.top);
                }
                bat.setPos((int) (bat.getPosX()), posY);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                bat.setSpeedY(0);
            }
            
        });
        pong pArray[] = {bat, ball};
        tick(pArray, pArray);
    }
    
    private void tick(final movers move[], final pong pongs[]) {
        Timer t = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pongs[1].movePong(pongs[0], 'l');
            }
        });
//        t.setRepeats(false);
        t.start();
        
    }
    
    public static interface movers {
     public void movePong();
    }
    
    public class pong implements movers {
        private double speedX, speedY;
        private pingPong pingPongWindow;
        Insets insets = getInset();
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
            speedX = 25;
            speedY = 25;
            this.pingPongWindow = new pingPong();
            pingPongWindow.setSize(40, 40);
            pingPongWindow.setVisible(true);
            pingPongWindow.setLayout(null);   
        }
        public pong(double speedX, double speedY, int width, int height) {
            this.speedX = speedX;
            this.speedY = speedY;
            this.pingPongWindow = new pingPong();
            pingPongWindow.setSize(width, height);
            pingPongWindow.setVisible(true);
        }
        public void movePong(pong otherPong, char direction) {
            hitOtherPong(otherPong, direction);
            movePong();
        }
        public void movePong() {
            hitBottom();
            hitRight();
            pingPongWindow.setLocation((int)(getPosX() + speedX), (int)(getPosY() + speedY));
        }
        private boolean hitRight() {
            if(getPosX() + pingPongWindow.getWidth() + speedX + insets.left >= Toolkit.getDefaultToolkit().getScreenSize().getWidth()){ setSpeedX(-speedX); return true;}
            return false;
        }
        private boolean hitBottom() {
            if(getPosY() + pingPongWindow.getHeight() + speedY + insets.bottom >= Toolkit.getDefaultToolkit().getScreenSize().getHeight() || getPosY() + speedY <= insets.top){ setSpeedY(-speedY); return true;}
            return false;
        }
        private boolean hitOtherPong(pong otherPong, char direction) {
            if(direction == 'l' && getPosX() + speedX <= otherPong.getPosX() + otherPong.pingPongWindow.getWidth() && otherPong.getPosY() + otherPong.pingPongWindow.getHeight() + otherPong.getSpeedY() >= getPosY() + speedY && getPosY() + pingPongWindow.getHeight() + speedY >= otherPong.getPosY() + otherPong.getSpeedY()){ speedX = -speedX; speedY += otherPong.getSpeedY(); return true;}
            return false;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextArea talkText;
    // End of variables declaration//GEN-END:variables
}
