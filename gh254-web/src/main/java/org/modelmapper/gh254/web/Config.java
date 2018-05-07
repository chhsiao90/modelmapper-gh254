package org.modelmapper.gh254.web;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.gh254.mod.Request;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Configuration
public class Config {
    @Bean
    @SuppressWarnings("all")
    public PropertyMap<Request, Dto> propertyMap() {
        return new PropertyMap<Request, Dto>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                using(new Converter<String, String>() {
                    @Override
                    public String convert(MappingContext<String, String> context) {
                        return Base64.getEncoder().encodeToString(context.getSource().getBytes());
                    }
                }).map().setEmailEncrypted(source.getEmail());
            }
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(propertyMap());
        return modelMapper;
    }
}
