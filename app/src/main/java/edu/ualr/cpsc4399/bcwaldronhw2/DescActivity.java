package edu.ualr.cpsc4399.bcwaldronhw2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class DescActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_activity);

        FragmentManager fm = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        String title;
        String desc;

        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");

        bundle.putString("title", title);
        bundle.putString("desc", desc);

        DescFragment frag = new DescFragment();
        frag.setArguments(bundle);

        fm.beginTransaction().add(R.id.fragment_cont, frag).commit();


    }
}
