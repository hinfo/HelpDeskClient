/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinfo.client.views;

import com.hinfo.main.ConectaBD;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author henrique
 */
public class TelaPrincipal extends javax.swing.JFrame {
        VerificaServidor status = new VerificaServidor();
        
        Thread t1 = new Thread(status);
        public static String url;
        public static String porta;
    
    
    public TelaPrincipal() {
        initComponents();
        lerConfig();
        t1.start();
        
    }
    
     public static void lerConfig(){
        JSONObject config;
        JSONParser dados = new JSONParser();
        
        try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			config = (JSONObject) dados.parse(new FileReader("config.json"));
			
			//Salva nas variaveis os dados retirados do arquivo
			url = (String) config.get("url");
			porta = (String) config.get("porta");
//			jTextFieldConfigServer.setText(url);
//                        jTextFieldConfigPort.setText(porta);

			System.out.printf(
					"Url: %s\nPorta: %s\n ",
					url, Integer.parseInt(porta));
		} 
		//Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
                    System.out.println("Arquivo de Configuração não encontado: \n" + e);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    class VerificaServidor extends Thread {
        @Override
            public void run(){
            Registry myRegistry;
            while (true){
            try {
                VerificaServidor.sleep(2000);
                myRegistry = LocateRegistry.getRegistry(url, Integer.parseInt(porta));
                ConectaBD obj = (ConectaBD) myRegistry.lookup("servico");
                String status = obj.mensagem();
                jLabelMsgServer.setForeground(Color.blue);
                jLabelMsgServer.setText(status);
                               
            } catch (RemoteException ex) {
                    jLabelMsgServer.setForeground(Color.red);
                    jLabelMsgServer.setText("Sem Conexão com o servidor! IP " + url + "");
               // Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
        }
    };
            

            
    public String msgServidor() throws RemoteException, NotBoundException{
           Registry myRegistry = LocateRegistry.getRegistry(url,Integer.parseInt(porta));
           ConectaBD obj = (ConectaBD) myRegistry.lookup("servico");
            return obj.mensagem();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMsgServer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jDesktopPaneMain = new javax.swing.JDesktopPane(){

            ImageIcon icon = new ImageIcon(
                getClass().getResource("/img/bcg1.png"));
            Image img = icon.getImage();

            @Override
            public void paintComponent(Graphics g){
                g.drawImage(img, 0, 0,getWidth(),getHeight(), this);
            }
        }
        ;
        jButtonPesquisa = new javax.swing.JButton();
        jButtonPost = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonConfig = new javax.swing.JButton();
        jMenuBarSistema = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemPesquisar = new javax.swing.JMenuItem();
        jMenuItemCadastrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HelpDesk Iconeweb");
        setPreferredSize(new java.awt.Dimension(1200, 700));

        jLabelMsgServer.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabelMsgServer.setForeground(new java.awt.Color(30, 78, 21));
        jLabelMsgServer.setText("Sem Conexão");

        jLabel1.setText("Usuário:");

        jLabelUsuario.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(0, 0, 153));
        jLabelUsuario.setText("USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelMsgServer, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabelUsuario)
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMsgServer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelUsuario))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDesktopPaneMainLayout = new javax.swing.GroupLayout(jDesktopPaneMain);
        jDesktopPaneMain.setLayout(jDesktopPaneMainLayout);
        jDesktopPaneMainLayout.setHorizontalGroup(
            jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPaneMainLayout.setVerticalGroup(
            jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        jButtonPesquisa.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hinfo/client/views/Magnifying Glass.png"))); // NOI18N
        jButtonPesquisa.setText("Pesquisa");
        jButtonPesquisa.setToolTipText("Pesquisas");
        jButtonPesquisa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPesquisa.setIconTextGap(15);
        jButtonPesquisa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        jButtonPost.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jButtonPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hinfo/client/views/Post.png"))); // NOI18N
        jButtonPost.setText("Postar");
        jButtonPost.setToolTipText("Inserir novo Post");
        jButtonPost.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPost.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPostActionPerformed(evt);
            }
        });

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hinfo/client/views/Door.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setToolTipText("Sair");
        jButtonSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonConfig.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jButtonConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hinfo/client/views/System.png"))); // NOI18N
        jButtonConfig.setText("Configurações");
        jButtonConfig.setToolTipText("Configurações");
        jButtonConfig.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConfig.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfigActionPerformed(evt);
            }
        });

        jMenu1.setText("Sistema");

        jMenuItem1.setText("Configurações");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Sair");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBarSistema.add(jMenu1);

        jMenu2.setText("Postagems");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });

        jMenuItemPesquisar.setText("Pesquisar");
        jMenuItemPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPesquisar);

        jMenuItemCadastrar.setText("Cadastrar");
        jMenuItemCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemCadastrarMouseClicked(evt);
            }
        });
        jMenuItemCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCadastrar);

        jMenuBarSistema.add(jMenu2);

        setJMenuBar(jMenuBarSistema);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPost, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonConfig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 599, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDesktopPaneMain)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        setBounds(0, 0, 1200, 740);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItemCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenuItemCadastrarMouseClicked

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItemCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarActionPerformed
        // TODO add your handling code here:
        WCadastro cadastro = new WCadastro();
        jDesktopPaneMain.add(cadastro);
        cadastro.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarActionPerformed
        // TODO add your handling code here:
        WPesquisa pesq = new WPesquisa();
        jDesktopPaneMain.add(pesq);
        pesq.setVisible(true);
        pesq.show();
    }//GEN-LAST:event_jMenuItemPesquisarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        WConfig config = new WConfig();
        jDesktopPaneMain.add(config);
        config.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        // TODO add your handling code here:
        WPesquisa pesq = new WPesquisa();
        jDesktopPaneMain.add(pesq);
        pesq.setVisible(true);
        pesq.show();
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jButtonPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPostActionPerformed
        // TODO add your handling code here:
        WCadastro cadastro = new WCadastro();
        jDesktopPaneMain.add(cadastro);
        cadastro.setVisible(true);
    }//GEN-LAST:event_jButtonPostActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfigActionPerformed
        // TODO add your handling code here:
        WConfig config = new WConfig();
        jDesktopPaneMain.add(config);
        config.setVisible(true);
    }//GEN-LAST:event_jButtonConfigActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
               
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfig;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonPost;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JDesktopPane jDesktopPaneMain;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabelMsgServer;
    public static javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBarSistema;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemCadastrar;
    private javax.swing.JMenuItem jMenuItemPesquisar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
