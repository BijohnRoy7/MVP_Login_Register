package invenz.roy.mvpprac1.Login;

public interface LoginView {

    void showProgressBar_view();
    void hideProgressBar_view();

    void setUserNameError_view();
    void setPasswordError_view();

    void navigateToMainActivity_view();
    void showAlertMessage_view(String message);

}
