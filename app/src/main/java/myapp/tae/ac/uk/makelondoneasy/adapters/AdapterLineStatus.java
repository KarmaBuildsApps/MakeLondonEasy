package myapp.tae.ac.uk.makelondoneasy.adapters;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.api.ItemOnClickInterface;

/**
 * Created by Karma on 19/01/16.
 */
public class AdapterLineStatus extends RecyclerView.Adapter<AdapterLineStatus.ViewHolder> {
    private Context context;
    private String[] detail = {"This is Detail 1. This is no very long text.", "This is Detail 2. This is no very long text.",
            "This is Detail 3. This is no very long text.", "This is Detail 4. This is no very long text."};
    private String[] header = {"Header 1", "Header 2", "Header 3", "Header 4"};

    public AdapterLineStatus(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.line_status_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvLineStatusHeader.setText(header[position]);
        holder.tvStatusDetail.setText(detail[position]);
        holder.setOnItemClickInterface(new ItemOnClickInterface() {
            @Override
            public void onItemClick(View view, int pos) {
                Toast.makeText(context, "This is nav Item: " + pos, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return header.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvLineStatusHeader;
        TextView tvStatusDetail;
        LinearLayout expandableView;


        private ItemOnClickInterface itemOnClickInterface;

        public ViewHolder(View itemView) {
            super(itemView);
            tvLineStatusHeader = (TextView) itemView.findViewById(R.id.tvLineStatus);
            tvStatusDetail = (TextView) itemView.findViewById(R.id.tvStatusDetail);
            expandableView = (LinearLayout) itemView.findViewById(R.id.llExpandableView);
            expandableView.setVisibility(View.GONE);
            itemView.setOnClickListener(this);
        }

        public void setOnItemClickInterface(ItemOnClickInterface itemOnClickInterface) {
            this.itemOnClickInterface = itemOnClickInterface;
        }


        @Override
        public void onClick(View v) {
            Log.i("ViewHolder", "Item number " + getLayoutPosition() + " is Clicked");
            if (expandableView.getVisibility() == View.GONE) {
                expand();
            } else {
                collapse();
            }
            itemOnClickInterface.onItemClick(v, getLayoutPosition());
        }

        /**
         * Animation for dropdown
         ***/

        private void expand() {
            //set Visible
            expandableView.setVisibility(View.VISIBLE);

            final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            expandableView.measure(widthSpec, heightSpec);

            ValueAnimator mAnimator = slideAnimator(0, expandableView.getMeasuredHeight());
            mAnimator.start();
        }

        private ValueAnimator slideAnimator(int start, int end) {

            ValueAnimator animator = ValueAnimator.ofInt(start, end);

            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    //Update Height
                    int value = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = expandableView.getLayoutParams();
                    layoutParams.height = value;
                    expandableView.setLayoutParams(layoutParams);
                }
            });
            return animator;
        }

        private void collapse() {
            int finalHeight = expandableView.getHeight();

            ValueAnimator mAnimator = slideAnimator(finalHeight, 0);

            mAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    //Height=0, but it set visibility to GONE
                    expandableView.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            mAnimator.start();
        }
    }


}
