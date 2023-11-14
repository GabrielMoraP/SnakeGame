package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PrincipalView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalView() {
		setUndecorated(true);
		setPreferredSize(new Dimension(250, 630));
		setBackground(new Color(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("SNAKE GAME");

		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 250, 0 };
		gbl_contentPane.rowHeights = new int[] { 30, 600, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 10.0, 90.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panelButtons = new JPanel();
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.insets = new Insets(0, 0, 0, 0);
		gbc_panelButtons.fill = GridBagConstraints.VERTICAL;
		gbc_panelButtons.gridx = 0;
		gbc_panelButtons.gridy = 0;
		contentPane.add(panelButtons, gbc_panelButtons);
		GridBagLayout gbl_panelButtons = new GridBagLayout();
		gbl_panelButtons.columnWidths = new int[]{89, 0};
		gbl_panelButtons.rowHeights = new int[]{23, 0};
		gbl_panelButtons.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelButtons.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelButtons.setLayout(gbl_panelButtons);
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(234, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Cascadia Code", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panelButtons.add(btnNewButton, gbc_btnNewButton);

		JPanel panelContent = new JPanel();
		panelContent.setFocusable(true);
		panelContent.setBorder(null);
		GridBagConstraints gbc_panelContent = new GridBagConstraints();
		gbc_panelContent.fill = GridBagConstraints.BOTH;
		gbc_panelContent.gridx = 0;
		gbc_panelContent.gridy = 1;
		contentPane.add(panelContent, gbc_panelContent);
		panelContent.setLayout(null);

		PanelPhone panelPhone = new PanelPhone();
		panelPhone.setBounds(0, 0, 250, 600);
		panelContent.add(panelPhone);
		
		GameView panelGame = new GameView();
		panelGame.setBounds(30, 77, 190, 260);
		panelContent.add(panelGame);

		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		panelGame.requestFocusInWindow();
	}
}
