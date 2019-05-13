import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SampleFrame05 extends JFrame
{
  JTextArea text_area = new JTextArea();
  JButton button = new JButton("これはボタンです。");

  public SampleFrame05()
  {
    this.setTitle("Sample No.5");
    this.setSize(800, 400);

    this.setLayout(new BorderLayout());
    this.add(this.text_area, BorderLayout.CENTER);
    this.add(button, BorderLayout.SOUTH);

    this.button.addActionListener(new MyActionListener()); // アクションリスナーをボタンに登録する。
  }

  public class MyActionListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String text = text_area.getText();
      text = text + "ボタンが押されました。\n";
      text_area.setText(text);
    }
  }
}