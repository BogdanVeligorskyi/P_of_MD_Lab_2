package ua.cn.cpnu.pmp_lab_2.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

// class for saving options in app
public class Options implements Parcelable {

    // possible number of questions
    public static final List<String> QUESTIONS_NUM = Arrays.asList
            ("5", "6", "7", "8", "9", "10");


    protected Options(Parcel in) {
    }

    public static final Creator<Options> CREATOR = new Creator<Options>() {
        @Override
        public Options createFromParcel(Parcel in) {
            return new Options(in);
        }

        @Override
        public Options[] newArray(int size) {
            return new Options[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
