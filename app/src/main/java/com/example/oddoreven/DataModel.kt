package com.example.oddoreven

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
        val  messageFromActivty: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }
        val  messageFromActivitySum: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }
        val  messageFromActivityRandList: MutableLiveData<String> by lazy {
             MutableLiveData<String>()
         }
        val  messageFromActivityRandListSum: MutableLiveData<String>  by lazy {
             MutableLiveData<String>()
        }
        val  messageCount: MutableLiveData<String>  by lazy {
            MutableLiveData<String>()
        }
        val  messageCountForUser: MutableLiveData<String>  by lazy {
            MutableLiveData<String>()
        }
        val  messageFromActivityResult: MutableLiveData<Int>  by lazy {
            MutableLiveData<Int>()
        }
        val  messageFromActivityResultFromUser: MutableLiveData<Int>  by lazy {
            MutableLiveData<Int>()
        }
        val  BtnClickFragment: MutableLiveData<Boolean>  by lazy {
            MutableLiveData<Boolean>()
        }
        val  BtnCheckenabled: MutableLiveData<Boolean>  by lazy {
            MutableLiveData<Boolean>()
        }
}
