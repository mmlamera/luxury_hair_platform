import React from 'react';
import { useNavigate } from 'react-router-dom'; // Import the useNavigate hook
import '../assets/style.css';

const Hero = () => {
    const navigate = useNavigate(); // Initialize the navigate function

    return (
        <section id="home" className="hero">
            <div className="hero-content">
                <h2>Elevate Your Style with Luxury Hair</h2>
                <p>RAW HAIR | VIETNAMESE | BRAZILIAN | PERUVIAN</p>
                <button className="product-button" onClick={() => navigate('/products')}>
                    SHOP NOW
                </button>
            </div>
        </section>
    );
};

export default Hero;
