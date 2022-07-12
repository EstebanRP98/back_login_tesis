package com.marcos.cuadros.security;
import com.marcos.cuadros.model.entity.UserEntity;
import com.marcos.cuadros.repository.UserRepository;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Optional;

@Component
public class AnpiInterceptor implements HandlerInterceptor {

    @Autowired
    UserRepository userRepository;

    /**
     * Executed before actual handler is executed
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        try {
//            String ipIngreso = Optional.ofNullable(request.getHeader("x-real-ip")).orElse(request.getRemoteAddr());
//            System.out.println("IP INTERCEPTOR:"+ipIngreso);
//
//            //se hace esta validacion para que se pueda ingresar al swagger por ip
//            if(request.getHeader("Authorization")==null) {
//                String ip = Optional.ofNullable(request.getHeader("x-real-ip")).orElse(request.getRemoteAddr());
//                RequestContextHolder.getRequestAttributes().setAttribute("ip", ip,
//                        RequestAttributes.SCOPE_REQUEST);
//                return true;
//            }

            String email = SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal().toString();

            UserEntity user = userRepository.findByEmail(email);
            if(email.equals("anonymousUser")) {
                return true;
            }else {
                Date limitDate = user.getLimitDate();
                if (limitDate.before(new Date())) {
                    throw new RuntimeException("Error: Falta de Pago");
                }
            }


            return true;
        } catch (Exception e) {
            response.getWriter().write(e.getMessage());
            response.setStatus(401);
            return false;
        }
    }


}
