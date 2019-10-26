package vcn_vacina.vacinaja.ui.home;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.stream.Collectors;

import vcn_vacina.vacinaja.R;
import vcn_vacina.vacinaja.Vaccines.Vaccine;
import vcn_vacina.vacinaja.mocks.MockedVaccines;
import vcn_vacina.vacinaja.mocks.mockedUser;

public class HomeFragment extends Fragment {

    private boolean mTwoPane;


    View view;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
                ViewModelProviders.of(this).get(HomeViewModel.class);
        if (view == null)
            view = inflater.inflate(R.layout.fragment_home, container, false);

        ((ImageView)view.findViewById(R.id.UserImage)).setImageResource(mockedUser.usuarioMocado.getImage());
        ((TextView)view.findViewById(R.id.UserName)).setText(mockedUser.usuarioMocado.getNome());
        ((TextView)view.findViewById(R.id.UserBirth)).setText(mockedUser.usuarioMocado.getIdade() + " Anos");
        ((TextView)view.findViewById(R.id.UserBloodType)).setText("Tipo sanguineo" + mockedUser.usuarioMocado.getBloodType());
        ((CompactCalendar) view.findViewById(R.id.calendarView)).Event()

        View recyclerView = view.findViewById(R.id.item_list);
        if (recyclerView != null)
            setupRecyclerView((RecyclerView) recyclerView);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new vaccineRecyclerView(MockedVaccines.getMockedVaccine().stream().filter(vac -> vac.getStatus()).collect(Collectors.toList())));
    }



    public static class vaccineRecyclerView
            extends RecyclerView.Adapter<vaccineRecyclerView.ViewHolder> {

        private final List<Vaccine> mValues;

        vaccineRecyclerView(List<Vaccine> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.vaccine_list_content, parent, false);
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

            ViewHolder(View view) {
                super(view);
                name = view.findViewById(R.id.VaccineName);
                minimumAge = view.findViewById(R.id.VaccineAge);
                importance = view.findViewById(R.id.VaccineImportance);
            }
        }


    }

}