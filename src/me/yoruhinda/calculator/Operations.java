package me.yoruhinda.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Operations implements ActionListener {

	private Calculator calculator;
	private JButton[] nums;
	private JButton[] op;
	private JTextField display;

	private char operations;
	private double memory = 0;
	private double reading = 0;
	private double value = 0;

	public Operations(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		this.nums = calculator.getNums();
		this.op = calculator.getOp();
		this.display = calculator.getDisplay();
		JButton button = (JButton) e.getSource();

		for (int i = 0; i < this.nums.length; i++) {
			if (nums[i] == button) {
				this.reading *= 10;
				this.reading += Double.parseDouble(button.getText());
				this.display.setText(this.display.getText() + button.getText());
			}
		}

		if (op[0] == button) {
			this.memory = this.reading;
			this.reading = 0;
			this.operations = '+';
			this.display.setText(null);
		} else if (op[1] == button) {
			this.memory = this.reading;
			this.reading = 0;
			this.operations = '-';
			this.display.setText(null);
		} else if (op[2] == button) {
			this.memory = this.reading;
			this.reading = 0;
			this.operations = '*';
			this.display.setText(null);
		} else if (op[3] == button) {
			this.memory = this.reading;
			this.reading = 0;
			this.operations = '/';
			this.display.setText(null);
		} else if (op[4] == button && reading != 0 && memory != 0) {
			switch (operations) {
			case '+':
				this.value = memory + reading;
				this.display.setText(Double.toString(value));
				this.operations = '\0';
				break;
			case '-':
				this.value = memory - reading;
				this.display.setText(Double.toString(value));
				break;
			case '*':
				this.value = memory * reading;
				this.display.setText(Double.toString(value));
				this.operations = '\0';
				break;
			case '/':
				this.value = memory / reading;
				this.display.setText(Double.toString(value));
				this.operations = '\0';
				break;
			case '\0':
				this.reading = 0;
				this.memory = 0;
				this.operations = '\0';
				this.display.setText(null);
				break;
			default:
				this.display.setText("INVALID!!!!!!!!!!!!!!!!!!!!!");
			}
		} else if (op[5] == button) {
			this.reading = 0;
			this.memory = 0;
			this.operations = '\0';
			this.display.setText(null);
		}
	}

}
