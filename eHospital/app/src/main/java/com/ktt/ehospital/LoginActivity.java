package com.ktt.ehospital;

import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.account.AccountAuthManager;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;
import com.ktt.request.AccountRequest;
import com.ktt.response.Account;
import com.ktt.presenter.LoginPresenter;
import com.ktt.response.Session;
import com.ktt.view.ILoginView;

//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private static final String TAG = "DemoHMSAccountKit";
    private AccountAuthParams authParams;
    private AccountAuthService authService;

    private ILoginView loginView;
    private LoginPresenter loginPresenter;
    SharedPreferences sharedpreferences;

    private Button btnSignIn, btnSignInHuaWei, btnRegister;
    private TextView txtUsername, txtPassword;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String name = "nameKey";
    public static final String id = "idKey";
    public static final String tokenType = "tokenKey";
    public static final String accessToken = "accessTokenKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = findViewById(R.id.signIn);
        btnSignInHuaWei = findViewById(R.id.huawei);
        btnRegister = findViewById(R.id.signUp);
        txtPassword = findViewById(R.id.passwordLogin);
        txtUsername = findViewById(R.id.usernameLogin);

        setBtnSignIn();
        setBtnSignInHuaWei();
        setBtnSignUp();


    }
    private void setBtnSignUp(){
        btnRegister.setOnClickListener(item->{
            Intent intent = new Intent(LoginActivity.this, activity_register.class);
            startActivity(intent);
            finish();
        });
    }
    private void setBtnSignInHuaWei(){
        btnSignInHuaWei.setOnClickListener(item->{
                signInId();
        });
    }

     ActivityResultLauncher<Intent> signInIDResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
             (ActivityResultCallback<ActivityResult>) result -> {

                 Intent data = result.getData();
                 //id-token signIn
                 Task<AuthAccount> authAccountTask = AccountAuthManager.parseAuthResultFromIntent(data);
                 if(authAccountTask.isSuccessful()){
                     AuthAccount authAccount = authAccountTask.getResult();
                     Log.i(TAG, authAccount.getDisplayName() + " signIn success ");
                     Log.i(TAG,"idToken + {" + authAccount.getIdToken()+"}");
                     Log.i(TAG,"email : "+ authAccount );

                     Intent intent = new Intent(LoginActivity.this,TrangChu.class);
                     startActivity(intent);
                     finish();

                 }else {
                     Log.i(TAG,"sign in failed: " + ((ApiException)authAccountTask.getException()).getStatusCode());
                 }
             });


    private void signInId(){
        authParams = new AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM).
                setIdToken().setAccessToken().createParams();
        authService= AccountAuthManager.getService(LoginActivity.this,authParams);
        signInIDResult.launch(authService.getSignInIntent());
    }

    private void setBtnSignIn(){
        btnSignIn.setOnClickListener(item->{
            AccountRequest accountDTO= new AccountRequest();
            accountDTO.setUsername( txtUsername.getText().toString() );
            accountDTO.setPassword( txtPassword.getText().toString());
            loginPresenter = new LoginPresenter(this);
            loginPresenter.sendAccount(accountDTO);
        });
    }

    @Override
    public void onComplete(Account account) {
            if(account.getId() != 0){
                Session session = new Session(this);
                session.setId(account.getId());
                session.setUsename(account.getUsername());
                session.setAccessToken(account.getAccessToken());

                System.out.println(" login access : " + session.getAccessToken());
                Intent intent = new Intent(LoginActivity.this, TrangChu.class);
                startActivity(intent);
            }else{
                Toast.makeText(LoginActivity.this, "sai thong tin mat khau",Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    public void onError(String message) {
        Toast.makeText(LoginActivity.this, "sai thong tin mat khau",Toast.LENGTH_SHORT).show();
    }
}
