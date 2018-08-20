package invenz.roy.mvpprac1.Registration;

import android.content.Context;

public interface RegPresenter {

    void register_presenter(String username, String email, String password, Context context);
    void onDestroy_presenter();

}
