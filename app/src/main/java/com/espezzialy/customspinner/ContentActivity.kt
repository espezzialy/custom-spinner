package com.espezzialy.customspinner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_page_selection.*

class ContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_page_selection)
        val button = findViewById<Button>(R.id.save_button)


        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId ==R.id.processando) {
                status = Status.PROCESSING
            }

            if(checkedId ==R.id.gerar_boleto) {
                status = Status.BANKSLIP
            }

            if(checkedId==R.id.pagar_bancos) {
                status = Status.BANKPAY
            }
        }
    }
}