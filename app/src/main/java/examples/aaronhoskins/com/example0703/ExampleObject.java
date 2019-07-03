package examples.aaronhoskins.com.example0703;

import android.os.Parcel;
import android.os.Parcelable;

public class ExampleObject implements Parcelable {
    private String mDataItemOne;
    private String mDataItemTwo;

    public ExampleObject(String mDataItemOne, String mDataItemTwo) {
        this.mDataItemOne = mDataItemOne;
        this.mDataItemTwo = mDataItemTwo;
    }

    protected ExampleObject(Parcel in) {
        mDataItemOne = in.readString();
        mDataItemTwo = in.readString();
    }

    public static final Creator<ExampleObject> CREATOR = new Creator<ExampleObject>() {
        @Override
        public ExampleObject createFromParcel(Parcel in) {
            return new ExampleObject(in);
        }

        @Override
        public ExampleObject[] newArray(int size) {
            return new ExampleObject[size];
        }
    };

    public String getmDataItemOne() {
        return mDataItemOne;
    }

    public void setmDataItemOne(String mDataItemOne) {
        this.mDataItemOne = mDataItemOne;
    }

    public String getmDataItemTwo() {
        return mDataItemTwo;
    }

    public void setmDataItemTwo(String mDataItemTwo) {
        this.mDataItemTwo = mDataItemTwo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mDataItemOne);
        parcel.writeString(mDataItemTwo);
    }
}
