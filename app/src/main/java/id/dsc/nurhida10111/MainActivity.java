package id.dsc.nurhida10111;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textNama;
    private EditText textPass;
    Button buttonLogin;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNama=findViewById(R.id.ed1);
        textPass=findViewById(R.id.ed2);
        buttonLogin=findViewById(R.id.btn);

        preferences=getSharedPreferences("bakso", MODE_PRIVATE);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Overridex
            public void onClick(View view) {
                if(!textNama.getText().toString().isEmpty() && !textPass.getText().toString().isEmpty()){
                    if(textNama.getText().toString().equals("mungkas") && textPass.getText().toString().equals("cobaaja123")){

                        SharedPreferences.Editor editor=preferences.edit();
                        editor.putString("Login", "ya");
                        editor.commit();

                        Intent pindahKlas=new Intent(MainActivity.this, Duactivity.class);
                        startActivity(pindahKlas);

                    }else{
                        Toast.makeText(MainActivity.this, "Nama dan Password anda salah",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this, "Field ada yang kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
