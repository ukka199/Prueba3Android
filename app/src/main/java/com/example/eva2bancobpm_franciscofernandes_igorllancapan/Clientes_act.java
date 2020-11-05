package com.example.eva2bancobpm_franciscofernandes_igorllancapan;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;


public class Clientes_act extends AppCompatActivity {

    private EditText edcodigo, ednombre, edsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        edcodigo = (EditText) findViewById(R.id.et_codigo);
        ednombre = (EditText) findViewById(R.id.et_nombre);
        edsalario = (EditText) findViewById(R.id.et_salario);
    }

    public void GuardarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if (!edcodigo.getText().toString().isEmpty()) {
            ContentValues cont = new ContentValues();

            cont.put("codigo", edcodigo.getText().toString());
            cont.put("nombre", ednombre.getText().toString());
            cont.put("salario", edsalario.getText().toString());

            db.insert("clientes", null, cont);
            db.close();

            Toast.makeText(this, "Has guardado un cliente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debe ingresar el codigo del Cliente", Toast.LENGTH_SHORT).show();
        }

    }

    public void MostrarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if (!codigo.isEmpty()) {
            Cursor fila = db.rawQuery("SELECT codigo, nombre, salario FROM clientes WHERE codigo=" + codigo, null);

            if (fila.moveToFirst()) {
                edcodigo.setText(fila.getString(0));
                ednombre.setText(fila.getString(1));
                edsalario.setText(fila.getString(2));
            } else {
                Toast.makeText(this, "No hay campos en la tabla Clientes", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "No hay Clientes con el codigo asociado", Toast.LENGTH_SHORT).show();
        }

    }

    public void EliminarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        db.delete("clientes", "codigo=" + codigo, null);
        db.close();

        Toast.makeText(this, "Has eliminado a un Cliente", Toast.LENGTH_SHORT).show();
    }

    public void ModificarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", edcodigo.getText().toString());
        cont.put("nombre", ednombre.getText().toString());
        cont.put("salario", edsalario.getText().toString());

        if (!codigo.isEmpty()) {
            db.update("clientes", cont, "codigo=" + codigo, null);
            db.close();

            Toast.makeText(this, "Ha actualizado un Cliente", Toast.LENGTH_SHORT).show();
        }
    }
}