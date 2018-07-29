package jForms;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author lutfijamaluddin
 */
public final class PropertyMenu extends javax.swing.JFrame {
    
    public static int counter = 1; // Allows other classes to use this variable. Mainly used to display the correct Manager contact number
    
    /**
     * Creates new form PropertyMenu
     * @throws java.io.IOException
     */
    public PropertyMenu() throws IOException {
        initComponents();
        initProperty();
        initRecommendedProperties1();
        initRecommendedProperties2();
        initRecommendedProperties3();
    }
    
    public void initRecommendedProperties1() throws IOException{
        try {
            Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();
            String sql = "SELECT * FROM Property WHERE ID = " + counter + "AND STATE = " + "'" + PropertyMainMenu.state + "'";
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
                recommend1Name.setText(rs.getString("NAME"));
                recommend1Type.setText(rs.getString("TYPE"));
                recommend1Price.setText(rs.getString("PRICE"));
                
                InputStream propertyImageIS = rs.getBinaryStream("IMAGE");
                // Decode the inputstream as BufferedImage
                BufferedImage propertyImageBuff;
                propertyImageBuff = ImageIO.read(propertyImageIS);
                Image propertyImageI = propertyImageBuff;
                ImageIcon propertyImageIcon =new ImageIcon(propertyImageI);
                recommend1.setIcon(propertyImageIcon);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initRecommendedProperties2() throws IOException{
        try {
            Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();
            String sql = "SELECT * FROM Property WHERE ID = " + (counter + 1) + "AND STATE = " + "'" + PropertyMainMenu.state + "'";
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
                recommend2Name.setText(rs.getString("NAME"));
                recommend2Type.setText(rs.getString("TYPE"));
                recommend2Price.setText(rs.getString("PRICE"));
                
                InputStream propertyImageIS = rs.getBinaryStream("IMAGE");
                // Decode the inputstream as BufferedImage
                BufferedImage propertyImageBuff;
                propertyImageBuff = ImageIO.read(propertyImageIS);
                Image propertyImageI = propertyImageBuff;
                ImageIcon propertyImageIcon =new ImageIcon(propertyImageI);
                recommend2.setIcon(propertyImageIcon);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initRecommendedProperties3() throws IOException{
        try {
            Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();
            String sql = "SELECT * FROM Property WHERE ID = " + (counter + 2) + "AND STATE = " + "'" + PropertyMainMenu.state + "'";
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
                recommend3Name.setText(rs.getString("NAME"));
                recommend3Type.setText(rs.getString("TYPE"));
                recommend3Price.setText(rs.getString("PRICE"));
                
                InputStream propertyImageIS = rs.getBinaryStream("IMAGE");
                // Decode the inputstream as BufferedImage
                BufferedImage propertyImageBuff;
                propertyImageBuff = ImageIO.read(propertyImageIS);
                Image propertyImageI = propertyImageBuff;
                ImageIcon propertyImageIcon =new ImageIcon(propertyImageI);
                recommend3.setIcon(propertyImageIcon);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initProperty() throws IOException {
        
        if (counter == 1) {// Disables button so that the table doesn't go out of bounds upon click
            previousButton.setEnabled(false); // Disables button
        }
        else if (counter > 1) { // Enables button once the counter is back into valid indexes
            previousButton.setEnabled(true); // Enables button
        }
        if (counter == getTableSize()) {
            nextButton.setEnabled(false);
        }
        if (counter < getTableSize()) {
            nextButton.setEnabled(true);
        }
        
        try {
            Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();
//            String sql = "SELECT * FROM Property WHERE ID = " + counter + "AND STATE = " + "'" + PropertyMainMenu.state + "'";
String sql = "SELECT * FROM Property WHERE STATE = " + "'" + PropertyMainMenu.state + "'";
ResultSet rs = s.executeQuery(sql);

while(rs.next()) {
    propertyName.setText(rs.getString("NAME"));
    propertyType.setText(rs.getString("TYPE"));
    
    forRent.setSelected(rs.getBoolean("TORENT"));
    forSale.setSelected(rs.getBoolean("TOSELL"));
    
    propertyState.setText(rs.getString("STATE"));
    propertyArea.setText(rs.getString("ADDRESS"));
    propertyPrice.setText(rs.getString("PRICE"));
    propertySize.setText(rs.getString("SQUAREFOOTAGE"));
    
    InputStream propertyImageIS = rs.getBinaryStream("IMAGE");
    // Decode the inputstream as BufferedImage
    BufferedImage propertyImageBuff;
    propertyImageBuff = ImageIO.read(propertyImageIS);
    Image propertyImageI = propertyImageBuff;
    ImageIcon propertyImageIcon =new ImageIcon(propertyImageI);
    propertyImage.setIcon(propertyImageIcon);
    
    InputStream propertyMapIS = rs.getBinaryStream("MAP");
    // Decode the inputstream as BufferedImage
    BufferedImage propertyMapBuff;
    propertyMapBuff = ImageIO.read(propertyMapIS);
    Image propertyMapI = propertyMapBuff;
    ImageIcon propertyMapIcon =new ImageIcon(propertyMapI);
    propertyMap.setIcon(propertyMapIcon);
}

        } catch (SQLException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getTableSize() {
        int size = 0;
        try {
            Statement s = DriverManager.getConnection("jdbc:derby://localhost:1527/OOP", "ludwig", "password").createStatement();
            String sql = "SELECT count(*) FROM Property";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                size = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return size;
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tempo = new javax.swing.JLabel();
        propertyType = new javax.swing.JLabel();
        forRent = new javax.swing.JCheckBox();
        forSale = new javax.swing.JCheckBox();
        propertyState = new javax.swing.JLabel();
        propertyArea = new javax.swing.JLabel();
        propertyPrice = new javax.swing.JLabel();
        propertySize = new javax.swing.JLabel();
        contactManagerButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        propertyType1 = new javax.swing.JLabel();
        propertyType2 = new javax.swing.JLabel();
        propertyImage = new javax.swing.JLabel();
        propertyMap = new javax.swing.JLabel();
        propertyName = new javax.swing.JLabel();
        recommend1 = new javax.swing.JLabel();
        recommend2 = new javax.swing.JLabel();
        recommend3 = new javax.swing.JLabel();
        recommend1Name = new javax.swing.JLabel();
        recommend1Type = new javax.swing.JLabel();
        recommend1Price = new javax.swing.JLabel();
        recommend1View = new javax.swing.JButton();
        recommend2View = new javax.swing.JButton();
        recommend3View = new javax.swing.JButton();
        recommend2Name = new javax.swing.JLabel();
        recommend2Type = new javax.swing.JLabel();
        recommend2Price = new javax.swing.JLabel();
        recommend3Type = new javax.swing.JLabel();
        recommend3Name = new javax.swing.JLabel();
        recommend3Price = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBar = new javax.swing.JMenu();
        mainMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Properties");

        tempo.setText("Other Nearby Properties");
        tempo.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        tempo.setToolTipText("");

        propertyType.setText("<TYPE>");
        propertyType.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        propertyType.setToolTipText("");

        forRent.setEnabled(false);
        forRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forRentActionPerformed(evt);
            }
        });

        forSale.setEnabled(false);
        forSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forSaleActionPerformed(evt);
            }
        });

        propertyState.setText("<STATE>");
        propertyState.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        propertyState.setToolTipText("");

        propertyArea.setText("<AREA>");
        propertyArea.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        propertyArea.setToolTipText("");

        propertyPrice.setText("<PRICE>");
        propertyPrice.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        propertyPrice.setToolTipText("");

        propertySize.setText("<SIZE RANGE SQFT>");
        propertySize.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        propertySize.setToolTipText("");

        contactManagerButton.setText("Contact Manager");
        contactManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactManagerButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        propertyType1.setText("For Rent");
        propertyType1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        propertyType1.setToolTipText("");

        propertyType2.setText("For Sale");
        propertyType2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        propertyType2.setToolTipText("");

        propertyImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        propertyMap.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        propertyName.setText("<NAME>");
        propertyName.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        propertyName.setToolTipText("");

        recommend1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        recommend2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        recommend3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        recommend1Name.setText("<NAME>");
        recommend1Name.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        recommend1Name.setToolTipText("");

        recommend1Type.setText("<TYPE>");
        recommend1Type.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        recommend1Type.setToolTipText("");

        recommend1Price.setText("<PRICE>");
        recommend1Price.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        recommend1Price.setToolTipText("");

        recommend1View.setText("View");
        recommend1View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommend1ViewActionPerformed(evt);
            }
        });

        recommend2View.setText("View");
        recommend2View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommend2ViewActionPerformed(evt);
            }
        });

        recommend3View.setText("View");
        recommend3View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommend3ViewActionPerformed(evt);
            }
        });

        recommend2Name.setText("<NAME>");
        recommend2Name.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        recommend2Name.setToolTipText("");

        recommend2Type.setText("<TYPE>");
        recommend2Type.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        recommend2Type.setToolTipText("");

        recommend2Price.setText("<PRICE>");
        recommend2Price.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        recommend2Price.setToolTipText("");

        recommend3Type.setText("<TYPE>");
        recommend3Type.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        recommend3Type.setToolTipText("");

        recommend3Name.setText("<NAME>");
        recommend3Name.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        recommend3Name.setToolTipText("");

        recommend3Price.setText("<PRICE>");
        recommend3Price.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        recommend3Price.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(408, 408, 408)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contactManagerButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(previousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(propertyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(propertyMap, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(recommend2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(112, 112, 112)
                            .addComponent(recommend3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(recommend2Price, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(recommend2Type, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(recommend2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(recommend2View)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(131, 131, 131)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(recommend3Price, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(recommend3Type, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(recommend3Name, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(238, 238, 238)
                                    .addComponent(recommend3View))))))
                .addContainerGap(449, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(recommend1Price, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(recommend1Type, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(recommend1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tempo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(recommend1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(recommend1View))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(propertySize, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(propertyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(propertyState, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(propertyArea, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(propertyType, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(propertyType1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(propertyType2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(forSale)
                                        .addComponent(forRent)))
                                .addComponent(propertyName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(776, 1223, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(propertyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(propertyMap, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contactManagerButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(previousButton))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recommend2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recommend3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(recommend3Name, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recommend3Type, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recommend3Price, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(recommend3View))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(recommend2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recommend2Type, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recommend2Price, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(recommend2View)))
                .addGap(273, 273, 273))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(propertyName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(propertyType, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(propertyType2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(forRent)
                                    .addGap(18, 18, 18)))
                            .addComponent(propertyType1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(forSale)
                            .addGap(46, 46, 46)
                            .addComponent(propertyState, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(propertyArea, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(propertyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(propertySize, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(265, 265, 265)
                    .addComponent(tempo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(recommend1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(recommend1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(recommend1Type, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(recommend1Price, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(recommend1View)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel1);

        menuBar.setText("File");

        mainMenu.setText("Main Menu");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });
        menuBar.add(mainMenu);

        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        menuBar.add(exitMenu);

        jMenuBar1.add(menuBar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1177, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_mainMenuActionPerformed
    
    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuActionPerformed
    
    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        counter--;
        try {
            initProperty();
        } catch (IOException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_previousButtonActionPerformed
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        counter++;
        try {
            initProperty();
        } catch (IOException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nextButtonActionPerformed
    
    private void contactManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactManagerButtonActionPerformed
        new ContactManager().setVisible(true);
    }//GEN-LAST:event_contactManagerButtonActionPerformed
    
    private void recommend1ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommend1ViewActionPerformed
        counter = 1;
        try {
            new RecommendedProperty().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_recommend1ViewActionPerformed
    
    private void recommend2ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommend2ViewActionPerformed
        counter = 2;
        try {
            new RecommendedProperty().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_recommend2ViewActionPerformed
    
    private void recommend3ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommend3ViewActionPerformed
        counter = 3;
        try {
            new RecommendedProperty().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_recommend3ViewActionPerformed
    
    private void forSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forSaleActionPerformed
    
    private void forRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forRentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forRentActionPerformed
    
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
            java.util.logging.Logger.getLogger(PropertyMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PropertyMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PropertyMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PropertyMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new PropertyMenu().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(PropertyMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contactManagerButton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JCheckBox forRent;
    private javax.swing.JCheckBox forSale;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mainMenu;
    private javax.swing.JMenu menuBar;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel propertyArea;
    private javax.swing.JLabel propertyImage;
    private javax.swing.JLabel propertyMap;
    private javax.swing.JLabel propertyName;
    private javax.swing.JLabel propertyPrice;
    private javax.swing.JLabel propertySize;
    private javax.swing.JLabel propertyState;
    private javax.swing.JLabel propertyType;
    private javax.swing.JLabel propertyType1;
    private javax.swing.JLabel propertyType2;
    private javax.swing.JLabel recommend1;
    private javax.swing.JLabel recommend1Name;
    private javax.swing.JLabel recommend1Price;
    private javax.swing.JLabel recommend1Type;
    private javax.swing.JButton recommend1View;
    private javax.swing.JLabel recommend2;
    private javax.swing.JLabel recommend2Name;
    private javax.swing.JLabel recommend2Price;
    private javax.swing.JLabel recommend2Type;
    private javax.swing.JButton recommend2View;
    private javax.swing.JLabel recommend3;
    private javax.swing.JLabel recommend3Name;
    private javax.swing.JLabel recommend3Price;
    private javax.swing.JLabel recommend3Type;
    private javax.swing.JButton recommend3View;
    private javax.swing.JLabel tempo;
    // End of variables declaration//GEN-END:variables
}
