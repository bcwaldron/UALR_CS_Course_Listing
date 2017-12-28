package edu.ualr.cpsc4399.bcwaldronhw2;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment{

    private RecyclerView RV;
    public List<Course> courses;
    private myAdapter adapter;
    private int is_phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        courses = build();

        ListActivity activity = (ListActivity) getActivity();
        is_phone = activity.getIs_phone();

        RV = (RecyclerView) view.findViewById(R.id.recycler_view);
        RV.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI(){

        adapter = new myAdapter(courses);
        RV.setAdapter(adapter);
    }


    private class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView classtitle;
        private Course course;

        public ListHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            classtitle = (TextView) itemView.findViewById(R.id.course_title);
        }

        public void bindCourse(Course c){

            course = c;
            classtitle.setText(course.getTitle());
        }

        @Override
        public void onClick(View v){
            //launch other activity
            int position;
            Course course;
            position = getAdapterPosition();
            course = courses.get(position);

            if(is_phone == 1){

                Intent i = new Intent(getActivity(), DescActivity.class);

                i.putExtra("title", course.getTitle());
                i.putExtra("desc", course.getDescription());
                startActivity(i);
            }
            else{
                DescFragment df = (DescFragment) getFragmentManager().findFragmentById(R.id.desc_frag);
                if(df != null){

                    df.updateFrag(course.getTitle(), course.getDescription());
                }

            }
        }
    }
    private List<Course> build() {

        List<Course> x = new ArrayList<>();
        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] desc = res.getStringArray(R.array.descriptions);

        for (int i = 0; i < 44; i++) {

            Course y = new Course();
            y.setTitle(titles[i]);
            y.setDescription(desc[i]);
            x.add(y);

        }
        return x;
    }

    private class myAdapter extends RecyclerView.Adapter<ListHolder>{

        private List<Course> mClasses;

        public myAdapter(List<Course> classes){

            mClasses = classes;
        }

        @Override
        public ListHolder onCreateViewHolder(ViewGroup parent, int viewType){

            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_item, parent, false);
            return new ListHolder(view);
        }

        @Override
        public void onBindViewHolder(ListHolder holder, int position){

            Course course = mClasses.get(position);
            holder.bindCourse(course);
        }

        @Override
        public int getItemCount(){

            return mClasses.size();
        }
    }

}
