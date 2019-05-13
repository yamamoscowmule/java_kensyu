import java.awt.BorderLayout;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

public class SampleFrame11 extends JFrame
{
  private String[] column_names = {"処理", "キー", "値"};

  DefaultTableModel table_model = new DefaultTableModel(column_names , 0);
  JTable table_view = new JTable(this.table_model);

  public SampleFrame11()
  {
    try
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
    
    catch(Exception e)
    {
      e.printStackTrace();
    }
   this.setTitle("Sample No.11");
    this.setSize(800, 400);

    JScrollPane scroll = new JScrollPane(this.table_view);

    this.setLayout(new BorderLayout());
    this.add(scroll, BorderLayout.CENTER);

    // Firebase の「ルート」の監視をするリスナーを生成。
    // スーパークラス(ChildEventListener)の
    // メソッド(onChildAddedなど)を
    // サブクラス(スーパークラスを継承したクラス、今はlistener)において
    // 同じメソッド名で定義(変更したり)

    ChildEventListener listener = new ChildEventListener()
    {
     // @Override
      public void onChildAdded(DataSnapshot snapshot, String name)
      {
        Object data[] = new Object[3];
        data[0] = snapshot.getKey();
        data[1] = snapshot.getValue();
        data[2] = "追加されました。";
        table_model.addRow(data);
      }
//
//      @Override
      public void onChildChanged(DataSnapshot snapshot, String name)
      {
        Object data[] = new Object[3];
        data[0] = snapshot.getKey();
        data[1] = snapshot.getValue();
        data[2] = "変更されました。 name = " + name;
        table_model.addRow(data);
      }
//
//      @Override
      public void onChildMoved(DataSnapshot snapshot, String name)
      {
        Object data[] = new Object[3];
        data[0] = snapshot.getKey();
        data[1] = snapshot.getValue();
        data[2] = "移動されました。name = " + name;
        table_model.addRow(data);
      }
//
//      @Override
      public void onChildRemoved(DataSnapshot snapshot)
      {
        Object data[] = new Object[3];
        data[0] = snapshot.getKey();
        data[1] = snapshot.getValue();
        data[2] = "削除されました。";
        table_model.addRow(data);
      }
//
      public void onCancelled1(DatabaseError error)
      {
        System.out.println("通信がキャンセルされました。");
      }
//
//      @Override
      public void onCancelled(DatabaseError arg0)
      {
      }
    };
//
//    // Firebase の「ルート」の監視を開始。
//
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    reference.child("folder").addChildEventListener(listener);
    reference.child("time").addChildEventListener(listener);
  }
}

