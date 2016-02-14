package sk.zatko.knights_tour.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;

/*
 * Swing JFrame window for results
 */
public class ResultUserInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2527020879452731524L;

	private JPanel contentPane;

	private JTextArea textArea;


	/**
	 * Create the frame.
	 */
	public ResultUserInterface() {
		
		setTitle("Result");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(560, 100, 560, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.GRAY));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setTabSize(3);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}


	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}
