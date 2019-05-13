import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SampleFrame07 extends JFrame implements ActionListener
{
  JTextArea text_area = new JTextArea();
  JButton button = new JButton("これはボタンです。");

  public SampleFrame07()
  {
    this.setTitle("Sample No.7");
    this.setSize(800, 400);

    JScrollPane scroll = new JScrollPane(this.text_area);

    this.setLayout(new BorderLayout());
    this.add(scroll, BorderLayout.CENTER);
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