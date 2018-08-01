package id.dsc.nurhida10111;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by athaya on 14/04/18.
 */

public class SharePrefence {
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor edit;

    public SharePrefence(Context context){
        this.sharedPreferences=context.getSharedPreferences("bakso", Context.MODE_PRIVATE);
        this.edit=edit;
    }
    public String getLogin(){
        return sharedPreferences.getString("Login", "tidak");
    }
}
