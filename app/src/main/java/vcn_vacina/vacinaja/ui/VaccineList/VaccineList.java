package vcn_vacina.vacinaja.ui.VaccineList;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vcn_vacina.vacinaja.R;
import vcn_vacina.vacinaja.Vaccines.Vaccine;
import vcn_vacina.vacinaja.mocks.MockedVaccines;
import vcn_vacina.vacinaja.vaccineRecyclerView;

public class VaccineList extends Fragment {

    View root;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (root == null)
            root = inflater.inflate(R.layout.fragment_vaccine_list, container, false);

        View recyclerView = root.findViewById(R.id.buyable);
        if (recyclerView != null)
            setupRecyclerView((RecyclerView) recyclerView, MockedVaccines.getMockedVaccine());

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupRecyclerView(@NonNull RecyclerView recyclerView, List<Vaccine> list) {
        recyclerView.setAdapter(new vaccineRecyclerView(list, R.layout.vaccine_list_content, this));
    }
}