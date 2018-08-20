package invenz.roy.mvpprac1.Registration;

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

public class RegInteractorImpl implements RegInteractor {


    private static final String TAG ="ROY" ;

    @Override
    public void registerUser_interactor(final String username, final String email, final String password, final OnRegisterLinishedListener listener, Context context) {

        if (username.isEmpty()){
            listener.onUserNameError_interactor();

        }else if (email.isEmpty()){
            listener.onEmailError_interactor();

        }else if (password.isEmpty()){
            listener.onPasswordError_interactor();

        }else {

            final boolean a = true;

            StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, Urls.REGISTER_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonObject = new JSONObject(response);

                                String code = jsonObject.getString("code");
                                String msg = jsonObject.getString("message");

                                //Log.d(TAG, "onResponse: "+code);
                                //Log.d(TAG, "onResponse: "+msg);

                                if (code.equals("success")){
                                    listener.onSuccess_interactor();

                                }else {
                                    listener.odFailure_interactor(msg);

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Log.d(TAG, "onErrorResponse: "+error);
                    listener.odFailure_interactor("Error occured");
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> userMap = new HashMap<>();
                    userMap.put("username",username);
                    userMap.put("email",email);
                    userMap.put("password",password);
                    return userMap;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);


        }

    }
}
