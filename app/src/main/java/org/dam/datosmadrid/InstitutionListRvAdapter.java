package org.dam.datosmadrid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.dam.datosmadrid.retrofitdata.Graph;

import java.util.ArrayList;

public class InstitutionListRvAdapter
        extends RecyclerView.Adapter<InstitutionListRvAdapter.InstitutionHolder> {
    private final ArrayList<Graph> institutionList;
    private final View.OnClickListener listener;

    public InstitutionListRvAdapter(ArrayList<Graph> institutionList,
                                    View.OnClickListener listener) {
        this.institutionList = institutionList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public InstitutionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_institution_item, parent, false);
        v.setOnClickListener(listener);
        return new InstitutionHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InstitutionHolder holder, int position) {
        Graph item = institutionList.get(position);
        holder.getTextViewInstitutionName().setText(item.getTitle());
        if (item.getAddress() != null)
            holder.getTextViewAddress().setText(item.getAddress().toString());
        else
            holder.getTextViewAddress().setText(R.string.str_nodir);
    }

    @Override
    public int getItemCount() {
        return institutionList.size();
    }

    public static class InstitutionHolder extends RecyclerView.ViewHolder {
        private final TextView textViewInstitutionName;
        private final TextView textViewAddress;

        public InstitutionHolder(@NonNull View itemView) {
            super(itemView);
            textViewInstitutionName = itemView.findViewById(R.id.textViewInstitutionName);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
        }

        public TextView getTextViewInstitutionName() {
            return textViewInstitutionName;
        }

        public TextView getTextViewAddress() {
            return textViewAddress;
        }
    }
}
