package com.example.mysimplecleanarchitecture.data

import com.example.mysimplecleanarchitecture.domain.MessageEntity

class MessageDataSource : IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity  = MessageEntity("Hello $name Welcome to Clean Architecture")
}