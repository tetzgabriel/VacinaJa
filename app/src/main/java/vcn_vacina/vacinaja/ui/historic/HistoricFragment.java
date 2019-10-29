package vcn_vacina.vacinaja.ui.historic;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import vcn_vacina.vacinaja.R;
import vcn_vacina.vacinaja.mocks.mockAptHist;

public class HistoricFragment extends Fragment {

    View root;


    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (root == null)
            root = inflater.inflate(R.layout.fragment_send, container, false);

        View recyclerView = root.findViewById(R.id.cts);
        if (recyclerView != null)
            setupRecyclerView((RecyclerView) recyclerView);

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {


        recyclerView.setAdapter(new HistoricRecyclerView(mockAptHist.mockedHistory, R.layout.historic_list, this));
    }
}