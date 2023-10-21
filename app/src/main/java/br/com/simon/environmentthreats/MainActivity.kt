package br.com.simon.environmentthreats

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {

    /** List with the environment threats */
    private val environmentThreatsList: MutableList<EnvironmentThreat> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_environment_threat)
        environmentThreatsList.add(EnvironmentThreat("Rua", LocalDateTime.now(), "Corte irregular de vegetação nativa"))
        environmentThreatsList.add(EnvironmentThreat("Rua", LocalDateTime.now(), "Pesca predatória com rede de arrasto"))
        environmentThreatsList.add(EnvironmentThreat("Rua", LocalDateTime.now(), "Descarte irregular de lixo hospitalar"))
        environmentThreatsList.add(EnvironmentThreat("Rua", LocalDateTime.now(), "Derrame químico em sistema de esgotamento pluvial com texto a mais do que devia"))
//        val listView: ListView = findViewById(R.id.listView)
//        listView.adapter = EnvironmentThreatsAdapter(environmentThreatsList, baseContext)
    }

}

/**
 * Adapter to show Environment Threats in ListView component.
 */
class EnvironmentThreatsAdapter(threats: List<EnvironmentThreat>, context: Context) : BaseAdapter() {

    private var threats: List<EnvironmentThreat>
    private var inflator: LayoutInflater

    init {
        this.threats = threats
        this.inflator = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return threats.size
    }

    override fun getItem(i: Int): Any {
        return threats[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, p1: View?, p2: ViewGroup?): View {
        val v: View = inflator.inflate(R.layout.environment_threat, null)
        val txtSaida = v.findViewById<View>(R.id.description) as TextView
        val txtDate = v.findViewById<View>(R.id.date) as TextView
        txtSaida.text = threats[i].description
        txtDate.text = threats[i].date.dayOfMonth.toString() + "/" +
                       threats[i].date.monthValue.toString() + "/" +
                       threats[i].date.year.toString()
        return v
    }

}