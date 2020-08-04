package com.espezzialy.customspinner

import android.app.ProgressDialog.show
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.my_custom_view_layout.view.*


class MyCustomView(context:Context, attributeSet: AttributeSet) : LinearLayout(context, attributeSet)  {

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.my_custom_view_layout, this, true)

        when(status) {
            Status.PROCESSING -> {
                customButton.text = "PROCESSANDO"
                customButton.background = ContextCompat.getDrawable(context, R.drawable.style_processing_button)
                customButton.isEnabled = false
            }

            Status.BANKSLIP -> {
                customButton.text = "GERAR BOLETO"
                customButton.background = ContextCompat.getDrawable(context, R.drawable.style_bank_slip_button)
                customButton.setOnClickListener {
                    Toast.makeText(context, "Ação de Gerar Boleto", Toast.LENGTH_SHORT).show()
                }
            }
            Status.BANKPAY -> {
                customButton.text = "PAY"
                customButton.background = ContextCompat.getDrawable(context, R.drawable.style_pay_button)
                customButton.setOnClickListener {  v ->
                    val popup = PopupMenu(context, v)
                    popup.inflate(R.menu.menu_example)
                    popup.setOnMenuItemClickListener { item ->
                        when (item.itemId){
                            R.id.banco_popular ->{
                                Toast.makeText(context, "Toast de ação - Banco Popular", Toast.LENGTH_SHORT).show()
                                true
                            }
                            R.id.banco_leon ->{
                                Toast.makeText(context, "Toast de ação - Banco Leon", Toast.LENGTH_SHORT).show()
                                true
                            }
                            else -> false
                        }
                    }
                    popup.show()
                }
            }
        }
    }
}