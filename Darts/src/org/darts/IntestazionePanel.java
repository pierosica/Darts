package org.darts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class IntestazionePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final static ButtonGroup buttonGroup = new ButtonGroup();
	private int selectedVal = 2;
	//private static JOptionPane jOptionPaneConferma = new JOptionPane();
	private Border borderIntestazione = new EtchedBorder(EtchedBorder.LOWERED,
			null, null);

	/**
	 * Create the panel.
	 */
	public IntestazionePanel() {

		JPanel pnlIntestazione = new JPanel();
		pnlIntestazione.setBorder(borderIntestazione);
		pnlIntestazione.setBounds(0, 0, 500, 40);
		pnlIntestazione.getLayout();
		pnlIntestazione.setVisible(true);

		JLabel lblNumeroGiocatori = new JLabel("Numero Giocatori");
		pnlIntestazione.add(lblNumeroGiocatori);
//
//		JRadioButton rdBtnP1 = new JRadioButton("1");
//		rdBtnP1.setEnabled(false);
//		buttonGroup.add(rdBtnP1);
//		pnlIntestazione.add(rdBtnP1);

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
		pnlIntestazione.add(btnNuovaPartita);
		btnNuovaPartita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// selectedVal = getSelectedButtonVal(buttonGroup);
				// conferma.setVisible(true);
				jOptionPanelConferma();
				// DartMain.buildIt(selectedVal);

			}

		});
		
		JButton btnCalcolaChiusura = new JButton("Calcola Chiusura");
//		btnCalcolaChiusura.setBounds(0, 0, 25, 25);
		pnlIntestazione.add(btnCalcolaChiusura);
		btnCalcolaChiusura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("test");
			}
		});
		add(pnlIntestazione);
		
	}

	public void jOptionPanelConferma() {
		Object[] options = { "Conferma", "Annulla" };
		int n = JOptionPane.showOptionDialog(this, "Sei davvero sicuro di voler iniziare una nuova partita?", "A T T E N Z I O N E ! ! !",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,
				null, options, options[1]);

		if (n == 0) {
			
			selectedVal = getSelectedButtonVal(buttonGroup);
			DartMain.buildIt(selectedVal);
			
			
			
		} else if (n == 1) {
			// usata se clikko Annulla
		} else {
			// usata se chiudo la jdialogpane con la "X"
		}
	}
	
	public int getSelectedVal() {
		return selectedVal;
	}

	public int getSelectedButtonVal(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons
				.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return (Integer.parseInt(button.getText()));
			}
		}

		return 0;
	}
}