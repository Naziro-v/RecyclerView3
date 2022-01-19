package com.nazirov.recyclerview3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.nazirov.recyclerview3.adapter.CustomAdapter;
import com.nazirov.recyclerview3.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareMemerList();
        refreshAdapter(members);
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter =new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);

    }


    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

    }
    private List<Member> prepareMemerList() {

        List<Member> members = new ArrayList <>();
        members.add(new Member());

        for (int i = 0; i < 30; i++) {
            if (i==0 || i==5 || i==16 || i==25) {
                members.add(new Member("Elmurod"+i,"Nazirov"+i,false));
            }
            else {
                members.add(new Member("Elmurod"+i,"Nazirov"+i,true));

            }
        }
        members.add(new Member());
        return members;

    }
}