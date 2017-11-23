package neer.com.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button1:
                Intent intent = new Intent(this,Login_Activity.class);
                startActivity(intent);
                break;
            case R.id.button2:
            Intent intent1 = new Intent(this,CreateAccount_Activity.class);
                startActivity(intent1);
                break;

        }
    }
}
