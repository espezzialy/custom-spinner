package com.espezzialy.customspinner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.texto_status


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.content_page_button)
        button1.setOnClickListener{
            val intent = Intent(this, ContentActivity::class.java)
            startActivity(intent)
        }



        val button2 = findViewById<Button>(R.id.customview_page_button)
        button2.setOnClickListener{
            val intent = Intent(this, CustomViewActivity::class.java)
            startActivity(intent)
        }

        when(status) {
            Status.PROCESSING -> {
                texto_status.visibility = View.VISIBLE
                texto_status.text = "CustomView Status Processando"
            }
            Status.BANKPAY -> {
                texto_status.visibility = View.VISIBLE
                texto_status.text = "CustomView Status: Pagamento via Banco"
            }
            Status.BANKSLIP -> {
                texto_status.visibility = View.VISIBLE
                texto_status.text = "CustomView Status: Boleto"
            }
        }
    }
}
