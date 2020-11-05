package com.example.eva2bancobpm_franciscofernandes_igorllancapan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Prestamo_act extends AppCompatActivity {

    private Spinner spinCliente, spinCredito;
    private TextView text;
    private Button calcularPrestamos, calcularDeudas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo_act);

        spinCliente = (Spinner)findViewById(R.id.spnClientes);
        spinCredito = (Spinner)findViewById(R.id.spnCreditos);

        text = (TextView)findViewById(R.id.tv1);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");


        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);

        spinCliente.setAdapter(adapt);
        spinCredito.setAdapter(adapts);
    }

    public void CalcularPrestamo(View v) {

        //CLIENTES Y CREDITOS BOTON CALCULAR PRESTAMO
        String cliente = spinCliente.getSelectedItem().toString();
        String credito = spinCredito.getSelectedItem().toString();

        Planes plan = new Planes();

        if (cliente.equals("Axel") && credito.equals("Credito Hipotecario"))
        {
            text.setText("El saldo total del prestamo es: "+plan.getSaldoAxelHipo());
        }

        if (cliente.equals("Roxana") && credito.equals("Credito Hipotecario"))
        {
            text.setText("El saldo total del prestamo es: "+plan.getSaldoRoxanaHipo());
        }

        if (cliente.equals("Axel") && credito.equals("Credito Automotriz"))
        {
            text.setText("El saldo total del prestamo es: "+plan.getSaldoAxelAuto());
        }

        if (cliente.equals("Roxana") && credito.equals("Credito Automotriz"))
        {
            text.setText("El saldo total del prestamo es: "+plan.getSaldoRoxanaAuto());
        }

    }
    public void CalcularDeudas(View v)
    {
        //CLIENTES Y CREDITOS BOTON DEUDAS
        String cliente = spinCliente.getSelectedItem().toString();
        String credito = spinCredito.getSelectedItem().toString();

        Planes plan = new Planes();

        if (cliente.equals("Axel") && credito.equals("Credito Hipotecario"))
        {
            text.setText("Su deuda hipotecaria en 12 cuotas es de: "+plan.getDeudasAxelHipo());
        }

        if (cliente.equals("Roxana") && credito.equals("Credito Hipotecario"))
        {
            text.setText("Su deuda hipotecaria en 12 cuotas es de: "+plan.getDeudasRoxanaHipo());
        }

        if (cliente.equals("Axel") && credito.equals("Credito Automotriz"))
        {
            text.setText("Su deuda automotriz en 8 cuotas es de: "+plan.getDeudasAxelAuto());
        }

        if (cliente.equals("Roxana") && credito.equals("Credito Automotriz"))
        {
            text.setText("Su deuda automotriz en 8 cuotas es de: "+plan.getDeudasRoxanaAuto());
        }

    }
}