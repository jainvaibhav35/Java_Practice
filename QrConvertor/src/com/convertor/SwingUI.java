package com.convertor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class SwingUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame main_frame;
	JLabel welcome_label, select_label, processing_label;
	JButton browse_button, convert_button;
	JTextField file_path_textField;
	JFileChooser choose_file;
	String Selected_file_path = null;
	File list_of_files;
	ArrayList<File> file_list;
	int no_of_files = 0;
	String movie_name;
	Image img;

	IGetFilePath filePath;

	SwingUI(IGetFilePath filePath) {
		this.filePath = filePath;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == browse_button) {

			file_path_textField.setText("");

			choose_file = new JFileChooser("Select File or Directory");
			choose_file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			choose_file.showDialog(SwingUI.this, "Select");
			Selected_file_path = choose_file.getSelectedFile().getPath();
			file_path_textField.setText(Selected_file_path);

			String extension = Selected_file_path.substring(Selected_file_path.lastIndexOf(".") + 1);
			if (!(extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx"))) {
				JOptionPane.showMessageDialog(main_frame, "Please choose xls file only.");
				file_path_textField.setText("");
			}
		}

		if (e.getSource() == convert_button) {
			String extension = Selected_file_path.substring(Selected_file_path.lastIndexOf(".") + 1);
			if (!(extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx"))) {
				JOptionPane.showMessageDialog(main_frame, "Please choose xls file only.");
				file_path_textField.setText("");
			} else {
				filePath.getSelectedFilePath(Selected_file_path);
			}
		}

	}

	public String getSelectFilePath() {
		return Selected_file_path;
	}

	public void showUI() {
		// Making Objects of all Components
		main_frame = new JFrame("QR Converor");
		welcome_label = new JLabel("Welcome to QR Convertor", JLabel.CENTER);
		select_label = new JLabel("Select xls File : ");
		processing_label = new JLabel();
		browse_button = new JButton("Browse");
		file_path_textField = new JTextField();
		convert_button = new JButton("Convert");

		// Setting welcome_label
		welcome_label.setBounds(0, 0, 1366, 100);
		welcome_label.setForeground(Color.DARK_GRAY);
		welcome_label.setFont(new Font("Serif", Font.ITALIC, 50));

		// Setting select_label
		select_label.setBounds(100, 120, 250, 50);
		select_label.setForeground(Color.BLUE);
		select_label.setFont(new Font("Serif", Font.ITALIC, 30));

		// Setting directory_name_field
		file_path_textField.setBounds(350, 135, 500, 30);
		file_path_textField.setForeground(Color.BLACK);
		file_path_textField.setFont(new Font("Serif", Font.ITALIC, 25));
		file_path_textField.setEnabled(true);

		// Setting browse_button
		browse_button.setBounds(900, 135, 150, 30);
		browse_button.setForeground(Color.DARK_GRAY);
		browse_button.setFont(new Font("Serif", Font.ITALIC, 25));

		// Setting fetch_info_button
		convert_button.setBounds(500, 200, 150, 30);
		convert_button.setForeground(Color.DARK_GRAY);
		convert_button.setHorizontalAlignment(SwingConstants.CENTER);
		convert_button.setVerticalAlignment(SwingConstants.CENTER);
		convert_button.setFont(new Font("Serif", Font.ITALIC, 25));

		convert_button.setEnabled(true);

		processing_label.setBounds(400, 300, 500, 30);
		processing_label.setForeground(Color.DARK_GRAY);
		processing_label.setFont(new Font("Serif", Font.ITALIC, 25));
//		processing_label.setText("Processing your request...");

//		processing_label.setVisible(false);
		// Adding Components to main_frame

		main_frame.add(welcome_label);
		main_frame.add(select_label);
		main_frame.add(browse_button);
		main_frame.add(file_path_textField);
		main_frame.add(convert_button);
		main_frame.add(processing_label);

		// Attaching with action_listner
		browse_button.addActionListener(this);
		convert_button.addActionListener(this);

		// Setting main_frame
		main_frame.setSize(1366, 768);
		main_frame.setLayout(null);
		main_frame.setVisible(true);
	}

	public void disableConvertButton() {
		processing_label.setText("Processing your request...");
		processing_label.paintImmediately(processing_label.getVisibleRect());
		convert_button.setEnabled(false);
	}

	public void enableConvertButton() {
		convert_button.setEnabled(true);
		processing_label.setText("QR Code successfully generated...");
	}

}