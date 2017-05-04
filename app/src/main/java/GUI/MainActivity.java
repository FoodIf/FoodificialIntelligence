package GUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hannes.foodificialintelligence.R;

/**
 * Created by Hannes on 2017-04-27.
 */

public class MainActivity extends Activity {
    private String activeView;

    public MainActivity(){
        activeView = "Main";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);
        Button openSettings = (Button) findViewById(R.id.goToSettings_Button);
        openSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveView("settings");
                setContentView(R.layout.activity_settings);
            }
        });
    };
    public void setActiveView(String activeView){
        this.activeView = activeView;
    }
    public String getActiveView(){
        return activeView;
    }
}
