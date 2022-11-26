package ua.cn.cpnu.pmp_lab_2.services;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import android.util.Log;
import ua.cn.cpnu.pmp_lab_2.model.Questions;

// service for loading questions from .txt file
public class QuestionsLoader extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}


