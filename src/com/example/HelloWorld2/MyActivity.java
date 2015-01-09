package com.example.HelloWorld2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    Button encryp = null;
//    Button decryp = null;
//
//    EditText source = null;
//    EditText dest = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (!FileUtils.exists(FileUtils.EnCryptyFilesDir) || !FileUtils.exists(FileUtils.CryptyEdFilesDir)) {
            new File(FileUtils.EnCryptyFilesDir).mkdir();
            new File(FileUtils.CryptyEdFilesDir).mkdir();
        }
        encryp = (Button) findViewById(R.id.encryp);
//        decryp = (Button) findViewById(R.id.decryp);
//        source = (EditText) findViewById(R.id.source);
//        dest = (EditText) findViewById(R.id.dest);

        encryp.setOnClickListener(this);
//        decryp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
//        String sourceFile = source.getText().toString();
//        String destFile = dest.getText().toString();


//        String dest1 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + sourceFile;
//        String dest2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + destFile;

//        if (view.getId() == R.id.decryp) {
//
//
//            EncryptUtil.enOrDecryptFile(null, dest1, dest2, Cipher.DECRYPT_MODE);
//
//
//        } else {
//        EncryptUtil.enOrDecryptFile(null, dest1, dest2, Cipher.ENCRYPT_MODE);


//        }
        String[] allEncrypty = FileUtils.getAllNeedEnCryptyFiles();

        if (allEncrypty == null) {
            Toast.makeText(MyActivity.this, "没有需要加密的文件!", Toast.LENGTH_LONG).show();
            return;
        }

        for (String s : allEncrypty) {
            String source = FileUtils.EnCryptyFilesDir + s;

            String cryptyedFileName = FileUtils.getCryptyedFileName(s);
            String dest = FileUtils.CryptyEdFilesDir + cryptyedFileName;

            if (!EncryptUtil.enOrDecryptFile(null, source, dest, Cipher.ENCRYPT_MODE)) {
                Toast.makeText(MyActivity.this, s + "加密失败!", Toast.LENGTH_LONG).show();

                break;
            }
        }

        Toast.makeText(MyActivity.this, "加密成功!", Toast.LENGTH_LONG).show();
    }
}
