package cl.awakelab.menubancario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.awakelab.menubancario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var saldo = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOk.setOnClickListener { v ->

            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radioButtonSaldo ->
                    binding.editTextSaldo.setText(saldo.toString())

                R.id.radioButtonIngresar -> ingresarSaldo()
                R.id.radioButtonRetirar -> retirarSaldo()
                R.id.radioButtonSalir -> finish()
            }
        }
    }

    private fun retirarSaldo() {
        val monto = binding.editTextSaldo.text.toString().toInt()
        if (monto <= saldo) {
            saldo -= monto
            limpiarMonto()
            crearMensaje("El retiro ha sido realizado correctamente")
        } else

            crearMensaje("El monto supero el saldo dispponible")
    }

    fun limpiarMonto() {
        binding.editTextSaldo.text.clear()

    }

    fun ingresarSaldo() {
        saldo += binding.editTextSaldo.text.toString().toInt()
        limpiarMonto()
        crearMensaje("Su saldo ha sido actualizado correctamente")

    }


    fun crearMensaje(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG).show()

    }
}