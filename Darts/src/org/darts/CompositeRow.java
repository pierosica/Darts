package org.darts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class CompositeRow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// public int IDriga;
	public JButton bottone;
	public boolean tuttiRossi = false;
	public ExtJLabel lblNumeroA;
	public ExtJLabel lblNumeroB;
	public ExtJLabel lblNumeroC;

	// private int IDpannello;

	// imposto i BORDI dei vari elementi
	private Border borderLblNumero = new EtchedBorder(EtchedBorder.RAISED,
			null, null);
	private Border borderBtnNumero = new EtchedBorder(EtchedBorder.RAISED,
			null, null);
	private Border borderCompositeRow = new EtchedBorder(EtchedBorder.LOWERED,
			null, null);

	// metodo di creazione della CompositeRow
	public CompositeRow(final int idpannello, final int idriga) {
		this.setLayout(null);
		this.setBorder(borderCompositeRow);

		// creo le JLabel dei Numeri
		lblNumeroA = new ExtJLabel();
		lblNumeroA.setBorder(borderLblNumero);
		lblNumeroA.setBounds(60, 2, 30, 25);
		this.add(lblNumeroA);

		lblNumeroB = new ExtJLabel();
		lblNumeroB.setBorder(borderLblNumero);
		lblNumeroB.setBounds(105, 2, 30, 25);
		this.add(lblNumeroB);

		lblNumeroC = new ExtJLabel();
		lblNumeroC.setBorder(borderLblNumero);
		lblNumeroC.setBounds(145, 2, 30, 25);
		this.add(lblNumeroC);

		// creo il Bottone del Numero
		final JButton btnNumero = new JButton(idriga + 1 + "");
		btnNumero.setBounds(5, 2, 34, 25);
		this.add(btnNumero);
		btnNumero.setMargin(new Insets(2, 2, 2, 2));
		btnNumero.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNumero.setBorder(borderBtnNumero);
		btnNumero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color rosso = new Color(255, 51, 0);

				if (tuttiRossi) {
					DartMain.incrementa(idpannello, idriga);
				}
				if (!lblNumeroA.isColored()) {
					lblNumeroA.setColoured(rosso);
				} else {
					if (!lblNumeroB.isColored()) {
						lblNumeroB.setColoured(rosso);
					} else {
						if (!lblNumeroC.isColored()) {
							lblNumeroC.setColoured(rosso);
							tuttiRossi = true;
							boolean morto = DartMain.numeroMorto(idriga);
							if (morto) {
								DartMain.cambiaColore(idpannello, idriga);
							}
						}
					}
				}
			}
		});
	}

}