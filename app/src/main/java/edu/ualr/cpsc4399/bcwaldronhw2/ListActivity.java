package edu.ualr.cpsc4399.bcwaldronhw2;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class ListActivity extends FragmentActivity {

    private int is_phone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        FragmentManager fm = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }
            is_phone = 1;

            ListFragment listfrag = new ListFragment();
            fm.beginTransaction().add(R.id.fragment_container, listfrag).commit();
        }
    }

    public int getIs_phone(){

        return is_phone;
    }
}
