import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.*;

public class MyFrame extends JFrame {

	JButton submit;
	JLabel midLabel;
	JLabel finalLabel;
	JLabel totalLabel;
	JLabel totalPoint;
	JLabel gradeLabel;
	JLabel gradePoint;
	JLabel message;
	JTextArea midTextArea;
	JTextArea finalTextArea;
	public String grade(float score){
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
	public void calculate(String mid,String Final)
	{
		float Mid, FinalP, total;
		
		try {
			Mid = Float.parseFloat(mid);
			FinalP = Float.parseFloat(Final);
	
			// Additional validation for negative scores
			if (Mid < 0 || FinalP < 0) {
				totalPoint.setText("");
				gradePoint.setText("");
				message.setText("Scores cannot be negative.\nTry again.");
				return;
			}
	
			total = Mid + FinalP;
			totalPoint.setText(String.valueOf(total));
			gradePoint.setText(grade(total));
			message.setText("");
	
		} catch (NumberFormatException e) {
			totalPoint.setText("");
			gradePoint.setText("");
			message.setText("Enter valid numeric scores.\nTry again.");
		}
	}

	MyFrame(String title){
		
		midLabel = new JLabel("Mid point : ");
		midLabel.setBounds(10,10,100,50);
		
		midTextArea = new JTextArea();
		midTextArea.setBounds(100, 25, 100, 20);

		finalLabel = new JLabel("final point : ");
		finalLabel.setBounds(10,50,100,50);
		
		finalTextArea = new JTextArea();
		finalTextArea.setBounds(100, 65, 100, 20);

		totalLabel = new JLabel("Total : ");
		totalLabel.setBounds(10, 150, 80, 50);

		totalPoint = new JLabel();
		totalPoint.setBounds(100, 150, 100, 50);

		gradeLabel = new JLabel("grade : ");
		gradeLabel.setBounds(10, 200, 100, 50);

		gradePoint = new JLabel();
		gradePoint.setBounds(100, 200, 100, 50);

		message = new JLabel();
		message.setBounds(50,240,300,40);

		submit = new JButton("Calculate");
		submit.setBounds(100, 100, 100, 50);
		submit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				String midInput, finalInput;

				midInput = midTextArea.getText();
				finalInput = finalTextArea.getText();
				calculate(midInput,finalInput);
				
            }
		});

		this.add(midTextArea);
		this.add(midLabel);
		this.add(finalLabel);
		this.add(finalTextArea);
		this.add(totalLabel);
		this.add(totalPoint);
		this.add(gradeLabel);
		this.add(gradePoint);
		this.add(submit);
		this.add(message);

		this.setTitle(title);
		this.setSize(500, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}