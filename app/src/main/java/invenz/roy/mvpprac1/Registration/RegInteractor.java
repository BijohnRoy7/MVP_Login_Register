package invenz.roy.mvpprac1.Registration;

import android.content.Context;

public interface RegInteractor {

    interface OnRegisterLinishedListener{

        void onUserNameError_interactor();
        void onEmailError_interactor();
        void onPasswordError_interactor();
        void onSuccess_interactor();
        void odFailure_interactor(String message);

    }

    void registerUser_interactor(String username, String email, String password, OnRegisterLinishedListener listener, Context context);


}
