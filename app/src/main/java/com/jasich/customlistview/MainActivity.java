package com.jasich.customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
    ListView maListViewPerso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maListViewPerso = findViewById(R.id.listviewperso);

        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();

        HashMap<String, String> map;

        map = new HashMap<>();
        map.put("titre", "Word");
        map.put("description", "Editeur de text");
        map.put("img", String.valueOf(R.drawable.word));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Excel");
        map.put("description", "Tableur");
        map.put("img", String.valueOf(R.drawable.excel));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "PowerPoint");

        map.put("description", "Logiciel de presentation");
            map.put("img", String.valueOf(R.drawable.powerpoint));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Outlook");
        map.put("description", "Client de courrier electronique");
        map.put("img", String.valueOf(R.drawable.outlook));
        listItem.add(map);

        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                listItem,
                R.layout.activity_list_item,
                new String[]{"img", "titre", "description"},
                new int[]{R.id.img, R.id.titre, R.id.description});
        maListViewPerso.setAdapter(adapter);


        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,String> map=(HashMap<String,String>)  maListViewPerso.getItemAtPosition(position);

                Toast.makeText(MainActivity.this, map.get("titre"), Toast.LENGTH_SHORT).show();


                                                   }
                                               }
        );


        maListViewPerso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String,String> map=(HashMap<String,String>)  maListViewPerso.getItemAtPosition(position);

                final AlertDialog.Builder bil=new AlertDialog.Builder(MainActivity.this);
                bil.setTitle("Sélection item");
                bil.setMessage("Votre choix:"+map.get("titre"));
                bil.setPositiveButton("ok",null);
                bil.show();



                return true;
            }
        });

    }
}
