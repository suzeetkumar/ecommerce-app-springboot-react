import React from 'react';
import { Link } from "react-router-dom";

const HomeLanding = () => {
    return (
        <main style={styles.container}>
            <section style={styles.hero}>
                <h1 style={styles.title}>Welcome to ShopEase</h1>
                <p style={styles.subtitle}>
                    Discover the best deals on your favorite products. Shop smart, shop easy!
                </p>
                <Link to="/showproduct" style={styles.ctaButton}>Start Shopping</Link>
                         </section>
            <section style={styles.features}>
                <div style={styles.featureCard}>
                    <img src="https://img.icons8.com/ios-filled/50/000000/shopping-cart.png" alt="Wide Selection" style={styles.icon} />
                    <h3>Wide Selection</h3>
                    <p>Thousands of products from top brands at unbeatable prices.</p>
                </div>
                <div style={styles.featureCard}>
                    <img src="https://img.icons8.com/ios-filled/50/000000/delivery.png" alt="Fast Delivery" style={styles.icon} />
                    <h3>Fast Delivery</h3>
                    <p>Get your orders delivered to your doorstep quickly and safely.</p>
                </div>
                <div style={styles.featureCard}>
                    <img src="https://img.icons8.com/ios-filled/50/000000/lock-2.png" alt="Secure Payments" style={styles.icon} />
                    <h3>Secure Payments</h3>
                    <p>Shop with confidence using our secure payment options.</p>
                </div>
            </section>
        </main>
    );
};

const styles = {
    container: {
        fontFamily: 'Segoe UI, sans-serif',
        minHeight: '100vh',
        background: 'linear-gradient(135deg, #f8fafc 0%, #e0e7ff 100%)',
        padding: '0 0 40px 0',
    },
    hero: {
        textAlign: 'center',
        padding: '80px 20px 40px 20px',
        background: 'linear-gradient(90deg, #6366f1 0%, #818cf8 100%)',
        color: '#fff',
        borderRadius: '0 0 32px 32px',
        marginBottom: '40px',
    },
    title: {
        fontSize: '3rem',
        fontWeight: 700,
        margin: '0 0 16px 0',
        letterSpacing: '1px',
    },
    subtitle: {
        fontSize: '1.25rem',
        margin: '0 0 32px 0',
        fontWeight: 400,
    },
    ctaButton: {
        display: 'inline-block',
        padding: '14px 36px',
        background: '#fff',
        color: '#6366f1',
        borderRadius: '24px',
        fontWeight: 600,
        fontSize: '1.1rem',
        textDecoration: 'none',
        boxShadow: '0 2px 8px rgba(99,102,241,0.15)',
        transition: 'background 0.2s, color 0.2s',
    },
    features: {
        display: 'flex',
        justifyContent: 'center',
        gap: '32px',
        marginTop: '40px',
        flexWrap: 'wrap',
    },
    featureCard: {
        background: '#fff',
        borderRadius: '16px',
        boxShadow: '0 2px 12px rgba(0,0,0,0.06)',
        padding: '32px 24px',
        textAlign: 'center',
        width: '260px',
        margin: '12px 0',
    },
    icon: {
        width: '48px',
        height: '48px',
        marginBottom: '16px',
    },
};

export default HomeLanding;