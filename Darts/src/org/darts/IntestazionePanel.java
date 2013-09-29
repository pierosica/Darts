package org.darts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;


@SuppressWarnings({ "serial", "unused" })
public class IntestazionePanel extends JPanel {
	private final static ButtonGroup buttonGroup = new ButtonGroup();
	private int selectedVal=2;
	private JDialog conferma;
	private Border borderIntestazione = new EtchedBorder(EtchedBorder.LOWERED,
			null, null);

	/**
	 * Create the panel.
	 */
	public IntestazionePanel() {
		
		JPanel pnlIntestazione = new JPanel();
		pnlIntestazione.setBorder(borderIntestazione);
		pnlIntestazione.setBounds(0, 0, 400, 40);
		pnlIntestazione.getLayout();
		pnlIntestazione.setVisible(true);
		
		JLabel lblNumeroGiocatori = new JLabel("Numero Giocatori");
		pnlIntestazione.add(lblNumeroGiocatori);
		
		JRadioButton rdBtnP1 = new JRadioButton("1");
		rdBtnP1.setEnabled(false);
		buttonGroup.add(rdBtnP1);
		pnlIntestazione.add(rdBtnP1);
		
		JRadioButton rdBtnP2 = new JRadioButton("2");
		buttonGroup.add(rdBtnP2);
		rdBtnP2.setSelected(true);
		pnlIntestazione.add(rdBtnP2);
		
		JRadioButton rdBtnP3 = new JRadioButton("3");
		buttonGroup.add(rdBtnP3);
		pnlIntestazione.add(rdBtnP3);
		
		JRadioButton rdBtnP4 = new JRadioButton("4");
		buttonGroup.add(rdBtnP4);
		pnlIntestazione.add(rdBtnP4);
		
		JButton btnNuovaPartita = new JButton("Nuova Partita");
		btnNuovaPartita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedVal= getSelectedButtonVal(buttonGroup);
				conferma.setVisible(true);
				DartMain.buildIt(selectedVal);
				
				
			}
		
		});
		
		
		//conferma = new JDialog(this, "test", true);
		conferma=new JDialog((Frame) this.getParent(), true);
		
		conferma.setBounds(600, 350, 300, 100);
		conferma.getContentPane().setLayout(null);
		conferma.getContentPane().add(new JLabel("Chiudi questa finestra per continuare",
						JLabel.CENTER));
		conferma.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		pnlIntestazione.add(btnNuovaPartita);
		
		add(pnlIntestazione);

	}

	public int getSelectedVal() {
		return selectedVal;
	}
	
	public int getSelectedButtonVal(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return (Integer.parseInt(button.getText()));
            }
        }

        return 0;
    }
}