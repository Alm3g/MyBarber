package com.example.mybarber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
EditText displayName,Email,Password,ConfirmPassword;
RadioGroup UserTypeGroup;
RadioButton BarberButton,CustomerButton;
Boolean IsBarber;
Button SignUp;
private FirebaseAuth mAuth;


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (BarberButton.isChecked())
            IsBarber=true;
        if (CustomerButton.isChecked())
            IsBarber=false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

       displayName=findViewById(R.id.displayname);
       Email=findViewById(R.id.email);
       Password=findViewById(R.id.password);
       ConfirmPassword=findViewById(R.id.confirmpassword);
       UserTypeGroup=findViewById(R.id.userTypeGroup);
       BarberButton=findViewById(R.id.barberButton);
       CustomerButton=findViewById(R.id.customerButton);
       BarberButton.setOnCheckedChangeListener(this);
       CustomerButton.setOnCheckedChangeListener(this);
       SignUp=findViewById(R.id.signupbtn);
       SignUp.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();



    }

    @Override
    public void onClick(View view) {
        if (view==SignUp){
            String username=displayName.getText().toString();
            String email=Email.getText().toString();
            String password=Password.getText().toString();




            User user=new User(username,email,password,IsBarber);
            submitClicked(user);
        }
    }

    public void submitClicked(User user) {

        mAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener(view,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    User user1 = new User(user.getEmail(),user.getPassword(),FirebaseAuth.getInstance().getUid());
                    Repository.getInstance().AddUser(user1);
                    //view.navigateToMain();

                } else {
                    // If sign in fails, display a message to the user.

                }
            }
        });
    }

}





