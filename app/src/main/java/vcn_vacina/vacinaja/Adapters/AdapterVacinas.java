package vcn_vacina.vacinaja.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vcn_vacina.vacinaja.R;
import vcn_vacina.vacinaja.Vaccines.Vaccine;

public class AdapterVacinas  extends RecyclerView.Adapter{

    private ArrayList<Vaccine> vaccines;
    private MyOnItemClickListener myOnItemClickListener;

    public AdapterVacinas(ArrayList arrayList) {
        this.vaccines = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_vacinas, viewGroup, false);

        final NewHolder holder = new AdapterVacinas.NewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Vaccine vacinas = vaccines.get(position);
        System.out.println(vacinas);
        ((NewHolder) holder).onBind(vacinas);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (myOnItemClickListener != null) {
                    myOnItemClickListener.onMyItemLongClick(position);

                    return true;
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NewHolder extends RecyclerView.ViewHolder {

        private TextView nome;
        private ImageView imagem;

        public NewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.txtNomeVacina);
        }


        public void onBind(Vaccine vaccine) {
            nome.setText(vaccine.getName().toUpperCase());
        }
    }

    public interface MyOnItemClickListener {
        void onMyItemLongClick(int position);
    }

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }
}
