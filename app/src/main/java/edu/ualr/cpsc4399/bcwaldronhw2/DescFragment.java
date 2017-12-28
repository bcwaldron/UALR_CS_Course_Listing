package edu.ualr.cpsc4399.bcwaldronhw2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static java.sql.Types.NULL;


public class DescFragment extends Fragment {

    private String desc;
    private String title;
    private TextView class_title;
    private TextView class_desc;
    private Bundle bundle;
    private int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        View view = inflater.inflate(R.layout.fragment_desc, container, false);

        bundle = this.getArguments();
        class_title = (TextView) view.findViewById(R.id.class_title);
        class_desc = (TextView) view.findViewById(R.id.class_desc);


        updateUI(view);
        return view;
    }

    private void updateUI(View v){

        if(bundle != null) {
            desc = bundle.getString("desc");
            title = bundle.getString("title");

            class_title = (TextView) v.findViewById(R.id.class_title);
            class_desc = (TextView) v.findViewById(R.id.class_desc);


            class_title.setText(title);
            class_desc.setText(desc);
        }

    }

    public void updateFrag(String title, String desc){

        class_title.setText(title);
        class_desc.setText(desc);
    }

}
