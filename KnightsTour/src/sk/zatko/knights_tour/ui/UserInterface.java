package sk.zatko.knights_tour.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JProgressBar;

import java.awt.Component;

import javax.swing.SpinnerNumberModel;

import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * Swing JFrame window for application gui
 */
public class UserInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3890266776077539455L;

	private JPanel contentPane;
	
	private final JComboBox<String> boardSizeComboBox;
	
	private final JSpinner xStartPositionSpinner;
	private final JSpinner yStartPositionSpinner;
	
	private final JTextField timeLimitTextField;
	
	private final JButton btnStartStop;
	private final JButton btnReset;
	
	private final JProgressBar progressBar;
	
	
	/**
	 * Create the frame.
	 */
	public UserInterface() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logo.png"));
		setTitle("Knight's Tour solver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.GRAY));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("images\\title.png"));
		logoLabel.setBounds(10, 10, 996, 200);
		contentPane.add(logoLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(10, 220, 996, 409);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblBoardSize = new JLabel("Chess board size");
		lblBoardSize.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBoardSize.setBounds(10, 10, 160, 40);
		panel.add(lblBoardSize);
		
		boardSizeComboBox = new JComboBox<String>();
		boardSizeComboBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		boardSizeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boardSizeComboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
		boardSizeComboBox.setMaximumRowCount(16);
		boardSizeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"5 x 5", "6 x 6", "7 x 7", "8 x 8", "9 x 9", "10 x 10", "11 x 11", "12 x 12", "13 x 13", "14 x 14", "15 x 15", "16 x 16", "17 x 17", "18 x 18", "19 x 19", "20 x 20"}));
		boardSizeComboBox.setBounds(330, 10, 130, 40);
		panel.add(boardSizeComboBox);
		
		JLabel lblStartPosition = new JLabel("Start position");
		lblStartPosition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStartPosition.setBounds(10, 70, 160, 40);
		panel.add(lblStartPosition);
		
		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblX.setBounds(330, 80, 20, 40);
		panel.add(lblX);
		
		xStartPositionSpinner = new JSpinner();
		xStartPositionSpinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		xStartPositionSpinner.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		xStartPositionSpinner.setBounds(350, 80, 110, 40);
		panel.add(xStartPositionSpinner);
		
		JLabel lblY = new JLabel("y");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblY.setBounds(330, 130, 20, 40);
		panel.add(lblY);
		
		yStartPositionSpinner = new JSpinner();
		yStartPositionSpinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yStartPositionSpinner.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		yStartPositionSpinner.setBounds(350, 130, 110, 40);
		panel.add(yStartPositionSpinner);
		
		JLabel lblTimeLimit = new JLabel("Time limit");
		lblTimeLimit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimeLimit.setBounds(10, 200, 160, 30);
		panel.add(lblTimeLimit);
		
		timeLimitTextField = new JTextField();
		timeLimitTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		timeLimitTextField.setText("60000");
		timeLimitTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		timeLimitTextField.setBounds(330, 200, 80, 40);
		timeLimitTextField.setColumns(10);
		panel.add(timeLimitTextField);
		
		JLabel lblSec = new JLabel("msec");
		lblSec.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSec.setBounds(414, 200, 46, 40);
		panel.add(lblSec);
		
		btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setActionCommand("");

		btnReset.setBounds(10, 356, 200, 40);
		panel.add(btnReset);
		
		btnStartStop = new JButton("START");
		btnStartStop.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnStartStop.setBounds(222, 356, 238, 40);
		panel.add(btnStartStop);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\board.png"));
		lblNewLabel.setBounds(586, 1, 407, 407);
		panel.add(lblNewLabel);

		progressBar = new JProgressBar();
		progressBar.setString("Solving ...");
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		progressBar.setRequestFocusEnabled(false);
		progressBar.setOpaque(true);
		progressBar.setBounds(10, 642, 996, 30);
		contentPane.add(progressBar);
	}
	
	public JSpinner getXStartPositionSpinner() {
		return xStartPositionSpinner;
	}

	public JSpinner getYStartPositionSpinner() {
		return yStartPositionSpinner;
	}

	public JComboBox<String> getBoardSizeComboBox() {
		return boardSizeComboBox;
	}

	public JButton getBtnStartStop() {
		return btnStartStop;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JTextField getTimeLimitTextField() {
		return timeLimitTextField;
	}
}
