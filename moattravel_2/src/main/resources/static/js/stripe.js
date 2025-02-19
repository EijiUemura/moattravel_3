const stripe = Stripe('pk_test_51Qm87xD7bdLx83uCLhRHjXe47afHs6zN1U2eTPWlvAfY9umefwFJx3PV5tWDUqn4qHjFeKgHgvYIOUez8T1RRfzw00jOf9p5tQ');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
	stripe.redirectToCheckout({
		sessionId: sessionId
	})
})