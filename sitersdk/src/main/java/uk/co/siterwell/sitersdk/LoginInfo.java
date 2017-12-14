package uk.co.siterwell.sitersdk;

import android.support.annotation.NonNull;

/**
 * Created by pizwang on 2017/12/14.
 */

public interface LoginInfo {
    @NonNull
    String getUserName();

    @NonNull
    String getPassword();
}
