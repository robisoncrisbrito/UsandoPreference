package br.edu.utfpr.usandopreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

private const val BD = "DATA"

class MainActivity : AppCompatActivity() {

    private lateinit var ivImagem : ImageView

    private var ligado = false

    private lateinit var sharedPreference:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivImagem = findViewById( R.id.ivImagem )

        sharedPreference = getSharedPreferences(BD, Context.MODE_PRIVATE )

        ligado = sharedPreference.getBoolean( "ligado", false )

        when ( ligado ) {
            true -> ivImagem.setImageResource( android.R.drawable.btn_star_big_on )
            false -> ivImagem.setImageResource( android.R.drawable.btn_star_big_off )
        }

    }

    fun btOnOffOnClick(view: View) {

        if ( ligado ) {
            ivImagem.setImageResource( android.R.drawable.btn_star_big_off )
        } else {
            ivImagem.setImageResource( android.R.drawable.btn_star_big_on )
        }

        ligado = !ligado

        var editor = sharedPreference.edit()
        editor.putBoolean( "ligado", ligado )
        editor.commit()

    }

    fun btPreferenciaOnClick(view: View) {
        val intent = Intent( this, SettingsActivity::class.java )
        startActivity( intent )
    }
}