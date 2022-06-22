package com.viniciusaraujo.routemy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.viniciusaraujo.routemy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivityMainBinding
    private var distancia: Float=0.0f
    private var price:Float=0.0f
    private var autonomy:Float=0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
        supportActionBar?.hide()
        handleUserName()

    }
    private fun handleUserName(){
        var string= Security(this).getString("user_name")
        if(string!="") binding.textFazerLoging.text= "Olá, ${string}"
    }
    private fun setListeners(){
        binding.buttonCalculate.setOnClickListener(this)
        binding.imageComprar.setOnClickListener(this)
        binding.imageDefinirRota.setOnClickListener(this)
        binding.imageConsultarModelo.setOnClickListener(this)
        binding.textFazerLoging.setOnClickListener(this)
        binding.buttonConnect.setOnClickListener(this)
        binding.tableRow1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id==R.id.buttonCalculate) {


            calculate()
        }
        if (v.id==R.id.image_DefinirRota){
            definirRota()
        }
        if (v.id==R.id.image_Comprar){
            comprar()
        }
        if (v.id==R.id.image_ConsultarModelo){
            consultarModelo()
        }
        if(v.id==R.id.text_fazer_loging){
            startActivity(Intent(this,LoginActivity::class.java))
        }
        if (v.id==R.id.buttonConnect){
            conectar()
            println("Some botao...")
        }
        if(v.id==R.id.table_row_1){
            analisarCorrida()
        }

    } private fun calculate(){

        println ("Calculando...")
        if(isValid()) {
             distancia = binding.edityTextDistance.text.toString().toFloat()
             price = binding.editTextPrice.text.toString().toFloat()
             autonomy = binding.editTextAutonomy.text.toString().toFloat()

            var resultado = distancia * price / autonomy
            println("R$ ${resultado}")

            binding.textViewTotal.setText("R$ ${"%.2f".format(resultado)}")
        }else{
            Toast.makeText(this,R.string.fill_all_fields,Toast.LENGTH_SHORT).show()

        }
    }
    private fun analisarCorrida(){
        Toast.makeText(this,"Analisando Corrida Selecionada",Toast.LENGTH_SHORT).show()

        startActivity(Intent(this, CorridaMainActivity::class.java))

    }
    private fun conectar(){

        binding.textKmsCorrida1.text="14"
        if(isValid()){
            var corrida =  Corrida()
                // binding.buttonConnect.isVisible=false
                binding.textChamadasAgora.isVisible=true
                binding.tableChamadas.isVisible=true

            var novaRota = distancia+binding.textKmsCorrida1.text.toString().toFloat()
           // binding.edityTextDistance.setText(novaRota.toString())

            var novoCustoTotal= novaRota*price/autonomy
           // binding.textViewTotal.text="R$ ${"%.2f".format(novoCustoTotal)}"
            binding.textCostCorrida1.text="R$ ${"%.2f".format(novoCustoTotal)}"

            var precoDaCorrida=novoCustoTotal+(novoCustoTotal*0.12)
            var precoDaCorridaStr= precoDaCorrida.toString()
            println("Preço da corrida dá: ${precoDaCorrida}")

            binding.textPrecoCorrida1.text="R$ ${"%.2f".format(precoDaCorrida)}"
            var lucro= precoDaCorrida-novoCustoTotal
            binding.textLucroCorrida1.text="R$ ${"%.2f".format(lucro)}"

            binding.buttonCalculate.isVisible=false
           binding.buttonConnect.isVisible=false
            binding.edityTextDistance.isEnabled=false
            binding.editTextPrice.isEnabled=false
            binding.editTextAutonomy.isEnabled=false
        //não testado ainda

                corrida.setKms(novaRota)
                corrida.setCost(novoCustoTotal)
                corrida.setPrice(precoDaCorrida.toFloat())
                corrida.setLucre(lucro.toFloat())

            //lllllllllllllllllllll
        }
        else{
            Toast.makeText(this,R.string.fill_all_fields,Toast.LENGTH_SHORT).show()

        }
    }

    private fun isValid():Boolean{
        return binding.edityTextDistance.text.toString()!="" &&
                binding.editTextPrice.text.toString()!="" &&
                binding.editTextAutonomy.text.toString()!=""&&
                binding.editTextAutonomy.text.toString().toFloat()!=0f
    }
    private fun abastecer(){
        println("Abastecer ....")

    }
    private fun definirRota(){
        println("Definindo rota...")
    }
    private fun comprar(){
        println("Comprando...")
    }
    private fun consultarModelo(){
        println("Consultar Modelo")
    }
}