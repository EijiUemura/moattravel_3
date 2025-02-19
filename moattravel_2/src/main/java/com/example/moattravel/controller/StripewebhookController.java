package com.example.moattravel.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.moattravel.service.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.net.Webhook;


@Controller

public class StripewebhookController {
	
	private final StripeService stripeService;
	
	@Value("${stripe.api-key}")
	private String stripeApiKey;
	
	@Value ("${stripe.webhook-secret}")
	private String webhookSecret;
	
	public StripewebhookController(StripeService stripeService) {
		this.stripeService = stripeService;
	}
	
	@PostMapping("/stripe/webhook")
	public ResponseEntity<String> webhook(@RequestBody String payload,@RequestHeader("Stripe-signature") String singHeader) {
		Stripe.apiKey = stripeApiKey;
		Event event = null;
		
		try {
			event = Webhook.constructEvent(payload, singHeader, webhookSecret);
		} catch (SignatureVerificationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		if("checkout.session.completed".equals(event.getType())) {
			stripeService.processSessionCompleted(event);
		}
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}

}
