import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SampleFrame02 extends JFrame
{
  public SampleFrame02()
  {
    this.setTitle("Sample No.2");
    this.setSize(800, 400);

    JTextArea area = new JTextArea();
    area.setEditable(false);
    area.setText("あいうえお\nかきくけこ\nさしすせそ");

    this.setLayout(new BorderLayout());
    this.add(area);
  }
}
