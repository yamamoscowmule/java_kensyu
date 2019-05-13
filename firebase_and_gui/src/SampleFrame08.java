import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SampleFrame08 extends JFrame implements ActionListener
{
  JTextArea text_area = new JTextArea();

  JPanel panel = new JPanel();

  JLabel label1 = new JLabel("あいうえお");
  JLabel label2 = new JLabel("かきくけこ");
  JLabel label3 = new JLabel("さしすせそ");
  JLabel label4 = new JLabel("たちつてと");
  JLabel label5 = new JLabel("なにぬねの");

  JButton button = new JButton("これはボタンです。");

  public SampleFrame08()
  {
    this.setTitle("Sample No.8");
    this.setSize(800, 400);

    panel.setLayout(new GridLayout(3, 2));
    panel.add(this.label1);
    panel.add(this.label2);
    panel.add(this.label3);
    panel.add(this.label4);
    panel.add(this.label5);
    panel.add(this.text_area);

    this.add(panel, BorderLayout.CENTER);
    this.add(button, BorderLayout.SOUTH);

    this.button.addActionListener(this); // アクションリスナーをボタンに登録する。
  }

  public void actionPerformed(ActionEvent e)
  {
    String text = text_area.getText();
    text = text + "ボタンが押されました。\n";
    text_area.setText(text);
  }
}
