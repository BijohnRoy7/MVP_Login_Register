package invenz.roy.mvpprac1.Login;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import invenz.roy.mvpprac1.utils.Urls;

public class LoginInteractorImpl implements LoginInteractor {


    private static final String TAG = "ROY";

    @Override
    public void login_Interactor(final String username, final String password, final OnLoginFinishedListener listener, Context context) {

        if (username.isEmpty()){
            listener.onUserNameError_Interactor();

        }else if (password.isEmpty()){
            listener.onPasswordError_Interactor();

        }/*else if (username.equals("john") && password.equals("123")){
            listener.onSuccess_Interactor();

        }*/
        else {

            StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, Urls.LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonObject = new JSONObject(response);

                                String code = jsonObject.getString("code");
                                String msg = jsonObject.getString("message");

                                Log.d(TAG, "onResponse: "+code);
                                Log.d(TAG, "onResponse: "+msg);

                                if (code.equals("success")){
                                    listener.onSuccess_Interactor();

                                }else {
                                    listener.onFailure_Interactor(msg);

                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Log.d(TAG, "onErrorResponse: "+error);
                    listener.onFailure_Interactor("Error Occured");
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> userMap = new HashMap<>();
                    userMap.put("username",username);
                    userMap.put("password",password);
                    return userMap;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);

        }

    }


}
