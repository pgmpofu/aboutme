package com.ai.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ai.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName = MyName("Patience Mpofu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mName = this.myName
        binding.doneButton.setOnClickListener {
           addNickname(it)
       }
    }

    private fun addNickname(view: View){
        binding.apply {
            mName?.nickname = editTextTextPersonName.text.toString()
            invalidateAll()
            binding.displayNickname.visibility = View.VISIBLE
        }
        hideKeyboard(view)
    }

    private fun hideKeyboard(view : View) {
        val im = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        im.hideSoftInputFromWindow(view.windowToken, 0)
    }
}