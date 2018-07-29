package jForms;

import javax.swing.JOptionPane;

import Classes.*;

/**
 *
 * @author lutfijamaluddin
 */
public class AddClerk extends javax.swing.JFrame {
    BookingAgent ba = new BookingAgent();
    
    /**
     * Creates new form AddNewManager
     */
    public AddClerk() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clerkID = new javax.swing.JTextField();
        clerkName = new javax.swing.JTextField();
        clerkGender = new javax.swing.JTextField();
        clerkEmail = new javax.swing.JTextField();
        clerkContact = new javax.swing.JTextField();
        addClerkButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        clerkUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        clerkPassword = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBar = new javax.swing.JMenu();
        mainMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Clerk");

        jLabel1.setText("Add Clerk");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("ID :");
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel3.setText("Name :");
        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel4.setText("Gender :");
        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel5.setText("E-Mail :");
        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel6.setText("Contact Number :");
        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        clerkID.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        clerkName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        clerkGender.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        clerkEmail.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        clerkContact.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        addClerkButton.setText("Add");
        addClerkButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        addClerkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClerkButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Username:");
        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        clerkUsername.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel8.setText("Password :");
        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        clerkPassword.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

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
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addClerkButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(clerkPassword))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(clerkContact))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(clerkEmail))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(clerkGender))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(clerkName))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(clerkID, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(clerkUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(294, 294, 294))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(clerkID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clerkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(clerkGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(clerkEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(clerkContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(clerkUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(clerkPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(addClerkButton)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addClerkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClerkButtonActionPerformed
        
        // Check for if any of the fields are empty. All fields need to be filled.
        if (clerkID.getText().isEmpty() || clerkName.getText().isEmpty() || clerkGender.getText().isEmpty()
                || clerkEmail.getText().isEmpty() || clerkContact.getText().isEmpty() || clerkUsername.getText().isEmpty() || clerkPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all details!");
        } else {
            // Below is code to get the text in the respective text boxes.
            String ID = clerkID.getText().trim();
            String name = clerkName.getText().trim();
            String gender = clerkGender.getText().trim();
            String email = clerkEmail.getText().trim();
            String contactNumber = clerkContact.getText().trim();
            String username = clerkUsername.getText().trim();
            String password = clerkPassword.getText().trim();
            
            // Below is code to insert the values above into the table
            ba.register(ID, password, username, name, gender, email, contactNumber);
        }
    }//GEN-LAST:event_addClerkButtonActionPerformed
    
    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_mainMenuActionPerformed
    
    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuActionPerformed
    
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
            java.util.logging.Logger.getLogger(AddManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddManager().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClerkButton;
    private javax.swing.JTextField clerkContact;
    private javax.swing.JTextField clerkEmail;
    private javax.swing.JTextField clerkGender;
    private javax.swing.JTextField clerkID;
    private javax.swing.JTextField clerkName;
    private javax.swing.JTextField clerkPassword;
    private javax.swing.JTextField clerkUsername;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mainMenu;
    private javax.swing.JMenu menuBar;
    // End of variables declaration//GEN-END:variables
}
