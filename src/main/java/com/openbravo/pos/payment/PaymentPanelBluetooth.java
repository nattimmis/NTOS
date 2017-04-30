//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2015 uniCenta
//    http://www.unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.payment;

import javafx.embed.swing.JFXPanel;
import javax.swing.JComponent;

/**
 *
 * @author Hugh Stevenson uniCenta
 */
public class PaymentPanelBluetooth extends javax.swing.JPanel implements PaymentPanel {

    private double m_dTotal;
    private String m_sTransactionID;
    private JPaymentNotifier m_notifier;
    
    /** Creates new form PaymentPanelSimple
     * @param notifier */
    public PaymentPanelBluetooth(JPaymentNotifier notifier) {
        
        m_notifier = notifier;
        initComponents();
    }
    
    /**
     *
     * @return
     */
    @Override
    public JComponent getComponent(){
        return this;
    }
    
    /**
     *
     * @param sTransaction
     * @param dTotal
     */
    @Override
    public void activate(String sTransaction, double dTotal) {
        
        m_sTransactionID = sTransaction;
        m_dTotal = dTotal;
        
        jLabel1.setText(
                m_dTotal > 0.0
                ? "Press OK to initialize the card reader for a sale"
                : "Press OK to initialize the card reader for a refund");
        
        m_notifier.setStatus(true, true);    
        
        JFXPanel fXPanel = new JFXPanel();
        this.add(fXPanel);
    }
    
    /**
     *
     * @return
     */
    @Override
    public PaymentInfoMagcard getPaymentInfoMagcard() {

        if (m_dTotal > 0.0) {
            return new PaymentInfoMagcard(
                    "",
                    "", 
                    "",
                    null,
                    null,
                    null,
                    m_sTransactionID,
                    m_dTotal);
        } else {
            return new PaymentInfoMagcardRefund( 
                    "",
                    "", 
                    "",
                    null,
                    null,
                    null,
                    m_sTransactionID,
                    m_dTotal);
        }
    } 
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        add(jLabel1);

    }
    // </editor-fold>                        
    
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
    
}
