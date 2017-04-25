package com.example.android.elegancetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String finalMessage = " ";
    int correctAnswersNumber = 0;
    String isQuestion1Correct = " ";
    String isQuestion2Correct = " ";
    String isQuestion3Correct = " ";
    String isQuestion4Correct = " ";
    String isQuestion5Correct = " ";
    String isQuestion6Correct = " ";
    String correct = "Correct!";
    String incorrect = "Incorrect!";
    String noAnswer = "No answer.";

    //These variables are used to save values when the device is rotated.
    private static final String STATE_finalMessage = "";
    private static final String STATE_correctAnswersNumber = "";
    private static final String STATE_isQuestion1Correct = "";
    private static final String STATE_isQuestion2Correct = "";
    private static final String STATE_isQuestion3Correct = "";
    private static final String STATE_isQuestion4Correct = "";
    private static final String STATE_isQuestion5Correct = "";
    private static final String STATE_isQuestion6Correct = "";

    /**
     * Saving the instance state because the main activity will destroy when screen
     * orientation is changed.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(STATE_finalMessage, finalMessage);
        savedInstanceState.putInt(STATE_correctAnswersNumber, correctAnswersNumber);
        savedInstanceState.putString(STATE_isQuestion1Correct, isQuestion1Correct);
        savedInstanceState.putString(STATE_isQuestion2Correct, isQuestion2Correct);
        savedInstanceState.putString(STATE_isQuestion3Correct, isQuestion3Correct);
        savedInstanceState.putString(STATE_isQuestion4Correct, isQuestion4Correct);
        savedInstanceState.putString(STATE_isQuestion5Correct, isQuestion5Correct);
        savedInstanceState.putString(STATE_isQuestion6Correct, isQuestion6Correct);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Restoring values back to normal.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        finalMessage = savedInstanceState.getString(STATE_finalMessage);
        correctAnswersNumber = savedInstanceState.getInt(STATE_correctAnswersNumber);
        isQuestion1Correct = savedInstanceState.getString(STATE_isQuestion1Correct);
        isQuestion2Correct = savedInstanceState.getString(STATE_isQuestion2Correct);
        isQuestion3Correct = savedInstanceState.getString(STATE_isQuestion3Correct);
        isQuestion4Correct = savedInstanceState.getString(STATE_isQuestion4Correct);
        isQuestion5Correct = savedInstanceState.getString(STATE_isQuestion5Correct);
        isQuestion6Correct = savedInstanceState.getString(STATE_isQuestion6Correct);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {

        //Check if the first question is correct/incorrect, or is there no answer.
        RadioButton radioButton11 = (RadioButton) findViewById(R.id.a11);
        RadioButton radioButton12 = (RadioButton) findViewById(R.id.a12);
        RadioButton radioButton13 = (RadioButton) findViewById(R.id.a13);
        if (radioButton12.isChecked()) {
            correctAnswersNumber += 1;
            isQuestion1Correct = correct;
        } else if (radioButton11.isChecked() || radioButton13.isChecked()) {
            isQuestion1Correct = incorrect;
        } else {
            isQuestion1Correct = noAnswer;
        }

        //Check if the second question is correct/incorrect, or is there no answer.
        RadioButton radioButton21 = (RadioButton) findViewById(R.id.a21);
        RadioButton radioButton22 = (RadioButton) findViewById(R.id.a22);
        RadioButton radioButton23 = (RadioButton) findViewById(R.id.a23);
        if (radioButton22.isChecked()) {
            correctAnswersNumber += 1;
            isQuestion2Correct = correct;
        } else if (radioButton21.isChecked() || radioButton23.isChecked()) {
            isQuestion2Correct = incorrect;
        } else {
            isQuestion2Correct = noAnswer;
        }

        //Check if the third question is correct/incorrect, or is there no answer.
        RadioButton radioButton31 = (RadioButton) findViewById(R.id.a31);
        RadioButton radioButton32 = (RadioButton) findViewById(R.id.a32);
        RadioButton radioButton33 = (RadioButton) findViewById(R.id.a33);
        if (radioButton32.isChecked()) {
            correctAnswersNumber += 1;
            isQuestion3Correct = correct;
        } else if (radioButton31.isChecked() || radioButton33.isChecked()) {
            isQuestion3Correct = incorrect;
        } else {
            isQuestion3Correct = noAnswer;
        }

        //Check if the fourth question is correct/incorrect, or is there no answer.
        RadioButton radioButton41 = (RadioButton) findViewById(R.id.a41);
        RadioButton radioButton42 = (RadioButton) findViewById(R.id.a42);
        RadioButton radioButton43 = (RadioButton) findViewById(R.id.a43);
        if (radioButton42.isChecked()) {
            correctAnswersNumber += 1;
            isQuestion4Correct = correct;
        } else if (radioButton41.isChecked() || radioButton43.isChecked()) {
            isQuestion4Correct = incorrect;
        } else {
            isQuestion4Correct = noAnswer;
        }

        //Check if the fifth question is correct/incorrect, or is there no answer.
        EditText editText = (EditText) findViewById(R.id.editText1);
        if (editText.getText().toString().equals("Goodyear Welting")) {
            correctAnswersNumber += 1;
            isQuestion5Correct = correct;
        } else if (editText.getText().toString().isEmpty()) {
            isQuestion5Correct = noAnswer;
        } else {
            isQuestion5Correct = incorrect;
        }

        //Check if the sixth question is correct/incorrect, or is there no answer.
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.a61);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.a62);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.a63);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.a64);
        if (!checkBox1.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) {
            correctAnswersNumber += 1;
            isQuestion6Correct = correct;
        } else if (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked() && !checkBox4.isChecked()) {
            isQuestion6Correct = noAnswer;
        } else {
            isQuestion6Correct = incorrect;
        }

        setMessage();
        displayMessage();
        reset();

    }

    //Sets the final message
    public void setMessage() {
        finalMessage += "Correct answers: " + correctAnswersNumber + "/6";
        if (correctAnswersNumber == 0) {
            finalMessage += "\nYour title: Eternal student";
        } else if (correctAnswersNumber == 1) {
            finalMessage += "\nYour title: Sale king";
        } else if (correctAnswersNumber == 2) {
            finalMessage += "\nYour title: Cloakroom attendant at salons";
        } else if (correctAnswersNumber == 3) {
            finalMessage += "\nYour title: Adept of classical elegance";
        } else if (correctAnswersNumber == 4) {
            finalMessage += "\nYour title: The hero of each event";
        } else if (correctAnswersNumber == 5) {
            finalMessage += "\nYour title: Elegant genius";
        } else if (correctAnswersNumber == 6) {
            finalMessage += "\nYour title: The godfather of fashion";
        }
        finalMessage += "\n\nYour answers:";
        finalMessage += "\n1)" + isQuestion1Correct;
        finalMessage += "\n2)" + isQuestion2Correct;
        finalMessage += "\n3)" + isQuestion3Correct;
        finalMessage += "\n4)" + isQuestion4Correct;
        finalMessage += "\n5)" + isQuestion5Correct;
        finalMessage += "\n6)" + isQuestion6Correct;
        finalMessage += "\n\nThank you for taking part in our test!";
    }

    //Displays the result to the screen depends of correctAnswers
    public void displayMessage() {
        Toast.makeText(this, finalMessage, Toast.LENGTH_LONG).show();
    }

    //Resets all values
    public void reset() {
        finalMessage = " ";
        correctAnswersNumber = 0;
        isQuestion1Correct = " ";
        isQuestion2Correct = " ";
        isQuestion3Correct = " ";
        isQuestion4Correct = " ";
        isQuestion5Correct = " ";
        isQuestion6Correct = " ";
    }

}
