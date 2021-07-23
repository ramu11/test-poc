package ch.medidata.demo.client;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import org.apache.cxf.jaxrs.client.cache.CacheControlFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheControlFeatureWrapper implements DynamicFeature {

   private static final Logger LOGGER = LoggerFactory.getLogger(CacheControlFeatureWrapper.class);
   private final CacheControlFeature cacheControlFeature;

   public CacheControlFeatureWrapper() {
      this.cacheControlFeature = new CacheControlFeature();
   }

   public void configure(final ResourceInfo resourceInfo, final FeatureContext context) {
      LOGGER.info("fcd0e875 enabling cache control feature");
      
      System.out.println("CacheControlFeatureWrapper");
      cacheControlFeature.configure(context);
   }

}
