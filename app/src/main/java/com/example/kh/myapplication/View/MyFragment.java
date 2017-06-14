package com.example.kh.myapplication.View;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.kh.myapplication.Module.Contact;
import com.example.kh.myapplication.Module.MyAdapterRecycler;
import com.example.kh.myapplication.Module.MyVolley;
import com.example.kh.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    private static final String TAG ="vo cong vinh" ;
    private String url = "http://192.168.1.10/DuLieu/josn.php";
    private  Context mContext;
    private List<Contact> list  = new ArrayList<Contact>();
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this,view);

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, (String) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                parseJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyVolley.getInstance(getActivity()).AddRequest(jsonArrayRequest);
    }

    public void parseJson(JSONArray jsonArray){
        try{
            int count  = 0 ;
            while(jsonArray.length()>count){
                JSONObject jsonObject  =jsonArray.getJSONObject(count);
                Contact contact = new Contact(jsonObject.getInt("Id"),jsonObject.getString("Name"),jsonObject.getString("Email"),jsonObject.getString("Phone"), jsonObject.getString("Src"));
                list.add(contact);

                count++;
            }
        }catch (Exception e){

        }
        Log.i(TAG, "parseJson: "+list.size()+list.get(0).getPhone()+", src: "+list.get(0).getSrc());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyAdapterRecycler(getActivity(),list));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MyVolley.getInstance(getActivity()).StartVolley();

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyVolley.getInstance(getActivity()).StopVolley();
    }
}
