package id.dsc.nurhida10111;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by athaya on 07/04/18.
 */

public class AdapterRc extends RecyclerView.Adapter<AdapterRc.ViewHolder>{
    Context context;
    //ArrayList<Drawable> img;
    //ArrayList<String> nama;
    //ArrayList<String> harga;

    List<id.dsc.nurhida10111.Menu> menuList=new ArrayList<>();
    DBhelper dbHelper;

    public AdapterRc(Context context, List<id.dsc.nurhida10111.Menu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

     //public AdapterRc(Context context, ArrayList<Drawable> img, ArrayList<String> nama, ArrayList<String> harga) {
     //   this.context = context;
     //   this.img = img;
     //   this.nama = nama;
     //   this.harga = harga;
     //}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdapterRc.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_bakso, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        dbHelper=DBhelper.getInstance(context);

        id.dsc.nurhida10111.Menu menu = (id.dsc.nurhida10111.Menu) menuList.get(position);

        //holder.imView.setBackground(img.get(position));
        //holder.nama.setText(nama.get(position));
        //holder.harga.setText(harga.get(position));

        holder.nama.setText(menu.getNama());
        holder.harga.setText(menu.getHarga());

    }

    @Override
    public int getItemCount() {return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imView;
        TextView nama;
        TextView harga;
        public ViewHolder(View itemView) {
            super(itemView);
            imView = itemView.findViewById(R.id.img);
            nama = itemView.findViewById(R.id.nama);
            harga = itemView.findViewById(R.id.harga);
        }
    }
}
