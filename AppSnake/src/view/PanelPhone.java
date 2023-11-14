package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

public class PanelPhone extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelPhone() {
		setBorder(null);
        ImageIcon imageIcon = new ImageIcon(PrincipalView.class.getResource("/img/phone.png"));
        Image originalImage = imageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(250, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        setPreferredSize(new Dimension(250,600));
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{400, 0};
        gridBagLayout.rowHeights = new int[]{600, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
		
        JLabel phone = new JLabel(scaledIcon);
		phone.setBorder(null);
		phone.setHorizontalTextPosition(SwingConstants.CENTER);
		phone.setOpaque(true);
		phone.setBackground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc_phone = new GridBagConstraints();
		gbc_phone.fill = GridBagConstraints.BOTH;
		gbc_phone.gridx = 0;
		gbc_phone.gridy = 0;
		add(phone, gbc_phone);

	}

}