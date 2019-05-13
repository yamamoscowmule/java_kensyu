import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SampleFrame03 extends JFrame
{
  public SampleFrame03()
  {
    this.setTitle("Sample No.3");
    this.setSize(800, 400);

    this.setLayout(new BorderLayout());
    this.add(new JTextArea(), BorderLayout.CENTER);
    this.add(new JButton("これはボタンです。"), BorderLayout.SOUTH);
  }
}
