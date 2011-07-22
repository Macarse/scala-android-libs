package net.virtualvoid.android.scalainstaller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ScalaInstallerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScalaInstaller installer = new ScalaInstaller(getApplicationContext());
        installer.installScalaLibs();

        TextView text = new TextView(this);
        text.setText("Everything worked well");
        setContentView(text);
    }
}

