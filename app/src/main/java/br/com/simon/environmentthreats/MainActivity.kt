package br.com.simon.environmentthreats

import android.content.Context
//noinspection SuspiciousImport
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    /** List view with the environment threats shown */
    private val listView: ListView = findViewById(R.id.listView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        listView.adapter = EnvironmentThreatsAdapter(emptyList(), baseContext)
    }

}

//class EnvironmentThreatsAdapter(threats: List<EnvironmentThreat>, context: Context) : BaseAdapter() {
//
//    private var threats: List<EnvironmentThreat>
//    private var inflator: LayoutInflater
//
//    init {
//        this.threats = threats
//        this.inflator = LayoutInflater.from(context)
//    }
//
//    override fun getCount(): Int {
//        return threats.size
//    }
//
//    override fun getItem(i: Int): Any {
//        return threats[i]
//    }
//
//    override fun getItemId(i: Int): Long {
//        return i.toLong()
//    }
//
//    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//        val v: View = inflator.inflate(R.layout.environment_threat, null)
//        return v
//    }
//
//}