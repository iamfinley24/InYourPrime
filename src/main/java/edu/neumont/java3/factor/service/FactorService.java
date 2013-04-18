package edu.neumont.java3.factor.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

@Service
@Path("/factor")
@Produces("text/plain")
public class FactorService {

	@GET
	public boolean factor(){
		
		return true;
	}
}


/*
 * interceptor/filter
 * request handlers (cxf)
 * http filters (j2ee)
 * 
 * webinf filter
 * request response and chain
 * chain.dochain or something like that
 * 
 * 
 * response www-authenticate:basic
 * 
 *  client
 *  jax-rs makes it easy on server side
 *  
 */
