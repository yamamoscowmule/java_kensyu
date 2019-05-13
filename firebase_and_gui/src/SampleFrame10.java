import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SampleFrame10 extends JFrame implements ActionListener
{
  private String[] column_names = {"A", "B", "C", "D", "E"};

  DefaultTableModel table_model = new DefaultTableModel(column_names , 0);
  JTable table_view = new JTable(this.table_model);
  JButton button = new JButton("これはボタンです。");

  int current_row = 0;
  int current_column = 0;

  public SampleFrame10()
  {
    this.setTitle("Sample No.10");
    this.setSize(800, 400);

    JScrollPane scroll = new JScrollPane(this.table_view);

    this.setLayout(new BorderLayout());
    this.add(scroll, BorderLayout.CENTER);
    this.add(this.button, BorderLayout.SOUTH);

    this.button.addActionListener(this); // アクションリスナーをボタンに登録する。
  }

  public void actionPerformed(ActionEvent e)
  {
    if(this.table_model.getRowCount()<=this.current_row)
    {
      this.table_model.addRow(new String[column_names.length]);
    }

    this.table_model.setValueAt(this.current_row + "行目 " + this.current_column + "カラム目 ", this.current_row, this.current_column);

    this.current_column++;

    if(column_names.length<=this.current_column)
    {
      this.current_column = 0;
      this.current_row++;
    }
  }
}

