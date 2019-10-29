package vcn_vacina.vacinaja.ui.historic;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vcn_vacina.vacinaja.Data.Appointment.Appointment;
import vcn_vacina.vacinaja.Data.Vaccines.Vaccine;
import vcn_vacina.vacinaja.R;

public class HistoricRecyclerView
        extends RecyclerView.Adapter<HistoricRecyclerView.ViewHolder> {

    private final List<Appointment> mValues;
    int lay;
    Fragment frag;
    ArrayList<Appointment> appointment;

    public HistoricRecyclerView(List<Appointment> items, int lt, Fragment frag) {
        mValues = items;
        lay = lt;
        this.frag = frag;
        appointment = new ArrayList<>();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(lay, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.local.setText(mValues.get(position).getLocal());
        holder.dia.setText(mValues.get(position).getData());
        holder.horario.setText(mValues.get(position).getHorarios());
        holder.vacinas.setText(mValues.get(position).getVaccines());

        holder.itemView.setTag(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView local;
        final TextView dia;
        final TextView horario;
        final TextView vacinas;

        @RequiresApi(api = Build.VERSION_CODES.N)
        ViewHolder(View view) {
            super(view);
            local = view.findViewById(R.id.local);
            dia = view.findViewById(R.id.dia);
            horario = view.findViewById(R.id.horario);
            vacinas = view.findViewById(R.id.vacinas);
        }
    }
}