package ua.cn.cpnu.pmp_lab_2.model;

import android.os.Parcel;
import android.os.Parcelable;

// class for defining a question, its possible variants and correct answer
public class Questions implements Parcelable {


    protected Questions(Parcel in) {
    }

    public static final Creator<Questions> CREATOR = new Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel in) {
            return new Questions(in);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
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

