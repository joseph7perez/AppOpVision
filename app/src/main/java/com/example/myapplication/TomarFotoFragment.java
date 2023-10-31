package com.example.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class TomarFotoFragment extends Fragment {

    ImageView foto;
    ImageButton abrirCamara;

    private static final int REQUEST_PERMISSION_CAMARA = 1;
    private static final int REQUEST_iMAGE_CAMARA = 11;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tomar_foto, container, false);

        foto = rootView.findViewById(R.id.foto);
        abrirCamara = rootView.findViewById(R.id.btntomarfoto);


        abrirCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ActivityCompat.checkSelfPermission( requireActivity(), Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                    irCamara();
                    } else {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION_CAMARA);
                    }

                } else {
                    irCamara();
                }
            }
        });
        return rootView;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_CAMARA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                irCamara();
            } else{
                Toast.makeText(requireContext(), "Necesita aceptar los permisos", Toast.LENGTH_SHORT).show();
            }

            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_iMAGE_CAMARA){
            if (resultCode == Activity.RESULT_OK){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                foto.setImageBitmap(bitmap);
                Log.i("TAG", "Result=>" + bitmap);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void irCamara(){
        Intent intentoCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intentoCamara.resolveActivity(getActivity().getPackageManager())!=null){
            startActivityForResult(intentoCamara, REQUEST_iMAGE_CAMARA);
        }
    }
}
