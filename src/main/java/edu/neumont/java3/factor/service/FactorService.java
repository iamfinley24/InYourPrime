package edu.neumont.java3.factor.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;
import org.springframework.stereotype.Service;

@Service
@Path("/factor")
public class FactorService {

	@GET
	@Produces("text/plain")
	public boolean factor(){
		
		return true;
	}
	
	
	public class AuthenticationHandler implements RequestHandler {

	    public Response handleRequest(Message m, ClassResourceInfo resourceClass) {
	        AuthorizationPolicy policy = (AuthorizationPolicy)m.get(AuthorizationPolicy.class);
	        String username = policy.getUserName();
	        String password = policy.getPassword(); 
	        if (isAuthenticated(username, password)) {
	            //TODO on with the request
	            return null;
	        } else {
	            return Response.status(401).header("WWW-Authenticate", "Basic").build();
	        }
	    }

		private boolean isAuthenticated(String username, String password) {
			return ( username == "abc123" && password == "password");
		}

	}
}


/*
 * interceptor/filter
 * request handlers (cxf)
 * http filters (j2ee)
 * 
 * WHITELIST 
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
