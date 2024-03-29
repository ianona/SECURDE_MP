package View;

import Controller.SQLiteJDBCDriverConnection;

public class Register extends javax.swing.JPanel {

    public Frame frame;

    public Register() {
        initComponents();
        errorLbl.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        confpass = new javax.swing.JPasswordField();
        errorLbl = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        password.setBackground(new java.awt.Color(240, 240, 240));
        password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        username.setBackground(new java.awt.Color(240, 240, 240));
        username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        confpass.setBackground(new java.awt.Color(240, 240, 240));
        confpass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confpass.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        errorLbl.setForeground(new java.awt.Color(255, 0, 0));
        errorLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLbl.setText("jLabel2");

        jButton2.setText("<< Back");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confpass, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(200, 200, 200))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorLbl)
                .addGap(12, 12, 12)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confpass, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //checks the validation of the password and confirmation
        SQLiteJDBCDriverConnection database = new SQLiteJDBCDriverConnection();
        int correct = 0;
        boolean hasUppercase = !password.getText().equals(password.getText().toLowerCase());
        boolean hasLowercase = !password.getText().equals(password.getText().toUpperCase());
        boolean isAtLeast8 = password.getText().length() >= 8;
        boolean hasSpecial = !password.getText().matches("[A-Za-z0-9 ]*");
        boolean hasNumber = password.getText().matches(".*\\d+.*");

        if (database.checkUsers(username.getText()).size() == 0) {
            // checks if both username and password are not empty
            if (password.getText().isEmpty() || username.getText().isEmpty()) {
                errorLbl.setText("Error! Username and password cannot be empty");
                errorLbl.setVisible(true);
            } else {
                correct = correct + 1;
            }

            //checks if the password is same as the confirmation password
            if (password.getText().equals(confpass.getText())) {
                correct = correct + 1;
            } else {
                System.out.println("NOT SAME PASSWORD");
                errorLbl.setText("Error! Passwords are not the same");
                errorLbl.setVisible(true);
            }

            //checks if the passsword field is empty
            if (!password.getText().equals("")) {
                correct = correct + 1;

            } else {
                System.out.println("EMPTY");
                errorLbl.setText("Error! Password cannot be empty");
                errorLbl.setVisible(true);
            }

            //checks if has 1 upper case letter
            if (hasUppercase) {
                correct = correct + 1;
            } else {
                System.out.println("NO UPPER CASE");
                errorLbl.setText("Error! Password requires at least 1 uppercase character");
                errorLbl.setVisible(true);
            }

            //checks if has 1 lower case letter
            if (hasLowercase) {
                correct = correct + 1;
            } else {
                System.out.println("NO LOWER CASE");
                errorLbl.setText("Error! Password requires at least 1 lowercase character");
                errorLbl.setVisible(true);
            }

            //check if it has at least 8 characters
            if (isAtLeast8) {
                correct = correct + 1;
            } else {
                System.out.println("NOT MORE THAN 8 CHAR");
                errorLbl.setText("Error! Password requires at least 8 characters");
                errorLbl.setVisible(true);
            }

            //check if it has number
            if (hasNumber) {
                correct = correct + 1;
            } else {
                System.out.println("NO NUMBER");
                errorLbl.setText("Error! Password requires at least 1 number");
                errorLbl.setVisible(true);
            }

            //check if it has special characters
            if (hasSpecial) {
                correct = correct + 1;
            } else {
                System.out.println("NOT SPECIAL");
                errorLbl.setText("Error! Password requires at least 1 special character");
                errorLbl.setVisible(true);
            }

            //if all of the condition checks, it stores the password
            if (correct == 8) {
                errorLbl.setVisible(false);
                frame.registerAction(username.getText(), password.getText(), confpass.getText());
                frame.loginNav();
                username.setText("");
                password.setText("");
                confpass.setText("");
            } else {
                System.out.println(correct);
            }
        } else {
            System.out.println("CHOOSE UNIQUE USERNAME");
            errorLbl.setText("Username is taken");
            errorLbl.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        errorLbl.setVisible(false);
        username.setText("");
        password.setText("");
        confpass.setText("");
        frame.loginNav();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confpass;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
