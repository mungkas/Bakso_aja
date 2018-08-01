package id.dsc.nurhida10111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Duactivity extends AppCompatActivity {
    RecyclerView rc;
    //ArrayList<Drawable> img=new ArrayList<>();
    //ArrayList<String> nama=new ArrayList<>();
    //ArrayList<String> harga=new ArrayList<>();
    Button pilih1;

    private DBhelper dBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duactivity);
        rc=findViewById(R.id.rC);
        pilih1=findViewById(R.id.btnTmbh);

        dBhelper=DBhelper.getInstance(getApplicationContext());

        pilih1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Duactivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });

        //img.add(getResources().getDrawable(R.drawable.bakso));
        //img.add(getResources().getDrawable(R.drawable.teh));
        //img.add(getResources().getDrawable(R.drawable.boraks));

        //nama.add("Bakso Enak");
        //nama.add("Es Teh");
        //nama.add("Bakso Tusuk");

        //harga.add("Rp.12.000");
        //harga.add("Rp.5.000");
        //harga.add("Rp.8.000");

        AdapterRc adapter=new AdapterRc(Duactivity.this, dBhelper.getMenu());
        rc.setLayoutManager(new LinearLayoutManager(Duactivity.this));
        rc.setAdapter(adapter);
    }
}
