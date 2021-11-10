package com.ktt.ehospital;

import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.account.AccountAuthManager;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;
import com.ktt.entities.Account;
import com.ktt.response.AccountDTO;
import com.ktt.utils.IApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "DemoHMSAccountKit";
    private AccountAuthParams authParams;
    private AccountAuthService authService;
    private Button btnSignIn, btnSignInHuaWei;
    private TextView txtUsername, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = findViewById(R.id.signIn);
        btnSignInHuaWei = findViewById(R.id.huawei);
        txtPassword = findViewById(R.id.passwordLogin);
        txtUsername = findViewById(R.id.usernameLogin);

        setBtnSignIn();
        setBtnSignInHuaWei();

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
            Account account = new Account();
            account.setUsername( txtUsername.getText().toString() );
            account.setPassword( txtPassword.getText().toString());

            sendAccount(account);
        });
    }

    private void sendAccount(Account account){
        IApiService.apiService.sendAccount(account).enqueue(new Callback<AccountDTO>() {
            @Override
            public void onResponse(Call<AccountDTO> call, Response<AccountDTO> response) {
                Toast.makeText(LoginActivity.this, " Call Api Success", Toast.LENGTH_SHORT).show();
                AccountDTO accountDTO = response.body();
                System.out.println("accountDTO : " + accountDTO.getAccessToken());
            }

            @Override
            public void onFailure(Call<AccountDTO> call, Throwable t) {
                Toast.makeText(LoginActivity.this, " Call Api error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
