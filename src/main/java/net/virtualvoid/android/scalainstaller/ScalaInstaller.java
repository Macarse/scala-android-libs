package net.virtualvoid.android.scalainstaller;

import android.content.Context;
import android.util.Log;

import java.io.*;

public class ScalaInstaller {
    Context ctx;
    public ScalaInstaller(Context ctx) {
        this.ctx = ctx;
    }

    private static String TAG = "ScalaInstaller";

    public static void installScalaLibs() {
        /*
         *  1. Make /system writeable
         *  2. Install files into application directory
         *  3. Change permissions
         *  4. Make links to ScalaLibs to /system/etc/permissions
         *  5. Make /system read-only
         */

        try {
            makeWritable();
            installFiles(ctx);
        } finally {
            makeReadOnly();
        }
    }

    public static void makeWritable() {
        Log.d(TAG, "Make /system writable");
        sudo("mount -oremount,rw /system");
    }
    public static void makeReadOnly() {
        Log.d(TAG, "Make /system read-only");
        sudo("mount -oremount,ro /system");
    }

    private static int[] resources = {
        R.raw.scala_collection,
        R.raw.scala_collection_desc
    };
    public static void installFiles(Context ctx) {

    }

    private static Runtime runtime = Runtime.getRuntime();
    private static void sudo(String cmd){
        try {
            Process proc = runtime.exec(new String[] {"su", "-c", cmd});
            int res = proc.waitFor();
            if (res != 0)
                throw new RuntimeException(String.format("Execution of cmd '%s' failed with exit code %d", cmd, res));
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Takes the resource with the given name and installs it into the files dir
     * @param resource
     */
    private void installFile(int resource) throws IOException {
        File targetFile = fileForResource(resource);
        FileOutputStream fos = new FileOutputStream(targetFile);
        InputStream is = ctx.getResources().openRawResource();

        byte[] buffer = new byte[65000];

        while (is.available() > 0) {
            int read = is.read(buffer);
            fos.write(buffer, 0, read);
        }
        is.close();
        fos.close();
    }
    private File fileForResource(int resource) {
        return new File(ctx.getFilesDir(), ctx.getResources().getResourceName(resource));
    }
}
