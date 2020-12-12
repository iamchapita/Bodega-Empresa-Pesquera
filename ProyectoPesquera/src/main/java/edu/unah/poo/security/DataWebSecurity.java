package edu.unah.poo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DataWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT usuario, contrasenia, 1 activo FROM Empleado where usuario = ?")
				.authoritiesByUsernameQuery("select usuario, puesto from Empleado where usuario = ?");
		
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	
	// Los recursos estáticos no requieren autenticación
	.antMatchers("/images/**").permitAll()
	// Las vistas públicas no requieren autenticación
	.antMatchers("/encriptar/**").permitAll()
	//.antMatchers("/**").not().hasAnyAuthority("N/A")
	// Asignar permisos a URLs por ROLES
	//.antMatchers("/facturacion/**").hasAnyAuthority("Vendedor")
	//.antMatchers("/Producto/crearProducto").hasAnyAuthority("Supervisor")
	
	// Todas las demás URLs de la Aplicación requieren autenticación
	.anyRequest().authenticated()
	
	// El formulario de Login no requiere autenticacion
	.and().formLogin().permitAll();


	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
}
