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
import android.widget.Toast;

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
    Button submit;
    int score = 0;
    String summaryMessage;
    String value;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dyslexia_test_layout);

        /**
         * Finding out what the metrics of the screen are and then setting the pop-up activity to be
         * measuring the chosen percentage based on it, in this case 90% width, 80% height.
         */

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .8));


/**
 * Declaring the buttons
 */
        radioButtonOneYes = (RadioButton) findViewById(R.id.radioButtonOneYes);
        radioButtonOneNo = (RadioButton) findViewById(R.id.radioButtonOneNo);
        radioButtonTwoYes = (RadioButton) findViewById(R.id.radioButtonTwoYes);
        radioButtonTwoNo = (RadioButton) findViewById(R.id.radioButtonTwoNo);
        radioButtonThreeYes = (RadioButton) findViewById(R.id.radioButtonThreeYes);
        radioButtonThreeNo = (RadioButton) findViewById(R.id.radioButtonThreeNo);
        radioButtonFourYes = (RadioButton) findViewById(R.id.radioButtonFourYes);
        radioButtonFourNo = (RadioButton) findViewById(R.id.radioButtonFourNo);
        submit = (Button) findViewById(R.id.submitButton);

        /**
         * Getting the name from the EditText and setting the question TextViews to show it. Had to add
         * and updated message since it only gets numbers for some reason instead of my text when I try
         * to use format.
         */

        final EditText nameInput = (EditText) findViewById(R.id.name_input);
        Button submitName = (Button) findViewById(R.id.save_name_button);
        submitName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String value = nameInput.getText().toString();
                TextView question = (TextView) findViewById(R.id.question_one);
                question.setText(getString(R.string.dyslexia_question_one_update1) + " " + value + " " + getString(R.string.dyslexia_question_one_update2));
                TextView question2 = (TextView) findViewById(R.id.question_two);
                question2.setText(value + getString(R.string.dyslexia_question_two_update2));
                TextView question3 = (TextView) findViewById(R.id.question_three);
                question3.setText(value + " " + getString(R.string.dyslexia_question_three_update2));
                TextView question4 = (TextView) findViewById(R.id.question_four);
                question4.setText(value + " " + getString(R.string.dyslexia_question_four_update2));
            }

        });

    }

    /**
     * This method counts the score based on which button is clicked. The YES buttons return 1 point,
     * the NO buttons don't return a value or change the score.
     *
     * @param view
     * @return
     */
    public int onRadioButtonClicked(View view) {

        if (radioButtonOneYes.isChecked()) {
            score = 1;

        }
        return score;
    }

    public int onRadioButtonClickedSecond(View view) {
        if (radioButtonTwoYes.isChecked()) {
            score += 1;


        }
        return score;
    }

    public int onRadioButtonClickedThird(View view) {
        if (radioButtonThreeYes.isChecked()) {
            score += 1;


        }
        return score;
    }

    public int onRadioButtonClickedForth(View view) {
        if (radioButtonFourYes.isChecked()) {
            score += 1;


        }

        return score;
    }


    /**
     * The method gets the score from above and adds it to the Result string to update it. If the checkbox for additional info
     * is checked it adds am additional string to the original message
     *
     * @return
     */
    public String updateScoreMessage() {

        childName = (EditText) findViewById(R.id.name_input);
        savedName = childName.getText().toString();
        String summaryMessage = getString(R.string.score_string, score);
        return summaryMessage;
    }

    /**
     * The method displays the score in a case the parent decides they don't want to send it as an email
     *
     * @param number
     */
    private void displayScore(String number) {
        TextView scoreString = (TextView) findViewById(R.id.score_string);
        scoreString.setText("" + number);
    }

    /**
     * Defines what happens if the email checkbox is active and if it isn't selected. Adds a toast in the case where it's not.
     *
     * @param view
     */
    public void showScore(View view) {
        CheckBox sentEmail = (CheckBox) findViewById(R.id.send_to_email);
        if (sentEmail.isChecked()) {

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "diddeto@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Резултат от тест за " + value);
            intent.putExtra(Intent.EXTRA_TEXT, updateScoreMessage() + "В случай, че резултатът е по-голям от 5, се консултирайте със специалист. Винаги първо се свържете с педиатър и учителя на детето, за да проверите дали няма други възможни проблеми! Никога не поставяйте диагноза сами!");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);

            }


        } else {
            Toast.makeText(this, updateScoreMessage(),
                    Toast.LENGTH_LONG).show();
            displayScore(updateScoreMessage() + getString(R.string.result_message));
        }

    }
}

