package myapp.tae.ac.uk.makelondoneasy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import myapp.tae.ac.uk.makelondoneasy.R;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.DeparturePoint;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.Journey;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.Leg;
import myapp.tae.ac.uk.makelondoneasy.model.tofromJourney.StopPoint;
import myapp.tae.ac.uk.makelondoneasy.ui.extra.LineColors;

/**
 * Created by Karma on 26/01/16.
 */
public class AdapterJSearchDirText extends RecyclerView.Adapter<AdapterJSearchDirText.ViewHolder> {
    private Context context;
    private Journey journeyOption;
    private List<StopPoint> journeyStops = null;
    private DeparturePoint journeyStartPoint = null;

    public AdapterJSearchDirText(Context context, Journey journeyOption) {
        this.context = context;
        this.journeyOption = journeyOption;
        if (journeyOption != null) {
            journeyStartPoint = journeyOption.getLegs().get(0).getDeparturePoint();
            journeyStops = getAllJOptionStops(journeyOption);
        }
    }

    private List<StopPoint> getAllJOptionStops(Journey journeyOption) {
        List<StopPoint> stops = new ArrayList<>();
        StopPoint startPoint = createPointForStart(journeyStartPoint);
        stops.add(startPoint);
        Leg journeyChange;
        String lineName;
        StopPoint tempStopPoint;
        for (int i = 0; i < journeyOption.getLegs().size(); i++) {
            journeyChange = journeyOption.getLegs().get(i);
            lineName = journeyChange.getRouteOptions().get(0).getLineIdentifier().getName();
            for (int j = 0; j < journeyChange.getPath().getStopPoints().size(); j++) {
                tempStopPoint = journeyOption.getLegs().get(i).getPath().getStopPoints().get(j);
                tempStopPoint.setLine(lineName);
                stops.add(tempStopPoint);
            }
        }
        return stops;
    }

    private StopPoint createPointForStart(DeparturePoint journeyStartPoint) {
        StopPoint stopPoint = new StopPoint();
        stopPoint.set$type(journeyStartPoint.get$type());
        stopPoint.setId(journeyStartPoint.getNaptanId());
        stopPoint.setName(journeyStartPoint.getCommonName());
        stopPoint.setUri("/StopPoint/" + journeyStartPoint.getNaptanId());
        stopPoint.setLine(journeyOption.getLegs().get(0).getRouteOptions().get(0).getLineIdentifier().getId());
        return stopPoint;
    }

    @Override
    public AdapterJSearchDirText.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jsearch_direction_text_cardview_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterJSearchDirText.ViewHolder holder, int position) {
        StopPoint stop = journeyStops.get(position);
        int colors[] = LineColors.getTextLineColors(context, stop.getLine());
        holder.tvDirStopPointName.setBackgroundColor(colors[0]);
        holder.tvDirStopPointName.setTextColor(colors[1]);
    }

    @Override
    public int getItemCount() {
        int size = getItemSize();
        return size;
    }

    public int getItemSize() {
        int itemSize = 0;
        int startPoint = 1;
        if (journeyStops != null) {
            itemSize = journeyStops.size() + startPoint;
        }
        return itemSize;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDirStopPointName, tvDirLine, tvDirLineStopInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDirStopPointName = (TextView) itemView.findViewById(R.id.tvDirStopPointName);
            tvDirLine = (TextView) itemView.findViewById(R.id.tvDirLineArror);
            tvDirLineStopInfo = (TextView) itemView.findViewById(R.id.tvDirLineStopInfo);
        }
    }
}
