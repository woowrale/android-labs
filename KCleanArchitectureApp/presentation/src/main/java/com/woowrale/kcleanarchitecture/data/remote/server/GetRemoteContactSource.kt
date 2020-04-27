package com.woowrale.kcleanarchitecture.data.remote.server

import com.woowrale.data.repository.remote.RemoteContactSource
import com.woowrale.domain.model.Contact
import com.woowrale.kcleanarchitecture.data.remote.mappers.MapperToContacts
import com.woowrale.kcleanarchitecture.data.remote.ws.ApiService
import java.io.IOException

class GetRemoteContactSource(apiService: ApiService) : RemoteContactSource {

    private val apiService: ApiService = apiService

    override fun getContacts(
        apiContacts: String,
        source: String,
        query: String
    ): List<Contact> {
        return try {
            MapperToContacts().mappertoContactList(apiService.getContacts(apiContacts, source).execute().body()!!)
        } catch (e: IOException) {
           return listOfNotNull()
        }
    }

}
