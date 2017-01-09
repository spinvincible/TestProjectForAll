package saurabhpandey.com.testprojectforall;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FirebaseAuth mAuth;
    List<Person> person;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();
        context = this;
        for (int i = 1; i <= 10; i++) {
            String name = "Person" + i;
            String email = "person" + i + "@gmail.com";
            String hobby = "tabletennis" + i;
            Person newPersonAdded = new Person(name, email, hobby);
            person.add(newPersonAdded);
//            DatabaseReference newPost = FirebaseUtil.getBaseRef().child("Person").push();
//            newPost.setValue(newPersonAdded);
        }


        viewPager = (ViewPager) findViewById(R.id.pagerView);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), person, context));


    }

//    public void sendDummyData(View view) {
//
//        for (int i = 1; i <= 5; i++) {
//            String name = "Person" +i;
//            String email = "person" +i+"@gmail.com";
//            String hobby = "tabletennis"+i;
//            Person newPersonAdded = new Person(name , email , hobby);
//            DatabaseReference newPost = FirebaseUtil.getBaseRef().child("Person").push();
//            newPost.setValue(newPersonAdded);
//        }
//
//    }


    public List<Person> getPerson(){
        return person;
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        String[] tabsArray;
        private List<Person> personInAdapter = new ArrayList<>();
        private Context context;

        int icons[] = {R.drawable.white_home, R.drawable.white_heart,
                R.drawable.white_star, R.drawable.white_heart, R.drawable.white_star};

        public MyPagerAdapter(FragmentManager fm, List<Person> person, Context context) {
            super(fm);
            personInAdapter = person;
            this.context = context;
            tabsArray = getResources().getStringArray(R.array.TABS);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return tabsArray[position];
        }

        @Override
        public Fragment getItem(int position) {

            return MyFragment.getInstance(position );
        }

        @Override
        public int getCount() {
            return personInAdapter.size();
        }
    }
}
