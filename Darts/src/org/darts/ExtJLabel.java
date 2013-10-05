package org.darts;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ExtJLabel extends JLabel {

	private Color color;
	private Color rosso = new Color(255, 51, 0);
	private Color blue = new Color (0,0,255);
	private Color grigio = (Color.LIGHT_GRAY);
	private boolean hasColor = false;

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
	
	public void setUnColoured() {
		hasColor = false;

	}

	public ExtJLabel() {
		this.color = grigio;
	}

}