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

	private static final long serialVersionUID = 1L;
	public boolean pnlChiuso;
	private boolean pnlMorto;
	private Color nero = new Color(0,0,0); 
	private Color bianco = new Color(255,255, 255); 
	public ExtJLabel lblNumeroA;
	public ExtJLabel lblNumeroB;
	public ExtJLabel lblNumeroC;
	private Border borderLblNumero = new EtchedBorder(EtchedBorder.RAISED,
			null, null);
	private Border borderBtnNumero = new EtchedBorder(EtchedBorder.RAISED,
			null, null);

	// metodo di creazione della CompositeRow
	public CompositeRow(final int idpannello, final int idriga) {
		this.setLayout(null);

		// creo le JLabel dei Numeri
		lblNumeroA = new ExtJLabel();
		lblNumeroA.setBorder(borderLblNumero);
		lblNumeroA.setBounds(40, 2, 25, 15);
		lblNumeroA.setColoured(lblNumeroA.getColor());
		this.add(lblNumeroA);

		lblNumeroB = new ExtJLabel();
		lblNumeroB.setBorder(borderLblNumero);
		lblNumeroB.setBounds(80, 2, 25, 15);
		lblNumeroB.setColoured(lblNumeroB.getColor());
		this.add(lblNumeroB);

		lblNumeroC = new ExtJLabel();
		lblNumeroC.setBorder(borderLblNumero);
		lblNumeroC.setBounds(120, 2, 25, 15);
		lblNumeroC.setColoured(lblNumeroC.getColor());
		this.add(lblNumeroC);

		/*
		 * creo il Bottone del Numero
		 */
		String btnLabel = (idriga + 1 + "");
		if (idriga==20) {
			btnLabel = "Bull";
		}
//		final JButton btnNumero = new JButton(idriga + 1 + "");
		final JButton btnNumero = new JButton(btnLabel);
		btnNumero.setBounds(5, 2, 25, 15);
		this.add(btnNumero);
		btnNumero.setMargin(new Insets(2, 2, 2, 2));
		btnNumero.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNumero.setBorder(borderBtnNumero);
		btnNumero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pnlChiuso | pnlMorto) {
					DartMain.incrementa(idpannello, idriga);
				} else {
					if (!lblNumeroA.isLblPreso()) {
						lblNumeroA.setLblPreso(true);
						pnlChiuso = false;
					} else {
						if (!lblNumeroB.isLblPreso()) {
							lblNumeroB.setLblPreso(true);
							pnlChiuso = false;
						} else {
							if (!lblNumeroC.isLblPreso()) {
								lblNumeroC.setLblPreso(true);
								pnlChiuso = true;
								pnlMorto = DartMain.isNumeroMorto(idriga);
								if (pnlMorto) {
									DartMain.cambiaColoreMorto(idpannello,
											idriga);
								}
							}
						}
					}
				}
			}
		});

		/*
		 * creo il Bottone ANNULLA Numero
		 */
		final JButton btnAnnullaNumero = new JButton(btnLabel);
		btnAnnullaNumero.setBounds(155, 5, 15, 9);
		this.add(btnAnnullaNumero);
		btnAnnullaNumero.setMargin(new Insets(2, 2, 2, 2));
		btnAnnullaNumero.setFont(new Font("Dialog", Font.PLAIN, 7));
		btnAnnullaNumero.setBorder(borderBtnNumero);
		btnAnnullaNumero.setForeground(bianco);
		btnAnnullaNumero.setBackground(nero);
		btnAnnullaNumero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent f) {
				pnlMorto = DartMain.isNumeroMorto(idriga);
				//System.out.println(pnlMorto);

				if (pnlMorto) {
					pnlChiuso = false;
					pnlMorto = false;
					DartMain.cambiaColoreChiuso(idpannello, idriga);
					// lblNumeroC.setLblPreso(false);

					// DartMain.cambiaColoreChiuso(idpannello, idriga);
				}
				if (pnlChiuso) {
					pnlChiuso = false;
				}
				if (lblNumeroC.isLblPreso() & lblNumeroB.isLblPreso()
						& lblNumeroA.isLblPreso()) {
					lblNumeroC.setLblPreso(false);
					pnlChiuso = false;
				} else {
					if (lblNumeroB.isLblPreso() & lblNumeroA.isLblPreso()) {
						lblNumeroB.setLblPreso(false);
						pnlChiuso = false;
					} else {
						if (lblNumeroA.isLblPreso()) {
							lblNumeroA.setLblPreso(false);
							pnlChiuso = false;
						}
					}
				}
			}
		});
	}
}