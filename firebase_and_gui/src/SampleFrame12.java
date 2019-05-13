import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SampleFrame12 extends JFrame implements ActionListener
{
  JTextArea text_area = new JTextArea();
  JButton button = new JButton("これはボタンです。");
  public SampleFrame12() //SampleFrame12クラスのコンストラクタ
  {
    try //try構文の中で例外処理が発生した場合、catch文に飛ぶ
    {
      // 初期化処理（プログラム開始時に一度だけ実行します）。
        String FILE_JSON = "/Users/HY/Downloads/fir-test-e4106-firebase-adminsdk-dk12d-502a62f8e6.json";
        FileInputStream serviceAccount =
      		  new FileInputStream(FILE_JSON);
      		FirebaseOptions options = new FirebaseOptions.Builder()
      		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
      		  .setDatabaseUrl("https://fir-test-e4106.firebaseio.com")
      		  .build();
      		FirebaseApp.initializeApp(options); 
    }
    catch(Exception e) //tryでの例外処理
    {
      e.printStackTrace();
    }
    
    this.setTitle("Sample No.12"); //UIのタイトル
    this.setSize(800, 400); //Windowの大きさ（横、縦）
 
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
