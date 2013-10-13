package org.darts;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ExtJLabel extends JLabel {

	private Color color;
	private Color grigio = new Color(230, 230, 230);
	private Color rosso = new Color(255, 0, 0);
	private Color blue = new Color(0, 0, 255);
	private boolean hasColor = false;
	private boolean lblPreso = false;
	private boolean lblMorto = false;

	public boolean isColored() {
		return hasColor;
	}

	public Color getColor() {
		return color;
	}

	public void setColoured(Color colore) {
		this.color = colore;
		this.setOpaque(true);
		this.setBackground(colore);
		if (colore != grigio) {
			hasColor = true;
		}
	}

	/**
	 * @return the preso
	 */
	public ExtJLabel() {
		this.color = grigio;
	}

	/**
	 * @return the lblPreso
	 */
	public boolean isLblPreso() {
		return lblPreso;
	}

	/**
	 * @param lblPreso
	 *            the lblPreso to set
	 */
	public void setLblPreso(boolean lblPreso) {
		if (lblPreso) {
			this.lblPreso = lblPreso;
			this.color = rosso;
			this.setOpaque(true);
			this.setBackground(color);
			hasColor = lblPreso;
		} else {
			this.lblPreso = lblPreso;
			this.color = grigio;
			this.setOpaque(true);
			this.setBackground(color);
			hasColor = lblPreso;
		}

	}

	/**
	 * @return the lblMorto
	 */
	public boolean isLblMorto() {
		return lblMorto;
	}

	/**
	 * @param lblMorto
	 *            the lblMorto to set
	 */
	public void setLblMorto(boolean lblMorto) {
		this.lblMorto = lblMorto;
		this.color = blue;
		this.setOpaque(true);
		this.setBackground(color);
		hasColor = true;
	}

}