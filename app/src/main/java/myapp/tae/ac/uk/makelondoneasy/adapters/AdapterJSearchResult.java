package myapp.tae.ac.uk.makelondoneasy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.Journey;

/**
 * Created by Karma on 24/01/16.
 */
public class AdapterJSearchResult extends RecyclerView.Adapter<AdapterJSearchResult.ViewHolder> {
    private List<Journey> journeyOptions;
    private Context context;

    public AdapterJSearchResult(Context context, List<Journey> journeyOptions) {
        this.context = context;
        this.journeyOptions = journeyOptions;
    }

    @Override
    public AdapterJSearchResult.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jsearch_results_cardview_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterJSearchResult.ViewHolder holder, int position) {
        Journey journeyOption = journeyOptions.get(position);
        String startTime = getJOptionStartTime(journeyOption);
        String journeyDuration = journeyOption.getDuration() + "";
        String lineChangesDetail = getJOptionLineChangesDetail(journeyOption);
        String lineChangesCount = journeyOption.getLegs().size() + "";
        holder.journeyResultName.setText("Option " + (position + 1));
        holder.journeyResultStartValue.setText(startTime);
        holder.journeyResultDurationValue.setText(journeyDuration);
        holder.journeyLineChangesValue.setText(lineChangesCount);
        holder.journeyLineChangeDetail.setText(lineChangesDetail);


    }

    private String getJOptionLineChangesDetail(Journey journeyOption) {
        String lineChangesDetail = "";
        for (int i = 0; i < journeyOption.getLegs().size(); i++) {
            if (i == 0) {
                lineChangesDetail += journeyOption.getLegs().get(i).getInstruction().getDetailed() + "\n";
            } else if (i == journeyOption.getLegs().size() - 1) {
                lineChangesDetail += " And \n" + journeyOption.getLegs().get(i).getInstruction().getDetailed()+"\n";
            }
        }
        return lineChangesDetail;
    }

    @Override
    public int getItemCount() {
        return journeyOptions.size();
    }

    public String getJOptionStartTime(Journey journeyOption) {
        String journeyOptionStartTime = journeyOption.getStartDateTime();
        int dateTimeSeperatorIndex = journeyOptionStartTime.indexOf('T');
        return journeyOptionStartTime.substring(dateTimeSeperatorIndex + 1);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView journeyResultName, journeyResultStartValue, journeyResultDurationValue, journeyLineChangesValue,
                journeyLineChangeDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            journeyResultName = (TextView) itemView.findViewById(R.id.tvJSearchResultName);
            journeyResultDurationValue = (TextView) itemView.findViewById(R.id.tvJSearchResultDurationValue);
            journeyResultStartValue = (TextView) itemView.findViewById(R.id.tvJSearchResultStartValue);
            journeyLineChangesValue = (TextView) itemView.findViewById(R.id.tvJSearchResultChangesValue);
            journeyLineChangeDetail = (TextView) itemView.findViewById(R.id.tvJSearchResultChangesDetail);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
