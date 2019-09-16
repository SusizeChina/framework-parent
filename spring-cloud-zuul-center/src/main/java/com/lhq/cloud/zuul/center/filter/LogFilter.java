package com.lhq.cloud.zuul.center.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.lhq.cloud.core.log.LogConstants;
import com.lhq.cloud.core.log.TraceLogUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： <br>
 * pre：路由之前 <br>
 * routing：路由之时 <br>
 * post： 路由之后 <br>
 * error：发送错误调用 <br>
 * filterOrder：过滤的顺序 <br>
 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。 <br>
 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 * 
 * @author lihuiquan
 *
 */
@Component
public class LogFilter {

	private static Logger log = LoggerFactory.getLogger(LogFilter.class);
	
	@Component
	public class LogPreFilter extends ZuulFilter {

		@Override
		public boolean shouldFilter() {
			return true;
		}

		@Override
		public Object run() throws ZuulException {
			RequestContext ctx = RequestContext.getCurrentContext();
			String traceId = ctx.getRequest().getHeader(LogConstants.HTTP_HEADER_TRACE_ID);
			log.info("traceId1" + traceId);
			if (StringUtils.isEmpty(traceId)) {
				traceId = TraceLogUtils.getTraceId();
				MDC.put(LogConstants.LOG_TRACE_ID, traceId);
				ctx.addZuulRequestHeader(LogConstants.HTTP_HEADER_TRACE_ID, traceId);
				log.info("traceId2" + traceId);
			}
			log.info("traceId3" + traceId);
			return null;
		}

		@Override
		public String filterType() {
			return "pre";
		}

		@Override
		public int filterOrder() {
			return 0;
		}

	}

	@Component
	public class LogPostFilter extends ZuulFilter {

		@Override
		public boolean shouldFilter() {
			return true;
		}

		@Override
		public Object run() throws ZuulException {
			MDC.remove(LogConstants.LOG_TRACE_ID);
			return null;
		}

		@Override
		public String filterType() {
			return "post";
		}

		@Override
		public int filterOrder() {
			return 0;
		}

	}

}
