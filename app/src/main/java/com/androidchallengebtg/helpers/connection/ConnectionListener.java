package com.androidchallengebtg.helpers.connection;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface ConnectionListener {

    void onSuccess (JSONObject response);
    void onError (JSONObject error);
}
