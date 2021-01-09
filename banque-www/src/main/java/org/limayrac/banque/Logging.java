package org.limayrac.banque;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {
	
	private static final Logger logger = LoggerFactory.getLogger(Logging.class);

	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		Object[] args = joinPoint.getArgs();
		
		StringBuilder builder = new StringBuilder();
		builder.append("Methode ");
		builder.append(methodName);
		builder.append(" invoquée avec les paramètres : ");
		for (Object o : args) {
			builder.append(o);
			builder.append(" - ");
		}
		logger.trace(builder.toString());
	}
	
	public void afterMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.trace("Methode "+ methodName + " a produit le resultat " + result);
	}
}

