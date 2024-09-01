import React, { useEffect, useState } from "react";
import {Link, NavLink} from "react-router-dom";
import "../assets/style.css";

const NavbarLanding = () => {
    const [cartItemsCount, setCartItemsCount] = useState(0);

    // Fetch cart items from localStorage and calculate the count
    useEffect(() => {
        const cart = localStorage.getItem("cart");
        if (cart) {
            const cartItems = JSON.parse(cart);
            const totalItems = cartItems.reduce(
                (total, item) => total + item.quantity,
                0
            );
            setCartItemsCount(totalItems);
        }
    }, []);

    return (
        <nav>
            <h1>Luxury Hair</h1>
            <ul>
                <li>
                    <NavLink to="/">Home</NavLink>
                </li>
                <li><Link to="/login">Login</Link></li>
            </ul>
        </nav>
    );
};

export default NavbarLanding;
