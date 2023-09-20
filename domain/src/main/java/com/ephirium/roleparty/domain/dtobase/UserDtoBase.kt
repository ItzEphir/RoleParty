package com.ephirium.roleparty.domain.dtobase

interface UserDtoBase : DtoBase {
    var login: String
    var email: String
    var threads: List<String>
}