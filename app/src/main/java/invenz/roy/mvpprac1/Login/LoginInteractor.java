package invenz.roy.mvpprac1.Login;

import android.content.Context;

public interface LoginInteractor {

    interface OnLoginFinishedListener{

        void onUserNameError_Interactor();
        void onPasswordError_Interactor();
        void onSuccess_Interactor();
        void onFailure_Interactor(String message);

    }


    void login_Interactor(String username, String password, OnLoginFinishedListener listener, Context context);

}
