package guiPack;
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import com.sun.image.codec.jpeg.*;
import java.util.Vector;
import javax.swing.*;

public class MenuCreationTool extends javax.swing.JFrame {
    int ww;
    int hh;
    BufferedImage biIn, biOut;
    Graphics2D g2dIn, g2dOut;
    boolean loaded;
    Color currentColor;
    
    MainForm parent;
    
    Vector <SingleShape> shapes;
    
    String fonts[] = new String[] {"TAHOMA", "ARIAL", "TIMES NEW ROMAN"};
    int sizes[] = new int[] {10, 15, 20, 25};
    
    /** Creates new form LineDrawingTool */
    public MenuCreationTool(MainForm parent) {
        this.parent = parent;
        
        initComponents();
        
        Dimension sd  = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth()/ 2, sd.height / 2 - this.getHeight()/ 2);        
        
        loaded = false;
        currentColor = Color.BLACK;
        
        jComboFont.removeAllItems();
        for(String font: fonts) {
            jComboFont.addItem(font);
        }
        
        jComboSize.removeAllItems();
        for(int size: sizes) {
            jComboSize.addItem(size);
        }
        
        shapes = new Vector<SingleShape>();
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabelDestination = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jCheckBold = new javax.swing.JCheckBox();
        jCheckItalics = new javax.swing.JCheckBox();
        jComboFont = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jRadioDrawText = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jTextDetail = new javax.swing.JTextField();
        jComboSize = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jRadioDrawCircle = new javax.swing.JRadioButton();
        jRadioDrawSquare = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU CREATION");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("B A C K");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelDestination.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDestination.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelDestination.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDestinationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jLabelDestination);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 380, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Load Image");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Save Output");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCheckBold.setText("Bold");

        jCheckItalics.setText("Italics");

        jComboFont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Select Color");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioDrawText);
        jRadioDrawText.setSelected(true);
        jRadioDrawText.setText("Text Input");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Text To Insert ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextDetail.setText("Detail");

        jComboSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jRadioDrawText)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jTextDetail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jCheckBold)
                .add(18, 18, 18)
                .add(jCheckItalics)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jComboFont, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jComboSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 40, Short.MAX_VALUE)
                .add(jButton3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton3)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jCheckBold)
                        .add(jCheckItalics)
                        .add(jComboFont, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jComboSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jTextDetail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jRadioDrawText))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(jRadioDrawCircle);
        jRadioDrawCircle.setText("Circle");
        jRadioDrawCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDrawCircleActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioDrawSquare);
        jRadioDrawSquare.setText("Rectangle");

        jButton5.setText("UNDO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jRadioDrawCircle)
                .add(18, 18, 18)
                .add(jRadioDrawSquare)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioDrawCircle)
                    .add(jRadioDrawSquare)
                    .add(jButton5))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {jButton1, jButton2, jButton4}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jButton1)
                        .add(jButton4))
                    .add(jButton2))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        if(!loaded) {
            new MessageBox(this,"Load An Image File First!").setVisible(true);
            return;
        }

        FileDialog fd = new FileDialog(this,"Select Output Image To Save To",FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile() == null)
            return;
        String fname = fd.getDirectory() + fd.getFile();
        fname = fname.toUpperCase();
        if(!(fname.endsWith(".JPG") || (fname.endsWith(".JPEG")))) {
            fname += ".JPG";
        }

        try
        {
            // save thumbnail image to OUTFILE
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fname));
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(biOut);
            param.setQuality(1.0f, false);
            encoder.setJPEGEncodeParam(param);
            encoder.encode(biOut);
            out.close(); 
            
        }catch(Exception e) { System.out.println("Some exception: " + e); }        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        JColorChooser jc = new JColorChooser();
        currentColor = jc.showDialog(this,"Select Text Color",currentColor);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void refreshImage() {
        g2dOut.drawImage(biIn, 0, 0, ww, hh, null);
        
        for(SingleShape ss: shapes) {
            switch(ss.shapeType) {
                case 1: // text
                {
                    String text = (String)ss.parameters.get(0);
                    int x = (int)(Integer)ss.parameters.get(1);
                    int y = (int)(Integer)ss.parameters.get(2);
                    Color color = (Color)ss.parameters.get(3);
                    int fontIndex = (int)(Integer)ss.parameters.get(4);
                    int sizeIndex = (int)(Integer)ss.parameters.get(5);
                    boolean bold = (boolean )(Boolean )ss.parameters.get(6);
                    boolean italics = (boolean )(Boolean )ss.parameters.get(7);
                    
                    
                    g2dOut.setColor(color);
                    int fontStyle = 0;
                    if(bold) {
                        fontStyle |= Font.BOLD;
                    }
                    if(italics) {
                        fontStyle |= Font.ITALIC;
                    }
                    g2dOut.setFont(new Font(fonts[fontIndex], fontStyle, sizes[sizeIndex]));
                    g2dOut.drawString(text,x, y);
                }
                    break;
                case 2: // oval
                {
                    int x = (int)(Integer)ss.parameters.get(0);
                    int y = (int)(Integer)ss.parameters.get(1);
                    g2dOut.setColor((Color)ss.parameters.get(2));
                    g2dOut.drawOval(x-10, y-10, 20, 20);
                }
                    break;
                case 3: // square
                {
                    int x = (int)(Integer)ss.parameters.get(0);
                    int y = (int)(Integer)ss.parameters.get(1);
                    g2dOut.setColor((Color)ss.parameters.get(2));
                    g2dOut.drawRect(x-10, y-10, 20, 20);
                }
                    break;
            }
        }
        jLabelDestination.repaint();
    }
    
    private void jLabelDestinationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDestinationMouseClicked
