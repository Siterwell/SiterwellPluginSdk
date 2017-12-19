package uk.co.siterwell.sitersdk.ipcam;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import uk.co.siterwell.sitersdk.LoginInfo;

/**
 * Created by pizwang on 2017/12/14.
 */

public class LoginedScannedDevice extends AbstractScannedDevice implements LoginInfo {

    public LoginedScannedDevice() {
        this(null,
            null,
            null,
            null,
            null,
            false,
            null,
            null,
            null,
            null);
    }

    public LoginedScannedDevice(String uuid,
                                String uri,
                                String manufacturer,
                                String modelName,
                                String scannedProtocol,
                                boolean isAdded,
                                String sn,
                                String mac,
                                String username,
                                String password) {
        super(uuid,
            uri,
            manufacturer,
            modelName,
            scannedProtocol,
            isAdded,
            sn,
            mac);
        this.username = username;
        this.password = password;
    }

    private LoginedScannedDevice(Parcel in) {
        super(in);
        this.username = in.readString();
        this.password = in.readString();
    }

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public static final Parcelable.Creator<LoginedScannedDevice> CREATOR = new Parcelable.Creator<LoginedScannedDevice>() {
        @Override
        public LoginedScannedDevice createFromParcel(Parcel in) {
            return new LoginedScannedDevice(in);
        }

        @Override
        public LoginedScannedDevice[] newArray(int size) {
            return new LoginedScannedDevice[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(username);
        parcel.writeString(password);
    }

    @NonNull
    @Override
    public String getUserName() {
        return this.username != null ? this.username : "";
    }

    @NonNull
    @Override
    public String getPassword() {
        return this.password != null ? this.password : "";
    }

    @Override
    public String toString() {
        return super.toString() + " LoginInfo{" +
            "username='" + getUserName() + '\'' +
            ", password='" + getPassword() + '\'' +
            '}';
    }
}
