package invenz.roy.mvpprac1.Login;

import android.content.Context;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCred_presenter(String userName, String password, Context context) {

        if (mLoginView != null){
            mLoginView.showProgressBar_view();
            mLoginInteractor.login_Interactor(userName, password, this, context);
        }

    }

    @Override
    public void onDestroy_presenter() {

        if (mLoginView != null){

            mLoginView.hideProgressBar_view();
            mLoginView = null;

        }
    }




    @Override
    public void onUserNameError_Interactor() {

        if (mLoginView != null){

            mLoginView.hideProgressBar_view();
            mLoginView.setUserNameError_view();
        }
    }

    @Override
    public void onPasswordError_Interactor() {

        if (mLoginView != null){

            mLoginView.hideProgressBar_view();
            mLoginView.setPasswordError_view();
        }
    }

    @Override
    public void onSuccess_Interactor() {

        if (mLoginView != null){

            mLoginView.hideProgressBar_view();
            mLoginView.navigateToMainActivity_view();
        }
    }

    @Override
    public void onFailure_Interactor(String message) {

        if (mLoginView != null){

            mLoginView.hideProgressBar_view();
            mLoginView.showAlertMessage_view(message);
        }
    }


}
