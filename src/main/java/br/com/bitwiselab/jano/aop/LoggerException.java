package br.com.bitwiselab.jano.aop;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class LoggerException implements ThrowsAdvice {
	private static Logger logger = Logger.getLogger(LoggerException.class);

	protected boolean deveSerLogada(Throwable throwable) {
		return (throwable instanceof RuntimeException);
	}

	public void afterThrowing(Throwable throwable) {
		// if (deveSerLogada(throwable)) {
		logger.error("Exceção (AOP)", throwable);
		// }
	}
}
