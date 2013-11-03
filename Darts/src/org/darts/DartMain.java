package org.darts;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DartMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JPanel contentPanePlayer;
	private static PlayerPanel[] panelArray;
	private static boolean[] mortoArray;
	private static IntestazionePanel intestazionepanel;
	public static Giocatore[] giocatoriArray;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DartMain frame = new DartMain();
					frame.setLocationRelativeTo(null);
					//frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void incrementa(int pannello, int riga) {
		boolean morto = true;
		int numeroGiocatori = intestazionepanel.getSelectedVal();
		int delta=1;
		if(riga==20){
			delta = 5;
		}

		for (int i = 0; i < numeroGiocatori; i++) {
			if (i != pannello) {
				PlayerPanel otherpanel = panelArray[i];
				CompositeRow otherrow = otherpanel.rowArray[riga];
				morto = morto & otherrow.pnlChiuso;
				if (!otherrow.pnlChiuso) {
					int totale = Integer.parseInt(otherpanel.lblPunteggioPlayer
							.getText().toString()) + riga + delta;
					otherpanel.lblPunteggioPlayer.setText("" + totale);
				}
			}
		}
		if (morto) {
			PlayerPanel mypanel = panelArray[pannello];

			int totale = Integer.parseInt(mypanel.lblPunteggioPlayer.getText()
					.toString()) + riga + delta;
			mypanel.lblPunteggioPlayer.setText("" + totale);

		}
	}

	public static void cambiaColoreChiuso(int pannello, int riga) {
		// se il btnAnnullaNumero e' premuto
		// quando un numero è morto, fa tornare tutto rosso
		// ..ci sara' poi un ulteriore controllo al click
		// del btnAnnullaNumero che si occupa delle labels
		int numeroGiocatori = intestazionepanel.getSelectedVal();
		mortoArray[riga] = false;

		for (int i = 0; i < numeroGiocatori; i++) {
			PlayerPanel otherpanel = panelArray[i];
			CompositeRow otherrow = otherpanel.rowArray[riga];
			ExtJLabel lblNumeroA = otherrow.lblNumeroA;
			ExtJLabel lblNumeroB = otherrow.lblNumeroB;
			ExtJLabel lblNumeroC = otherrow.lblNumeroC;
			if (lblNumeroA.isLblPreso()) {
				lblNumeroA.setLblPreso(true);
			}
			if (lblNumeroB.isLblPreso()) {
				lblNumeroB.setLblPreso(true);
			}
			if (lblNumeroC.isLblPreso()) {
				lblNumeroC.setLblPreso(true);
			}
		}
	}

	public static void cambiaColoreMorto(int pannello, int riga) {

		mortoArray[riga] = true;

		int numeroGiocatori = intestazionepanel.getSelectedVal();
		for (int i = 0; i < numeroGiocatori; i++) {
			PlayerPanel otherpanel = panelArray[i];
			CompositeRow otherrow = otherpanel.rowArray[riga];

			ExtJLabel lblNumeroA = otherrow.lblNumeroA;
			lblNumeroA.setLblMorto(true);
			ExtJLabel lblNumeroB = otherrow.lblNumeroB;
			lblNumeroB.setLblMorto(true);
			ExtJLabel lblNumeroC = otherrow.lblNumeroC;
			lblNumeroC.setLblMorto(true);
		}
	}

	public static boolean isNumeroMorto(int riga) {
		int numeroGiocatori = intestazionepanel.getSelectedVal();
		boolean morto = true;
		for (int i = 0; i < numeroGiocatori; i++) {

			PlayerPanel otherpanel = panelArray[i];
			CompositeRow otherrow = otherpanel.rowArray[riga];
			morto = morto & otherrow.pnlChiuso;

		}
		return morto;
	}

	/*
	 *  TODO
	 */
	public static void vincitore (){
		int numeroGiocatori = intestazionepanel.getSelectedVal();
		for (int i = 0; i < numeroGiocatori; i++) {
//			if (i != pannello) {
//				PlayerPanel otherpanel = panelArray[i];
//				CompositeRow otherrow = otherpanel.rowArray[riga];
//				morto = morto & otherrow.pnlChiuso;
//				if (!otherrow.pnlChiuso) {
//					int totale = Integer.parseInt(otherpanel.lblPunteggioPlayer
//							.getText().toString()) + riga + delta;
//					otherpanel.lblPunteggioPlayer.setText("" + totale);
//				}
//
//			}
		}
	}

	public static void buildIt(int giocatori) {
		contentPanePlayer.removeAll();
		contentPanePlayer.repaint();
		panelArray = new PlayerPanel[giocatori];
		mortoArray = new boolean[21];
		int width = 190;
		int height = 550;
		PlayerPanel pnlPlayer;
		for (int i = 0; i < giocatori; i++) {
			pnlPlayer = new PlayerPanel(i);
			pnlPlayer.setBounds((width + 5) * i, 5, width, height);
			pnlPlayer.setLayout(null);
//			if (giocatoriArray[i]!=null) {
//				if (giocatoriArray[i].getNome()!="") {
//					giocatoriArray[i]=giocatoriArray[i];	
//					pnlPlayer.txtName.setText(giocatoriArray[i].getNome());
//				}
//				
//				
//			} else {
//				giocatoriArray[i]=new Giocatore("");
//			}
			
			panelArray[i] = pnlPlayer;
			//contentPanePlayer.setBackground(new Color(255,0,0));
			contentPanePlayer.add(pnlPlayer);
		}
	}

	/**
	 * Create the frame.
	 */
	public DartMain() {
		setResizable(false);

		// imposto la window del programma
		setTitle("Darts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(300, 300, 800, 600);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int larghezzaMonitor = gd.getDisplayMode().getWidth();
		int altezzaMonitor = gd.getDisplayMode().getHeight();
//		Dimension screen = getToolkit().getScreenSize();
//		int larghezzaMonitor = screen.width;
//		int altezzaMonitor = screen.height;
		int larghezzaFrame = 800;
		int altezzaFrame = 600;
		int posX=(larghezzaMonitor - larghezzaFrame)/2;
		int posY=(altezzaMonitor - altezzaFrame)/2;
		setBounds(posX, posY, larghezzaFrame, altezzaFrame);

		// creo il contentPane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// aggancio il panel della intestazione
		intestazionepanel = new IntestazionePanel();
		intestazionepanel.setBounds(124, 0, 550, 47);
		contentPane.add(intestazionepanel);
		int numeroGiocatori = intestazionepanel.getSelectedVal();
		giocatoriArray= new Giocatore[numeroGiocatori];

		contentPanePlayer = new JPanel();
		contentPanePlayer.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanePlayer.setBounds(12, 50, 800, 560);
		contentPanePlayer.setLayout(null);
		contentPane.add(contentPanePlayer);

		buildIt(numeroGiocatori);

	}

}