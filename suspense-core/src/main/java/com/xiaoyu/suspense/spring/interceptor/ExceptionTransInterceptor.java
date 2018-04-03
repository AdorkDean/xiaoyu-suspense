package com.xiaoyu.suspense.spring.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoyu.suspense.exception.BasicException;
import com.xiaoyu.suspense.exception.BasicRuntimeException;
import com.xiaoyu.suspense.exception.ExceptionFactory;

/**
 * 异常统一转换
 */
public class ExceptionTransInterceptor implements MethodInterceptor {

	Logger logger = LoggerFactory.getLogger("SPRING_LOGGER");

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		try {
			return invocation.proceed();

		} catch (BasicRuntimeException e) {
			throw e;
		}catch (BasicException e) {
			throw e;
		}
		catch (Exception e) {
			logger.error("unknow exception",e);
			throw ExceptionFactory.createSysException("系统错误");
		}
	}

}
