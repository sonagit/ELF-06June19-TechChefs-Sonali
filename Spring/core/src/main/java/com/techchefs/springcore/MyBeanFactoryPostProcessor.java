package com.techchefs.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException{
		System.out.println("MyBeanFactoryPostProcessor before init");
	}
}
