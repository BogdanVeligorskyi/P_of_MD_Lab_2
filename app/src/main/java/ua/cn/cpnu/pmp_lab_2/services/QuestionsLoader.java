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

    public static final String TAG = QuestionsLoader.class.getSimpleName();
    public static final String KEY_QUESTIONS = "ANSWER";
    public static final String FILENAME = "questions.txt";
    public static final String KEY_ACTION = "LOAD_QUESTIONS";

    @Override
    public int onStartCommand(Intent intent, int flags,
                              int startId) {
        String action = intent.getAction();
        if (Objects.equals(action, KEY_ACTION)) {
            try {
                loadQuestions(FILENAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stopSelf();
        return START_STICKY;
    }

    // load questions, answers and possible variants from file
    public void loadQuestions(String filename) throws IOException {
        AssetManager am = getAssets();
        InputStream is = am.open(filename);
        Questions[] arrQuestions = new Questions[10];
        Log.e("TAG", "im in condition");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String s;
        for (int i = 0; i < 10; i++) {
            s = reader.readLine();
            String[] questionParts = s.split("_");
            String[] variants = questionParts[1].split(":");
            arrQuestions[i] = new Questions(questionParts[0], variants, questionParts[1]);
            arrQuestions[i].text_of_question = questionParts[0];
            arrQuestions[i].answer = questionParts[2];
            arrQuestions[i].variants_arr[0] = variants[0];
            arrQuestions[i].variants_arr[1] = variants[1];
            arrQuestions[i].variants_arr[2] = variants[2];
            arrQuestions[i].variants_arr[3] = variants[3];
        }
        Intent answer = new Intent(KEY_ACTION);
        answer.putExtra(KEY_QUESTIONS, arrQuestions);
        sendBroadcast(answer);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}


