package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.appointments.AppointmentCancelData;
import med.voll.api.domain.appointments.AppointmentScheduleService;
import med.voll.api.domain.appointments.DetailedAppointmentData;
import med.voll.api.domain.appointments.ScheduleAppointmentData;
import med.voll.api.domain.user.AutenticationData;
import med.voll.api.domain.user.User;
import med.voll.api.infra.ValidateException;
import med.voll.api.infra.security.TokenJWTData;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentScheduleService service;

    @PostMapping
    @Transactional
    public ResponseEntity schedule(@RequestBody @Valid ScheduleAppointmentData data) throws ValidateException {
        DetailedAppointmentData appointmentData = service.schedule(data);
        return ResponseEntity.ok(appointmentData);
    }

    @PutMapping
    @Transactional
    public ResponseEntity cancel(@RequestBody @Valid AppointmentCancelData data){
        service.cancel(data);
        return ResponseEntity.ok().build();
    }
}
