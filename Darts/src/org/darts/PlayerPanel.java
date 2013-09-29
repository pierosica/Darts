package org.darts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({ "serial", "unused" })
public class PlayerPanel extends JPanel {

	private JPanel contentPane;
	public JTextField txtName;
	private static int NumeroRighe = 21;
	private CompositeRow riga;
	public JLabel lblPunteggioPlayer;
	public int IDpannello;

	public CompositeRow[] rowArray = new CompositeRow[NumeroRighe];

	Border borderTxtName = new EtchedBorder(EtchedBorder.LOWERED, null, null);

	/**
	 * Create the panel.
	 */
	public PlayerPanel(int id) {
		// setAlignmentY(0.0f);
		// setAlignmentX(0.0f);
		// setBounds(new Rectangle(0, 0, 150, 485));
		// this.setLayout(null);

		this.IDpannello = id;

		JPanel pnlPlayer = new JPanel();
		pnlPlayer.setBounds(0, 0, 190, 480);
		// pnlPlayer.setBackground(Color.GRAY);
		pnlPlayer.setBorder(borderTxtName);
		pnlPlayer.setLayout(null);
		add(pnlPlayer);

		// Player TextName
		txtName = new JTextField();
		txtName.setBounds(5, 12, 180, 34);
		txtName.setToolTipText("Nome del primo giocatore");
		txtName.setColumns(10);
		txtName.setText("Unknown name");
		txtName.setBorder(borderTxtName);
		pnlPlayer.add(txtName);

		// Player lblPunteggio
		lblPunteggioPlayer = new JLabel("0");
		lblPunteggioPlayer.setBounds(5, 42, 180, 34);
		lblPunteggioPlayer.setBorder(borderTxtName);
		lblPunteggioPlayer.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPunteggioPlayer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPunteggioPlayer.setToolTipText("Punteggio " + txtName.getText());
		pnlPlayer.add(lblPunteggioPlayer);

		int width = 180;
		int height = 30;
		// aggiungo le CompositeRow
		for (int i = 0; i < NumeroRighe; i++) {
			riga = new CompositeRow(this.IDpannello, i);
			riga.setBounds(5, 85 + (height + 5) * i, width, height);
			rowArray[i] = riga;
			pnlPlayer.add(riga);
		}

		// riga1.setBounds(12, 155, 150, 25);

	}

}