// TODO add your handling code here:
        if(!loaded) {
            return;
        }
        
        if(evt.getX()>ww && evt.getY()>hh) {
            return;
        }
        
        if(jRadioDrawText.isSelected()) {
            String str = jTextDetail.getText();
            if(str=="") {
                System.out.println("Empty Text Field!");
                return;
            }
            SingleShape ss = new SingleShape();
            ss.shapeType = 1; // text
            ss.parameters.add(jTextDetail.getText());
            ss.parameters.add(evt.getX());
            ss.parameters.add(evt.getY());
            ss.parameters.add(currentColor);
            ss.parameters.add(jComboFont.getSelectedIndex());
            ss.parameters.add(jComboSize.getSelectedIndex());
            ss.parameters.add(jCheckBold.isSelected());
            ss.parameters.add(jCheckItalics.isSelected());
            
            shapes.add(ss);
        }else if(jRadioDrawCircle.isSelected()) {
            SingleShape ss = new SingleShape();
            ss.shapeType = 2;
            ss.parameters.add(evt.getX());
            ss.parameters.add(evt.getY());
            ss.parameters.add(currentColor);
            shapes.add(ss);
        }else if(jRadioDrawSquare.isSelected()) {
            SingleShape ss = new SingleShape();
            ss.shapeType = 3;
            ss.parameters.add(evt.getX());
            ss.parameters.add(evt.getY());
            ss.parameters.add(currentColor);
            shapes.add(ss);
        }
        refreshImage();
//        int printWhat = jComboPrintWhat.getSelectedIndex();
//        switch(printWhat) {
//            case 0:
//                graphics2D.setColor(currentColor);
//                graphics2D.setFont(new Font("Arial",Font.PLAIN,10));
//                graphics2D.drawString(str,evt.getX(),evt.getY());
//                break;
//            case 1:
//                graphics2D.setColor(currentColor);
//                graphics2D.drawRect(evt.getX()-2,evt.getY()-2,4,4);
//                graphics2D.setColor(currentColor.brighter());
//                graphics2D.drawRect(evt.getX()-4,evt.getY()-4,8,8);
//                break;
//            case 2:
//                graphics2D.setColor(currentColor);
//                graphics2D.drawRect(evt.getX()-2,evt.getY()-2,4,4);
//                graphics2D.setColor(currentColor.brighter());
//                graphics2D.drawRect(evt.getX()-4,evt.getY()-4,8,8);
//                
//                graphics2D.setColor(currentColor);
//                graphics2D.setFont(new Font("Arial",Font.PLAIN,10));
//                graphics2D.drawString(str,evt.getX()+10,evt.getY()+4);
//                break;
//            case 3:
//                graphics2D.setColor(currentColor);
//                graphics2D.drawOval(evt.getX()-3,evt.getY()-3,4,4);
//                graphics2D.setColor(currentColor);
//                graphics2D.setFont(new Font("Arial",Font.PLAIN,10));
//                graphics2D.drawString(str,evt.getX()+8,evt.getY()+8);
//                break;
//        }
//        jLabelDestination.repaint();
        
    }//GEN-LAST:event_jLabelDestinationMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        String fname;
        FileDialog fd = new FileDialog(this,"Select Input Image",FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile() == null)
            return;
        fname = fd.getDirectory() + fd.getFile();
        
        try
        {
            Image image = Toolkit.getDefaultToolkit().getImage(fname);
            MediaTracker mediaTracker = new MediaTracker(new Container());
            mediaTracker.addImage(image, 0);
            mediaTracker.waitForID(0);
            System.out.println("Input Image Read!");
            ww = image.getWidth(null);
            hh = image.getHeight(null);
            
            // draw original image to thumbnail image object and
            biIn = new BufferedImage(ww, hh, BufferedImage.TYPE_INT_RGB);
            g2dIn = biIn.createGraphics();
            g2dIn.drawImage(image, 0, 0, ww, hh, null);
            
            biOut = new BufferedImage(ww, hh, BufferedImage.TYPE_INT_RGB);
            g2dOut = biOut.createGraphics();
            g2dOut.drawImage(image, 0, 0, ww, hh, null);
            
            shapes.clear();
            
            jLabelDestination.setIcon(new ImageIcon(biOut));
            loaded = true;
            
        }catch(Exception e) { System.out.println("Some excep: " + e); }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        setVisible(false);
        parent.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(shapes.size() > 0) {
            shapes.remove(shapes.size() - 1);
        }
        refreshImage();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioDrawCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDrawCircleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioDrawCircleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBold;
    private javax.swing.JCheckBox jCheckItalics;
    private javax.swing.JComboBox jComboFont;
    private javax.swing.JComboBox jComboSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelDestination;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioDrawCircle;
    private javax.swing.JRadioButton jRadioDrawSquare;
    private javax.swing.JRadioButton jRadioDrawText;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextDetail;
    // End of variables declaration//GEN-END:variables
    
}
