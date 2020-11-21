package com.example.parcialacostadam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.parcialacostadam.R.*;

public class MainActivity extends AppCompatActivity {

    Button listar, guardar;
    RadioButton activo;
    TextView idempleado;
    EditText nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

         activo = findViewById(id.activo);
         listar = findViewById(id.listar);
         guardar = findViewById(id.guardar);
         idempleado = findViewById(id.IdEmpleado);
         nombre = findViewById(id.nombre);
         apellido = findViewById(id.apellido);

         guardar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 alta(idempleado.getText().toString(), nombre, apellido, activo.isChecked());
             }});

    }

    public void alta(String IdEmpleado, EditText nombre, EditText apellido, boolean activo) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nombre_string = nombre.getText().toString();
        String apellido_string = apellido.getText().toString();
        ContentValues empleado = new ContentValues();
        empleado.put("idempleado", IdEmpleado);
        empleado.put("nombre", nombre_string);
        empleado.put("apellido", apellido_string);
        empleado.put("activo", activo);
        bd.insert("empleado", null, empleado);
        bd.close();

        Toast.makeText(this, "Se cargaron los datos del empleado",
                Toast.LENGTH_SHORT).show();
    }


}