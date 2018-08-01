package id.dsc.nurhida10111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    EditText etNama, etHarga;
    Button buttonSave;

    DBhelper DbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        etNama = findViewById(R.id.nama_menu);
        etHarga = findViewById(R.id.harga);
        buttonSave = findViewById(R.id.btn_input1);

        DbHelper = DBhelper.getInstance(getApplicationContext());

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mendeklarasikan class menu
                id.dsc.nurhida10111.Menu menu = new id.dsc.nurhida10111.Menu();

                //mengatur value untuk harga dan nama menu bedasarkan inputan user
                menu.setNama(etNama.getText().toString());
                menu.setHarga(etHarga.getText().toString());

                //proses input ke database
                DbHelper.insertMenu(menu);

                //pindah ke activity home
                Intent intent = new Intent(InsertActivity.this, Duactivity.class);
                startActivity(intent);
            }
        });
    }
}
