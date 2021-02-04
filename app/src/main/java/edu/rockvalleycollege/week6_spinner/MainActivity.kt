/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Week 6 - Spinner
*/

package edu.rockvalleycollege.week6_spinner

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtFullName = findViewById<EditText>(R.id.txtFullName)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var spinner = findViewById<Spinner>(R.id.spinner)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        var txtShow = findViewById<TextView>(R.id.txtShow)
        var spinList = arrayOf("Online","TV","Career Fair", "Radio", "Other")

        val adapter1 = ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, spinList)
        android.R.layout.simple_spinner_item
        android.R.layout.simple_spinner_dropdown_item
        spinner.adapter = adapter1

        txtFullName.requestFocus()



        btnSubmit.setOnClickListener {

            hideKeyboard()

            var spinnerSelection = ""

            when (spinner.selectedItem.toString()){
                "Online" -> spinnerSelection = "Online"
                "TV" -> spinnerSelection = "TV"
                "Radio" -> spinnerSelection = "Radio"
                "Other" -> spinnerSelection = "Other"
                "Career Fair" -> spinnerSelection = "Career Fair"

            }
            // The next line goes with the when loop above
            txtShow.text = createMessage(txtFullName.text.toString(), txtEmail.text.toString(), spinnerSelection)

            // The next line replaces the when loop and the statement above. This line would reduce the number of lines
            // and also keeps errors down to a minimum. This line was just to prove that we didn't need the when loop.
            //txtShow.text = createMessage(txtFullName.text.toString(), txtEmail.text.toString(), spinner.selectedItem.toString())

            txtFullName.text.clear()
            txtEmail.text.clear()
            txtFullName.requestFocus()

        }//end of onclick listener


        // This code goes at the end of OnCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }// End of hidekeyboard findviewbyid

    }// end of Oncreate

    //function to hide keyboard goes right before the last right bracket of Class MainActivity
    //should auto import android.content.Context
    //should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }// End of Hide Keyboard function

    fun createMessage(fullName: String, email: String, spinnerSelection: String): String{
        var message = "Name: $fullName \nemail: $email \nHow did you find us: $spinnerSelection"
        return message
    }// End of createMessage function

}// End of Main Activity