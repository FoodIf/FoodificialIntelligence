package MyAndroid;

import android.app.Application;
import android.content.Context;

/**
 * Created by Hannes on 2017-05-12.
 */

public class MyApplication extends Application {
    private static final MyApplication ourInstance = new MyApplication();

    public static MyApplication getInstance() {
        return ourInstance;
    }

    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        this.context=getApplicationContext();
    }

    public static Context getContext() {
        //  return instance.getApplicationContext();
        return context;
    }


    public static void setContext(Context contxt) {
        context = contxt;
    }
}


