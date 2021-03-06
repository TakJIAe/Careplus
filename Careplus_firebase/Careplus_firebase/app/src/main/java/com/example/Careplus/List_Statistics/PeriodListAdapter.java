package com.example.Careplus.List_Statistics;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Careplus.AddMedicin.AddPeriodInfo;
import com.example.Careplus.R;

import java.util.ArrayList;

public class PeriodListAdapter extends RecyclerView.Adapter<PeriodListAdapter.MainViewHolder> {
    private ArrayList<AddPeriodInfo> mDataset2;
    private Activity activity;
    static int nowValue1 ;
    static int value1;

    class MainViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ProgressBar bar;
        Button periodeat;

        MainViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public PeriodListAdapter(Activity activity, ArrayList<AddPeriodInfo> myDataset2) {
        this.mDataset2 = myDataset2;
        this.activity = activity;


    }
    @Override
    public int getItemViewType(int position){
        return position;
    }

    @NonNull
    @Override
    public PeriodListAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_period, parent, false);
        
        final MainViewHolder mainViewHolder = new MainViewHolder(cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView periodnameTextView = cardView.findViewById(R.id.name_medicin_text_period);
        TextView periodkindTextView = cardView.findViewById(R.id.kind_medicin_text_period);
        TextView periodstartTextView = cardView.findViewById(R.id.start_medicin_text_period);
        TextView periodcycleTextView = cardView.findViewById(R.id.medicin_text_period_cycle);
        TextView timeTextView4 = cardView.findViewById(R.id.medicin_time_text4);
        TextView timeTextView5 = cardView.findViewById(R.id.medicin_time_text5);
        TextView timeTextView6 = cardView.findViewById(R.id.medicin_time_text6);

        AddPeriodInfo userInfo2 = mDataset2.get(position);

        periodnameTextView.setText(userInfo2.get?????????());
        periodkindTextView.setText(userInfo2.get?????????());
        periodstartTextView.setText(userInfo2.get??????????????????());
        periodcycleTextView.setText(userInfo2.get????????????());
        timeTextView4.setText(userInfo2.get??????1());
        timeTextView5.setText(userInfo2.get??????2());
        timeTextView6.setText(userInfo2.get??????3());

    }

    @Override
    public int getItemCount() {
        return mDataset2.size();
    }
}