package com.if5b.UAS_Goffice.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.if5b.UAS_Goffice.R;

public class FeedbackFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private EditText email, feedback;
    private Button submit;
    private String subject;

    public FeedbackFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */

    public static FeedbackFragment newInstance(String param1, String param2) {
        FeedbackFragment fragment = new FeedbackFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_feedback, container, false);
        email = rootView.findViewById(R.id.et_email);
        feedback = rootView.findViewById(R.id.et_feedback);
        submit = rootView.findViewById(R.id.btn_submit);
        subject = "Feedback Goffice";

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ourEmail = email.getText().toString();
                String Feedback = feedback.getText().toString();
                String Subject = subject.toString();
                String[] emailDivide = {"kgsmammaryazid@mhs.mdp.ac.id ivanlaksono@mhs.mdp.ac.id mredhosaputra@mhs.mdp.ac.id "};

                Intent send = new Intent(Intent.ACTION_SEND);
                send.putExtra(Intent.EXTRA_EMAIL, emailDivide);
                send.putExtra(Intent.EXTRA_TEXT, Feedback);
                send.putExtra(Intent.EXTRA_SUBJECT, Subject);
                send.setType("message/rfc822");
                send.setPackage("com.google.android.gm");
                startActivity(send);
            }
        });
        return rootView;
    }

}
