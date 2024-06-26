/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CastleVania;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class CrearPlayer extends javax.swing.JFrame {
ArrayList<Logs> Todoslos_Logs;
    //Variable Global que contiene todos los usuarios
    ArrayList<Usuario> Usuarios;
    //Variable Global que indica cuando se le da click a la caja de texto de Nombre
    boolean CT_Nombre_Clickeado = false;
    //Variable Global que indica cuando se le da click a la caja de texto de Contreseña
    boolean CT_Pass_Clickeado = false;

    
    //Constructor del Frame con Atributo que Obtiene la lista de Usuarios
    public CrearPlayer(ArrayList UsuariosObtenidos, ArrayList<Logs> Todoslos_Logs_A) {

        
        //Crea una nueva lista de usuarios (por si aun no se ha creado)
        Usuarios = new ArrayList<Usuario>();
        
        //Si ya se creo una lista de usuarios que viene por medio del atributo esta 
        // se iguala a la variable global
        if (UsuariosObtenidos != null) {
            Usuarios = UsuariosObtenidos;
        }
        
        
                
         Todoslos_Logs = new ArrayList<Logs>();
        if(Todoslos_Logs_A != null){
            Todoslos_Logs= Todoslos_Logs_A;
        }

        initComponents();
        this.setResizable(false);
         this.setSize(860, 480);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(60, 63, 65));
        jTextField1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Nombre");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 230, 34));

        jPasswordField1.setBackground(new java.awt.Color(60, 63, 65));
        jPasswordField1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 230, 35));

        jButton1.setBackground(new java.awt.Color(60, 63, 65));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Crear");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 150, 40));

        jButton2.setBackground(new java.awt.Color(60, 63, 65));
        jButton2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Volver");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pantalla1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 860, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        //Obtencion de Nombre y Contraseña de los cuadros de texto
        String Nombre = jTextField1.getText();
        String Pass = jPasswordField1.getText();
        
        //Boolean para saber si el usuario existe
       

       
       if(jPasswordField1.getText().length() != 5){
           
           
             JOptionPane.showMessageDialog(null, "Error, la contraseña debe ser exactamente de 5 caracteres");
       
       return;
       }
        //Ciclo que recorre toda la lista de usuarios buscando si el nombre
        // ya fue creado, si existe mandara un mensaje 
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).getUser().equals(Nombre)) {
                JOptionPane.showMessageDialog(null, "Error, el usuario ya existe");
                return;
            }
        }

            //Se crea un nuevo objeto usuario con Nombre y Contraseña
            Usuario UsuarioCreado = new Usuario(Nombre, Pass);

            // El objetoUsuario se agrega a la lista de usuarios
            Usuarios.add(UsuarioCreado);

            // Se envia un mensaje de confirmacion
            JOptionPane.showMessageDialog(null, "Usuario Creado Exitosamente");
            
            MenuInicial ObjetoMenuInicial = new MenuInicial(Usuarios, this.Todoslos_Logs);
        ObjetoMenuInicial.setVisible(true);
            this.dispose();
            
        

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        
        
        //Creamos un Jframe y lo hacemos visible
        MenuInicial ObjetoMenuInicial = new MenuInicial(Usuarios, this.Todoslos_Logs);
        ObjetoMenuInicial.setVisible(true);
        
        //Cerramos el Jframe actual
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
       
        //Si no se ha dado clic en el cuadro de texto, se borrara su contenido inicial
        
        if (!CT_Nombre_Clickeado) {
            jTextField1.setText("");
            CT_Nombre_Clickeado = true;
        }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
     
              //Si no se ha dado clic en el cuadro de texto, se borrara su contenido inicial
        if (!CT_Pass_Clickeado) {
            jPasswordField1.setText("");
            CT_Pass_Clickeado = true;
        }
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPlayer(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
