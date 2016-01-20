package myapp.tae.ac.uk.makelondoneasy.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.adapters.AdapterNavMenu;
import myapp.tae.ac.uk.makelondoneasy.api.ItemOnClickInterface;

/**
 * Created by Karma on 19/01/16.
 */
public class NavigationMenuFragment extends Fragment implements ItemOnClickInterface {
    private RecyclerView rcNavMenu;
    private AdapterNavMenu adapterNavMenu;
    private ImageView profilePic;
    private DrawerLayout drawerLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        rcNavMenu = (RecyclerView) v.findViewById(R.id.rcNavMenu);
        profilePic = (ImageView) v.findViewById(R.id.ivNavHeaderPic);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rcNavMenu.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterNavMenu = new AdapterNavMenu(getActivity(), drawerLayout);
        rcNavMenu.setAdapter(adapterNavMenu);
    }

    public void sendDrawerLayout(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }
    //    public void setParentActivity(Context context, DrawerLayout drawerLayout) {
//        this.drawerLayout = drawerLayout;
//        String[] menu = context.getResources().getStringArray(R.array.drawerMenu);
//        adapterNavMenu = new AdapterNavMenu(getActivity(), menu);
//        rcNavMenu.setLayoutManager(new LinearLayoutManager(context));//set Layout Manager for the adapter
//        rcNavMenu.setAdapter(adapterNavMenu);
//        rcNavMenu.bringToFront();
//
//    }

    @Override
    public void onItemClick(View view, int pos) {

    }
}
