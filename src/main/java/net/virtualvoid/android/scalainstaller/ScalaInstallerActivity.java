package net.virtualvoid.android.scalainstaller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScalaInstallerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        final TextView text = (TextView) findViewById(R.id.text);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                ScalaInstaller installer = new ScalaInstaller(getApplicationContext());
                installer.installScalaLibs();
                button.setEnabled(false);

                text.setTextSize(20);
                text.setText("Finished! Please restart your phone.");
            }
        });
    }
}

