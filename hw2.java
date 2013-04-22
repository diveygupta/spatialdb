/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package dbms;
//import pop.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author DIVEY
 */
public class hw2 extends JFrame {

    // Variables declaration - do not modify
    private JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextArea jTextField1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private mapData jLabel1;
    // End of variables declaration
    //public Populate file=new Populate();
    public Graphics gk;
    public int mouseX = 0, mouseY = 0;
    public int[] xcod, ycod;
    public int globalpoints = 0;
	public int totpoints;
    public String query = "";
    public String totquery = "";
    public int t = 0, y = 0, u = 0;
    public int checkBox1 = 0, checkBox2 = 0, checkBox3 = 0;
    public int xpp = 0, ypp = 0;
    public Connection con = null;
    public Statement stmt = null;
    public PreparedStatement SecondStatement = null;
    public ResultSet rs = null;
    public int apr;
    public BufferedImage image = null;
    int clearAll = 0;
    public int checkAp = 0;
    public int checkP = 0;
    public int checkPq = 0;
    public int checkall=0;
        public int querycounter=0;
    private javax.swing.JScrollPane jScrollPane1;
    //  JScrollPane sp = new JScrollPane(jTextField1); 
    // JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    InputStream input = classLoader.getResourceAsStream("map.jpg");

    public hw2() {

        initComponents();
        groupButton();
        setVisible(true);
        setTitle("Divey Kumar Gupta, USC ID:8945816572");
        setResizable(false);
        //sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // jTextField1.add(scrollBar);
        // jTextField1.setAutoscrolls(true);
        // jTextField1.setRequestFocusEnabled(false);
        //   jScrollPane1.setViewportView(jTextArea1);
    }

    private void groupButton() {

        ButtonGroup bg1 = new ButtonGroup();

        bg1.add(jRadioButton1);
        bg1.add(jRadioButton2);
        bg1.add(jRadioButton3);
        bg1.add(jRadioButton4);

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new mapData();
        jTextField1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        //jLabel1.setSize(820, 580);      
        //jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton1StateChanged(evt);
            }

            private void jRadioButton1StateChanged(ChangeEvent evt) {
//                throw new UnsupportedOperationException("Not yet implemented");
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }

            private void jRadioButton1ActionPerformed(ActionEvent evt) {
                // throw new UnsupportedOperationException("Not yet implemented");
            }
        });

        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);

            }

            private void jRadioButton2StateChanged(ChangeEvent evt) {
//                throw new UnsupportedOperationException("Not yet implemented");
            }
        });

        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
                Graphics gg = getGraphics();
                gg.clearRect(2, 25, 820, 580);
                gg.drawImage(image, 2, 25, null);
                checkP = 0;
				totpoints=0;
				globalpoints=0;
            }

            private void jRadioButton2ActionPerformed(ActionEvent evt) {
                // throw new UnsupportedOperationException("Not yet implemented");
            }
        });


        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
                Graphics gg = getGraphics();
                gg.clearRect(2, 25, 820, 580);
                gg.drawImage(image, 2, 25, null);
                checkPq = 0;
            }

            private void jRadioButton3ActionPerformed(ActionEvent evt) {
                // throw new UnsupportedOperationException("Not yet implemented");
            }
        });

        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
                Graphics gg = getGraphics();
                gg.clearRect(2, 25, 820, 580);
                gg.drawImage(image, 2, 25, null);
                checkAp = 0;
            }

            private void jRadioButton4ActionPerformed(ActionEvent evt) {
                // throw new UnsupportedOperationException("Not yet implemented");
            }
        });


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 390, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 516, Short.MAX_VALUE));

        jInternalFrame1.setVisible(true);

        jCheckBox1.setText("Building");

        jCheckBox2.setText("Access Point");

        jCheckBox3.setText("People");

        jRadioButton1.setText("Whole Region");

        jRadioButton2.setText("Range Query");

        jRadioButton3.setText("Point Query");

        jRadioButton4.setText("Find AP covered People");

        jButton1.setText("Submit Query");
        jLabel3.setText("Active Feature Type");

        jLabel4.setText("Query");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jRadioButton3)
                .addComponent(jRadioButton2))
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jCheckBox1)
                .addGap(24, 24, 24)))
                .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox3))
                .addComponent(jRadioButton4)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel4)
                .addComponent(jRadioButton1))))
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jButton1))
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)))
                .addContainerGap(21, Short.MAX_VALUE)));
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jCheckBox3)
                .addComponent(jCheckBox2))
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(59, 59, 59)));

        jLabel1.setText("");

        jTextField1.setColumns(20);
        jTextField1.setRows(5);
        jScrollPane1.setViewportView(jTextField1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(817, 817, 817)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public class mapData extends JLabel implements MouseListener, MouseMotionListener {

       

        public mapData() {
            // addMouseListener();
            addMouseListener(this);
            addMouseMotionListener(this);
            totpoints = 0;
            xcod = new int[200];
            ycod = new int[200];
            // setIcon(new ImageIcon("C:\\Users\\DIVEY\\Desktop\\1st sem\\db\\hw2\\map.jpg"));
            jCheckBox1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    checkBox1 = 1;
                    // totquery=totquery+"SELECT b.b_points,b.b_coord.sdo_ordinates FROM building b"+"\n";

                }
            });


            jCheckBox2.addMouseListener(new MouseAdapter() {
//                @Override
                public void mouseClicked(MouseEvent me) {
                    checkBox2 = 1;
                    //  totquery=totquery+"SELECT u.ap_coord.SDO_POINT.X,u.ap_coord.SDO_POINT.Y,u.ap_radius FROM access_point u \n";

                }
            });
