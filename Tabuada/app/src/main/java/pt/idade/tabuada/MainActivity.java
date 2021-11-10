package pt.idade.tabuada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMyListView();
    }

    private void initializeMyListView() {
        ListView listNumber = (ListView) findViewById(R.id.listNumber);

        ArrayList<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(1);
        myNumbers.add(2);
        myNumbers.add(3);
        myNumbers.add(4);

        ArrayAdapter<Integer> myListAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_2, myNumbers);

        listNumber.setAdapter(myListAdapter);

        clickEvent(listNumber, myNumbers);
    }

    private void clickEvent(ListView list, final ArrayList<Integer> number) {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("INFO", "Números");
            }
        });
    }
}