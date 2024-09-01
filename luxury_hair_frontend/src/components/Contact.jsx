import React, { useState } from "react";
import "../assets/style.css";

const Subscribe = () => {
  const [email, setEmail] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Prepare the data to be sent to the server
    const data = {
      email: email,
    };

    try {
      // Check if the email already exists
      const emailExistsResponse = await fetch(
          `http://localhost:8080/LuxuryHairVendingSystemDB/newsletter/email-exists?email=${email}`
      );

      if (emailExistsResponse.ok) {
        const emailExistsData = await emailExistsResponse.json();
        if (emailExistsData.exists) {
          alert("This email is already subscribed.");
          return; // Stop further execution if email exists
        }
      } else {
        alert("There was an error checking the email. Please try again.");
        return; // Stop further execution if the email existence check fails
      }

      // Send POST request to the server to create the subscription
      const response = await fetch(
          "http://localhost:8080/LuxuryHairVendingSystemDB/newsletter/create",
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
          }
      );

      // Handle the response
      if (response.ok) {
        alert("Thank you for subscribing!");
        setEmail(""); // Clear the input field after successful submission
      } else {
        alert("There was an error. Please try again.");
      }
    } catch (error) {
      console.error("Error:", error);
      alert("There was a problem connecting to the server.");
    }
  };

  return (
      <section id="subscribe" className="subscribe-section">
        <div className="subscribe-container">
          <h2>Subscribe to our emails</h2>
          <p>
            Be the first to know about new collections and exclusive discounts.
          </p>
          <form className="subscribe-form" onSubmit={handleSubmit}>
            <input
                type="email"
                placeholder="Email"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
            <button type="submit" className="subscribe-btn">
              →
            </button>
          </form>
        </div>
      </section>
  );
};

export default Subscribe;
