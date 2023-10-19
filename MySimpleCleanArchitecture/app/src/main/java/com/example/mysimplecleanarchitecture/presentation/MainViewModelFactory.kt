package com.example.mysimplecleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mysimplecleanarchitecture.di.Injection
import com.example.mysimplecleanarchitecture.domain.MessageUseCase

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private var messageUseCase: MessageUseCase
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(messageUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: MainViewModelFactory? = null

        fun getInstance(): MainViewModelFactory = instance ?: synchronized(this) {
            instance ?: MainViewModelFactory(Injection.provideUseCase())
        }
    }
}