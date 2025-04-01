package it.petraccino.hrpayroll.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class HrWorkerInstanceSupplier {

    @Value("#{'${hr-worker.instances}'.split(',')}")
    private List<String> instances;

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier() {
        List<ServiceInstance> serviceInstances = instances.stream()
                .map(url -> new CustomServiceInstance("hr-worker", URI.create(url)))
                .collect(Collectors.toList());

        return new ServiceInstanceListSupplier() {
            @Override
            public String getServiceId() {
                return "hr-worker";
            }

            @Override
            public Flux<List<ServiceInstance>> get() {
                return Flux.just(serviceInstances);
            }
        };
    }

    @Data
    @AllArgsConstructor
    static class CustomServiceInstance implements ServiceInstance {
        private final String serviceId;
        private final URI uri;

        @Override
        public String getInstanceId() {
            return ServiceInstance.super.getInstanceId();
        }

        @Override
        public String getServiceId() {
            return serviceId;
        }

        @Override
        public String getHost() {
            return uri.getHost();
        }

        @Override
        public int getPort() {
            return uri.getPort();
        }

        @Override
        public boolean isSecure() {
            return false;
        }

        @Override
        public URI getUri() {
            return uri;
        }

        @Override
        public String getScheme() {
            return uri.getScheme();
        }

        @Override
        public Map<String, String> getMetadata() {
            return Map.of();
        }
    }
}