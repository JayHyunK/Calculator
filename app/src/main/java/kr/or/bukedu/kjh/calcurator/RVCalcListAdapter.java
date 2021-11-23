package kr.or.bukedu.kjh.calcurator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVCalcListAdapter extends RecyclerView.Adapter <RVCalcListAdapter.ViewHolder>{
    private ArrayList<String> data = null;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        TextView tvr;
        ViewHolder(View itemView){
            super(itemView);
            tv = itemView.findViewById(R.id.calcResultProcess);
            tvr = itemView.findViewById(R.id.calcResult);
        }
    }

    RVCalcListAdapter(ArrayList<String> list){
        data = list;
    }

    // onCreateVieHolder()
    @Override
    public RVCalcListAdapter.ViewHolder onCreateViewHolder(ViewGroup p, int viewType){
        Context ctx = p.getContext();
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.claclist_items, p, false);
        RVCalcListAdapter.ViewHolder vh = new RVCalcListAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RVCalcListAdapter.ViewHolder holder, int position) {
        String txt = data.get(position);
        String[] arr = txt.split("#");
        holder.tv.setText(arr[0]);
        holder.tvr.setText(arr[1]);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
