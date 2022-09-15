//Autor YoruHinda
//Calculadora java swing

package me.yoruhinda.calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private static final int WIDTH = 420, HEIGHT = 460;
	private JButton[] nums = new JButton[12];
	private JButton[] op = new JButton[6];
	private JPanel panel;
	private JPanel panel_nu;
	private JPanel panel_op;
	private JTextField display;
	private Operations operations = new Operations(this);

	public Calculator() {
		this.calculatorFrame();
	}

	public void calculatorFrame() {
		this.setTitle("Calculator");
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.initComponents();

		this.setVisible(true);

	}

	private void initComponents() {
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());

		this.panel_nu = new JPanel();
		this.panel_nu.setLayout(new GridLayout(4, 3));

		this.panel_op = new JPanel();
		this.panel_op.setLayout(new GridLayout(3, 2));
		this.panel_op.setPreferredSize(new Dimension(150, 220));

		this.display = new JTextField();
		this.display.setColumns(15);
		this.display.setFont(new Font("SansSerif", Font.BOLD, 20));
		this.display.setHorizontalAlignment(JTextField.RIGHT);
		this.display.setEditable(false);
		this.display.setOpaque(false);

		int value_nu = 0;
		int value_op = 0;

		for (int i = 0; i < this.nums.length; i++) {
			this.nums[i] = new JButton();
			this.nums[i].setText(Integer.toString(value_nu += 1));
			this.nums[i].setFocusable(false);
			if (value_nu == 10) {
				this.nums[i].setText(null);
				this.nums[i].setEnabled(false);
			} else if (value_nu == 11) {
				this.nums[i].setText(Integer.toString(value_nu -= 11));
				value_nu = 11;
			} else if (value_nu == 12) {
				this.nums[i].setText(null);
				this.nums[i].setEnabled(false);
			}
			this.panel_nu.add(this.nums[i]);
			this.nums[i].addActionListener(this.operations);
		}

		for (int i = 0; i < this.op.length; i++) {
			this.op[i] = new JButton();
			this.op[i].setFocusable(false);
			if (value_op == 0) {
				this.op[i].setText("+");
				value_op += 1;
			} else if (value_op == 1) {
				this.op[i].setText("-");
				value_op += 1;
			} else if (value_op == 2) {
				this.op[i].setText("*");
				value_op += 1;
			} else if (value_op == 3) {
				this.op[i].setText("/");
				value_op += 1;
			} else if (value_op == 4) {
				this.op[i].setText("=");
				value_op += 1;
			} else {
				this.op[i].setText("C");
			}
			this.panel_op.add(this.op[i]);
			this.op[i].addActionListener(this.operations);
		}

		this.panel.add(display);

		this.add(panel, BorderLayout.NORTH);
		this.add(panel_op, BorderLayout.EAST);
		this.add(panel_nu, BorderLayout.CENTER);

	}

	public JTextField getDisplay() {
		return display;
	}

	public void setDisplay(JTextField display) {
		this.display = display;
	}

	public JButton[] getNums() {
		return nums;
	}

	public void setNums(JButton[] nums) {
		this.nums = nums;
	}

	public JButton[] getOp() {
		return op;
	}

	public void setOp(JButton[] op) {
		this.op = op;
	}
}
