package net.virtualvoid.android.scalainstaller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

public class ScalaInstallerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String res = getApplicationContext().getFilesDir().getParent().toString();
        TextView text = new TextView(this);
        text.setText("Result: "+res);
        setContentView(text);
    }
}

