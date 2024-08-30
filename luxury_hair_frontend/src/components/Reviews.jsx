import React, { useState } from 'react';
import "../assets/style.css";
import '../assets/Reviews.css';

const initialReviews = [
    {
        id: 1,
        name: 'Grace',
        rating: 5,
        date: 'August 26, 2024',
        text: 'I absolutely love this product! It exceeded my expectations in every way. The quality is fantastic, and it’s worth every penny. Highly recommend!',
        image: null,
    },
   
];

const Reviews = () => {
    const [name, setName] = useState('');
    const [rating, setRating] = useState(5);
    const [reviewText, setReviewText] = useState('');
    const [image, setImage] = useState(null);
    const [reviews, setReviews] = useState(initialReviews);
   


    const handleImageChange = (e) => {
        if (e.target.files[0]) {
            setImage(URL.createObjectURL(e.target.files[0]));
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const newReview = {
            id: reviews.length + 1,
            name,
            rating,
            date: new Date().toLocaleDateString(),
            text: reviewText,
            image,
        };
        

    setReviews([...reviews, newReview]);
        setName('');
        setRating(5);
        setReviewText('');
        setImage(null);
    };

    return (
        <div className="reviews">
            <header className="header">
                <h1>Product Review</h1>
            </header>
            <main className="main-content">
                <section className="review-form-section">
                    <h2>Leave Us a Review</h2>
                    <form onSubmit={handleSubmit} className="review-form">
                        <div className="form-group">
                            <label htmlFor="name">Name:</label>
                            <input
                                id="name"
                                type="text"
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                                placeholder="Your Name"
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="rating">Rate Our Services:</label>
                            <select
                                id="rating"
                                value={rating}
                                onChange={(e) => setRating(Number(e.target.value))}
                                required
                            >
                                {[1, 2, 3, 4, 5].map(num => (
                                    <option key={num} value={num}>
                                        {'★'.repeat(num) + '☆'.repeat(5 - num)} ({num}/5)
                                    </option>
                                ))}
                            </select>
                        </div>
                        <div className="form-group">
                            <label htmlFor="reviewText">Review:</label>
                            <textarea
                                id="reviewText"
                                value={reviewText}
                                onChange={(e) => setReviewText(e.target.value)}
                                placeholder="Write your review here..."
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="imageUpload">Upload an Image:</label>
                            <input
                                id="imageUpload"
                                type="file"
                                accept="image/*"
                                onChange={handleImageChange}
                            />
                            {image && <img src={image} alt="Preview" className="image-preview" />}
                        </div>
                        <button type="submit">Submit Review</button>
                    </form>
                </section>
                <section className="existing-reviews-section">
                    <h2>Existing Reviews</h2>
                    {reviews.length > 0 ? (
                        reviews.map((review) => (
                            <div key={review.id} className="review-card">
                                <div className="review-header">
                                    <h3>{review.name}</h3>
                                    <div className="review-rating">
                                        {'★'.repeat(review.rating) + '☆'.repeat(5 - review.rating)} ({review.rating}/5)
                                    </div>
                                    <span className="review-date">{review.date}</span>
                                </div>
                                <p>{review.text}</p>
                                {review.image && <img src={review.image} alt="Product" className="review-image" />}
                               
                            </div>
                        ))
                    ) : (
                        <p>No reviews yet.</p>
                    )}
                </section>
            </main>
        </div>
    );
};

export default Reviews;
