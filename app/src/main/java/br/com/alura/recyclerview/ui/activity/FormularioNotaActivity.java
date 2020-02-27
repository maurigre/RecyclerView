package br.com.alura.recyclerview.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

import br.com.alura.recyclerview.R;
import br.com.alura.recyclerview.model.Nota;

public class FormularioNotaActivity extends AppCompatActivity {

    public static final String CHAVE_NOTA = "nota";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_nota);
        setTitle("Nova nota");
        Intent dadosRecebidos = getIntent();
        if (dadosRecebidos.hasExtra(CHAVE_NOTA)) {
            Nota notaRecebida = (Nota) dadosRecebidos.getSerializableExtra(CHAVE_NOTA);
            TextView titulo = findViewById(R.id.formulario_nota_titulo);
            TextView descricao = findViewById(R.id.formulario_nota_descricao);
            titulo.setText(notaRecebida.getTitulo());
            descricao.setText(notaRecebida.getDescricao());
        }
    }
}
