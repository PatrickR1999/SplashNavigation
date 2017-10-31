package com.example.nav;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EmailFragment extends Fragment {

    EditText editEmail, editSubject, editMessage; // Muutuja editEmail, editSubject, editMessage lisamine
    Button btn_Send; // Muutuja btn_send lisamine

    public EmailFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) { // Meetod

        View view = inflater.inflate(R.layout.fragment_email, container, false);

        editEmail = (EditText) view.findViewById(R.id.editEmail); //Otsib EditText editEmaili ID projektist üles
        editSubject = (EditText) view.findViewById(R.id.editSubject); //Otsib EditText editSubjecti ID projektist üles
        editMessage = (EditText) view.findViewById(R.id.editMessage); //Otsib EditText editMessage ID projektist üles
        btn_Send = (Button) view.findViewById(R.id.btn_send); //Otsib nupu btn_sendi ID projektist üles
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = editEmail.getText().toString(); //Võtab editEmaililt teksti ja muudab selle Stringiks
                String subject = editSubject.getText().toString(); //Võtab editSubjectilt teksti ja muudab selle Stringiks
                String message = editMessage.getText().toString(); //Võtab editMessagelt teksti ja muudab selle Stringiks

                Intent intent = new Intent(Intent.ACTION_SEND); // Selle koodireaga teeb uue intenti, millega tuleb valik appidest emaili saatmiseks
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                intent.setType("message/rfc822"); // Muudab intenti tüübiks "message/rfc822"

                startActivity(Intent.createChooser(intent, "Select Email app")); // Avab valiku, saad valida sobiva appi emaili saatmiseks, nt gmail
            }
        });
        return view; // Tagastab view
    }
}

