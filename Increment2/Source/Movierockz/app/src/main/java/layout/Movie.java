package layout;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usgir.movierockz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Movie extends Fragment {
    ViewPager pager;
    TabLayout tabLayout;
    Context context;
    View view;
    String s[];


    public Movie() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_movie, container, false);
        s = new String[]{"Movies","TV-Shows"};
        pager = (ViewPager)view.findViewById(R.id.pager);
        tabLayout = (TabLayout)view.findViewById(R.id.tablay);
        context = getActivity();
        FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
        Myadapter myadapter = new Myadapter(manager);
        pager.setAdapter(myadapter);
        tabLayout.setupWithViewPager(pager);
        return view;
    }

    public class Myadapter extends FragmentPagerAdapter
    {

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return Myfragment.getFragment(position);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return s[position];
        }
    }
    public static class Myfragment extends android.support.v4.app.Fragment
    {
        public static android.support.v4.app.Fragment getFragment(int i)
        {
            Myfragment myfragment = new Myfragment();
            Bundle args = new Bundle();
            args.putInt("pos",i);
            myfragment.setArguments(args);
            return myfragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            if (getArguments().getInt("pos")==0)
            {
                return inflater.inflate(R.layout.fragment_movie1,container,false);
            }
            return inflater.inflate(R.layout.fragment_tvshows,container,false);
        }
    }

}
