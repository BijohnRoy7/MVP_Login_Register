package invenz.roy.mvpprac1.Registration;

import android.content.Context;

public class RegPresenterImpl implements RegPresenter, RegInteractor.OnRegisterLinishedListener {

    private RegView mRegView;
    private RegInteractor mRegInteractor;

    public RegPresenterImpl(RegView mRegView) {
        this.mRegView = mRegView;
        mRegInteractor = new RegInteractorImpl();
    }

    @Override
    public void register_presenter(String username, String email, String password, Context context) {

        if (mRegView != null ){
            mRegView.showProgressBar_view();
            mRegInteractor.registerUser_interactor(username, email, password, this, context);
        }

    }

    @Override
    public void onDestroy_presenter() {
        if (mRegView != null ){
            mRegView = null;
        }
    }

    @Override
    public void onUserNameError_interactor() {
        if (mRegView != null ){

            mRegView.hideProgressBar_view();
            mRegView.setUserNameError_view();
        }
    }

    @Override
    public void onEmailError_interactor() {
        if (mRegView != null ){

            mRegView.hideProgressBar_view();
            mRegView.setEmailError_view();
        }
    }

    @Override
    public void onPasswordError_interactor() {
        if (mRegView != null ){

            mRegView.hideProgressBar_view();
            mRegView.setPasswordError_view();
        }
    }

    @Override
    public void onSuccess_interactor() {
        if (mRegView != null ){

            mRegView.hideProgressBar_view();
            mRegView.navigateMainActivity_view();
        }
    }

    @Override
    public void odFailure_interactor(String message) {
        if (mRegView != null ){

            mRegView.hideProgressBar_view();
            mRegView.showAlert_view(message);
        }
    }
}
