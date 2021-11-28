package com.example.ulide.ui.spotsFromRoute;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ulide.R;
import com.example.ulide.databinding.FragmentMyProfileBinding;
import com.example.ulide.downloaders.JSONArrayDownloader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SpotsFromRouteFragment extends Fragment {

    private FragmentMyProfileBinding binding;
    private ListView listViewSpots;

    ArrayList<String> spots;
    ArrayList<String> spotsId;
    ArrayList<String> spotsName;
    ArrayAdapter<String> adapterSpots;
    JSONArray objSpots = null;

    public SpotsFromRouteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listViewSpots = binding.listRoutes;

        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");

        JSONArrayDownloader task = new JSONArrayDownloader();
        try {
            objSpots = task.execute("https://ulide.herokuapp.com/api/routes/" + id + "/spots").get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            objSpots = null;
        }

        JSONObject obj;
        spots = new ArrayList<>();
        spotsId = new ArrayList<>();
        if (objSpots != null) {
            for (int i = 0; i < objSpots.length(); i++) {
                try {
                    obj = objSpots.getJSONObject(i);
                    spots.add(obj.getString("spName"));
                    spotsId.add(obj.getString("id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.e("SPOTS", spots.toString());
            InitalizeAdapter();
        }

        return root;
    }

    public void InitalizeAdapter() {
        adapterSpots = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, spots);
        listViewSpots.setAdapter(adapterSpots);
    }
}