package com.ephirium.roleparty.data.model

import com.ephirium.roleparty.domain.dtobase.UserDtoBase
import com.google.firebase.firestore.DocumentId

data class UserDto(
    @DocumentId override var id: String = "",
    override var login: String = "",
    override var email: String = "",
    override var threads: List<String> = listOf(),
) : UserDtoBase
