package com.ephirium.roleparty.ui.navigation

sealed interface Destinations {
    val route: String

    object Auth : Destinations {
        override val route = "authGraph"

        object Nested {
            object Main : Destinations {
                override val route = "main"
            }

            object SignUp : Destinations {
                override val route = "sign_up"
            }

            object SignIn : Destinations {
                override val route = "sign_in"
            }
        }
    }

    object Chats : Destinations {
        override val route = "chats"
    }
}

