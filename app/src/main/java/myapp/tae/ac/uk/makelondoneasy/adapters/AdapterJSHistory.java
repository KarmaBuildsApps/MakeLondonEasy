package myapp.tae.ac.uk.makelondoneasy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

import java.util.List;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.api.ItemOnClickInterface;
import myapp.tae.ac.uk.makelondoneasy.data.DJourney;
import myapp.tae.ac.uk.makelondoneasy.ui.JSHistory;

/**
 * Created by Karma on 28/01/16.
 */
public class AdapterJSHistory extends RecyclerView.Adapter<AdapterJSHistory.ViewHolder> {
    private List<DJourney> histories;
    private Context context;

    public AdapterJSHistory(Context context, List<DJourney> histories) {
        this.context = context;
        this.histories = histories;
    }

    @Override
    public AdapterJSHistory.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jsearch_history_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DJourney history = histories.get(position);
        String journeyName = history.getFromPlace().getName() + "\n to \n" + history.getToPlace().getName();
        holder.historyJourneyName.setText(journeyName);
        holder.historyJourneyDate.setText(history.getDate());
        holder.setOnClickInterface(new ItemOnClickInterface() {
            @Override
            public void onItemClick(View view, int pos) {
                histories.remove(pos);
                ((JSHistory) context).rmJHistoryItem(history.getId());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SwipeLayout swipeLayout;
        private ImageView ivDelete;
        private TextView historyJourneyName, historyJourneyDate;
        private ItemOnClickInterface onClickInterface;

        public ViewHolder(View itemView) {
            super(itemView);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.slJSHistory);
            ivDelete = (ImageView) itemView.findViewById(R.id.ivJSHistoryDelete);
            historyJourneyDate = (TextView) itemView.findViewById(R.id.tvJSHistoryJourneyInfo);
            historyJourneyDate = (TextView) itemView.findViewById(R.id.tvJSHistoryJourneyDate);
            ivDelete.setOnClickListener(this);
            swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
                @Override
                public void onClose(SwipeLayout layout) {
                    //when the SurfaceView totally cover the BottomView.
                }

                @Override
                public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                    //you are swiping.
                }

                @Override
                public void onStartOpen(SwipeLayout layout) {

                }

                @Override
                public void onOpen(SwipeLayout layout) {
                    //when the BottomView totally show.
                }

                @Override
                public void onStartClose(SwipeLayout layout) {

                }

                @Override
                public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                    //when user's hand released.
                }
            });
        }

        public void setOnClickInterface(ItemOnClickInterface onClickInterface) {
            this.onClickInterface = onClickInterface;
        }

        @Override
        public void onClick(View v) {
            onClickInterface.onItemClick(v, getLayoutPosition());
        }
    }
}
