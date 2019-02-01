package com.tcs.rbc.appium.poc.automation.report;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
 
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
 
public class AnnotationTransformer implements IAnnotationTransformer {
 
    
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryHandler.class);
    }
}