//
            jCheckBox3.addMouseListener(new MouseAdapter() {
//                @Override
                public void mouseClicked(MouseEvent me) {
                    checkBox3 = 1;
                    // totquery=totquery+"SELECT u.p_coord.SDO_POINT.X,u.p_coord.SDO_POINT.Y FROM people u \n";

                }
            });
            start();
        }

        public void mouseMoved(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
            // System.out.println("You clicked on " + mouseX + "," + mouseY);
            String cood = "(" + mouseX + "," + mouseY + ")";
            jLabel2.setText(cood);
        }

        //addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent me) {
        public void mouseClicked(MouseEvent e) {
            // System.out.println("hii");
            if (jRadioButton3.isSelected() && checkPq == 0) {
                
                Graphics gg = getGraphics();
                gg.setColor(Color.red);
              //  gg.drawRect(xpp - 2, ypp - 2, 5, 5);
                xpp = e.getX();
                ypp = e.getY();
                gg.fillRect(xpp - 2, ypp - 2, 5, 5);
                gg.drawOval(xpp - 70, ypp - 70, 140, 140);
                checkPq = 1;
            } else if (jRadioButton4.isSelected() && checkAp == 0) {
                
                Graphics gg = getGraphics();
                gg.setColor(Color.red);
                xpp = e.getX();
                ypp = e.getY();
                //gg.drawRect(xpp - 2, ypp - 2, 5, 5);
                gg.fillRect(xpp - 2, ypp - 2, 5, 5);
                checkAp = 1;

            } else if (jRadioButton2.isSelected() && checkP == 0) {
                if (totpoints > 0 && (Math.abs(xcod[0] - e.getX()) <= 2)
                        && (Math.abs(ycod[0] - e.getY()) <= 2)) {
                    mypolygon();

                    totpoints = 0;//System.out.println("hii2");  
                } else if (e.isMetaDown()) {
                    mypolygon();
                    globalpoints = totpoints;
                    totpoints = 0;
                    checkP = 1;
                } else {   //  System.out.println("hii");          
                    xcod[totpoints] = e.getX();
                    ycod[totpoints] = e.getY();

                    totpoints++;
                    if (totpoints >= 2) {
                        myline(xcod[totpoints - 2], ycod[totpoints - 2],
                                xcod[totpoints - 1], ycod[totpoints - 1]);
                    }
                }

            }
        }
        //}); // end mousePressed()

        private void myline(int x1, int y1, int x2, int y2) {

            Graphics gl = getGraphics();
            gl.setColor(Color.red);
            gl.drawLine(x1, y1, x2, y2);
            gl.dispose();
        }

        private void mypolygon() {

            if (totpoints < 2) {
                return;
            }
            Graphics gl = getGraphics();
            if (totpoints == 2) {
                gl.drawLine(xcod[0], ycod[0], xcod[1], ycod[1]);
            } else {
                gl.setColor(Color.red);
                gl.drawPolygon(xcod, ycod, totpoints);
            }
            gl.dispose();
        }

        @Override
        public void paintComponent(Graphics g) {
            try {

                image = ImageIO.read(this.getClass().getResource("map.jpg"));
                //  jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("map.jpg")));
                //   jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("**resources/map.jpg**"))); // NOI18N
            } catch (IOException ex) {
                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
            }

            g.drawImage(image, 0, 0, null);

            if (clearAll == 1) {
                return;
            }

        }
        
        public class buttonHandler implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                 
                    clearAll = 1;
                    ConnectToDB();
                    try {
                        stmt = con.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ResultSet rs;

                    if (jRadioButton1.isSelected()) {

                        Graphics gg = getGraphics();
                        gg.clearRect(0, 0, 820, 580);
                        gg.drawImage(image, 0, 0, null);
                        if (jCheckBox1.isSelected()) {
                            drawBuilding(gk);
                        }
                        if (jCheckBox2.isSelected()) {
                            drawAp(gk);
                        }
                        if (jCheckBox3.isSelected()) {
                            drawPeople(gk);
                        }
                        jTextField1.setText(totquery);
                        totquery = "";
                        querycounter=0;
                        checkBox1 = 0;
                        checkBox2 = 0;
                        checkBox3 = 0;
                    }

                    if (jRadioButton2.isSelected()) /////////////radio button2
                    {
                        // System.out.println("in button2");
						if(globalpoints>2)
						{
                        String t = "";
                        int[] xtot;
                        int[] ytot;
                        int xctr = 0, yctr = 0;
                        Number[] xytot;
                        int x = 0, y = 0, r = 0;
                        // System.out.println("total is" +globalpoints);
                        for (int i = 0; i < globalpoints; i++) {

                            t += xcod[i];
                            t += ",";
                           
                            t += ycod[i];
                            t += ",";
                        }
                        t += xcod[0];
                        t += ",";
                        
                        t += ycod[0];

                        //  System.out.println(t);
                        if (jCheckBox1.isSelected()) {
                            // System.out.println("entering check1");
                            try {
                                query = "SELECT b.bpoints,b.bcoord.sdo_ordinates FROM building b where MDSYS.sdo_anyinteract(b.bcoord,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(" + t + ")))= 'TRUE'";

                                rs = stmt.executeQuery(query);
                                querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                //System.out.println(rs);


                                while (rs.next()) {

                                    int num_points = rs.getInt("bpoints");
                                    oracle.jdbc2.Array str2 = (oracle.jdbc2.Array) ((OracleResultSet) rs).getArray("bcoord.sdo_ordinates");
                                  
                                    xytot = (Number[]) str2.getArray();
                                    
                                   
                                    xtot = new int[(xytot.length) / 2];
                                    ytot = new int[(xytot.length) / 2];


                                    
                                    for (int i = 0; i < xytot.length; i++) {
                                        if (i % 2 == 0) {
                                           
                                            xtot[xctr++] = xytot[i].intValue();
                                        } else {
                                            
                                            ytot[yctr++] = xytot[i].intValue();
                                        }
                                    }
                                     Graphics gg = getGraphics();
                                    gg.setColor(Color.yellow);

                                    gg.drawPolygon(xtot, ytot, num_points);
                                    xctr = 0;
                                    yctr = 0;

                                   
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        if (jCheckBox2.isSelected()) {
                            try {
                                query = "SELECT ap.apcoord.SDO_POINT.X,ap.apcoord.SDO_POINT.Y,ap.apradius FROM accesspoint ap where MDSYS.sdo_anyinteract(ap.apcoord2,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(" + t + ")))= 'TRUE'";
                                querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);
                               
                                while (rs.next()) {
                                    x = rs.getInt(1);
                                    y = rs.getInt(2);
                                    r = rs.getInt(3);
                                    Graphics gg = getGraphics();
                                    gg.setColor(Color.red);


                                    //gg.drawRect(x-5, y-5, 15, 15);
                                    gg.fillRect(x - 5, y - 5, 15, 15);
                                    gg.drawOval(x - r, y - r, 2 * r, 2 * r);

                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        if (jCheckBox3.isSelected()) {
                            try {

                                query = "SELECT pp.pcoord.SDO_POINT.X,pp.pcoord.SDO_POINT.Y FROM people pp where MDSYS.sdo_anyinteract(pp.pcoord,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(" + t + ")))= 'TRUE'";
                              querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);
                                
                                while (rs.next()) {
                                    x = rs.getInt(1);
                                    y = rs.getInt(2);

                                    Graphics gg = getGraphics();
                                    gg.setColor(Color.green);
                                   // gg.drawRect(x - 5, y - 5, 10, 10);
                                    gg.fillRect(x - 5, y - 5, 10, 10);

                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        t = "";
                        jCheckBox1.setSelected(false);
                        jCheckBox2.setSelected(false);
                        jCheckBox3.setSelected(false);
                        //   System.out.println("t is"+t);
                        jTextField1.setText(totquery);
                        totquery = "";
                        querycounter=0;
                    }
					
					}


                    if (jRadioButton3.isSelected()) {
                        // Graphics ggg = getGraphics();
//                        ggg.clearRect(0, 0, 820, 580);
//                        ggg.drawImage(image, 0, 0, null);

                        int x1, y1, x2, y2, x3, y3;//xpp,ypp
                        String tp = "";
                        int xctr, yctr;
                           xctr=0;yctr=0;
                        int[] xtot;
                        int[] ytot;
                        
                        Number[] xytot;
                        x3 = xpp;
                        y1 = ypp;
                         y2 = ypp;
                        
                        x1 = xpp - 70;
                        
                        x2 = xpp + 70;
                       
                        y3 = ypp - 70;
                        
                        tp = x1 + "," + y1 + "," + x2 + "," + y2 + "," + x3 + "," + y3;

                        if (jCheckBox1.isSelected()) {
                            try {
                                query = "SELECT b.bpoints,b.bcoord.sdo_ordinates FROM building b where MDSYS.sdo_anyinteract(b.bcoord,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(" + tp + ")))= 'TRUE'";
                                querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);


                                while (rs.next()) {

                                    int num_points = rs.getInt("bpoints");
                                    oracle.jdbc2.Array str2 = (oracle.jdbc2.Array) ((OracleResultSet) rs).getArray("bcoord.sdo_ordinates");
                                    
                                    xytot = (Number[]) str2.getArray();

                                    
                                    xtot = new int[xytot.length / 2];
                                    ytot = new int[xytot.length / 2];

                                    

                                    for (int i = 0; i < xytot.length; i++) {
                                        if (i % 2 == 0) {
                                
                                            xtot[xctr++] = xytot[i].intValue();
                                        } else {
                                            ytot[yctr++] = xytot[i].intValue();
										}
                                    }
                                    xctr = 0;
                                    yctr = 0;
                                    Graphics gg = getGraphics();
                                    gg.setColor(Color.green);
                                    gg.drawPolygon(xtot, ytot, num_points);
                                }



                                query = "SELECT b.bpoints,b.bcoord.sdo_ordinates FROM building b WHERE SDO_NN(b.bcoord,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(" + xpp + "," + ypp + ",NULL),NULL,NULL),'SDO_NUM_RES=1')='TRUE' AND sdo_anyinteract(b.bcoord,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(" + tp + ")))= 'TRUE'";
                                 querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+="; ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);
                                
                                while (rs.next()) {

                                    int num_points = rs.getInt("bpoints");
                                    oracle.jdbc2.Array str2 = (oracle.jdbc2.Array) ((OracleResultSet) rs).getArray("bcoord.sdo_ordinates");
                                
                                    xytot = (Number[]) str2.getArray();
                                
                                    xtot = new int[xytot.length / 2];
                                    overx=xtot[0];
                                    ytot = new int[xytot.length / 2];
                                    overy=ytot[0];
                                

                                        for (int i = 0; i < xytot.length; i++) {
                                        if (i % 2 == 0) {
                                
                                            xtot[xctr++] = xytot[i].intValue();
                                        } else {
                                
                                            ytot[yctr++] = xytot[i].intValue();
                                        }
                                    }
                                     xctr = 0;
                                    yctr = 0;
                                    Graphics gg = getGraphics();
                                    gg.setColor(Color.yellow);
                                    gg.drawPolygon(xtot, ytot, num_points);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        if (jCheckBox2.isSelected()) {
                            try {
                                query = "SELECT app.apcoord.SDO_POINT.X,app.apcoord.SDO_POINT.Y,app.apradius FROM accesspoint app where MDSYS.sdo_anyinteract(app.apcoord2,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(" + tp + ")))= 'TRUE'";
                               querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);
                                
                                while (rs.next()) {
                                    int x = rs.getInt(1);
                                
                                    int y = rs.getInt(2);
                                
                                    int r = rs.getInt(3);

                                    Graphics gg = getGraphics();
                                    gg.setColor(Color.green);

                                 //   gg.drawRect(x - 7, y - 7, 15, 15);
                                    gg.fillRect(x - 7, y - 7, 15, 15);
                                    gg.drawOval(x - r, y - r, 2 * r, 2 * r);


                                }

                                query = "SELECT app.apcoord.SDO_POINT.X,app.apcoord.SDO_POINT.Y,app.apradius FROM accesspoint app WHERE SDO_NN(app.apcoord2,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(" + xpp + "," + ypp + ",NULL),NULL,NULL),'SDO_NUM_RES=1')='TRUE' AND sdo_anyinteract(app.apcoord2,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(" + tp + ")))= 'TRUE'";
                              querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);
                                
                                while (rs.next()) {
                                    int x = rs.getInt(1);
                                
                                    int y = rs.getInt(2);
                                
                                    int r = rs.getInt(3);

                                    Graphics gg = getGraphics();
                                    gg.setColor(Color.yellow);

                               //     gg.drawRect(x - 7, y - 7, 15, 15);
                                    gg.fillRect(x - 7, y - 7, 15, 15);

                                    gg.drawOval(x - r, y - r, 2 * r, 2 * r);


                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }


                        if (jCheckBox3.isSelected()) {
                            try {
                                query = "SELECT pp.pcoord.SDO_POINT.X,pp.pcoord.SDO_POINT.Y FROM people pp where MDSYS.sdo_anyinteract(pp.pcoord,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(" + tp + ")))= 'TRUE'";
                             querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);
                                
                                while (rs.next()) {

                                    int x = rs.getInt(1);
                                    int y = rs.getInt(2);


                                    Graphics gg = getGraphics();
                                    gg.setColor(Color.green);

                                  //  gg.drawRect(x - 5, y - 5, 10, 10);
                                    gg.fillRect(x - 5, y - 5, 10, 10);


                                }

                                query = "SELECT pp.pcoord.SDO_POINT.X,pp.pcoord.SDO_POINT.Y FROM people pp WHERE SDO_NN(pp.pcoord,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(" + xpp + "," + ypp + ",NULL),NULL,NULL),'SDO_NUM_RES=1')='TRUE' AND sdo_anyinteract(pp.pcoord,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(" + tp + ")))= 'TRUE'";

                                rs = stmt.executeQuery(query);
                               querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                while (rs.next()) {
                                    int x = rs.getInt(1);
                                
                                    int y = rs.getInt(2);
                                
                                    Graphics gg = getGraphics();
                                    gg.setColor(Color.yellow);
                                    //gg.drawRect(x - 5, y - 5, 10, 10);
                                    gg.fillRect(x - 5, y - 5, 10, 10);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
                            }


                        }
                        jCheckBox1.setSelected(false);
                        jCheckBox2.setSelected(false);
                        jCheckBox3.setSelected(false);
                        jTextField1.setText(totquery);
                        totquery = "";
                        querycounter=0;
                    }///end if of radio3

                    if (jRadioButton4.isSelected()) {
                        String tp = "";
                        int x = 0, y = 0, r = 0;
                        int x1, y1, x2, y2, x3, y3;//xpp,ypp
                        try {
                            Graphics gg = getGraphics();
                            if (checkAp == 1) {
                                drawBuilding(gk);
                                drawAp(gk);
                                drawPeople(gk);
                                query = "SELECT u.apcoord.SDO_POINT.X,u.apcoord.SDO_POINT.Y,u.apradius FROM accesspoint u WHERE SDO_NN(u.apcoord,SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(" + xpp + "," + ypp + ",NULL),NULL,NULL),'SDO_NUM_RES=1')='TRUE'";
                               querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);
                                
                                while (rs.next()) {
                                    x = rs.getInt(1);
                                    xpp = x;
                                    
                                    y = rs.getInt(2);
                                    ypp = y;
                                    
                                    r = rs.getInt(3);


                                    apr = r;
                                    //   Graphics gg=getGraphics();
                                    gg.setColor(Color.blue);
                                    //gg.drawRect(x-7, y-7, 15, 15);
                                    gg.fillRect(x - 4, y - 4, 15, 15);

                                }
                                 x3 = xpp;    
                                x1 = xpp - apr - 10;
                               
                                y1 = ypp;
                                y2 = ypp;
                                x2 = xpp + apr + 10;                                
                               
                                y3 = ypp - apr - 10;

                                tp = x1 + "," + y1 + "," + x2 + "," + y2 + "," + x3 + "," + y3;
                                query = "SELECT u.pcoord.SDO_POINT.X,u.pcoord.SDO_POINT.Y FROM people u where MDSYS.sdo_anyinteract(u.pcoord,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(" + tp + ")))= 'TRUE'";
                               querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);
                                
                                while (rs.next()) {

                                    x = rs.getInt(1);
                                    y = rs.getInt(2);

                                    gg.setColor(Color.blue);
                                    //gg.drawLine(xpp,ypp,x,y);
                                    gg.fillRect(x - 3, y - 3, 10, 10);
                                }
                                


                                x1 = xpp - apr;
                                y1 = ypp;
                                y2 = ypp;
                               
                                x3 = xpp;
                                x2 = xpp + apr;
                               
                                y3 = ypp - apr;
                                    
                                tp = x1 + "," + y1 + "," + x2 + "," + y2 + "," + x3 + "," + y3;
                                query = "SELECT u.pcoord.SDO_POINT.X,u.pcoord.SDO_POINT.Y FROM people u where MDSYS.sdo_anyinteract(u.pcoord,MDSYS.SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(" + tp + ")))= 'TRUE'";
                               querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
                                totquery += query;
                                totquery += "\n";
                                rs = stmt.executeQuery(query);
                               

                                while (rs.next()) {
                                    gg.setColor(Color.yellow);    
                                    x = rs.getInt(1);
                                    
                                    y = rs.getInt(2);
                                  //  System.out.println(x+" "+y);
                                    
                                    gg.drawLine(xpp, ypp, x, y);
                                    gg.fillRect(x - 2, y - 2, 10, 10);
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
                        }


                        jTextField1.setText(totquery);
                        totquery = "";
                        querycounter=0;
                    }  //end of radio4                   
            }
        }

        public void start() {

            //  file.ap("C:\\Users\\DIVEY\\Desktop\\1st sem\\db\\hw2\\ap.xy");
            //   file.building("C:\\Users\\DIVEY\\Desktop\\1st sem\\db\\hw2\\building.xy");
            //   file.people("C:\\Users\\DIVEY\\Desktop\\1st sem\\db\\hw2\\people.xy");

            buttonHandler bh = new buttonHandler();
            jButton1.addActionListener(bh);


                       

        }

        public void drawAp(Graphics g) {
            Graphics gg = getGraphics();
//        if(y==0) {
            gg.setColor(Color.red);
//            }

          
            query = "SELECT u.apcoord.SDO_POINT.X,u.apcoord.SDO_POINT.Y,u.apradius FROM accesspoint u";
            try {
                rs = stmt.executeQuery(query);


                while (rs.next()) {
                    int x = rs.getInt(1);
                    
                    int y = rs.getInt(2);
                    
                    int r = rs.getInt(3);

                    //gg.drawRect(x - 5, y - 5, 15, 15);
                    gg.fillRect(x - 5, y - 5, 15, 15);

                    gg.drawOval(x - r, y - r, 2 * r, 2 * r);
                }
            } catch (SQLException ex) {
                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
            }
          querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
            totquery = totquery + "SELECT u.apcoord.SDO_POINT.X,u.apcoord.SDO_POINT.Y,u.apradius FROM accesspoint u \n";
        }

        public void drawPeople(Graphics g) {
            Graphics gg = getGraphics();
//        if(u==0)
            //   {
            gg.setColor(Color.green);
            //   }
            
//        }
//        else
//        {
//            
            
            //}

            query = "SELECT u.pcoord.SDO_POINT.X,u.pcoord.SDO_POINT.Y FROM people u";
            try {
                rs = stmt.executeQuery(query);


                while (rs.next()) {
                    int x = rs.getInt(1);
            
                    int y = rs.getInt(2);
            
                    //gg.drawRect(x - 3, y - 3, 10, 10);
                    gg.fillRect(x - 3, y - 3, 10, 10);
                }
            } catch (SQLException ex) {
                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
            }
            querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
            totquery = totquery + "SELECT u.pcoord.SDO_POINT.X,u.pcoord.SDO_POINT.Y FROM people u \n";
        }

        public void drawBuilding(Graphics g) {
            int xctr = 0, yctr = 0;
            int[] xtot;
            int[] ytot;

            Number[] xytot;
            Graphics gg = getGraphics();

            

            query = "SELECT b.bpoints,b.bcoord.sdo_ordinates FROM building b";
            try {
                rs = stmt.executeQuery(query);

                while (rs.next()) {


                    int num_points = rs.getInt("bpoints");
                    oracle.jdbc2.Array str = (oracle.jdbc2.Array) ((OracleResultSet) rs).getArray("bcoord.sdo_ordinates");
                   // System.out.println(str);
                    gg.setColor(Color.yellow);
                    xytot = (Number[]) str.getArray();
                    xtot = new int[xytot.length / 2];
            
                    ytot = new int[xytot.length / 2];
            
                        
                    for (int i = 0; i < xytot.length; i++) {
                        if (i % 2 == 0) {
            
                            xtot[xctr++] = xytot[i].intValue();
                        } else {
            
                            ytot[yctr++] = xytot[i].intValue();
                        }
                    }
                    xctr = 0;
                    yctr = 0;
                    
                    gg.drawPolygon(xtot, ytot, num_points);
                }
            } catch (SQLException ex) {
                Logger.getLogger(hw2.class.getName()).log(Level.SEVERE, null, ex);
            }
            querycounter++;
                                totquery+="Query";
                                totquery+=querycounter;
                                totquery+=": ";
            totquery = totquery + "SELECT b.bpoints,b.bcoord.sdo_ordinates FROM building b" + "\n";
        }

        public void mouseDragged(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void ConnectToDB() {
            // System.out.println("trying to connect");
            try {

               //   System.out.println("trying to connect");
                //System.out.print("Looking for Oracle's jdbc-odbc driver ... ");
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());


                String URL = "jdbc:oracle:thin:@localhost:1521:DIVEY";
                String userName = "scott";
                String password = "tiger";

                //	System.out.print("Connecting to DB...");
                con = DriverManager.getConnection(URL, userName, password);
              //  System.out.println(", Connected!");

                //stmt = mainConnection.createStatement();
                //	SecondStatement = mainConnection.prepareStatement( "insert into info values( ?, ?, ?)" );

            } catch (Exception e) {
                System.out.println("Error while connecting to DB: " + e.toString());
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // file = new Populate();
        new hw2().setVisible(true);


    }
}
