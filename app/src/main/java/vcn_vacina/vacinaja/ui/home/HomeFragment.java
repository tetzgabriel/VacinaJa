package vcn_vacina.vacinaja.ui.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.Date;
import java.util.Objects;

import vcn_vacina.vacinaja.MainActivity;
import vcn_vacina.vacinaja.R;
import vcn_vacina.vacinaja.mocks.MockedVaccines;
import vcn_vacina.vacinaja.mocks.mockedUser;
import vcn_vacina.vacinaja.vaccineRecyclerView;

public class HomeFragment extends Fragment {

    View view;
    CompactCalendarView calendar;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewModelProviders.of(this).get(HomeViewModel.class);
        if (view == null)
            view = inflater.inflate(R.layout.fragment_home, container, false);

        ((ImageView) view.findViewById(R.id.UserImage)).setImageResource(mockedUser.usuarioMocado.getImage());
        ((TextView) view.findViewById(R.id.UserName)).setText(mockedUser.usuarioMocado.getNome());
        ((TextView) view.findViewById(R.id.UserBirth)).setText(mockedUser.usuarioMocado.getIdade() + " Anos");
        ((TextView) view.findViewById(R.id.UserBloodType)).setText("Tipo sanguineo" + mockedUser.usuarioMocado.getBloodType());
        calendar = view.findViewById(R.id.calendarView);
        Button vacinas = view.findViewById(R.id.btn_Vac_disp);
        vacinas.setOnClickListener(vw -> ((MainActivity) Objects.requireNonNull(getActivity())).makeVacList());
        Button consultas = view.findViewById(R.id.btn_consut_hist);
        consultas.setOnClickListener(vw -> ((MainActivity) Objects.requireNonNull(getActivity())).makeConsult());
        HomeFragment rh = this;
        calendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                if(calendar.getEvents(dateClicked).isEmpty())
                    ((MainActivity) Objects.requireNonNull(getActivity())).makeAppointment(dateClicked.getTime(), rh);
                else
                    Toast.makeText(getContext(), calendar.getEvents(dateClicked).stream().map(Event::getData).reduce((v1, v2) -> v1 +""+ v2).orElse("").toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });


        View recyclerView = view.findViewById(R.id.item_list);
        if (recyclerView != null)
            setupRecyclerView((RecyclerView) recyclerView);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new vaccineRecyclerView(MockedVaccines.mockedVaccineTaken, R.layout.vaccine_list_content, this));
    }

    public void createEvent(Long eventDay, String description) {
        calendar.addEvent(new Event(Color.YELLOW, eventDay, description));
    }


}