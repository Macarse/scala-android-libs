package net.virtualvoid.android.scalainstaller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScalaInstallerActivity extends Activity implements Runnable {
    ProgressDialog progress;
    TextView text;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        text = (TextView) findViewById(R.id.text);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                progress = ProgressDialog.show(ScalaInstallerActivity.this, "Installing...", "");

                Thread thread = new Thread(ScalaInstallerActivity.this);
                thread.start();
            }
        });
    }

    @Override
    public void run() {
        ScalaInstaller installer = new ScalaInstaller(getApplicationContext());
        installer.installScalaLibs();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.setEnabled(false);

                text.setTextSize(20);
                text.setText("Finished! Please restart your phone.");

                progress.dismiss();
            }
        });
    }
}

