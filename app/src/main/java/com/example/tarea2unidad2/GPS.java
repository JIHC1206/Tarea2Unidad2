package com.example.tarea2unidad2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GPS extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        txtLatitud = findViewById(R.id.txt_latitud);
        txtLongitud = findViewById(R.id.txt_longitud);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
    txtLatitud.setText(""+latLng.latitude);
    txtLongitud.setText(""+latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
    txtLatitud.setText(""+latLng.latitude);
    txtLongitud.setText(""+latLng.longitude);
    }
    //-38.734671, -72.609912
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
    mMap=googleMap;
    this.mMap.setOnMapClickListener(this);
    this.mMap.setOnMapLongClickListener(this);
    LatLng Direccion = new LatLng(-38.734671, -72.609912);
    mMap.addMarker(new MarkerOptions().position(Direccion).title("Direccion Local"));
    mMap.moveCamera(CameraUpdateFactory.newLatLng(Direccion));
    }

}