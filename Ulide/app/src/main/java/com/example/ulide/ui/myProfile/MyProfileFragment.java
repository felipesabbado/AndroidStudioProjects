package com.example.ulide.ui.myProfile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ulide.R;
import com.example.ulide.databinding.FragmentMyProfileBinding;
import com.example.ulide.downloaders.JSONArrayDownloader;
import com.example.ulide.ui.spotsFromRoute.SpotsFromRouteFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MyProfileFragment extends Fragment {

    private FragmentMyProfileBinding binding;
    private ListView listViewRoutes;

    ArrayList<String> routes;
    ArrayList<String> routesId;
    ArrayList<String> routesName;
    ArrayAdapter<String> adapterRoutes;
    JSONArray objRoutesAvg = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMyProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listViewRoutes = binding.listRoutes;

        JSONArrayDownloader task = new JSONArrayDownloader();
        try {
            objRoutesAvg = task.execute("https://ulide.herokuapp.com/api/routes/avg").get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            objRoutesAvg = null;
        }

        JSONObject obj;
        routes = new ArrayList<>();
        routesId = new ArrayList<>();
        routesName = new ArrayList<>();
        if(objRoutesAvg != null) {
            for(int i = 0; i < objRoutesAvg.length(); i++) {
                try {
                    obj = objRoutesAvg.getJSONObject(i);
                    double routesAvg = obj.getDouble("rtAvg");
                    String routeName = obj.getString("rtName");
                    routes.add(String.format("%s - Rate: %.2f", routeName, routesAvg));
                    routesId.add(obj.getString("id"));
                    routesName.add(obj.getString("rtName"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.e("Array List", routes.toString());
            InitializeAdapter();
        }

        return root;
    }

    public void InitializeAdapter(){
        adapterRoutes = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, routes);
        listViewRoutes.setAdapter(adapterRoutes);
        createListViewClickItemEvent(listViewRoutes, routes, routesId, routesName);
    }

    private void createListViewClickItemEvent(ListView list, final ArrayList<String> items,
                                              final ArrayList<String> id, final ArrayList<String> name) {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("INFO", "O nome da rota é: " + items.get(i));
                Log.e("INFO", "O id da rota é: " + id.get(i));
                Log.e("INFO", name.get(i));
                // Fazer a ligação com o SpotsFromRouteFragment
                Intent spotsFromRoute = new Intent(getContext(), SpotsFromRouteFragment.class);
                spotsFromRoute.putExtra("id", id.get(i));
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().
                        replace(R.id.nav_host_fragment_container, SpotsFromRouteFragment.class, null).
                        setReorderingAllowed(true).addToBackStack("Spots").commit();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}