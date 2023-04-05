package com.example.oddoreven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.oddoreven.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    var n = 3
    lateinit var First: String
    lateinit var Second: String
    lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(OneFragment.newInstance(), R.id.OneFrame)
        openFrag(TwoFragment.newInstance(), R.id.TwoFrame)
        binding.Start.setOnClickListener{
            if (binding.Start.isEnabled == true){
                randStart()
                dataModel.messageFromActivty.value = First
                dataModel.messageFromActivitySum.value = Second

                check()
                dataModel.messageFromActivityResult.value = result.toInt()

                randStart()
                dataModel.messageFromActivityRandList.value = First
                dataModel.messageFromActivityRandListSum.value = Second

                check()
                dataModel.messageFromActivityResultFromUser.value = result.toInt()

                dataModel.BtnClickFragment.value = true
                binding.Start.isEnabled = false
                binding.Continue.isVisible = true
                binding.Close.isVisible = true
            }
            binding.Continue.setOnClickListener(){
                binding.Start.isEnabled = true
                binding.Continue.isVisible = false
                binding.Close.isVisible = false
                dataModel.BtnClickFragment.value = false
            }
            binding.Close.setOnClickListener(){
                finish()
            }
        }
        dataModel.messageCount.observe(this) {
            binding.textforcomputer.text = it
        }
        dataModel.messageCountForUser.observe(this) {
            binding.textforuser.text = it
        }
        dataModel.BtnCheckenabled.observe(this){
            if (it == true){
                binding.Start.isEnabled = true
            }
        }
    }
    private fun check() {
        if (Second.toInt() % 2 == 0){
            result = "1"
        }else {
            result = "2"
        }

    }

    private fun randStart(){
        var randomList: RandList = RandList()
        var listorsum = randomList.RandomListOrSum(n)
        First = listorsum.first
        Second = listorsum.second.toString()
    }

    private fun openFrag(f: Fragment, idHolder: Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}
