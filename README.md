# Spring
Study_Spring

# web.xml 한글 인코딩 방법

	<filter> 
	    <filter-name>encodingFilter</filter-name> 
	    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class> 
	    <init-param> 
	       <param-name>encoding</param-name> 
	       <param-value>UTF-8</param-value> 
	    </init-param> 
	    <init-param> 
	       <param-name>forceEncoding</param-name> 
	       <param-value>true</param-value> 
	    </init-param> 
	 </filter> 
	 <filter-mapping> 
	    <filter-name>encodingFilter</filter-name> 
	    <url-pattern>/*</url-pattern> 
	 </filter-mapping> 
