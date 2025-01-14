/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package In_records;

import Account.Connection2d;
import Classes.AS_prod;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ahsan
 */
public class In_Status extends javax.swing.JFrame {

    /**
     * Creates new form Rec_comp_acc
     */
    public In_Status() {
        initComponents();
        
        setCentre();
        
        setCentre();
        
        AS_prod as=new AS_prod();
        
        as.InReset(tab_recT);
        as.InCatReset(tab_recCA, "comp");
        as.InCatReset(tab_recH, "hardware");
        as.InCatReset(tab_recC, "composing");
        as.InCatReset(tab_recS, "stationary");
        Call();
    }
    private void setCentre(){
        //to set the jframe on centre:
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dim= new Dimension(tool.getScreenSize());
        int height=(int)dim.getHeight();
        int width=(int)dim.getWidth();
        setLocation(width/ 2-getWidth() / 2,height / 2-getHeight() /2);
    }
    
    private int Tqty(){
        int count=tab_recT.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recT.getValueAt(i, 3).toString());
        
        return sum; 
    }
    
    private int TqtyCA(){
        int count=tab_recCA.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recCA.getValueAt(i, 3).toString());
        
        return sum; 
    }
    
    private int TqtyH(){
        int count=tab_recH.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recH.getValueAt(i, 3).toString());
        
        return sum; 
    }
    
    private int TqtyC(){
        int count=tab_recC.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recC.getValueAt(i, 3).toString());
        
        return sum; 
    }
    
    private int TqtyS(){
        int count=tab_recS.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recS.getValueAt(i, 3).toString());
        
        return sum; 
    }
    
    private int TPtotal(){
        int count=tab_recT.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum+=Integer.parseInt(tab_recT.getValueAt(i, 3).toString())*(Integer.parseInt(tab_recT.getValueAt(i, 5).toString())-Integer.parseInt(tab_recT.getValueAt(i, 4).toString()));
       
        return sum; 
    }
    
    private int TPtotalCA(){
        int count=tab_recCA.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum+=Integer.parseInt(tab_recT.getValueAt(i, 3).toString())*(Integer.parseInt(tab_recT.getValueAt(i, 5).toString())-Integer.parseInt(tab_recT.getValueAt(i, 4).toString()));
       
        return sum; 
    }
    
    private int TPtotalH(){
        int count=tab_recH.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum+=Integer.parseInt(tab_recT.getValueAt(i, 3).toString())*(Integer.parseInt(tab_recT.getValueAt(i, 5).toString())-Integer.parseInt(tab_recT.getValueAt(i, 4).toString()));
       
        return sum; 
    }
    
    private int TPtotalC(){
        int count=tab_recC.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum+=Integer.parseInt(tab_recT.getValueAt(i, 3).toString())*(Integer.parseInt(tab_recT.getValueAt(i, 5).toString())-Integer.parseInt(tab_recT.getValueAt(i, 4).toString()));
       
        return sum; 
    }
    
    private int TPtotalS(){
        int count=tab_recS.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum+=Integer.parseInt(tab_recT.getValueAt(i, 3).toString())*(Integer.parseInt(tab_recT.getValueAt(i, 5).toString())-Integer.parseInt(tab_recT.getValueAt(i, 4).toString()));
       
        return sum; 
    }
    
    private int Ttotal(){
        int count=tab_recT.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recT.getValueAt(i, 5).toString());
        
        return sum; 
    }
    
    private int TtotalCA(){
        int count=tab_recCA.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recCA.getValueAt(i, 5).toString());
        
        return sum; 
    }
    
    private int TtotalH(){
        int count=tab_recH.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recH.getValueAt(i, 5).toString());
        
        return sum; 
    }
    
    private int TtotalC(){
        int count=tab_recC.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recC.getValueAt(i, 5).toString());
        
        return sum; 
    }
    
    private int TtotalS(){
        int count=tab_recS.getRowCount(), sum=0;
        
        for(int i=0; i<count; i++)
            sum=sum+Integer.parseInt(tab_recS.getValueAt(i, 5).toString());
        
        return sum; 
    }
    
    private void Call(){
        t_total.setText(Integer.toString(Ttotal()));
        t_prod.setText(Integer.toString(tab_recT.getRowCount()));
        t_qty.setText(Integer.toString(Tqty()));
        t_profitEst.setText(Integer.toString(TPtotal()));
        
        t_CAtotal.setText(Integer.toString(TtotalCA()));
        t_CAprod.setText(Integer.toString(tab_recCA.getRowCount()));
        t_CAqty.setText(Integer.toString(TqtyCA()));
        t_CAProfitEst.setText(Integer.toString(TPtotalCA()));
        
        t_Htotal.setText(Integer.toString(TtotalH()));
        t_Hprod.setText(Integer.toString(tab_recH.getRowCount()));
        t_Hqty.setText(Integer.toString(TqtyH()));
        t_HProfitEst.setText(Integer.toString(TPtotalH()));
        
        t_Ctotal.setText(Integer.toString(TtotalC()));
        t_Cprod.setText(Integer.toString(tab_recC.getRowCount()));
        t_Cqty.setText(Integer.toString(TqtyC()));
        t_CProfitEst.setText(Integer.toString(TPtotalC()));
        
        t_Stotal.setText(Integer.toString(TtotalS()));
        t_Sprod.setText(Integer.toString(tab_recS.getRowCount()));
        t_Sqty.setText(Integer.toString(TqtyS()));
        t_SProfitEst.setText(Integer.toString(TPtotalS()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        t_prod = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        t_qty = new javax.swing.JTextField();
        t_profitEst = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        t_total = new javax.swing.JTextField();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        t_serDate = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        t_maxDate = new com.toedter.calendar.JDateChooser();
        t_minDate = new com.toedter.calendar.JDateChooser();
        b_serDDate = new javax.swing.JButton();
        b_serDate = new javax.swing.JButton();
        b_close = new javax.swing.JButton();
        t_inDate = new com.toedter.calendar.JDateChooser();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        t_CAprod = new javax.swing.JTextField();
        t_CAqty = new javax.swing.JTextField();
        t_CAProfitEst = new javax.swing.JTextField();
        t_CAtotal = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        t_Hprod = new javax.swing.JTextField();
        t_Hqty = new javax.swing.JTextField();
        t_HProfitEst = new javax.swing.JTextField();
        t_Htotal = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        t_Cprod = new javax.swing.JTextField();
        t_Cqty = new javax.swing.JTextField();
        t_CProfitEst = new javax.swing.JTextField();
        t_Ctotal = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        t_Sprod = new javax.swing.JTextField();
        t_Sqty = new javax.swing.JTextField();
        t_SProfitEst = new javax.swing.JTextField();
        t_Stotal = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_recT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_recCA = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tab_recH = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tab_recC = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tab_recS = new javax.swing.JTable();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        b_back = new javax.swing.JButton();
        b_ser1 = new javax.swing.JButton();
        b_reset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jDesktopPane1.setBackground(new java.awt.Color(102, 102, 102));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IN STATUS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Algerian", 3, 40), new java.awt.Color(222, 97, 15))); // NOI18N
        jDesktopPane1.setForeground(new java.awt.Color(0, 255, 0));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Totals", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 2, 30), new java.awt.Color(164, 224, 250))); // NOI18N
        jLayeredPane1.setForeground(new java.awt.Color(19, 212, 206));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_prod.setEditable(false);
        t_prod.setBackground(new java.awt.Color(224, 243, 251));
        t_prod.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_prod.setToolTipText("enter code");
        t_prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_prodKeyTyped(evt);
            }
        });
        jLayeredPane1.add(t_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Products");
        jLayeredPane1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quantities");
        jLayeredPane1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        t_qty.setEditable(false);
        t_qty.setBackground(new java.awt.Color(224, 243, 251));
        t_qty.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_qtyActionPerformed(evt);
            }
        });
        t_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_qtyKeyTyped(evt);
            }
        });
        jLayeredPane1.add(t_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, 30));

        t_profitEst.setEditable(false);
        t_profitEst.setBackground(new java.awt.Color(224, 243, 251));
        t_profitEst.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_profitEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_profitEstActionPerformed(evt);
            }
        });
        t_profitEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_profitEstKeyTyped(evt);
            }
        });
        jLayeredPane1.add(t_profitEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Profit(Est)");
        jLayeredPane1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total Pur Price");
        jLayeredPane1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 30));

        t_total.setEditable(false);
        t_total.setBackground(new java.awt.Color(224, 243, 251));
        t_total.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_totalActionPerformed(evt);
            }
        });
        t_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_totalKeyTyped(evt);
            }
        });
        jLayeredPane1.add(t_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 130, 30));

        jDesktopPane1.add(jLayeredPane1);
        jLayeredPane1.setBounds(330, 60, 270, 200);

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 2, 30), new java.awt.Color(164, 224, 250))); // NOI18N
        jLayeredPane4.setForeground(new java.awt.Color(19, 212, 206));
        jLayeredPane4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_serDate.setDateFormatString("d-MM-yyyy");
        jLayeredPane4.add(t_serDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 120, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Date");
        jLayeredPane4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Min Date");
        jLayeredPane4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Max Date");
        jLayeredPane4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 30));

        t_maxDate.setDateFormatString("d-MM-yyyy");
        jLayeredPane4.add(t_maxDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 120, 30));

        t_minDate.setDateFormatString("d-MM-yyyy");
        jLayeredPane4.add(t_minDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 120, 30));

        b_serDDate.setBackground(new java.awt.Color(87, 150, 176));
        b_serDDate.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        b_serDDate.setForeground(new java.awt.Color(255, 255, 255));
        b_serDDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ser0 - Copy.png"))); // NOI18N
        b_serDDate.setText("Search");
        b_serDDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_serDDateMouseClicked(evt);
            }
        });
        b_serDDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_serDDateActionPerformed(evt);
            }
        });
        jLayeredPane4.add(b_serDDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 100, 40));

        b_serDate.setBackground(new java.awt.Color(87, 150, 176));
        b_serDate.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        b_serDate.setForeground(new java.awt.Color(255, 255, 255));
        b_serDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ser0 - Copy.png"))); // NOI18N
        b_serDate.setText("Search");
        b_serDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_serDateMouseClicked(evt);
            }
        });
        b_serDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_serDateActionPerformed(evt);
            }
        });
        jLayeredPane4.add(b_serDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 100, 30));

        jDesktopPane1.add(jLayeredPane4);
        jLayeredPane4.setBounds(10, 60, 320, 200);

        b_close.setBackground(new java.awt.Color(102, 102, 102));
        b_close.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        b_close.setForeground(java.awt.Color.red);
        b_close.setText("X");
        b_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_closeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b_closeMouseReleased(evt);
            }
        });
        b_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_closeActionPerformed(evt);
            }
        });
        jDesktopPane1.add(b_close);
        b_close.setBounds(1100, 0, 45, 30);

        t_inDate.setBackground(new java.awt.Color(210, 217, 247));
        t_inDate.setDateFormatString("d-MM-yyyy");
        jDesktopPane1.add(t_inDate);
        t_inDate.setBounds(770, 220, 0, 0);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Computer Acc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 2, 30), new java.awt.Color(164, 224, 250))); // NOI18N
        jLayeredPane2.setForeground(new java.awt.Color(19, 212, 206));
        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_CAprod.setEditable(false);
        t_CAprod.setBackground(new java.awt.Color(224, 243, 251));
        t_CAprod.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_CAprod.setToolTipText("enter code");
        t_CAprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_CAprodKeyTyped(evt);
            }
        });
        jLayeredPane2.add(t_CAprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, 30));

        t_CAqty.setEditable(false);
        t_CAqty.setBackground(new java.awt.Color(224, 243, 251));
        t_CAqty.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_CAqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_CAqtyActionPerformed(evt);
            }
        });
        t_CAqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_CAqtyKeyTyped(evt);
            }
        });
        jLayeredPane2.add(t_CAqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, 30));

        t_CAProfitEst.setEditable(false);
        t_CAProfitEst.setBackground(new java.awt.Color(224, 243, 251));
        t_CAProfitEst.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_CAProfitEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_CAProfitEstActionPerformed(evt);
            }
        });
        t_CAProfitEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_CAProfitEstKeyTyped(evt);
            }
        });
        jLayeredPane2.add(t_CAProfitEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, 30));

        t_CAtotal.setEditable(false);
        t_CAtotal.setBackground(new java.awt.Color(224, 243, 251));
        t_CAtotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_CAtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_CAtotalActionPerformed(evt);
            }
        });
        t_CAtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_CAtotalKeyTyped(evt);
            }
        });
        jLayeredPane2.add(t_CAtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 130, 30));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Total Pur Price");
        jLayeredPane2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 30));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Profit(Est)");
        jLayeredPane2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Quantities");
        jLayeredPane2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Products");
        jLayeredPane2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        jDesktopPane1.add(jLayeredPane2);
        jLayeredPane2.setBounds(600, 60, 270, 200);

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hardware", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 2, 30), new java.awt.Color(164, 224, 250))); // NOI18N
        jLayeredPane5.setForeground(new java.awt.Color(19, 212, 206));
        jLayeredPane5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_Hprod.setEditable(false);
        t_Hprod.setBackground(new java.awt.Color(224, 243, 251));
        t_Hprod.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_Hprod.setToolTipText("enter code");
        t_Hprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_HprodKeyTyped(evt);
            }
        });
        jLayeredPane5.add(t_Hprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, 30));

        t_Hqty.setEditable(false);
        t_Hqty.setBackground(new java.awt.Color(224, 243, 251));
        t_Hqty.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_Hqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_HqtyActionPerformed(evt);
            }
        });
        t_Hqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_HqtyKeyTyped(evt);
            }
        });
        jLayeredPane5.add(t_Hqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, 30));

        t_HProfitEst.setEditable(false);
        t_HProfitEst.setBackground(new java.awt.Color(224, 243, 251));
        t_HProfitEst.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_HProfitEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_HProfitEstActionPerformed(evt);
            }
        });
        t_HProfitEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_HProfitEstKeyTyped(evt);
            }
        });
        jLayeredPane5.add(t_HProfitEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, 30));

        t_Htotal.setEditable(false);
        t_Htotal.setBackground(new java.awt.Color(224, 243, 251));
        t_Htotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_Htotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_HtotalActionPerformed(evt);
            }
        });
        t_Htotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_HtotalKeyTyped(evt);
            }
        });
        jLayeredPane5.add(t_Htotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 130, 30));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Total Pur Price");
        jLayeredPane5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 30));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Profit(Est)");
        jLayeredPane5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Quantities");
        jLayeredPane5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Products");
        jLayeredPane5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        jDesktopPane1.add(jLayeredPane5);
        jLayeredPane5.setBounds(870, 60, 270, 200);

        jLayeredPane6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Composing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 2, 30), new java.awt.Color(164, 224, 250))); // NOI18N
        jLayeredPane6.setForeground(new java.awt.Color(19, 212, 206));
        jLayeredPane6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_Cprod.setEditable(false);
        t_Cprod.setBackground(new java.awt.Color(224, 243, 251));
        t_Cprod.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_Cprod.setToolTipText("enter code");
        t_Cprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_CprodKeyTyped(evt);
            }
        });
        jLayeredPane6.add(t_Cprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, 30));

        t_Cqty.setEditable(false);
        t_Cqty.setBackground(new java.awt.Color(224, 243, 251));
        t_Cqty.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_Cqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_CqtyActionPerformed(evt);
            }
        });
        t_Cqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_CqtyKeyTyped(evt);
            }
        });
        jLayeredPane6.add(t_Cqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, 30));

        t_CProfitEst.setEditable(false);
        t_CProfitEst.setBackground(new java.awt.Color(224, 243, 251));
        t_CProfitEst.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_CProfitEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_CProfitEstActionPerformed(evt);
            }
        });
        t_CProfitEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_CProfitEstKeyTyped(evt);
            }
        });
        jLayeredPane6.add(t_CProfitEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, 30));

        t_Ctotal.setEditable(false);
        t_Ctotal.setBackground(new java.awt.Color(224, 243, 251));
        t_Ctotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_Ctotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_CtotalActionPerformed(evt);
            }
        });
        t_Ctotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_CtotalKeyTyped(evt);
            }
        });
        jLayeredPane6.add(t_Ctotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 130, 30));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Total Pur Price");
        jLayeredPane6.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 30));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Profit(Est)");
        jLayeredPane6.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Quantities");
        jLayeredPane6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Products");
        jLayeredPane6.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        jDesktopPane1.add(jLayeredPane6);
        jLayeredPane6.setBounds(470, 260, 270, 200);

        jLayeredPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stationary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 2, 30), new java.awt.Color(164, 224, 250))); // NOI18N
        jLayeredPane7.setForeground(new java.awt.Color(19, 212, 206));
        jLayeredPane7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_Sprod.setEditable(false);
        t_Sprod.setBackground(new java.awt.Color(224, 243, 251));
        t_Sprod.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_Sprod.setToolTipText("enter code");
        t_Sprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_SprodKeyTyped(evt);
            }
        });
        jLayeredPane7.add(t_Sprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, 30));

        t_Sqty.setEditable(false);
        t_Sqty.setBackground(new java.awt.Color(224, 243, 251));
        t_Sqty.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_Sqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_SqtyActionPerformed(evt);
            }
        });
        t_Sqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_SqtyKeyTyped(evt);
            }
        });
        jLayeredPane7.add(t_Sqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, 30));

        t_SProfitEst.setEditable(false);
        t_SProfitEst.setBackground(new java.awt.Color(224, 243, 251));
        t_SProfitEst.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_SProfitEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_SProfitEstActionPerformed(evt);
            }
        });
        t_SProfitEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_SProfitEstKeyTyped(evt);
            }
        });
        jLayeredPane7.add(t_SProfitEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, 30));

        t_Stotal.setEditable(false);
        t_Stotal.setBackground(new java.awt.Color(224, 243, 251));
        t_Stotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        t_Stotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_StotalActionPerformed(evt);
            }
        });
        t_Stotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_StotalKeyTyped(evt);
            }
        });
        jLayeredPane7.add(t_Stotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 130, 30));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Total Pur Price");
        jLayeredPane7.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 30));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Profit(Est)");
        jLayeredPane7.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Quantities");
        jLayeredPane7.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Products");
        jLayeredPane7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        jDesktopPane1.add(jLayeredPane7);
        jLayeredPane7.setBounds(740, 260, 270, 200);

        jLayeredPane8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 2, 30), new java.awt.Color(164, 224, 250))); // NOI18N
        jLayeredPane8.setForeground(new java.awt.Color(19, 212, 206));
        jLayeredPane8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_recT.setBackground(new java.awt.Color(76, 190, 232));
        tab_recT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tab_recT.setForeground(new java.awt.Color(255, 255, 255));
        tab_recT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_recT.setGridColor(new java.awt.Color(35, 106, 118));
        tab_recT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_recTMouseClicked(evt);
            }
        });
        tab_recT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tab_recTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tab_recTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tab_recTKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tab_recT);

        jLayeredPane8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 40, 590, 20));

        tab_recCA.setBackground(new java.awt.Color(76, 190, 232));
        tab_recCA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tab_recCA.setForeground(new java.awt.Color(255, 255, 255));
        tab_recCA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_recCA.setGridColor(new java.awt.Color(35, 106, 118));
        tab_recCA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_recCAMouseClicked(evt);
            }
        });
        tab_recCA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tab_recCAKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tab_recCAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tab_recCAKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tab_recCA);

        jLayeredPane8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 60, 590, 20));

        tab_recH.setBackground(new java.awt.Color(76, 190, 232));
        tab_recH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tab_recH.setForeground(new java.awt.Color(255, 255, 255));
        tab_recH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_recH.setGridColor(new java.awt.Color(35, 106, 118));
        tab_recH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_recHMouseClicked(evt);
            }
        });
        tab_recH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tab_recHKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tab_recHKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tab_recHKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(tab_recH);

        jLayeredPane8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 80, 590, 20));

        tab_recC.setBackground(new java.awt.Color(76, 190, 232));
        tab_recC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tab_recC.setForeground(new java.awt.Color(255, 255, 255));
        tab_recC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_recC.setGridColor(new java.awt.Color(35, 106, 118));
        tab_recC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_recCMouseClicked(evt);
            }
        });
        tab_recC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tab_recCKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tab_recCKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tab_recCKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(tab_recC);

        jLayeredPane8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 100, 590, 20));

        tab_recS.setBackground(new java.awt.Color(76, 190, 232));
        tab_recS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tab_recS.setForeground(new java.awt.Color(255, 255, 255));
        tab_recS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_recS.setGridColor(new java.awt.Color(35, 106, 118));
        tab_recS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_recSMouseClicked(evt);
            }
        });
        tab_recS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tab_recSKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tab_recSKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tab_recSKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(tab_recS);

        jLayeredPane8.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 120, 590, 20));

        jDesktopPane1.add(jLayeredPane8);
        jLayeredPane8.setBounds(10, 460, 60, 40);

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action Performed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 2, 30), new java.awt.Color(164, 224, 250))); // NOI18N
        jLayeredPane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_back.setBackground(new java.awt.Color(80, 137, 161));
        b_back.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        b_back.setForeground(new java.awt.Color(255, 255, 255));
        b_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back1.png"))); // NOI18N
        b_back.setText("Back");
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });
        jLayeredPane3.add(b_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, 40));

        b_ser1.setBackground(new java.awt.Color(80, 137, 161));
        b_ser1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        b_ser1.setForeground(new java.awt.Color(255, 255, 255));
        b_ser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ser2.png"))); // NOI18N
        b_ser1.setText("Advanced");
        b_ser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_ser1MouseEntered(evt);
            }
        });
        b_ser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ser1ActionPerformed(evt);
            }
        });
        jLayeredPane3.add(b_ser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 120, 40));

        b_reset.setBackground(new java.awt.Color(80, 137, 161));
        b_reset.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        b_reset.setForeground(new java.awt.Color(255, 255, 255));
        b_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset1.png"))); // NOI18N
        b_reset.setText("Reset");
        b_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_resetActionPerformed(evt);
            }
        });
        jLayeredPane3.add(b_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 120, 40));

        jDesktopPane1.add(jLayeredPane3);
        jLayeredPane3.setBounds(10, 290, 320, 160);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ser21.png"))); // NOI18N
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(10, 50, 360, 410);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/budget_idea_investment-512.png"))); // NOI18N
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(470, 10, 600, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1144, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab_recTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_recTMouseClicked
        boolean b=tab_recT.isEditing();
        
        if(b==false){
            ImageIcon icon=new ImageIcon("delete0.png");
            JOptionPane.showMessageDialog(null,"Exception ERROR, Problem in Record Display ","CLICK COMPUTERS SERVICES",JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }//GEN-LAST:event_tab_recTMouseClicked

    private void tab_recTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recTKeyPressed

    }//GEN-LAST:event_tab_recTKeyPressed

    private void tab_recTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recTKeyReleased

    }//GEN-LAST:event_tab_recTKeyReleased

    private void tab_recTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recTKeyTyped
        char c=evt.getKeyChar();

        if(!(c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_tab_recTKeyTyped

    private void b_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_closeMouseEntered

        b_close.setBackground(Color.RED);        // TODO add your handling code here:
        b_close.setForeground(Color.white);
    }//GEN-LAST:event_b_closeMouseEntered

    private void b_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_closeMouseExited
        b_close.setBackground(Color.GRAY);
        b_close.setForeground(Color.red);
    }//GEN-LAST:event_b_closeMouseExited

    private void b_closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_closeMouseReleased

    }//GEN-LAST:event_b_closeMouseReleased

    private void b_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_closeActionPerformed
        dispose();
    }//GEN-LAST:event_b_closeActionPerformed

    private void t_qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_qtyKeyTyped

    }//GEN-LAST:event_t_qtyKeyTyped

    private void t_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_qtyActionPerformed

    private void t_profitEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_profitEstKeyTyped

    }//GEN-LAST:event_t_profitEstKeyTyped

    private void t_profitEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_profitEstActionPerformed

    }//GEN-LAST:event_t_profitEstActionPerformed

    private void t_totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_totalKeyTyped

    }//GEN-LAST:event_t_totalKeyTyped

    private void t_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_totalActionPerformed

    private void t_prodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_prodKeyTyped

    }//GEN-LAST:event_t_prodKeyTyped

    private void b_serDDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_serDDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b_serDDateMouseClicked

    private void b_serDDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_serDDateActionPerformed

        try{
            if( t_maxDate.getDateFormatString().equals("") || t_minDate.getDateFormatString().equals("")){
                ImageIcon err=new ImageIcon("war4.png");
                JOptionPane.showMessageDialog(null, "Please enter DATE Difference to Search","CLICK COMPUTER SERVICES",JOptionPane.INFORMATION_MESSAGE,err);
            }
            else{
                AS_prod ser=new AS_prod();

                String minD=((JTextField)t_minDate.getDateEditor().getUiComponent()).getText();
                String maxD=((JTextField)t_maxDate.getDateEditor().getUiComponent()).getText();

                ser.Get_InDateDiff_Data(tab_recT, minD, maxD);
                ser.Get_InDateDiffCat_Data(tab_recCA, minD, maxD, "comp");
                ser.Get_InDateDiffCat_Data(tab_recH, minD, maxD, "hardware");
                ser.Get_InDateDiffCat_Data(tab_recC, minD, maxD, "composing");
                ser.Get_InDateDiffCat_Data(tab_recS, minD, maxD, "stationary");
                Call();
            }
        }catch(Exception e){
            ImageIcon icon=new ImageIcon("notify2.png");
            JOptionPane.showMessageDialog(null,"Exception ERROR, Poblem in Searching Product by Date Difference ","CLICK COMPUTERS SERVICES",JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }//GEN-LAST:event_b_serDDateActionPerformed

    private void b_serDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_serDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b_serDateMouseClicked

    private void b_serDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_serDateActionPerformed
        try{
            if(t_serDate.getDateFormatString().equals("")){
                ImageIcon err=new ImageIcon("war4.png");
                JOptionPane.showMessageDialog(null, "Please enter DATE to Search","CLICK COMPUTER SERVICES",JOptionPane.INFORMATION_MESSAGE,err);
            }
            else{
                AS_prod ser=new AS_prod();
                String date=((JTextField)t_serDate.getDateEditor().getUiComponent()).getText();

                if(ser.search_InDate(date)==true){
                    ser.Get_InDdata(tab_recT, date);
                    ser.Get_InCatDdata(tab_recCA, date, "comp");
                    ser.Get_InCatDdata(tab_recH, date, "hardware");
                    ser.Get_InCatDdata(tab_recC, date, "composing");
                    ser.Get_InCatDdata(tab_recS, date, "stationary");
                    Call();
                }
                else
                JOptionPane.showMessageDialog(null, "Invalid Date","CLICK COMPUTERS SERVICES",JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){
            ImageIcon icon=new ImageIcon("notify2.png");
            JOptionPane.showMessageDialog(null,"Exception ERROR, Poblem in Searching Product by Date","CLICK COMPUTERS SERVICES",JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }//GEN-LAST:event_b_serDateActionPerformed

    private void t_CAprodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_CAprodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CAprodKeyTyped

    private void t_CAqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_CAqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CAqtyActionPerformed

    private void t_CAqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_CAqtyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CAqtyKeyTyped

    private void t_CAProfitEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_CAProfitEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CAProfitEstActionPerformed

    private void t_CAProfitEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_CAProfitEstKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CAProfitEstKeyTyped

    private void t_CAtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_CAtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CAtotalActionPerformed

    private void t_CAtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_CAtotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CAtotalKeyTyped

    private void t_HprodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_HprodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_HprodKeyTyped

    private void t_HqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_HqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_HqtyActionPerformed

    private void t_HqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_HqtyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_HqtyKeyTyped

    private void t_HProfitEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_HProfitEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_HProfitEstActionPerformed

    private void t_HProfitEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_HProfitEstKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_HProfitEstKeyTyped

    private void t_HtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_HtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_HtotalActionPerformed

    private void t_HtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_HtotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_HtotalKeyTyped

    private void t_CprodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_CprodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CprodKeyTyped

    private void t_CqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_CqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CqtyActionPerformed

    private void t_CqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_CqtyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CqtyKeyTyped

    private void t_CProfitEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_CProfitEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CProfitEstActionPerformed

    private void t_CProfitEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_CProfitEstKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CProfitEstKeyTyped

    private void t_CtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_CtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CtotalActionPerformed

    private void t_CtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_CtotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_CtotalKeyTyped

    private void t_SprodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_SprodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_SprodKeyTyped

    private void t_SqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_SqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_SqtyActionPerformed

    private void t_SqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_SqtyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_SqtyKeyTyped

    private void t_SProfitEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_SProfitEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_SProfitEstActionPerformed

    private void t_SProfitEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_SProfitEstKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_SProfitEstKeyTyped

    private void t_StotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_StotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_StotalActionPerformed

    private void t_StotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_StotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_StotalKeyTyped

    private void tab_recCAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_recCAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recCAMouseClicked

    private void tab_recCAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recCAKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recCAKeyPressed

    private void tab_recCAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recCAKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recCAKeyReleased

    private void tab_recCAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recCAKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recCAKeyTyped

    private void b_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_resetActionPerformed

        AS_prod as=new AS_prod();
        as.InReset(tab_recT);
        as.InCatReset(tab_recCA, "comp");
        as.InCatReset(tab_recH, "hardware");
        as.InCatReset(tab_recC, "composing");
        as.InCatReset(tab_recS, "stationary");
        Call();
    }//GEN-LAST:event_b_resetActionPerformed

    private void tab_recHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_recHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recHMouseClicked

    private void tab_recHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recHKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recHKeyPressed

    private void tab_recHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recHKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recHKeyReleased

    private void tab_recHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recHKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recHKeyTyped

    private void tab_recCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_recCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recCMouseClicked

    private void tab_recCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recCKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recCKeyPressed

    private void tab_recCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recCKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recCKeyReleased

    private void tab_recCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recCKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recCKeyTyped

    private void tab_recSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_recSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recSMouseClicked

    private void tab_recSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recSKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recSKeyPressed

    private void tab_recSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recSKeyReleased

    private void tab_recSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tab_recSKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tab_recSKeyTyped

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        dispose();
    }//GEN-LAST:event_b_backActionPerformed

    private void b_ser1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ser1MouseEntered

    }//GEN-LAST:event_b_ser1MouseEntered

    private void b_ser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ser1ActionPerformed
        In_Search ser=new In_Search();
        ser.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_ser1ActionPerformed

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
            java.util.logging.Logger.getLogger(In_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(In_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(In_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(In_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new In_Status().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_close;
    private javax.swing.JButton b_reset;
    private javax.swing.JButton b_ser1;
    private javax.swing.JButton b_serDDate;
    private javax.swing.JButton b_serDate;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField t_CAProfitEst;
    private javax.swing.JTextField t_CAprod;
    private javax.swing.JTextField t_CAqty;
    private javax.swing.JTextField t_CAtotal;
    private javax.swing.JTextField t_CProfitEst;
    private javax.swing.JTextField t_Cprod;
    private javax.swing.JTextField t_Cqty;
    private javax.swing.JTextField t_Ctotal;
    private javax.swing.JTextField t_HProfitEst;
    private javax.swing.JTextField t_Hprod;
    private javax.swing.JTextField t_Hqty;
    private javax.swing.JTextField t_Htotal;
    private javax.swing.JTextField t_SProfitEst;
    private javax.swing.JTextField t_Sprod;
    private javax.swing.JTextField t_Sqty;
    private javax.swing.JTextField t_Stotal;
    private com.toedter.calendar.JDateChooser t_inDate;
    private com.toedter.calendar.JDateChooser t_maxDate;
    private com.toedter.calendar.JDateChooser t_minDate;
    private javax.swing.JTextField t_prod;
    private javax.swing.JTextField t_profitEst;
    private javax.swing.JTextField t_qty;
    private com.toedter.calendar.JDateChooser t_serDate;
    private javax.swing.JTextField t_total;
    private javax.swing.JTable tab_recC;
    private javax.swing.JTable tab_recCA;
    private javax.swing.JTable tab_recH;
    private javax.swing.JTable tab_recS;
    private javax.swing.JTable tab_recT;
    // End of variables declaration//GEN-END:variables
}
