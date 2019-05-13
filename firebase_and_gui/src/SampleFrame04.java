import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SampleFrame04 extends JFrame
{
  JTextArea text_area = new JTextArea();
  JButton button = new JButton("これはボタンです。");

  public SampleFrame04()
  {
    this.setTitle("Sample No.4");
    this.setSize(800, 400);

    this.setLayout(new BorderLayout());
    this.add(text_area, BorderLayout.CENTER);
    this.add(button, BorderLayout.SOUTH);
  }
}
