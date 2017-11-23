package neer.com.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount_Activity extends AppCompatActivity {
    EditText name, usi,pass;
    MyDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_);
        name = (EditText) findViewById(R.id.full_name);
        usi = (EditText) findViewById(R.id.email_address);
        pass = (EditText) findViewById(R.id.password);
        db= new MyDataBase(this);
    }

    public void onSignUpClick(View view) {
        if (name.getText()==null || usi.getText()==null || pass.getText()==null){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }else {
          db.addData(usi.getText().toString(),pass.getText().toString(),name.getText().toString());
            Intent home = new Intent(this, HomePage_Activity.class );
            home.putExtra("name",usi.getText().toString());
            startActivity(home);
        }
    }
}
