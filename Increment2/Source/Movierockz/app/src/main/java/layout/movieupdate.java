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
public class movieupdate extends Fragment {
    ViewPager pager;
    TabLayout tabLayout;
    Context context;
    View view;
    String s[];

    public movieupdate() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_movieupdate, container, false);
        s = new String[]{"Movies","TV-Shows","Movies","TV-Shows"};
        pager = (ViewPager)view.findViewById(R.id.pager3);
        tabLayout = (TabLayout)view.findViewById(R.id.tablay2);
        context = getActivity();
        FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
        Myadapters myadapter = new Myadapters(manager);
        pager.setAdapter(myadapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_movie_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tv_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_movie_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_tv_black_24dp);
        return view;
    }
    public class Myadapters extends FragmentPagerAdapter
    {

        public Myadapters(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return Myfragments.getFragment(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return s[position];
        }
    }
    public static class Myfragments extends android.support.v4.app.Fragment
    {
        public static android.support.v4.app.Fragment getFragment(int i)
        {
            Myfragments myfragment = new Myfragments();
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
