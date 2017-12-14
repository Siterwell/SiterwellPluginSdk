package uk.co.siterwell.sitersdk.ipcam;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractScannedDevice implements Parcelable, IpCamScannedDevice {
    @SerializedName("uuid")
    protected String uuid;

    @SerializedName("mac")
    protected String mac;

    @Expose(deserialize = false)
    protected String ipAddress;

    @SerializedName("manufacture_name")
    protected String manufacturer;

    @SerializedName("hardware_name")
    protected String modelName;

    @SerializedName("device_protocol")
    protected String scannedProtocol;

    @SerializedName("device_uri")
    protected String uri;

    @SerializedName("is_added")
    protected boolean isAdded;

    @SerializedName("sn")
    protected String sn;

    public AbstractScannedDevice() {
        this(null,
            null,
            null,
            null,
            null,
            false,
            null,
            null);
    }

    public AbstractScannedDevice(String uuid,
                             String uri,
                             String manufacturer,
                             String modelName,
                             String scannedProtocol,
                             boolean isAdded,
                             String sn,
                             String mac) {
        this.uuid = uuid;
        this.uri = uri;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.isAdded = isAdded;
        this.ipAddress = extractIpAddress(uri);
        this.scannedProtocol = scannedProtocol;
        this.sn = sn;
        this.mac = mac;
    }

    protected AbstractScannedDevice(Parcel in) {
        uuid = in.readString();
        mac = in.readString();
        ipAddress = in.readString();
        manufacturer = in.readString();
        modelName = in.readString();
        scannedProtocol = in.readString();
        uri = in.readString();
        isAdded = in.readByte() != 0;
        sn = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(uuid);
        parcel.writeString(mac);
        parcel.writeString(ipAddress);
        parcel.writeString(manufacturer);
        parcel.writeString(modelName);
        parcel.writeString(scannedProtocol);
        parcel.writeString(uri);
        parcel.writeByte((byte) (isAdded ? 1 : 0));
        parcel.writeString(sn);
    }

    @Nullable
    @Override
    public String getUuid() {
        return this.uuid;
    }

    @Nullable
    public String getIpAddress() {
        if (ipAddress == null && uri != null) {
            ipAddress = extractIpAddress(uri);
        }
        return this.ipAddress;
    }

    @NonNull
    @Override
    public String getManufacturer() {
        return this.manufacturer != null ? this.manufacturer : "";
    }

    @NonNull
    @Override
    public String getModelName() {
        return this.modelName != null ? this.modelName : "";
    }

    @NonNull
    @Override
    public String getScannedProtocol() {
        return this.scannedProtocol != null ? this.scannedProtocol : "";
    }

    @NonNull
    @Override
    public String getSn() {
        return this.sn != null ? this.sn : "";
    }

    @NonNull
    @Override
    public String getMac() {
        return this.mac != null ? this.mac : "";
    }

    @Override
    public boolean isAdded() { return this.isAdded; }

    @Nullable
    private String extractIpAddress(String uriStr) {
        if (uriStr == null || uriStr.isEmpty()) {
            return null;
        }

        Uri uri = Uri.parse(uriStr);

        return uri.getHost();
    }

    @Override
    public String toString() {
        return "BaseScannedDevice{" +
            "uuid='" + getUuid() + '\'' +
            ", ipAddress='" + getIpAddress() + '\'' +
            ", manufacturer='" + getManufacturer() + '\'' +
            ", modelName='" + getModelName() + '\'' +
            ", uri='" + uri + '\'' +
            ", sn='" + sn + '\'' +
            ", mac='" + mac + '\'' +
            '}';
    }
}
