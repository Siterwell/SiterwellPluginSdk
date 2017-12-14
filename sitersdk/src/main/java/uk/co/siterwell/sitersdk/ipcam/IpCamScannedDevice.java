package uk.co.siterwell.sitersdk.ipcam;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface IpCamScannedDevice {
    @Nullable
    String getUuid();

    @Nullable
    String getIpAddress();

    @NonNull
    String getManufacturer();

    @NonNull
    String getModelName();

    @NonNull
    String getScannedProtocol();

    @NonNull
    String getSn();

    @NonNull
    String getMac();

    boolean isAdded();
}
