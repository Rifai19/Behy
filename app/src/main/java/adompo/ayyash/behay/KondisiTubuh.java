package adompo.ayyash.behay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class KondisiTubuh extends Fragment {
    public static KondisiTubuh newInstance() {
        KondisiTubuh fragment = new KondisiTubuh();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kondisi_tubuh, container, false);
    }
}