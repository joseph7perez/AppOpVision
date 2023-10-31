package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.CallableStatement;
import java.sql.Connection;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CrearCuenta extends AppCompatActivity {

    private static conexionBD con= new conexionBD();

    private EditText correo;
    private TextInputEditText contraseña;
    private TextInputEditText confcontraseña;
    private MaterialButton crearcuentabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_cuenta);

        correo = findViewById(R.id.correo);
        contraseña = findViewById(R.id.contraseña);
        confcontraseña = findViewById(R.id.confcontraseña);
        crearcuentabtn = findViewById(R.id.crearcuentabtn);

        crearcuentabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String corr = correo.getText().toString();
                String contra = contraseña.getText().toString();
                String confcontra = confcontraseña.getText().toString();

                if (contra.equals(confcontra) && corr.contains("@")) {

                   // conexionBD dbHelper = new conexionBD(this);
                   // SQLiteDatabase db = dbHelper.getWritableDatabase();
                    Connection conn = null;

                    try {
                        conn = conexionBD.getConnection();
                        if (conn != null) {

                            String sql = "INSERT INTO usuarios (email, contraseña, conf_contra) VALUES (?, ?, ?)";
                            PreparedStatement preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setString(1, corr);
                            preparedStatement.setString(2, contra);
                            preparedStatement.setString(3, confcontra);
                            int rowsAffected = preparedStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Error en el registro", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        // Manejar errores de conexión a la base de datos
                    } finally {
                        try {
                            if (conn != null) {
                                conn.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    Intent intento1 = new Intent(CrearCuenta.this, MenuDesplegable.class);
                    startActivity(intento1);
                } else {

                    Toast.makeText(getApplicationContext(), "El correo es incorrecto o las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}