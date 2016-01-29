package myapp.tae.ac.uk.makelondoneasy.adapters;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.api.ItemOnClickInterface;
import myapp.tae.ac.uk.makelondoneasy.ui.extra.LineColors;
import myapp.tae.ac.uk.makelondoneasy.model.lineStatus.LineStatus;
import myapp.tae.ac.uk.makelondoneasy.model.lineStatus.TFLLineStatus;

/**
 * Created by Karma on 19/01/16.
 */
public class AdapterLineStatus extends RecyclerView.Adapter<AdapterLineStatus.ViewHolder> {
    private Context context;
    private List<TFLLineStatus> tflLineStatuses;

    public AdapterLineStatus(Context context, List<TFLLineStatus> tflLineStatus) {
        this.context = context;
        this.tflLineStatuses = tflLineStatus;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.line_status_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TFLLineStatus tflLineStatus = tflLineStatuses.get(position);
        String[] statusInfo = getStatusHeader(tflLineStatus);
        int colors[] = LineColors.getTextLineColors(context, statusInfo[0]);
        holder.lineNameColor.setBackgroundColor(colors[0]);
        holder.lineNameColor.setText(tflLineStatus.getName());
        holder.lineNameColor.setTextColor(colors[1]);
        holder.tvLineStatusHeader.setText(statusInfo[1]);
        if (!statusInfo[1].equals("Good Service")) {
            holder.tvLineStatusHeader.setTextColor(Color.RED);
        } else {
            holder.tvLineStatusHeader.setTextColor(Color.BLACK);
        }
        holder.tvStatusDetail.setText(statusInfo[2]);
        holder.setOnItemClickInterface(new ItemOnClickInterface() {
            @Override
            public void onItemClick(View view, int pos) {
//                Toast.makeText(context, "This is nav Item: " + pos, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (tflLineStatuses != null)
            return tflLineStatuses.size();
        else
            return 0;
    }

//    /**
//     * the color names is value>>color have format colorThisIsName where color as prefix and
//     * color name in camel case. This method ensure to return line name in camel case so that codes
//     * that set color of card views according to line name can use camel case converted text to produce
//     * color names.
//     *
//     * @param lineName
//     * @return
//     */
//    private String toCamelCaseForColor(String lineName) {
//        String nameForColor = lineName.toLowerCase();
//        nameForColor = nameForColor.replace("&", "");
//        nameForColor = nameForColor.substring(0, 1).toUpperCase() + nameForColor.substring(1);
//        while (nameForColor.contains(" ")) {
//            int spacePos = nameForColor.indexOf(' ');
//            if (spacePos != nameForColor.length() - 1) {
//                nameForColor = nameForColor.substring(0, spacePos) + nameForColor.substring(spacePos + 1, spacePos + 2).toUpperCase() +
//                        nameForColor.substring(spacePos + 2);
//            }
//        }
//        Log.i("Convert", "Original : " + lineName + "\n Converted : " + nameForColor);
//        return nameForColor;
//    }


    public String[] getStatusHeader(TFLLineStatus line) {
        LineStatus lineStatus = line.getLineStatuses().get(0);
        String lineId = line.getId();
        String statusHeader = lineStatus.getStatusSeverityDescription();
        String statusDetail = "";
        if (lineStatus.getStatusSeverity() < 10) {//&& lineStatus.getValidityPeriods().get(0).getIsNow()
            statusDetail = lineStatus.getReason();
        } else {
            statusDetail = lineStatus.getStatusSeverityDescription();
        }
        String[] lineStatusDetail = {lineId, statusHeader, statusDetail};
        return lineStatusDetail;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvLineStatusHeader;
        private TextView tvStatusDetail;
        private LinearLayout expandableView;
        private TextView lineNameColor;
        private ItemOnClickInterface itemOnClickInterface;

        public ViewHolder(View itemView) {
            super(itemView);
            tvLineStatusHeader = (TextView) itemView.findViewById(R.id.tvLineStatus);
            tvStatusDetail = (TextView) itemView.findViewById(R.id.tvStatusDetail);
            expandableView = (LinearLayout) itemView.findViewById(R.id.llExpandableView);
            lineNameColor = (TextView) itemView.findViewById(R.id.tvLineNameColor);
            expandableView.setVisibility(View.GONE);
            itemView.setOnClickListener(this);
        }

        public void setOnItemClickInterface(ItemOnClickInterface itemOnClickInterface) {
            this.itemOnClickInterface = itemOnClickInterface;
        }


        @Override
        public void onClick(View v) {// FIXME: 22/01/16
            Log.i("ViewHolder", "Item number " + getLayoutPosition() + " is Clicked");
            if (expandableView.getVisibility() == View.GONE) {
                expand();
            } else {
                collapse();
//                animationDown(expandableView, expandableView.getHeight());

            }
            itemOnClickInterface.onItemClick(v, getLayoutPosition());
        }

        /**
         * Animation for dropdown
         ***/

        private void expand() {
            //set Visible
            expandableView.setVisibility(View.VISIBLE);

            int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(expandableView.getHeight(), View.MeasureSpec.UNSPECIFIED);
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
                    expandableView.requestLayout();
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

        //Animation for devices with kitkat and below
        public void animationDown(final LinearLayout billChoices, int originalHeight) {

            // Declare a ValueAnimator object
            ValueAnimator valueAnimator;
            if (!billChoices.isShown()) {
                billChoices.setVisibility(View.VISIBLE);
                billChoices.setEnabled(true);
                valueAnimator = ValueAnimator.ofInt(0, originalHeight + originalHeight); // These values in this method can be changed to expand however much you like
            } else {
                valueAnimator = ValueAnimator.ofInt(originalHeight + originalHeight, 0);

                Animation a = new AlphaAnimation(1.00f, 0.00f); // Fade out

                a.setDuration(200);
                // Set a listener to the animation and configure onAnimationEnd
                a.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        billChoices.setVisibility(View.INVISIBLE);
                        billChoices.setEnabled(false);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                // Set the animation on the custom view
                billChoices.startAnimation(a);
            }
            valueAnimator.setDuration(200);
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    Integer value = (Integer) animation.getAnimatedValue();
                    billChoices.getLayoutParams().height = value.intValue();
                    billChoices.requestLayout();
                }
            });


            valueAnimator.start();
        }
    }

}
