package com.harikrish.fitzy.ui.screens.components.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.AllIcons
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.AddressCard
import compose.icons.fontawesomeicons.solid.Heart
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.ShoppingCart

sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {

    data object Home: BottomNavItem("home", "Home", FontAwesomeIcons.Solid.Home)
    data object Cart: BottomNavItem("cart", "Cart", FontAwesomeIcons.Solid.ShoppingCart)
    data object Wishlist: BottomNavItem("wishlist", "Wish List", FontAwesomeIcons.Solid.Heart)
    data object Profile: BottomNavItem("profile", "Account", FontAwesomeIcons.Solid.AddressCard)
}
