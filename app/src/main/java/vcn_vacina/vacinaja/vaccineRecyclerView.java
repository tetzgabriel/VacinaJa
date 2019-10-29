package vcn_vacina.vacinaja;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vcn_vacina.vacinaja.Data.Vaccines.Vaccine;
import vcn_vacina.vacinaja.mocks.MockedVaccines;
import vcn_vacina.vacinaja.ui.Appointment.AppointmentFragment;

public class vaccineRecyclerView
        extends RecyclerView.Adapter<vaccineRecyclerView.ViewHolder> {

    private final List<Vaccine> mValues;
    int lay;
    Fragment frag;
    ArrayList<Vaccine> auxliarVaccineList;

    public vaccineRecyclerView(List<Vaccine> items, int lt, Fragment frag) {
        mValues = items;
        lay = lt;
        this.frag = frag;
        auxliarVaccineList = new ArrayList<>();
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
        holder.name.setText(mValues.get(position).getName());
        holder.minimumAge.setText("Idade minima: " + mValues.get(position).getMinimunAge());
        holder.importance.setText("Importancia: " + mValues.get(position).getImportance());

        holder.itemView.setTag(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final TextView minimumAge;
        final TextView importance;

        @RequiresApi(api = Build.VERSION_CODES.N)
        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.VaccineName);
            minimumAge = view.findViewById(R.id.VaccineAge);
            importance = view.findViewById(R.id.VaccineImportance);
            if (lay == R.layout.to_buy_vaccine)
                view.findViewById(R.id.checkBox).setOnClickListener(vw -> {
                    if (((CheckBox) view.findViewById(R.id.checkBox)).isChecked()) {
                        ((AppointmentFragment) frag).setValue(MockedVaccines.findPriceByName(name.getText().toString()), MockedVaccines.findVaccineByName(name.getText().toString()));
                    } else {
                        ((AppointmentFragment) frag).setValue(MockedVaccines.findPriceByName(name.getText().toString()) * -1, MockedVaccines.findVaccineByName(name.getText().toString()));
                    }

                });
        }
    }
}