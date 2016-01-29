package myapp.tae.ac.uk.makelondoneasy.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import myapp.tae.ac.uk.makelondoneasy.MainActivity;
import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.api.ItemOnClickInterface;

/**
 * Created by Karma on 19/01/16.
 */
public class AdapterNavMenu extends RecyclerView.Adapter<AdapterNavMenu.ViewHolder> {
    private Context context;
    private String[] menuItems;
    private int[] menuIcons;
    private DrawerLayout drawerLayout;

    public AdapterNavMenu(Context context, DrawerLayout drawerLayout) {
        this.context = context;
        this.drawerLayout = drawerLayout;
//        this.menuItems = menuItems;
        menuItems = context.getResources().getStringArray(R.array.drawerMenu);
//        menuIcons = context.getResources().getIntArray(R.array.drawerMenuIcons);
        menuIcons = getImagesResources(context, R.array.drawerMenuIcons);
//        getNavMenuItems();
    }

    private static int[] getImagesResources(Context context, int arrayResource) {
        TypedArray mIconsTypeArray = context.getResources().obtainTypedArray(arrayResource);
        int[] mDrawerIcons = new int[mIconsTypeArray.length()];
        for (int i = 0; i < mDrawerIcons.length; i++) {
            mDrawerIcons[i] = mIconsTypeArray.getResourceId(i, 0);
        }
        mIconsTypeArray.recycle();
        return mDrawerIcons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nav_menu_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNavManuItem.setText(menuItems[position]);
//        holder.ivNavMenuIcon.setImageResource(menuIcons[position]);
        Picasso.with(context).load(menuIcons[position]).resize(64, 64).
                centerCrop().into(holder.ivNavMenuIcon);
        holder.setOnItemClickInterface(new ItemOnClickInterface() {
            @Override
            public void onItemClick(View view, int pos) {
                drawerLayout.closeDrawers();
                ((MainActivity) context).performActionOnNavClicked(pos);
            }
        });
    }


    @Override
    public int getItemCount() {
        return menuItems.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvNavManuItem;
        private ImageView ivNavMenuIcon;
        private ItemOnClickInterface itemOnClickInterface;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNavManuItem = (TextView) itemView.findViewById(R.id.tvNavMenuItem);
            ivNavMenuIcon = (ImageView) itemView.findViewById(R.id.ivNavMenuIcon);
            itemView.setOnClickListener(this);
        }

        public void setOnItemClickInterface(ItemOnClickInterface itemOnClickInterface) {
            this.itemOnClickInterface = itemOnClickInterface;
        }


        @Override
        public void onClick(View v) {
            Log.i("ViewHolder", "Item number " + getLayoutPosition() + " is Clicked");
            itemOnClickInterface.onItemClick(v, getLayoutPosition());
        }
    }
}
