package com.example.HelloWorld2;

import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2014/11/14.
 */
public class FileUtils {
    public static final String EnCryptyFilesDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "EnCrypty" + File.separator;
    public static final String CryptyEdFilesDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "CryptyEd" + File.separator;

    public static String[] getAllNeedEnCryptyFiles() {
        if (!exists(EnCryptyFilesDir)) {
            return null;
        }

        File EnCryptyDir = new File(EnCryptyFilesDir);
        File[] enCryptyFiles = EnCryptyDir.listFiles();

        if (enCryptyFiles == null || enCryptyFiles.length == 0) {
            return null;
        }

        String[] results = new String[enCryptyFiles.length];


        int i = 0;

        for (File f : enCryptyFiles) {
            results[i] = f.getName();
            i++;
        }

        return results;
    }

    public static String getCryptyedFileName(String fileName) {

        String[] s = fileName.split("\\.");

        return s[0];

    }


    public static boolean exists(String path) {

        File file = new File(path);

        if (file.exists()) {
            return true;
        } else {
            return false;
        }

    }
}
