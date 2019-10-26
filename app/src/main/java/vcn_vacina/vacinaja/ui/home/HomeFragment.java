package vcn_vacina.vacinaja.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vcn_vacina.vacinaja.R;
import vcn_vacina.vacinaja.Vaccines.Vaccine;
import vcn_vacina.vacinaja.mocks.mockedUser;

import static vcn_vacina.vacinaja.mocks.mockedVaccines.mockedVaccine;

public class HomeFragment extends Fragment {

    private boolean mTwoPane;


    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
                ViewModelProviders.of(this).get(HomeViewModel.class);
        if (view == null)
            view = inflater.inflate(R.layout.fragment_home, container, false);

        ((ImageView)view.findViewById(R.id.UserImage)).setImageResource(mockedUser.usuarioMocado.getImage());
        ((TextView)view.findViewById(R.id.UserName)).setText(mockedUser.usuarioMocado.getNome());
        ((TextView)view.findViewById(R.id.UserBirth)).setText(mockedUser.usuarioMocado.getIdade());
        ((TextView)view.findViewById(R.id.UserBloodType)).setText(mockedUser.usuarioMocado.getBloodType());

        View recyclerView = view.findViewById(R.id.item_list);
        assert recyclerView != null;
//        setupRecyclerView((RecyclerView) recyclerView);

        return view;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        List<Vaccine> goodStatus = new ArrayList<>();

        recyclerView.setAdapter(new vaccineRecyclerView(this, mockedVaccine, true));
    }



    public static class vaccineRecyclerView
            extends RecyclerView.Adapter<vaccineRecyclerView.ViewHolder> {

        private final HomeFragment mParentActivity;
        private final List<Vaccine> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //todo onclick
            }
        };

        vaccineRecyclerView(HomeFragment parent,
                            List<Vaccine> items,
                            boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.vaccine_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.name.setText(mValues.get(position).getName());
            holder.minimumAge.setText(mValues.get(position).getMinimunAge());
            holder.importance.setText(mValues.get(position).getImportance());

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
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
                name = (TextView) view.findViewById(R.id.VaccineName);
                minimumAge = (TextView) view.findViewById(R.id.VaccineAge);
                importance = (TextView) view.findViewById(R.id.VaccineImportance);
            }
        }


    }

}