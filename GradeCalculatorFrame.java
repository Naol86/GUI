import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.*;

public class GradeCalculatorFrame extends JFrame {

	JButton submitButton;
	JLabel midLabel;
	JLabel finalLabel;
	JLabel totalLabel;
	JLabel totalPointLabel;
	JLabel gradeLabel;
	JLabel gradePointLabel;
	JLabel messageLabel;
	JTextArea midTextArea;
	JTextArea finalTextArea;

	public String getGrade(float score) {
		if (score >= 90) {
			return "A+";
		} else if (score >= 85) {
			return "A";
		} else if (score >= 80) {
			return "A-";
		} else if (score >= 75) {
			return "B+";
		} else if (score >= 70) {
			return "B";
		} else if (score >= 65) {
			return "B-";
		} else if (score >= 60) {
			return "C+";
		} else if (score >= 50) {
			return "C";
		} else if (score >= 45) {
			return "C-";
		} else if (score >= 40) {
			return "D";
		} else {
			return "F";
		}
	}

	public void calculateGrade(String midScore, String finalScore) {
		float mid, finalExam, total;

		try {
			mid = Float.parseFloat(midScore);
			finalExam = Float.parseFloat(finalScore);

			// Additional validation for negative scores
			if (mid < 0 || finalExam < 0) {
				totalPointLabel.setText("");
				gradePointLabel.setText("");
				messageLabel.setText("Scores cannot be negative.\nTry again.");
				return;
			}

			total = mid + finalExam;
			totalPointLabel.setText(String.valueOf(total));
			gradePointLabel.setText(getGrade(total));
			messageLabel.setText("");

		} catch (NumberFormatException e) {
			totalPointLabel.setText("");
			gradePointLabel.setText("");
			messageLabel.setText("Enter valid numeric scores.\nTry again.");
		}
	}

	GradeCalculatorFrame(String title) {

		midLabel = new JLabel("Mid point : ");
		midLabel.setBounds(10, 10, 100, 50);

		midTextArea = new JTextArea();
		midTextArea.setBounds(100, 25, 100, 20);

		finalLabel = new JLabel("Final point : ");
		finalLabel.setBounds(10, 50, 100, 50);

		finalTextArea = new JTextArea();
		finalTextArea.setBounds(100, 65, 100, 20);

		totalLabel = new JLabel("Total : ");
		totalLabel.setBounds(10, 150, 80, 50);

		totalPointLabel = new JLabel();
		totalPointLabel.setBounds(100, 150, 100, 50);

		gradeLabel = new JLabel("Grade : ");
		gradeLabel.setBounds(10, 200, 100, 50);

		gradePointLabel = new JLabel();
		gradePointLabel.setBounds(100, 200, 100, 50);

		messageLabel = new JLabel();
		messageLabel.setBounds(50, 240, 300, 40);

		submitButton = new JButton("Calculate");
		submitButton.setBounds(100, 100, 100, 50);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String midInput, finalInput;

				midInput = midTextArea.getText();
				finalInput = finalTextArea.getText();
				calculateGrade(midInput, finalInput);

			}
		});

		this.add(midTextArea);
		this.add(midLabel);
		this.add(finalLabel);
		this.add(finalTextArea);
		this.add(totalLabel);
		this.add(totalPointLabel);
		this.add(gradeLabel);
		this.add(gradePointLabel);
		this.add(submitButton);
		this.add(messageLabel);

		this.setTitle(title);
		this.setSize(500, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
