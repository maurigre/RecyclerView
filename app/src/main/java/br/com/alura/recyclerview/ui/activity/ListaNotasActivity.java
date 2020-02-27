package br.com.alura.recyclerview.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import br.com.alura.recyclerview.R;
import br.com.alura.recyclerview.dao.NotaDAO;
import br.com.alura.recyclerview.model.Nota;
import br.com.alura.recyclerview.ui.recyclerview.adapter.ListaNotasAdapter;
import br.com.alura.recyclerview.ui.recyclerview.adapter.listener.OnItemClickListener;

public class ListaNotasActivity extends AppCompatActivity {

    private static final String TAG = "ListaNotasActivity";
    public static final String CHAVE_NOTA = "nota";
    private static List<Nota> notas = new ArrayList<>();
    private NotaDAO dao = new NotaDAO();
    private ListaNotasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        //geraNotasDeTeste();
        //Log.i(TAG, "onCreate: " + pegaTodasNotas().toString());
        configuraRecycleView();

    }

    private void configuraRecycleView() {
        RecyclerView listaNotasRecycleView = findViewById(R.id.activity_lista_notas_rv);
        configuraAdapter(listaNotasRecycleView);
    }

    private void configuraAdapter(RecyclerView listaNotasRecycleView) {
        List<Nota> todasNotas = pegaTodasNotas();
        adapter = new ListaNotasAdapter(this, todasNotas);
        listaNotasRecycleView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onitemclick(Nota nota) {
                Intent abreFormularioComNota = new Intent(ListaNotasActivity.this, FormularioNotaActivity.class);
                abreFormularioComNota.putExtra(CHAVE_NOTA, nota);
                startActivityForResult(abreFormularioComNota,2);
            }
        });

    }

    private List<Nota> pegaTodasNotas() {
        geraNotasDeTeste();
        return dao.todos();
    }

    private void geraNotasDeTeste() {
        for (int i = 0; i < 9; i++) {
            dao.insere(new Nota("Titulo " + (i + 1), "Descricao " + (i + 1)));
        }
    }
}
