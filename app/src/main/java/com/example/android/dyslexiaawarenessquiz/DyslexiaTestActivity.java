package com.example.android.dyslexiaawarenessquiz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Clementine on 1/31/2018.
 */

public class DyslexiaTestActivity extends Activity {
    EditText childName;
    String savedName;
    RadioButton radioButtonOneYes, radioButtonOneNo;
    RadioButton radioButtonTwoYes, radioButtonTwoNo;
    RadioButton radioButtonThreeYes, radioButtonThreeNo;
    RadioButton radioButtonFourYes, radioButtonFourNo;
    String selectedAnswerOne;
    String selectedAnswerTwo;
    String selectedAnswerThree;
    String selectedAnswerFour;
    Button submit;
    int score = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dyslexia_test_layout);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .8));
        childName = (EditText) findViewById(R.id.name_input);
        savedName = childName.getText().toString();
        String formatted = getString(R.string.dyslexia_question_one, savedName);

        radioButtonOneYes = (RadioButton) findViewById(R.id.radioButtonOneYes);
        radioButtonOneNo = (RadioButton) findViewById(R.id.radioButtonOneNo);
        radioButtonTwoYes = (RadioButton) findViewById(R.id.radioButtonTwoYes);
        radioButtonTwoNo = (RadioButton) findViewById(R.id.radioButtonTwoNo);
        radioButtonThreeYes = (RadioButton) findViewById(R.id.radioButtonThreeYes);
        radioButtonThreeNo = (RadioButton) findViewById(R.id.radioButtonThreeNo);
        radioButtonFourYes = (RadioButton) findViewById(R.id.radioButtonFourYes);
        radioButtonFourNo = (RadioButton) findViewById(R.id.radioButtonFourNo);
        submit = (Button) findViewById(R.id.submitButton);


    }

    public int onRadioButtonClicked(View view) {

        if (radioButtonOneYes.isChecked()) {
            score = 1;

        } else {
            score = 0;
        }

        if (radioButtonTwoYes.isChecked()) {
            score += 1;
        }

        if (radioButtonThreeYes.isChecked()) {
            score += 1;
        }

        if (radioButtonFourYes.isChecked()) {
            score += 1;
        }

        return score;
    }

    public String updateScore() {

        childName = (EditText) findViewById(R.id.name_input);
        savedName = childName.getText().toString();
        String summaryMessage = getString(R.string.score_string, savedName);
        summaryMessage = getString(R.string.score_string) + " " + score;
        return summaryMessage;
    }

    private void displayScore(String number) {
        TextView scoreString = (TextView) findViewById(R.id.score_string);
        scoreString.setText("" + number);
    }

    public void showScore(View view) {

        CheckBox sentEmail = (CheckBox) findViewById(R.id.send_to_email);
        if (sentEmail.isChecked()) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "diddeto@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Резултат от тест за " + "Име");
            intent.putExtra(Intent.EXTRA_TEXT, updateScore());
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else {
            displayScore(updateScore());
        }
    }
}
