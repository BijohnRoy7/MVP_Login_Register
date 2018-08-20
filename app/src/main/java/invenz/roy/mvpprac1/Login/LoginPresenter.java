package invenz.roy.mvpprac1.Login;

import android.content.Context;

public interface LoginPresenter {

    void validateCred_presenter(String userName, String password, Context context);
    void onDestroy_presenter();

}
