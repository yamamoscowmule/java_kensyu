import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class SampleFrame09 extends JFrame implements ActionListener
{
  DefaultListModel list_model = new DefaultListModel();
  JList list_view = new JList(this.list_model);
  JButton button = new JButton("これはボタンです。");

  public SampleFrame09()
  {
    this.setTitle("Sample No.9");
    this.setSize(800, 400);

    JScrollPane scroll = new JScrollPane(this.list_view);

    this.setLayout(new BorderLayout());
    this.add(scroll, BorderLayout.CENTER);
    this.add(button, BorderLayout.SOUTH);

    this.button.addActionListener(this); // アクションリスナーをボタンに登録する。
  }

  public void actionPerformed(ActionEvent e)
  {
    this.list_model.addElement("追加されたリスト項目 " + new Date());
  }
}


