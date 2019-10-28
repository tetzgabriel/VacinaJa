package vcn_vacina.vacinaja.ui.VaccineList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import vcn_vacina.vacinaja.R;

public class VaccineList extends Fragment {

    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if(root == null)
            root = inflater.inflate(R.layout.fragment_vaccine_list, container, false);
        return root;
    }
}