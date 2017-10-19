package adompo.ayyash.behay;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adompo.ayyash.behay.test.ItemObjectAktifitas;
import adompo.ayyash.behay.test.MainAdapterAktifitas;

public class TipsSehat extends Fragment {
    ProgressDialog progressDialog;
    private ItemObjectAktifitas.ObjectAkatifitas objectAkatifitas;
    private MainAdapterAktifitas adapter;
    public static TipsSehat newInstance() {
        TipsSehat fragment = new TipsSehat();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Progress dialog
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Silahkan Tunggu...");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tips_sehat, container, false);
    }

    public void GetData(String URL) {

        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            ;

            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                objectAkatifitas = mGson.fromJson(response, ItemObjectAktifitas.ObjectAkatifitas.class);
                System.out.println("Respond "+ response);
                // adapter = new MainAdapterProfile(this, objectBelajar.result);
                adapter = new MainAdapterAktifitas(getContext(), objectAkatifitas.result);
                //  adapter = new MainAdapterProfile((Response.Listener<String>) getApplication(), objectBelajar.result);
//                rv_item.setAdapter(adapter);

                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Gagal Konek ke server, periksa jaringan anda :(", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });

        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        queue.add(stringRequest);
    }
}
