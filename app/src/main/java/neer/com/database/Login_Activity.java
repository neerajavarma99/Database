package neer.com.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity
{
    EditText id, password;
    MyDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        id = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);
        db = new MyDataBase(this);

    }

    public void OnButtonPressed(View view)

    {
        if (id.getText() == null || password.getText() == null)
        {
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        }
        else
            {
            String s = db.getData(id.getText().toString());
            if (s != null)
            {
                if (s.equals(password.getText().toString()))
                {
                    Intent home = new Intent(this, HomePage_Activity.class );
                    home.putExtra("name",id.getText().toString());
                    startActivity(home);
                }
                else
                    {
                    Toast.makeText(this, "Wrong password!", Toast.LENGTH_SHORT).show();
                    }
            }
            else
                {
                Toast.makeText(this, "Wrong user name!", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
