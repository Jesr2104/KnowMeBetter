package com.just_jump.knowmebetter.ui.navigation

sealed class NavItem(val route: String) {
    //----------------------------------------------------------------------
    // list of routes
    //----------------------------------------------------------------------
    //Screen #1
    object SplashScreen : NavItem("splashScreen")

    //Screen #2
    object SelectCategory : NavItem("selectCategory")

    //Screen #3
    object ShowQuestion : NavItem("showQuestion")
}