package neer.com.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomePage_Activity extends AppCompatActivity {
         TextView name;
    MyDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_);
        name = (TextView) findViewById(R.id.name);
        String s = getIntent().getStringExtra("name");
        db = new MyDataBase(this);
        String fname = db.getName(s);
        if (fname!=null){
            name.setText("Hello "+fname);
        }
    }
}
