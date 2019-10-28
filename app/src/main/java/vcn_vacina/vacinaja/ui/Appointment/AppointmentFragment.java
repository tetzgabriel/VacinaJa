package vcn_vacina.vacinaja.ui.Appointment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import vcn_vacina.vacinaja.MainActivity;
import vcn_vacina.vacinaja.R;
import vcn_vacina.vacinaja.Vaccines.Vaccine;
import vcn_vacina.vacinaja.mocks.MockedVaccines;
import vcn_vacina.vacinaja.ui.home.HomeFragment;
import vcn_vacina.vacinaja.vaccineRecyclerView;

public class AppointmentFragment extends Fragment {

    View root;
    Long dataFInal;
    float value;
    static ArrayList<Vaccine> auxliarVaccineList;
    HomeFragment fragment;

    public AppointmentFragment(Long data, HomeFragment fragment) {
        dataFInal = data;
        auxliarVaccineList = new ArrayList<>();
        this.fragment = fragment;
    }

    public AppointmentFragment(HomeFragment fragment) {
        dataFInal = null;
        auxliarVaccineList = new ArrayList<>();
        this.fragment = fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (root == null)
            root = inflater.inflate(R.layout.fragment_appointment, container, false);

        CompactCalendarView comp = root.findViewById(R.id.CompraCalendarView);
        if (dataFInal != null)
            comp.setCurrentDate(new Date(dataFInal));

        View recyclerView = root.findViewById(R.id.buyable);
        value = 0;
        if (recyclerView != null)
            setupRecyclerView((RecyclerView) recyclerView);

        root.findViewById(R.id.btnGoMaterial).setOnClickListener(v -> {
            if (auxliarVaccineList.isEmpty()) {
                Snackbar.make(v, "Escolha uma Vacina", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            } else {
                MockedVaccines.mockedVaccineTaken.addAll(auxliarVaccineList);
                fragment.createEvent(dataFInal, auxliarVaccineList.stream().map(Vaccine::getName).reduce((v1, v2) -> v1 + "\n" + v2).orElse(""));
                auxliarVaccineList.clear();
                value = 0;
                ((TextView) Objects.requireNonNull(getView()).findViewById(R.id.finalValue)).setText(String.valueOf(value));
                ((MainActivity) Objects.requireNonNull(getActivity())).makeHome();
            }

        });

        return root;
    }

    public void setValue(float plus, Vaccine vaccine) {
        value += plus;
        ((TextView) Objects.requireNonNull(getView()).findViewById(R.id.finalValue)).setText(String.valueOf(value));
        if (plus > 0)
            auxliarVaccineList.add(vaccine);
        else
            auxliarVaccineList.remove(vaccine);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        List<Vaccine> aux = new ArrayList<>();
        MockedVaccines.mockedVaccine.forEach(vaccine -> {
            if (!MockedVaccines.mockedVaccineTaken.contains(vaccine)) {
                aux.add(vaccine);
            }
        });

        recyclerView.setAdapter(new vaccineRecyclerView(aux, R.layout.to_buy_vaccine, this));
    }
}