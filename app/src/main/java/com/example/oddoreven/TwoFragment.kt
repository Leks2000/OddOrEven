package com.example.oddoreven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.example.oddoreven.databinding.FragmentTwoBinding
import kotlin.properties.Delegates

class TwoFragment : Fragment() {

    lateinit var binding: FragmentTwoBinding
    var radio by Delegates.notNull<Int>()
    var count = 0

    private  val dataModel: DataModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageFromActivityRandList.observe(activity as LifecycleOwner){
            binding.randvalue.text = it
        }
        dataModel.messageFromActivityRandListSum.observe(activity as LifecycleOwner){
        binding.Sum.text = it
        }
        binding.radioButton3.setOnClickListener{
            dataModel.BtnCheckenabled.value = true
            radio = 1
        }
        binding.radioButton4.setOnClickListener{
            dataModel.BtnCheckenabled.value = true
            radio = 2
        }
        dataModel.messageFromActivityResultFromUser.observe(activity as LifecycleOwner) {
            if (radio == 1) {
                binding.imageView2.isVisible = true
                binding.radioButton3.isChecked = true
                binding.imageView3.isVisible = false
                if (radio == it) {
                    binding.imageView2.setImageResource(R.drawable.plus_transformed)
                    count++
                } else {
                    binding.imageView2.setImageResource(R.drawable.cross_transformed)
                }
            } else {
                binding.imageView3.isVisible = true
                binding.radioButton4.isChecked = true
                binding.imageView2.isVisible = false
                if (radio == it) {
                    binding.imageView3.setImageResource(R.drawable.plus_transformed)
                    count++
                } else {
                    binding.imageView3.setImageResource(R.drawable.cross_transformed)
                }
            }
            dataModel.messageCountForUser.value = count.toString()
        }
    }

    companion object{
        @JvmStatic
        fun newInstance() = TwoFragment()
    }
}
