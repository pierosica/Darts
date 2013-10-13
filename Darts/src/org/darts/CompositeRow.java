package org.darts;

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
	// public JButton bottone;
	public boolean pnlChiuso;
	private boolean pnlMorto;
	public ExtJLabel lblNumeroA;
	public ExtJLabel lblNumeroB;
	public ExtJLabel lblNumeroC;

	// private int IDpannello;

	// imposto i BORDI dei vari elementi
	private Border borderLblNumero = new EtchedBorder(EtchedBorder.RAISED,
			null, null);
	private Border borderBtnNumero = new EtchedBorder(EtchedBorder.RAISED,
			null, null);

	// private Border borderCompositeRow = new
	// EtchedBorder(EtchedBorder.LOWERED,
	// null, null);

	// metodo di creazione della CompositeRow
	public CompositeRow(final int idpannello, final int idriga) {
		this.setLayout(null);
		// this.setBorder(borderCompositeRow);

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
		final JButton btnNumero = new JButton(idriga + 1 + "");
		btnNumero.setBounds(5, 2, 25, 15);
		this.add(btnNumero);
		btnNumero.setMargin(new Insets(2, 2, 2, 2));
		btnNumero.setFont(new Font("Dialog", Font.BOLD, 12));
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
		final JButton btnAnnullaNumero = new JButton(idriga + 1 + "");
		btnAnnullaNumero.setBounds(150, 2, 25, 15);
		this.add(btnAnnullaNumero);
		btnAnnullaNumero.setMargin(new Insets(2, 2, 2, 2));
		btnAnnullaNumero.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAnnullaNumero.setBorder(borderBtnNumero);
		btnAnnullaNumero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent f) {
				pnlMorto = DartMain.isNumeroMorto(idriga);
				System.out.println(pnlMorto);

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