package kr.or.bukedu.kjh.calcurator;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewCalcList extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public class calcViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        calcViewHolder(View itemView){
            super(itemView);
            tv = itemView.findViewById(R.id.calcResult);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return 0;
    }
}
