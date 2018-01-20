package com.convertor;

import javax.swing.JOptionPane;

public class ConvertorMain implements IGetFilePath {

	String selectedFilePath;
	SwingUI swingUI;

	public static void main(String[] args) {

		ConvertorMain main = new ConvertorMain();
		main.showUi();
	}	

	@Override
	public void getSelectedFilePath(String selectedFilePath) {

		try {
			this.selectedFilePath = selectedFilePath;
			System.out.println("File Path is " + selectedFilePath);

			swingUI.disableConvertButton();

			ReadXlsFile readFile = new ReadXlsFile(selectedFilePath,this);
			readFile.readValueAndGenerateImage();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(swingUI.main_frame, "Exception Occured " + e.getMessage());
		}

	}

	public void showUi() {
		swingUI = new SwingUI(ConvertorMain.this);
		swingUI.showUI();
	}

	public void enableConvertButton() {
		swingUI.enableConvertButton();
	}

}
