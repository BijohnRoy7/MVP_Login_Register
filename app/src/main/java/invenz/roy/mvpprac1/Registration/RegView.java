package invenz.roy.mvpprac1.Registration;

public interface RegView {

    void showProgressBar_view();
    void hideProgressBar_view();

    void setUserNameError_view();
    void setPasswordError_view();
    void setEmailError_view();

    void navigateMainActivity_view();
    void showAlert_view(String message);

}
