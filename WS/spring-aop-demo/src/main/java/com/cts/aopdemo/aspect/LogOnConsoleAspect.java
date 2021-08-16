package com.cts.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogOnConsoleAspect {
	
	@Pointcut("execution(* com.cts.aopdemo.service.GreetServiceImpl.greet(..))")
	public void pc1() {}

	@Before("pc1()")
	public void logTheMethodCall(JoinPoint jp) {
		System.out.println("About to exeucvte the method " +jp.getSignature());
	}
	
	@After("pc1()")
	public void logTheMethodCallCompletion(JoinPoint jp) {
		System.out.println("Competled execution of the method " +jp.getSignature());
	}
}
