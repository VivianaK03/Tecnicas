package co.edu.usbcali.LatamKG.configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguracion {
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}
