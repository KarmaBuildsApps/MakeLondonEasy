package myapp.tae.ac.uk.makelondoneasy.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

import io.fabric.sdk.android.Fabric;
import myapp.tae.ac.uk.makelondoneasy.R;

/**
 * Created by Karma on 26/01/16.
 */
public class PMethodPayPal extends AppCompatActivity implements View.OnClickListener {
    private Button btnPay;
    private EditText etDonationAmount;
    private double donationAmount = 0;
    //set the environment for production/sandbox/no netowrk
    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
    private static final String CONFIG_CLIENT_ID = "Ade17MF945swtrOqPQx-Y7rjjT7rA2R5bMiYR-Ehdh7MCmZMWyb7-RhOUzCDBIartohE-ROPdGExKpss";
    private final int REQUEST_PAYPAL_PAYMENT = 1;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(CONFIG_ENVIRONMENT)
            .clientId(CONFIG_CLIENT_ID)
                    // The following are only used in PayPalFuturePaymentActivity.
            .merchantName("The Appexperts Ltd")
            .merchantPrivacyPolicyUri(Uri.parse("https://www.example.com/privacy"))
            .merchantUserAgreementUri(Uri.parse("https://www.example.com/legal"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this);
        setContentView(R.layout.paypal_donation_layout);
        etDonationAmount = (EditText) findViewById(R.id.etPaymentAmount);
        btnPay = (Button) findViewById(R.id.btPayPalDonate);
        btnPay.setOnClickListener(this);

        /**
         * call pay pal services
         */

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btPayPalDonate:
                if (!etDonationAmount.getText().equals("")) {
                    donationAmount = Double.parseDouble(etDonationAmount.getText().toString());
                    if (donationAmount <= 0) {
                        Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_LONG).show();
                        break;
                    }
                } else {
                    Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_LONG).show();
                    break;
                }
                PayPalPayment thingToBuy = new PayPalPayment(new BigDecimal(donationAmount), "USD", "theappexperts.co.uk",
                        PayPalPayment.PAYMENT_INTENT_SALE);

                Intent intent = new Intent(PMethodPayPal.this, PaymentActivity.class);

                intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);

                startActivityForResult(intent, REQUEST_PAYPAL_PAYMENT);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_PAYPAL_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                PaymentConfirmation confirm = data
                        .getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirm != null) {
                    try {
                        System.out.println("Responseeee" + confirm);
                        Log.i("paymentExample", confirm.toJSONObject().toString());
                        JSONObject jsonObj = new JSONObject(confirm.toJSONObject().toString());

                        String paymentId = jsonObj.getJSONObject("response").getString("id");
                        System.out.println("payment id:-==" + paymentId);
                        Toast.makeText(getApplicationContext(), paymentId, Toast.LENGTH_LONG).show();

                    } catch (JSONException e) {
                        Log.e("paymentExample", "an extremely unlikely failure occurred: ", e);
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("paymentExample", "The user canceled.");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i("paymentExample", "An invalid Payment was submitted. Please see the docs.");
            }
        }


    }


}
