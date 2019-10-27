package vcn_vacina.vacinaja.ui.VaccineList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vcn_vacina.vacinaja.Adapters.AdapterVacinas;
import vcn_vacina.vacinaja.MainActivity;
import vcn_vacina.vacinaja.R;
import vcn_vacina.vacinaja.mocks.MockedVaccines;

public class VaccineList extends Fragment {

    private GalleryViewModel galleryViewModel;
    View root;
    private View view;
    private RecyclerView mRecyclerView;
    private AdapterVacinas adapterVacinas;
    private MockedVaccines vaccines = new MockedVaccines();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        if(root == null)
            root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        mRecyclerView = root.findViewById(R.id.recycleVacinas);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));

        adapterVacinas = new AdapterVacinas(new ArrayList(vaccines.mockedVaccine));

        adapterVacinas.setMyOnItemClickListener(position -> ((MainActivity) getActivity()).showReceita(position));

        mRecyclerView.setAdapter(adapterVacinas);



        return root;
    }
}