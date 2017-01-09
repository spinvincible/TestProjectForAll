package saurabhpandey.com.testprojectforall;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nixxmare on 11/17/2016.
 */

public class MyFragment extends Fragment {
    private TextView textView;
    List<Person> personInAdapter = new ArrayList<>();
    private Context context;
    private DatabaseReference databaseReference;
    public static MyFragment getInstance(int position) {
        MyFragment myFragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);

        return myFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        textView = (TextView) view.findViewById(R.id.myFragmentTextView);
        databaseReference = FirebaseUtil.getBaseRef().child("Person");
        int i = getArguments().getInt("position");
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Person person = dataSnapshot.getValue(Person.class);
                
                textView.setText(person.getEmail());
                // [END_EXCLUDE]
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                // [START_EXCLUDE]

            }
        };
        databaseReference.addValueEventListener(postListener);
//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            textView.setText("The value is" +i);
//        }

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}